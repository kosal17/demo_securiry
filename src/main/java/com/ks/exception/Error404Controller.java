package com.ks.exception;

import com.ks.constants.HttpStatus;
import com.ks.domain.response.Result;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("error")
public class Error404Controller {
    @RequestMapping(value = "",produces = "text/html;charset=UTF-8")
    public String error404(HttpServletResponse response){
        response.setStatus(HttpStatus.SUCCESS);
        return "api not found";
    }
    @RequestMapping(value = "",consumes = "application/json;charset=UTF-8",produces = "application/json;charset=UTF-8")
    public Result error404Json(HttpServletResponse response){
        response.setStatus(HttpStatus.SUCCESS);
        return Result.error(404,"api not found");
    }

}
