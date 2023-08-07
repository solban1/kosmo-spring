package sol.backend.dto;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;
import sol.backend.domain.Board;

@Getter
public class BoardListResult {
    private List<Board> list;
    private int size;
    private long totalElements;
    private int totalPages;
    private int pageIndex;

    public BoardListResult(Page<Board> page) {
        list = page.getContent();
        size = page.getSize();
        totalElements = page.getTotalElements();
        totalPages = page.getTotalPages();
        pageIndex = page.getPageable().getPageNumber();
    }
}
