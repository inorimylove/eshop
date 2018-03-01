package me.inori.eshop.dao;

import org.springframework.stereotype.Repository;

import me.inori.eshop.entity.test.Test;
import me.inori.eshop.entity.test.TestRollBack;
@Repository
public interface TestDao {
	public Test searchTest(Test item);
	
	public void insertTest(Test item);
	
	public void inMoney(TestRollBack item);
	public void outMoney(TestRollBack item);
}
