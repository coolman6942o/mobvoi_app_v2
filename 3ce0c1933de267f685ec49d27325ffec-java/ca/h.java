package ca;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
import java.util.Arrays;
/* compiled from: Protos.java */
/* loaded from: classes2.dex */
public final class h extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f5668a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5669b;

    /* renamed from: c  reason: collision with root package name */
    public long f5670c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f5671d;

    /* renamed from: e  reason: collision with root package name */
    public String f5672e;

    /* renamed from: f  reason: collision with root package name */
    public String f5673f;

    /* renamed from: g  reason: collision with root package name */
    public String f5674g;

    /* renamed from: h  reason: collision with root package name */
    public c[] f5675h;

    /* renamed from: i  reason: collision with root package name */
    public long f5676i;

    public h() {
        a();
    }

    public h a() {
        this.f5668a = "";
        this.f5669b = false;
        this.f5670c = 0L;
        this.f5671d = e.f13298a;
        this.f5672e = "";
        this.f5673f = "";
        this.f5674g = "";
        this.f5675h = c.b();
        this.f5676i = 0L;
        this.cachedSize = -1;
        return this;
    }

    /* renamed from: b */
    public h mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 10) {
                this.f5668a = aVar.u();
            } else if (v10 == 16) {
                this.f5669b = aVar.h();
            } else if (v10 == 24) {
                this.f5670c = aVar.l();
            } else if (v10 == 34) {
                this.f5671d = aVar.i();
            } else if (v10 == 42) {
                this.f5672e = aVar.u();
            } else if (v10 == 50) {
                this.f5673f = aVar.u();
            } else if (v10 == 58) {
                this.f5674g = aVar.u();
            } else if (v10 == 66) {
                int a10 = e.a(aVar, 66);
                c[] cVarArr = this.f5675h;
                int length = cVarArr == null ? 0 : cVarArr.length;
                int i10 = a10 + length;
                c[] cVarArr2 = new c[i10];
                if (length != 0) {
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                }
                while (length < i10 - 1) {
                    cVarArr2[length] = new c();
                    aVar.m(cVarArr2[length]);
                    aVar.v();
                    length++;
                }
                cVarArr2[length] = new c();
                aVar.m(cVarArr2[length]);
                this.f5675h = cVarArr2;
            } else if (v10 == 72) {
                this.f5676i = aVar.l();
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f5668a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(1, this.f5668a);
        }
        boolean z10 = this.f5669b;
        if (z10) {
            computeSerializedSize += CodedOutputByteBufferNano.b(2, z10);
        }
        long j10 = this.f5670c;
        if (j10 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.j(3, j10);
        }
        if (!Arrays.equals(this.f5671d, e.f13298a)) {
            computeSerializedSize += CodedOutputByteBufferNano.d(4, this.f5671d);
        }
        if (!this.f5672e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(5, this.f5672e);
        }
        if (!this.f5673f.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(6, this.f5673f);
        }
        if (!this.f5674g.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(7, this.f5674g);
        }
        c[] cVarArr = this.f5675h;
        if (cVarArr != null && cVarArr.length > 0) {
            int i10 = 0;
            while (true) {
                c[] cVarArr2 = this.f5675h;
                if (i10 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i10];
                if (cVar != null) {
                    computeSerializedSize += CodedOutputByteBufferNano.l(8, cVar);
                }
                i10++;
            }
        }
        long j11 = this.f5676i;
        return j11 != 0 ? computeSerializedSize + CodedOutputByteBufferNano.j(9, j11) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f5668a.equals("")) {
            codedOutputByteBufferNano.b0(1, this.f5668a);
        }
        boolean z10 = this.f5669b;
        if (z10) {
            codedOutputByteBufferNano.G(2, z10);
        }
        long j10 = this.f5670c;
        if (j10 != 0) {
            codedOutputByteBufferNano.O(3, j10);
        }
        if (!Arrays.equals(this.f5671d, e.f13298a)) {
            codedOutputByteBufferNano.I(4, this.f5671d);
        }
        if (!this.f5672e.equals("")) {
            codedOutputByteBufferNano.b0(5, this.f5672e);
        }
        if (!this.f5673f.equals("")) {
            codedOutputByteBufferNano.b0(6, this.f5673f);
        }
        if (!this.f5674g.equals("")) {
            codedOutputByteBufferNano.b0(7, this.f5674g);
        }
        c[] cVarArr = this.f5675h;
        if (cVarArr != null && cVarArr.length > 0) {
            int i10 = 0;
            while (true) {
                c[] cVarArr2 = this.f5675h;
                if (i10 >= cVarArr2.length) {
                    break;
                }
                c cVar = cVarArr2[i10];
                if (cVar != null) {
                    codedOutputByteBufferNano.Q(8, cVar);
                }
                i10++;
            }
        }
        long j11 = this.f5676i;
        if (j11 != 0) {
            codedOutputByteBufferNano.O(9, j11);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
