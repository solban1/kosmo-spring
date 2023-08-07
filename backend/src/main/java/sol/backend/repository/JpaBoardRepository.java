package sol.backend.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import sol.backend.domain.Board;


public interface JpaBoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderBySeqDesc();
    Page<Board> findAllByOrderBySeqDesc(Pageable pageable);
}
