package com.google.protobuf;

import java.io.IOException;
/* compiled from: MessageLite.java */
/* loaded from: classes.dex */
public interface e0 extends f0 {

    /* compiled from: MessageLite.java */
    /* loaded from: classes.dex */
    public interface a extends f0, Cloneable {
        e0 build();

        e0 buildPartial();

        a mergeFrom(i iVar, q qVar) throws IOException;

        a mergeFrom(byte[] bArr) throws InvalidProtocolBufferException;
    }

    l0<? extends e0> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    byte[] toByteArray();

    ByteString toByteString();

    void writeTo(CodedOutputStream codedOutputStream) throws IOException;
}
