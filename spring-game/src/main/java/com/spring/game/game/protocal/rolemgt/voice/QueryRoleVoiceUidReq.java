package com.snail.webgame.game.protocal.rolemgt.voice;

import org.epilot.ccf.core.protocol.MessageBody;
import org.epilot.ccf.core.protocol.ProtocolSequence;

public class QueryRoleVoiceUidReq extends MessageBody {

	private String roleName; // 角色名称

	@Override
	protected void setSequnce(ProtocolSequence ps) {
		ps.addString("roleName", "flashCode", 0);
		
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
