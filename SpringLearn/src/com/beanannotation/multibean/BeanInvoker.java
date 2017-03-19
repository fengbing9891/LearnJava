package com.beanannotation.multibean;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.parsing.BeanEntry;
import org.springframework.stereotype.Component;

/**
 * 用@Autowired 注解list，map类型
 * @author WBF
 *
 */
@Component
public class BeanInvoker {
	
	@Autowired
	private List<BeanInterface> list;
	
	@Autowired
	private Map<String,BeanInterface> map;
	
	@Autowired
	@Qualifier("beanOneImpl")
	private BeanInterface beanInterface;

	public void say(){
		if(list != null && list.size() > 0){
			System.out.println("list...");
			for (BeanInterface beanInterface : list) {
				System.out.println(beanInterface.getClass().getName());
			}
		}else{
			System.out.println("List<BeanInterface> is null");
		}

		System.out.println();
		
		if(map != null && map.size() > 0){
			System.out.println("map...");
			for (Map.Entry<String, BeanInterface> entry : map.entrySet()) {
				System.out.println(entry.getKey() + "      "  + entry.getValue().getClass().getName());
			}
		}else{
			System.out.println("Map<String,BeanInterface> is null");
		}
		
		System.out.println("");
		
		if(beanInterface != null){
			System.out.println(beanInterface.getClass().getName());
		}else{
			System.out.println("beanInterface is null");
		}
		
		
	}
	
}
