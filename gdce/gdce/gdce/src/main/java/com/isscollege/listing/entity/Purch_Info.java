package com.isscollege.listing.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Purch_Info implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * tb_purch_info.pNumber (挂牌编号)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Integer pNumber;

	/**
	 * tb_purch_info.pListID (单据编号)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pListID;

	/**
	 * tb_purch_info.pName (申请人)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pName;

	/**
	 * tb_purch_info.pIssuer (签发人)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pIssuer;

	/**
	 * tb_purch_info.pApplyDate (申请日期)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Timestamp pApplyDate;

	/**
	 * tb_purch_info.pDeliverEarliest (最早交货时间)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date pDeliverEarliest;

	/**
	 * tb_purch_info.pDeliverLatest (最晚交货时间)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date pDeliverLatest;

	/**
	 * tb_purch_info.pCoalType (煤炭分类)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pCoalType;

	/**
	 * tb_purch_info.pCoalBusType (商业分类)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pCoalBusType;

	/**
	 * tb_purch_info.pCount (采购数量)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pCount;

	/**
	 * tb_purch_info.pTransport (运输方式)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pTransport;

	/**
	 * tb_purch_info.pDeliverPlace (交货地点)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pDeliverPlace;

	/**
	 * tb_purch_info.pSettlement (结算方式)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pSettlement;

	/**
	 * tb_purch_info.pCheck (验收方式)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pCheck;

	/**
	 * tb_purch_info.pPayment (结算付款方式)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pPayment;

	/**
	 * tb_purch_info.pQuoDeposit (报价保证金缴纳)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pQuoDeposit;

	/**
	 * tb_purch_info.pBidBond (履约保证金缴纳)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pBidBond;

	/**
	 * tb_purch_info.pQnetar (收到基低位发热量最小值(Kcal/kg))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pQnetar;

	/**
	 * tb_purch_info.pStar (收到基全硫(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pStar;

	/**
	 * tb_purch_info.pM (全水分最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pM;

	/**
	 * tb_purch_info.pAar (收到基灰分最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pAar;

	/**
	 * tb_purch_info.pVarmin (收到基挥发分最小值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pVarmin;

	/**
	 * tb_purch_info.pVarmax (收到基挥发分最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pVarmax;

	/**
	 * tb_purch_info.pMad (空干基水分最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pMad;

	/**
	 * tb_purch_info.pStad (空干基全硫最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pStad;

	/**
	 * tb_purch_info.pVadmin (空干基挥发分最小值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pVadmin;

	/**
	 * tb_purch_info.pVadmax (空干基挥发分最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pVadmax;

	/**
	 * tb_purch_info.pQgrd (干基高位发热量最小值(Kcal/kg))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pQgrd;

	/**
	 * tb_purch_info.pStd (干基全硫最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pStd;

	/**
	 * tb_purch_info.pVanmin (干燥无灰基挥发分最小值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pVanmin;

	/**
	 * tb_purch_info.pVanmax (干燥无灰基挥发分最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pVanmax;

	/**
	 * tb_purch_info.pGrad (粒度最大值(mm))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pGrad;

	/**
	 * tb_purch_info.pST (灰熔点最小值(℃))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pST;

	/**
	 * tb_purch_info.pHGI (哈氏可磨系数最小值)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double pHGI;

	/**
	 * tb_purch_info.pRemarks (备注)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pRemarks;

	/**
	 * tb_purch_info.pState (挂牌审核状态，默认为0(待审核），1代表已发布，2代表已下架)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String pState;

	/**
	 * tb_purch_info.uID (用户编号)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Integer uID;

	/**
	 * tb_purch_info.adminID (挂牌审核管理员编号)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Integer adminID;

	public double getCoalPrice() {
		return coalPrice;
	}

	public void setCoalPrice(double coalPrice) {
		this.coalPrice = coalPrice;
	}

	public double getTransPrice() {
		return transPrice;
	}

	public void setTransPrice(double transPrice) {
		this.transPrice = transPrice;
	}

	public String getsPlace() {
		return sPlace;
	}

	public void setsPlace(String sPlace) {
		this.sPlace = sPlace;
	}

	public String getExchangeMeans() {
		return exchangeMeans;
	}

	public void setExchangeMeans(String exchangeMeans) {
		this.exchangeMeans = exchangeMeans;
	}

	public String getLogisticsbus() {
		return logisticsbus;
	}

	public void setLogisticsbus(String logisticsbus) {
		this.logisticsbus = logisticsbus;
	}

	private double coalPrice;
	private double transPrice;
	private String sPlace;
	private String exchangeMeans;
	private String logisticsbus;

	public Integer getpNumber() {
		return pNumber;
	}

	public void setpNumber(Integer pNumber) {
		this.pNumber = pNumber;
	}

	public String getpListID() {
		return pListID;
	}

	public void setpListID(String pListID) {
		this.pListID = pListID;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpIssuer() {
		return pIssuer;
	}

	public void setpIssuer(String pIssuer) {
		this.pIssuer = pIssuer;
	}

	public Timestamp getpApplyDate() {
		return pApplyDate;
	}

	public void setpApplyDate(Timestamp pApplyDate) {
		this.pApplyDate = pApplyDate;
	}

	public Date getpDeliverEarliest() {
		return pDeliverEarliest;
	}

	public void setpDeliverEarliest(Date pDeliverEarliest) {
		this.pDeliverEarliest = pDeliverEarliest;
	}

	public Date getpDeliverLatest() {
		return pDeliverLatest;
	}

	public void setpDeliverLatest(Date pDeliverLatest) {
		this.pDeliverLatest = pDeliverLatest;
	}

	public String getpCoalType() {
		return pCoalType;
	}

	public void setpCoalType(String pCoalType) {
		this.pCoalType = pCoalType;
	}

	public String getpCoalBusType() {
		return pCoalBusType;
	}

	public void setpCoalBusType(String pCoalBusType) {
		this.pCoalBusType = pCoalBusType;
	}

	public Double getpCount() {
		return pCount;
	}

	public void setpCount(Double pCount) {
		this.pCount = pCount;
	}

	public String getpTransport() {
		return pTransport;
	}

	public void setpTransport(String pTransport) {
		this.pTransport = pTransport;
	}

	public String getpDeliverPlace() {
		return pDeliverPlace;
	}

	public void setpDeliverPlace(String pDeliverPlace) {
		this.pDeliverPlace = pDeliverPlace;
	}

	public String getpSettlement() {
		return pSettlement;
	}

	public void setpSettlement(String pSettlement) {
		this.pSettlement = pSettlement;
	}

	public String getpCheck() {
		return pCheck;
	}

	public void setpCheck(String pCheck) {
		this.pCheck = pCheck;
	}

	public String getpPayment() {
		return pPayment;
	}

	public void setpPayment(String pPayment) {
		this.pPayment = pPayment;
	}

	public Double getpQuoDeposit() {
		return pQuoDeposit;
	}

	public void setpQuoDeposit(Double pQuoDeposit) {
		this.pQuoDeposit = pQuoDeposit;
	}

	public Double getpBidBond() {
		return pBidBond;
	}

	public void setpBidBond(Double pBidBond) {
		this.pBidBond = pBidBond;
	}

	public Double getpQnetar() {
		return pQnetar;
	}

	public void setpQnetar(Double pQnetar) {
		this.pQnetar = pQnetar;
	}

	public Double getpStar() {
		return pStar;
	}

	public void setpStar(Double pStar) {
		this.pStar = pStar;
	}

	public Double getpM() {
		return pM;
	}

	public void setpM(Double pM) {
		this.pM = pM;
	}

	public Double getpAar() {
		return pAar;
	}

	public void setpAar(Double pAar) {
		this.pAar = pAar;
	}

	public Double getpVarmin() {
		return pVarmin;
	}

	public void setpVarmin(Double pVarmin) {
		this.pVarmin = pVarmin;
	}

	public Double getpVarmax() {
		return pVarmax;
	}

	public void setpVarmax(Double pVarmax) {
		this.pVarmax = pVarmax;
	}

	public Double getpMad() {
		return pMad;
	}

	public void setpMad(Double pMad) {
		this.pMad = pMad;
	}

	public Double getpStad() {
		return pStad;
	}

	public void setpStad(Double pStad) {
		this.pStad = pStad;
	}

	public Double getpVadmin() {
		return pVadmin;
	}

	public void setpVadmin(Double pVadmin) {
		this.pVadmin = pVadmin;
	}

	public Double getpVadmax() {
		return pVadmax;
	}

	public void setpVadmax(Double pVadmax) {
		this.pVadmax = pVadmax;
	}

	public Double getpQgrd() {
		return pQgrd;
	}

	public void setpQgrd(Double pQgrd) {
		this.pQgrd = pQgrd;
	}

	public Double getpStd() {
		return pStd;
	}

	public void setpStd(Double pStd) {
		this.pStd = pStd;
	}

	public Double getpVanmin() {
		return pVanmin;
	}

	public void setpVanmin(Double pVanmin) {
		this.pVanmin = pVanmin;
	}

	public Double getpVanmax() {
		return pVanmax;
	}

	public void setpVanmax(Double pVanmax) {
		this.pVanmax = pVanmax;
	}

	public Double getpGrad() {
		return pGrad;
	}

	public void setpGrad(Double pGrad) {
		this.pGrad = pGrad;
	}

	public Double getpST() {
		return pST;
	}

	public void setpST(Double pST) {
		this.pST = pST;
	}

	public Double getpHGI() {
		return pHGI;
	}

	public void setpHGI(Double pHGI) {
		this.pHGI = pHGI;
	}

	public String getpRemarks() {
		return pRemarks;
	}

	public void setpRemarks(String pRemarks) {
		this.pRemarks = pRemarks;
	}

	public String getpState() {
		return pState;
	}

	public void setpState(String pState) {
		this.pState = pState;
	}

	public Integer getuID() {
		return uID;
	}

	public void setuID(Integer uID) {
		this.uID = uID;
	}

	public Integer getAdminID() {
		return adminID;
	}

	public void setAdminID(Integer adminID) {
		this.adminID = adminID;
	}

	@Override
	public String toString() {
		return "Purch_Info [pNumber=" + pNumber + ", pListID=" + pListID + ", pName=" + pName + ", pIssuer=" + pIssuer
				+ ", pApplyDate=" + pApplyDate + ", pDeliverEarliest=" + pDeliverEarliest + ", pDeliverLatest="
				+ pDeliverLatest + ", pCoalType=" + pCoalType + ", pCoalBusType=" + pCoalBusType + ", pCount=" + pCount
				+ ", pTransport=" + pTransport + ", pDeliverPlace=" + pDeliverPlace + ", pSettlement=" + pSettlement
				+ ", pCheck=" + pCheck + ", pPayment=" + pPayment + ", pQuoDeposit=" + pQuoDeposit + ", pBidBond="
				+ pBidBond + ", pQnetar=" + pQnetar + ", pStar=" + pStar + ", pM=" + pM + ", pAar=" + pAar
				+ ", pVarmin=" + pVarmin + ", pVarmax=" + pVarmax + ", pMad=" + pMad + ", pStad=" + pStad + ", pVadmin="
				+ pVadmin + ", pVadmax=" + pVadmax + ", pQgrd=" + pQgrd + ", pStd=" + pStd + ", pVanmin=" + pVanmin
				+ ", pVanmax=" + pVanmax + ", pGrad=" + pGrad + ", pST=" + pST + ", pHGI=" + pHGI + ", pRemarks="
				+ pRemarks + ", pState=" + pState + ", uID=" + uID + ", adminID=" + adminID + ", coalPrice=" + coalPrice
				+ ", transPrice=" + transPrice + ", sPlace=" + sPlace + ", exchangeMeans=" + exchangeMeans
				+ ", logisticsbus=" + logisticsbus + "]";
	}

	public Purch_Info() {
		super();

	}

	public Purch_Info(Integer pNumber, String pListID, String pName, String pIssuer, Timestamp pApplyDate,
			Date pDeliverEarliest, Date pDeliverLatest, String pCoalType, String pCoalBusType, Double pCount,
			String pTransport, String pDeliverPlace, String pSettlement, String pCheck, String pPayment,
			Double pQuoDeposit, Double pBidBond, Double pQnetar, Double pStar, Double pM, Double pAar, Double pVarmin,
			Double pVarmax, Double pMad, Double pStad, Double pVadmin, Double pVadmax, Double pQgrd, Double pStd,
			Double pVanmin, Double pVanmax, Double pGrad, Double pST, Double pHGI, String pRemarks, String pState,
			Integer uID, Integer adminID, double coalPrice, double transPrice, String sPlace, String exchangeMeans,
			String logisticsbus) {
		super();
		this.pNumber = pNumber;
		this.pListID = pListID;
		this.pName = pName;
		this.pIssuer = pIssuer;
		this.pApplyDate = pApplyDate;
		this.pDeliverEarliest = pDeliverEarliest;
		this.pDeliverLatest = pDeliverLatest;
		this.pCoalType = pCoalType;
		this.pCoalBusType = pCoalBusType;
		this.pCount = pCount;
		this.pTransport = pTransport;
		this.pDeliverPlace = pDeliverPlace;
		this.pSettlement = pSettlement;
		this.pCheck = pCheck;
		this.pPayment = pPayment;
		this.pQuoDeposit = pQuoDeposit;
		this.pBidBond = pBidBond;
		this.pQnetar = pQnetar;
		this.pStar = pStar;
		this.pM = pM;
		this.pAar = pAar;
		this.pVarmin = pVarmin;
		this.pVarmax = pVarmax;
		this.pMad = pMad;
		this.pStad = pStad;
		this.pVadmin = pVadmin;
		this.pVadmax = pVadmax;
		this.pQgrd = pQgrd;
		this.pStd = pStd;
		this.pVanmin = pVanmin;
		this.pVanmax = pVanmax;
		this.pGrad = pGrad;
		this.pST = pST;
		this.pHGI = pHGI;
		this.pRemarks = pRemarks;
		this.pState = pState;
		this.uID = uID;
		this.adminID = adminID;
		this.coalPrice = coalPrice;
		this.transPrice = transPrice;
		this.sPlace = sPlace;
		this.exchangeMeans = exchangeMeans;
		this.logisticsbus = logisticsbus;
	}
}
