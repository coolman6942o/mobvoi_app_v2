package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.emoji2.text.d;
import androidx.emoji2.text.i;
import b0.e;
import g0.j;
import h0.f;
import j0.h;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
/* compiled from: FontRequestEmojiCompatConfig.java */
/* loaded from: classes.dex */
public class i extends d.c {

    /* renamed from: j  reason: collision with root package name */
    private static final a f2843j = new a();

    /* compiled from: FontRequestEmojiCompatConfig.java */
    /* loaded from: classes.dex */
    public static class a {
        public Typeface a(Context context, f.b bVar) throws PackageManager.NameNotFoundException {
            return f.a(context, null, new f.b[]{bVar});
        }

        public f.a b(Context context, h0.d dVar) throws PackageManager.NameNotFoundException {
            return f.b(context, null, dVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FontRequestEmojiCompatConfig.java */
    /* loaded from: classes.dex */
    public static class b implements d.g {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2844a;

        /* renamed from: b  reason: collision with root package name */
        private final h0.d f2845b;

        /* renamed from: c  reason: collision with root package name */
        private final a f2846c;

        /* renamed from: d  reason: collision with root package name */
        private final Object f2847d = new Object();

        /* renamed from: e  reason: collision with root package name */
        private Handler f2848e;

        /* renamed from: f  reason: collision with root package name */
        private Executor f2849f;

        /* renamed from: g  reason: collision with root package name */
        private ThreadPoolExecutor f2850g;

        /* renamed from: h  reason: collision with root package name */
        d.h f2851h;

        /* renamed from: i  reason: collision with root package name */
        private ContentObserver f2852i;

        /* renamed from: j  reason: collision with root package name */
        private Runnable f2853j;

        b(Context context, h0.d dVar, a aVar) {
            h.h(context, "Context cannot be null");
            h.h(dVar, "FontRequest cannot be null");
            this.f2844a = context.getApplicationContext();
            this.f2845b = dVar;
            this.f2846c = aVar;
        }

        private void b() {
            synchronized (this.f2847d) {
                this.f2851h = null;
                ContentObserver contentObserver = this.f2852i;
                if (contentObserver != null) {
                    this.f2846c.c(this.f2844a, contentObserver);
                    this.f2852i = null;
                }
                Handler handler = this.f2848e;
                if (handler != null) {
                    handler.removeCallbacks(this.f2853j);
                }
                this.f2848e = null;
                ThreadPoolExecutor threadPoolExecutor = this.f2850g;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f2849f = null;
                this.f2850g = null;
            }
        }

        private f.b e() {
            try {
                f.a b10 = this.f2846c.b(this.f2844a, this.f2845b);
                if (b10.c() == 0) {
                    f.b[] b11 = b10.b();
                    if (b11 != null && b11.length != 0) {
                        return b11[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + b10.c() + ")");
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        @Override // androidx.emoji2.text.d.g
        public void a(d.h hVar) {
            h.h(hVar, "LoaderCallback cannot be null");
            synchronized (this.f2847d) {
                this.f2851h = hVar;
            }
            d();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            synchronized (this.f2847d) {
                if (this.f2851h != null) {
                    try {
                        f.b e10 = e();
                        int b10 = e10.b();
                        if (b10 == 2) {
                            synchronized (this.f2847d) {
                            }
                        }
                        if (b10 == 0) {
                            j.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface a10 = this.f2846c.a(this.f2844a, e10);
                            ByteBuffer f10 = e.f(this.f2844a, null, e10.d());
                            if (f10 == null || a10 == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            l b11 = l.b(a10, f10);
                            j.b();
                            synchronized (this.f2847d) {
                                d.h hVar = this.f2851h;
                                if (hVar != null) {
                                    hVar.b(b11);
                                }
                            }
                            b();
                            return;
                        }
                        throw new RuntimeException("fetchFonts result is not OK. (" + b10 + ")");
                    } catch (Throwable th2) {
                        synchronized (this.f2847d) {
                            d.h hVar2 = this.f2851h;
                            if (hVar2 != null) {
                                hVar2.a(th2);
                            }
                            b();
                        }
                    }
                }
            }
        }

        void d() {
            synchronized (this.f2847d) {
                if (this.f2851h != null) {
                    if (this.f2849f == null) {
                        ThreadPoolExecutor b10 = androidx.emoji2.text.b.b("emojiCompat");
                        this.f2850g = b10;
                        this.f2849f = b10;
                    }
                    this.f2849f.execute(new Runnable() { // from class: androidx.emoji2.text.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.b.this.c();
                        }
                    });
                }
            }
        }

        public void f(Executor executor) {
            synchronized (this.f2847d) {
                this.f2849f = executor;
            }
        }
    }

    public i(Context context, h0.d dVar) {
        super(new b(context, dVar, f2843j));
    }

    public i c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
