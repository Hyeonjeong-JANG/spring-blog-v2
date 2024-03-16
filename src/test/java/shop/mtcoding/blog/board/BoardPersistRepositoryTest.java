package shop.mtcoding.blog.board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.annotation.Id;

import java.util.List;

@Import(BoardPersistRepository.class)
@DataJpaTest
public class BoardPersistRepositoryTest {
    @Autowired
    private BoardPersistRepository boardPersistRepository;

    @Test
    public void save_test() {
        // given
        Board board = new Board("title5", "content5", "ssar");

        // when
        boardPersistRepository.save(board);

        // then
        Assertions.assertThat(board.getTitle()).isEqualTo("title5");
        System.out.println("save_test:"  +board);
    }
}
