package 종합.예제11.controller;

import org.springframework.web.bind.annotation.*;
import 종합.예제11.model.dao.BoardDao;
import 종합.예제11.model.dto.BoardDto;

import java.util.ArrayList;

@RestController // 싱글톤 같은 기능이 포함 됨. +@Component
public class BoardController {



    // (*) boardDao 싱글톤 가져오기
    private BoardDao boardDao = BoardDao.getInstance();

    // (1) 등록 기능 구현
    @PostMapping("/board") //  http://localhost:8080/board
    // @GetMapping @PutMapping @DeleteMapping
    // 관례적으로 쿼리스트링 주로 쓰지 않는 곳의 이유 : 아이디 , 비밀번호 등의 개인정보는 노출 시키면 안되니깐
    public boolean boardWrite( @RequestBody BoardDto boardDto ){
        // 1. 여러가지 유효성검사 (패스~)
        // 2. 데이터문제 없으면 묶음(객체)하나로 만들기
        // --> 주의할점 매개변수와 동일한 생성자가 존재하지 않으면 오류 발생한다.
        // BoardDto boardDto = new BoardDto( 0 , bcontent , bwriter );

        // (2-1) dto 새로 안만들고 자동으로 할거라면 ?
        // 매개변수에 @RequestBody BoardDto boardDto 넣어주면 2번 생략 가능

        // 3. 객체화 된 dto를 dao에게 전달후 결과를 받는다.
        boolean result = boardDao.boardWrite( boardDto );
        // 4. 결과를 view에게 리턴한다.
        return result;
    } // func e


    // (2) 전체조회 기능 구현
    @GetMapping("/board")
    public ArrayList<BoardDto> boardPrint( ){
        // - 유효성검사 ~ // - 매개변수 ~
        // 3. dao에게 전달후 결과를 받는다.
        ArrayList<BoardDto> result = boardDao.boardPrint( );
        // 4. 결과를 view에게 리턴한다.
        return result;
    } // func e


    // (3) 삭제 기능 구현
    @DeleteMapping("/board")
    // @RequestParam : 쿼리스트링 사용
    // ----> 탈랜드 http에 ?(쿼리스트링) bno = ? 써야함 // 띄어쓰기는 하면 안됨
    public boolean boardDelete( @RequestParam int bno ){
        // 1.유효성검사2.객체화
        // 3. dao에게 삭제할번호 전달후 결과를 받는다.
        boolean result = boardDao.boardDelete( bno );
        // 4. 결과를 view에게 리턴한다.
        return result;
    } // func e


    // (4) 수정 기능 구현
    @PutMapping("/board")
    public boolean boardUpdate( @RequestBody BoardDto boardDto ){
        // 1.유효성검사
        // 2.객체화<선택, 속성이 2개이상 이면서 하나의 dto 표현 가능하면 권장>
        // BoardDto boardDto = new BoardDto( bno , bcontent , null );
        // 3. dao에게 삭제할번호 전달후 결과를 받는다.
        boolean result = boardDao.boardUpdate( boardDto );
        // 4. 결과를 view에게 리턴한다.
        return result;
    } // func e

} // class e
