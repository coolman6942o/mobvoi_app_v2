package com.mobvoi.companion.profile;

import android.app.Application;
import android.content.Context;
import android.util.Pair;
import android.widget.Toast;
import androidx.lifecycle.w;
import com.google.gson.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.pojo.DataType;
import java.util.ArrayList;
import rx.i;
/* compiled from: HealthInfoModel.java */
/* loaded from: classes2.dex */
public class h extends ed.a {

    /* renamed from: b  reason: collision with root package name */
    private final ra.b f17333b = ra.h.b();

    /* renamed from: c  reason: collision with root package name */
    private w<Pair<Boolean, sa.a>> f17334c = new w<>();

    /* renamed from: d  reason: collision with root package name */
    protected w<Boolean> f17335d = new w<>();

    /* renamed from: e  reason: collision with root package name */
    protected Context f17336e;

    /* renamed from: f  reason: collision with root package name */
    private c f17337f;

    /* compiled from: HealthInfoModel.java */
    /* loaded from: classes2.dex */
    class a extends i<sa.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ sa.a f17338a;

        a(sa.a aVar) {
            this.f17338a = aVar;
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            k.a("HealthInfoModel", new e().s(cVar));
            if (cVar.b()) {
                h.this.f17334c.o(new Pair(Boolean.TRUE, this.f17338a));
                if (h.this.f17337f != null) {
                    h.this.f17337f.a();
                    return;
                }
                return;
            }
            Toast.makeText(h.this.f17336e, cVar.errorMsg, 1).show();
            h.this.f17334c.o(new Pair(Boolean.FALSE, this.f17338a));
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.f("HealthInfoModel", "modify fail: %s", th2.getMessage());
            h.this.f17334c.o(new Pair(Boolean.FALSE, this.f17338a));
        }
    }

    /* compiled from: HealthInfoModel.java */
    /* loaded from: classes2.dex */
    class b extends i<sa.c> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f17340a;

        b(boolean z10) {
            this.f17340a = z10;
        }

        /* renamed from: b */
        public void onNext(sa.c cVar) {
            if (cVar.b()) {
                k.a("HealthInfoModel", "pii modify success: " + this.f17340a);
                h.this.f17335d.o(Boolean.TRUE);
                ta.a.G(this.f17340a);
                return;
            }
            k.a("HealthInfoModel", "pii modify failed: " + this.f17340a);
            h.this.f17335d.o(Boolean.FALSE);
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            k.e("HealthInfoModel", "modify fail", th2);
            h.this.f17335d.o(Boolean.FALSE);
        }
    }

    /* compiled from: HealthInfoModel.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a();
    }

    public h(Application application) {
        super(application);
        new ArrayList();
        this.f17336e = application;
        new w();
    }

    public w<Pair<Boolean, sa.a>> d() {
        return this.f17334c;
    }

    public w<Boolean> e() {
        return this.f17335d;
    }

    public void f() {
        ig.b.J().x(0L, Long.valueOf(System.currentTimeMillis()), DataType.GoalTodayExercise);
        ig.b.J().x(0L, Long.valueOf(System.currentTimeMillis()), DataType.GoalTodayActive);
        ig.b.J().x(0L, Long.valueOf(System.currentTimeMillis()), DataType.GoalTodayStep);
    }

    public void g(c cVar) {
        this.f17337f = cVar;
    }

    public void h(sa.a aVar) {
        k.a("HealthInfoModel", "update account info");
        if (!ta.a.b()) {
            Context context = this.f17336e;
            Toast.makeText(context, context.getString(ce.h.V), 0).show();
            this.f17334c.o(new Pair<>(Boolean.FALSE, aVar));
        } else if (aVar == null) {
            this.f17334c.o(new Pair<>(Boolean.FALSE, aVar));
        } else {
            a(this.f17333b.e(aVar).Z(cq.a.c()).H(xp.a.b()).V(new a(aVar)));
        }
    }

    public void i(boolean z10) {
        a(this.f17333b.f(ta.a.s(), z10).Z(cq.a.c()).H(xp.a.b()).V(new b(z10)));
    }
}
