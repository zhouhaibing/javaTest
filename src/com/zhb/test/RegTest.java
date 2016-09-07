package com.zhb.test;


public class RegTest {
    public static void main(String[] args){
        
        /*String str = "2015-07-30 14:47:07.126  INFO 125653 --- [io-18180-exec-9] c.s.p.s.service.rest.AppController       : start to call channel verify session service,authInfo:"
                + "eyJuYW1lIjoiY3BkMjU1NjY1OCIsImNoYW5uZWxJZCI6" + 
"Imlvc19oYWltYXYzIiwiYXBwSWQiOiIxMDI0YXBwaWQiLCJhdXRoVG9rZW4iOiJZVGt6TjBGUlNsSkJVVTVYUVdkTlIwRkJkMGhCZDFWRlYzZFNZbFpXU2xGRVJsSlVRbXhvVmtKQlkwRkNkMlJVUVdkVlNrRnNORVZDZHpWVldGWk9WRlZuVW1GQ2QyTklRa0ZqVEZa"
+"UldsTllSWFJLUjFaU1lWWkJTbFJXUVZWQlZrWlJSVll4VFV4Q1FVbEZRVUZCU0ZaV1dVVkNWbmRDVjJ4M1RrRkdUVVJUYURsT1FVRmFVME5SUmxaRFozTkZRbWM9Iiwic2lnbiI6IjJlN2ZhYzlhYTMyZjM0M2I0Y2U3NjJjNTg3YWZjZjI5IiwidUlkIjoiY3BkMjU1"
+"NjY1OCJ9version:1.6.4";
        
        String reg = ".+,authInfo:(.*)version:.*";
        
        Pattern pat = Pattern.compile(reg);
        Matcher mat = pat.matcher(str);
        if(mat.matches()){
            System.out.println(mat.group(0));
            System.out.println(mat.group(1));
        }
        
        
        String s = "E:\\format-data\\split_1.txt";
        System.out.println(s);
        String fileName = s.substring(s.lastIndexOf("\\")+1,s.length());
        System.out.println(fileName);//split_1.txt
        String reg2 = "^split_(\\d).txt$";
        Pattern pat2 = Pattern.compile(reg2);
        Matcher mat2 = pat2.matcher("split_1.txt");
        if(mat2.matches()){
            System.out.println(mat2.group(0));
            System.out.println(mat2.group(1));
        }
        System.out.println(s.substring(0, s.lastIndexOf("\\") + 1));
        
        
        System.out.println(s.replaceAll("(\\d)", "2"));
        
        String ss = "eyJjaGFubmVsSWQiOiJqaW5zaGFuSU9TIiwiYXBwSWQiOiIxMTA5IiwiYXV0aFRva2VuIjoiMDdkZGQ4MTIwYmU4OTlhNSIsInNpZ24iOiI1MDlhZmExYTM1Mjk2NmIzZmNjNzk4MmI5NjlkNTU3MiIsInVJZCI6IjQwZmU3YWNhMmI5MGJlODEyNjA4NjVfX0VYUF8uIn0=,eyJjaGFubmVsSWQiOiJqaW5zaGFuSU9TIiwiYXBwSWQiOiIxMTA5IiwiYXV0aFRva2VuIjoiMD";
        //String ss = "eyJhcHBJZCI6IjExMDgiLCJhdXRoVG9rZW4iOiJLTFA0VnB0YVFoRTEyQUNlIiwiY2hhbm5lbElkIjoibWkiLCJuYW1lIjoi6buY6K6k6LSm5Y+3IiwidUlkIjoiNzQ2ODU0NTAiLCJzaWduIjoiODkwZDkxZTRhMmYzZGU5YmUzZjJjOWY4Y2MwNzcxYmMifQ==";
        //ss = ss.replaceAll("\\", replacement)
        //String ss = "eyJhcHBJZCI6IjExMDgiLCJhdXRoVG9rZW4iOiJLTFA0VnB0YVFoRTEyQUNlIiwiY2hhbm5lbElkIjoibWkiLCJuYW1lIjoi6buY6K6k6LSm5Y 3IiwidUlkIjoiNzQ2ODU0NTAiLCJzaWduIjoiODkwZDkxZTRhMmYzZGU5YmUzZjJjOWY4Y2MwNzcxYmMifQ";
        System.out.println(Base64.decode(ss));
        
        String ss1 = "ss dd    xx d";
        ss1 = ss1.replaceAll("\\s+", "+");
        System.out.println(ss1);*/
        
        
        
        /*String ss2 = "2015-07-31 18:55:06.673  INFO 125721 --- [o-28180-exec-10] c.s.p.s.service.rest.AppController       : start to call channel verify session service,authInfo:eyJhcHBJZCI6IjExMDkiLCJzaWduIjoiN2Y0YzczMWFjNWM1YTRkMGZlZGJiYzM2ZDY5ZmRhNDkiLCJ1SWQiOiJhNjZiM2Y2YjZjM2U3NWRmODU2NDg3X19FWFBfLiIsImF1dGhUb2tlbiI6InNlZGYyMGU2MTRmOTA3MGFhIiwiY2hhbm5lbElkIjoiamluc2hhbklPUyJ9,eyJhcHBJZCI6IjExMDkiLCJzaversion:";
        //String reg3 = "(\\d{1,})\\w{1,}";
        //String reg3 = "(\\d{3})\\w+";
        //String reg3 = "^(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}).+";
        String reg3 = "^(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}).+,authInfo:(.*)version:.*";
        Pattern pat3 = Pattern.compile(reg3);
        Matcher mat3 = pat3.matcher(ss2);
        if(mat3.matches()){
            System.out.println(mat3.group(0) + "\n" + mat3.group(1) + "\n" + Base64.decode(mat3.group(2)));
        }
        
        
        //分割url
        String outfilePath ="E:\\format-data//splits\\";
        System.out.println(outfilePath);
        System.out.println(outfilePath.split("\\\\")[0]);
        System.out.println(outfilePath.split("//")[0]);// //不是转义字符, 字符"|","*","+"都得加上转义字符，前面加上"\\"
        
        
        System.out.println("-----------------------------");
        String reg4 = "^(.+)\\.uc$";
        Pattern pat4 = Pattern.compile(reg4);
        Matcher mat4 = pat4.matcher("com.xishanju.ed3.uc");
        if(mat4.matches()){
            System.out.println(mat4.group(0));
        }
        
        System.out.println("--------------ddd---------------");
        String reg5 = "(%[A-Z]*[0-9]*)*";
        Pattern pat5 = Pattern.compile(reg5);
        Matcher mat5 = pat5.matcher("%E5%A7");
        if(mat5.matches()){
            System.out.println(mat5.group(0));
        }*/
    	
    	String ss = "xgsdk.qa.datasource.password";
    	String regex = "xgsdk.(ci|qa).datasource.password";
    	System.out.println(ss.matches(regex));
        
        
        
    }

}
