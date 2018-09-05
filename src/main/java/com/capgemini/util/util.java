package com.capgemini.util;

public class util{

        public static boolean isNumeric( String x){
            boolean is= Boolean.TRUE;

            try {
                Integer.valueOf(x);
            } catch (Exception e){
                is=Boolean.FALSE;
            }
            return is;

        }


}


