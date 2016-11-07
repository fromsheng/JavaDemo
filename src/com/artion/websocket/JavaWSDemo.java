package com.artion.websocket;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

public class JavaWSDemo extends WebSocketClient {

	public JavaWSDemo(URI serverUri, Draft protocolDraft,
			Map<String, String> httpHeaders, int connectTimeout) {
		super(serverUri, protocolDraft, httpHeaders, connectTimeout);
	}

	public JavaWSDemo(URI serverUri, Draft draft) {
		super(serverUri, draft);
	}

	public JavaWSDemo(URI serverURI) {
		super(serverURI);
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		 // The codecodes are documented in class org.java_websocket.framing.CloseFrame  
        System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) );  
	}

	@Override
	public void onError( Exception ex ) {
		 ex.printStackTrace();  
         // if the error is fatal then onClose will be called additionally  
	}

	@Override
	public void onMessage(String message) {
		System.out.println( "received: " + message );  
	}

	@Override
	public void onOpen(ServerHandshake arg0) {
		System.out.println( "opened connection" );  
	}

	
	public static void main(String[] args) {
		JavaWSDemo c;
		try {
//			String uri =  "ws://websocket.yunzhijia.com?openToken=MjZ0NnZjNjl8t_NlbTLEzKt-Z1QQ2Pvcso7R00sbADm8PSvDNbgX7lKSbex2kJoaIyvGti8Ci5TckIANf0XzNxRMgf_5Dxti14Hjw7KQ_P85l7vUVurQXGgdGQNmgrnKESTJVSVV2WHLP9ECLBInrGvmGISePu1TlbNDAx2FEdU" ;
			String uri = "wss://real.okcoin.cn:10440/websocket/okcoinapi";
			System.out.println( "uri: " + uri );  
			c = new JavaWSDemo( new URI(uri), new Draft_17());
			c.connect(); 
//			c.send("handshake");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
          
	}
}
