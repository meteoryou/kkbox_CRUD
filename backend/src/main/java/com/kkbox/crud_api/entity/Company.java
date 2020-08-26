package com.kkbox.crud_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 关注公众号：MarkerHub
 * @since 2020-08-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 公司名稱
     */
    @TableField("NAME")
    private String name;

    /**
     * 填單人
     */
    @TableField("FILL_IN")
    private String fillIn;

    /**
     * 負責人
     */
    @TableField("OWNER")
    private String owner;

    /**
     * 地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 統編
     */
    @TableField("TAX_ID")
    private String taxId;

    /**
     * 電話
     */
    @TableField("PHONE_NUM")
    private String phoneNum;

    /**
     * 傳真
     */
    @TableField("FAX_NUM")
    private String faxNum;

    /**
     * 備註
     */
    @TableField("COMMENT")
    private String comment;

    @TableField("CREATE_BY")
    private String createBy;

    @TableField("CREATE_DT")
    private LocalDateTime createDt;

    @TableField("UPDATE_BY")
    private String updateBy;

    @TableField("UPDATE_DT")
    private LocalDateTime updateDt;

    @TableField(exist = false)
    private List<Contact> contactList;


}
