package me.inori.eshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import me.inori.base.Utils.ToolUtils;
import me.inori.base.common.Constant;
import me.inori.base.exception.MyException;
import me.inori.eshop.dao.TestDao;
import me.inori.eshop.entity.test.Test;
import me.inori.eshop.entity.test.TestRollBack;
import me.inori.eshop.service.TestService;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDao testDao;
	
	@Transactional
	@Override
	public void insertTest(Test item) {
		// TODO Auto-generated method stub
		try{
			testDao.insertTest(item);
		}catch (Exception e){
			e.printStackTrace();
			throw new MyException(ToolUtils.GetErrorMessage(e, Constant.STR_SAVE_F));
		}
	}
	
	@Transactional
	@Override
	public void rollbackTest0(int idin, int idout, int money) {
		
		// TODO Auto-generated method stub
		TestRollBack item0 = new TestRollBack();
		item0.setId(idin);
		item0.setMoney(money);
		
		TestRollBack item1 = new TestRollBack();
		item1.setId(idout);
		item1.setMoney(money);
		
		try{
			testDao.inMoney(item0);
//			int i = 1/0;
			testDao.outMoney(item1);
		}catch (Exception e){
			e.printStackTrace();
			throw new MyException(ToolUtils.GetErrorMessage(e, Constant.STR_SAVE_F));
		}
	}

	@Override
	public void rollbackTest1(List<Test> list) {
		// TODO Auto-generated method stub
		try{
			testDao.insertTest2(list);
		}catch (Exception e){
			e.printStackTrace();
//			throw new MyException(ToolUtils.GetErrorMessage(e, Constant.STR_SAVE_F));
		}
	}


}
