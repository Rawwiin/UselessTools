package com.example.uselesstools.controller;

import com.example.uselesstools.model.request.Result;
import com.example.uselesstools.model.request.ResultCode;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Rawwiin
 */
@RestController
public class EscapeController {

    @PostMapping("/escape")
    @ResponseBody
    public Result escape(@RequestBody Map<String,String> params) {
        String origin = params.get("string");
        String escapeJava = StringEscapeUtils.escapeJava(origin);
        System.out.println(origin + " => " + escapeJava);
        return ResultCode.SUCCESS.createResult(escapeJava);
    }

    @PostMapping("/unescape")
    public Result unescape(@RequestBody Map<String,String> params) {
        String origin = params.get("string");
        String unescapeJava = StringEscapeUtils.unescapeJava(origin);
        return ResultCode.SUCCESS.createResult(unescapeJava);
    }
}
