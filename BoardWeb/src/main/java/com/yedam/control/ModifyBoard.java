package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoard implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청 파라미터에서 "bno" 값을 가져옴.
        String bno = req.getParameter("bno");
        
        // BoardService 인스턴스를 생성.
        BoardService svc = new BoardServiceImpl();
        
        // "bno" 값을 정수로 변환.
        BoardVO board = svc.getBoard(Integer.parseInt(bno));
        
        // 게시물 정보를 요청 속성에 저장.
        req.setAttribute("board", board);
        
        // modifyForm.jsp 페이지로 포워딩.
		req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);

	}

}
