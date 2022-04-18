package com.example.smserver.type;

/**
 * @description:
 * @author: zhh
 * @time: 2022/4/16
 */
public enum RoleEnum {
    /**
     * 超级管理员
     */
    ADMIN(1L,"ADMIN","超级管理员"),
    /**
     * 学生
     */
    STUDENT(2L,"STUDENT","学生"),
    /**
     * 老师
     */
    TEACHER(3L,"TEACHER","老师");

    public long id;
    public String name;
    public String zh;

    RoleEnum(long id, String name, String zh){
        this.id = id;
        this.name = name;
        this.zh = zh;
    }
}
