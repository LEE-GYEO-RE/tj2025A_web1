package example.실습.실습2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestController2 {

    // 테스트
    //@GetMapping("/board")
    //public boolean method1(){
    //    return true;
    //}

    // 1. 게시물 등록
    @PostMapping("/board")
    public boolean boardWrite(String bwriter, String bcontent) {
        System.out.println("bwriter = " + bwriter + ", bcontent = " + bcontent);
        System.out.println("RestController2.boardWrite");
        // bwriter = null, bcontent = null
        return true;
    }

    // 2. 게시물 전체 조회
    @GetMapping("/board")
    public List<BoardDto> boardPrint() {
        ArrayList<BoardDto> list = new ArrayList<>();
        list.add(new BoardDto("안녕하세요", 1, "유재석"));
        list.add(new BoardDto("안녕하세요2", 2, "강호동"));
        return list;
    }

    // 3. 게시물 개별 조회
    @GetMapping("/board/detail")
    public BoardDto boardDetail(@RequestParam(defaultValue = "0") int bno) {
        BoardDto boardDto = new BoardDto();
        System.out.println("RestController2.boardDetail");
        System.out.println("bno = " + bno);
        return boardDto;
    }

    // 4. 게시물 삭제
    @DeleteMapping("/board")
    public boolean boardDelete(@RequestParam(defaultValue = "0") int bno) {
        System.out.println("RestController2.boardDelete");
        System.out.println("bno = " + bno);
        return true;
    }

    // 5. 게시물 수정
    @PutMapping("/board")
    public boolean boardUpdate(BoardDto boardDto) {
        System.out.println("RestController2.boardUpdate");
        System.out.println("boardDto = " + boardDto);
        return false;
    }

}
