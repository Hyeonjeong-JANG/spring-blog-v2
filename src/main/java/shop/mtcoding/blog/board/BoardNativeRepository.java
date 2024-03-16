package shop.mtcoding.blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardNativeRepository {
    private final EntityManager em;


    @Transactional
    public void updateById(int id, String title, String content, String username) {
        String q = """
                update board_tb set title =?, content=?, username=? where id =?
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, title);
        query.setParameter(2, content);
        query.setParameter(3, username);
        query.setParameter(4, id);

        query.executeUpdate();
    }

    @Transactional
    public void deleteById(int id) {
        String q = """
                delete from board_tb where id =?
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, id);
        query.executeUpdate();
    }

    public Board findById(int id) {
        String q = """
                select * from board_tb where id=?
                """;
        Query query = em.createNativeQuery(q, Board.class);
        query.setParameter(1, id);
        return (Board) query.getSingleResult();
    }

    @Transactional
    public void save(BoardRequest.SaveDTO reqDTO) {
        String q = """
                insert into board_tb(title, content, username, created_at) values(?,?,?,now())
                """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, reqDTO.getTitle());
        query.setParameter(2,  reqDTO.getContent());
        query.setParameter(3,  reqDTO.getUsername());

        query.executeUpdate();
    }

    public List<Board> findAll() {
        String q = """
                select * from board_tb order by id desc 
                """;
        Query query = em.createNativeQuery(q, Board.class);
        return query.getResultList();
    }
}
