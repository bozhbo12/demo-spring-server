package com.snail.webgame.game.protocal.ride.updown;

import org.epilot.ccf.config.Resource;
import org.epilot.ccf.core.processor.ProtocolProcessor;
import org.epilot.ccf.core.processor.Request;
import org.epilot.ccf.core.processor.Response;
import org.epilot.ccf.core.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.snail.webgame.game.common.GameMessageHead;
import com.snail.webgame.game.common.util.Command;
import com.snail.webgame.game.protocal.ride.service.RideMgrService;

public class RideUpDownProcessor extends ProtocolProcessor {

	private static final Logger logger = LoggerFactory.getLogger("logs");

	private RideMgrService rideMgrService;

	public void setRideMgrService(RideMgrService rideMgrService) {
		this.rideMgrService = rideMgrService;
	}

	@Override
	public void execute(Request request, Response response) {

		Message message = request.getMessage();

		GameMessageHead header = (GameMessageHead) message.getHeader();
		int roleId = header.getUserID0();

		header.setProtocolId(Command.RIDE_UPDOWN_RESP);
		
		RideUpDownReq req = (RideUpDownReq) message.getBody();

		RideUpDownResp resp = rideMgrService.rideUpDown(roleId, req);

		message.setBody(resp);
		message.setHeader(header);
		response.write(message);

		if (logger.isInfoEnabled()) {
			logger.info(Resource.getMessage("game", "GAME_ROLE_RIDE_2") + ":result=" + resp.getResult() + ",roleId=" + roleId);
		}
	}

}
