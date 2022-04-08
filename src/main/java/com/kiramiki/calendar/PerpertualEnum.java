package com.kiramiki.calendar;

public enum PerpertualEnum {
    YUANDAN_2021_01("2021-01-01",1),
    YUANDAN_2021_02("2021-01-02",1),
    YUANDAN_2021_03("2021-01-03",1),
    SPRINGFESTIVAL_2021_00("2021-02-07",0),
    SPRINGFESTIVAL_2021_01("2021-02-11",1),
    SPRINGFESTIVAL_2021_02("2021-02-12",1),
    SPRINGFESTIVAL_2021_03("2021-02-13",1),
    SPRINGFESTIVAL_2021_04("2021-02-14",1),
    SPRINGFESTIVAL_2021_05("2021-02-15",1),
    SPRINGFESTIVAL_2021_06("2021-02-16",1),
    SPRINGFESTIVAL_2021_07("2021-02-17",1),
    SPRINGFESTIVAL_2021_09("2021-02-20",0),
    QINGMING_2021_01("2021-04-03",1),
    QINGMING_2021_02("2021-04-04",1),
    QINGMING_2021_03("2021-04-05",1),
    LABORDAY_2021_00("2021-04-25",0),
    LABORDAY_2021_01("2021-05-01",1),
    LABORDAY_2021_02("2021-05-02",1),
    LABORDAY_2021_03("2021-05-03",1),
    LABORDAY_2021_04("2021-05-04",1),
    LABORDAY_2021_05("2021-05-05",1),
    LABORDAY_2021_06("2021-05-08",0),
    DUANWU_2021_01("2021-06-12",1),
    DUANWU_2021_02("2021-06-13",1),
    DUANWU_2021_03("2021-06-14",1),
    ZHONGQIU_2021_00("2021-09-18",0),
    ZHONGQIU_2021_01("2021-09-19",1),
    ZHONGQIU_2021_02("2021-09-20",1),
    ZHONGQIU_2021_03("2021-09-21",1),
    GUOQING_2021_00("2021-09-26",0),
    GUOQING_2021_01("2021-10-01",1),
    GUOQING_2021_02("2021-10-02",1),
    GUOQING_2021_03("2021-10-03",1),
    GUOQING_2021_04("2021-10-04",1),
    GUOQING_2021_05("2021-10-05",1),
    GUOQING_2021_06("2021-10-06",1),
    GUOQING_2021_07("2021-10-07",1),
    GUOQING_2021_08("2021-10-09",0),


    YUANDAN_2022_01("2022-01-01",1),
    YUANDAN_2022_02("2022-01-02",1),
    YUANDAN_2022_03("2022-01-03",1),
    SPRINGFESTIVAL_2022_00("2022-01-29",0),
    SPRINGFESTIVAL_2022_01("2022-01-30",0),
    SPRINGFESTIVAL_2022_02("2022-01-31",1),
    SPRINGFESTIVAL_2022_03("2022-02-01",1),
    SPRINGFESTIVAL_2022_04("2022-02-02",1),
    SPRINGFESTIVAL_2022_05("2022-02-03",1),
    SPRINGFESTIVAL_2022_06("2022-02-04",1),
    SPRINGFESTIVAL_2022_07("2022-02-05",1),
    SPRINGFESTIVAL_2022_09("2022-02-06",1),
    QINGMING_2022_01("2022-04-02",0),
    QINGMING_2022_02("2022-04-03",1),
    QINGMING_2022_03("2022-04-04",1),
    QINGMING_2022_04("2022-04-05",1),
    LABORDAY_2022_00("2022-04-24",0),
    LABORDAY_2022_01("2022-04-30",1),
    LABORDAY_2022_02("2022-05-01",1),
    LABORDAY_2022_03("2022-05-02",1),
    LABORDAY_2022_04("2022-05-03",1),
    LABORDAY_2022_05("2022-05-04",1),
    LABORDAY_2022_06("2022-05-07",0),
    DUANWU_2022_01("2022-06-03",1),
    DUANWU_2022_02("2022-06-04",1),
    DUANWU_2022_03("2022-06-05",1),
    ZHONGQIU_2022_01("2022-09-10",1),
    ZHONGQIU_2022_02("2022-09-11",1),
    ZHONGQIU_2022_03("2022-09-12",1),
    GUOQING_2022_01("2022-10-01",1),
    GUOQING_2022_02("2022-10-02",1),
    GUOQING_2022_03("2022-10-03",1),
    GUOQING_2022_04("2022-10-04",1),
    GUOQING_2022_05("2022-10-05",1),
    GUOQING_2022_06("2022-10-06",1),
    GUOQING_2022_07("2022-10-07",1),
    GUOQING_2022_08("2022-10-08",0),
    GUOQING_2022_09("2022-10-09",0),
    ;
    ;
    private String nowadays;
    private Integer is_perpetual;
    PerpertualEnum(String nowadays, Integer is_perpetual) {
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

    public static PerpertualEnum for_PerpertualEnum(String nowadays){
        //values是将枚举类转换为数组
        PerpertualEnum[] countryEnums = PerpertualEnum.values();
        for (PerpertualEnum element: countryEnums) {
            if (nowadays.equals(element.getNowadays())){
                return element;
            }
        }
        return null;
    }

}
