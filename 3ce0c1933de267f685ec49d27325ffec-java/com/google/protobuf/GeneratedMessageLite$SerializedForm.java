package com.google.protobuf;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class GeneratedMessageLite$SerializedForm implements Serializable {
    private static final long serialVersionUID = 0;
    private final byte[] asBytes;
    private final String messageClassName;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeneratedMessageLite$SerializedForm(e0 e0Var) {
        this.messageClassName = e0Var.getClass().getName();
        this.asBytes = e0Var.toByteArray();
    }

    public static GeneratedMessageLite$SerializedForm of(e0 e0Var) {
        return new GeneratedMessageLite$SerializedForm(e0Var);
    }

    @Deprecated
    private Object readResolveFallback() throws ObjectStreamException {
        try {
            Field declaredField = Class.forName(this.messageClassName).getDeclaredField("defaultInstance");
            declaredField.setAccessible(true);
            return ((e0) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
        } catch (InvalidProtocolBufferException e10) {
            throw new RuntimeException("Unable to understand proto buffer", e10);
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException("Unable to call parsePartialFrom", e12);
        } catch (NoSuchFieldException e13) {
            throw new RuntimeException("Unable to find defaultInstance in " + this.messageClassName, e13);
        } catch (SecurityException e14) {
            throw new RuntimeException("Unable to call defaultInstance in " + this.messageClassName, e14);
        }
    }

    protected Object readResolve() throws ObjectStreamException {
        try {
            Field declaredField = Class.forName(this.messageClassName).getDeclaredField("DEFAULT_INSTANCE");
            declaredField.setAccessible(true);
            return ((e0) declaredField.get(null)).newBuilderForType().mergeFrom(this.asBytes).buildPartial();
        } catch (InvalidProtocolBufferException e10) {
            throw new RuntimeException("Unable to understand proto buffer", e10);
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("Unable to find proto buffer class: " + this.messageClassName, e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException("Unable to call parsePartialFrom", e12);
        } catch (NoSuchFieldException unused) {
            return readResolveFallback();
        } catch (SecurityException e13) {
            throw new RuntimeException("Unable to call DEFAULT_INSTANCE in " + this.messageClassName, e13);
        }
    }
}
