package sol.backend.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import sol.backend.domain.Board;

@Repository
public class JpaClassicBoardRepository implements BoardRepository {
    @Autowired
    private EntityManager em;

    @Override
    public List<Board> getList() {
        return em.createQuery("SELECT b FROM Board b ORDER BY b.seq DESC", Board.class).getResultList();
    }

    @Override
    public Board getContent(long seq) {
        return em.find(Board.class, seq);
    }

    @Override
    public void insert(Board board) {
        em.persist(board);
        em.flush();
        System.out.println(board);
    }

    @Override
    public void update(Board board) {
        em.createQuery("UPDATE Board b SET b.email=?1, b.subject=?2, b.content=?3 WHERE b.seq=?4")
                .setParameter(1, board.getEmail()).setParameter(2, board.getSubject())
                .setParameter(3, board.getContent()).setParameter(4, board.getSeq()).executeUpdate();
    }

    @Override
    public void delete(long seq) {
        em.remove(getContent(seq));
    }

}
