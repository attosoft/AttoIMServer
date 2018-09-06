package cn.id0755.im.server.utils;

import java.util.HashMap;
import java.util.Map;

import cn.id0755.im.chat.proto.Login;
import cn.id0755.im.chat.proto.Message;

public class MessageUtil {
    private static final Map<Class, Message.CMD_ID> mCmdIdMap = new HashMap<Class, Message.CMD_ID>();

    static {
        mCmdIdMap.put(Login.LoginRequest.class, Message.CMD_ID.CMD_LOGIN_REQ);
        mCmdIdMap.put(Login.LoginResponse.class, Message.CMD_ID.CMD_LOGIN_RESP);
    }

    public static Message.MessageData wrap(com.google.protobuf.AbstractMessageLite messageLite) {
        if (messageLite == null || !mCmdIdMap.containsKey(messageLite.getClass())) {
            return null;
        }
        Message.MessageData.Builder builder = Message.MessageData.newBuilder();
        builder.setCmdId(mCmdIdMap.get(messageLite.getClass()));
        builder.setContent(messageLite.toByteString());
        return builder.build();
    }
}
