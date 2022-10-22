package com.mobvoi.companion.health.entity;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import tc.e;
import tc.f;
/* compiled from: SportMedalData.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static final C0205a f16843f = new C0205a(null);

    /* renamed from: a  reason: collision with root package name */
    private long f16844a;

    /* renamed from: b  reason: collision with root package name */
    private long f16845b;

    /* renamed from: c  reason: collision with root package name */
    private int f16846c;

    /* renamed from: d  reason: collision with root package name */
    private String f16847d = "";

    /* renamed from: e  reason: collision with root package name */
    private List<b> f16848e = new ArrayList();

    /* compiled from: SportMedalData.kt */
    /* renamed from: com.mobvoi.companion.health.entity.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0205a {
        private C0205a() {
        }

        public /* synthetic */ C0205a(f fVar) {
            this();
        }

        public final a a(e.a sportWeekOfMonthCompleteBean) {
            i.f(sportWeekOfMonthCompleteBean, "sportWeekOfMonthCompleteBean");
            a aVar = new a();
            aVar.i(sportWeekOfMonthCompleteBean.a());
            List<e.a.C0504a> b10 = sportWeekOfMonthCompleteBean.b();
            if (b10 != null) {
                for (e.a.C0504a aVar2 : b10) {
                    b bVar = new b();
                    bVar.f16850b = aVar2.a();
                    bVar.f16851c = aVar2.b();
                    bVar.f16852d = aVar2.c();
                    bVar.f16849a = aVar2.d();
                    bVar.f16853e = aVar2.e();
                    aVar.e().add(bVar);
                }
            }
            return aVar;
        }

        public final a b(f.a currentWeekSportCompleteBean) {
            i.f(currentWeekSportCompleteBean, "currentWeekSportCompleteBean");
            a aVar = new a();
            aVar.f(currentWeekSportCompleteBean.a());
            aVar.h(currentWeekSportCompleteBean.b());
            aVar.g(currentWeekSportCompleteBean.c());
            return aVar;
        }
    }

    /* compiled from: SportMedalData.kt */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public long f16849a;

        /* renamed from: b  reason: collision with root package name */
        public long f16850b;

        /* renamed from: c  reason: collision with root package name */
        public String f16851c = "";

        /* renamed from: d  reason: collision with root package name */
        public String f16852d = "";

        /* renamed from: e  reason: collision with root package name */
        public int f16853e;
    }

    public final long a() {
        return this.f16845b;
    }

    public final int b() {
        return this.f16846c;
    }

    public final long c() {
        return this.f16844a;
    }

    public final String d() {
        return this.f16847d;
    }

    public final List<b> e() {
        return this.f16848e;
    }

    public final void f(long j10) {
        this.f16845b = j10;
    }

    public final void g(int i10) {
        this.f16846c = i10;
    }

    public final void h(long j10) {
        this.f16844a = j10;
    }

    public final void i(String str) {
        i.f(str, "<set-?>");
        this.f16847d = str;
    }
}
