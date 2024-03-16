package shop.mtcoding.blog.board;

import jakarta.el.ELManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardPersistRepository {
    private final EntityManager em;
    @Transactional
    public void updateById(int id, BoardRequest.UpdateDTO reqDTO) {
       Board board = findById(id);
       board.update(reqDTO);
    }

    @Transactional
    public void deleteById(int id) {
        String q = """
                delete from Board b where b.id = :id
                """;
        Query query = em.createQuery(q);
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public Board findById(int id) {
        Board board = em.find(Board.class, id);
        return board;
    }

    public List<Board> findAll() {
        String q = """
                select b from Board b order by b.id desc
                """;
        Query query = em.createQuery(q, Board.class);
        return (List<Board>) query.getResultList();
    }

    @Transactional
    public Board save(Board board) {
        em.persist(board);
        return board;
    }
}
