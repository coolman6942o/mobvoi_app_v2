package com.google.protobuf;

import java.io.InputStream;
/* compiled from: Parser.java */
/* loaded from: classes.dex */
public interface l0<MessageType> {
    MessageType parseDelimitedFrom(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType parseDelimitedFrom(InputStream inputStream, q qVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString byteString) throws InvalidProtocolBufferException;

    MessageType parseFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(i iVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(i iVar, q qVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream inputStream) throws InvalidProtocolBufferException;

    MessageType parseFrom(InputStream inputStream, q qVar) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] bArr) throws InvalidProtocolBufferException;

    MessageType parseFrom(byte[] bArr, q qVar) throws InvalidProtocolBufferException;

    MessageType parsePartialFrom(i iVar, q qVar) throws InvalidProtocolBufferException;
}
