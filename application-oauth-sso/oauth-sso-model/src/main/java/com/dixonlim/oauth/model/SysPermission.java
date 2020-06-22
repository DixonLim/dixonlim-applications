package com.dixonlim.oauth.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname com.dixonlim.model.SysPermission
 * @Auther: DixonLim
 * @Date: 2019/9/14 13:59
 * @Description:
 */
@Entity
@Table(name = "sys_permission")
@Data
public class SysPermission extends BaseModel implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "url", nullable = false, length = 255)
    private String url;

    @Column(name = "role_id", nullable = false, length = 64)
    private String roleId;

    @Column(name = "permission", nullable = false, length = 255)
    private String permission;

}
