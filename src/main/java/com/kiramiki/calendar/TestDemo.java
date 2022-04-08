package com.kiramiki.calendar;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.date.DateUtil;

import java.lang.reflect.Field;
import java.util.*;

public class TestDemo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {


        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("1","String1");
        hashMap.put("2","String2");
        hashMap.put("3","String3");
        hashMap.put("4","String4");
        hashMap.put("5","String5");
        hashMap.put("6","String6");

        for (String key: hashMap.keySet()){
            System.out.println(hashMap.get(key));
        }

        // 用这个时间来代替审核通过时间
//        Date passDate = DateUtil.parse("2021-12-09");
//        String passDateStr = DateUtil.format(passDate,"yyyy-MM-dd");
//        System.out.println(passDateStr);
//        Date nowDate = new Date();
//
//        String nowDateStr = DateUtil.format(nowDate,"yyyy-MM-dd");
//        System.out.println(nowDateStr);
//        // 当前时间减5天，是否小于审核通过实践，
//        int year = DateUtil.year(nowDate);
//        System.out.println(year);
//        int workDays = PerpetualCalendar.getWorkDays(year,passDateStr,nowDateStr);
//        System.out.println("workDays :" + workDays);
//        String str =  "61052219960206001X";
//        String build = str.substring(6,14);
//        String sex = str.substring(16,17);
//        Integer i = (Integer.parseInt(sex))%2;
//        System.out.println(build);
//        System.out.println(sex);
//        String offDate = DateUtil.offsetMonth(new Date(),-3).toString();
//        System.out.println(offDate);
//        List<String> list = new ArrayList<>();
//        System.out.println(ListUtil.);
//
//        Testtest testtest = new Testtest();
//        testtest.setPersonName("zhangsan");
//        Map<String,Object> map = BeanUtil.beanToMap(testtest);
//        System.out.println(map);
//        String str = "idCard";
//        Field name = Testtest.class.getDeclaredField(str);
//        name.setAccessible(true);
//        Testtest qualifiQueryRequest = new Testtest();
//        String desc = (String)name.get(testtest);
//        System.out.println(desc);


//        Perpetual perpetual = new Perpetual();
//        perpetual.setIs_perpetual(5);
//        perpetual.setWeek(5);
//        perpetual.setNowadays("test");
//        Perpetual1 perpetual1 = new Perpetual1();
//        BeanUtil.copyProperties(perpetual,perpetual1);
//        System.out.println(perpetual1.getIs_perpetual());
//        System.out.println(perpetual1.getNowadays());
    }

}
