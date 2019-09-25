package com.security.demo.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.security.demo.bean.UmsAdmin;
import com.security.demo.mapper.UmsAdminMapper;
import com.security.demo.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UmsAdminMapper umsAdminMapper;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody String data) {
        JsonObject param = new JsonParser().parse(data).getAsJsonObject();
        String token = adminService.login(param.get("username").toString(), param.get("password").toString());
        Map<String, String> tokenMap = new HashMap<>();
        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@RequestBody String data) {
        JsonObject param = new JsonParser().parse(data).getAsJsonObject();
        String username = param.get("username").toString().replace("\"", "");
        String password = param.get("password").toString().replace("\"", "");
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername(username);
        String encodePassword = passwordEncoder.encode(password);
        umsAdmin.setPassword(encodePassword);
        umsAdmin.setStatus(1);
        umsAdminMapper.insert(umsAdmin);
        return "regist successfully!";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:product:create')")
    public String create() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();

        return "success:" + name;
    }
}
