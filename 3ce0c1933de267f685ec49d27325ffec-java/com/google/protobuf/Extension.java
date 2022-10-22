package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.e0;
/* loaded from: classes.dex */
public abstract class Extension<ContainingType extends e0, Type> extends n<ContainingType, Type> {

    /* loaded from: classes.dex */
    protected enum ExtensionType {
        IMMUTABLE,
        MUTABLE,
        PROTO1
    }

    /* loaded from: classes.dex */
    public enum MessageType {
        PROTO1,
        PROTO2
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.n
    public final boolean b() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object c(Object obj);

    public abstract Descriptors.FieldDescriptor d();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object e(Object obj);
}
