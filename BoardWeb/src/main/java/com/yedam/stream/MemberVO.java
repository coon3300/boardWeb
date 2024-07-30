package com.yedam.stream;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 매개값 가지는 생성자
@NoArgsConstructor // 기본 생성자
public class MemberVO  implements Serializable{
	private int memberNo;
	private String memberName;
	private int point;
}
