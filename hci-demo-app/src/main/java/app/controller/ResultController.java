package app.controller;

import demo.dto.Result;
import demo.service.ITypicodeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResultController {

    private  final ITypicodeService typicodeService;

    public ResultController(ITypicodeService typicodeService) {
        this.typicodeService = typicodeService;
    }

    @RequestMapping("/test")
    public Result test(@RequestParam String userId) {
        return typicodeService.getResult(userId);
    }

}
