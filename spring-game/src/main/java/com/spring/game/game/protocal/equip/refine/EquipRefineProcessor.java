package com.snail.webgame.game.protocal.equip.refine;

import org.epilot.ccf.config.Resource;
import org.epilot.ccf.core.processor.ProtocolProcessor;
import org.epilot.ccf.core.processor.Request;
import org.epilot.ccf.core.processor.Response;
import org.epilot.ccf.core.protocol.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.snail.webgame.game.common.GameMessageHead;
import com.snail.webgame.game.common.util.Command;
import com.snail.webgame.game.protocal.equip.service.EquipMgtService;

public class EquipRefineProcessor extends ProtocolProcessor{
	private static Logger logger = LoggerFactory.getLogger("logs");
	private EquipMgtService equipMgtService;
	
	public void setEquipMgtService(EquipMgtService equipMgtService) {
		this.equipMgtService = equipMgtService;
	}
	@Override
	public void execute(Request request, Response response) {
		Message msg = request.getMessage();
		GameMessageHead header  = (GameMessageHead) msg.getHeader();
		header.setMsgType(Command.EQUIP_REFINE_RESP);
		
		int roleId = header.getUserID0();
		
		EquipRefineReq req = (EquipRefineReq) msg.getBody();
		
		EquipRefineResp resp = equipMgtService.refineEquip(roleId, req);
		
		msg.setHeader(header);
		msg.setBody(resp);
		response.write(msg);
		
		if(logger.isInfoEnabled()){
			logger.info(Resource.getMessage("game", "GAME_EQUIP_INFO_6") + ": result=" + resp.getResult() + ",roleId="
					+ roleId);
		}
	}

}
