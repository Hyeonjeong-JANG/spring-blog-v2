package shop.mtcoding.blog.board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Import(BoardNativeRepository.class)
@DataJpaTest
public class BoardNativeRepositoryTest {

    @Autowired
    private BoardNativeRepository boardNativeRepository;

    @Test
    public void findAll_test() {
        // given


        // when
        List<Board> boardList = boardNativeRepository.findAll();
        System.out.println("findAll_test/size: " + boardList.size());
        System.out.println("findAll_test/username: " + boardList.get(2).getUsername());

        // then
        assertThat(boardList.size()).isEqualTo(4);
        assertThat(boardList.get(2).getUsername()).isEqualTo("ssar");
    }


    @Test
    public void findById_test() {
        // given
        int id = 1;

        // when
        Board board = boardNativeRepository.findById(id);

        // then
        System.out.println("findById_test: " + board);
        assertThat(board.getTitle()).isEqualTo("제목1");
        assertThat(board.getUsername()).isEqualTo("ssar");
    }

    @Test
    public void deleteById_test() {
        // given
        int id = 1;

        // when
        boardNativeRepository.deleteById(id);

        // then
        List<Board> boardList = boardNativeRepository.findAll();
        assertThat(boardList.size()).isEqualTo(3);
    }

    @Test
    public void updateById_test() {
        // given
        int id = 1;
        String title = "메롱";
        String content = "롱메";

        // when
        boardNativeRepository.updateById(id, title, content);

        // then
        Board board = boardNativeRepository.findById(id);
        assertThat(board.getTitle()).isEqualTo("메롱");
        assertThat(board.getContent()).isEqualTo("롱메");
    }
}
