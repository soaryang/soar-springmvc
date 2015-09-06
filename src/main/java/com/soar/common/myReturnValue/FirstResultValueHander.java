package com.soar.common.myReturnValue;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Administrator on 2015/8/30 0030.
 */
public class FirstResultValueHander implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        System.out.println(")))))))))))))))))))))))))))))))))))))))))))))begin");
        return true;
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        System.out.print("---------------------------------------myResult");
    }
}
