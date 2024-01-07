package mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        //System.out.println(name + surname);\
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam("a") int a,
                                 @RequestParam("b") int b,
                                 @RequestParam("action") String action,
                                 Model model) {
        double result = 0;
        switch (action) {
            case "add":
                result = a + b;
                break;
            case "sub":
                result = a - b;
                break;
            case "mult":
                result = a * b;
                break;
            case "div":
                result = a / (double)b;
                break;
            default:
                System.out.println("Миша, вырубай");
        }
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
