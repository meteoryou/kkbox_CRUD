package com.kkbox.crud_api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kkbox.crud_api.entity.Contact;
import com.kkbox.crud_api.mapper.ContactMapper;
import com.kkbox.crud_api.service.ContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-08-09
 */
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements ContactService {

    public List<Contact> queryContactByCompany(Integer companyId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("COMPANY_ID", companyId);

        return list(queryWrapper);
    }
}
