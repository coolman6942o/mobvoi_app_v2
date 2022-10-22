package androidx.work;

import android.os.Build;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: Configuration.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    final Executor f4695a;

    /* renamed from: b  reason: collision with root package name */
    final Executor f4696b;

    /* renamed from: c  reason: collision with root package name */
    final t f4697c;

    /* renamed from: d  reason: collision with root package name */
    final i f4698d;

    /* renamed from: e  reason: collision with root package name */
    final p f4699e;

    /* renamed from: f  reason: collision with root package name */
    final g f4700f;

    /* renamed from: g  reason: collision with root package name */
    final String f4701g;

    /* renamed from: h  reason: collision with root package name */
    final int f4702h;

    /* renamed from: i  reason: collision with root package name */
    final int f4703i;

    /* renamed from: j  reason: collision with root package name */
    final int f4704j;

    /* renamed from: k  reason: collision with root package name */
    final int f4705k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Configuration.java */
    /* renamed from: androidx.work.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class ThreadFactoryC0054a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f4706a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f4707b;

        ThreadFactoryC0054a(a aVar, boolean z10) {
            this.f4707b = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            String str = this.f4707b ? "WM.task-" : "androidx.work-";
            return new Thread(runnable, str + this.f4706a.incrementAndGet());
        }
    }

    /* compiled from: Configuration.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        Executor f4708a;

        /* renamed from: b  reason: collision with root package name */
        t f4709b;

        /* renamed from: c  reason: collision with root package name */
        i f4710c;

        /* renamed from: d  reason: collision with root package name */
        Executor f4711d;

        /* renamed from: e  reason: collision with root package name */
        p f4712e;

        /* renamed from: f  reason: collision with root package name */
        g f4713f;

        /* renamed from: g  reason: collision with root package name */
        String f4714g;

        /* renamed from: h  reason: collision with root package name */
        int f4715h = 4;

        /* renamed from: i  reason: collision with root package name */
        int f4716i = 0;

        /* renamed from: j  reason: collision with root package name */
        int f4717j = Integer.MAX_VALUE;

        /* renamed from: k  reason: collision with root package name */
        int f4718k = 20;

        public a a() {
            return new a(this);
        }
    }

    /* compiled from: Configuration.java */
    /* loaded from: classes.dex */
    public interface c {
        a a();
    }

    a(b bVar) {
        Executor executor = bVar.f4708a;
        if (executor == null) {
            this.f4695a = a(false);
        } else {
            this.f4695a = executor;
        }
        Executor executor2 = bVar.f4711d;
        if (executor2 == null) {
            this.f4696b = a(true);
        } else {
            this.f4696b = executor2;
        }
        t tVar = bVar.f4709b;
        if (tVar == null) {
            this.f4697c = t.c();
        } else {
            this.f4697c = tVar;
        }
        i iVar = bVar.f4710c;
        if (iVar == null) {
            this.f4698d = i.c();
        } else {
            this.f4698d = iVar;
        }
        p pVar = bVar.f4712e;
        if (pVar == null) {
            this.f4699e = new r1.a();
        } else {
            this.f4699e = pVar;
        }
        this.f4702h = bVar.f4715h;
        this.f4703i = bVar.f4716i;
        this.f4704j = bVar.f4717j;
        this.f4705k = bVar.f4718k;
        this.f4700f = bVar.f4713f;
        this.f4701g = bVar.f4714g;
    }

    private Executor a(boolean z10) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z10));
    }

    private ThreadFactory b(boolean z10) {
        return new ThreadFactoryC0054a(this, z10);
    }

    public String c() {
        return this.f4701g;
    }

    public g d() {
        return this.f4700f;
    }

    public Executor e() {
        return this.f4695a;
    }

    public i f() {
        return this.f4698d;
    }

    public int g() {
        return this.f4704j;
    }

    public int h() {
        if (Build.VERSION.SDK_INT == 23) {
            return this.f4705k / 2;
        }
        return this.f4705k;
    }

    public int i() {
        return this.f4703i;
    }

    public int j() {
        return this.f4702h;
    }

    public p k() {
        return this.f4699e;
    }

    public Executor l() {
        return this.f4696b;
    }

    public t m() {
        return this.f4697c;
    }
}
