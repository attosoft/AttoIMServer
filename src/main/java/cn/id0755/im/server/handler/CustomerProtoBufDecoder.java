package cn.id0755.im.server.handler;

import cn.id0755.im.server.utils.L;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class CustomerProtoBufDecoder extends MessageToMessageDecoder<ByteBuf> {
    private static final boolean HAS_PARSER;
    private final MessageLite prototype;
    private final ExtensionRegistryLite extensionRegistry;

    public CustomerProtoBufDecoder(MessageLite prototype) {
        this(prototype, (ExtensionRegistry) null);
    }

    public CustomerProtoBufDecoder(MessageLite prototype, ExtensionRegistry extensionRegistry) {
        this(prototype, (ExtensionRegistryLite) extensionRegistry);
    }

    public CustomerProtoBufDecoder(MessageLite prototype, ExtensionRegistryLite extensionRegistry) {
        if (prototype == null) {
            throw new NullPointerException("prototype");
        } else {
            this.prototype = prototype.getDefaultInstanceForType();
            this.extensionRegistry = extensionRegistry;
        }
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        msg.markReaderIndex();
        int protoType = msg.readInt();
        msg.resetReaderIndex();
        if (protoType == 0) {

        } else if (protoType == 1) {

        } else {

        }

        L.d("Decoder", "decode:" + protoType);

        int length = msg.readableBytes();
        byte[] array;
        int offset;
        if (msg.hasArray()) {
            array = msg.array();
            offset = msg.arrayOffset() + msg.readerIndex();
        } else {
            array = new byte[length];
            msg.getBytes(msg.readerIndex(), array, 0, length);
            offset = 0;
        }

        if (this.extensionRegistry == null) {
            if (HAS_PARSER) {
                out.add(this.prototype.getParserForType().parseFrom(array, offset, length));
            } else {
                out.add(this.prototype.newBuilderForType().mergeFrom(array, offset, length).build());
            }
        } else if (HAS_PARSER) {
            out.add(this.prototype.getParserForType().parseFrom(array, offset, length, this.extensionRegistry));
        } else {
            out.add(this.prototype.newBuilderForType().mergeFrom(array, offset, length, this.extensionRegistry).build());
        }

    }

    static {
        boolean hasParser = false;

        try {
            MessageLite.class.getDeclaredMethod("getParserForType");
            hasParser = true;
        } catch (Throwable var2) {
            ;
        }

        HAS_PARSER = hasParser;
    }
}
