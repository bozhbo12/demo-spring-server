package com.snail.webgame.game.protocal.equip.merge;

import org.epilot.ccf.core.protocol.MessageBody;
import org.epilot.ccf.core.protocol.ProtocolSequence;

public class MergeEquipReq extends MessageBody {

	private int heroId;// 英雄编号
	private int equipId;// 装备编号

	@Override
	protected void setSequnce(ProtocolSequence ps) {
		ps.add("heroId", 0);
		ps.add("equipId", 0);
	}

	public int getHeroId() {
		return heroId;
	}

	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}

	public int getEquipId() {
		return equipId;
	}

	public void setEquipId(int equipId) {
		this.equipId = equipId;
	}
}

