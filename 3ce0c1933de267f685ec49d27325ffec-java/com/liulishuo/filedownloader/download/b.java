package com.liulishuo.filedownloader.download;

import java.net.ProtocolException;
import r9.d;
import r9.e;
/* compiled from: ConnectionProfile.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    final long f15102a;

    /* renamed from: b  reason: collision with root package name */
    final long f15103b;

    /* renamed from: c  reason: collision with root package name */
    final long f15104c;

    /* renamed from: d  reason: collision with root package name */
    final long f15105d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f15106e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f15107f;

    /* compiled from: ConnectionProfile.java */
    /* renamed from: com.liulishuo.filedownloader.download.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0183b {
        public static b a(long j10) {
            return new b(0L, 0L, -1L, j10);
        }

        public static b b(long j10, long j11, long j12, long j13) {
            return new b(j10, j11, j12, j13);
        }

        public static b c(long j10, long j11, long j12) {
            return new b(j10, j11, -1L, j12);
        }

        public static b d() {
            return new b();
        }

        public static b e() {
            return new b(0L, 0L, 0L, 0L, true);
        }
    }

    public void a(j9.b bVar) throws ProtocolException {
        if (!this.f15106e) {
            if (this.f15107f && d.a().f33477h) {
                bVar.h("HEAD");
            }
            bVar.e("Range", this.f15104c == -1 ? e.n("bytes=%d-", Long.valueOf(this.f15103b)) : e.n("bytes=%d-%d", Long.valueOf(this.f15103b), Long.valueOf(this.f15104c)));
        }
    }

    public String toString() {
        return e.n("range[%d, %d) current offset[%d]", Long.valueOf(this.f15102a), Long.valueOf(this.f15104c), Long.valueOf(this.f15103b));
    }

    private b() {
        this.f15102a = 0L;
        this.f15103b = 0L;
        this.f15104c = 0L;
        this.f15105d = 0L;
        this.f15106e = false;
        this.f15107f = true;
    }

    private b(long j10, long j11, long j12, long j13) {
        this(j10, j11, j12, j13, false);
    }

    private b(long j10, long j11, long j12, long j13, boolean z10) {
        if (!(j10 == 0 && j12 == 0) && z10) {
            throw new IllegalArgumentException();
        }
        this.f15102a = j10;
        this.f15103b = j11;
        this.f15104c = j12;
        this.f15105d = j13;
        this.f15106e = z10;
        this.f15107f = false;
    }
}
