package mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author imnot
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("index")
    public String toIndex(){

        return "index";
    }
}
