package org.wingame;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtils {
	
	public static String getMD5(String str){
		try {
			MessageDigest digest = MessageDigest.getInstance("md5");
			digest.update(str.getBytes());
			byte[] bytes = digest.digest();
			return CommonUtils.getHexString(bytes);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	private static String getHexString(byte[] bytes){
		if(bytes == null) return null;
		StringBuffer strBuf = new StringBuffer(bytes.length * 2);
		for(int i = 0;i < bytes.length;i++){
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if(hex.length() == 2) strBuf.append(hex);
			else strBuf.append("0" + hex);
		}
		return strBuf.toString();
	}
	
	public static String getRandomPassword(int length) {
		final String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append(chars.charAt((int) (Math.random() * chars.length())));
		}
		return sb.toString();
	}
}
