package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.lifecycle.s;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.k;
import z1.j;
/* loaded from: classes.dex */
public class SystemAlarmService extends s implements e.c {

    /* renamed from: d  reason: collision with root package name */
    private static final String f4772d = k.f("SystemAlarmService");

    /* renamed from: b  reason: collision with root package name */
    private e f4773b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4774c;

    private void e() {
        e eVar = new e(this);
        this.f4773b = eVar;
        eVar.m(this);
    }

    @Override // androidx.work.impl.background.systemalarm.e.c
    public void a() {
        this.f4774c = true;
        k.c().a(f4772d, "All commands completed in dispatcher", new Throwable[0]);
        j.a();
        stopSelf();
    }

    @Override // androidx.lifecycle.s, android.app.Service
    public void onCreate() {
        super.onCreate();
        e();
        this.f4774c = false;
    }

    @Override // androidx.lifecycle.s, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f4774c = true;
        this.f4773b.j();
    }

    @Override // androidx.lifecycle.s, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        super.onStartCommand(intent, i10, i11);
        if (this.f4774c) {
            k.c().d(f4772d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f4773b.j();
            e();
            this.f4774c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f4773b.a(intent, i11);
        return 3;
    }
}
