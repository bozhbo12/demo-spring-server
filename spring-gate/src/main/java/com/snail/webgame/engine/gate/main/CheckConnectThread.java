package com.snail.webgame.engine.gate.main;

import java.util.Map;
import java.util.Set;

import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.snail.webgame.engine.gate.cache.ServerMap;
import com.snail.webgame.engine.gate.common.ConnectConfig;
import com.snail.webgame.engine.gate.config.GlobalServer;
import com.snail.webgame.engine.gate.config.WebGameConfig;
import com.snail.webgame.engine.gate.send.connect.Connect;
import com.snail.webgame.engine.gate.util.MessageServiceManage;
import com.spring.common.ServerName;

/**
 * 维护连接 如果连接中断重新连接
 * 
 * @author cici
 *
 */
public class CheckConnectThread extends Thread {
	private MessageServiceManage messagemgt = new MessageServiceManage();
	private static Logger logger = LoggerFactory.getLogger("logs");
	private IoHandlerAdapter handlerAdapter;
	private IServerState serverState;

	public CheckConnectThread(IoHandlerAdapter handlerAdapter) {
		this(handlerAdapter, new DefaultServerState());
	}

	public CheckConnectThread(IoHandlerAdapter handlerAdapter, IServerState serverState) {
		this.handlerAdapter = handlerAdapter;
		this.serverState = serverState;
	}

	public void run() {
		while (true) {
			Map<String, ConnectConfig> map = WebGameConfig.getInstance().getConnectConfig();

			Set<String> set = map.keySet();

			for (String key : set) {
				// if(key.startsWith(ServerName.GAME_SCENE_SERVER))
				// {
				checkConnect(key);
				// }

			}

			if (serverState.isAllNormal()) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					logger.error("", e);
				}
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					logger.error("", e);
				}
			}

		}
	}

	public void checkConnect(String serverName) {
		IoSession session = ServerMap.getSession(serverName);
		if (session == null || !session.isConnected()) {
			GlobalServer.GAME_IS_REGISTER = false;
			
			session = Connect.connectServer(serverName, handlerAdapter);
			
			if (session != null) {
				ServerMap.addSession(serverName, session);
			}
		}
		if (session != null && session.isConnected()) {
			if (serverName.startsWith(ServerName.GAME_SCENE_SERVER)) {
				messagemgt.sendActiveServerMessage(session, 1);

			} else if (serverName.equalsIgnoreCase(ServerName.GAME_SERVER_NAME)) {
				if (GlobalServer.GAME_IS_REGISTER) {
					messagemgt.sendActiveServerMessage(session, 1);
				} else {
					messagemgt.sendActiveServerMessage(session, 0);
					session.setAttribute("serverName", ServerName.GAME_SERVER_NAME);

				}
				GlobalServer.GAME_IS_REGISTER = true;
			} else if (serverName.startsWith(ServerName.ROOM_SERVER_NAME)) {
				if (session.getAttribute(serverName) == null) {
					messagemgt.sendActiveServerMessage(session, 1);
					session.setAttribute(serverName, "1");
				} else {
					messagemgt.sendActiveServerMessage(session, 0);
				}
			}
		}
	}
}
