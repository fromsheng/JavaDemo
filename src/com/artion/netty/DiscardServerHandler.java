package com.artion.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.Charset;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
//		String recStr = new String(((String) msg).getBytes(), Charset.forName("UTF-8"));
//        //收到消息直接打印输出
//        System.out.println(ctx.channel().remoteAddress()+ "say :"+recStr);
		
		System.out.println("hello from client");
        //返回客户端 
        ctx.writeAndFlush("Received your message!");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

}
