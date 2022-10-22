package u1;

import a2.a;
import android.content.Context;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.k;
import java.util.ArrayList;
import java.util.List;
import v1.b;
import v1.c;
import v1.e;
import v1.f;
import v1.g;
import v1.h;
import y1.p;
/* compiled from: WorkConstraintsTracker.java */
/* loaded from: classes.dex */
public class d implements c.a {

    /* renamed from: d  reason: collision with root package name */
    private static final String f35269d = k.f("WorkConstraintsTracker");

    /* renamed from: a  reason: collision with root package name */
    private final c f35270a;

    /* renamed from: b  reason: collision with root package name */
    private final ConstraintController<?>[] f35271b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f35272c = new Object();

    public d(Context context, a aVar, c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.f35270a = cVar;
        this.f35271b = new c[]{new v1.a(applicationContext, aVar), new b(applicationContext, aVar), new h(applicationContext, aVar), new v1.d(applicationContext, aVar), new g(applicationContext, aVar), new f(applicationContext, aVar), new e(applicationContext, aVar)};
    }

    @Override // v1.c.a
    public void a(List<String> list) {
        synchronized (this.f35272c) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (c(str)) {
                    k.c().a(f35269d, String.format("Constraints met for %s", str), new Throwable[0]);
                    arrayList.add(str);
                }
            }
            c cVar = this.f35270a;
            if (cVar != null) {
                cVar.e(arrayList);
            }
        }
    }

    @Override // v1.c.a
    public void b(List<String> list) {
        synchronized (this.f35272c) {
            c cVar = this.f35270a;
            if (cVar != null) {
                cVar.b(list);
            }
        }
    }

    public boolean c(String str) {
        c[] cVarArr;
        synchronized (this.f35272c) {
            for (c cVar : this.f35271b) {
                if (cVar.d(str)) {
                    k.c().a(f35269d, String.format("Work %s constrained by %s", str, cVar.getClass().getSimpleName()), new Throwable[0]);
                    return false;
                }
            }
            return true;
        }
    }

    public void d(Iterable<p> iterable) {
        synchronized (this.f35272c) {
            for (c cVar : this.f35271b) {
                cVar.g(null);
            }
            for (c cVar2 : this.f35271b) {
                cVar2.e(iterable);
            }
            for (c cVar3 : this.f35271b) {
                cVar3.g(this);
            }
        }
    }

    public void e() {
        synchronized (this.f35272c) {
            for (c cVar : this.f35271b) {
                cVar.f();
            }
        }
    }
}
