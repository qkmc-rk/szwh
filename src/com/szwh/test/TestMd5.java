package com.szwh.test;

import org.junit.Test;

import com.szwh.util.AppMD5Util;

public class TestMd5 {
	
	@Test
	public void testMd5() {
		String password = "sz123456";
		System.out.println("after encoding-->" + AppMD5Util.MD5(password));
		System.out.println("after encoding with salt-->" + AppMD5Util.md5Password(password));
	}
}
