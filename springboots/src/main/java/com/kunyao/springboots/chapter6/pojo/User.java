package com.kunyao.springboots.chapter6.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName User
 * @Description 用户pojo
 * @Author kunyao
 * @Date $
 */
@Alias("user")
public class User {

    private Long id;

    private String username;

    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
