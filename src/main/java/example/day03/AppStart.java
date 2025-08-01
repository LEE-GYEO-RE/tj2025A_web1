package example.day03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 기본 세팅 + 컴포넌트 스캔 + 내장 톰캣(서버) 실행
public class AppStart {
    public static void main(String[] args) {

        SpringApplication.run(AppStart.class);  // AppStart 매개변수로 전달

    } // main e
} // class e
