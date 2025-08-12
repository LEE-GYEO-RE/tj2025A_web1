package example.day03;

// AppStart : 스프링 실행과 동시에 같은 패키지/하위패키지 내 모든 컴포넌트 스캔 자동 bean(객체) 등록

import org.springframework.web.bind.annotation.*;

import java.util.Map;

// @Controller // 스프링에게 해당 클래스는 Controller 라는 걸 알리는 것.
// 어노테이션이란 ? 라벨/스티커 느낌.
// 스프링 왜씀 ? : 협업할 때 , 규칙과 패턴을 지켜서 빠른 작업 위해 ('유리 취급 주의'라는 라벨이 붙으면 , 유리 물품을 처리할때 주의할 수 있음)
// + HTTP(웹통신) 지원 + @Component 포함 (@SpringBootApplication) 가 스캔하는 대상 )
@RestController // @Controller( +Component ) + @ResponseBody
public class RestController1 {
    // 싱글톤 생략 : @Component 사용했기 때문에

    @GetMapping("/day03") // HTTP(웹 통신 규약) 중에서 'GET' METHOD를 사용 , URL은 사용자가 경로 정의 , baseUrl 뒤로 자원 URL 정의
    // ("/day03")--------> url : http://localhost:8080/day03
    // Whitelabel Error Page : 요청은 정상이지만 , 응답이 없다.
    // *Talend API : 브라우저(주소입력창) 에서 HTTP 웹주소 입력은 GET 방식만 지원. 그래서 프론트 없는 백앤드 담당은 Talend 에서 crud 기능 확인위해 씀.
    // 그래서 고객들은 GET 방식으로만 브라우저를 접한다.
    // 로그인은 POST 방식임.
    // @ResponseBody // HTTP 요청에 따른 처리 후 응답을 자바 타입에서 HTTP 타이브로 *자동변환* 주로 JSON(자바스크립트객체)
    // 요청은 매개변수 , 응답은 리턴
    // --> 현재 Controller 가 @RestController
    public String method1() {
        return "나는 자바에서 보내온 메시지.";
    }

    // +++++++++++ 매개변수 +++++++++++
    // 메소드에서 매개변수란? 메소드 호출시 메소드 안으로 들어오는 값을 저장하는 변수
    // + HTTP 요청시에도 인자값/자원 보낼 수 있다.
    // ++ 자바 메소드 인자값 전달 방식 : method2 (유재석);
    // ++ HTTP 메소드 인자값 전달 방식 : http://localhost:8080/day03/param1?매개변수명=값
    // +++ 쿼리스트링이란 ? URL(주소) 뒤에 ? 붙이고 자원(데이터) 이동/전달/표현 할때 사용하는 문법
    // ++++ URL?매개변수명=값&매개변수명2=값2&매개변수명3=값3     ( 주의할점 : 문자만 가능 )
    @GetMapping("/day03/param1")
    public boolean method2(@RequestParam(name = "name", defaultValue = "홍길동", required = true) String name) {
        // @RequestParam : Request(요청) + Param(매개변수) == 요청매개변수 매핑 어노테이션
        // + @RequestParam( name = "URL매개변수명" , defaultValue = "초기값" , required = true/false );
        // ++ name = "URL매개변수명" : 주소(URL) 상의 ? 뒤로 매핑(연결)할 매개변수명 명시 , 단 자바 매개변수와 이름이 동일 시 생략가능
        // 예] http://localhost:8080/day03/param1?name=유재석 ----> String name 이면 생략 가능
        // 예] http://localhost:8080/day03/param1?name=유재석 ----> @RequestParam( name = "name" ) String nickName
        // ++  defaultValue = "홍길동" : 만약에 매개변수명에 값이 생략되면 자동으로 들어가는 값
        // 예] http://localhost:8080/day03/param1 ----> name = 매개변수가 생략됐으면 기본값 들어옴 -> name = 홍길동
        // ++ required : 만약에 해당 매개변수가 없으면 자동으로 예외 발생 시켜줌
        // 안쓸 때 예]  HTTP 400 ERROR(잘못된 요청 뜻) ----> 유효성 검사
        System.out.println("RestController1.method2");  // soutm : 현재 메소드명 출력
        System.out.println("name = " + name);           // soutp : 현재 메소드 매개변수 출력
        return true;
    }

