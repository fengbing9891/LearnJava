package com.dao.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		User user1 = new User();
		user1.setId(10);
		
		User user2 = new User();
		user2.setName("zhangxiaowu");
		
		User user3 = new User();
		user3.setEmail("111@qq.com,222@qq.com,333@qq.com");
		
		String sql1 = query(user1);
		String sql2 = query(user2);
		String sql3 = query(user3);
		
		System.out.println(sql1);
		System.out.println(sql2);
		System.out.println(sql3);
		
		Department dep1 = new Department();
		dep1.setAmount(1000);
		dep1.setDepName("互联网大数据部");
		System.out.println(query(dep1));
	}

	private static String query(Object obj) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Class c = obj.getClass();
		
		boolean isExist = c.isAnnotationPresent(Table.class);	//如果指定类型的注释存在于此元素上, 返回true，否则返回false
		if(!isExist){
			return null;
		}
		Table table = (Table) c.getAnnotation(Table.class);		//方法返回这个元素的注解指定类型
		String tableName = table.value();
		
		sb.append("select * from ").append(tableName).append(" where 1=1 ");
		
		Field[] fArray = c.getDeclaredFields();
		for (Field field : fArray) {
			boolean isCExist = field.isAnnotationPresent(Column.class);
			if(!isCExist){
				continue;
			}
			Column column = (Column) field.getAnnotation(Column.class);
			String columnName = column.value();
			
			String fieldName = field.getName();

			Object fieldValue = null;
			String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			
			try {
				Method method = c.getMethod(getMethodName);
				fieldValue = method.invoke(obj);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if(fieldValue == null || (fieldValue instanceof Integer && (Integer)fieldValue == 0)){
				continue;
			}
			
			sb.append(" and ").append(columnName);
			
			if(fieldValue instanceof String){
				if(((String) fieldValue).contains(",")){
					sb.append(" in (");
					String[] values = ((String) fieldValue).split(",");
					for (String v : values) {
						sb.append("'").append(v).append("'").append(",");
					}
					sb.deleteCharAt(sb.length()-1);		//在这个序列中的指定位置删除字符
					sb.append(")");
				}else{
					sb.append("=").append("'").append(fieldValue).append("'");
				}
				
			}else if(fieldValue instanceof Integer){
				sb.append("=").append(fieldValue);
			}
			
		}
		
		return sb.toString();
	}
	
}












