package com.snail.webgame.game.protocal.stone.inlay;

import org.epilot.ccf.core.protocol.MessageBody;
import org.epilot.ccf.core.protocol.ProtocolSequence;

import com.snail.webgame.game.protocal.equip.query.EquipInfoRe;

public class InlayStoneResp extends MessageBody 
{
	private int result;
	private int heroId;	
	private int equipId;
	private int fightValue;//
	private EquipInfoRe equipInfo=new EquipInfoRe();// 单个装备信息
	private byte sourceType;//1:银子	2:金子	3:体力	7:玩家经验	8:竞技场货币-勇气点	9:征战四方货币 正义点	10:工会币	15:玩家等级	28:跨服币	
	//32:战功 34:历史战功	49:体力值购买次数  50:银子购买次数  51:经验活动剩余次数 52:金币活动剩余次数  53:用户名修改次数  54:历史最高战斗力  55：精力
	private int sourceChange;//资源变动数,正值为增加,负值为减少

	@Override
	protected void setSequnce(ProtocolSequence ps) 
	{
		ps.add("result", 0);
		ps.add("heroId", 0);
		ps.add("equipId", 0);
		ps.add("fightValue", 0);
		
		ps.addObject("equipInfo");
		
		ps.add("sourceType", 0);
		ps.add("sourceChange", 0);
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
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

	public int getFightValue() {
		return fightValue;
	}

	public void setFightValue(int fightValue) {
		this.fightValue = fightValue;
	}

	public EquipInfoRe getEquipInfo() {
		return equipInfo;
	}

	public void setEquipInfo(EquipInfoRe equipInfo) {
		this.equipInfo = equipInfo;
	}

	public byte getSourceType() {
		return sourceType;
	}

	public void setSourceType(byte sourceType) {
		this.sourceType = sourceType;
	}

	public int getSourceChange() {
		return sourceChange;
	}

	public void setSourceChange(int sourceChange) {
		this.sourceChange = sourceChange;
	}
	
}
