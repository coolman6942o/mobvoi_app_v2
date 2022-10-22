package qi;

import android.annotation.SuppressLint;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.mobvoi.mcuwatch.settings.persistence.DeviceDataSourceImpl;
import ei.h;
import fj.e;
import fj.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import pi.a;
import rx.c;
import rx.subjects.b;
import rx.subjects.d;
import sh.k;
import wi.f;
import yp.g;
/* compiled from: WatchLiteBaseViewModel.java */
/* loaded from: classes2.dex */
public class w extends f {

    /* renamed from: c  reason: collision with root package name */
    private final d<a, a> f33187c = b.o0();

    /* renamed from: d  reason: collision with root package name */
    protected ArrayList<e> f33188d = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    protected final ni.a f33186b = DeviceDataSourceImpl.getInstance();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean p(String str, a aVar) {
        return Boolean.valueOf(TextUtils.equals(str, aVar.macAddress));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean q(Object obj) {
        return Boolean.valueOf(obj instanceof pk.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ pk.f r(Object obj) {
        return (pk.f) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c s(androidx.fragment.app.f fVar, Boolean bool) {
        if (bool.booleanValue()) {
            return j.h(fVar, "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT");
        }
        return c.A(this.f33188d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(String str, androidx.fragment.app.f fVar, List list) {
        boolean z10;
        Iterator it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!((e) it.next()).f27050a) {
                    z10 = false;
                    break;
                }
            } else {
                z10 = true;
                break;
            }
        }
        if (z10) {
            y(str);
        } else {
            Toast.makeText(fVar, fVar.getString(k.Z1), 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c u(androidx.fragment.app.f fVar, Boolean bool) {
        if (bool.booleanValue()) {
            return j.h(fVar, j.d());
        }
        return c.A(this.f33188d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(androidx.fragment.app.f fVar, List list) {
        boolean z10;
        Iterator it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                if (!((e) it.next()).f27050a) {
                    z10 = false;
                    break;
                }
            } else {
                z10 = true;
                break;
            }
        }
        if (z10) {
            h.a().o(fVar);
        } else {
            Toast.makeText(fVar, j.c(fVar), 0).show();
        }
    }

    public void A(final androidx.fragment.app.f fVar) {
        this.f33188d.clear();
        c.A(Boolean.valueOf(Build.VERSION.SDK_INT >= 23)).v(new g() { // from class: qi.s
            @Override // yp.g
            public final Object call(Object obj) {
                c u10;
                u10 = w.this.u(fVar, (Boolean) obj);
                return u10;
            }
        }).X(new yp.b() { // from class: qi.n
            @Override // yp.b
            public final void call(Object obj) {
                w.v(androidx.fragment.app.f.this, (List) obj);
            }
        });
    }

    public void B(Context context) {
        h.a().j(context);
    }

    public void C(androidx.fragment.app.f fVar) {
        h.a().e(fVar);
    }

    public Application getApplication() {
        return com.mobvoi.android.common.utils.b.e();
    }

    public c<a> i(final String str) {
        return this.f33186b.dataChange().u(new g() { // from class: qi.r
            @Override // yp.g
            public final Object call(Object obj) {
                Boolean p10;
                p10 = w.p(str, (a) obj);
                return p10;
            }
        });
    }

    public c<a> j(String str) {
        c<a> l10 = k(str).l(100L, TimeUnit.MILLISECONDS);
        final d<a, a> dVar = this.f33187c;
        Objects.requireNonNull(dVar);
        yp.b<? super a> pVar = new yp.b() { // from class: qi.p
            @Override // yp.b
            public final void call(Object obj) {
                d.this.onNext((a) obj);
            }
        };
        final d<a, a> dVar2 = this.f33187c;
        Objects.requireNonNull(dVar2);
        a(l10.Y(pVar, new yp.b() { // from class: qi.q
            @Override // yp.b
            public final void call(Object obj) {
                d.this.onError((Throwable) obj);
            }
        }));
        c<a> i10 = i(str);
        final d<a, a> dVar3 = this.f33187c;
        Objects.requireNonNull(dVar3);
        yp.b<? super a> pVar2 = new yp.b() { // from class: qi.p
            @Override // yp.b
            public final void call(Object obj) {
                d.this.onNext((a) obj);
            }
        };
        final d<a, a> dVar4 = this.f33187c;
        Objects.requireNonNull(dVar4);
        a(i10.Y(pVar2, new yp.b() { // from class: qi.q
            @Override // yp.b
            public final void call(Object obj) {
                d.this.onError((Throwable) obj);
            }
        }));
        return this.f33187c.L();
    }

    public c<a> k(String str) {
        return this.f33186b.queryDevice(str);
    }

    public c<pk.f> l() {
        return ci.a.b().c().u(v.f33185a).D(u.f33184a);
    }

    public boolean m(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ci.a.b().f(str);
    }

    @SuppressLint({"MissingPermission"})
    public boolean n() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    public boolean o() {
        return h.a().n();
    }

    public void w(androidx.fragment.app.f fVar) {
        h.a().o(fVar);
    }

    public void x(pk.f fVar) {
        mi.a.d(fVar);
        this.f33186b.insertOrUpdateInfo(fVar);
    }

    public void y(String str) {
        h.a().l(getApplication(), str);
    }

    public void z(final androidx.fragment.app.f fVar, final String str) {
        this.f33188d.clear();
        c.A(Boolean.valueOf(Build.VERSION.SDK_INT > 30)).v(new g() { // from class: qi.t
            @Override // yp.g
            public final Object call(Object obj) {
                c s10;
                s10 = w.this.s(fVar, (Boolean) obj);
                return s10;
            }
        }).X(new yp.b() { // from class: qi.o
            @Override // yp.b
            public final void call(Object obj) {
                w.this.t(str, fVar, (List) obj);
            }
        });
    }
}
