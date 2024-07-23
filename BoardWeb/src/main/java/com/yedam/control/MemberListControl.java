package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberService mvc = new MemberServiceImpl();
		
		String order = req.getParameter("order");
		
		// 정렬 기준이 null인 경우 기본값을 "member_id"로 설정.
		order = order == null ? "member_id" : order;
		
		List<MemberVO> list = mvc.userList("User", order);
		
        // 요청 객체에 게시글 목록을 속성으로 추가합니다.
		req.setAttribute("userList", list);
	
		req.getRequestDispatcher("admin/memberList.tiles").forward(req, resp);
	}

}
