package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/request")
@RestController
public class RequestController {
    private Logger logger = LoggerFactory.getLogger(RequestController.class);

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Request request(@ModelAttribute("request") Request request) throws IOException {
        logger.info("リクエスト情報: {} ", request.toString());
        logger.info("レスポンス: {}", request.toString());
        return request;
    }
}
