package me.inori.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import me.inori.base.Utils.ToolUtils;
import me.inori.base.common.Constant;
import me.inori.base.entity.ReturnValue;
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
	public void insertTest(Test item,ReturnValue rtv) {
		// TODO Auto-generated method stub
		try{
			testDao.insertTest(item);
			rtv.setMessage(Constant.STR_SAVE_S);
		}catch (Exception e){
			e.printStackTrace();
			rtv.setSuccess(false);
			rtv.setMessage(ToolUtils.GetErrorMessage(e, Constant.STR_SAVE_F));
		}
	}
	
	@Transactional
	@Override
	public void rollbackTest0(int idin, int idout, int money,ReturnValue rtv) {
		
		// TODO Auto-generated method stub
		TestRollBack item0 = new TestRollBack();
		item0.setId(idin);
		item0.setMoney(money);
		
		TestRollBack item1 = new TestRollBack();
		item1.setId(idout);
		item1.setMoney(money);
		
		try{
			testDao.inMoney(item0);
			int i = 1/0;
			testDao.outMoney(item1);
			rtv.setMessage(Constant.STR_SAVE_S);
		}catch (Exception e){
			e.printStackTrace();
			rtv.setSuccess(false);
			rtv.setMessage(ToolUtils.GetErrorMessage(e, Constant.STR_SAVE_F));
		}
	}


}
