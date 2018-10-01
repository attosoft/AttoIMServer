package cn.id0755.im.server.service;

import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineClient {
    public final static AttributeKey<String> CLIENT_ID = AttributeKey.newInstance("client_id");
    private static final Map<String, ChannelHandlerContext> mClients = new ConcurrentHashMap<String, ChannelHandlerContext>();

    public static void putClient(String clientId,ChannelHandlerContext handlerContext){
        mClients.put(clientId,handlerContext);
    }

    public static ChannelHandlerContext removeClient(String clientId){
        return mClients.remove(clientId);
    }

    public static Collection<ChannelHandlerContext> allClient(){
        return mClients.values();
    }
}
