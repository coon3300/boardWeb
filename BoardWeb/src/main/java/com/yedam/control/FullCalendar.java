package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.CalendarVO;

public class FullCalendar implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		/*
			[{ "title":"sample", "start":"2023-01-05" }, { "title":"회의", "start":"2023-01-21T13:00:00", "end":"2023-01-21T16:00:00" }]
		 * 
			[
				{ "title":"sample", "start":"2023-01-05" }, 
				{ "title":"회의", "start":"2023-01-21T13:00:00", "end":"2023-01-21T16:00:00" }
			]
		 */

		BoardService svc = new BoardServiceImpl();
		List<CalendarVO> list = svc.calendarList();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(list);
		
        //resp.getWriter().print("[{ \"title\":\"sample\", \"start\":\"2023-01-05\" }, { \"title\":\"회의\", \"start\":\"2023-01-21T13:00:00\", \"end\":\"2023-01-21T16:00:00\" }]");
        resp.getWriter().print(json);
		
	}

}
