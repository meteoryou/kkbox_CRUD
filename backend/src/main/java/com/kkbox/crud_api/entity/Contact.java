package com.kkbox.crud_api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "ID", type = IdType.INPUT)
    private String id;

    /**
     * COMPANY_ID
     */
    @TableField("COMPANY_ID")
    private Integer companyId;

    /**
     * 姓名
     */
    @TableField("NAME")
    private String name;

    /**
     * 職稱
     */
    @TableField("JOB_TITLE")
    private String jobTitle;

    /**
     * 電話
     */
    @TableField("PHONE_NUM")
    private String phoneNum;

    /**
     * 信箱
     */
    @TableField("EMAIL")
    private String email;

    @TableField("CREATE_BY")
    private String createBy;

    @TableField("CREATE_DT")
    private LocalDateTime createDt;

    @TableField("UPDATE_BY")
    private String updateBy;

    @TableField("UPDATE_DT")
    private LocalDateTime updateDt;


}
