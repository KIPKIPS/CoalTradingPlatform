package com.isscollege.users.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.isscollege.users.entity.Bank_Finance;

@Mapper
public interface UserDao {
	// 登录
	@Select("select * from tb_bank_finance where bankAcount=#{bankAcount} and bankPassword=#{bankPassword}")
	Bank_Finance login(Bank_Finance bank_Finance);

	// 预存功能
	@Update("update tb_bank_finance set balance = balance + #{balance} where bankAcount = #{bankAcount}")
	Integer modifyBalance(@Param("balance") Double balance, @Param("bankAcount") String bankAcount);

	// 根据预存金额修改未冻结金额
	@Update("update tb_bank_finance set usableMoney = usableMoney + #{balance} where bankAcount = #{bankAcount}")
	Integer modifyUsableMoneyByBalance(@Param("balance") Double balance, @Param("bankAcount") String bankAcount);

	// 修改冻结金额
	@Update("update tb_bank_finance set frozenMoney = frozenMoney + #{frozenMoney} where bankAcount = #{bankAcount}")
	Integer modifyFrozenMoney(@Param("bankAcount") String bankAcount, @Param("frozenMoney") Double frozenMoney);

	// 修改未冻结金额
	@Update("update tb_bank_finance set usableMoney = usableMoney - #{usableMoney} where bankAcount = #{bankAcount}")
	Integer modifyUsableMoney(@Param("bankAcount") String bankAcount, @Param("usableMoney") Double usableMoney);

	// 通过银行账号获取用户对象
	@Select("select * from tb_bank_finance where bankAcount = #{bankAcount}")
	Bank_Finance queryBankFinance(String bankAcount);

	// 将注册用户数据插入数据库
	@Insert("insert into tb_bank_finance(bankAcount, bankPassword, cName, cRealName, cLegalPerson, uRealName, uTeleNum)"
			+ "values(#{bankAcount}, #{bankPassword}, #{cName}, #{cRealName}, #{cLegalPerson}, #{uRealName}, #{uTeleNum})")
	Integer tradeUserRegist(Bank_Finance bank_Finance);

	// 查询账号是否已存在
	@Select("select * from tb_bank_finance where cName=#{cName}")
	Bank_Finance queryUserAcountBycName(String cName);

	// 更新解冻金额与可用金额
	@Update("update tb_bank_finance set frozenMoney=#{frozenMoney}, usableMoney=#{usableMoney} where bankAcount=#{bankAcount}")
	Integer modifyBalanceFoUnfrozen(Bank_Finance finance);

	// 查询需要更新解冻保证金的账户
	@Select("select * from tb_bank_finance where bankAcount = #{bankAcount} for update")
	Bank_Finance queryBankFinanceForUpdate(String bankAcount);

	// 查询所有账户信息
	@Select("select * from tb_bank_finance")
	List<Bank_Finance> queryAllAccount();
}
