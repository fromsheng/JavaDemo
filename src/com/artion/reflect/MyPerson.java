package com.artion.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

import net.sf.json.JSONObject;



public class MyPerson {
	
	public static Object getInstance(String className, JSONObject json) {
		if(json == null) {
			return null;
		}
		 Class<?> clazz = null;
	        Field[] fields = null;
	        Object o = null;
	        try {
	            clazz = Class.forName(className);
	            fields = clazz.getDeclaredFields(); // 取得类中的全部属性
	            o = clazz.newInstance();
	            // 传入的参数长度与生产的实例属性个数不一样
	            Object item = null;
	            for (int i = 0; i < fields.length; i++) {
	                fields[i].setAccessible(true);
	                System.out.println("fields name == " + fields[i].getName());
	                Type type = fields[i].getType(); // 获得每个字段的类型
	                item = json.opt(fields[i].getName());
	                System.out.println("item value == " + item);
	                String in = item.getClass().getName();
	                Class<?> cIn = Class.forName(in); // 获得每个传入参数的类型
	                // 相对应的参数类型不一样
//	                if (!type.equals(cIn)) {
//	                    return null;
//	                }
	                fields[i].set(o, item);
	 
	 
	            }
	        } catch (ClassNotFoundException e) {
	            System.out.println("找不到这个类...");
	            e.printStackTrace();
	        } catch (InstantiationException e) {
	            e.printStackTrace();
	        } catch (IllegalAccessException e) {
	            e.printStackTrace();
	        } catch (SecurityException e) {
	            e.printStackTrace();
	        }
	 
	        return o;
	}
    
    /**
     * 通过传入类的全限定名和成员属性值生成实例
     * @param className
     * @param params
     * @return
     */
    public static Object getInstance(String className, Object... params) {
        Class<?> clazz = null;
        Field[] fields = null;
        Object o = null;
        try {
            clazz = Class.forName(className);
            fields = clazz.getDeclaredFields(); // 取得类中的全部属性
            o = clazz.newInstance();
            // 传入的参数长度与生产的实例属性个数不一样
            if (params.length != fields.length) {
                return null;
            }
            for (int i = 0; i < fields.length; i++) {
                fields[i].setAccessible(true);
                System.out.println(fields[i].getName());
                Type type = fields[i].getType(); // 获得每个字段的类型
                String in = params[i].getClass().getName();
                Class<?> cIn = Class.forName(in); // 获得每个传入参数的类型
                // 相对应的参数类型不一样
                if (!type.equals(cIn)) {
                    return null;
                }
                fields[i].set(o, params[i]);
 
                // Method method=clazz.getMethod("setName");
                // method.invoke(o, params[0]);
                // Method method2=clazz.getMethod("setAge");
                // method2.invoke(o, params[1]);
 
                // ((Person) o).setName((String)params[0]);
                // ((Person) o).setAge((Integer) params[1]);
 
            }
        } catch (ClassNotFoundException e) {
            System.out.println("找不到这个类...");
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
 
        return o;
    }
 
    public static void main(String[] args) {
//        Person o = (Person) MyPerson.getInstance("Person", "haha", 20);
    	System.out.println(Person.class.getName());
        Person o = (Person) MyPerson.getInstance(Person.class.getName(), "haha", new Integer(20));
        System.out.println(o.toString());
        
        System.out.println("-----------------------------------------");
        
        JSONObject json = new JSONObject();
        json.put("age", 22);
        json.put("name", "fadsfas");
        System.out.println(json.toString());
        o = (Person) getInstance(Person.class.getName(), json);
        System.out.println(o.toString());
    }
}
 
class Person {
    private String name;
    private Integer age;    // 写成基本类型 int型时报错...
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
 
    
}
