package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardNativeRepository boardNativeRepository;

    @GetMapping("/board/{id}/update-form")
    public String updateForm(@PathVariable (name="id") Integer id, HttpServletRequest request){
        Board board = boardNativeRepository.findById(id);
        request.setAttribute("board", board);
        return "board/update-form";
    }

    @PostMapping("/board/{id}/update")
    public String update(@PathVariable (name = "id") Integer id, String title, String  content, String  username){
        System.out.println("id: "+id);
        System.out.println("title: "+title);
        System.out.println("content: "+content);
        System.out.println("username: "+username);
        boardNativeRepository.updateById(id, title, content, username);
        return "redirect:/board/"+id;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request) {

        List<Board> boardList = boardNativeRepository.findAll();
        request.setAttribute("boardList", boardList);

        return "index";
    }

    @PostMapping("/board/save")
    public String save(String title, String content, String username) {
        // *** 항상 출력해보고 디비에 넣어라.
        boardNativeRepository.save(title, content, username);
        return "redirect:/";
    }

    @GetMapping("/board/save-form")
    public String saveForm() {
        return "board/save-form";
    }

    @GetMapping("/board/{id}")
    public String detail(@PathVariable (name = "id") Integer id, HttpServletRequest request) {
        Board board = boardNativeRepository.findById(id);
        request.setAttribute("board", board);
        return "board/detail";
    }

    @PostMapping("/board/{id}/delete")
    public String delete(@PathVariable (name = "id") Integer id) {
        // *** 항상 출력해보고 디비에 넣어라.
        boardNativeRepository.deleteById(id);

        return "redirect:/";
    }
}
