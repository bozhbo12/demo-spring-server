package com.spring.world.io.process.role.login;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.snail.mina.protocol.info.IRoomBody;
import com.snail.mina.protocol.info.Message;
import com.snail.mina.protocol.info.impl.RoomMessageHead;
import com.snail.mina.protocol.processor.IProcessor;
import com.spring.common.GameMessageType;
import com.spring.logic.request.login.LoginReq;
import com.spring.logic.role.service.RoleLoginService;

@Component
public class LoginProcessor implements IProcessor {

	private static final Log logger = LogFactory.getLog(LoginProcessor.class);

	private RoleLoginService roleLoginService;

	@Override
	public void processor(Message message) {
		RoomMessageHead head = (RoomMessageHead) message.getiRoomHead();
		LoginReq req = (LoginReq) message.getiRoomBody();

		GolfFlowerResp resp = new GolfFlowerResp();
		resp.setVersion(100);

		this.roleLoginService.roleLogin(head.getGateId(), head.getRoleId(), req.getAccount(), req.getMd5Pass(),
				req.getValidate(), resp, (r) -> {
					return 1;
				});

		logger.info("role login " + req.getAccount());
	}

	@Override
	public Class<? extends IRoomBody> getRoomBodyClass() {
		return LoginReq.class;
	}

	@Override
	public int getMsgType() {
		return GameMessageType.GAME_CLIENT_LOGIN_SEND;
	}

	public void setRoleLoginService(RoleLoginService roleLoginService) {
		this.roleLoginService = roleLoginService;
	}
}
