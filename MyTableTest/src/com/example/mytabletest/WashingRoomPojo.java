package com.example.mytabletest;

/**
 * @author daij
 * @version 1.0 状态实体
 */
public class WashingRoomPojo {

	private static final long serialVersionUID = -8379602526383806649L;
	public static final String TAG = "WashingRoomPojo";
	public int wrPojoId;
	public String wrAreaName;
	public int wrManMTNum;
	public int wrManDCNum;
	public int wrManXBCNum;
	public int wrWomanMTNum;
	public int wrWomanDCNum;
	public int wrWomanXBCNum;

	public int getWrPojoId() {
		return wrPojoId;
	}

	public WashingRoomPojo setWrPojoId(int wrPojoId) {
		this.wrPojoId = wrPojoId;
		return this;
	}

	public String getWrAreaName() {
		return wrAreaName;
	}

	public WashingRoomPojo setWrAreaName(String wrAreaName) {
		this.wrAreaName = wrAreaName;
		return this;
	}

	public int getWrManMT() {
		return wrManMTNum;
	}

	public WashingRoomPojo setWrManMT(int wrManMT) {
		this.wrManMTNum = wrManMT;
		return this;
	}

	public int getWrManDC() {
		return wrManDCNum;
	}

	public WashingRoomPojo setWrManDC(int wrManDC) {
		this.wrManDCNum = wrManDC;
		return this;
	}

	public int getWrManXBC() {
		return wrManXBCNum;
	}

	public WashingRoomPojo setWrManXBC(int wrManXBC) {
		this.wrManXBCNum = wrManXBC;
		return this;
	}

	public int getWrWomanMT() {
		return wrWomanMTNum;
	}

	public WashingRoomPojo setWrWomanMT(int wrWomanMT) {
		this.wrWomanMTNum = wrWomanMT;
		return this;
	}

	public int getWrWomanDC() {
		return wrWomanDCNum;
	}

	public WashingRoomPojo setWrWomanDC(int wrWomanDC) {
		this.wrWomanDCNum = wrWomanDC;
		return this;
	}

	public int getWrWomanXBC() {
		return wrWomanXBCNum;
	}

	public WashingRoomPojo setWrWomanXBC(int wrWomanXBC) {
		this.wrWomanXBCNum = wrWomanXBC;
		return this;
	}

}
