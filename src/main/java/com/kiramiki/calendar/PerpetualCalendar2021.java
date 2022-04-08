package com.kiramiki.calendar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/***
 * 万年历 2021
 */
public class PerpetualCalendar2021 {
    public static List<Perpetual> list = new ArrayList<>();

    //一、元旦：2021年1月1日至3日放假，共3天。
    //
    //二、春节：2月11日至17日放假调休，共7天。2月7日（星期日）、2月20日（星期六）上班。
    //
    //三、清明节：4月3日至5日放假调休，共3天。
    //
    //四、劳动节：5月1日至5日放假调休，共5天。4月25日（星期日）、5月8日（星期六）上班。
    //
    //五、端午节：6月12日至14日放假，共3天。
    //
    //六、中秋节：9月19日至21日放假调休，共3天。9月18日（星期六）上班。
    //
    //七、国庆节：10月1日至7日放假调休，共7天。9月26日（星期日）、10月9日（星期六）上班。
    private static void getPerpetual(List<Perpetual> list){
        int year = 2021;
        int initWeek = 5;
        int[] months = new int[]{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //计算瑞年
//        if (initYears%400 != 0 && initYears%4 == 0 ){
//            initDays = 366;
//            months[1] = 28;
//        }
        for (int i = 0 ; i < months.length; i++){
            int m = i+1;
            int d = 1;
//            System.out.println("月份" + i);
            for (int j = 0 ; j<months[i] ;j++){
                Perpetual perpetual = new Perpetual();
                String date = year + "-" + String.format("%02d",m) + "-" + String.format("%02d",d);
                int w = initWeek;
                int p = 0;
                if (initWeek == 6 || initWeek == 7){
                    p = 1;
                }
                d++;
                initWeek++;
                if (initWeek > 7 ){
                    initWeek = 1;
                }
                perpetual.setWeek(initWeek);
                perpetual.setNowadays(date);
                perpetual.setIs_perpetual(p);
                list.add(perpetual);
//                System.out.println(date + " " + w + " " + p );
            }
        }
        for (Perpetual perpetual : list){
            PerpertualEnum perpertualEnum = PerpertualEnum.for_PerpertualEnum(perpetual.getNowadays());
            if (perpertualEnum != null){
                perpetual.setIs_perpetual(perpertualEnum.getIs_perpetual());
            }
//            System.out.print(perpetual.getNowadays() + " " + perpetual.getWeek() + " " + perpetual.getIs_perpetual());
//            System.out.println();
        }
    }

    public static void main(String[] args) {
//        getPerpetual(list);
//        String date = "2021-09-01";
//        String date2 = "2021-10-10";
//        Long startTime = System.currentTimeMillis();
//        int workDays = getWorkDays(date, date2);
//        Long endTime = System.currentTimeMillis();
//        System.out.println("workDays :" + workDays);
//        System.out.println("OK,用时：" + (endTime - startTime));
        int code = 401/100;
        String codeStr = String.format("%02d",code);
        System.out.println(codeStr);
    }

    private static int getWorkDays(String date1, String date2){
        int start = 0 ;
        int end = 0;
        for (int i = 0 ; i< list.size(); i++){
            if (date1.equals(list.get(i).getNowadays())){
                start = i;
            }
            if (date2.equals(list.get(i).getNowadays())){
                end = i;
            }
        }
        System.out.println("start:" + start);
        System.out.println("end:" + end);
        int  count = 0;
        for (int i = start; i < end + 1 ; i++){
            if (0 == list.get(i).getIs_perpetual()){
                count++;
            }
        }
        return count;
    }

}
