package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {

	public static SqlSessionFactory getInstance() {
        // MyBatis 설정 파일의 경로
		
		String resource = "config/mybatis-config.xml";	//cofig/
        // 설정 파일을 읽기 위한 InputStream 선언
		InputStream inputStream = null;
		
		try {
            // MyBatis 설정 파일을 리소스로부터 스트림으로 로드
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        // 설정 파일을 사용하여 SqlSessionFactory 빌드
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
        // SqlSessionFactory 인스턴스를 반환
		return sqlSessionFactory;
		
	}

}
