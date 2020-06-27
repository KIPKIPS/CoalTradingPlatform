package com.isscollege.users.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:Simona @date:2019年7月5日下午3:31:47
 * 
 * 
 */

/**
 * 银行卡号生成规则： 1. 19位数字 2. 前六位：发行者标识代码 62开头代表中国银联 这里默认使用 628362） 3.
 * 中间12位发卡行自定义，这里根据date类生成 4. 最后一位校验位，根据Luhn算法（Luhn algorithm）计算
 * 
 */
public class CreateUserAccount {

	/**
	 * 生成校验位
	 */
	public static String createCheckNum(String string) {

		int sum = 0;
		int length = string.length();
		int[] strArray = new int[length];
		for (int i = 0; i < length; i++) {
			strArray[length - i - 1] = Integer.parseInt(string.substring(length - i - 1, length - i));
			int digit = strArray[length - i - 1];

			if (i % 2 == 0)
				digit *= 2;
			sum += digit > 9 ? digit - 9 : digit;
		}
		int checkNum = 10 - (sum % 10);
		String checkNumString = Integer.toString(checkNum == 10 ? 0 : checkNum);

		return checkNumString;
	}

	public static String getAccountNumber() {

		String accountNumber = "628362";

		// 获取当前时间反转后截取前十一位
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		StringBuffer number2 = new StringBuffer(sdf.format(date));
		String reverseNumber2 = number2.reverse().toString();
		String newNumber2 = reverseNumber2.substring(0, 12);

		// 连接字符串
		accountNumber = accountNumber.concat(newNumber2);
		accountNumber = accountNumber.concat(createCheckNum(accountNumber));

		return accountNumber;
	}

}
