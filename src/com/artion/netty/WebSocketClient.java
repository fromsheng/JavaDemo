package com.artion.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PingWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * This is an example of a WebSocket client.
 * <p>
 * In order to run this example you need a compatible WebSocket server.
 * Therefore you can either start the WebSocket server from the examples
 * by running {@link io.netty.example.http.websocketx.server.WebSocketServer}
 * or connect to an existing WebSocket server such as
 * <a href="http://www.websocket.org/echo.html">ws://echo.websocket.org</a>.
 * <p>
 * The client will attempt to connect to the URI passed to it as the first argument.
 * You don't have to specify any arguments if you want to connect to the example WebSocket server,
 * as this is the default.
 */
public final class WebSocketClient {

    private String serverUrl;
    private EventLoopGroup group;
    private Channel channel;
    private String id;
    
    public WebSocketClient(String serverUrl, String id)
    {
    	this.serverUrl = serverUrl;
    	group = new NioEventLoopGroup();
    	this.id = id;
    }
    
    public void connect() throws Exception
    {
    	
        URI uri = new URI(serverUrl);
        String scheme = uri.getScheme() == null? "http" : uri.getScheme();
        final String host = uri.getHost() == null? "127.0.0.1" : uri.getHost();
        final int port;
        if (uri.getPort() == -1) {
            if ("http".equalsIgnoreCase(scheme)) {
                port = 80;
            } else if ("https".equalsIgnoreCase(scheme)) {
                port = 443;
            } else {
                port = -1;
            }
        } else {
            port = uri.getPort();
        }
        if (!"ws".equalsIgnoreCase(scheme) && !"wss".equalsIgnoreCase(scheme)) {
            System.err.println("Only WS(S) is supported.");
            return;
        }
        
        try {
        	
        	DefaultHttpHeaders header = new DefaultHttpHeaders();
        	header.add("openToken", "c29jeTBrdzBXhmHXbVwVARja00vrscjl75N7NoM1Q-ocRlfbQBSKeRC7QkSm7QB-SZ-y8yxZQTnCcFrh404Bs9Cu-wRmGHMB4gU9xbzZ8yFSRfHyqh636s7gOBg_RWX-f7VMX-0uHJdtjoUQ7ilxsszUHjG5Qmz0BRYuNh6ZO8Xch4OKu2uweUn7xA2hubMS");
//        	header.add("User-Agent","10204/4.2.5;iPhone OS 7.1;Apple;x86_64;102/10109");
        	header.add("User-Agent","10201/6.0.4;Android4.4.2;Huawei;HUAWEI MT7-TL00;102;1080*1812");
        	
            // Connect with V13 (RFC 6455 aka HyBi-17). You can change it to V08 or V00.
            // If you change it to V00, ping is not supported and remember to change
            // HttpResponseDecoder to WebSocketHttpResponseDecoder in the pipeline.
            final WebSocketClientHandler handler =
                    new WebSocketClientHandler(
                            WebSocketClientHandshakerFactory.newHandshaker(
                                    uri, WebSocketVersion.V13, null, false, header),id);

            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .handler(new ChannelInitializer<SocketChannel>() {
                 @Override
                 protected void initChannel(SocketChannel ch) {
                     ChannelPipeline p = ch.pipeline();
                     p.addLast(
                             new HttpClientCodec(),
                             new HttpObjectAggregator(8192),
                             handler);
                 }
             });

            channel = b.connect(uri.getHost(), port).sync().channel();
            handler.handshakeFuture().sync();
        } finally {
            
        }
    }
    
    public void sendMsg(String msg)
    {
    	System.out.println(msg);
        WebSocketFrame frame = new TextWebSocketFrame(msg);
        channel.writeAndFlush(frame);
    }
    
    public void ping()
    {
        WebSocketFrame frame = new PingWebSocketFrame(Unpooled.wrappedBuffer(new byte[] { 8, 1, 8, 1 }));
        channel.writeAndFlush(frame);
    }
    
    public void cmdPing()
    {
    	String cmd = "{cmd:\"ping\"}";
    	sendMsg(cmd);
    }
    
    public void close() throws InterruptedException
    {
    	channel.writeAndFlush(new CloseWebSocketFrame());
    	channel.closeFuture().sync();
    	
    }
    
    public void shutdown()
    {
    	group.shutdownGracefully();
    }
    
    public static String getCmdQueryByKey(String cmdKey) {
    	if(cmdKey == null) {
    		return null;
    	}
    	return "{cmd:\"" + cmdKey + "\", type:\"query\"}";
    }
    
    public static String getCmdQueryByKey(String cmdKey, String lastUpdateTime) {
        if(cmdKey == null) {
            return cmdKey;
        }
        StringBuffer sb = new StringBuffer();
        sb.append("{cmd:\"");
        sb.append(cmdKey);
        sb.append("\", type:\"query\"");
        if(lastUpdateTime != null) {
            sb.append(",lastUpdateTime:\"");
            sb.append(lastUpdateTime);
            sb.append("\"");
        }
        sb.append("}");

        return sb.toString();
    }
    
    
    public static void main(String[] args) throws Exception {
    	
//    	String url = System.getProperty("url", "ws://127.0.0.1:8090/xuntong/websocket");    	
    	String url = "wss://192.168.22.142:80/xuntong/websocket";  //dev 
//    	String url = "ws://172.20.192.10:80/xuntong/websocket";  //devTest 
//     	String url = "ws://websocket.yunzhijia.com:80/xuntong/websocket";   
//    	String url = "ws://120.131.8.203:80/xuntong/websocket"; //金山云  
 //   	String url = "ws://118.194.40.32:80/xuntong/websocket";  //kdtest  金山云 
//   	String url = "ws://dotest.kdweibo.cn:80/xuntong/websocket";  //kdtest 
    	System.out.println("uri == " + url);
    	WebSocketClient client = new WebSocketClient(url,"0001");
    	client.connect();
    	try{
	        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
	        while (true) {
	            String msg = console.readLine();
	            System.out.println("msg== " + msg);
	            if (msg == null) {
	                break;
	            } else if ("bye".equals(msg.toLowerCase())) {
	            	client.close();
	                break;
	            } else if ("ping".equals(msg.toLowerCase())) {
	            	client.ping();
	            } else if ("cmdping".equals(msg.toLowerCase())) {
	            	client.cmdPing();
	            } else {
//	            	client.sendMsg(msg);
	            	client.sendMsg(getCmdQueryByKey(msg, "2014"));
	            }
	        }
    	}finally{
    		client.shutdown();
    	}

    }
}