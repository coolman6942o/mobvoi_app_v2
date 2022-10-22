package com.google.protobuf.nano;

import java.io.IOException;
import java.util.Arrays;
/* compiled from: MessageNano.java */
/* loaded from: classes.dex */
public abstract class c {
    protected volatile int cachedSize = -1;

    public static final <T extends c> T mergeFrom(T t10, byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (T) mergeFrom(t10, bArr, 0, bArr.length);
    }

    public static final boolean messageNanoEquals(c cVar, c cVar2) {
        int serializedSize;
        if (cVar == cVar2) {
            return true;
        }
        if (cVar == null || cVar2 == null || cVar.getClass() != cVar2.getClass() || cVar2.getSerializedSize() != (serializedSize = cVar.getSerializedSize())) {
            return false;
        }
        byte[] bArr = new byte[serializedSize];
        byte[] bArr2 = new byte[serializedSize];
        toByteArray(cVar, bArr, 0, serializedSize);
        toByteArray(cVar2, bArr2, 0, serializedSize);
        return Arrays.equals(bArr, bArr2);
    }

    public static final byte[] toByteArray(c cVar) {
        int serializedSize = cVar.getSerializedSize();
        byte[] bArr = new byte[serializedSize];
        toByteArray(cVar, bArr, 0, serializedSize);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeSerializedSize() {
        return 0;
    }

    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getSerializedSize() {
        int computeSerializedSize = computeSerializedSize();
        this.cachedSize = computeSerializedSize;
        return computeSerializedSize;
    }

    public abstract c mergeFrom(a aVar) throws IOException;

    public String toString() {
        return d.d(this);
    }

    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
    }

    public static final <T extends c> T mergeFrom(T t10, byte[] bArr, int i10, int i11) throws InvalidProtocolBufferNanoException {
        try {
            a e10 = a.e(bArr, i10, i11);
            t10.mergeFrom(e10);
            e10.a(0);
            return t10;
        } catch (InvalidProtocolBufferNanoException e11) {
            throw e11;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public c clone() throws CloneNotSupportedException {
        return (c) super.clone();
    }

    public static final void toByteArray(c cVar, byte[] bArr, int i10, int i11) {
        try {
            CodedOutputByteBufferNano E = CodedOutputByteBufferNano.E(bArr, i10, i11);
            cVar.writeTo(E);
            E.a();
        } catch (IOException e10) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e10);
        }
    }
}
