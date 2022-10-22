package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.u;
/* loaded from: classes.dex */
public enum Syntax implements m0 {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);
    
    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    private final int value;
    private static final u.b<Syntax> internalValueMap = new u.b<Syntax>() { // from class: com.google.protobuf.Syntax.a
    };
    private static final Syntax[] VALUES = values();

    Syntax(int i10) {
        this.value = i10;
    }

    public static Syntax forNumber(int i10) {
        if (i10 == 0) {
            return SYNTAX_PROTO2;
        }
        if (i10 != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static final Descriptors.d getDescriptor() {
        return z0.b().i().get(0);
    }

    public static u.b<Syntax> internalGetValueMap() {
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
    public static Syntax valueOf(int i10) {
        return forNumber(i10);
    }

    public static Syntax valueOf(Descriptors.e eVar) {
        if (eVar.g() != getDescriptor()) {
            throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        } else if (eVar.f() == -1) {
            return UNRECOGNIZED;
        } else {
            return VALUES[eVar.f()];
        }
    }
}
