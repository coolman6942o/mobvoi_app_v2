package com.google.protobuf;

import com.google.protobuf.b;
import com.google.protobuf.e0;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: AbstractParser.java */
/* loaded from: classes.dex */
public abstract class c<MessageType extends e0> implements l0<MessageType> {
    private static final q EMPTY_REGISTRY = q.a();

    private MessageType checkMessageInitialized(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw newUninitializedMessageException(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    private UninitializedMessageException newUninitializedMessageException(MessageType messagetype) {
        if (messagetype instanceof b) {
            return ((b) messagetype).newUninitializedMessageException();
        }
        return new UninitializedMessageException(messagetype);
    }

    @Override // com.google.protobuf.l0
    public MessageType parseDelimitedFrom(InputStream inputStream, q qVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialDelimitedFrom(inputStream, qVar));
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream, q qVar) throws InvalidProtocolBufferException {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            return parsePartialFrom((InputStream) new b.a.C0171a(inputStream, i.y(read, inputStream)), qVar);
        } catch (IOException e10) {
            throw new InvalidProtocolBufferException(e10.getMessage());
        }
    }

    @Override // com.google.protobuf.l0
    public MessageType parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parseDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }

    public MessageType parsePartialDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parsePartialDelimitedFrom(inputStream, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(i iVar) throws InvalidProtocolBufferException {
        return (MessageType) parsePartialFrom(iVar, EMPTY_REGISTRY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.l0
    public MessageType parseFrom(i iVar, q qVar) throws InvalidProtocolBufferException {
        return (MessageType) checkMessageInitialized((e0) parsePartialFrom(iVar, qVar));
    }

    public MessageType parsePartialFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        try {
            i newCodedInput = byteString.newCodedInput();
            MessageType messagetype = (MessageType) parsePartialFrom(newCodedInput, qVar);
            try {
                newCodedInput.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e10) {
                throw e10.setUnfinishedMessage(messagetype);
            }
        } catch (InvalidProtocolBufferException e11) {
            throw e11;
        }
    }

    @Override // com.google.protobuf.l0
    public MessageType parseFrom(i iVar) throws InvalidProtocolBufferException {
        return parseFrom(iVar, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.l0
    public MessageType parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(byteString, qVar));
    }

    @Override // com.google.protobuf.l0
    public MessageType parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return parseFrom(byteString, EMPTY_REGISTRY);
    }

    public MessageType parseFrom(byte[] bArr, int i10, int i11, q qVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(bArr, i10, i11, qVar));
    }

    public MessageType parsePartialFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return parsePartialFrom(byteString, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(byte[] bArr, int i10, int i11, q qVar) throws InvalidProtocolBufferException {
        try {
            i h10 = i.h(bArr, i10, i11);
            MessageType messagetype = (MessageType) parsePartialFrom(h10, qVar);
            try {
                h10.a(0);
                return messagetype;
            } catch (InvalidProtocolBufferException e10) {
                throw e10.setUnfinishedMessage(messagetype);
            }
        } catch (InvalidProtocolBufferException e11) {
            throw e11;
        }
    }

    public MessageType parseFrom(byte[] bArr, int i10, int i11) throws InvalidProtocolBufferException {
        return parseFrom(bArr, i10, i11, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.l0
    public MessageType parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return parseFrom(bArr, 0, bArr.length, qVar);
    }

    @Override // com.google.protobuf.l0
    public MessageType parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return parseFrom(bArr, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.l0
    public MessageType parseFrom(InputStream inputStream, q qVar) throws InvalidProtocolBufferException {
        return checkMessageInitialized(parsePartialFrom(inputStream, qVar));
    }

    public MessageType parsePartialFrom(byte[] bArr, int i10, int i11) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, i10, i11, EMPTY_REGISTRY);
    }

    @Override // com.google.protobuf.l0
    public MessageType parseFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parseFrom(inputStream, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, 0, bArr.length, qVar);
    }

    public MessageType parsePartialFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return parsePartialFrom(bArr, 0, bArr.length, EMPTY_REGISTRY);
    }

    public MessageType parsePartialFrom(InputStream inputStream, q qVar) throws InvalidProtocolBufferException {
        i e10 = i.e(inputStream);
        MessageType messagetype = (MessageType) parsePartialFrom(e10, qVar);
        try {
            e10.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e11) {
            throw e11.setUnfinishedMessage(messagetype);
        }
    }

    public MessageType parsePartialFrom(InputStream inputStream) throws InvalidProtocolBufferException {
        return parsePartialFrom(inputStream, EMPTY_REGISTRY);
    }
}