    @GetMapping("/day03/param2")
    // http://localhost:8080/day03/param2?name=강호동&age=20
    public int method3(@RequestParam(required = true) String name,
                       @RequestParam(name = "age") int 나이) {   // 자동타입 변환****
        // 통신 확인 방법
        System.out.println("RestController1.method3");
        System.out.println("name = " + name + ", age = " + 나이);

        return 3; // 임의 값 반환
    }

    @DeleteMapping("/day03/param3")
    public String method4(@RequestParam Map<String, String> map) {
        // 일반적으로 정해진 규칙이나 매개변수명이 아닌 단순 MAP(비규칙) 구조일 경우 @RequestParam 사용해야한다.
        System.out.println("RestController1.method4");
        // MAP : KEY와 VALUE 를 한쌍(ENTRY) 구성하여 여러개 ENTRY 저장 구조
        System.out.println("map = " + map);
        return "안녕";
    }

    @DeleteMapping("/day03/param4")
    // ++ DTO 에 자동 매핑 하기 위해서는 DTO 에도 name 과 age 멤버변수가 존재 해야한다. +생성자 +setter/getter
    public int method5(TaskDto taskDto) {
        // @RequestParam : DTO 내 동일한 멤버변수와 생성자가 구성된 상태일때
        // new TaskDto() 생략해도 자동으로 만들어준다.
        System.out.println("RestController1.method5");
        System.out.println("taskDto = " + taskDto);
        // taskDto = TaskDto{name='유재석', age=40}
        return 3;
    }

    /*
    * 1) 쿼리스트링이란 ?  :  URL 경로상의 매개변수 표현 , 매개변수 노출o , 보안 위험 , URL?매개변수=값&매개변수=값
    * 2) body(본문)이란?  :  HTTP 본문에 매개변수 표현 , 매개변수 노출x ,  보안 안전 , POST/PUT 에서 JSON타입으로 객체 지원
    * +++ HTTPS          : 암호화되어 , 안전하게 데이터 주고받기

                      @RequestParam                          vs          @ModelAttribute                                        VS   @RequestBody
     역할              단일 파라미터에 변수 바인딩                           복수 파라미터에 객체 바인딩                                     본문(body) 객체 바인딩
     생략기준           변수명이 일치할 경우(쿼리스트링의 매개변수)             DTO 타입일때 기본적용(+생성자 , +Setter )                      DTO
     주요타입           기본형: int/String/List/Map                        DTO/VO(개발자가만든객체) *VO(읽기모드 = setter 없음)             DTO
     처리가능요청       쿼리스트링,<form:첨부파일x>                          쿼리스트링,<form:첨부파일o>                                    본문(body)
     HTTP메소드        GET/POST/PUT/DELET                                 GET/POST/PUT/DELET                                          POST/PUT

     -----------> 개인정보는 @RequestBody , url 들어가면 안됨.
     -----------> 일반정보 조회는 @RequestParam 나 @ModelAttribute 씀.


    */

    @PostMapping("/day03/param5")
    // Talend API : [Method] Post , [Scheme] baseURL/day03/param5
    // [HEADERS] JSON [BODY] { "name" : "유재석" , "age" : "40" }
    // --------> Post 방식으로 URL 주소로 부가정보에 JSON 보내는 것 BODY 객체를
    public boolean method6(@RequestBody TaskDto taskDto) {
        System.out.println("RestController1.method6");
        System.out.println("taskDto = " + taskDto);
        // taskDto = TaskDto{name='유재석', age=40}
        return true;
    }

    @PutMapping("/day03/param6")
    public int method7(@RequestBody Map<String, String> map) {
        System.out.println("RestController1.method7");
        System.out.println("map = " + map);
        // @RequestBody 쓰면 : map = {name=유재석, age=40}
        // @RequestBody 안쓰면 : map = {}
        return 3;
    }


} // class e


















