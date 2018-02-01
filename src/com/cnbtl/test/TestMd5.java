package com.cnbtl.test;

import org.junit.Test;

import com.cnbtl.util.AppMD5Util;

public class TestMd5 {
	
	@Test
	public void testMd5() {
		String password = "1314520";
		System.out.println("after encoding-->" + AppMD5Util.MD5(password));
		System.out.println("after encoding with salt-->" + AppMD5Util.md5Password(password));
	}
}
