package com.spring.logic.message.request.room;

import java.nio.ByteOrder;

import org.apache.mina.common.ByteBuffer;

import com.snail.mina.protocol.info.impl.BaseRoomResp;

public class RoomInitResp extends BaseRoomResp {
	
	private int roomId;

	@Override
	public void resp2Bytes(ByteBuffer buffer, ByteOrder order) {
		setInt(buffer, order, roomId);
	}
	
	@Override
	public void bytes2Req(ByteBuffer buffer, ByteOrder order) {
		this.roomId = getInt(buffer, order);
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	
}
