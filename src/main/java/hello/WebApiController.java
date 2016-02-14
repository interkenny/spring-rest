package hello;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebApiController {

    @RequestMapping(method=RequestMethod.GET)
    public void method1() {
        throw new MyException("test exception");
    }
    @RequestMapping(value="/null", method=RequestMethod.GET)
    public void method2() {
        throw new NullPointerException("test exception");
    }

    /*
    @ExceptionHandler でアノテートしたメソッドを定義すると、そのコントローラ内でだけ有効な例外ハンドリングができる。
    @ExceptionHandler の value には、ハンドリングしたい例外の Class オブジェクトを渡す。
     */
    @ExceptionHandler(NullPointerException.class)
    public String handling(NullPointerException e) {
        return "{\"message\":\"" + e.getMessage() + "\"}";
    }

}
