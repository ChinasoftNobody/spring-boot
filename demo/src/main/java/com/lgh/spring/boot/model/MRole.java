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
@Table(name = "auth_role")
public class MRole implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid")
    private String id;
    private String name;
    private String describtion;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "auth_role_permission",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "id")})
    private Set<MPermission> permissions = new HashSet<>();
    @ManyToMany(mappedBy = "roles")
    private Set<MUser> users = new HashSet<>();

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

    public Set<MPermission> getPermissions() {
        return permissions;
    }
    public void setPermissions(Set<MPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<MUser> getUsers() {
        return users;
    }

    public void setUsers(Set<MUser> users) {
        this.users = users;
    }
}
