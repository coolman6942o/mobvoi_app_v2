package com.mobvoi.wear.speech.proto.nano;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class NetworkInfo extends c {
    private static volatile NetworkInfo[] _emptyArray;
    public int state;
    public int subtype;
    public int type;

    public NetworkInfo() {
        clear();
    }

    public static NetworkInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (b.f13297b) {
                if (_emptyArray == null) {
                    _emptyArray = new NetworkInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public static NetworkInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (NetworkInfo) c.mergeFrom(new NetworkInfo(), bArr);
    }

    public NetworkInfo clear() {
        this.state = 0;
        this.type = 0;
        this.subtype = 0;
        this.cachedSize = -1;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i10 = this.state;
        if (i10 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.h(1, i10);
        }
        int i11 = this.type;
        if (i11 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.h(2, i11);
        }
        int i12 = this.subtype;
        return i12 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.h(3, i12) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i10 = this.state;
        if (i10 != 0) {
            codedOutputByteBufferNano.M(1, i10);
        }
        int i11 = this.type;
        if (i11 != 0) {
            codedOutputByteBufferNano.M(2, i11);
        }
        int i12 = this.subtype;
        if (i12 != 0) {
            codedOutputByteBufferNano.M(3, i12);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    public static NetworkInfo parseFrom(a aVar) throws IOException {
        return new NetworkInfo().mergeFrom(aVar);
    }

    @Override // com.google.protobuf.nano.c
    public NetworkInfo mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 8) {
                this.state = aVar.k();
            } else if (v10 == 16) {
                this.type = aVar.k();
            } else if (v10 == 24) {
                this.subtype = aVar.k();
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }
}
