package com.google.common.hash;

import com.google.common.base.p;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* compiled from: AbstractStreamingHasher.java */
/* loaded from: classes.dex */
abstract class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f12308a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12309b;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int i10) {
        this(i10, i10);
    }

    private void d() {
        l.a(this.f12308a);
        while (this.f12308a.remaining() >= this.f12309b) {
            e(this.f12308a);
        }
        this.f12308a.compact();
    }

    @Override // com.google.common.hash.j
    public final h b() {
        d();
        l.a(this.f12308a);
        if (this.f12308a.remaining() > 0) {
            f(this.f12308a);
            ByteBuffer byteBuffer = this.f12308a;
            l.b(byteBuffer, byteBuffer.limit());
        }
        return c();
    }

    protected abstract h c();

    protected abstract void e(ByteBuffer byteBuffer);

    protected abstract void f(ByteBuffer byteBuffer);

    protected c(int i10, int i11) {
        p.d(i11 % i10 == 0);
        this.f12308a = ByteBuffer.allocate(i11 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.f12309b = i10;
    }
}
