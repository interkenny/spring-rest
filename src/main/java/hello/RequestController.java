package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequestMapping("/request")
@RestController
public class RequestController {
    private Logger logger = LoggerFactory.getLogger(RequestController.class);

    private RequestService requestService;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Respons request(@ModelAttribute("request") Request request) throws IOException {
        logger.info("リクエスト情報: {} ", request.toString());

        //requestService.save(request);
        Respons respons = new Respons();
        respons.setCode("6666");
        respons.setMessage("テスト");
        respons.setData(request.getRecords());

        logger.info("レスポンス: {}", request.toString());
        return respons;
    }
}
