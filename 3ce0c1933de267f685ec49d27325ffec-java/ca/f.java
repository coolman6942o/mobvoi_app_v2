package ca;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.c;
import com.google.protobuf.nano.e;
import java.io.IOException;
import java.util.Arrays;
/* compiled from: Protos.java */
/* loaded from: classes2.dex */
public final class f extends c {

    /* renamed from: a  reason: collision with root package name */
    public String f5658a;

    /* renamed from: b  reason: collision with root package name */
    public String f5659b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f5660c;

    /* renamed from: d  reason: collision with root package name */
    public int f5661d;

    /* renamed from: e  reason: collision with root package name */
    public String f5662e;

    /* renamed from: f  reason: collision with root package name */
    public String f5663f;

    public f() {
        a();
    }

    public f a() {
        this.f5658a = "";
        this.f5659b = "";
        this.f5660c = e.f13298a;
        this.f5661d = 0;
        this.f5662e = "";
        this.f5663f = "";
        this.cachedSize = -1;
        return this;
    }

    /* renamed from: b */
    public f mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 10) {
                this.f5658a = aVar.u();
            } else if (v10 == 18) {
                this.f5659b = aVar.u();
            } else if (v10 == 26) {
                this.f5660c = aVar.i();
            } else if (v10 == 32) {
                this.f5661d = aVar.k();
            } else if (v10 == 42) {
                this.f5662e = aVar.u();
            } else if (v10 == 50) {
                this.f5663f = aVar.u();
            } else if (!e.e(aVar, v10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f5658a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(1, this.f5658a);
        }
        if (!this.f5659b.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(2, this.f5659b);
        }
        if (!Arrays.equals(this.f5660c, e.f13298a)) {
            computeSerializedSize += CodedOutputByteBufferNano.d(3, this.f5660c);
        }
        int i10 = this.f5661d;
        if (i10 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.h(4, i10);
        }
        if (!this.f5662e.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.r(5, this.f5662e);
        }
        return !this.f5663f.equals("") ? computeSerializedSize + CodedOutputByteBufferNano.r(6, this.f5663f) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f5658a.equals("")) {
            codedOutputByteBufferNano.b0(1, this.f5658a);
        }
        if (!this.f5659b.equals("")) {
            codedOutputByteBufferNano.b0(2, this.f5659b);
        }
        if (!Arrays.equals(this.f5660c, e.f13298a)) {
            codedOutputByteBufferNano.I(3, this.f5660c);
        }
        int i10 = this.f5661d;
        if (i10 != 0) {
            codedOutputByteBufferNano.M(4, i10);
        }
        if (!this.f5662e.equals("")) {
            codedOutputByteBufferNano.b0(5, this.f5662e);
        }
        if (!this.f5663f.equals("")) {
            codedOutputByteBufferNano.b0(6, this.f5663f);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
