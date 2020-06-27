package com.isscollege.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetNumber {
	public static String getNumber(String id) {
		// 获取当前时间
		Date date = new Date();

		/*
		 * 格式化之后对日期进行处理
		 */
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// // 生成编号：当前时间（年月日时分秒+摘牌编号）
		// String number = sdf.format(date).replaceAll(":|-| ", "") + id;

		/*
		 * 直接按照所需格式进行格式化
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String number = sdf.format(date) + id;

		return number;
	}

	public static void main(String[] args) {
		System.out.println(getNumber("02"));
	}

}
