package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchVO;
import com.yedam.mapper.StudentMapper;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

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
	public List<MemberVO> memberList(String res, String order) {
		return mapper.selectUser(res, order);
	}

	@Override
	public List<StudentVO> studentList() {
		return mapper.studentList();
	}

	@Override
	public boolean removeStudent(String sno) {
		return mapper.deleteStudent(sno) == 1;
	}

	@Override
	public boolean addStudent(StudentVO svo) {
		return mapper.insertStudent(svo) == 1;

	}

	
}
