package com.mobvoi.companion.health;

import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.f0;
import androidx.lifecycle.w;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import io.m;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import rx.c;
import sc.i;
import tc.e;
import tc.f;
import yp.b;
/* compiled from: SportMedalViewModel.kt */
/* loaded from: classes2.dex */
public final class SportMedalViewModel extends f0 {

    /* renamed from: a  reason: collision with root package name */
    private final i f16802a;

    /* renamed from: b  reason: collision with root package name */
    private final w<Pair<Boolean, f.a>> f16803b = new w<>();

    /* renamed from: c  reason: collision with root package name */
    private final w<Pair<Boolean, List<e.a>>> f16804c = new w<>();

    /* renamed from: d  reason: collision with root package name */
    private final Calendar f16805d = Calendar.getInstance();

    /* renamed from: e  reason: collision with root package name */
    private final DateFormat f16806e = new SimpleDateFormat(SettingConstants.DATE_FORMAT_DEFAULT);

    /* compiled from: SportMedalViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public SportMedalViewModel(i sportMedalApiHelper) {
        kotlin.jvm.internal.i.f(sportMedalApiHelper, "sportMedalApiHelper");
        this.f16802a = sportMedalApiHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SportMedalViewModel this$0, f response) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(response, "response");
        if (response.b() == 0) {
            this$0.j().m(new Pair<>(Boolean.TRUE, response.a()));
        } else {
            this$0.j().m(new Pair<>(Boolean.FALSE, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(SportMedalViewModel this$0, Throwable th2) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.j().m(new Pair<>(Boolean.FALSE, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List l(e resp1, e resp2) {
        List<e.a> b10;
        List<e.a> b11;
        kotlin.jvm.internal.i.f(resp1, "resp1");
        kotlin.jvm.internal.i.f(resp2, "resp2");
        ArrayList arrayList = new ArrayList();
        if (resp2.a() == 0 && (b11 = resp2.b()) != null) {
            arrayList.addAll(b11);
        }
        if (resp1.a() == 0 && (b10 = resp1.b()) != null) {
            arrayList.addAll(b10);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(SportMedalViewModel this$0, List list) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(list, "list");
        if (!list.isEmpty()) {
            this$0.i().m(new Pair<>(Boolean.TRUE, list));
        } else {
            this$0.i().m(new Pair<>(Boolean.FALSE, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(SportMedalViewModel this$0, Throwable throwable) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(throwable, "throwable");
        k.d("SportMedalViewModel", throwable.getMessage());
        this$0.i().m(new Pair<>(Boolean.FALSE, null));
    }

    public final m h() {
        String s10 = ta.a.s();
        if (TextUtils.isEmpty(s10)) {
            return m.f28349a;
        }
        this.f16802a.a(s10).Y(new b() { // from class: com.mobvoi.companion.health.n3
            @Override // yp.b
            public final void call(Object obj) {
                SportMedalViewModel.f(SportMedalViewModel.this, (f) obj);
            }
        }, new b() { // from class: com.mobvoi.companion.health.p3
            @Override // yp.b
            public final void call(Object obj) {
                SportMedalViewModel.g(SportMedalViewModel.this, (Throwable) obj);
            }
        });
        return m.f28349a;
    }

    public final w<Pair<Boolean, List<e.a>>> i() {
        return this.f16804c;
    }

    public final w<Pair<Boolean, f.a>> j() {
        return this.f16803b;
    }

    public final void k(boolean z10) {
        String s10 = ta.a.s();
        if (!TextUtils.isEmpty(s10)) {
            if (z10) {
                this.f16805d.setTime(new Date(System.currentTimeMillis()));
            } else {
                this.f16805d.add(2, -1);
            }
            Calendar calendar = this.f16805d;
            calendar.set(5, calendar.getActualMinimum(5));
            String format = this.f16806e.format(this.f16805d.getTime());
            this.f16805d.add(2, -1);
            c<e> Z = this.f16802a.b(s10, this.f16806e.format(this.f16805d.getTime()), format).Z(cq.a.c());
            this.f16805d.add(2, -1);
            Calendar calendar2 = this.f16805d;
            calendar2.set(5, calendar2.getActualMinimum(5));
            String format2 = this.f16806e.format(this.f16805d.getTime());
            this.f16805d.add(2, -1);
            c.l0(Z, this.f16802a.b(s10, this.f16806e.format(this.f16805d.getTime()), format2).Z(cq.a.c()), r3.f16949a).Z(cq.a.c()).Y(new b() { // from class: com.mobvoi.companion.health.q3
                @Override // yp.b
                public final void call(Object obj) {
                    SportMedalViewModel.m(SportMedalViewModel.this, (List) obj);
                }
            }, new b() { // from class: com.mobvoi.companion.health.o3
                @Override // yp.b
                public final void call(Object obj) {
                    SportMedalViewModel.n(SportMedalViewModel.this, (Throwable) obj);
                }
            });
        }
    }
}
