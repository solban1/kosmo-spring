package sol.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sol.backend.domain.Board;
import sol.backend.repository.JpaBoardRepository;

@Service
public class JpaBoardService implements BoardService {
    @Autowired
    private JpaBoardRepository repository;

    @Override
    public List<Board> getList() {
        return repository.findAllByOrderBySeqDesc();
    }

    public Page<Board> getPage(Pageable pageable) {
        return repository.findAllByOrderBySeqDesc(pageable);
    }

    @Override
    public Board getContent(long seq) {
        return repository.getReferenceById(seq);
    }

    @Override
    public void insert(Board board) {
        repository.save(board);
    }

    @Override
    public void update(Board board) {
        Board oldBoard = getContent(board.getSeq());
        oldBoard.setEmail(board.getEmail());
        oldBoard.setSubject(board.getSubject());
        oldBoard.setContent(board.getContent());
        repository.save(oldBoard);
    }

    @Override
    public void delete(long seq) {
        repository.deleteById(seq);
    }
    
}
