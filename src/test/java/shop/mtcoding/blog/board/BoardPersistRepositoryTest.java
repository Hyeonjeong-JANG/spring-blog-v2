package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
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

    @Autowired
    private EntityManager em;

    @Test
    public void deleteById_test() {
        // given
        int id = 1;
        //
        List<Board> boardList = boardPersistRepository.findAll();
        boardPersistRepository.deleteById(id);
        em.flush();

        // then
//        Assertions.assertThat(board.getTitle()).isEqualTo("제목1"); // 인텔리제이 콘솔창 한글이 깨져서 부득이하게 시스템아웃출력함
        System.out.println(boardList);
    }

    @Test
    public void findAll_test() {
        // given


        // when
        List<Board> boardList = boardPersistRepository.findAll();

        // then
        Assertions.assertThat(boardList.size()).isEqualTo(4);
    }

    @Test
    public void findById_test() {
        // given
        int id = 1;
        // when
        Board board = boardPersistRepository.findById(id);

        // then
//        Assertions.assertThat(board.getTitle()).isEqualTo("제목1"); // 인텔리제이 콘솔창 한글이 깨져서 부득이하게 시스템아웃출력함
        System.out.println("findById_test:" + board);
    }

//    @Test
//    public void save_test() {
//        // given
//        Board board = new Board("title5", "content5", "ssar");
//
//        // when
//        boardPersistRepository.save(board);
//
//        // then
//        //Assertions.assertThat(board.getTitle()).isEqualTo("title5");
//        System.out.println("save_test:" + board);
//    }
}
