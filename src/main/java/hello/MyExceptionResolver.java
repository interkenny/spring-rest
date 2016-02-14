package hello;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyExceptionResolver implements HandlerExceptionResolver {

    // @ResponseStatus でアノテートされたクラスがスローされた場合は呼ばれない
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
        System.out.println(ex.getClass() + " : " + ex.getMessage());

        // RestControllerの場合、レスポンスがデフォルトのハンドリング方法で処理されるようになる
        if (isRestController(handler)) {
            return null;
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("my-error");

        return mv;
    }

    // Return Json object
    private boolean isRestController(Object handler) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod)handler;

            return method.getMethod().getDeclaringClass().isAnnotationPresent(RestController.class);
        }

        return false;
    }
}
