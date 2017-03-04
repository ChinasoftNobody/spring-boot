package com.lgh.spring.boot.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/3/4.
 */
@Entity
@Table(name = "auth_permission")
public class MPermission implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid")
    private String id;
    private String name;
    private String describtion;
    @ManyToMany(mappedBy = "permissions")
    private Set<MRole> roles = new HashSet<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }
    public Set<MRole> getRoles() {
        return roles;
    }
    public void setRoles(Set<MRole> roles) {
        this.roles = roles;
    }
}
