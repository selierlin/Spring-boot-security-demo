package com.github.peng.spring.boot.security.demo.controller;


import com.github.peng.spring.boot.security.demo.mapper.model.BaseUser;
import com.github.peng.spring.boot.security.demo.service.BaseMenuService;
import com.github.peng.spring.boot.security.demo.service.BaseRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fp295 on 2018/4/7.
 */
@Controller
public class BaseUserController extends BaseController{

    @Autowired
    private BaseRoleService baseRoleService;

    @Autowired
    protected BaseMenuService baseMenuService;

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @RequestMapping("/index.ftl")
    public ModelAndView select(HttpServletRequest request){

        BaseUser baseUser = getCurrentUser();
        request.setAttribute("userInfo",baseUser);
        request.setAttribute("roleList",baseRoleService.selectRolesByUserId(baseUser.getId()));
        request.setAttribute("menuList", baseMenuService.selectRootMenusByUserId(baseUser.getId(), baseUser.getUserName()));
        return new ModelAndView("index");
    }

    @RequestMapping("/{menu}.ftl")
    public ModelAndView menu(HttpServletRequest request, @PathVariable String menu){
        return new ModelAndView(menu);
    }

}
