package sol.backend.repository;

import java.util.List;

import sol.backend.domain.Board;

public interface BoardRepository {
    List<Board> getList();

    Board getContent(long seq);

    void insert(Board board);

    void update(Board board);

    void delete(long seq);
}
