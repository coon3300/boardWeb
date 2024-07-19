package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchVO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

/**
 * 인터페이스(BoardServiceImpl)을 구현하는 구현객체.
 * 인터페이스에 정의된 메소드를 다 구현해야함.
 */

public class BoardServiceImpl implements BoardService{

	SqlSession sqlSession = DataSource.getInstance().openSession(true); // 자동 커밋.
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
//	@Override
//	public List<BoardVO> boardList(int page) {
//		return mapper.selectListPaging(page);
//	}
	@Override
	public List<BoardVO> boardList(SearchVO search) {
		return mapper.selectListPaging(search);
	}

//	@Override
//	public int totalCount() {
//		return mapper.selectTotalCount();
//	}
	@Override
	public int totalCount(SearchVO search) {
//		return mapper.selectTotalCount();
		return mapper.selectTotalCount(search);
	}
	
//	@Override
//	public List<BoardVO> boardList(int page) {
//		return mapper.selectListPaging(page);
//	}	
	
	@Override
	public boolean addBoard(BoardVO board) {
		return mapper.insertBoard(board) == 1;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.updateBoard(board) == 1;
	}

	@Override
	public boolean removeBoard(int boardNo) {
		return mapper.deleteBoard(boardNo) == 1;
	}

	@Override
	public BoardVO getBoard(int boardNo) {
		// TODO Auto-generated method stub
		return mapper.selectBoard(boardNo);
	}
	
	

}
