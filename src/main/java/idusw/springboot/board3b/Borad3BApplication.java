package idusw.springboot.board3b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //(exclude = DataSourceAutoConfiguration.class)
public class Borad3BApplication {

    public static void main(String[] args) {
        SpringApplication.run(Borad3BApplication.class, args);
    }

}
