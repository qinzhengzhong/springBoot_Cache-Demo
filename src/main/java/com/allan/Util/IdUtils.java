package com.allan.Util;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * 封装各种生成唯一性ID算法的工具类.
 * 
 * @author qinzz
 */
public abstract class IdUtils {

	private static SecureRandom random = new SecureRandom();

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成,中间有-分割
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 使用SecureRandom随机生成Long. 
	 */
	public static long randomLong() {
		return random.nextLong();
	}

	/**
	 * 基于Base62编码的随机生成Long.
	 */
	public static String randomBase62() {
		return EncodeUtils.base62Encode(random.nextLong());
	}
	public static void main(String[] args) {
		System.out.println(uuid());
		System.out.println(randomLong());
		System.out.println(randomBase62());
		System.out.println(UUID.randomUUID().getMostSignificantBits());
	}
}
