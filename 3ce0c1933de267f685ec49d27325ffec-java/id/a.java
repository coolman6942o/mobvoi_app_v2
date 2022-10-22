package id;

import android.content.Context;
import android.widget.Toast;
import ra.b;
import ra.h;
import sa.c;
/* compiled from: ProfileHealthPresenterImpl.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private Context f28235d;

    /* renamed from: a  reason: collision with root package name */
    private final b f28232a = h.b();

    /* renamed from: c  reason: collision with root package name */
    private final ua.a f28234c = h.a();

    /* renamed from: b  reason: collision with root package name */
    private final dq.b f28233b = new dq.b();

    /* compiled from: ProfileHealthPresenterImpl.java */
    /* renamed from: id.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0314a implements yp.b<c> {
        C0314a() {
        }

        /* renamed from: a */
        public void call(c cVar) {
            if (cVar.b()) {
                Toast.makeText(a.this.f28235d, a.this.f28235d.getString(ce.h.f5877w), 0).show();
            }
        }
    }

    public a(Context context) {
        this.f28235d = context;
    }

    public void b(sa.a aVar) {
        this.f28233b.a(this.f28232a.e(aVar).Z(this.f28234c.b()).H(this.f28234c.a()).X(new C0314a()));
    }
}
