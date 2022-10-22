package g5;

import android.util.Log;
import j5.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import n5.k;
/* compiled from: RequestTracker.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final Set<a> f27282a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f27283b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f27284c;

    public boolean a(a aVar) {
        boolean z10 = true;
        if (aVar == null) {
            return true;
        }
        boolean remove = this.f27282a.remove(aVar);
        if (!this.f27283b.remove(aVar) && !remove) {
            z10 = false;
        }
        if (z10) {
            aVar.clear();
        }
        return z10;
    }

    public void b() {
        for (a aVar : k.i(this.f27282a)) {
            a(aVar);
        }
        this.f27283b.clear();
    }

    public void c() {
        this.f27284c = true;
        for (a aVar : k.i(this.f27282a)) {
            if (aVar.isRunning() || aVar.k()) {
                aVar.clear();
                this.f27283b.add(aVar);
            }
        }
    }

    public void d() {
        this.f27284c = true;
        for (a aVar : k.i(this.f27282a)) {
            if (aVar.isRunning()) {
                aVar.b();
                this.f27283b.add(aVar);
            }
        }
    }

    public void e() {
        for (a aVar : k.i(this.f27282a)) {
            if (!aVar.k() && !aVar.d()) {
                aVar.clear();
                if (!this.f27284c) {
                    aVar.e();
                } else {
                    this.f27283b.add(aVar);
                }
            }
        }
    }

    public void f() {
        this.f27284c = false;
        for (a aVar : k.i(this.f27282a)) {
            if (!aVar.k() && !aVar.isRunning()) {
                aVar.e();
            }
        }
        this.f27283b.clear();
    }

    public void g(a aVar) {
        this.f27282a.add(aVar);
        if (!this.f27284c) {
            aVar.e();
            return;
        }
        aVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f27283b.add(aVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f27282a.size() + ", isPaused=" + this.f27284c + "}";
    }
}
