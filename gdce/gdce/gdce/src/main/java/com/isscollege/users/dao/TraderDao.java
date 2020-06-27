package com.isscollege.users.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.users.entity.Company_File;
import com.isscollege.users.entity.Login_Info;
import com.isscollege.users.entity.Question;
import com.isscollege.users.entity.Trade_Account;

@Mapper
public interface TraderDao {
	// 用户退出登录
	@Update("update tb_login_info set loginState=#{loginState} where uID=#{uID}")
	public Integer logout(Login_Info trader);

	// 管理员登录
	@Select("select * from tb_login_info where uName=#{uName} and uPass=#{uPass}")
	public Login_Info login(Login_Info trader);

	// 用户注册
	// 添加到用户表
	@Insert("insert into tb_login_info (uName,uPass) value (#{uName},#{uPass})")
	public Integer registtotb_login_info(Login_Info trader);

	// 添加到用户详细信息表
	@Insert("insert into tb_trade_account (uRealName,uTelephone,muName,muTelephone,muMail,cName,cType,cLegalPerson,cLegalPersonID,cAddress,cEmile,cEasyName,cFax,cMoney,cBusinessLicense,cTax,cOrg,cBank,cBankAccount,cPermission,cResource,cTransport,cBrief,cPostalCode) value (#{uRealName},#{uTelephone},#{muName},#{muTelephone},#{muMail},#{cName},#{cType},#{cLegalPerson},#{cLegalPersonID},#{cAddress},#{cEmile},#{cEasyName},#{cFax},#{cMoney},#{cBusinessLicense},#{cTax},#{cOrg},#{cBank},#{cBankAccount},#{cPermission},#{cResource},#{cTransport},#{cBrief},#{cPostalCode})")
	public Integer registtotb_trade_account(Trade_Account trade_account);

	// 添加到资质信息表
	@Insert("insert into tb_company_file (cBusinessLicense,cTax,cOrg,cBank,cLegalPerson,cPermission,uID) value (#{cBusinessLicense},#{cTax},#{cOrg},#{cBank},#{cLegalPerson},#{cPermission},#{uID})")
	public Integer registtotb_company_file(Company_File company_file);

	// 添加到密保信息表
	@Insert("insert into tb_question (cQuestion,cAnswer,uID) value (#{cQuestion},#{cAnswer},#{uID})")
	public Integer registtotb_question(Question question);

	// 查找普通用户是否存在
	@Select("select * from tb_login_info where uName=#{uName}")
	public Login_Info isExist(Login_Info trader);

	// 查询用户名是否已存在
	@Select("select uName from tb_login_info where uName = #{uName}")
	public Integer select_uName_by_uName(String uName);

	// 判断是否已经存在该公司
	@Select("select * from tb_trade_account where cName=#{cName}")
	public Trade_Account isExistCom(Trade_Account trade_account);

	// 判断密保答案是否正确
	@Select("select * from tb_question where cQuestion=#{cQuestion} and cAnswer=#{cAnswer} and uID=#{uID}")
	public Question isright(Question question);

	// 修改密码
	@Update("update tb_login_info set uPass=#{uPass} where uName=#{uName}")
	public Integer modifypassword(Login_Info trader);

	// 更新企业详细信息
	@Update("update tb_trade_account set cName=#{cName},cLegalPerson=#{cLegalPerson},cLegalPersonID=#{cLegalPersonID},cAddress=#{cAddress},cEmile=#{cEmile},uTelephone=#{uTelephone},cFax=#{cFax},cPostalCode=#{cPostalCode},cMoney=#{cMoney},cBusinessLicense=#{cBusinessLicense},cOrg=#{cOrg},cPermission=#{cPermission},cTax=#{cTax},cBank=#{cBank},cBankAccount=#{cBankAccount},cResource=#{cResource},cTransport=#{cTransport},cBrief=#{cBrief} where uID=#{uID}")
	public Integer modifyInfo(Trade_Account trade_Account);

	// 查：企业详情表：tb_trade_account
	@Select("select * from tb_trade_account where uID=#{uID}")
	public Trade_Account showCompanyInfo(int uid);

	// 更新信息资质表
	@Update("update tb_company_file set ${arg0}=#{arg1} where uID=${arg2}")
	public Integer fileModify(String infoName, String path, Integer uID);

	// 根据用户ID查公司名称
	@Select("select cName from tb_trade_account where uID=#{uID}")
	public String getCompanyName(int uID);

	// 得到有用户信息注册状态的交易用户对象（1、只完成一级注册 2、进行了2级注册，但待审核 3、2级注册审核通过）
	@Select("select a.uID,a.loginState,a.uName,a.uPass,b.uState from tb_login_info as a ,tb_trade_account as b where a.uID = b.uID and a.uID = #{uID}")
	public Login_Info get_uState(int uID);

	// 判断账户信息是否存在(银行子系统)
	@Select("select * from tb_trade_account where cName=#{cName}")
	public Trade_Account doesTheAccountExist(String cName);

	// 将银行系统生成的账号插入到交易账户表
	@Update("update tb_trade_account set cBankAccount=#{cBankAccount} where cName=#{cName}")
	public Integer updateUserAccountInfoBycName(@Param("cName") String cName,
			@Param("cBankAccount") String cBankAccount);

}
