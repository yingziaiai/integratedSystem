package com.cloud.integratedSystem.auth.exception;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

//        /**
//         * 日志
//         */
//        private Logger logger = LoggerFactory.getLogger(getClass());
//
//        /**
//         * json 转换工具类
//         */
//        private ObjectMapper objectMapper;
//        @Autowired
//        private SecurityProperties securityProperties;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        logger.info("登录成功");
        super.onAuthenticationSuccess(request,response,authentication);
//        response.setContentType("application/json;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        out.write("{\"error_code\":\"0\",\"message\":\"欢迎登录系统\"}");
        //判断是json 格式返回 还是 view 格式返回
//            if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
//                //将 authention 信息打包成json格式返回
//                response.setContentType("application/json;charset=UTF-8");
//                response.getWriter().write(objectMapper.writeValueAsString(authentication));
//            }else {
//                //返回view
//                super.onAuthenticationSuccess(request,response,authentication);
//            }

    }
}
