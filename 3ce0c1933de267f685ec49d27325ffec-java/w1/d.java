package w1;

import android.content.Context;
import androidx.work.k;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
/* compiled from: ConstraintTracker.java */
/* loaded from: classes.dex */
public abstract class d<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final String f35927f = k.f("ConstraintTracker");

    /* renamed from: a  reason: collision with root package name */
    protected final a2.a f35928a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f35929b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f35930c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Set<u1.a<T>> f35931d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    T f35932e;

    /* compiled from: ConstraintTracker.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f35933a;

        a(List list) {
            this.f35933a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (u1.a aVar : this.f35933a) {
                aVar.a(d.this.f35932e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, a2.a aVar) {
        this.f35929b = context.getApplicationContext();
        this.f35928a = aVar;
    }

    public void a(u1.a<T> aVar) {
        synchronized (this.f35930c) {
            if (this.f35931d.add(aVar)) {
                if (this.f35931d.size() == 1) {
                    this.f35932e = b();
                    k.c().a(f35927f, String.format("%s: initial state = %s", getClass().getSimpleName(), this.f35932e), new Throwable[0]);
                    e();
                }
                aVar.a(this.f35932e);
            }
        }
    }

    public abstract T b();

    public void c(u1.a<T> aVar) {
        synchronized (this.f35930c) {
            if (this.f35931d.remove(aVar) && this.f35931d.isEmpty()) {
                f();
            }
        }
    }

    public void d(T t10) {
        synchronized (this.f35930c) {
            T t11 = this.f35932e;
            if (t11 != t10 && (t11 == null || !t11.equals(t10))) {
                this.f35932e = t10;
                this.f35928a.a().execute(new a(new ArrayList(this.f35931d)));
            }
        }
    }

    public abstract void e();

    public abstract void f();
}
