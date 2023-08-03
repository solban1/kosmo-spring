package sol.backend.controller;

import java.util.List;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sol.backend.controller.domain.Human;
import sol.backend.controller.domain.HumanList;

@RequestMapping("/test")
@RestController
public class TestController {
    
    @RequestMapping({"", "/"})
    public void m00() {
        System.out.println("m00()");
    }

    @RequestMapping("/base1")
    public void m01() {
        System.out.println("m01()(ALL methods)");
    }

    @GetMapping("/base2")
    public void m02() {
        System.out.println("m02()(GET only)");
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "/base3")
    public void m03() {
        System.out.println("m03(GET, POST only)");
    }

    @GetMapping("/param1")
    public void m04(Human human) {
        System.out.println(human);
    }

    @GetMapping("/param2")
    public void m06(@RequestParam List<String> names) { // @RequestParam is required
        System.out.println(names);
    }

    @GetMapping("/param3")
    public void m08(@RequestParam MultiValueMap<String, String> params) {
        System.out.println(params);
    }

    @GetMapping("/param4")
    public void m09(@RequestParam HumanList list) { // need to encode character [, ]
        System.out.println(list);
    }

    @GetMapping("/param5")
    public void m10(ToDo todo) {
        System.out.println(todo.getCdate());
    }

    @GetMapping("/json1")
    public Human m11(Human human) {
        return human;
    }

}
