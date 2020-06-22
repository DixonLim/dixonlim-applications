package com.dixonlim.oauth.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: DixonLim
 * @Date: 2020/6/22 21:56
 * @Description: model基本抽象类，用于继承
 */
@MappedSuperclass
@Data
abstract public class BaseModel implements Serializable {

    /**
     * 创建日期
     */
    @Column(name = "date_created")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dateCreated;

    /**
     * 最后更新日期
     */
    @Column(name = "last_updated")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdated;

    /**
     * 版本号
     */
    @Column(name = "version")
    private Integer version;

    /**
     * 是否删除标识
     */
    @Column(name = "is_delete")
    private Boolean deleteFlag = false;

    /**
     * 删除日期
     */
    @Column(name = "delete_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date deleteDate;

    /**
     * 操作用户
     */
    @Column(name = "operation_user")
    private String operationUser;


    public void setDeleteFlag(Boolean deleteFlag) {
        if (deleteFlag != null && deleteFlag) {
            this.deleteDate = new Date();
        }
        this.deleteFlag = deleteFlag;
    }

    @PrePersist
    protected void prePersist() {
        dateCreated = new Date();
        lastUpdated = dateCreated;
        version = 1;
    }

    @PreUpdate
    private void preUpdate() {
        lastUpdated = new Date();
        if (version == null) {
            version = 1;
        } else {
            version++;
        }
    }
}
