package com.mobvoi.mcuwatch.ui.onlinedial.apollo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.w;
import dq.b;
import io.d;
import io.f;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import yh.c;
/* compiled from: DialViewModel.kt */
/* loaded from: classes2.dex */
public final class v extends f0 {

    /* renamed from: a  reason: collision with root package name */
    private final String f19954a;

    /* renamed from: b  reason: collision with root package name */
    private final b f19955b;

    /* renamed from: c  reason: collision with root package name */
    private final d f19956c;

    /* compiled from: DialViewModel.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements qo.a<w<List<? extends c>>> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final w<List<c>> invoke() {
            w<List<c>> wVar = new w<>();
            v.f(v.this, 0, 1, null);
            return wVar;
        }
    }

    public v() {
        d a10;
        this.f19954a = yd.b.c(com.mobvoi.android.common.utils.b.e()) ? "en" : "cn";
        this.f19955b = new b();
        a10 = f.a(new a());
        this.f19956c = a10;
    }

    private final w<List<c>> d() {
        return (w) this.f19956c.getValue();
    }

    public static /* synthetic */ void f(v vVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 100;
        }
        vVar.e(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(v this$0, List list) {
        i.f(this$0, "this$0");
        this$0.d().o(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Throwable th2) {
    }

    public final LiveData<List<c>> c() {
        return d();
    }

    public final void e(int i10) {
        th.b g10 = ki.d.f29985b.g();
        String s10 = ta.a.s();
        i.e(s10, "getSessionId()");
        this.f19955b.a(g10.b(s10, 0, i10, this.f19954a).e(cq.a.c()).b(xp.a.b()).d(new yp.b() { // from class: com.mobvoi.mcuwatch.ui.onlinedial.apollo.t
            @Override // yp.b
            public final void call(Object obj) {
                v.g(v.this, (List) obj);
            }
        }, u.f19953a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.f0
    public void onCleared() {
        super.onCleared();
        this.f19955b.b();
    }
}
