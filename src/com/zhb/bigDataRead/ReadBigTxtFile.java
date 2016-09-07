package com.zhb.bigDataRead;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.codec.binary.Base64;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhb.bigDataRead.model.VerifySessionResponse;
import com.zhb.bigDataRead.model.VerifySessionResponseData;

public class ReadBigTxtFile {
    
    public static String originalDataPath = "E:\\format-data\\originalData";
    
    public static OutputStreamWriter writer;
    public static BufferedWriter bw;
    public static String outfilePath ="E:\\format-data\\splits\\";
    public static File outFile;
    public static int MAX_FILE_SIZE = 10 * 1024 * 1024;
    
    public static File errorFile;
    public static String errorFilePath ="E:\\format-data\\errors\\";
    public static OutputStreamWriter errorWriter;
    public static BufferedWriter errorBw;
    
    public static int total = 0;
    public static int rightCount = 0;
    public static int neededCount = 0;
    public static int notNeededCount = 0;
    public static int errorCount = 0;
    
    public static void main(String[] args){
       // initWriter();
        List<File> selectedFiles = selectFiles(originalDataPath);
        if(selectedFiles != null && !selectedFiles.isEmpty()){
            readTxtFile(selectedFiles, "utf-8");
        }
        
    }
    
    public static void initRightWriter(String eventDay){
        String rightFilePath = outfilePath + eventDay + "\\ip_42.62.96.60\\port_8180\\"+ eventDay + ".log";
        outFile = new File(rightFilePath);
        
        if(!outFile.exists()){
            createDirectory(rightFilePath);          
        }
        try {
            if(writer != null && bw != null){
                bw.close();
                writer.close();
            }       
            writer = new OutputStreamWriter(new FileOutputStream(outFile,true));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        bw = new BufferedWriter(writer);
        
        
    }
    
    public static void initErrorWriter(String eventDay){
        String errorPath = errorFilePath + eventDay + "\\ip_42.62.96.60\\port_8180\\"+ eventDay + "_error.log";
        
        errorFile = new File(errorPath); 
        
        if(!errorFile.exists()){
            createDirectory(errorPath);
        }
        try {
            if(errorBw != null && errorWriter != null){
                errorBw.close();
                errorWriter.close();
            }
                  
            errorWriter = new OutputStreamWriter(new FileOutputStream(errorFile,true));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        errorBw = new BufferedWriter(errorWriter);
        
    }
    
    public static void createDirectory(String filePath){
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
    
    public static List<File> selectFiles(String originalDataPath){
        List<File> fileList = new ArrayList<File>();
        File destFile = new File(originalDataPath);
        if(destFile.exists()){
            if(destFile.isFile()){
                return fileList;
            }else{
                File[] files = destFile.listFiles();
                if(files.length == 0){
                    System.out.println("the directory is empty");
                    return fileList;
                }else{
                    for(File file : files){
                        if(file.getName().matches("login(\\d+).txt")){
                            fileList.add(file);
                        }
                    }
                }
            }
        }
        return fileList;
    }
    public static void readTxtFile(List<File> selectedFiles,String encoding) {
        for(File file : selectedFiles){
            try{
                if(file.isFile() && file.exists()){
                    InputStreamReader read = new InputStreamReader(new FileInputStream(file),encoding);
                    BufferedReader br = new BufferedReader(read);             
                    String line = null;                   
                    while((line = br.readLine()) != null){
                        total++;
                        String reg = "^(\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}).+,authInfo:(.*)version:.*";               
                        Pattern pat = Pattern.compile(reg);
                        Matcher mat = pat.matcher(line);
                        
                        JSONObject authObj = new JSONObject();
                        String eventTime = "";
                        String eventDay = "";
                        if(mat.matches()){
                            eventTime = mat.group(1);
                            eventDay = eventTime.split("\\s")[0];
                            String authStr = mat.group(2);
                            authStr = authStr.replaceAll("\\s+", "+");
                            String decodeStr = "";
                            //System.out.println("authInfo: " + mat.group(1));
                            try{
                                if(!authStr.startsWith("{\"")){
                                    decodeStr = new String(Base64.decodeBase64(authStr.getBytes()),"UTF-8");
                                    authStr = decodeStr;
                                }
                                authObj = JSON.parseObject(authStr);                            
                            }catch(Exception e){
                                //e.printStackTrace();
                                saveErrorData(line,eventDay);
                                continue;
                            }
                            
                        }else{
                            saveErrorData(line,"0000-00-00");
                            System.out.println(line);
                            continue;
                        }
                        
                        if(authObj == null){
                            saveErrorData(line,eventDay);
                            continue;
                        } 
                        rightCount++;
                        formatedJsonStr(authObj, eventTime);
                    }
                    br.close();
                    read.close();
                    
                    
                }else{
                    System.out.println("找不到文件");
                }
            }catch(IOException e){
                System.out.println("读取文件出错");
                e.printStackTrace();
            }
        }
        closeWriter();        
        System.out.println("total: " + total + " right: " + rightCount + 
                " need: " + neededCount + "not need: " +notNeededCount + " error: " + errorCount);
            
    }
    public static void formatedJsonStr(JSONObject authObj,String eventTime){
        String appid = authObj.getString("appId");
        String channelId = authObj.getString("channelId");
        boolean appFlag = "1100".equals(appid) || "100001".equals(appid);
        boolean channelIdFlag = "mi".equalsIgnoreCase(channelId) || "yingyongbao".equalsIgnoreCase(channelId)
                || "weixin".equalsIgnoreCase(channelId) || "QQ".equalsIgnoreCase(channelId);
        if(appFlag && channelIdFlag){
            neededCount++;
            //System.out.println(eventStamp);
            //String eventTime = getEventTime(line); 
            String authToken = authObj.getString("authToken");
            String uId = authObj.getString("uId");
            String name = authObj.getString("name");
            
            VerifySessionResponse verifySes = new VerifySessionResponse();
            verifySes.setCode("0");
            String milliseconds = FileUtils.getMilliseconds(eventTime, "yyyy-MM-dd HH:mm:ss");
            verifySes.setEventTime(milliseconds);
            VerifySessionResponseData data = new VerifySessionResponseData();
            data.setXgAppId(appid);
            data.setChannelId(channelId);
            data.setSessionId(authToken);
            data.setUid(uId);
            data.setUserName(name);
            verifySes.setData(data);
            String jsonData = JSON.toJSONString(verifySes); 
            String eventDay = eventTime.split("\\s")[0];
            makeJsonFormatToFile(jsonData,eventDay);
            
        }else{
            notNeededCount++;
        }
    }    
    
    public static void closeWriter(){
        try {
            bw.close();
            writer.close();            
            errorBw.close();
            errorWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void makeJsonFormatToFile(String jsonData,String eventDay){
        
        try {
            initRightWriter(eventDay);         
            bw.append(jsonData);
            bw.append("\n");
            bw.flush();        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
    public static void saveErrorData(String line,String eventDay){
        errorCount++;
        initErrorWriter(eventDay);
        try{
            errorBw.append(line);
            errorBw.append("\n");
            errorBw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    

}
