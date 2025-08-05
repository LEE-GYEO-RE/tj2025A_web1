package 종합.예제11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {


        // 직접 view 실행 x 스프링 실행 해야함
        // 스프링 실행하면 프로젝트 내 resource 폴더의 HTML/CSS/JS 프론트엔드 싹 다 등록한다.
        // 단 resources/static 폴더 안에 있어야 함.

        SpringApplication.run( AppStart.class );

    } // main e
} // class e
