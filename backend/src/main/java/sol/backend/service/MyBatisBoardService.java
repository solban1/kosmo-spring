package sol.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sol.backend.domain.Board;
import sol.backend.mapper.BoardMapper;

// @Service
public class MyBatisBoardService implements BoardService {
    @Autowired
    private BoardMapper mapper;

    @Override
    public List<Board> getList() {
        return mapper.getList();
    }

    @Override
    public Board getContent(long seq) {
        return mapper.getContent(seq);
    }

    @Override
    public void insert(Board board) {
        mapper.insert(board);
    }

    @Override
    public void update(Board board) {
        mapper.update(board);
    }

    @Override
    public void delete(long seq) {
        mapper.delete(seq);
    }
    
}
