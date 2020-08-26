package com.kkbox.crud_api.controller;


import com.kkbox.crud_api.entity.Company;
import com.kkbox.crud_api.entity.Contact;
import com.kkbox.crud_api.mapper.CompanyMapper;
import com.kkbox.crud_api.service.CompanyService;
import com.kkbox.crud_api.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Wrapper;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-08-08
 */
@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private ContactController contactController;

    @GetMapping("/{id}")
    public Company test(@PathVariable("id") Long id){
        return companyService.getById(id);
    }

    @GetMapping("/list")
    public List<Company> queryAllCompany(){
        return companyService.list();
    }

    @PostMapping("/saveCompany")
    public void saveCompanyTest(@Validated @RequestBody Company company){
        companyService.saveCompany(company);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCompany(@PathVariable("id") Integer companyId){
        contactService.queryContactByCompany(companyId);
    }
}
