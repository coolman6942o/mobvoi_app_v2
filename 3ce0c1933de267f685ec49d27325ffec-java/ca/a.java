package ca;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
/* compiled from: Protos.java */
/* loaded from: classes2.dex */
public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f5640a;

    public a() {
        a();
    }

    public a a() {
        this.f5640a = "";
        this.cachedSize = -1;
        return this;
    }

    /* renamed from: b */
    public a mergeFrom(com.google.protobuf.nano.a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 10) {
                this.f5640a = aVar.u();
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return !this.f5640a.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.r(1, this.f5640a) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f5640a.equals("")) {
            codedOutputByteBufferNano.b0(1, this.f5640a);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
