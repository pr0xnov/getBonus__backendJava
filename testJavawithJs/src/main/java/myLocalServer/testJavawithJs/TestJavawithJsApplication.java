package myLocalServer.testJavawithJs;

import myLocalServer.testJavawithJs.entity.Card;
import myLocalServer.testJavawithJs.repository.CardRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class TestJavawithJsApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestJavawithJsApplication.class, args);
	}

}
