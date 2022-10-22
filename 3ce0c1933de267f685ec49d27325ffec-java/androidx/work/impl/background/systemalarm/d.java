package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.e;
import androidx.work.k;
import java.util.Collections;
import java.util.List;
import r1.b;
import u1.c;
import y1.p;
import z1.j;
import z1.n;
/* compiled from: DelayMetCommandHandler.java */
/* loaded from: classes.dex */
public class d implements c, b, n.b {

    /* renamed from: j  reason: collision with root package name */
    private static final String f4785j = k.f("DelayMetCommandHandler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f4786a;

    /* renamed from: b  reason: collision with root package name */
    private final int f4787b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4788c;

    /* renamed from: d  reason: collision with root package name */
    private final e f4789d;

    /* renamed from: e  reason: collision with root package name */
    private final u1.d f4790e;

    /* renamed from: h  reason: collision with root package name */
    private PowerManager.WakeLock f4793h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4794i = false;

    /* renamed from: g  reason: collision with root package name */
    private int f4792g = 0;

    /* renamed from: f  reason: collision with root package name */
    private final Object f4791f = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, int i10, String str, e eVar) {
        this.f4786a = context;
        this.f4787b = i10;
        this.f4789d = eVar;
        this.f4788c = str;
        this.f4790e = new u1.d(context, eVar.f(), this);
    }

    private void d() {
        synchronized (this.f4791f) {
            this.f4790e.e();
            this.f4789d.h().c(this.f4788c);
            PowerManager.WakeLock wakeLock = this.f4793h;
            if (wakeLock != null && wakeLock.isHeld()) {
                k.c().a(f4785j, String.format("Releasing wakelock %s for WorkSpec %s", this.f4793h, this.f4788c), new Throwable[0]);
                this.f4793h.release();
            }
        }
    }

    private void g() {
        synchronized (this.f4791f) {
            if (this.f4792g < 2) {
                this.f4792g = 2;
                k c10 = k.c();
                String str = f4785j;
                c10.a(str, String.format("Stopping work for WorkSpec %s", this.f4788c), new Throwable[0]);
                Intent g10 = b.g(this.f4786a, this.f4788c);
                e eVar = this.f4789d;
                eVar.k(new e.b(eVar, g10, this.f4787b));
                if (this.f4789d.e().g(this.f4788c)) {
                    k.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.f4788c), new Throwable[0]);
                    Intent f10 = b.f(this.f4786a, this.f4788c);
                    e eVar2 = this.f4789d;
                    eVar2.k(new e.b(eVar2, f10, this.f4787b));
                } else {
                    k.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f4788c), new Throwable[0]);
                }
            } else {
                k.c().a(f4785j, String.format("Already stopped work for %s", this.f4788c), new Throwable[0]);
            }
        }
    }

    @Override // z1.n.b
    public void a(String str) {
        k.c().a(f4785j, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // u1.c
    public void b(List<String> list) {
        g();
    }

    @Override // r1.b
    public void c(String str, boolean z10) {
        k.c().a(f4785j, String.format("onExecuted %s, %s", str, Boolean.valueOf(z10)), new Throwable[0]);
        d();
        if (z10) {
            Intent f10 = b.f(this.f4786a, this.f4788c);
            e eVar = this.f4789d;
            eVar.k(new e.b(eVar, f10, this.f4787b));
        }
        if (this.f4794i) {
            Intent a10 = b.a(this.f4786a);
            e eVar2 = this.f4789d;
            eVar2.k(new e.b(eVar2, a10, this.f4787b));
        }
    }

    @Override // u1.c
    public void e(List<String> list) {
        if (list.contains(this.f4788c)) {
            synchronized (this.f4791f) {
                if (this.f4792g == 0) {
                    this.f4792g = 1;
                    k.c().a(f4785j, String.format("onAllConstraintsMet for %s", this.f4788c), new Throwable[0]);
                    if (this.f4789d.e().j(this.f4788c)) {
                        this.f4789d.h().b(this.f4788c, 600000L, this);
                    } else {
                        d();
                    }
                } else {
                    k.c().a(f4785j, String.format("Already started work for %s", this.f4788c), new Throwable[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f4793h = j.b(this.f4786a, String.format("%s (%s)", this.f4788c, Integer.valueOf(this.f4787b)));
        k c10 = k.c();
        String str = f4785j;
        c10.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.f4793h, this.f4788c), new Throwable[0]);
        this.f4793h.acquire();
        p n10 = this.f4789d.g().n().M().n(this.f4788c);
        if (n10 == null) {
            g();
            return;
        }
        boolean b10 = n10.b();
        this.f4794i = b10;
        if (!b10) {
            k.c().a(str, String.format("No constraints for %s", this.f4788c), new Throwable[0]);
            e(Collections.singletonList(this.f4788c));
            return;
        }
        this.f4790e.d(Collections.singletonList(n10));
    }
}
