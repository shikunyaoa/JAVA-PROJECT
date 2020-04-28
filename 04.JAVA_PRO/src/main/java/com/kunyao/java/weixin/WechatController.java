package com.kunyao.java.weixin;


import com.google.gson.JsonObject;
import com.kunyao.java.common.config.ResponseHelper;
import com.kunyao.java.common.config.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.open.api.WxOpenService;
import me.chanjar.weixin.open.util.json.WxOpenGsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @ClassName: WechatController
 * @Author: kunyao
 * @Description: 微信开放平台扫码登录
 * @Date: 2020/3/27 9:59
 * @Version: 1.0
 */
@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.appsecret}")
    private String appsecret;

    @Value("${wechat.scope}")
    private String scope;

    @Value("${wechat.callBack}")
    private String callBack;

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxOpenService wxOpenService;



    @RequestMapping("/code")
    @ResponseBody
    public ResponseModel getWechatCode(){
        try {
            String oauthUrl = "https://open.weixin.qq.com/connect/qrconnect?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=http://bestus.gz01.bdysite.com/zupu/zupu/login.html#wechat_redirect";
            String redirect_uri = URLEncoder.encode(callBack, "utf-8");
            oauthUrl =  oauthUrl.replace("APPID",appid).replace("REDIRECT_URI",redirect_uri).replace("SCOPE",scope);

            return ResponseHelper.buildResponseModel(oauthUrl);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseHelper.validationFailure("获取失败");
    }


    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String authorizationCode, @RequestParam("state") String returnUrl) throws Exception {
        //获得access token
        String s = null;
        try {
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+appsecret+"&code="+authorizationCode+"&grant_type=authorization_code";
            s = wxOpenService.get(url, null);

        } catch (Exception e) {
            log.info("[微信网页授权] {}",e);
        }
        JsonObject jsonObject = WxOpenGsonBuilder.create().fromJson(s, JsonObject.class);
        return "redirect:" + returnUrl + "?openid=" + jsonObject.get("openid").getAsString();

    }

}