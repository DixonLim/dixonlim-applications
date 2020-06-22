package com.dixonlim.oauth.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Classname com.dixonlim.model.SysRole
 * @Auther: DixonLim
 * @Date: 2019/9/13 22:46
 * @Description:
 */
@Entity
@Table(name ="sys_role")
@Data
public class SysRole extends BaseModel implements Serializable {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "code", nullable = false, length = 64)
    private String code;

    @Column(name = "name", nullable = false, length = 64)
    private String name;
}
