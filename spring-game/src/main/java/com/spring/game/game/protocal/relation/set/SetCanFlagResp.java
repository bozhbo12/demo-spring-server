package com.snail.webgame.game.protocal.relation.set;

import org.epilot.ccf.core.protocol.MessageBody;
import org.epilot.ccf.core.protocol.ProtocolSequence;

public class SetCanFlagResp extends MessageBody {
	private int result;

	@Override
	protected void setSequnce(ProtocolSequence ps) {
		ps.add("result", 0);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

}
