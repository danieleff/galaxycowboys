package galaxycowboys.net;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.Gson;

import fi.iki.elonen.NanoHTTPD;

public class Server extends NanoHTTPD {
    public Server(int port) {
        super(port);
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
        HashMap<String, Object> response = new HashMap<String, Object>();
        for (Entry<String, String> entry : session.getParms().entrySet()) {
            response.put(entry.getKey(), entry.getValue());
        }
        response.put("error", 0);
        return toJsonResponse(response);
    }
    
    private Response toJsonResponse(Object response) {
        Gson gson = new Gson();
        return new Response(gson.toJson(response));
    }
    
}