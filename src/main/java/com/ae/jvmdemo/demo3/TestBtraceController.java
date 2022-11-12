package com.ae.jvmdemo.demo3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 有这么一个接口，等会使用Btrace脚本可以动态调式
 */
@RestController
@RequestMapping("/api")
public class TestBtraceController {

    @GetMapping("/btrace")
    public String testBtrace(@RequestParam(value = "name") String name){
        return "hello " + name;
    }
}
