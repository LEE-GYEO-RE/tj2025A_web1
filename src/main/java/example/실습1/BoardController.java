package example.실습1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {

    // 1. 글쓰기
    @PostMapping("/실습1/board")
    @ResponseBody
    public boolean create(){
        System.out.println("BoardController.create");
        return true;
    }

    // 2. 전체 글 조회
    @GetMapping("/실습1/board")
    @ResponseBody
    public List<boardDto> read(){
        System.out.println("BoardController.read");
        ArrayList<boardDto> list = new ArrayList<>();
        list.add(new boardDto());
        list.add(new boardDto());
        return list;
    }

    // 3. 개별 글 조회
    @GetMapping("/실습1/board/view")
    @ResponseBody
    public Map<Integer , String> dread(){
        System.out.println("BoardController.dread");
        Map<Integer , String > map = new HashMap<>();
        map.put(1 , "어린왕자");
        map.put(2 , "누가 내머리에 똥쌌어");
        return map;
    }

    // 4. 개별 글 수정
    @PutMapping("/실습1/board")
    @ResponseBody
    public boolean update(){
        System.out.println("BoardController.update");
        return false;
    }

    // 5. 개별 글 삭제
    @DeleteMapping("/실습1/board")
    @ResponseBody
    public int delete(){
        System.out.println("BoardController.delete");
        return 3;
    }

} // class e

