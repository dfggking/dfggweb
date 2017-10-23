package com.dfggking.socket.listener;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.dfggking.web.vo.ChatVO;

/**
 * @Description TODO
 * @author dfggking@hotmail.com
 * @date 2017-06-29
 * @version 
 */
public class SocketServerListener implements DataListener<ChatVO> {
    
    private SocketIOServer server;
    /**
     * @see com.corundumstudio.socketio.listener.DataListener#onData(com.corundumstudio.socketio.SocketIOClient, java.lang.Object, com.corundumstudio.socketio.AckRequest)
     * @Description TODO
     * @author dfggking@hotmail.com
     * @date 2017-06-29
     * @version
     */
    @Override
    public void onData(SocketIOClient client, ChatVO data, AckRequest ackSender) throws Exception {
        this.server.getBroadcastOperations().sendEvent("chatevent", data);
    }
    /**
     * @return the server
     */
    public SocketIOServer getServer() {
        return server;
    }
    /**
     * @param server the server to set
     */
    public void setServer(SocketIOServer server) {
        this.server = server;
    }
}
