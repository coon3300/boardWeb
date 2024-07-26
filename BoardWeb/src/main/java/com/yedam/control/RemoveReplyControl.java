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
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// retCode:Success, retCode:Fail 작성.
		resp.setContentType("text/json;charset=utf-8");
		
		String rno = req.getParameter("rno");
		
		ReplyService svc = new ReplyServiceImpl();
		// retCode: Success, retVal: ReplyVO
		// retCode: Fail, retVal: null
		Map<String, Object> map = new HashMap<>();
		
		try {
			if(svc.removeReply(Integer.parseInt(rno))) {
				map.put("retCode", "Success");
			}
		}catch(Exception e) {
			// e.printStackTrace();
			map.put("retCode", "Fail");
		}
		// json문자열 생성.
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(map);
		
		resp.getWriter().print(json);		
		
	}

}
