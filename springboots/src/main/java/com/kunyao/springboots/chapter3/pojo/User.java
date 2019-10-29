package com.kunyao.springboots.chapter3.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @ClassName User
 * @Description 实体类
 * @Author kunyao
 * @Date $
 */
//@Component表名哪个类被扫描进入Spring IoC容器
//@ComponentScan则表名采用何种策略去扫描装配Bean
@Component("user")
public class User {

    //@Value则是指定具体的值
    @Value("1")
    private Long id;

    @Value("user_name_1")
    private String username;

    @Value("note_1")
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
