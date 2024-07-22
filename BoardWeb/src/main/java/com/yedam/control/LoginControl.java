package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// id, pw 파리미터 => 게시글 목록 or 로그인 화면
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		MemberService svc = new MemberServiceImpl();
		if(svc.loginCheck(id, pw)) {
			
			// 세션 객체(attribute)
			HttpSession session = req.getSession();
			session.setAttribute("logid", id);
			session.setMaxInactiveInterval(30 * 60); // 초 단위, 0: 무제한
			
			
			resp.sendRedirect("boardList.do"); // 객체 전달 없음
		}else {
			// msg를 "아이디와 비번을 확인하세요!";
			req.setAttribute("msg", "아이디와 비번을 확인하세요!");
	        req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp); // 객체 전달 가능

		}
	}

}
