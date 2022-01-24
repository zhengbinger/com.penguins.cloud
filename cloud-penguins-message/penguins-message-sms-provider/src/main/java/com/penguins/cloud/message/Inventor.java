package com.penguins.cloud.message;

import java.util.Date;

/**
 * @author 郑冰
 * @date 2022/1/21 13:57
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class Inventor {

    private String name;
    private Date birthday;
    private String nationality;

    public Inventor(String name, Date birthday, String nationality) {
        this.name = name;
        this.birthday = birthday;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public Inventor setName(String name) {
        this.name = name;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Inventor setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public Inventor setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }
}
