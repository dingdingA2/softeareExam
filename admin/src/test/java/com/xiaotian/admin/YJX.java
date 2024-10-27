package com.xiaotian.admin;

/**
 * @author 程序狗没有春天
 * @version 1.00
 * @createTime 2024/8/5 21:36
 */
public class YJX {
    public static void main(String[] args) {
        girlfriend gf1 = new girlfriend("小诗诗", 18, 180, 60, "唱");
        girlfriend gf2 = new girlfriend("小倩倩", 19, 175, 55, "跳");
        girlfriend gf3 = new girlfriend("小佳佳", 20, 168, 55, "rap");
        System.out.println("我的女朋友一号的基本信息：" + "姓名: " + gf1.getName() + " 年龄: " + gf1.getAge() + " 身高: " + gf1.getHigh() + " 体重: " + gf1.getWeight() + " 爱好: " + gf1.getHpbby());
        System.out.println("我的女朋友二号的基本信息：" + "姓名: " + gf2.getName() + " 年龄: " + gf2.getAge() + " 身高: " + gf2.getHigh() + " 体重: " + gf2.getWeight() + " 爱好: " + gf2.getHpbby());
        System.out.println("我的女朋友三号的基本信息：" + "姓名: " + gf3.getName() + " 年龄: " + gf3.getAge() + " 身高: " + gf3.getHigh() + " 体重: " + gf3.getWeight() + " 爱好: " + gf3.getHpbby());
    }
}
