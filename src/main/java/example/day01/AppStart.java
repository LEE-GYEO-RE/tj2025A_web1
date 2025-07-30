package example.day01;

import example.day01.controller.BoardController;
import example.day01.model.dto.BoardDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication

public class AppStart {
    public static void main(String[] args) {

        System.out.println("자바 실행");
        // BoardService 10 : view 제외한 동일한 구조
        // Gradle 환경 아닐때는 jar 라이브러리 등록
        // Gradle 환경 : build.gradle 파일내 'runtimeOnly 'com.mysql:mysql-connector-j' 코드 필요
        // 저 코드가 알아서 라이브러리 추가 됨

        // view 없을 때 dao , controller 기능 확인 테스트
        boolean result = BoardController.getInstance().boardWrite("테스트내용" , "ㅎㅇㅎㅇ");
        System.out.println(result);

        // 전체 조회 기능 테스트
        ArrayList<BoardDto> result1 = BoardController.getInstance().boardPrint();
        System.out.println(result1);

        // * Spring 환경 실행
        // SpringApplication.run( 현재클래스명.class );
        SpringApplication.run( AppStart.class );

    } // main e
} // class e
