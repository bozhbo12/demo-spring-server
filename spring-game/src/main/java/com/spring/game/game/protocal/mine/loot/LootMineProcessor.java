package com.snail.webgame.game.protocal.mine.loot;

import org.epilot.ccf.config.Resource;
import org.epilot.ccf.core.processor.ProtocolProcessor;
import org.epilot.ccf.core.processor.Request;
import org.epilot.ccf.core.processor.Response;
import org.epilot.ccf.core.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.snail.webgame.game.common.GameMessageHead;
import com.snail.webgame.game.common.util.Command;
import com.snail.webgame.game.protocal.mine.service.MineMgtService;

public class LootMineProcessor extends ProtocolProcessor {

	private static Logger logger = LoggerFactory.getLogger("logs");

	private MineMgtService mineMgtService;

	public void setMineMgtService(MineMgtService mineMgtService) {
		this.mineMgtService = mineMgtService;
	}

	public void execute(Request request, Response response) {
		Message message = request.getMessage();
		GameMessageHead header = (GameMessageHead) message.getHeader();
		header.setMsgType(Command.QUERY_MINE_LOOT_RESP);
		int roleId = header.getUserID0();
		LootMineResp resp = mineMgtService.queryMineLoot(roleId);
		message.setHeader(header);
		message.setBody(resp);
		response.write(message);

		if (logger.isInfoEnabled()) {
			logger.info(Resource.getMessage("game", "GAME_MINE_INFO_5") + ": result=" + resp.getResult() + ",roleId="
					+ roleId + ",count=" + resp.getCount());
		}
	}

}
