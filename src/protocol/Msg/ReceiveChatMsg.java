// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ReceiveChatMsg.proto

package protocol.Msg;

public final class ReceiveChatMsg {
  private ReceiveChatMsg() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface ReceiveChatSyncOrBuilder extends
      // @@protoc_insertion_point(interface_extends:protocol.ReceiveChatSync)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .protocol.ChatItem chatData = 1;</code>
     */
    java.util.List<protocol.Data.ChatData.ChatItem> 
        getChatDataList();
    /**
     * <code>repeated .protocol.ChatItem chatData = 1;</code>
     */
    protocol.Data.ChatData.ChatItem getChatData(int index);
    /**
     * <code>repeated .protocol.ChatItem chatData = 1;</code>
     */
    int getChatDataCount();
    /**
     * <code>repeated .protocol.ChatItem chatData = 1;</code>
     */
    java.util.List<? extends protocol.Data.ChatData.ChatItemOrBuilder> 
        getChatDataOrBuilderList();
    /**
     * <code>repeated .protocol.ChatItem chatData = 1;</code>
     */
    protocol.Data.ChatData.ChatItemOrBuilder getChatDataOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code protocol.ReceiveChatSync}
   */
  public static final class ReceiveChatSync extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:protocol.ReceiveChatSync)
      ReceiveChatSyncOrBuilder {
    // Use ReceiveChatSync.newBuilder() to construct.
    private ReceiveChatSync(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private ReceiveChatSync(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final ReceiveChatSync defaultInstance;
    public static ReceiveChatSync getDefaultInstance() {
      return defaultInstance;
    }

    public ReceiveChatSync getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private ReceiveChatSync(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
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
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                chatData_ = new java.util.ArrayList<protocol.Data.ChatData.ChatItem>();
                mutable_bitField0_ |= 0x00000001;
              }
              chatData_.add(input.readMessage(protocol.Data.ChatData.ChatItem.PARSER, extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          chatData_ = java.util.Collections.unmodifiableList(chatData_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return protocol.Msg.ReceiveChatMsg.internal_static_protocol_ReceiveChatSync_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return protocol.Msg.ReceiveChatMsg.internal_static_protocol_ReceiveChatSync_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              protocol.Msg.ReceiveChatMsg.ReceiveChatSync.class, protocol.Msg.ReceiveChatMsg.ReceiveChatSync.Builder.class);
    }

    public static com.google.protobuf.Parser<ReceiveChatSync> PARSER =
        new com.google.protobuf.AbstractParser<ReceiveChatSync>() {
      public ReceiveChatSync parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ReceiveChatSync(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<ReceiveChatSync> getParserForType() {
      return PARSER;
    }

    public static final int CHATDATA_FIELD_NUMBER = 1;
    private java.util.List<protocol.Data.ChatData.ChatItem> chatData_;
    /**
     * <code>repeated .protocol.ChatItem chatData = 1;</code>
     */
    public java.util.List<protocol.Data.ChatData.ChatItem> getChatDataList() {
      return chatData_;
    }
    /**
     * <code>repeated .protocol.ChatItem chatData = 1;</code>
     */
    public java.util.List<? extends protocol.Data.ChatData.ChatItemOrBuilder> 
        getChatDataOrBuilderList() {
      return chatData_;
    }
    /**
     * <code>repeated .protocol.ChatItem chatData = 1;</code>
     */
    public int getChatDataCount() {
      return chatData_.size();
    }
    /**
     * <code>repeated .protocol.ChatItem chatData = 1;</code>
     */
    public protocol.Data.ChatData.ChatItem getChatData(int index) {
      return chatData_.get(index);
    }
    /**
     * <code>repeated .protocol.ChatItem chatData = 1;</code>
     */
    public protocol.Data.ChatData.ChatItemOrBuilder getChatDataOrBuilder(
        int index) {
      return chatData_.get(index);
    }

    private void initFields() {
      chatData_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      for (int i = 0; i < getChatDataCount(); i++) {
        if (!getChatData(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < chatData_.size(); i++) {
        output.writeMessage(1, chatData_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < chatData_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, chatData_.get(i));
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static protocol.Msg.ReceiveChatMsg.ReceiveChatSync parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protocol.Msg.ReceiveChatMsg.ReceiveChatSync parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protocol.Msg.ReceiveChatMsg.ReceiveChatSync parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static protocol.Msg.ReceiveChatMsg.ReceiveChatSync parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static protocol.Msg.ReceiveChatMsg.ReceiveChatSync parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protocol.Msg.ReceiveChatMsg.ReceiveChatSync parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static protocol.Msg.ReceiveChatMsg.ReceiveChatSync parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static protocol.Msg.ReceiveChatMsg.ReceiveChatSync parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static protocol.Msg.ReceiveChatMsg.ReceiveChatSync parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static protocol.Msg.ReceiveChatMsg.ReceiveChatSync parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(protocol.Msg.ReceiveChatMsg.ReceiveChatSync prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code protocol.ReceiveChatSync}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:protocol.ReceiveChatSync)
        protocol.Msg.ReceiveChatMsg.ReceiveChatSyncOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return protocol.Msg.ReceiveChatMsg.internal_static_protocol_ReceiveChatSync_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return protocol.Msg.ReceiveChatMsg.internal_static_protocol_ReceiveChatSync_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                protocol.Msg.ReceiveChatMsg.ReceiveChatSync.class, protocol.Msg.ReceiveChatMsg.ReceiveChatSync.Builder.class);
      }

      // Construct using protocol.Msg.ReceiveChatMsg.ReceiveChatSync.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
          getChatDataFieldBuilder();
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        if (chatDataBuilder_ == null) {
          chatData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          chatDataBuilder_.clear();
        }
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return protocol.Msg.ReceiveChatMsg.internal_static_protocol_ReceiveChatSync_descriptor;
      }

      public protocol.Msg.ReceiveChatMsg.ReceiveChatSync getDefaultInstanceForType() {
        return protocol.Msg.ReceiveChatMsg.ReceiveChatSync.getDefaultInstance();
      }

      public protocol.Msg.ReceiveChatMsg.ReceiveChatSync build() {
        protocol.Msg.ReceiveChatMsg.ReceiveChatSync result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public protocol.Msg.ReceiveChatMsg.ReceiveChatSync buildPartial() {
        protocol.Msg.ReceiveChatMsg.ReceiveChatSync result = new protocol.Msg.ReceiveChatMsg.ReceiveChatSync(this);
        int from_bitField0_ = bitField0_;
        if (chatDataBuilder_ == null) {
          if (((bitField0_ & 0x00000001) == 0x00000001)) {
            chatData_ = java.util.Collections.unmodifiableList(chatData_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.chatData_ = chatData_;
        } else {
          result.chatData_ = chatDataBuilder_.build();
        }
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof protocol.Msg.ReceiveChatMsg.ReceiveChatSync) {
          return mergeFrom((protocol.Msg.ReceiveChatMsg.ReceiveChatSync)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(protocol.Msg.ReceiveChatMsg.ReceiveChatSync other) {
        if (other == protocol.Msg.ReceiveChatMsg.ReceiveChatSync.getDefaultInstance()) return this;
        if (chatDataBuilder_ == null) {
          if (!other.chatData_.isEmpty()) {
            if (chatData_.isEmpty()) {
              chatData_ = other.chatData_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureChatDataIsMutable();
              chatData_.addAll(other.chatData_);
            }
            onChanged();
          }
        } else {
          if (!other.chatData_.isEmpty()) {
            if (chatDataBuilder_.isEmpty()) {
              chatDataBuilder_.dispose();
              chatDataBuilder_ = null;
              chatData_ = other.chatData_;
              bitField0_ = (bitField0_ & ~0x00000001);
              chatDataBuilder_ = 
                com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                   getChatDataFieldBuilder() : null;
            } else {
              chatDataBuilder_.addAllMessages(other.chatData_);
            }
          }
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        for (int i = 0; i < getChatDataCount(); i++) {
          if (!getChatData(i).isInitialized()) {
            
            return false;
          }
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        protocol.Msg.ReceiveChatMsg.ReceiveChatSync parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (protocol.Msg.ReceiveChatMsg.ReceiveChatSync) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<protocol.Data.ChatData.ChatItem> chatData_ =
        java.util.Collections.emptyList();
      private void ensureChatDataIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          chatData_ = new java.util.ArrayList<protocol.Data.ChatData.ChatItem>(chatData_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilder<
          protocol.Data.ChatData.ChatItem, protocol.Data.ChatData.ChatItem.Builder, protocol.Data.ChatData.ChatItemOrBuilder> chatDataBuilder_;

      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public java.util.List<protocol.Data.ChatData.ChatItem> getChatDataList() {
        if (chatDataBuilder_ == null) {
          return java.util.Collections.unmodifiableList(chatData_);
        } else {
          return chatDataBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public int getChatDataCount() {
        if (chatDataBuilder_ == null) {
          return chatData_.size();
        } else {
          return chatDataBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public protocol.Data.ChatData.ChatItem getChatData(int index) {
        if (chatDataBuilder_ == null) {
          return chatData_.get(index);
        } else {
          return chatDataBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public Builder setChatData(
          int index, protocol.Data.ChatData.ChatItem value) {
        if (chatDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureChatDataIsMutable();
          chatData_.set(index, value);
          onChanged();
        } else {
          chatDataBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public Builder setChatData(
          int index, protocol.Data.ChatData.ChatItem.Builder builderForValue) {
        if (chatDataBuilder_ == null) {
          ensureChatDataIsMutable();
          chatData_.set(index, builderForValue.build());
          onChanged();
        } else {
          chatDataBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public Builder addChatData(protocol.Data.ChatData.ChatItem value) {
        if (chatDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureChatDataIsMutable();
          chatData_.add(value);
          onChanged();
        } else {
          chatDataBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public Builder addChatData(
          int index, protocol.Data.ChatData.ChatItem value) {
        if (chatDataBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureChatDataIsMutable();
          chatData_.add(index, value);
          onChanged();
        } else {
          chatDataBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public Builder addChatData(
          protocol.Data.ChatData.ChatItem.Builder builderForValue) {
        if (chatDataBuilder_ == null) {
          ensureChatDataIsMutable();
          chatData_.add(builderForValue.build());
          onChanged();
        } else {
          chatDataBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public Builder addChatData(
          int index, protocol.Data.ChatData.ChatItem.Builder builderForValue) {
        if (chatDataBuilder_ == null) {
          ensureChatDataIsMutable();
          chatData_.add(index, builderForValue.build());
          onChanged();
        } else {
          chatDataBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public Builder addAllChatData(
          java.lang.Iterable<? extends protocol.Data.ChatData.ChatItem> values) {
        if (chatDataBuilder_ == null) {
          ensureChatDataIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, chatData_);
          onChanged();
        } else {
          chatDataBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public Builder clearChatData() {
        if (chatDataBuilder_ == null) {
          chatData_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          chatDataBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public Builder removeChatData(int index) {
        if (chatDataBuilder_ == null) {
          ensureChatDataIsMutable();
          chatData_.remove(index);
          onChanged();
        } else {
          chatDataBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public protocol.Data.ChatData.ChatItem.Builder getChatDataBuilder(
          int index) {
        return getChatDataFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public protocol.Data.ChatData.ChatItemOrBuilder getChatDataOrBuilder(
          int index) {
        if (chatDataBuilder_ == null) {
          return chatData_.get(index);  } else {
          return chatDataBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public java.util.List<? extends protocol.Data.ChatData.ChatItemOrBuilder> 
           getChatDataOrBuilderList() {
        if (chatDataBuilder_ != null) {
          return chatDataBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(chatData_);
        }
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public protocol.Data.ChatData.ChatItem.Builder addChatDataBuilder() {
        return getChatDataFieldBuilder().addBuilder(
            protocol.Data.ChatData.ChatItem.getDefaultInstance());
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public protocol.Data.ChatData.ChatItem.Builder addChatDataBuilder(
          int index) {
        return getChatDataFieldBuilder().addBuilder(
            index, protocol.Data.ChatData.ChatItem.getDefaultInstance());
      }
      /**
       * <code>repeated .protocol.ChatItem chatData = 1;</code>
       */
      public java.util.List<protocol.Data.ChatData.ChatItem.Builder> 
           getChatDataBuilderList() {
        return getChatDataFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilder<
          protocol.Data.ChatData.ChatItem, protocol.Data.ChatData.ChatItem.Builder, protocol.Data.ChatData.ChatItemOrBuilder> 
          getChatDataFieldBuilder() {
        if (chatDataBuilder_ == null) {
          chatDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
              protocol.Data.ChatData.ChatItem, protocol.Data.ChatData.ChatItem.Builder, protocol.Data.ChatData.ChatItemOrBuilder>(
                  chatData_,
                  ((bitField0_ & 0x00000001) == 0x00000001),
                  getParentForChildren(),
                  isClean());
          chatData_ = null;
        }
        return chatDataBuilder_;
      }

      // @@protoc_insertion_point(builder_scope:protocol.ReceiveChatSync)
    }

    static {
      defaultInstance = new ReceiveChatSync(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:protocol.ReceiveChatSync)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_protocol_ReceiveChatSync_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_protocol_ReceiveChatSync_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\024ReceiveChatMsg.proto\022\010protocol\032\016ChatDa" +
      "ta.proto\"7\n\017ReceiveChatSync\022$\n\010chatData\030" +
      "\001 \003(\0132\022.protocol.ChatItemB\016\n\014protocol.Ms" +
      "g"
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
          protocol.Data.ChatData.getDescriptor(),
        }, assigner);
    internal_static_protocol_ReceiveChatSync_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_protocol_ReceiveChatSync_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_protocol_ReceiveChatSync_descriptor,
        new java.lang.String[] { "ChatData", });
    protocol.Data.ChatData.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
