package com.beanannotation.multibean;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@order ��list�жԶ����������ֻ���������Ч����map��Ч
@Order(1)
@Component
public class BeanTwoImpl implements BeanInterface {

}
