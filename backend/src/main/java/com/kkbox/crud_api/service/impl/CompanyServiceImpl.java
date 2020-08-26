package com.kkbox.crud_api.service.impl;

import com.kkbox.crud_api.entity.Company;
import com.kkbox.crud_api.entity.Contact;
import com.kkbox.crud_api.mapper.CompanyMapper;
import com.kkbox.crud_api.service.CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kkbox.crud_api.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-08-09
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {

    @Autowired
    private ContactService contactService;

    @Transactional(rollbackFor={Exception.class})
    public void saveCompany(Company company) {

        company.setUpdateDt(LocalDateTime.now());
        saveOrUpdate(company);

        //Get company primiry key
        Integer companyId = company.getId();

        List<Contact> contactList = company.getContactList();
        for(Contact contact : contactList){
            contact.setCompanyId(companyId);
        }

        List<String> removeContactIds = getRemoveContactIds(companyId, contactList);

        if(!contactList.isEmpty()){
            contactService.saveOrUpdateBatch(contactList);
        }

        if (!removeContactIds.isEmpty()) {
            contactService.removeByIds(removeContactIds);
        }
    }

    public void deleteCompany(Integer companyId){

        List<Contact> contactList = contactService.queryContactByCompany(companyId);
        List<String> contactIdList = new ArrayList<String>();
        for(Contact contact : contactList){
            contactIdList.add(contact.getId());
        }

        if(contactIdList.size() != 0){
            contactService.removeByIds(contactIdList);
        }
        removeById(companyId);
    }

    private List<String> getRemoveContactIds(Integer companyId, List<Contact> contactList){
        List<String> result = new ArrayList<String>();

        List<Contact> oriContactList = contactService.queryContactByCompany(companyId);

        // if oriContact.id is exsit in contact
        Predicate<Contact> isReadyToRemove = oriContact -> !contactList.stream().anyMatch(
                newContact -> oriContact.getId().equals(newContact.getId())
        );

        result = oriContactList
                .stream()
                .filter(isReadyToRemove)
                .map(oriContact -> oriContact.getId())
                .collect(Collectors.toList());

        return result;
    }
}
