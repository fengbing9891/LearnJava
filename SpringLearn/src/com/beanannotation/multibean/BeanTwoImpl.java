package com.beanannotation.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@order 在list中对对象进行排序，只针对数组有效，对map无效
@Order(1)
@Component
public class BeanTwoImpl implements BeanInterface {

}
