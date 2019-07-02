/**
 * 
 */
package com.java.list.arraylist;

import java.util.ArrayList;

import com.java.stringbuffer.IStringBuffer;

/**
 * @author PE
 * @date 2019年6月26日 下午4:12:24
 * @explain 自定义ArrayList实现
 */
public class MyArrayListBuffer implements IStringBuffer{
	 public int length = 0;
	    public int capacity = 16;
	    public ArrayList<Character> value = new ArrayList<Character>();
	     
	    public MyArrayListBuffer(String s){
	        if(null != s){
	            for (int i = 0; i < s.length(); i++)
	            {
	                this.value.add(new Character(s.charAt(i)));
	            }
	            this.length = s.length();
	            this.capacity = this.length + capacity;               
	        }
	        else{
	            this.value = null;
	        }
	    }
	     
	    public MyArrayListBuffer(){
	        this.value = null;
	    }
	     
	    @Override
	    public void append(String str) throws Exception
	    {
	        insert(this.length,str);
	    }
	 
	    @Override
	    public void append(char c) throws Exception
	    {
	        append(String.valueOf(c));
	    }
	 
	    @Override
	    public void insert(int pos, char b) throws Exception
	    {
	        insert(pos,String.valueOf(b));
	    }
	 
	    @Override
	    public void insert(int pos, String b) throws Exception
	    {
	        if(pos<0 || pos>this.length)  {
	            System.out.println("插入位置不合理");
	            return;
	        }
	        if(null == b)       {
	            System.out.println("插入的字符串为空");
	            return;
	        }
	         
	        this.length += b.length();
	        this.capacity += this.length;
	         
	        for (int i = pos,j = 0; i < b.length() + pos; i++,j++)
	        {
	            this.value.add(i,b.charAt(j));
	        }
	    }
	 
	    @Override
	    public void delete(int start)
	    {
	        delete(start,this.length);
	    }
	 
	    @Override
	    public void delete(int start, int end)
	    {
	        if(start < 0 || start > this.length - 1 || end < 0)        System.out.println("删除位置不合理");
	        this.length -= (end - start);
	        this.capacity += this.length;
	         
	        for (int i = start; i < end; i++)
	        {
	            this.value.remove(start);
	        }
	    }
	 
	    @Override
	    public void reverse()
	    {
	        char temp;
	        for (int i = 0; i < value.size() / 2; i++)
	        {
	            temp = value.get(i);
	            value.set(i, value.get(value.size()-i-1));
	            value.set(value.size()-i-1, temp);
	        }
	    }
	 
	    @Override
	    public int length()
	    {
	        return this.length;
	    }
	 
	    public String toString(){
	        Character[] ch = (Character[])this.value.toArray(new Character[]{});
	        char[] c = new char[ch.length];
	        for (int i = 0; i < c.length; i++)
	        {
	            c[i] = ch[i];
	        }
	        String s = new String(c);
	        return s;
	    }
	     
}
