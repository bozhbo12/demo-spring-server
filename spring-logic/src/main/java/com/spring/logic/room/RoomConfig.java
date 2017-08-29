package com.spring.logic.room;

import java.util.concurrent.atomic.AtomicInteger;

import com.spring.logic.room.cache.RoomCahce;

public class RoomConfig {

	public static AtomicInteger roomIdSeq = new AtomicInteger(1);
	
	public static int ROOM_MAX_ROLES = 6;
	
	public static int ROOM_MAX_COUNT = 10000;
	
	public static void init() {
		RoomCahce.init();
	}
	
	public static int createRoomId() {
		return roomIdSeq.incrementAndGet();
	}
}
