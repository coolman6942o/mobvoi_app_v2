package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.d;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.e;
import androidx.lifecycle.p;
import g0.j;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
/* loaded from: classes.dex */
public class EmojiCompatInitializer implements k1.a<Boolean> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends d.c {
        protected a(Context context) {
            super(new b(context));
            b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements d.g {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2781a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends d.h {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d.h f2782a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f2783b;

            a(b bVar, d.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f2782a = hVar;
                this.f2783b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.d.h
            public void a(Throwable th2) {
                try {
                    this.f2782a.a(th2);
                } finally {
                    this.f2783b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.d.h
            public void b(l lVar) {
                try {
                    this.f2782a.b(lVar);
                } finally {
                    this.f2783b.shutdown();
                }
            }
        }

        b(Context context) {
            this.f2781a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.d.g
        public void a(final d.h hVar) {
            final ThreadPoolExecutor b10 = androidx.emoji2.text.b.b("EmojiCompatInitializer");
            b10.execute(new Runnable() { // from class: androidx.emoji2.text.e
                @Override // java.lang.Runnable
                public final void run() {
                    EmojiCompatInitializer.b.this.d(hVar, b10);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c */
        public void d(d.h hVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                i a10 = androidx.emoji2.text.c.a(this.f2781a);
                if (a10 != null) {
                    a10.c(threadPoolExecutor);
                    a10.a().a(new a(this, hVar, threadPoolExecutor));
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th2) {
                hVar.a(th2);
                threadPoolExecutor.shutdown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                j.a("EmojiCompat.EmojiCompatInitializer.run");
                if (d.h()) {
                    d.b().k();
                }
            } finally {
                j.b();
            }
        }
    }

    @Override // k1.a
    public List<Class<? extends k1.a<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    /* renamed from: c */
    public Boolean b(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return Boolean.FALSE;
        }
        d.g(new a(context));
        d(context);
        return Boolean.TRUE;
    }

    void d(Context context) {
        final Lifecycle lifecycle = ((p) androidx.startup.a.c(context).d(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new e() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.h
            public void a(p pVar) {
                EmojiCompatInitializer.this.e();
                lifecycle.c(this);
            }

            @Override // androidx.lifecycle.h
            public /* synthetic */ void b(p pVar) {
                androidx.lifecycle.d.a(this, pVar);
            }

            @Override // androidx.lifecycle.h
            public /* synthetic */ void e(p pVar) {
                androidx.lifecycle.d.c(this, pVar);
            }

            @Override // androidx.lifecycle.h
            public /* synthetic */ void f(p pVar) {
                androidx.lifecycle.d.f(this, pVar);
            }

            @Override // androidx.lifecycle.h
            public /* synthetic */ void g(p pVar) {
                androidx.lifecycle.d.b(this, pVar);
            }

            @Override // androidx.lifecycle.h
            public /* synthetic */ void i(p pVar) {
                androidx.lifecycle.d.e(this, pVar);
            }
        });
    }

    void e() {
        androidx.emoji2.text.b.d().postDelayed(new c(), 500L);
    }
}
