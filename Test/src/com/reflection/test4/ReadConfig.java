/**
 * 
 */
package com.reflection.test4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.reflection.test2.ADHero;
import com.reflection.test2.APHero;
import com.reflection.test3.Hero;

/**
 * @author PE
 * @date 2019年7月2日 下午1:31:19
 * @explain 首先根据这个配置文件，使用反射实例化出两个英雄出来。 然后通过反射给这两个英雄设置名称，接着再通过反射，
 *          调用第一个英雄的attackHero方法，攻击第二个英雄
 */
public class ReadConfig {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException, NoSuchMethodException,
			IllegalArgumentException, InvocationTargetException {
		File file = new File("D:\\Download\\Test\\src\\com\\reflection\\hero.config");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String apstr = br.readLine();
		String apname = br.readLine();
		String adstr = br.readLine();
		String adname = br.readLine();
		Class apclass = Class.forName(apstr);
		Class adclass = Class.forName(adstr);
		APHero ap = (APHero) apclass.newInstance();
		ADHero ad = (ADHero) adclass.getConstructor().newInstance();

		Field apfield = apclass.getField("name");
		Field adfield = adclass.getField("name");
		apfield.set(ap, apname);
		adfield.set(ad, adname);
		/*
		 * System.out.println(ap); System.out.println(ad);
		 */
		System.out.format("ADHero name: %s %nAPhero name: %s %n", ad.name, ap.name);
		Method apattack = apclass.getMethod("attackHero", Hero.class);
		apattack.invoke(ap, ad);
		fr.close();
		br.close();

	}

}
