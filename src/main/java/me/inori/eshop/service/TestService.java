package me.inori.eshop.service;

import org.springframework.stereotype.Service;

import me.inori.base.entity.ReturnValue;
import me.inori.eshop.entity.test.Test;

@Service
public interface TestService {
	
	public void insertTest(Test item,ReturnValue rtv);
	
	public void rollbackTest0(int idin,int idout,int money,ReturnValue rtv);
}
