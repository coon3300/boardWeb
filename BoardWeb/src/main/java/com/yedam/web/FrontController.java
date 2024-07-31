package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.ActionControl;
import com.yedam.control.AddBoardControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AddStudent;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardForm;
import com.yedam.control.BoardListControl;
import com.yedam.control.CntByMember;
import com.yedam.control.DeleteBoard;
import com.yedam.control.GoogleChart;
import com.yedam.control.ImageDownload;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginForm;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.StudentListControl;
import com.yedam.control.UpdateBoard;
import com.yedam.control.ModifyBoard;
import com.yedam.control.PagingCount;
import com.yedam.control.RemoveBoard;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.RemoveStudent;
import com.yedam.control.ReplyListControl;
import com.yedam.control.ScriptControl;
import com.yedam.control.StudentJson;

/**
 * FrontController 역할은 사용자의 모든 요청을 처리.
 * 서블릿. a.do, sample.do, ... *.do
 * 객체생성 -> init -> service -> destory.
 */

public class FrontController extends HttpServlet{
	
	//			Control 인터페이스 타입의 맵
	Map<String, Control> map ;

	public FrontController() {
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/boardList.do", new BoardListControl());
		// 글등록 구현: 등록화면(boardForm.do) + DB등록(addBoard.do) -> 글 목록 페이지 이동.
		map.put("/boardForm.do", new BoardForm());
		map.put("/addBoard.do", new AddBoardControl());
		
		// 상세화면
		map.put("/board.do", new BoardControl());
		
		// 삭제
		map.put("/removeBoard.do", new RemoveBoard());	//삭제화면
		map.put("/deleteBoard.do", new DeleteBoard());	//삭제처리

		// 수정
		map.put("/modifyBoard.do", new ModifyBoard());	//수정화면
		map.put("/updateBoard.do", new UpdateBoard());	//수정처리
		
		// 로그인.
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		
		
		// 학생목록.
		map.put("/stdList.do", new StudentListControl());

		// 태그연습.
		map.put("/action.do", new ActionControl());
		
		// 관리자가 사용하는 기능들... ex) 회원목록...
		map.put("/memberList.do", new MemberListControl());
		
		// 자바 스크립트 연습하는 페이지 호출.
		map.put("/javascript.do", new ScriptControl());
		
		// 학생정보를 반환해주는 페이지(json).
		map.put("/studentJson.do", new StudentJson());
		
		// 학생정보(학번기준) 삭제.
		map.put("/removeStudent.do", new RemoveStudent());
		
		// 등록.
		map.put("/addStudent.do", new AddStudent());
		
		// 목록.
		map.put("/replyList.do", new ReplyListControl());
		// 등록.
		map.put("/addReply.do", new AddReplyControl());
		// 삭제.
		map.put("/removeReply.do", new RemoveReplyControl());
		
		// 페이징을 위한 전체건수.
		map.put("/pagingCount.do", new PagingCount());
		
		// 이미지 다운로드.
		map.put("/imageDownload.do", new ImageDownload());
		
		// 작성자별 게시건수.
		map.put("/countByMember.do", new CntByMember());
		
		// 차트페이지
		map.put("/googleChart.do", new GoogleChart());
		
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
        // 예를 들어, boardList.do: 목록, addBoard.do: 등록과 같은 요청을 처리합니다.
		String uri = req.getRequestURI(); // URL(http://localhost/BoardWeb/boardList.do) vs. URI(BoardWeb/*.do)
		String context = req.getContextPath(); // 프로젝트 명.(/BoardWeb)
		String path = uri.substring(context.length()); // "/*.do"
		
		System.out.println("uri : " + uri);
		System.out.println("context : " + context);
		System.out.println("path : " + path);
		
        // 요청에 해당하는 Control 객체를 맵에서 찾아서 실행합니다.
		Control sub = map.get(path);
		sub.exec(req, resp);
		
	}
	
}
