package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.sql.Timestamp;

@Data
@Table(name = "board_tb")
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String username;
    private String content;
    private Timestamp createdAt;

    // 세터는 모든 필드에 적용될 필요가 없기 때문에 필요한 것만 만들어서 쓴다.
    // 이렇게 하지 않고 모든 필드의 세터를 열어두면 컨트롤러에서 막 이것저것 다 고치는 이상한 짓을 하는 사람이 있다.
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
