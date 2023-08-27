package com.blogger;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.blogger.constants.AppContants;
import com.blogger.utils.PrintLog;

@EntityScan("com.blogger")
@EnableJpaRepositories("com.blogger")
@SpringBootApplication
public class BloggerManagmentApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		loadSystemProperty();
		SpringApplication.run(BloggerManagmentApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BloggerManagmentApplication.class);
	}

	public static void loadSystemProperty() {
		try {
			System.setProperty(AppContants.HOSTNAME, InetAddress.getLocalHost().getHostName());
		} catch (UnknownHostException e) {
			PrintLog.logError("loadSystemProperty", e.getMessage());
			PrintLog.logError("loadSystemProperty", e.getCause().toString());
			e.printStackTrace();
		}
	}
}
