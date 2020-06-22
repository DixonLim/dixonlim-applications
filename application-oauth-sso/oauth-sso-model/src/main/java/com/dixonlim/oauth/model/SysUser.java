package com.dixonlim.oauth.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by DixonLim
 */
@Entity
@Table(name = "sys_user")
@Data
public class SysUser extends BaseModel implements Serializable{

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    @Column(name = "password", nullable = false, length = 155)
    private String password;

    @Column(name = "email", length = 64)
    private String email;
}
