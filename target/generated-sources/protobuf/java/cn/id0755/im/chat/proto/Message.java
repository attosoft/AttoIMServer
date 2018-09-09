// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Message.proto

package cn.id0755.im.chat.proto;

public final class Message {
  private Message() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code cn.id0755.im.chat.proto.CMD_ID}
   */
  public enum CMD_ID
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <pre>
     *    CMD_ID_INVALID = -1;
     * </pre>
     *
     * <code>CMD_UNKNOWN = 0;</code>
     */
    CMD_UNKNOWN(0),
    /**
     * <code>CMD_HELLO = 1;</code>
     */
    CMD_HELLO(1),
    /**
     * <code>CMD_AUTH = 2;</code>
     */
    CMD_AUTH(2),
    /**
     * <code>CMD_SEND_MESSAGE = 3;</code>
     */
    CMD_SEND_MESSAGE(3),
    /**
     * <code>CMD_CONVERSATION_LIST = 4;</code>
     */
    CMD_CONVERSATION_LIST(4),
    /**
     * <code>CMD_JOINTOPIC = 5;</code>
     */
    CMD_JOINTOPIC(5),
    /**
     * <code>CMD_LEFTTOPIC = 7;</code>
     */
    CMD_LEFTTOPIC(7),
    /**
     * <code>LOGIN_REQ = 8;</code>
     */
    LOGIN_REQ(8),
    /**
     * <code>LOGIN_RESP = 9;</code>
     */
    LOGIN_RESP(9),
    /**
     * <code>PING = 10;</code>
     */
    PING(10),
    /**
     * <code>PONG = 11;</code>
     */
    PONG(11),
    UNRECOGNIZED(-1),
    ;

    /**
     * <pre>
     *    CMD_ID_INVALID = -1;
     * </pre>
     *
     * <code>CMD_UNKNOWN = 0;</code>
     */
    public static final int CMD_UNKNOWN_VALUE = 0;
    /**
     * <code>CMD_HELLO = 1;</code>
     */
    public static final int CMD_HELLO_VALUE = 1;
    /**
     * <code>CMD_AUTH = 2;</code>
     */
    public static final int CMD_AUTH_VALUE = 2;
    /**
     * <code>CMD_SEND_MESSAGE = 3;</code>
     */
    public static final int CMD_SEND_MESSAGE_VALUE = 3;
    /**
     * <code>CMD_CONVERSATION_LIST = 4;</code>
     */
    public static final int CMD_CONVERSATION_LIST_VALUE = 4;
    /**
     * <code>CMD_JOINTOPIC = 5;</code>
     */
    public static final int CMD_JOINTOPIC_VALUE = 5;
    /**
     * <code>CMD_LEFTTOPIC = 7;</code>
     */
    public static final int CMD_LEFTTOPIC_VALUE = 7;
    /**
     * <code>LOGIN_REQ = 8;</code>
     */
    public static final int LOGIN_REQ_VALUE = 8;
    /**
     * <code>LOGIN_RESP = 9;</code>
     */
    public static final int LOGIN_RESP_VALUE = 9;
    /**
     * <code>PING = 10;</code>
     */
    public static final int PING_VALUE = 10;
    /**
     * <code>PONG = 11;</code>
     */
    public static final int PONG_VALUE = 11;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static CMD_ID valueOf(int value) {
      return forNumber(value);
    }

    public static CMD_ID forNumber(int value) {
      switch (value) {
        case 0: return CMD_UNKNOWN;
        case 1: return CMD_HELLO;
        case 2: return CMD_AUTH;
        case 3: return CMD_SEND_MESSAGE;
        case 4: return CMD_CONVERSATION_LIST;
        case 5: return CMD_JOINTOPIC;
        case 7: return CMD_LEFTTOPIC;
        case 8: return LOGIN_REQ;
        case 9: return LOGIN_RESP;
        case 10: return PING;
        case 11: return PONG;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<CMD_ID>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        CMD_ID> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<CMD_ID>() {
            public CMD_ID findValueByNumber(int number) {
              return CMD_ID.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return cn.id0755.im.chat.proto.Message.getDescriptor().getEnumTypes().get(0);
    }

    private static final CMD_ID[] VALUES = values();

    public static CMD_ID valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private CMD_ID(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:cn.id0755.im.chat.proto.CMD_ID)
  }

  public interface MessageDataOrBuilder extends
      // @@protoc_insertion_point(interface_extends:cn.id0755.im.chat.proto.MessageData)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.cn.id0755.im.chat.proto.CMD_ID cmdId = 1;</code>
     */
    int getCmdIdValue();
    /**
     * <code>.cn.id0755.im.chat.proto.CMD_ID cmdId = 1;</code>
     */
    cn.id0755.im.chat.proto.Message.CMD_ID getCmdId();

    /**
     * <code>bytes content = 2;</code>
     */
    com.google.protobuf.ByteString getContent();
  }
  /**
   * Protobuf type {@code cn.id0755.im.chat.proto.MessageData}
   */
  public  static final class MessageData extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:cn.id0755.im.chat.proto.MessageData)
      MessageDataOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use MessageData.newBuilder() to construct.
    private MessageData(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private MessageData() {
      cmdId_ = 0;
      content_ = com.google.protobuf.ByteString.EMPTY;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private MessageData(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 8: {
              int rawValue = input.readEnum();

              cmdId_ = rawValue;
              break;
            }
            case 18: {

              content_ = input.readBytes();
              break;
            }
            default: {
              if (!parseUnknownFieldProto3(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.id0755.im.chat.proto.Message.internal_static_cn_id0755_im_chat_proto_MessageData_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.id0755.im.chat.proto.Message.internal_static_cn_id0755_im_chat_proto_MessageData_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.id0755.im.chat.proto.Message.MessageData.class, cn.id0755.im.chat.proto.Message.MessageData.Builder.class);
    }

    public static final int CMDID_FIELD_NUMBER = 1;
    private int cmdId_;
    /**
     * <code>.cn.id0755.im.chat.proto.CMD_ID cmdId = 1;</code>
     */
    public int getCmdIdValue() {
      return cmdId_;
    }
    /**
     * <code>.cn.id0755.im.chat.proto.CMD_ID cmdId = 1;</code>
     */
    public cn.id0755.im.chat.proto.Message.CMD_ID getCmdId() {
      @SuppressWarnings("deprecation")
      cn.id0755.im.chat.proto.Message.CMD_ID result = cn.id0755.im.chat.proto.Message.CMD_ID.valueOf(cmdId_);
      return result == null ? cn.id0755.im.chat.proto.Message.CMD_ID.UNRECOGNIZED : result;
    }

    public static final int CONTENT_FIELD_NUMBER = 2;
    private com.google.protobuf.ByteString content_;
    /**
     * <code>bytes content = 2;</code>
     */
    public com.google.protobuf.ByteString getContent() {
      return content_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (cmdId_ != cn.id0755.im.chat.proto.Message.CMD_ID.CMD_UNKNOWN.getNumber()) {
        output.writeEnum(1, cmdId_);
      }
      if (!content_.isEmpty()) {
        output.writeBytes(2, content_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (cmdId_ != cn.id0755.im.chat.proto.Message.CMD_ID.CMD_UNKNOWN.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(1, cmdId_);
      }
      if (!content_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, content_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof cn.id0755.im.chat.proto.Message.MessageData)) {
        return super.equals(obj);
      }
      cn.id0755.im.chat.proto.Message.MessageData other = (cn.id0755.im.chat.proto.Message.MessageData) obj;

      boolean result = true;
      result = result && cmdId_ == other.cmdId_;
      result = result && getContent()
          .equals(other.getContent());
      result = result && unknownFields.equals(other.unknownFields);
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + CMDID_FIELD_NUMBER;
      hash = (53 * hash) + cmdId_;
      hash = (37 * hash) + CONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getContent().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static cn.id0755.im.chat.proto.Message.MessageData parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static cn.id0755.im.chat.proto.Message.MessageData parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(cn.id0755.im.chat.proto.Message.MessageData prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code cn.id0755.im.chat.proto.MessageData}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:cn.id0755.im.chat.proto.MessageData)
        cn.id0755.im.chat.proto.Message.MessageDataOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return cn.id0755.im.chat.proto.Message.internal_static_cn_id0755_im_chat_proto_MessageData_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return cn.id0755.im.chat.proto.Message.internal_static_cn_id0755_im_chat_proto_MessageData_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                cn.id0755.im.chat.proto.Message.MessageData.class, cn.id0755.im.chat.proto.Message.MessageData.Builder.class);
      }

      // Construct using cn.id0755.im.chat.proto.Message.MessageData.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        cmdId_ = 0;

        content_ = com.google.protobuf.ByteString.EMPTY;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return cn.id0755.im.chat.proto.Message.internal_static_cn_id0755_im_chat_proto_MessageData_descriptor;
      }

      @java.lang.Override
      public cn.id0755.im.chat.proto.Message.MessageData getDefaultInstanceForType() {
        return cn.id0755.im.chat.proto.Message.MessageData.getDefaultInstance();
      }

      @java.lang.Override
      public cn.id0755.im.chat.proto.Message.MessageData build() {
        cn.id0755.im.chat.proto.Message.MessageData result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public cn.id0755.im.chat.proto.Message.MessageData buildPartial() {
        cn.id0755.im.chat.proto.Message.MessageData result = new cn.id0755.im.chat.proto.Message.MessageData(this);
        result.cmdId_ = cmdId_;
        result.content_ = content_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return (Builder) super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof cn.id0755.im.chat.proto.Message.MessageData) {
          return mergeFrom((cn.id0755.im.chat.proto.Message.MessageData)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(cn.id0755.im.chat.proto.Message.MessageData other) {
        if (other == cn.id0755.im.chat.proto.Message.MessageData.getDefaultInstance()) return this;
        if (other.cmdId_ != 0) {
          setCmdIdValue(other.getCmdIdValue());
        }
        if (other.getContent() != com.google.protobuf.ByteString.EMPTY) {
          setContent(other.getContent());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        cn.id0755.im.chat.proto.Message.MessageData parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (cn.id0755.im.chat.proto.Message.MessageData) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int cmdId_ = 0;
      /**
       * <code>.cn.id0755.im.chat.proto.CMD_ID cmdId = 1;</code>
       */
      public int getCmdIdValue() {
        return cmdId_;
      }
      /**
       * <code>.cn.id0755.im.chat.proto.CMD_ID cmdId = 1;</code>
       */
      public Builder setCmdIdValue(int value) {
        cmdId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>.cn.id0755.im.chat.proto.CMD_ID cmdId = 1;</code>
       */
      public cn.id0755.im.chat.proto.Message.CMD_ID getCmdId() {
        @SuppressWarnings("deprecation")
        cn.id0755.im.chat.proto.Message.CMD_ID result = cn.id0755.im.chat.proto.Message.CMD_ID.valueOf(cmdId_);
        return result == null ? cn.id0755.im.chat.proto.Message.CMD_ID.UNRECOGNIZED : result;
      }
      /**
       * <code>.cn.id0755.im.chat.proto.CMD_ID cmdId = 1;</code>
       */
      public Builder setCmdId(cn.id0755.im.chat.proto.Message.CMD_ID value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        cmdId_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>.cn.id0755.im.chat.proto.CMD_ID cmdId = 1;</code>
       */
      public Builder clearCmdId() {
        
        cmdId_ = 0;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString content_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes content = 2;</code>
       */
      public com.google.protobuf.ByteString getContent() {
        return content_;
      }
      /**
       * <code>bytes content = 2;</code>
       */
      public Builder setContent(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        content_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes content = 2;</code>
       */
      public Builder clearContent() {
        
        content_ = getDefaultInstance().getContent();
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFieldsProto3(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:cn.id0755.im.chat.proto.MessageData)
    }

    // @@protoc_insertion_point(class_scope:cn.id0755.im.chat.proto.MessageData)
    private static final cn.id0755.im.chat.proto.Message.MessageData DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new cn.id0755.im.chat.proto.Message.MessageData();
    }

    public static cn.id0755.im.chat.proto.Message.MessageData getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<MessageData>
        PARSER = new com.google.protobuf.AbstractParser<MessageData>() {
      @java.lang.Override
      public MessageData parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new MessageData(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<MessageData> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<MessageData> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public cn.id0755.im.chat.proto.Message.MessageData getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_cn_id0755_im_chat_proto_MessageData_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_cn_id0755_im_chat_proto_MessageData_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rMessage.proto\022\027cn.id0755.im.chat.proto" +
      "\"N\n\013MessageData\022.\n\005cmdId\030\001 \001(\0162\037.cn.id07" +
      "55.im.chat.proto.CMD_ID\022\017\n\007content\030\002 \001(\014" +
      "*\300\001\n\006CMD_ID\022\017\n\013CMD_UNKNOWN\020\000\022\r\n\tCMD_HELL" +
      "O\020\001\022\014\n\010CMD_AUTH\020\002\022\024\n\020CMD_SEND_MESSAGE\020\003\022" +
      "\031\n\025CMD_CONVERSATION_LIST\020\004\022\021\n\rCMD_JOINTO" +
      "PIC\020\005\022\021\n\rCMD_LEFTTOPIC\020\007\022\r\n\tLOGIN_REQ\020\010\022" +
      "\016\n\nLOGIN_RESP\020\t\022\010\n\004PING\020\n\022\010\n\004PONG\020\013b\006pro" +
      "to3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_cn_id0755_im_chat_proto_MessageData_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_cn_id0755_im_chat_proto_MessageData_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_cn_id0755_im_chat_proto_MessageData_descriptor,
        new java.lang.String[] { "CmdId", "Content", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
