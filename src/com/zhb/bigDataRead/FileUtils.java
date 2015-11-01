package com.zhb.bigDataRead;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FileUtils {
    
    public static String getMilliseconds(String dateStr,String format){
        DateFormat sdf = new SimpleDateFormat(format);
        String milliseconds = "";
        try {
            milliseconds = String.valueOf(sdf.parse(dateStr).getTime());
        }catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return milliseconds;
    }
    
    //create directory that with filename
    public static void createDirWithFileName(String filePath){
        String[] paths = filePath.split("\\\\");
        String dir = paths[0];
        for(int i=0;i < paths.length - 2;  i++){
            dir = dir + "/" + paths[i+1];
            File dirFile = new File(dir);
            if(!dirFile.exists()){
                dirFile.mkdir();
            }
        }
    }

}
