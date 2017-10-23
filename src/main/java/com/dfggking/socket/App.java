package com.dfggking.socket;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import com.dfggking.socket.listener.SocketServerListener;
import com.dfggking.web.vo.ChatVO;

/**
 * @Description TODO
 * @author dfggking@hotmail.com
 * @date 2017-06-29
 * @version 
 */
public class App {

    /**
     * 启动监听器
     * @Description TODO
     * @author dfggking@hotmail.com
     * @date 2017-06-29
     * @param 
     * @return void
     * @version
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(8887);
        
        SocketIOServer server = new SocketIOServer(config);
        SocketServerListener listener = new SocketServerListener();
        listener.setServer(server);
        server.addEventListener("chatEvent", ChatVO.class, listener);
        
        server.start();
        Thread.sleep(Integer.MAX_VALUE);
        server.stop();
    }
}
