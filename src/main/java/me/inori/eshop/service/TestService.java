package me.inori.eshop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import me.inori.eshop.entity.test.Test;

@Service
public interface TestService {
	
	public void insertTest(Test item);
	
	public void rollbackTest0(int idin,int idout,int money);
	
	public void rollbackTest1(List<Test> list);
}
