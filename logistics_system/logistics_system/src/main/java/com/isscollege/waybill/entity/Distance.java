package com.isscollege.waybill.entity;

public class Distance {

	// 物流起始和终止地点
	private String start_end_pos;
	// 起始地点和终止地点间的距离
	private double distance;

	public String getStart_end_pos() {
		return start_end_pos;
	}

	public void setStart_end_pos(String start_end_pos) {
		this.start_end_pos = start_end_pos;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Distance [start_end_pos=" + start_end_pos + ", distance=" + distance + "]";
	}

}
