package hm.heatermeater;

import android.app.Activity;
import android.util.Log;
import android.view.View;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

public class Server extends Activity {

    private WebSocketClient mWebSocketClient;

    //Start up connection with server
    public void connectWebSocket(final String targetTime, final String targetTemperature) {
        URI uri;
        try {
            uri = new URI("ws://54.218.32.43:8001");
            Log.i("Test", "Connection started");
        } catch (URISyntaxException e) {
            Log.i("Test", "Refused");
            e.printStackTrace();
            return;
        }
        mWebSocketClient = new WebSocketClient(uri, new Draft_17()) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", "Opened");
                try {
                    JSONObject jsonObj = new JSONObject();
                    jsonObj.put("Request", "start"); // Set the first name/pair
                    jsonObj.put("Serial", "TEST123");
                    jsonObj.put("ETA", targetTime);
                    jsonObj.put("RequiredTemp", targetTemperature);
                    Log.i("test", jsonObj.toString());
                    mWebSocketClient.send(jsonObj.toString());
                } catch (Exception e) {}
            }

            @Override
            public void onMessage(String s) {
                final String message = s;
                try {
                    JSONObject receivedJson = new JSONObject(s);
                    Log.i("test5", s);
                    Log.i("test6", receivedJson.getString("id"));
                    Log.i("test7", receivedJson.getString("temperature"));
                } catch (Exception e) {
                    Log.i("test4", "went wrong");
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //TextView textView = (TextView) findViewById(R.id.messages);
                        //textView.setText(textView.getText() + "\n" + message);

                    }
                });
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Websocket", "Closed " + s);
            }

            @Override
            public void onError(Exception e) {
                Log.i("Websocket", "Error " + e.getMessage());
            }
        };
        mWebSocketClient.connect();
    }

    //Request JSON object from server
    public JSONObject serverRequest(View view) {
        JSONObject err = new JSONObject();
        try {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("Request", "query"); // Set the first name/pair
            jsonObj.put("Serial", "TEST123");
            Log.i("test", jsonObj.toString());
            mWebSocketClient.send(jsonObj.toString());
            return jsonObj;
        }
        catch (Exception e) {
        }
        return err;
    }

    //Send cooking information to the server
    public void serverSend(String targetTime, String targetTemperature)
    {
        try {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("Request", "start");
            jsonObj.put("Serial", "TEST123");
            jsonObj.put("ETA", targetTime);
            jsonObj.put("RequiredTemp", targetTemperature);
            mWebSocketClient.send(jsonObj.toString());
        }
        catch (Exception e){}
    }
}
