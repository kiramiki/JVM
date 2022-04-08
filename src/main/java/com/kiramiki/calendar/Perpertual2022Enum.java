package com.kiramiki.calendar;

public enum Perpertual2022Enum {
    YUANDAN_01("2022-01-01",1),
    YUANDAN_02("2022-01-02",1),
    YUANDAN_03("2022-01-03",1),
	
    SPRINGFESTIVAL_00("2022-01-29",0),
    SPRINGFESTIVAL_01("2022-01-30",0),
    SPRINGFESTIVAL_02("2022-01-31",1),
    SPRINGFESTIVAL_03("2022-02-01",1),
    SPRINGFESTIVAL_04("2022-02-02",1),
    SPRINGFESTIVAL_05("2022-02-03",1),
    SPRINGFESTIVAL_06("2022-02-04",1),
    SPRINGFESTIVAL_07("2022-02-05",1),
    SPRINGFESTIVAL_09("2022-02-06",1),
	
    QINGMING_01("2022-04-02",0),
    QINGMING_02("2022-04-03",1),
    QINGMING_03("2022-04-04",1),
	QINGMING_04("2022-04-05",1),
	
	LABORDAY_00("2022-04-24",0),
    LABORDAY_01("2022-04-30",1),
    LABORDAY_02("2022-05-01",1),
    LABORDAY_03("2022-05-02",1),
	LABORDAY_04("2022-05-03",1),
	LABORDAY_05("2022-05-04",1),
	LABORDAY_06("2022-05-07",0),
	
    DUANWU_01("2022-06-03",1),
    DUANWU_02("2022-06-04",1),
    DUANWU_03("2022-06-05",1),
	
    ZHONGQIU_01("2022-09-10",1),
    ZHONGQIU_02("2022-09-11",1),
    ZHONGQIU_03("2022-09-12",1),
	
    GUOQING_01("2022-10-01",1),
    GUOQING_02("2022-10-02",1),
    GUOQING_03("2022-10-03",1),
    GUOQING_04("2022-10-04",1),
    GUOQING_05("2022-10-05",1),
    GUOQING_06("2022-10-06",1),
    GUOQING_07("2022-10-07",1),
    GUOQING_08("2022-10-08",0),
	GUOQING_09("2022-10-09",0),
    ;
    private String nowadays;
    private Integer is_perpetual;
    Perpertual2022Enum(String nowadays, Integer is_perpetual) {
        this.nowadays = nowadays;
        this.is_perpetual = is_perpetual;
    }

    public String getNowadays() {
        return nowadays;
    }

    public void setNowadays(String nowadays) {
        this.nowadays = nowadays;
    }

    public Integer getIs_perpetual() {
        return is_perpetual;
    }

    public void setIs_perpetual(Integer is_perpetual) {
        this.is_perpetual = is_perpetual;
    }

    public static Perpertual2022Enum for_PerpertualEnum(String nowadays){
        //values是将枚举类转换为数组
        Perpertual2022Enum[] countryEnums = Perpertual2022Enum.values();
        for (Perpertual2022Enum element: countryEnums) {
            if (nowadays.equals(element.getNowadays())){
                return element;
            }
        }
        return null;
    }

}
