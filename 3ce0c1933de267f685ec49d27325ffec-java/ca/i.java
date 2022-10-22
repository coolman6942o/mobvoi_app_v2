package ca;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
/* compiled from: Protos.java */
/* loaded from: classes2.dex */
public final class i extends c {

    /* renamed from: a  reason: collision with root package name */
    public long f5677a;

    public i() {
        a();
    }

    public i a() {
        this.f5677a = 0L;
        this.cachedSize = -1;
        return this;
    }

    /* renamed from: b */
    public i mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 8) {
                this.f5677a = aVar.l();
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        long j10 = this.f5677a;
        return j10 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.j(1, j10) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        long j10 = this.f5677a;
        if (j10 != 0) {
            codedOutputByteBufferNano.O(1, j10);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
