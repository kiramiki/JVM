package com.kiramiki.jvm.utils;

/**
 * 枚举类的使用
 * ---枚举的作用，可以理解为一个小型的mysql数据库，用来存放一些常量数据，修改方便，降低代码耦合度。
 * ---什么情况下可以用枚举呢？比如某些常用的数据，某些统一的键值对
 */
public enum CountryEnum {
    ONE(1,"齐"), TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");
    private Integer number;
    private String country;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    CountryEnum(Integer number, String country) {
        this.number = number;
        this.country = country;
    }

    public static CountryEnum for_CountryEnum(Integer number){
        //values是将枚举类转换为数组
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum element: countryEnums) {
                if (number == element.getNumber()){
                    return element;
                }
        }
        return null;
    }

}
