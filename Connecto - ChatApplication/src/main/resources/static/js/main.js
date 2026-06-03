
'use strict';
const usernamePage = document.querySelector('#username-page');
const chatPage = document.querySelector('#chat-page');

const usernameForm = document.querySelector('#usernameForm');
const messageForm = document.querySelector('#messageForm');

const messageInput = document.querySelector('#message');
const messageArea = document.querySelector('#messageArea');
const connectingElement = document.querySelector('.connecting');

let stompClient = null;

const colors = [
'#2196F3',
'#32c787',
'#00BCD4',
'#ff5652',
'#ffc107',
'#ff85af',
'#FF9800',
'#39bbb0'
];

/* =========================
REGISTER
========================= */

async function registerUser() {


const username =
    document.querySelector('#username').value.trim();

const password =
    document.querySelector('#password').value.trim();

if (!username || !password) {

    alert('Please enter username and password');
    return;
}

try {

    const response =
        await fetch('/api/auth/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username,
                password
            })
        });

    const result =
        await response.text();

    if (!response.ok) {

        alert(result);
        return;
    }

    alert('Registration Successful');

} catch (error) {

    console.error(error);

    alert('Registration Failed');
}


}

/* =========================
LOGIN
========================= */

async function connect(event) {


event.preventDefault();

const username =
    document.querySelector('#username').value.trim();

const password =
    document.querySelector('#password').value.trim();

if (!username || !password) {

    alert('Please enter username and password');
    return;
}

try {

    const response =
        await fetch('/api/auth/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username,
                password
            })
        });

    if (!response.ok) {

        alert('Invalid Username or Password');
        return;
    }

    const data =
        await response.json();

    localStorage.setItem(
        'token',
        data.token
    );

    window.chatUsername =
        username;
    usernamePage.classList.add('hidden');
    chatPage.classList.remove('hidden');

    const socket =
        new SockJS('/ws');

    stompClient =
        Stomp.over(socket);

    stompClient.connect(
        {
            Authorization:
                'Bearer ' + data.token
        },
        onConnected,
        onError
    );

} catch (error) {

    console.error(error);

    alert('Login Failed');
}


}

/* =========================
CONNECTED
========================= */

function onConnected() {


stompClient.subscribe(
    '/topic/public',
    onMessageReceived
);

stompClient.send(
    '/app/chat.addUser',
    {},
    JSON.stringify({
        sender: window.chatUsername,
        type: 'JOIN'
    })
);

connectingElement.classList.add(
    'hidden'
);


}

/* =========================
ERROR
========================= */

function onError(error) {


console.error(error);

connectingElement.textContent =
    'Could not connect to WebSocket server';

connectingElement.style.color =
    'red';


}

/* =========================
SEND MESSAGE
========================= */

function sendMessage(event) {


event.preventDefault();

const messageContent =
    messageInput.value.trim();

if (
    messageContent &&
    stompClient
) {

    const chatMessage = {

        sender:
            window.chatUsername,

        content:
            messageContent,

        type:
            'CHAT'
    };

    stompClient.send(
        '/app/chat.sendMessage',
        {},
        JSON.stringify(chatMessage)
    );

    messageInput.value = '';
}


}

/* =========================
RECEIVE MESSAGE
========================= */

function onMessageReceived(payload) {

const message =
    JSON.parse(payload.body);

const messageElement =
    document.createElement('li');

if (message.type === 'JOIN') {

    messageElement.classList.add(
        'event-message'
    );

    message.content =
        message.sender + ' joined!';

} else if (
    message.type === 'LEAVE'
) {

    messageElement.classList.add(
        'event-message'
    );

    message.content =
        message.sender + ' left!';

} else {

    messageElement.classList.add(
        'chat-message'
    );

    const avatarElement =
        document.createElement('i');

    avatarElement.appendChild(
        document.createTextNode(
            message.sender[0]
        )
    );

    avatarElement.style.backgroundColor =
        getAvatarColor(
            message.sender
        );

    messageElement.appendChild(
        avatarElement
    );

    const usernameElement =
        document.createElement('span');

    usernameElement.appendChild(
        document.createTextNode(
            message.sender
        )
    );

    messageElement.appendChild(
        usernameElement
    );
}

const textElement =
    document.createElement('p');

textElement.appendChild(
    document.createTextNode(
        message.content
    )
);

messageElement.appendChild(
    textElement
);

messageArea.appendChild(
    messageElement
);

messageArea.scrollTop =
    messageArea.scrollHeight;


}

/* =========================
AVATAR COLOR
========================= */

function getAvatarColor(sender) {


let hash = 0;

for (
    let i = 0;
    i < sender.length;
    i++
) {

    hash =
        31 * hash +
        sender.charCodeAt(i);
}

return colors[
    Math.abs(
        hash %
        colors.length
    )
];


}

/* =========================
LOGOUT
========================= */

function logout() {


localStorage.removeItem(
    'token'
);

if (stompClient) {

    stompClient.disconnect();
}

window.chatUsername = null;

location.reload();


}

/* =========================
EVENTS
========================= */

window.addEventListener(
'load',
function () {


    const registerBtn =
        document.querySelector(
            '#registerBtn'
        );

    const logoutBtn =
        document.querySelector(
            '#logoutBtn'
        );

    if (registerBtn) {

        registerBtn.addEventListener(
            'click',
            registerUser
        );
    }

    if (logoutBtn) {

        logoutBtn.addEventListener(
            'click',
            logout
        );
    }

    if (usernameForm) {

        usernameForm.addEventListener(
            'submit',
            connect
        );
    }

    if (messageForm) {

        messageForm.addEventListener(
            'submit',
            sendMessage
        );
    }
}


);
