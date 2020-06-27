package com.isscollege.users.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.users.entity.Uncheck_regist;

@Mapper
public interface regist_check_Dao {
	// 查询所有提交资料但未审核的用户
	@Select("select * from tb_trade_account where uState=2")
	public List<Uncheck_regist> list_uncheck_user();

	// 根据uid查询具体用户
	@Select("select * from tb_trade_account where uID=#{uid}")
	public Uncheck_regist show_uncheck_user(int uid);

	// 将具体用户通过审核
	@Update("update tb_trade_account set uState=3 where uID=#{uid}")
	public int pass(int uid);

	// 将未通过审核用户的审核意见插入意见表
	@Insert("insert into tb_opinion(uID,uOpinion,oType) values (#{uid},#{uopinion},1)")
	public int NoPass(@Param("uid") int uid, @Param("uopinion") String uopinion);

	// 通过UID查uname
	@Select("select uName from tb_login_info where uID=#{uid}")
	public String selectuname(int uid);

	// 查询具体用户的企业营业执照文件名用于拼接文件路径
	@Select("select cBusinessLicense from tb_company_file where uID=#{uid} ")
	public String show_uncheck_user_file_cBusinessLicense(int uid);

	// 查询具体用户的企业税务登记文件名用于拼接文件路径
	@Select("select cTax from tb_company_file where uID=#{uid} ")
	public String show_uncheck_user_file_cTax(int uid);

	// 查询具体用户的企业组织机构代码证文件名用于拼接文件路径
	@Select("select cOrg from tb_company_file where uID=#{uid} ")
	public String show_uncheck_user_file_cOrg(int uid);

	// 查询具体用户的企业开户许可证文件名用于拼接文件路径
	@Select("select cBank from tb_company_file where uID=#{uid} ")
	public String show_uncheck_user_file_cBank(int uid);

	// 查询具体用户的企业法人代表身份证文件名用于拼接文件路径
	@Select("select cLegalPerson from tb_company_file where uID=#{uid} ")
	public String show_uncheck_user_file_cLegalPerson(int uid);

	// 查询具体用户的煤炭经营许可证文件名用于拼接文件路径
	@Select("select cPermission from tb_company_file where uID=#{uid} ")
	public String show_uncheck_user_file_cPermission(int uid);
}
