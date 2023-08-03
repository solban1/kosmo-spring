package sol.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sol.backend.domain.Board;
import sol.backend.repository.BoardRepository;

//@Service
public class JdbcBoardService implements BoardService {
    //@Autowired
    private BoardRepository repository;

    public JdbcBoardService(BoardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Board> getList() {
        return repository.getList();
    }

    @Override
    public Board getContent(long seq) {
        return repository.getContent(seq);
    }

    @Override
    public void insert(Board board) {
        repository.insert(board);
    }

    @Override
    public void update(Board board) {
        repository.update(board);
    }

    @Override
    public void delete(long seq) {
        repository.delete(seq);
    }
    
}
