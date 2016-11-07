package com.artion.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

public class TimeClientHandler  extends ChannelInboundHandlerAdapter {

	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
		try {
            System.out.println("hello from server");
            ctx.close();
        } finally {
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
