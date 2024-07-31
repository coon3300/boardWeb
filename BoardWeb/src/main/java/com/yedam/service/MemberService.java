package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

public interface MemberService {
//	boolean loginCheck(String id, String pw);
	MemberVO loginCheck(String id, String pw);
	
	List<MemberVO> memberList(String res, String order);
	
	// 학생목록조회.
	List<StudentVO> studentList();
	boolean removeStudent(String sno);
	boolean addStudent(StudentVO svo);
	
	List<Map<String, Object>> getCountByMember();

}
