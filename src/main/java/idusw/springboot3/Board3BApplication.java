package idusw.springboot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  //(exclude = DataSourceAutoConfiguration.class)
public class Board3BApplication {

    public static void main(String[] args) {
        SpringApplication.run(Board3BApplication.class, args);
    }

}
