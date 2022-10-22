package ca;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
/* compiled from: Protos.java */
/* loaded from: classes2.dex */
public final class g extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f5664a;

    /* renamed from: b  reason: collision with root package name */
    public String f5665b;

    /* renamed from: c  reason: collision with root package name */
    public String f5666c;

    /* renamed from: d  reason: collision with root package name */
    public String f5667d;

    public g() {
        a();
    }

    public g a() {
        this.f5664a = "";
        this.f5665b = "";
        this.f5666c = "";
        this.f5667d = "";
        this.cachedSize = -1;
        return this;
    }

    /* renamed from: b */
    public g mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 10) {
                this.f5664a = aVar.u();
            } else if (v10 == 18) {
                this.f5665b = aVar.u();
            } else if (v10 == 26) {
                this.f5666c = aVar.u();
            } else if (v10 == 34) {
                this.f5667d = aVar.u();
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f5664a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(1, this.f5664a);
        }
        if (!this.f5665b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(2, this.f5665b);
        }
        if (!this.f5666c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(3, this.f5666c);
        }
        return !this.f5667d.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.r(4, this.f5667d) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f5664a.equals("")) {
            codedOutputByteBufferNano.b0(1, this.f5664a);
        }
        if (!this.f5665b.equals("")) {
            codedOutputByteBufferNano.b0(2, this.f5665b);
        }
        if (!this.f5666c.equals("")) {
            codedOutputByteBufferNano.b0(3, this.f5666c);
        }
        if (!this.f5667d.equals("")) {
            codedOutputByteBufferNano.b0(4, this.f5667d);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
