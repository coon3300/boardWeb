package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;
import com.yedam.vo.StudentVO;

public interface StudentMapper {
	List<StudentVO> studentList();
	
	StudentVO selectOne(String sno);

	int insertStudent(StudentVO svo);
	int deleteStudent(String stdNo);
	
	// 로그인 체크.
	// mapper.xml에 2개 이상 매개변수로 전달할 때 @Param 사용
	// 클래스 필드 2개 이상 포함하는 객체를 전달할 경우는 매개변수로 객체 1개 전달
	MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	List<MemberVO> selectUser(@Param("res") String res, @Param("orderBy") String orderBy);
	
	// 차트 (작성자별 건수)
	List<Map<String, Object>> selectCountByMember();
}
