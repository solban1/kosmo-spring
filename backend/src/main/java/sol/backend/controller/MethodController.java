package sol.backend.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MethodController {
    // controller returns template
    @GetMapping("/template")
    public String m1(Model model) {
        model.addAttribute("data", "Goodbye JSP 2");
        return "tmeplate";
    }

    // controller returns string
    @ResponseBody
    @GetMapping("/string")
    public String m2() {
        return "string";
    }

    @ResponseBody
    @GetMapping("/book")
    public Book m3(@RequestParam(required = false) String title, String price) {
        if (title == null) {
            title = "Harry Potter";
        }
        try {
            return new Book(title, Integer.parseInt(price));
        } catch (NumberFormatException | NullPointerException e) {
            return new Book(title, 10000);
        }
    }

    @ResponseBody
    @GetMapping("/book/{id}")
    public Book m3(@PathVariable int id) {
        ArrayList<Book> arr = new ArrayList<>();
        arr.add(new Book("Harry Potter", 10000));
        arr.add(new Book("Harry Potter2", 20000));
        arr.add(new Book("Harry Potter3", 30000));

        return arr.get(id);
    }

    class Book {
        private String title;
        private int price;

        Book(String title, int price) {
            this.title = title;
            this.price = price;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public int getPrice() {
            return price;
        }
    }

}
