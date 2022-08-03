package com.kiramiki.algorithms.leteCode;

public class Bottle {


    /**
     * 两块买一瓶水，4个瓶盖换一瓶水，2个瓶子换一瓶，10块能喝几瓶
     * @param
     * @return
     */
    public static int bottle(int gay,int body,int count){
        if (gay/4 == 0 && body/2 == 0){
            return count;
        }
        int num1 = gay/4 + body/2;
        gay = gay%4 + num1;
        body = body%2 + num1;
        count = count + num1;
        return bottle(gay,body,count);
    }

    public static void main(String[] args) {
        int num = 10;
        int gay  = num/2;
        int body = num/2;
        int count = num/2;
        int bottle = bottle(gay, body, count);
        System.out.println(bottle);
    }
}
