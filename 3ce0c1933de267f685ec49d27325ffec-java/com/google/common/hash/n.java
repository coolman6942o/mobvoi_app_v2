package com.google.common.hash;

import com.google.common.base.v;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: LongAddables.java */
/* loaded from: classes.dex */
final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final v<m> f12318a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LongAddables.java */
    /* loaded from: classes.dex */
    public class a implements v<m> {
        a() {
        }

        /* renamed from: a */
        public m get() {
            return new o();
        }
    }

    /* compiled from: LongAddables.java */
    /* loaded from: classes.dex */
    class b implements v<m> {
        b() {
        }

        /* renamed from: a */
        public m get() {
            return new c(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LongAddables.java */
    /* loaded from: classes.dex */
    public static final class c extends AtomicLong implements m {
        private c() {
        }

        @Override // com.google.common.hash.m
        public void a() {
            getAndIncrement();
        }

        @Override // com.google.common.hash.m
        public long b() {
            return get();
        }

        @Override // com.google.common.hash.m
        public void c(long j10) {
            getAndAdd(j10);
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        v<m> vVar;
        try {
            new o();
            vVar = new a();
        } catch (Throwable unused) {
            vVar = new b();
        }
        f12318a = vVar;
    }

    public static m a() {
        return f12318a.get();
    }
}
