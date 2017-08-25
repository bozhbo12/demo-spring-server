package com.snail.webgame.game.protocal.fight.competition.cancel;

import org.epilot.ccf.config.Resource;
import org.epilot.ccf.core.processor.ProtocolProcessor;
import org.epilot.ccf.core.processor.Request;
import org.epilot.ccf.core.processor.Response;
import org.epilot.ccf.core.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.snail.webgame.game.common.GameMessageHead;
import com.snail.webgame.game.common.util.Command;
import com.snail.webgame.game.protocal.fight.competition.service.CompetitionService;

/**
 * 
 * 类介绍:取消提交竞技场战斗申请
 *
 * @author zhoubo
 * @2014-11-25
 */
public class CancelFightProcessor extends ProtocolProcessor {

	private static Logger logger = LoggerFactory.getLogger("logs");

	private CompetitionService competitionService;

	public void setCompetitionService(CompetitionService competitionService) {
		this.competitionService = competitionService;
	}

	public void execute(Request request, Response response) {
		Message message = request.getMessage();
		GameMessageHead header = (GameMessageHead) message.getHeader();
		header.setMsgType(Command.FIGHT_CANCEL_SUBMIT_COMPETITION_RESP);
		int roleId = header.getUserID0();
		CancelFightResp resp = this.competitionService.cancelCompetitionFight(roleId);
		
		message.setHeader(header);
		message.setBody(resp);
		response.write(message);

		if (logger.isInfoEnabled()) {
			logger.info(Resource.getMessage("game", "GAME_PVP_INFO_2") + ": result=" + resp.getResult() + ",roleId="
					+ roleId);
		}
	}
}
