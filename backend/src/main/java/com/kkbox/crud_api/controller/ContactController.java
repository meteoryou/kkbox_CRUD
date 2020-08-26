package com.kkbox.crud_api.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kkbox.crud_api.entity.Contact;
import com.kkbox.crud_api.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/{companyId}")
    public List<Contact> queryContactByCompanytest(@PathVariable("companyId") Integer companyId){
        return contactService.queryContactByCompany(companyId);
    }

}
