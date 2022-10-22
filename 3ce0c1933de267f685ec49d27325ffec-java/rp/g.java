package rp;

import kotlin.collections.h;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Segment.kt */
/* loaded from: classes3.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f33663a;

    /* renamed from: b  reason: collision with root package name */
    public int f33664b;

    /* renamed from: c  reason: collision with root package name */
    public int f33665c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f33666d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f33667e;

    /* renamed from: f  reason: collision with root package name */
    public g f33668f;

    /* renamed from: g  reason: collision with root package name */
    public g f33669g;

    /* compiled from: Segment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public g() {
        this.f33663a = new byte[8192];
        this.f33667e = true;
        this.f33666d = false;
    }

    public final void a() {
        g gVar = this.f33669g;
        int i10 = 0;
        if (gVar != this) {
            i.d(gVar);
            if (gVar.f33667e) {
                int i11 = this.f33665c - this.f33664b;
                g gVar2 = this.f33669g;
                i.d(gVar2);
                int i12 = 8192 - gVar2.f33665c;
                g gVar3 = this.f33669g;
                i.d(gVar3);
                if (!gVar3.f33666d) {
                    g gVar4 = this.f33669g;
                    i.d(gVar4);
                    i10 = gVar4.f33664b;
                }
                if (i11 <= i12 + i10) {
                    g gVar5 = this.f33669g;
                    i.d(gVar5);
                    f(gVar5, i11);
                    b();
                    h.b(this);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("cannot compact".toString());
    }

    public final g b() {
        g gVar = this.f33668f;
        if (gVar == this) {
            gVar = null;
        }
        g gVar2 = this.f33669g;
        i.d(gVar2);
        gVar2.f33668f = this.f33668f;
        g gVar3 = this.f33668f;
        i.d(gVar3);
        gVar3.f33669g = this.f33669g;
        this.f33668f = null;
        this.f33669g = null;
        return gVar;
    }

    public final g c(g segment) {
        i.f(segment, "segment");
        segment.f33669g = this;
        segment.f33668f = this.f33668f;
        g gVar = this.f33668f;
        i.d(gVar);
        gVar.f33669g = segment;
        this.f33668f = segment;
        return segment;
    }

    public final g d() {
        this.f33666d = true;
        return new g(this.f33663a, this.f33664b, this.f33665c, true, false);
    }

    public final g e(int i10) {
        g gVar;
        if (i10 > 0 && i10 <= this.f33665c - this.f33664b) {
            if (i10 >= 1024) {
                gVar = d();
            } else {
                gVar = h.c();
                byte[] bArr = this.f33663a;
                byte[] bArr2 = gVar.f33663a;
                int i11 = this.f33664b;
                h.e(bArr, bArr2, 0, i11, i11 + i10, 2, null);
            }
            gVar.f33665c = gVar.f33664b + i10;
            this.f33664b += i10;
            g gVar2 = this.f33669g;
            i.d(gVar2);
            gVar2.c(gVar);
            return gVar;
        }
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    public final void f(g sink, int i10) {
        i.f(sink, "sink");
        if (sink.f33667e) {
            int i11 = sink.f33665c;
            if (i11 + i10 > 8192) {
                if (!sink.f33666d) {
                    int i12 = sink.f33664b;
                    if ((i11 + i10) - i12 <= 8192) {
                        byte[] bArr = sink.f33663a;
                        h.e(bArr, bArr, 0, i12, i11, 2, null);
                        sink.f33665c -= sink.f33664b;
                        sink.f33664b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            byte[] bArr2 = this.f33663a;
            byte[] bArr3 = sink.f33663a;
            int i13 = sink.f33665c;
            int i14 = this.f33664b;
            h.c(bArr2, bArr3, i13, i14, i14 + i10);
            sink.f33665c += i10;
            this.f33664b += i10;
            return;
        }
        throw new IllegalStateException("only owner can write".toString());
    }

    public g(byte[] data, int i10, int i11, boolean z10, boolean z11) {
        i.f(data, "data");
        this.f33663a = data;
        this.f33664b = i10;
        this.f33665c = i11;
        this.f33666d = z10;
        this.f33667e = z11;
    }
}
