package com.zhb.bigDataRead;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataTranslation {
    
    public static String inputPath = "E:\\format-data\\originalData\\datalogs_20150821_59\\login_archives";
    public static String outPath = "E:\\format-data\\originalData\\datalogs_out\\datalogs_20150821_59\\login_archives";
    
    public static void main(String[] args){
        //get files in a day
        File inputFile = new File(inputPath);
        File[] filesByDay = null;
        if(inputFile.exists()){
             filesByDay = inputFile.listFiles();            
        }
        if(filesByDay.length > 0){
            for(File f : filesByDay){
               File[] filesByPort = f.listFiles()[0].listFiles();
               for(File fp : filesByPort){
                   File[] dayFiles = fp.listFiles();
                   for(File dayfile : dayFiles){
                       //read  object write
                       doFileTranslate(dayfile);
                   }
               }
                
            }
        }
            
    }
    
    public static void doFileTranslate(File file){
        if(file.isFile() && file.exists()){
            String fileName = file.getName();
            Pattern pat = Pattern.compile("^login_(.+).log$");
            Matcher mat = pat.matcher(fileName);
            String dateStr = "";
            if(mat.matches()){
                dateStr = mat.group(1);
            }
            String milliseconds =  FileUtils.getMilliseconds(dateStr,"yyyy-MM-dd_HH-mm");
            InputStreamReader read;
            try {
                read = new InputStreamReader(new FileInputStream(file));
                BufferedReader br = new BufferedReader(read);
                
                String fullPath = file.getAbsolutePath();
                String newFilePath = outPath + fullPath.split("login_archives")[1];
                File destFile = new File(newFilePath);
                if(!destFile.exists()){
                   FileUtils.createDirWithFileName(newFilePath);
                }
                OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(destFile,true));
                BufferedWriter bw = new BufferedWriter(writer);
                String line = null;
                while((line = br.readLine()) != null){
                    JSONObject jsonO = JSON.parseObject(line);
                    jsonO.put("eventTime", milliseconds);
                    //saveToNewFile(jsonO.toJSONString());
                    bw.append(jsonO.toJSONString());
                    bw.append("\n");
                    bw.flush();
                }
                br.close();
                read.close();
                bw.close();
                writer.close();
                
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }                
        }
    }
    
    
    
    
    

}
