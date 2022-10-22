package ca;

import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.a;
import com.google.protobuf.nano.c;
import java.io.IOException;
/* compiled from: Protos.java */
/* loaded from: classes2.dex */
public final class e extends c {

    /* renamed from: a  reason: collision with root package name */
    public int f5650a;

    /* renamed from: b  reason: collision with root package name */
    public f f5651b;

    /* renamed from: c  reason: collision with root package name */
    public h f5652c;

    /* renamed from: d  reason: collision with root package name */
    public i f5653d;

    /* renamed from: e  reason: collision with root package name */
    public d f5654e;

    /* renamed from: f  reason: collision with root package name */
    public g f5655f;

    /* renamed from: g  reason: collision with root package name */
    public a f5656g;

    /* renamed from: h  reason: collision with root package name */
    public b f5657h;

    public e() {
        a();
    }

    public static e c(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (e) c.mergeFrom(new e(), bArr);
    }

    public e a() {
        this.f5650a = 0;
        this.f5651b = null;
        this.f5652c = null;
        this.f5653d = null;
        this.f5654e = null;
        this.f5655f = null;
        this.f5656g = null;
        this.f5657h = null;
        this.cachedSize = -1;
        return this;
    }

    /* renamed from: b */
    public e mergeFrom(a aVar) throws IOException {
        while (true) {
            int v10 = aVar.v();
            if (v10 == 0) {
                return this;
            }
            if (v10 == 8) {
                int k10 = aVar.k();
                switch (k10) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                        this.f5650a = k10;
                        continue;
                }
            } else if (v10 == 18) {
                if (this.f5651b == null) {
                    this.f5651b = new f();
                }
                aVar.m(this.f5651b);
            } else if (v10 == 26) {
                if (this.f5652c == null) {
                    this.f5652c = new h();
                }
                aVar.m(this.f5652c);
            } else if (v10 == 34) {
                if (this.f5653d == null) {
                    this.f5653d = new i();
                }
                aVar.m(this.f5653d);
            } else if (v10 == 42) {
                if (this.f5654e == null) {
                    this.f5654e = new d();
                }
                aVar.m(this.f5654e);
            } else if (v10 == 50) {
                if (this.f5655f == null) {
                    this.f5655f = new g();
                }
                aVar.m(this.f5655f);
            } else if (v10 == 58) {
                if (this.f5656g == null) {
                    this.f5656g = new a();
                }
                aVar.m(this.f5656g);
            } else if (v10 == 66) {
                if (this.f5657h == null) {
                    this.f5657h = new b();
                }
                aVar.m(this.f5657h);
            } else if (!com.google.protobuf.nano.e.e(aVar, v10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.nano.c
    public int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i10 = this.f5650a;
        if (i10 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.h(1, i10);
        }
        f fVar = this.f5651b;
        if (fVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.l(2, fVar);
        }
        h hVar = this.f5652c;
        if (hVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.l(3, hVar);
        }
        i iVar = this.f5653d;
        if (iVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.l(4, iVar);
        }
        d dVar = this.f5654e;
        if (dVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.l(5, dVar);
        }
        g gVar = this.f5655f;
        if (gVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.l(6, gVar);
        }
        a aVar = this.f5656g;
        if (aVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.l(7, aVar);
        }
        b bVar = this.f5657h;
        return bVar != null ? computeSerializedSize + CodedOutputByteBufferNano.l(8, bVar) : computeSerializedSize;
    }

    @Override // com.google.protobuf.nano.c
    public void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i10 = this.f5650a;
        if (i10 != 0) {
            codedOutputByteBufferNano.M(1, i10);
        }
        f fVar = this.f5651b;
        if (fVar != null) {
            codedOutputByteBufferNano.Q(2, fVar);
        }
        h hVar = this.f5652c;
        if (hVar != null) {
            codedOutputByteBufferNano.Q(3, hVar);
        }
        i iVar = this.f5653d;
        if (iVar != null) {
            codedOutputByteBufferNano.Q(4, iVar);
        }
        d dVar = this.f5654e;
        if (dVar != null) {
            codedOutputByteBufferNano.Q(5, dVar);
        }
        g gVar = this.f5655f;
        if (gVar != null) {
            codedOutputByteBufferNano.Q(6, gVar);
        }
        a aVar = this.f5656g;
        if (aVar != null) {
            codedOutputByteBufferNano.Q(7, aVar);
        }
        b bVar = this.f5657h;
        if (bVar != null) {
            codedOutputByteBufferNano.Q(8, bVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }
}
