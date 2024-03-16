package shop.mtcoding.blog.board;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.blog.util.MyDateUtil;

import java.sql.Timestamp;

@Entity
@Table(name = "board_tb")
@Data
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String username;
    private Timestamp createdAt;

    public Board(String title, String content, String username) {
        this.title = title;
        this.content = content;
        this.username = username;
    }

    public String getTime() {
        return MyDateUtil.timestampFormat(createdAt);
    }
}
