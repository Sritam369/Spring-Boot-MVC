'use strict';

var usernamePage =
    document.querySelector('#username-page');

var chatPage =
    document.querySelector('#chat-page');

var usernameForm =
    document.querySelector('#usernameForm');

var messageForm =
    document.querySelector('#messageForm');

var messageInput =
    document.querySelector('#message');

var messageArea =
    document.querySelector('#messageArea');

var connectingElement =
    document.querySelector('.connecting');

var stompClient = null;

var colors = [
    '#2196F3',
    '#32c787',
    '#00BCD4',
    '#ff5652',
    '#ffc107',
    '#ff85af',
    '#FF9800',
    '#39bbb0'
];

/*
 * REGISTER
 */
async function registerUser() {

    const username =
        document.querySelector('#username')
            .value.trim();

    const password =
        document.querySelector('#password')
            .value.trim();

    if (!username || !password) {

        alert(
            "Please enter username and password"
        );

        return;
    }

    try {

        const response =
            await fetch(
                '/api/auth/register',
                {
                    method: 'POST',
                    headers: {
                        'Content-Type':
                            'application/json'
                    },
                    body: JSON.stringify({
                        username: username,
                        password: password
                    })
                }
            );

        if (!response.ok) {

            throw new Error(
                "Registration Failed"
            );
        }

        alert(
            "Registration Successful! Please Login."
        );

    } catch (error) {

        console.error(error);

        alert(
            "Registration Failed"
        );
    }
}

/*
 * LOGIN
 */
async function connect(event) {

    event.preventDefault();

    const username =
        document.querySelector('#username')
            .value.trim();

    const password =
        document.querySelector('#password')
            .value.trim();

    if (!username || !password) {

        alert(
            "Please enter username and password"
        );

        return;
    }

    try {

        const response =
            await fetch(
                '/api/auth/login',
                {
                    method: 'POST',
                    headers: {
                        'Content-Type':
                            'application/json'
                    },
                    body: JSON.stringify({
                        username: username,
                        password: password
                    })
                }
            );

        if (!response.ok) {

            throw new Error(
                "Login Failed"
            );
        }

        const data =
            await response.json();

        localStorage.setItem(
            "token",
            data.token
        );

        window.chatUsername =
            username;

        usernamePage.classList.add(
            'hidden'
        );

        chatPage.classList.remove(
            'hidden'
        );

        const socket =
            new SockJS('/ws');

        stompClient =
            Stomp.over(socket);

        stompClient.connect(
            {
                Authorization:
                    "Bearer " +
                    localStorage.getItem(
                        "token"
                    )
            },
            onConnected,
            onError
        );

    } catch (error) {

        console.error(error);

        alert(
            "Invalid username or password"
        );
    }
}

/*
 * WEBSOCKET CONNECTED
 */
function onConnected() {

    stompClient.subscribe(
        '/topic/public',
        onMessageReceived
    );

    stompClient.send(
        "/app/chat.addUser",
        {},
        JSON.stringify({
            sender:
                window.chatUsername,
            type: 'JOIN'
        })
    );

    connectingElement.classList.add(
        'hidden'
    );

    console.log(
        "WebSocket Connected"
    );
}

/*
 * WEBSOCKET ERROR
 */
function onError(error) {

    console.error(error);

    connectingElement.textContent =
        'Could not connect to WebSocket server.';

    connectingElement.style.color =
        'red';
}

/*
 * SEND MESSAGE
 */
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
            "/app/chat.sendMessage",
            {},
            JSON.stringify(
                chatMessage
            )
        );

        messageInput.value = '';
    }
}

/*
 * RECEIVE MESSAGE
 */
function onMessageReceived(payload) {

    const message =
        JSON.parse(payload.body);

    const messageElement =
        document.createElement('li');

    if (
        message.type === 'JOIN'
    ) {

        messageElement.classList.add(
            'event-message'
        );

        message.content =
            message.sender +
            " joined!";

    } else if (
        message.type === 'LEAVE'
    ) {

        messageElement.classList.add(
            'event-message'
        );

        message.content =
            message.sender +
            " left!";

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

        avatarElement.style[
            'background-color'
        ] =
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

/*
 * AVATAR COLOR
 */
function getAvatarColor(
    messageSender
) {

    let hash = 0;

    for (
        let i = 0;
        i < messageSender.length;
        i++
    ) {

        hash =
            31 * hash +
            messageSender.charCodeAt(i);
    }

    return colors[
        Math.abs(
            hash %
            colors.length
        )
    ];
}

/*
 * EVENTS
 */
document
    .querySelector('#registerBtn')
    .addEventListener(
        'click',
        registerUser
    );

usernameForm.addEventListener(
    'submit',
    connect,
    true
);

messageForm.addEventListener(
    'submit',
    sendMessage,
    true
);