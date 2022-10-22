package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.e0;
/* compiled from: Message.java */
/* loaded from: classes.dex */
public interface d0 extends e0, g0 {

    /* compiled from: Message.java */
    /* loaded from: classes.dex */
    public interface a extends e0.a, g0 {
        a addRepeatedField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        @Override // 
        d0 build();

        @Override // 
        d0 buildPartial();

        a clearField(Descriptors.FieldDescriptor fieldDescriptor);

        Descriptors.b getDescriptorForType();

        a mergeFrom(ByteString byteString, q qVar) throws InvalidProtocolBufferException;

        a mergeFrom(d0 d0Var);

        a newBuilderForField(Descriptors.FieldDescriptor fieldDescriptor);

        a setField(Descriptors.FieldDescriptor fieldDescriptor, Object obj);

        a setUnknownFields(a1 a1Var);
    }

    @Override // 
    l0<? extends d0> getParserForType();

    @Override // 
    a newBuilderForType();

    @Override // 
    a toBuilder();
}
