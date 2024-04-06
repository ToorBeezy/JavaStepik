package chat;

import java.io.IOException;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

@WebSocket
public class WebSocketConnect {
    private Session sess;

    @OnWebSocketConnect
    public void onConnect(Session sess) {
        this.sess = sess;
    }

    @OnWebSocketMessage
    public void onMessage(String message) throws IOException {
        sess.getRemote().sendString(message);
    }
}