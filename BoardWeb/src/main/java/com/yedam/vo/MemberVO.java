package com.yedam.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class MemberVO{
	private String memberId;
	private String memberPw;
	private String memberNm;
	private String responsibility;
}
