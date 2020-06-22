package com.dixonlim.oauth.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Classname com.dixonlim.model.SysUserRole
 * @Auther: DixonLim
 * @Date: 2019/9/13 22:48
 * @Description:
 */
@Entity
@Table(name = "sys_user_role")
@Data
public class SysUserRole extends BaseModel  implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "user_id", nullable = false, length = 64)
    private String userId;

    @Column(name = "role_id",nullable = false, length = 64)
    private String roleId;
}
