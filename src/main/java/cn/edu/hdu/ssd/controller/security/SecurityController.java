package cn.edu.hdu.ssd.controller.security;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.hdu.ssd.common.base.BaseController;
import cn.edu.hdu.ssd.model.ShiroToken;

@Controller
@RequestMapping("/security")
public class SecurityController extends BaseController
{
    @RequestMapping(value = "/view/login", method = RequestMethod.GET)
    public ModelAndView login()
    {
        return new ModelAndView("user/login");
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> login(HttpServletRequest request)
    {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        try
        {
            ShiroToken token = new ShiroToken("admin", "21232f297a57a5a743894a0e4a801fc3");
            token.setRememberMe(false);
            SecurityUtils.getSubject().login(token);
            ShiroToken token2 = (ShiroToken) SecurityUtils.getSubject().getPrincipal();

            logger.info(token2.getUsername() + "," + token2.getPswd());

            resultMap.put("status", 200);
            resultMap.put("message", "登录成功");

            /**
             * 获取登录之前的地址
             */
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = null;
            if (null != savedRequest)
            {
                url = savedRequest.getRequestUrl();
            }
            // 跳转地址
            resultMap.put("back_url", url);
        }
        catch (DisabledAccountException e)
        {
            resultMap.put("status", 500);
            resultMap.put("message", "帐号已经禁用。");
        }
        catch (Exception e)
        {
            resultMap.put("status", 500);
            resultMap.put("message", "帐号或密码错误");
        }
        return resultMap;
    }

}
