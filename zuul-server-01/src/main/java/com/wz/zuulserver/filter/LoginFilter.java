package com.wz.zuulserver.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    /**
     * 配置过滤类型，有四种不同生命周期的过滤器类型
     * 1. pre：路由之前
     * 2. routing：路由之时
     * 3. post：路由之后
     * 4. error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 配置过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 配置是否需要过滤：true/需要，false/不需要
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务代码
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();

        HttpServletRequest request = context.getRequest();
        String ip = getIpAddr(request);
        logger.info("{} >>> {} >>> {}", request.getMethod(), request.getRequestURL().toString(),ip);
        String token = request.getParameter("token");
        if (token == null) {
            logger.warn("没有token");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            //重定向到登陆

            //Your code..


            //禁止ip
            if("192.168.137.1".equals(ip)){
            try {
                HttpServletResponse response = context.getResponse();
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("非法入侵");
            } catch (IOException e) {
            }

            }
        } else {
            logger.info("OK");
            //访问页面
            //Your code...


        }
        return null;
    }

    /**
     * 获取ip
     * */
    public static String getIpAddr(HttpServletRequest request) {
        //X-Forwarded-For，不区分大小写
        String possibleIpStr = request.getHeader("X-Forwarded-For");
        String remoteIp = request.getRemoteAddr();
        String clientIp;
        if (StringUtils.isNotBlank(possibleIpStr) && !"unknown".equalsIgnoreCase(possibleIpStr)) {
            //可能经过好几个转发流程，第一个是用户的真实ip，后面的是转发服务器的ip
            clientIp = possibleIpStr.split(",")[0].trim();
        } else {
            //如果转发头ip为空，说明是直接访问的，没有经过转发
            clientIp = remoteIp;
        }
        return clientIp;

    }
}
