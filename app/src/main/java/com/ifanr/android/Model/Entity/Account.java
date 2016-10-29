package com.ifanr.android.Model.Entity;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by ganyao on 2016/10/26.
 */

public class Account extends RealmObject{
    //主键必须添加注解
    @PrimaryKey
    private int id;//主键id
    @Required    //注解设为Required代表必须项
    private String name = "1234";//姓名

    private int age;//年龄

    @Ignore   //表示忽视项,数据库不会存储该字段
    private boolean hasGrilFriend;//是否有女朋友

    public Account() {
    }

    public Account(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Account(String name, int id, int age, boolean hasGrilFriend) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.hasGrilFriend = hasGrilFriend;
    }

    public boolean isHasGrilFriend() {
        return hasGrilFriend;
    }

    public void setHasGrilFriend(boolean hasGrilFriend) {
        this.hasGrilFriend = hasGrilFriend;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
