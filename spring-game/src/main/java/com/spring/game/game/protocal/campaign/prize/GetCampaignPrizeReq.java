package com.snail.webgame.game.protocal.campaign.prize;

import org.epilot.ccf.core.protocol.MessageBody;
import org.epilot.ccf.core.protocol.ProtocolSequence;

public class GetCampaignPrizeReq extends MessageBody {

	private int battleNo;// 关卡编号

	@Override
	protected void setSequnce(ProtocolSequence ps) {
		ps.add("battleNo", 0);
	}

	public int getBattleNo() {
		return battleNo;
	}

	public void setBattleNo(int battleNo) {
		this.battleNo = battleNo;
	}
}
