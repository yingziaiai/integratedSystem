package com.cloud.integratedSystem.auth.controller;

import com.cloud.integratedSystem.auth.constant.GithubConstant;
import com.cloud.integratedSystem.auth.util.HttpClientUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
public class GithubLoginController {

    @GetMapping("/githubLogin")
    public void githubLogin(HttpServletResponse response) throws IOException {
        String state = "test";
        // Step1：通过 Code url 获取 code
        response.sendRedirect(GithubConstant.CODE_URL.concat("&state=" + state));
    }


    @GetMapping("/githubCallback")
    public String githubCallbackWithCode(String code, String state) throws Exception {
        System.out.println("==>state:" + state);
        System.out.println("==>code:" + code);

        if (!StringUtils.isEmpty(code) && !StringUtils.isEmpty(state)) {
            String token_url = GithubConstant.TOKEN_URL.replace("CODE", code);
            // Step2：通过 Authorization Code 获取 AccessToken
            String githubAccessTokenResult = HttpClientUtils.doGet(token_url);
            String token = HttpClientUtils.getMap(githubAccessTokenResult).get("access_token");
            // Step3: 根据token发送请求获取登录人的信息  ，通过令牌去获得用户信息
            String userinfo_url = GithubConstant.USER_INFO_URL.replace("TOKEN", token);
            String userInfo = HttpClientUtils.doGet(userinfo_url);//json

            Map<String, String> responseMap = HttpClientUtils.getMapByJson(userInfo);
            // 成功则登陆
            return "index.html";
        }
        return "login.html";

  }

}
