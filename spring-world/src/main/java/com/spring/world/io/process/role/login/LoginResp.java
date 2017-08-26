package com.spring.world.io.process.role.login;

import java.nio.ByteOrder;

import org.apache.mina.common.ByteBuffer;

import com.snail.mina.protocol.info.impl.BaseRoomResp;

public class LoginResp extends BaseRoomResp {

	private int result;// 1-成功 2-成功（本地没有用户，需创建）3-成功(新创建的用的，需要引导)
	private int roleId;// 角色Id
	private String account;// 玩家登陆帐号
	private String roleName;// 角色名称
	private short gateServerId;// gate服务器Id

	@Override
	public void resp2Bytes(ByteBuffer buffer, ByteOrder order) {
		setInt(buffer, order, result);
		setInt(buffer, order, roleId);
		setString(buffer, order, account);
		setString(buffer, order, roleName);
		setShort(buffer, order, gateServerId);

	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public short getGateServerId() {
		return gateServerId;
	}

	public void setGateServerId(short gateServerId) {
		this.gateServerId = gateServerId;
	}

}
