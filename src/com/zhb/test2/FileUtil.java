package com.zhb.test2;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class FileUtil {

	/**
	 * 读取文件内容
	 *
	 * @param filePath
	 * @return
	 */
	public static String read(String filePath,String orgiString,String targetString) {
		BufferedReader br = null;
		String line = null;
		StringBuffer buf = new StringBuffer();

		try {
			// 根据文件路径创建缓冲输入流
			br = new BufferedReader(new FileReader(filePath));

			// 循环读取文件的每一行, 对需要修改的行进行修改, 放入缓冲对象中
			while ((line = br.readLine()) != null) {
				// 此处根据实际需要修改某些行的内容
				if (line.indexOf(orgiString) != -1) {
					line = line.replaceAll(orgiString, targetString);
				}

				buf.append(line);
				buf.append("\r\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
				}
			}
		}

		return buf.toString();
	}

	/**
	 * 将内容回写到文件中
	 *
	 * @param filePath
	 * @param content
	 */
	public static void write(String filePath, String content) {
		BufferedWriter bw = null;

		try {
			// 根据文件路径创建缓冲输出流
			bw = new BufferedWriter(new FileWriter(filePath));
			// 将内容写入文件中
			bw.write(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					bw = null;
				}
			}
		}
	}

	/**
	 * 读取properties文件
	 * @param filePath properteis文件的路径
	 * @return 返回的文件的键值对
	 */
	public static Properties loadPropertiesFile(String filePath)
	{
		Properties prop = new Properties();
		InputStream in = null;
		try{
			//读取属性文件a.properties
			in = new BufferedInputStream (new FileInputStream(filePath));
			prop.load(in);//加载属性列表
		}
		catch(Exception e){
			return prop;
		} finally {
			if(in != null)
			{
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return prop;
	}

	/**
	 * 根据AndroidManifest.xml的路径获取对应的properties属性
	 * @param 打包过程中AndroidManifest.xml的路径
	 * @return 获取所有的渠道参数值
	 */
	public static Properties getChannelPropertiesByXmlPath(String xmlFilePath,String channelId){
		//获取xgsdk_properties目录
		String propertiesFile =  xmlFilePath.replaceAll("AndroidManifest.xml", "assets/sdk_config.properties");
		//获取sensitive_properteis文件路径
		String sensitiveFilePath =  xmlFilePath.replaceAll("tmp/AndroidManifest.xml", "sensitive/"+channelId+"_sensitive_config.properties");
		System.out.println("SDK_CONFIG.properties------------->" + propertiesFile);
		System.out.println("SDK_CONFIG.properties------------->" + sensitiveFilePath);
		Properties properties =	FileUtil.loadPropertiesFile(propertiesFile);
		properties.putAll(FileUtil.loadPropertiesFile(sensitiveFilePath));

		return properties;
	}

	public static InputStream replaceAllString(InputStream inputStream,String regex,String replacement) throws UnsupportedEncodingException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line.replaceAll(regex, replacement));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		InputStream resultStrean = null;
		resultStrean = new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));

		return resultStrean;
	}

	public static void main(String[] args)
	{
		String content = read("F:\\test2\\target\\apktool.yml", "com.wh.xyfm.anzhi", "kugou");
		write("F:\\test2\\target\\apktool.yml", content);
	}
}
