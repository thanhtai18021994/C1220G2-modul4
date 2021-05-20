package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Role implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long id;
    private String nameRole;
    @ManyToMany(fetch =FetchType.EAGER,mappedBy ="roles",cascade = CascadeType.ALL)
    private Set<User> users;

    public Role() {
    }

    public Role(String nameRole) {
        this.nameRole = nameRole;
    }

    public Role(String nameRole, Set<com.example.demo.model.User> users) {
        this.nameRole = nameRole;
        this.users = users;
    }

    public Role(Long id, String nameRole, Set<com.example.demo.model.User> users) {
        this.id = id;
        this.nameRole = nameRole;
        this.users = users;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    public Set<com.example.demo.model.User> getUsers() {
        return users;
    }

    public void setUsers(Set<com.example.demo.model.User> users) {
        this.users = users;
    }
}
