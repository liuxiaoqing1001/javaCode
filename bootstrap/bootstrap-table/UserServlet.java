package com.isoft.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isoft.dao.User2Dao;
import com.isoft.db.SqlSesionnUtils;
import com.isoft.entity.User2;
import com.isoft.service.User2Service;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServlet.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    User2Service userService ;
    Map<String , Object> resultMap ;
    public UserServlet() {
        super();
        userService = new User2Service() ;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		String from = request.getParameter("from") == null ? "" :  request.getParameter("from");		
		switch(from.toLowerCase()) {
		case "delone" :
			delOne(request , response) ;
			break;
		case "delmore" :
			delMore(request , response) ;
			break;
		case "edit" :
			update(request , response);
			break;
		case "add" :
			add(request , response) ;
			break;
		case "namecheck" :
			namecheck(request , response) ;
			break;
		default : 
			select(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request , response);
	}
	private void namecheck(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name") ;
		System.out.println(name);
		resultMap = new HashMap<>();
		resultMap.put("valid", ! userService.nameExists(name)) ;		
		response.getWriter().print(jsonSerializable(resultMap));
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name") ;
		String email = request.getParameter("email") ;
		String pass = request.getParameter("pass") ;
		resultMap.put("addResult", userService.add(new User2(name, pass, email))) ;
		
		response.getWriter().print(jsonSerializable(resultMap));
	}
	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("editId") ;
		String email = request.getParameter("email") ;
		String status = request.getParameter("status") ;
		System.out.println(id + "," + email + "," + status);
		resultMap = new HashMap<>();		
		resultMap.put("updateResult", userService.update(new User2(Integer.parseInt(id) , null , email , Integer.parseInt(status)))) ;
		
		response.getWriter().print(jsonSerializable(resultMap));
	}
	private void delMore(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String ids = request.getParameter("ids") ;
		String[] temp = ids.split(",") ;
		
		int[] idsInt = new int[temp.length];
		for(int i = 0 ;i < temp.length ;i++) {
			idsInt[i] = Integer.parseInt(temp[i]) ;
		}
		resultMap = new HashMap<>();
		resultMap.put("delResult", userService.delByIds(idsInt)) ;
		
		response.getWriter().print(jsonSerializable(resultMap));
	}
	private void delOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id") ;		
		resultMap = new HashMap<>();
		resultMap.put("delResult", userService.delById(Integer.parseInt(id))) ;
		
		response.getWriter().print(jsonSerializable(resultMap));
	}
	private void select(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String size = request.getParameter("pageSize") ;
		String page = request.getParameter("pageNumber") ;
		String nameKey = request.getParameter("nameKey") ;
		String emailKey = request.getParameter("emailKey") ;
		String active = request.getParameter("status") ;
		String sortName = request.getParameter("sortName") ;
		String sortOrder = request.getParameter("sortOrder") ;
		Map<String , Object> map = new HashMap<>() ;
		if(null != sortName && sortName.length() > 0) {
			map.put(User2Dao.KEY_SORTNAME , sortName) ;			
			if(null != sortOrder && sortOrder.length() > 0) {
				map.put(User2Dao.KEY_SORTORDER, sortOrder) ;
			}
		}
		if(null != page && page.length() > 0) {
			map.put(User2Dao.KEY_PAGE, Integer.parseInt(page)) ;
		} else {
			map.put(User2Dao.KEY_PAGE, 1) ;
		}
		if(null != size && size.length() > 0) {
			map.put(User2Dao.KEY_SIZE, Integer.parseInt(size)) ;
		} else {
			map.put(User2Dao.KEY_SIZE, 2) ;
		}
		if(null != nameKey && nameKey.length() > 0) {
			map.put(User2Dao.KEY_NAMEKEY, nameKey) ;
		}
		if(null != emailKey && emailKey.length() > 0) {
			map.put(User2Dao.KEY_EMAILKEY, emailKey) ;
		}
		if(null != active && "-1" != active) {
			map.put(User2Dao.KEY_ACTIVE, Integer.parseInt(active)) ;
		}
				
		List<User2> list = userService.getUsers(map);
		int count = userService.getCount(map) ;
		Map<String , Object> userMap = new HashMap<>();
		userMap.put("total", count) ;
		userMap.put("rows", list) ;
		response.getWriter().print(jsonSerializable(userMap));
	}
	
	private String jsonSerializable(Object obj) {
		ObjectMapper objMapper = new ObjectMapper() ;
		try {
			String str = objMapper.writeValueAsString(obj) ;
			System.out.println(str);
			return str ;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null ;
	}

}
