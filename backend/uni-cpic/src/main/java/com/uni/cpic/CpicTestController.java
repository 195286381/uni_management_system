package com.uni.cpic;

import com.uni.common.core.controller.BaseController;
import com.uni.common.core.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 太平洋保险业务代码
 * @author zhuzw
 * @date 2024/11/19 14:59
 */
@RestController
@RequestMapping("/cpic/test")
@Slf4j
public class CpicTestController extends BaseController {
    @GetMapping("/hello")
    public AjaxResult hello(){
        return success("hello");
    }
}
