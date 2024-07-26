package com.yedam.common;

import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.SqlSession;

import com.yedam.mapper.ReplyMapper;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
	
	public static void main(String[] args) {
		/**
//		SqlSession sqlSession = DataSource.getInstance().openSession();
		SqlSession sqlSession = DataSource.getInstance().openSession(true); // 자동 커밋.
		
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//		mapper.studentList();
//		mapper.studentList().forEach(student -> {
//			System.out.println(student);
//		});
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		BoardVO brd = new BoardVO();

		// select
//		mapper.BoardList();
//		mapper.BoardList().forEach(student -> {
//			System.out.println(student);
//		});		
		
		
//		// insult
//		brd.setTitle("매퍼테스트");
//		brd.setContent("조건이 제대로 되는 지");
//		brd.setWriter("newbie");
//		if(mapper.insertBoard(brd) == 1) {
//			System.out.println("ok");
//		}
		
//		// update
//		brd.setBoardNo(22);
//		brd.setTitle("매퍼 업데이트");
//		brd.setContent("정보 갱신");
//		if(mapper.updateBoard(brd) == 1) {
//			System.out.println("ok");
//		}		
		
//		// delete
////		brd.setBoardNo(22);
//		if(mapper.deleteBoard(22) == 1) {
//			System.out.println("ok");
//		}				
//		
//		
//		// 출력부
//		mapper.selectList().forEach(board -> System.out.println(board.toString()));
		
		
		BoardService svc = new BoardServiceImpl();
//		svc.boardList().forEach(svc -> System.out.println(svc));
//		svc.boardList().forEach(System.out::println);
//		System.out.println("- End -");
		
//		svc.boardList(2).forEach(System.out::println);
		
		SearchVO search = new SearchVO();
//		search.setSearchCondition("T");
//		search.setKeyword("test");
//		search.setPage(1);
		
//		search.setSearchCondition("W");
//		search.setKeyword("chacha");
//		search.setPage(1);
		
		search.setSearchCondition("TW");
		search.setKeyword("웹은");
		search.setPage(1);
		
		svc.boardList(search).forEach(System.out::println);
		System.out.println("- End -");
		 * 
		 */
/**
		SqlSession sqlSession = DataSource.getInstance().openSession(true); // 자동 커밋.
		
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		
		ReplyService rvc = new ReplyServiceImpl();

		
		ReplyVO rvo = new ReplyVO();
		rvo.setReplyContent("등록 연습");
		rvo.setReplyer("user03");
		rvo.setBoardNo(171);
				
		if(rvc.removeReply(1)) {
			System.out.println("삭제완료!");
		}

		rvc.replyList(171).forEach(System.out::println);
		System.out.println("-- end --");
 * 		
 */
		ReplyService svc = new ReplyServiceImpl();
		
		SearchVO search = new SearchVO();
		search.setBno(170);
		search.setPage(1);
		
		svc.replyList(search).forEach(System.out::println);
		
		System.out.println("-- end --");
		
	}
}
