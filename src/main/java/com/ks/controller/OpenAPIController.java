package com.ks.controller;

import com.ks.domain.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("open_api")
public class OpenAPIController {

    @GetMapping("test")
    public Result TestOpenAPI(){
        return Result.success("Test");
    }
    @GetMapping("test/a")
    public Result TestOpenAPIA(){
        return Result.success("TestA");
    }
}
