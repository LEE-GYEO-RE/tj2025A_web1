package example.day07;

// 롬복 : 설계에서 자주 사용되는 코드를 자동 생성
// 롬복 설치
// 1) 인텔리제이 설치 (환경) 설정 플러그인에서 lombok 검색해서 설치

// 2) 그레이들 설치   (프로젝트)
// https://start.spring.io/ 홈페이지에서 오른쪽 상단 add dependencies 에서 lombok 검색
// compileOnly 'org.projectlombok:lombok'  // lombok 설치
// annotationProcessor 'org.projectlombok:lombok'  // lombok 설치

import lombok.*;

@NoArgsConstructor // 빈 생성자 *(컴파일시/실행) 자동 생성
@AllArgsConstructor // 전체 생성자 *(컴파일시/실행) 자동 생성
@Getter // 모든 멤버변수에 대해서 getter 메소드 *(컴파일시/실행) 자동생성
@Setter // 모든 멤버변수에 대해서 setter 메소드 *(컴파일시/실행) 자동생성
@ToString // 객체 조회시 주소값 대신에 모든 멤버변수를 문자열 출력 메소드 *(컴파일시/실행) 자동생성
public class StudentDto {
    // 멤버변수
    private int sno;        // 번호
    private String sname;   // 이름
    private int skor;       // 국어점수
    private int smath;      // 수학점수
    private String sdate;   // 등록일

    // 빈 생성자 , 풀(모든 매개변수) 생성자

    // getter , setter , toString


} // class e
