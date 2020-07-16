package com.parttime.util;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

@SuppressWarnings("all")
public class Conversion {
	/**
	 * @param obj
	 * @param request
	 */
	public static void convert(Object obj,HttpServletRequest request){
		try{
			//通过对象获取反射入口类Class
			Class clazz = obj.getClass();
			//获取所有的属性
			Field[] fields = clazz.getDeclaredFields();
			for(Field field : fields){
				//修改属性的访问权限
				field.setAccessible(true);
				//获取属性名
				String name = field.getName();
				//获取属性的类型
				Class<?> cls = field.getType();
				//判断类型是否为数组
				if(!cls.isArray()){
					//从请求中获取值
					String val = request.getParameter(name);
					if(val==null){
						continue;
					}
					//获取数据类型的字符串表示形式
					String type = cls.getName();
					if("int".equals(type) || "java.lang.Integer".equals(type)){
						field.set(obj, Integer.parseInt(val));
					}else if("double".equals(type) || "java.lang.Double".equals(type)){
						field.set(obj, Double.parseDouble(val) );
					}else if("float".equals(type) || "java.lang.Float".equals(type)){
						field.set(obj, Float.parseFloat(val) );
					}else if("java.util.Date".equals(type)){
						//2019-10-10
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						field.set(obj, sdf.parse(val));
					}else if("java.lang.String".equals(type)){
						field.set(obj, val);
					}
				}else{
					//从请求中获取一个数组
					String[] array = request.getParameterValues(name);
					if(array==null || array.length==0){
						continue;
					}
					if(int[].class==cls || Integer[].class==cls){
						int[] vals =  new int[array.length];
						for(int i=0;i<array.length;i++){
							vals[i] = Integer.parseInt(array[i]);
						}
						field.set(obj, vals);
					}else if(double[].class==cls || Double[].class==cls){
						double[] vals =  new double[array.length];
						for(int i=0;i<array.length;i++){
							vals[i] = Double.parseDouble(array[i]);
						}
						field.set(obj, vals);
					}else if(float[].class==cls || Float[].class==cls){
						float[] vals =  new float[array.length];
						for(int i=0;i<array.length;i++){
							vals[i] = Float.parseFloat(array[i]);
						}
						field.set(obj, vals);
					}else if(Date[].class==cls){
						Date[] vals =  new Date[array.length];
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						for(int i=0;i<array.length;i++){
							vals[i] = sdf.parse(array[i]); 
						}
						field.set(obj, vals);
					}else if(String[].class==cls){
						field.set(obj, array);
					}
					
				}
				
			}
		}catch(Exception e){
			e.printStackTrace();	
		}
		
	}
	
	
}











