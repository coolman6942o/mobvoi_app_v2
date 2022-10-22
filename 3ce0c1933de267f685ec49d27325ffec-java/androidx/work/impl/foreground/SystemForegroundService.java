package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.s;
import androidx.work.impl.foreground.a;
import androidx.work.k;
/* loaded from: classes.dex */
public class SystemForegroundService extends s implements a.b {

    /* renamed from: f  reason: collision with root package name */
    private static final String f4817f = k.f("SystemFgService");

    /* renamed from: b  reason: collision with root package name */
    private Handler f4818b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4819c;

    /* renamed from: d  reason: collision with root package name */
    androidx.work.impl.foreground.a f4820d;

    /* renamed from: e  reason: collision with root package name */
    NotificationManager f4821e;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4822a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Notification f4823b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f4824c;

        a(int i10, Notification notification, int i11) {
            this.f4822a = i10;
            this.f4823b = notification;
            this.f4824c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f4822a, this.f4823b, this.f4824c);
            } else {
                SystemForegroundService.this.startForeground(this.f4822a, this.f4823b);
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4826a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Notification f4827b;

        b(int i10, Notification notification) {
            this.f4826a = i10;
            this.f4827b = notification;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f4821e.notify(this.f4826a, this.f4827b);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4829a;

        c(int i10) {
            this.f4829a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f4821e.cancel(this.f4829a);
        }
    }

    private void e() {
        this.f4818b = new Handler(Looper.getMainLooper());
        this.f4821e = (NotificationManager) getApplicationContext().getSystemService("notification");
        androidx.work.impl.foreground.a aVar = new androidx.work.impl.foreground.a(getApplicationContext());
        this.f4820d = aVar;
        aVar.m(this);
    }

    @Override // androidx.work.impl.foreground.a.b
    public void b(int i10, int i11, Notification notification) {
        this.f4818b.post(new a(i10, notification, i11));
    }

    @Override // androidx.work.impl.foreground.a.b
    public void c(int i10, Notification notification) {
        this.f4818b.post(new b(i10, notification));
    }

    @Override // androidx.work.impl.foreground.a.b
    public void d(int i10) {
        this.f4818b.post(new c(i10));
    }

    @Override // androidx.lifecycle.s, android.app.Service
    public void onCreate() {
        super.onCreate();
        e();
    }

    @Override // androidx.lifecycle.s, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f4820d.k();
    }

    @Override // androidx.lifecycle.s, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f4819c) {
            k.c().d(f4817f, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f4820d.k();
            e();
            this.f4819c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f4820d.l(intent);
        return 3;
    }

    @Override // androidx.work.impl.foreground.a.b
    public void stop() {
        this.f4819c = true;
        k.c().a(f4817f, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        stopSelf();
    }
}
