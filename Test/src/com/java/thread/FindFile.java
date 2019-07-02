/**
 * 
 */
package com.java.thread;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author PE
 * @date 2019年6月27日 下午3:35:41
 * @explain 
 */
public class FindFile {
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
    	File file=new File("D:/testpro/Test");
        long starttime1=System.currentTimeMillis();
        findcontent(file,"FindFile");
        long endtime1=System.currentTimeMillis();
        long time1=endtime1-starttime1;
        System.out.println("使用多线程查找指定字符串的用时为："+time1+"ms");
         
        long starttime2=System.currentTimeMillis();
        normalFindContent(file, "FindFile");
        long endtime2=System.currentTimeMillis();
        long time2=endtime2-starttime2;
        System.out.println("使用普通方法查找指定字符串的用时为："+time2+"ms");
 
    }
	 public static void findcontent(File file,String str) {
	        File[]allFiles=file.listFiles();
	        if(allFiles==null) {
	            System.out.println("当前目录为空！");
	            return;
	        }
	        for(File f1:allFiles) {
	            if(f1.isDirectory()) {
	                findcontent(f1, str);
	            }
	            else if(f1.getName().endsWith(".java")){
	                Thread thread=new Thread() {
	                    public void run() {
	                        try(FileReader fileReader=new FileReader(f1);){
	                            char[]cs=new char[(int)f1.length()];
	                            fileReader.read(cs);
	                            String string=String.valueOf(cs);
	                            if(string.contains(str)) {
	                                System.out.println("使用多线程找到含有字符串"+str+"的java文件"+",文件名称为"+f1.getName());
	                            }
	                        }
	                        catch (IOException e) {
	                            // TODO: handle exception
	                            e.printStackTrace();
	                        }
	                    }
	                    };
	                thread.start();
	                     
	                 
	                 
	            }
	        }
	    }
	     
	    public static void normalFindContent(File file,String str) {
	        File[]files=file.listFiles();
	        if(null==files) {
	            System.out.println("当前目录为空！");
	            return;
	        }
	        for(File f1:files) {
	            if(f1.isDirectory()) {
	                normalFindContent(f1, str);
	            }
	            else if(f1.getName().endsWith(".java")){
	                try(FileReader fileReader=new FileReader(f1)){
	                    char[]cs=new char[(int)f1.length()];
	                    fileReader.read(cs);
	                    String string=String.valueOf(cs);
	                    if(string.contains(str)) {
	                        System.out.println("找到含有字符串"+str+"的java文件"+",文件名称为"+f1.getName());
	                    }
	                }
	                catch (IOException e) {
	                    // TODO: handle exception
	                    e.printStackTrace();
	                }
	            }
	        }
	    }
	 

}
