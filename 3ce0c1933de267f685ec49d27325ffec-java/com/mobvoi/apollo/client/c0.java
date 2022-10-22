package com.mobvoi.apollo.client;

import kotlin.jvm.internal.f;
/* compiled from: ResponseCallback.kt */
/* loaded from: classes2.dex */
public abstract class c0 {

    /* renamed from: a  reason: collision with root package name */
    private Integer f15466a;

    /* renamed from: b  reason: collision with root package name */
    private long f15467b;

    /* compiled from: ResponseCallback.kt */
    /* loaded from: classes2.dex */
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

    public c0() {
        this(null, 1, null);
    }

    public c0(Integer num) {
        this.f15466a = num;
        this.f15467b = 10000L;
    }

    public final Integer j() {
        return this.f15466a;
    }

    public final long k() {
        return this.f15467b;
    }

    public void l(int i10) {
    }

    public abstract void m(byte[] bArr);

    public final void n(Integer num) {
        this.f15466a = num;
    }

    public final void o(long j10) {
        this.f15467b = j10;
    }

    public /* synthetic */ c0(Integer num, int i10, f fVar) {
        this((i10 & 1) != 0 ? null : num);
    }
}
