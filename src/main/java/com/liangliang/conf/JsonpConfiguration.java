package com.liangliang.conf;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

// jsonpApi 此包下所有类和方法都支持 jsonp 跨域
@ControllerAdvice(basePackages = {"com.lianglaing.jsonpApi"})
public class JsonpConfiguration extends AbstractJsonpResponseBodyAdvice {
    public JsonpConfiguration() {
        super("callback", "jsonp");
    }
}
