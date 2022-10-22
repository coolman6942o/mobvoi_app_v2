package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.Map;
/* compiled from: MessageOrBuilder.java */
/* loaded from: classes.dex */
public interface g0 extends f0 {
    Map<Descriptors.FieldDescriptor, Object> getAllFields();

    @Override // 
    d0 getDefaultInstanceForType();

    Descriptors.b getDescriptorForType();

    Object getField(Descriptors.FieldDescriptor fieldDescriptor);

    a1 getUnknownFields();

    boolean hasField(Descriptors.FieldDescriptor fieldDescriptor);
}
