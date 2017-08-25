package com.snail.webgame.game.protocal.fightdeploy.buy;

import org.epilot.ccf.config.Resource;
import org.epilot.ccf.core.processor.ProtocolProcessor;
import org.epilot.ccf.core.processor.Request;
import org.epilot.ccf.core.processor.Response;
import org.epilot.ccf.core.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.snail.webgame.game.common.GameMessageHead;
import com.snail.webgame.game.common.util.Command;
import com.snail.webgame.game.protocal.fightdeploy.service.FightDeployMgtService;

public class BuyDeployPosProcessor extends ProtocolProcessor {

	private static Logger logger = LoggerFactory.getLogger("logs");

	private FightDeployMgtService fightDeployMgtService;

	public void setFightDeployMgtService(FightDeployMgtService fightDeployMgtService) {
		this.fightDeployMgtService = fightDeployMgtService;
	}

	public void execute(Request request, Response response) {
		Message message = request.getMessage();
		GameMessageHead header = (GameMessageHead) message.getHeader();
		header.setMsgType(Command.BUY_FIGHT_DEPLOY_RESP);
		int roleId = header.getUserID0();
		BuyDeployPosReq req = (BuyDeployPosReq) message.getBody();
		BuyDeployPosResp resp = fightDeployMgtService.buyDeployPos(roleId, req);
		message.setHeader(header);
		message.setBody(resp);
		response.write(message);

		if (logger.isInfoEnabled()) {
			logger.info(Resource.getMessage("game", "GAME_FIGHT_DEPLOY_INFO_4") + ": result=" + resp.getResult() + ",roleId="
					+ roleId);
		}
	}

}

