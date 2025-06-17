package com.dev.springsecurity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UserEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column
private long id;
@Column
private String username;
@Column
private String password;

@ElementCollection(fetch=FetchType.EAGER)
private List<String>roleList = new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(long id, String username, String password, List<String> roleList) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleList = roleList;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoleList() {
        return this.roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public UserEntity id(long id) {
        setId(id);
        return this;
    }

    public UserEntity username(String username) {
        setUsername(username);
        return this;
    }

    public UserEntity password(String password) {
        setPassword(password);
        return this;
    }

    public UserEntity roleList(List<String> roleList) {
        setRoleList(roleList);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserEntity)) {
            return false;
        }
        UserEntity userEntity = (UserEntity) o;
        return id == userEntity.id && Objects.equals(username, userEntity.username) && Objects.equals(password, userEntity.password) && Objects.equals(roleList, userEntity.roleList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, roleList);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", roleList='" + getRoleList() + "'" +
            "}";
    }
}
