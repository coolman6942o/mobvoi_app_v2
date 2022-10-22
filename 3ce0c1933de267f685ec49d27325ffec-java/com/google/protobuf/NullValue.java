package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.u;
/* loaded from: classes.dex */
public enum NullValue implements m0 {
    NULL_VALUE(0),
    UNRECOGNIZED(-1);
    
    public static final int NULL_VALUE_VALUE = 0;
    private final int value;
    private static final u.b<NullValue> internalValueMap = new u.b<NullValue>() { // from class: com.google.protobuf.NullValue.a
    };
    private static final NullValue[] VALUES = values();

    NullValue(int i10) {
        this.value = i10;
    }

    public static NullValue forNumber(int i10) {
        if (i10 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static final Descriptors.d getDescriptor() {
        return v0.b().i().get(0);
    }

    public static u.b<NullValue> internalGetValueMap() {
        return internalValueMap;
    }

    public final Descriptors.d getDescriptorForType() {
        return getDescriptor();
    }

    @Override // com.google.protobuf.u.a
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public final Descriptors.e getValueDescriptor() {
        return getDescriptor().i().get(ordinal());
    }

    @Deprecated
    public static NullValue valueOf(int i10) {
        return forNumber(i10);
    }

    public static NullValue valueOf(Descriptors.e eVar) {
        if (eVar.g() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        } else if (eVar.f() == -1) {
            return UNRECOGNIZED;
        } else {
            return VALUES[eVar.f()];
        }
    }
}
