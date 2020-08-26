package com.kkbox.crud_api.service;

import com.kkbox.crud_api.entity.Company;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-08-09
 */
public interface CompanyService extends IService<Company> {

    public void saveCompany(Company company);

    public void deleteCompany(Integer companyId);
}
