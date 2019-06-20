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

    public static int rC(String s) {
        int yearDigits = Integer.parseInt(s.substring(0, 2));
        int year = 0;
        int monthDigits = Integer.parseInt(s.substring(2, 4));
        int month = 0;
        int day = Integer.parseInt(s.substring(4, 6));

        if (s.substring(6, 7).equals("/")) {
            if (yearDigits < 54 && s.length() == 11) {
                year = 2000 + yearDigits;
            } else {
                year = 1900 + yearDigits;
            }
        } else {
            if (yearDigits < 54 && s.length() == 10) {
                year = 2000 + yearDigits;
            } else {
                year = 1900 + yearDigits;
            }
        }

        if (monthDigits > 0 && monthDigits <= 12) {
            month = monthDigits;
        } else if (monthDigits > 20 && monthDigits <= 32) {
            month = monthDigits - 20;
        } else if (monthDigits > 50 && monthDigits <= 62) {
            month = monthDigits - 50;
        } else {
            month = monthDigits - 70;
        }

        return (day * 1000000 + month * 10000 + year);

    }

}
