package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.common.SearchVO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        // 요청 파라미터에서 페이지 번호를 가져옴.
		String page = req.getParameter("page");
		
        // 페이지 번호가 null인 경우 기본값 "1" 설정
		page = page == null ? "1" : page;
		
        // 요청 파라미터에서 검색 조건과 키워드 가져옴
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
        // 검색 조건과 키워드를 담는 SearchVO 객체 생성
		SearchVO search = new SearchVO();
		search.setKeyword(kw);
		search.setPage(Integer.parseInt(page));
		search.setSearchCondition(sc);
		
        // BoardService 객체 생성.
		BoardService svc = new BoardServiceImpl();
		
        // 검색 조건에 맞는 게시글 목록 가져옴
		List<BoardVO> list = svc.boardList(search);
		
        // 요청 객체에 게시글 목록 속성 추가
		req.setAttribute("boardList", list);
		
        // 전체 게시글 수를 가져와 페이징 처리를 위한 PageDTO 객체 생성.
		int totalCnt = svc.totalCount(search);
		PageDTO pageDTO = new PageDTO(Integer.parseInt(page),totalCnt);
		req.setAttribute("paging", pageDTO);
		req.setAttribute("keyword", kw);
		req.setAttribute("searchCondition", sc);
		
//        // boardList.jsp로 포워딩.
//		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp") //
		req.getRequestDispatcher("board/boardList.tiles") //
		.forward(req, resp); // 페이지 재지정.
	}
}
