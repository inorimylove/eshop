package me.inori.eshop.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import me.inori.base.Utils.JsonUtils;
import me.inori.base.Utils.ToolUtils;
import me.inori.base.entity.ReturnValue;
import me.inori.eshop.dao.TestDao;
import me.inori.eshop.entity.test.Test;
import me.inori.eshop.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping(value = "/test")
	@ResponseBody
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/jsp/test/test.jsp");
		Test item = new Test();
		try {
			item.setId(1);
			Test test=testDao.searchTest(item);
			mv.addObject("name", test.getName());
			return mv;	
		} catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("redirect:index.jsp");
		}
		return mv;
	}

	@RequestMapping(value = "/create")
	@ResponseBody
	public ReturnValue create(@RequestBody String param) {
		ReturnValue rtv=new ReturnValue();
		rtv.setSuccess(false);
		Test test=JsonUtils.getBeanFromJson(param, Test.class);
		
		if(test.getId()!=0&&ToolUtils.StringNotEmpty(test.getName())){
		testService.insertTest(test,rtv);
		}
		return rtv;
	}
	
	@RequestMapping(value = "/rollback0")
	@ResponseBody
	public ReturnValue rollback0() {
		ReturnValue rtv=new ReturnValue();
		rtv.setSuccess(false);
		testService.rollbackTest0(1, 2, 200, rtv);
		
		return rtv;
	}
	

}
