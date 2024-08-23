package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.CalendarVO;

public class RemoveCalendar implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		BoardService svc = new BoardServiceImpl();
		CalendarVO cvo = new CalendarVO();
		cvo.setTitle(title);
		cvo.setStart(start);
		cvo.setEnd(end);

		Map<String, Object> map = new HashMap<>();
		
		if(svc.removeCalendar(cvo)) {
			map.put("retCode", "Success");
		}else {
			map.put("retCode", "Fail");
		}
		
		//resp.setContentType("text/json;charset=utf-8");
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(map)); // 객체 -> json
	}

}