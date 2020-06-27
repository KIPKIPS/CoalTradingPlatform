package com.isscollege.listing.entity;

import java.io.Serializable;

public class Seller_Info implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * tb_seller_info.sNumber (挂牌编号)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Integer sNumber;

	/**
	 * tb_seller_info.sCount (供应数量（万吨）)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double sCount;

	/**
	 * tb_seller_info.sKCal (热值(KCal/kg))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double sKCal;

	/**
	 * tb_seller_info.sCPrice (原煤单价(元/吨))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double sCPrice;

	/**
	 * tb_seller_info.sS (全硫含量最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double sS;

	/**
	 * tb_seller_info.sPlace (产地)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String sPlace;

	/**
	 * tb_seller_info.sFreight (运费单价(元/吨))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double sFreight;

	/**
	 * tb_seller_info.sVolatilizeMin (挥发分最小值)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double sVolatilizeMin;

	/**
	 * tb_seller_info.sVolatilizeMax (挥发分最大值)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double sVolatilizeMax;

	/**
	 * tb_seller_info.sDeliverPlace (发货地)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String sDeliverPlace;

	/**
	 * tb_seller_info.sAshContent (空干基灰分最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double sAshContent;

	/**
	 * tb_seller_info.sMoisture (全水分最大值(%))
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Double sMoisture;

	/**
	 * tb_seller_info.sState (挂牌审核状态，默认为0(待审核），1代表已发布，2代表已下架)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private String sState;

	/**
	 * tb_seller_info.uID (用户编号)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Integer uID;

	/**
	 * tb_seller_info.adminID (挂牌审核管理员编号)
	 * 
	 * @ibatorgenerated 2019-06-11 12:58:05
	 */
	private Integer adminID;

	private String coalTtype;
	private String transType;
	private String deliveryPlace;
	private String exchangeMeans;
	private String logisticsbus;

	public String getCoalTtype() {
		return coalTtype;
	}

	public void setCoalTtype(String coalTtype) {
		this.coalTtype = coalTtype;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getDeliveryPlace() {
		return deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
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

	public Integer getsNumber() {
		return sNumber;
	}

	public void setsNumber(Integer sNumber) {
		this.sNumber = sNumber;
	}

	public Double getsCount() {
		return sCount;
	}

	public void setsCount(Double sCount) {
		this.sCount = sCount;
	}

	public Double getsKCal() {
		return sKCal;
	}

	public void setsKCal(Double sKCal) {
		this.sKCal = sKCal;
	}

	public Double getsCPrice() {
		return sCPrice;
	}

	public void setsCPrice(Double sCPrice) {
		this.sCPrice = sCPrice;
	}

	public Double getsS() {
		return sS;
	}

	public void setsS(Double sS) {
		this.sS = sS;
	}

	public String getsPlace() {
		return sPlace;
	}

	public void setsPlace(String sPlace) {
		this.sPlace = sPlace;
	}

	public Double getsFreight() {
		return sFreight;
	}

	public void setsFreight(Double sFreight) {
		this.sFreight = sFreight;
	}

	public Double getsVolatilizeMin() {
		return sVolatilizeMin;
	}

	public void setsVolatilizeMin(Double sVolatilizeMin) {
		this.sVolatilizeMin = sVolatilizeMin;
	}

	public Double getsVolatilizeMax() {
		return sVolatilizeMax;
	}

	public void setsVolatilizeMax(Double sVolatilizeMax) {
		this.sVolatilizeMax = sVolatilizeMax;
	}

	public String getsDeliverPlace() {
		return sDeliverPlace;
	}

	public void setsDeliverPlace(String sDeliverPlace) {
		this.sDeliverPlace = sDeliverPlace;
	}

	public Double getsAshContent() {
		return sAshContent;
	}

	public void setsAshContent(Double sAshContent) {
		this.sAshContent = sAshContent;
	}

	public Double getsMoisture() {
		return sMoisture;
	}

	public void setsMoisture(Double sMoisture) {
		this.sMoisture = sMoisture;
	}

	public String getsState() {
		return sState;
	}

	public void setsState(String sState) {
		this.sState = sState;
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
		return "Seller_Info [sNumber=" + sNumber + ", sCount=" + sCount + ", sKCal=" + sKCal + ", sCPrice=" + sCPrice
				+ ", sS=" + sS + ", sPlace=" + sPlace + ", sFreight=" + sFreight + ", sVolatilizeMin=" + sVolatilizeMin
				+ ", sVolatilizeMax=" + sVolatilizeMax + ", sDeliverPlace=" + sDeliverPlace + ", sAshContent="
				+ sAshContent + ", sMoisture=" + sMoisture + ", sState=" + sState + ", uID=" + uID + ", adminID="
				+ adminID + ", coalTtype=" + coalTtype + ", transType=" + transType + ", deliveryPlace=" + deliveryPlace
				+ ", exchangeMeans=" + exchangeMeans + ", logisticsbus=" + logisticsbus + "]";
	}

	public Seller_Info() {
		super();
	}

	public Seller_Info(Integer sNumber, Double sCount, Double sKCal, Double sCPrice, Double sS, String sPlace,
			Double sFreight, Double sVolatilizeMin, Double sVolatilizeMax, String sDeliverPlace, Double sAshContent,
			Double sMoisture, String sState, Integer uID, Integer adminID, String coalTtype, String transType,
			String deliveryPlace, String exchangeMeans, String logisticsbus) {
		super();
		this.sNumber = sNumber;
		this.sCount = sCount;
		this.sKCal = sKCal;
		this.sCPrice = sCPrice;
		this.sS = sS;
		this.sPlace = sPlace;
		this.sFreight = sFreight;
		this.sVolatilizeMin = sVolatilizeMin;
		this.sVolatilizeMax = sVolatilizeMax;
		this.sDeliverPlace = sDeliverPlace;
		this.sAshContent = sAshContent;
		this.sMoisture = sMoisture;
		this.sState = sState;
		this.uID = uID;
		this.adminID = adminID;
		this.coalTtype = coalTtype;
		this.transType = transType;
		this.deliveryPlace = deliveryPlace;
		this.exchangeMeans = exchangeMeans;
		this.logisticsbus = logisticsbus;
	}

	public Seller_Info(Integer sNumber, String exchangeMeans, String logisticsbus) {
		super();
		this.sNumber = sNumber;
		this.exchangeMeans = exchangeMeans;
		this.logisticsbus = logisticsbus;
	}

}
