package ca;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
/* compiled from: Protos.java */
/* loaded from: classes2.dex */
public final class d extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f5647a;

    /* renamed from: b  reason: collision with root package name */
    public String f5648b;

    /* renamed from: c  reason: collision with root package name */
    public String f5649c;

    public d() {
        a();
    }

    public d a() {
        this.f5647a = "";
        this.f5648b = "";
        this.f5649c = "";
        this.cachedSize = -1;
        return this;
    }

    /* renamed from: b */
    public d mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 10) {
                this.f5647a = aVar.u();
            } else if (v10 == 18) {
                this.f5648b = aVar.u();
            } else if (v10 == 26) {
                this.f5649c = aVar.u();
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f5647a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(1, this.f5647a);
        }
        if (!this.f5648b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(2, this.f5648b);
        }
        return !this.f5649c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.r(3, this.f5649c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f5647a.equals("")) {
            codedOutputByteBufferNano.b0(1, this.f5647a);
        }
        if (!this.f5648b.equals("")) {
            codedOutputByteBufferNano.b0(2, this.f5648b);
        }
        if (!this.f5649c.equals("")) {
            codedOutputByteBufferNano.b0(3, this.f5649c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
