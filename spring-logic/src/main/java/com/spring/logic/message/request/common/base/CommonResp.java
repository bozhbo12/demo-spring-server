package com.spring.logic.message.request.common.base;

import java.nio.ByteOrder;

import org.apache.mina.common.ByteBuffer;

import com.snail.mina.protocol.info.impl.BaseRoomResp;

public class CommonResp extends BaseRoomResp {

	private int optionType;
	private String optionStr;
	
	public CommonResp() {
		
	}
	
	public CommonResp(int optionType, String optionStr) {
		this.optionType = optionType;
		this.optionStr = optionStr;
	}
	
	@Override
	public void bytes2Req(ByteBuffer buffer, ByteOrder order) {
		this.optionType = getInt(buffer, order);
		this.optionStr = getString(buffer, order);
	}
	
	
	@Override
	public void resp2Bytes(ByteBuffer buffer, ByteOrder order) {
		setInt(buffer, order, optionType);
		setString(buffer, order, optionStr);
		
	}

	public int getOptionType() {
		return optionType;
	}

	public void setOptionType(int optionType) {
		this.optionType = optionType;
	}

	public String getOptionStr() {
		return optionStr;
	}

	public void setOptionStr(String optionStr) {
		this.optionStr = optionStr;
	}
	
	
}
