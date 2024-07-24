package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchVO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.MemberVO;

public interface MemberService {
//	boolean loginCheck(String id, String pw);
	MemberVO loginCheck(String id, String pw);
	
	List<MemberVO> memberList(String res, String order);
	
}
