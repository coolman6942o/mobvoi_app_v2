package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public final class i<L> {

    /* renamed from: a  reason: collision with root package name */
    private final c f8624a;

    /* renamed from: b  reason: collision with root package name */
    private volatile L f8625b;

    /* renamed from: c  reason: collision with root package name */
    private final a<L> f8626c;

    /* loaded from: classes.dex */
    public static final class a<L> {

        /* renamed from: a  reason: collision with root package name */
        private final L f8627a;

        /* renamed from: b  reason: collision with root package name */
        private final String f8628b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(L l10, String str) {
            this.f8627a = l10;
            this.f8628b = str;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8627a == aVar.f8627a && this.f8628b.equals(aVar.f8628b);
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f8627a) * 31) + this.f8628b.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public interface b<L> {
        void a(L l10);

        void b();
    }

    /* loaded from: classes.dex */
    private final class c extends q6.i {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z10 = true;
            if (message.what != 1) {
                z10 = false;
            }
            b6.i.a(z10);
            i.this.d((b) message.obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Looper looper, L l10, String str) {
        this.f8624a = new c(looper);
        this.f8625b = (L) b6.i.l(l10, "Listener must not be null");
        this.f8626c = new a<>(l10, b6.i.g(str));
    }

    public final void a() {
        this.f8625b = null;
    }

    public final a<L> b() {
        return this.f8626c;
    }

    public final void c(b<? super L> bVar) {
        b6.i.l(bVar, "Notifier must not be null");
        this.f8624a.sendMessage(this.f8624a.obtainMessage(1, bVar));
    }

    final void d(b<? super L> bVar) {
        Object obj = (L) this.f8625b;
        if (obj == null) {
            bVar.b();
            return;
        }
        try {
            bVar.a(obj);
        } catch (RuntimeException e10) {
            bVar.b();
            throw e10;
        }
    }
}
