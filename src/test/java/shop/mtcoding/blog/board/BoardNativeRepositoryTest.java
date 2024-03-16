package shop.mtcoding.blog.board;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardNativeRepository.class)
@DataJpaTest
public class BoardNativeRepositoryTest {

    @Autowired
    private BoardNativeRepository boardNativeRepository;

    @Test
    public void updateById_test() {
        // given
        int id = 1;
        String title = "제목수정";
        String content = "내용수정";
        String username = "ssar2";

        // when
        boardNativeRepository.updateById(id, title, content, username);
        Board board = boardNativeRepository.findById(id);

        // then
        Assertions.assertThat(board.getContent()).isEqualTo("내용수정");
        Assertions.assertThat(board.getTitle()).isEqualTo("제목수정");
        Assertions.assertThat(board.getUsername()).isEqualTo("ssar2");
    }

        @Test
        public void deleteById_test () {
            // given
            int id = 1;

            // when
            boardNativeRepository.deleteById(id);
            List<Board> boardList = boardNativeRepository.findAll();

            // then
            Assertions.assertThat(boardList.size()).isEqualTo(3);

        }

        @Test
        public void findById_test () {
            // given
            int id = 1;

            // when
            Board board = boardNativeRepository.findById(id);

            // then
            Assertions.assertThat(board.getTitle()).isEqualTo("제목1");
            Assertions.assertThat(board.getContent()).isEqualTo("내용1");

        }


        @Test
        public void findAll_test () {
            // given


            // when
            List<Board> boardList = boardNativeRepository.findAll();

            // then
            Assertions.assertThat(boardList.size()).isEqualTo(4);

        }
    }
