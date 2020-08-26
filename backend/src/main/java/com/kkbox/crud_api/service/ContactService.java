package com.kkbox.crud_api.service;

import com.kkbox.crud_api.entity.Contact;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-08-09
 */
public interface ContactService extends IService<Contact> {

    public List<Contact> queryContactByCompany(Integer companyId);
}
