package galaxycowboys.net;

import java.util.HashMap;

import com.google.gson.Gson;

import fi.iki.elonen.NanoHTTPD;
import galaxycowboys.TurnManager;
import galaxycowboys.gameobject.Galaxy;
import galaxycowboys.gameobject.GameObject;
import galaxycowboys.gameobject.Star;
import galaxycowboys.gameobject.Turn;

public class Server extends NanoHTTPD {
    private final TurnManager turnManager;

    public Server(int port, TurnManager turnManager) {
        super(port);
        this.turnManager = turnManager;
    }
 
    public Response serve(IHTTPSession session) {
        Response response=null;
        
        if ("/get_static_data".equals(session.getUri())) {
            response = getStaticData(session);
        } else {
            response=new Response("Error");
        }
        
        response.addHeader("Access-Control-Allow-Origin", session.getHeaders().get("Origin"));
        return response;
    }
    
    private Response getStaticData(IHTTPSession session) {
        Turn previous = turnManager.getPrevious();
        Galaxy galaxy = previous.getGalaxy();
        
        
        HashMap<String, Object> response = new HashMap<String, Object>();
        for (GameObject child : galaxy.getChilds()) {
            Star s=(Star)child;
            //todo...
        }
        
        response.put("error", 0);
        return toJsonResponse(response);
    }
    
    private Response toJsonResponse(Object response) {
        Gson gson = new Gson();
        return new Response(gson.toJson(response));
    }
    
}