package com.sri;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class BootMvcProj15InternationalizationApplication {

	@Bean(name="localeResolver") // Fixed bean name
	public SessionLocaleResolver createResolver() {
		SessionLocaleResolver s = new SessionLocaleResolver();
		s.setDefaultLocale(new Locale("en","US"));
		return s;
	}
	
	@Bean
	public LocaleChangeInterceptor createInterceptor() {
		LocaleChangeInterceptor l = new LocaleChangeInterceptor();
		l.setParamName("lang");
		return l;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj15InternationalizationApplication.class, args);
	}

}
