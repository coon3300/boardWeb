package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchVO;
import com.yedam.mapper.StudentMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public class MemberServiceImpl implements MemberService{

	SqlSession sqlSession = DataSource.getInstance().openSession(true); // 자동 커밋.
	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
	
	@Override
//	public boolean loginCheck(String id, String pw) {
	public MemberVO loginCheck(String id, String pw) {
//		return mapper.selectMember(id, pw) == 1;
		return mapper.selectMember(id, pw);
	}
	
	@Override
	public List<MemberVO> userList(String res, String order) {
		return mapper.selectUser(res, order);
	}

	
}
