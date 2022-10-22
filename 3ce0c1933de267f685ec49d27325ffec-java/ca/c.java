package ca;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.b;
import com.google.protobuf.nano.e;
import java.io.IOException;
/* compiled from: Protos.java */
/* loaded from: classes2.dex */
public final class c extends com.google.protobuf.nano.c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c[] f5644c;

    /* renamed from: a  reason: collision with root package name */
    public String f5645a;

    /* renamed from: b  reason: collision with root package name */
    public String f5646b;

    public c() {
        a();
    }

    public static c[] b() {
        if (f5644c == null) {
            synchronized (b.f13297b) {
                if (f5644c == null) {
                    f5644c = new c[0];
                }
            }
        }
        return f5644c;
    }

    public c a() {
        this.f5645a = "";
        this.f5646b = "";
        this.cachedSize = -1;
        return this;
    }

    /* renamed from: c */
    public c mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 10) {
                this.f5645a = aVar.u();
            } else if (v10 == 18) {
                this.f5646b = aVar.u();
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f5645a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(1, this.f5645a);
        }
        return !this.f5646b.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.r(2, this.f5646b) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f5645a.equals("")) {
            codedOutputByteBufferNano.b0(1, this.f5645a);
        }
        if (!this.f5646b.equals("")) {
            codedOutputByteBufferNano.b0(2, this.f5646b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
