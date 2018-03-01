package me.inori.base.Utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.microsoft.sqlserver.jdbc.SQLServerException;

public class ToolUtils {

	public static void OutStr(HttpServletResponse res, String str) {
		PrintWriter out = null;
		try {
			res.setHeader("Content-type", "text/json;charset=UTF-8");
			res.setCharacterEncoding("UTF-8");
			out = res.getWriter();
			out.print(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.close();
	}

	
	public static String GetErrorMessage(Exception e, String prefix) {
	  	String rtn = "";
	  	
	  	if (e.getCause() instanceof SQLServerException) {
	  		
				SQLServerException sex = (SQLServerException)e.getCause();
				switch (sex.getErrorCode()) 
				{
					case 18456:
						rtn = prefix + "数据库登录失败！";
						break;
						
					case 2627:
						rtn = prefix + "编号重复,请重新填写！";
						break;
						
					default:
						rtn = prefix + sex.getMessage();
						break;
				}
			}
	  	else if (e.getCause() instanceof java.sql.SQLException) {
	  		java.sql.SQLException oex = (java.sql.SQLException)e.getCause();
	  		
	  		switch (oex.getErrorCode()) 
				{
					case 17002:
						rtn = prefix + "数据库登录失败！";
						break;
						
					default:
						rtn = prefix + oex.getMessage();
						break;
				}
	  	}
			else 
				rtn = prefix + e.getMessage();
	  	
	  	return rtn.replace('"', '\'');
	  }
	
	
	public static boolean StringNotEmpty(String str){
		return str!=null&&!"".equals(str);
	}
	
}
