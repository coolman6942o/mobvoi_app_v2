package ci;

import android.text.TextUtils;
import ei.h;
import java.util.concurrent.atomic.AtomicReference;
import rx.c;
import rx.subjects.d;
/* compiled from: BleRxBus.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final d<Object, Object> f5902a;

    /* renamed from: b  reason: collision with root package name */
    private AtomicReference<fi.a> f5903b;

    /* compiled from: BleRxBus.java */
    /* loaded from: classes2.dex */
    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final a f5904a = new a();
    }

    public static a b() {
        return b.f5904a;
    }

    private fi.a d() {
        fi.a aVar = this.f5903b.get();
        if (aVar == null || TextUtils.isEmpty(aVar.b()) || aVar.c() != 1) {
            return aVar;
        }
        fi.a q5 = h.a().q(aVar.b());
        if (q5.c() == 1) {
            return aVar;
        }
        fi.a aVar2 = new fi.a(q5.c(), aVar.b());
        g(aVar2);
        return aVar2;
    }

    public fi.a a(String str) {
        fi.a d10 = d();
        return (d10 == null || (str != null && !d10.d(str))) ? new fi.a(0, str) : d10;
    }

    public c<Object> c() {
        return this.f5902a;
    }

    public boolean e() {
        fi.a d10 = d();
        return d10 != null && d10.c() == 1;
    }

    public boolean f(String str) {
        fi.a d10 = d();
        return d10 != null && d10.d(str) && d10.c() == 1;
    }

    public void g(Object obj) {
        if (obj instanceof fi.a) {
            this.f5903b.getAndSet((fi.a) obj);
        }
        if (this.f5902a.m0()) {
            this.f5902a.onNext(obj);
        }
    }

    private a() {
        this.f5903b = new AtomicReference<>();
        this.f5902a = rx.subjects.b.o0();
    }
}
