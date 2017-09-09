package com.spring.logic.role.info;

import com.spring.logic.role.enums.RoleRoomStateEnum;

public class RoomRoleInfo {

	private int roleId;
	private int gateId;
	private volatile int roomId;
	private String roleName;
	private int gold;
	private int vipLevel;
	private String header;
	
	private long lastStateTime;
	
	private RoleRoomStateEnum state;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getGateId() {
		return gateId;
	}
	public void setGateId(int gateId) {
		this.gateId = gateId;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public RoleRoomStateEnum getState() {
		return state;
	}
	public void setState(RoleRoomStateEnum state) {
		this.state = state;
		this.lastStateTime = System.currentTimeMillis();
	}
	public long getLastStateTime() {
		return lastStateTime;
	}
	
	
}