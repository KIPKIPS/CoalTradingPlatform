
package com.isscollege.users.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.isscollege.users.entity.Company_File;
import com.isscollege.users.entity.Login_Info;
import com.isscollege.users.entity.Question;
import com.isscollege.users.entity.Trade_Account;
import com.isscollege.users.utils.MD5;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TraderDaoTest {

	@Autowired
	private TraderDao traderDao;

	// 用户退出测试
	@Test
	public void input_Login_Info_result_1() {
		Login_Info trader = new Login_Info();
		trader.setuID(1);
		trader.setLoginState("0");
		int i = traderDao.logout(trader);
		assertEquals(1, i);
	}

	@Test
	public void input_Login_Info_result_NotNull() {
		Login_Info trader = new Login_Info();
		trader.setuName("aaa");
		trader.setuPass(new MD5().getMD5ofStr("123456"));
		Login_Info tempTrader = traderDao.login(trader);
		assertNotNull(tempTrader);
	}
	//普通用户注册测试
	@Test
	public void registtotb_login_infoTest() {
		Login_Info trader = new Login_Info();
		trader.setuName("龙哥");
		trader.setuPass("123456");
		Integer expect=1;
		assertEquals(expect, traderDao.registtotb_login_info(trader));
	}
	@Test
	public void registtotb_trade_accountTest() {
		Trade_Account trade_account=new Trade_Account(0,"谢广坤", "15664716754", "谢飞机", "15664716754", "1348776645@qq.com",
				"西安某公司", "买家", "刘能", "43526172837465435X", "陕西西安", "1348776645@qq.com",
				"1", "1", 20.0, "1", "买家", "1",
				"12313","123", "12314", "1", "1", "a",
				"a");
		Integer expect=1;
		assertEquals(expect, traderDao.registtotb_trade_account(trade_account));
	}
	@Test
	public void registtotb_company_fileTest(){
		Company_File company_file=new  Company_File("aaa/qwda.jpg", "aaa/qwda.jpg", "aaa/qwda.jpg", "aaa/qwda.jpg", "aaa/qwda.jpg",
				"aaa/qwda.jpg", 0);
		Integer expect=1;
		assertEquals(expect, traderDao.registtotb_company_file(company_file));
		
	}
	@Test
	public void registtotb_questionTest(){
		Question question=new Question();
		question.setcAnswer("0101");
		question.setcQuestion("你的生日?");
		Integer expect=1;
		assertEquals(expect, traderDao.registtotb_question(question));
	}
	@Test
	public void isExist(){
		Login_Info trader = new Login_Info();
		trader.setuName("112233");
		trader.setuPass(new MD5().getMD5ofStr("123456"));
		Login_Info tempTrader = traderDao.isExist(trader);
		assertNotNull(tempTrader);	
	}
	@Test
	public void isExistCom(){
		Trade_Account trade_account=new Trade_Account();
		trade_account.setcName("小米");
		assertNotNull(traderDao.isExistCom(trade_account));
	}
	@Test
	public void isrightTest(){
		Question question=new Question("您的出生地在哪里？","1212",1);
		assertNotNull(traderDao.isright(question));
	}
	@Test
	public void modifypasswordTest(){
		Login_Info trader = new Login_Info();
		trader.setuName("112233");
		trader.setuPass(new MD5().getMD5ofStr("111111"));
		Integer expect=1;
		assertEquals(expect,traderDao.modifypassword(trader));
	}
	
}
