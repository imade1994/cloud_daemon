package com.tj.cloud;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }




    public String convert(String s, int numRows) {
        int index  = 0;
        int middle = numRows-2;
        Map<Integer, String> map = new HashMap<>();
        String[] sp = s.split("");
        while(index<s.length()){
            for(int k=0;k<numRows;k++){
                for(int i = 0; i < numRows; i++) {
                    do{
                        if(middle>0 && k!=0 && k !=numRows-1){

                        }else{
                            if(map.containsKey(k)){
                                map.get(k).concat(sp[index]);
                            }else{
                                map.put(k,new String(sp[index]));
                            }
                        }

                    }while (!sp[index].equals(",")&&!sp[index].equals(","))
                }
                index++;
            }
        }

    }

}