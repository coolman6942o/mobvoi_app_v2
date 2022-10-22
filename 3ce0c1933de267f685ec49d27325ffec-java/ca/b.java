package ca;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
/* compiled from: Protos.java */
/* loaded from: classes2.dex */
public final class b extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f5641a;

    /* renamed from: b  reason: collision with root package name */
    public String f5642b;

    /* renamed from: c  reason: collision with root package name */
    public String f5643c;

    public b() {
        a();
    }

    public b a() {
        this.f5641a = "";
        this.f5642b = "";
        this.f5643c = "";
        this.cachedSize = -1;
        return this;
    }

    /* renamed from: b */
    public b mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 10) {
                this.f5641a = aVar.u();
            } else if (v10 == 18) {
                this.f5642b = aVar.u();
            } else if (v10 == 26) {
                this.f5643c = aVar.u();
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f5641a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(1, this.f5641a);
        }
        if (!this.f5642b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(2, this.f5642b);
        }
        return !this.f5643c.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.r(3, this.f5643c) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f5641a.equals("")) {
            codedOutputByteBufferNano.b0(1, this.f5641a);
        }
        if (!this.f5642b.equals("")) {
            codedOutputByteBufferNano.b0(2, this.f5642b);
        }
        if (!this.f5643c.equals("")) {
            codedOutputByteBufferNano.b0(3, this.f5643c);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
