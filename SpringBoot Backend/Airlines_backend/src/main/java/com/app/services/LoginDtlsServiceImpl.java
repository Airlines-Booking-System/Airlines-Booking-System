package com.app.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.daos.LoginDtlsDao;
import com.app.entities.RoleEnum;
import com.app.entities.UserDetails;

public class LoginDtlsServiceImpl implements LoginDtlsService {

    @Autowired
    private LoginDtlsDao dao;

    @Override
    public String getUser(String email, String password) {
        if(dao.getUser(email, password)!=null){
            UserDetails user=dao.getUser(email,password);
            RoleEnum role=user.getRole();
            if ("ADMIN".equals(role)) {
                return "redirect:/admin/dashboard";
            } else if ("USER".equals(role)) {
                return "redirect:/user/dashboard";
            }
        }
        return "";
    }

}
