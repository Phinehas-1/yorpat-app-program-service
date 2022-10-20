package dev.bigdecimal.yorpat.api.programservice;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProgramServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgramServiceApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.driverClassName(System.getenv("DATABASE_DRIVER_CLASS"))
				.url(System.getenv("DATABASE_URL"))
				.username(System.getenv("DATABASE_USER"))
				.password(System.getenv("DATABASE_PASSWORD"))
				.build();
	}
}
