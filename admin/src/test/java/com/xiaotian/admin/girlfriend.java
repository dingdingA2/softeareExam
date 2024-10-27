package com.xiaotian.admin;

/**
 * @author 程序狗没有春天
 * @version 1.00
 * @createTime 2024/8/5 21:34
 */
public class girlfriend {
    private String name;
    private int age;
    private int high;
    private int weight;
    private String hpbby;

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

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getHpbby() {
        return hpbby;
    }

    public void setHpbby(String hpbby) {
        this.hpbby = hpbby;
    }

    public girlfriend(String name, int age, int high, int weight, String hpbby) {
        this.name = name;
        this.age = age;
        this.high = high;
        this.weight = weight;
        this.hpbby = hpbby;
    }

    public girlfriend() {
    }
}
