package com.yedam.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadFile {
	public static void main(String[] args) {
		String strPath = "https://image.oliveyoung.co.kr/uploads/images/goods/400/10/0000/0018/A00000018373109ko.jpg?l=ko";
		try {
			URL url = new URL(strPath);
			InputStream is = url.openStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			
			// 출력스트림.
			FileOutputStream fos = new FileOutputStream("c:/temp/image1.jpg");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			while(true) {
				int read = bis.read();
				if(read == -1) break;
				bos.write(read);
			}
			bos.flush();bos.close();
			fos.flush();fos.close();
			bis.close();is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("완료!!");
	}
}
