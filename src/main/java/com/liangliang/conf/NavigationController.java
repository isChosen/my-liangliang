package com.liangliang.conf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 *
 * Author: Administrator
 * Date: 2018/4/5
 * Description:
 */

@Controller
public class NavigationController {

    // 主页
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    // 聊天室
    @RequestMapping("/chat")
    public String chat() {
        return "pages/chat";
    }

}
