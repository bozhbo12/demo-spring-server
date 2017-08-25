package com.snail.webgame.game.protocal.checkIn7Day.getReward;

import org.epilot.ccf.core.protocol.MessageBody;
import org.epilot.ccf.core.protocol.ProtocolSequence;

public class RewardCheckIn7DayReq extends MessageBody {
	private int no;	//领取编号
	@Override
	protected void setSequnce(ProtocolSequence ps) {
		ps.add("no", 0);
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
}
