package sol.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sol.backend.domain.Board;
import sol.backend.service.BoardService;
import sol.backend.service.JpaBoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private JpaBoardService service;
    
    @GetMapping({"", "/"})
    public String index() {
        return "redirect:/board/list";
    }
    
    // @GetMapping("/list")
    // public void getList(Model model) {
    //     model.addAttribute("list", service.getList());
    // }

    @GetMapping("/list")
    public void getPage(Model model, Integer page, Integer size) {
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }
        Page<Board> boardPage = service.getPage(Pageable.ofSize(size).withPage(page - 1));
        model.addAttribute("currentPage", page);
        model.addAttribute("page", boardPage);
    }

    @GetMapping("/content")
    public void getContent(long seq, Model model) {
        model.addAttribute("dto", service.getContent(seq));
    }

    @GetMapping("/write")
    public void loadWrite(Model model, @RequestParam(defaultValue = "-1") long seq) {
        if (seq != -1) {
            model.addAttribute("dto", service.getContent(seq));
        }
    }

    @GetMapping("/update")
    public String delete(String m, long seq) {
        if (m.equals("del")) {
            service.delete(seq);
        }
        return "redirect:list";
    }

    @PostMapping("/update")
    public String update(String m, Board board, @RequestParam(defaultValue = "-1") long seq) {
        if (m.equals("new")) {
            service.insert(board);
        } else if (m.equals("edit") && seq != -1) {
            board.setSeq(seq);
            service.update(board);
        }

        return "redirect:list";
    }
}
