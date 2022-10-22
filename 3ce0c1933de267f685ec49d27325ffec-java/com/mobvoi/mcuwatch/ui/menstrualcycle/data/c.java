package com.mobvoi.mcuwatch.ui.menstrualcycle.data;

import android.content.Context;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.common.data.pojo.DataType;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: PeriodStorage.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: g  reason: collision with root package name */
    public static final a f19788g = new a(null);

    /* renamed from: h  reason: collision with root package name */
    private static c f19789h;

    /* renamed from: a  reason: collision with root package name */
    private final Context f19790a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19791b = "PeriodStorage";

    /* renamed from: c  reason: collision with root package name */
    private final io.d f19792c;

    /* renamed from: d  reason: collision with root package name */
    private final io.d f19793d;

    /* renamed from: e  reason: collision with root package name */
    private final io.d f19794e;

    /* renamed from: f  reason: collision with root package name */
    private final io.d f19795f;

    /* compiled from: PeriodStorage.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final c a(Context context) {
            i.f(context, "context");
            if (c.f19789h == null) {
                c.f19789h = new c(context);
            }
            c cVar = c.f19789h;
            i.d(cVar);
            return cVar;
        }
    }

    /* compiled from: PeriodStorage.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<com.mobvoi.health.common.data.db.a> {
        b() {
            super(0);
        }

        /* renamed from: a */
        public final com.mobvoi.health.common.data.db.a invoke() {
            com.mobvoi.health.common.data.db.a q5 = com.mobvoi.health.common.data.db.a.q(c.this.e());
            q5.r(c.this.h());
            return q5;
        }
    }

    /* compiled from: PeriodStorage.kt */
    /* renamed from: com.mobvoi.mcuwatch.ui.menstrualcycle.data.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0228c extends Lambda implements qo.a<String> {
        C0228c() {
            super(0);
        }

        @Override // qo.a
        public final String invoke() {
            return com.mobvoi.android.common.utils.e.e(c.this.e());
        }
    }

    /* compiled from: PeriodStorage.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements qo.a<ok.a> {
        public static final d INSTANCE = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final ok.a invoke() {
            return new ok.a();
        }
    }

    /* compiled from: PeriodStorage.kt */
    /* loaded from: classes2.dex */
    static final class e extends Lambda implements qo.a<String> {
        e() {
            super(0);
        }

        @Override // qo.a
        public final String invoke() {
            return com.mobvoi.health.companion.system.c.a().l(c.this.e());
        }
    }

    public c(Context context) {
        io.d a10;
        io.d a11;
        io.d a12;
        io.d a13;
        i.f(context, "context");
        this.f19790a = context;
        a10 = io.f.a(new b());
        this.f19792c = a10;
        a11 = io.f.a(new e());
        this.f19793d = a11;
        a12 = io.f.a(new C0228c());
        this.f19794e = a12;
        a13 = io.f.a(d.INSTANCE);
        this.f19795f = a13;
    }

    private final com.mobvoi.health.common.data.db.a f() {
        return (com.mobvoi.health.common.data.db.a) this.f19792c.getValue();
    }

    private final String g() {
        return (String) this.f19794e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h() {
        return (String) this.f19793d.getValue();
    }

    private final void i(DataType dataType, int i10) {
        qf.a aVar = new qf.a(dataType, System.currentTimeMillis());
        aVar.h(i10);
        aVar.f33126b = h();
        aVar.f33125a = g();
        try {
            f().d(aVar);
        } catch (Exception e10) {
            k.r(this.f19791b, "Failed to insert data", e10, new Object[0]);
        }
    }

    private final void j(DataType dataType, long j10, int i10) {
        qf.a aVar = new qf.a(dataType, System.currentTimeMillis());
        aVar.i(i10, j10);
        aVar.f33126b = h();
        aVar.f33125a = g();
        try {
            f().d(aVar);
        } catch (Exception e10) {
            k.r(this.f19791b, "Failed to insert data", e10, new Object[0]);
        }
    }

    public final void d(nk.b eventPoint) {
        i.f(eventPoint, "eventPoint");
        j(DataType.PeriodEvent, eventPoint.f31301a, eventPoint.f31302b.typeCode);
    }

    public final Context e() {
        return this.f19790a;
    }

    public final void k(int i10) {
        i(DataType.PeriodCycleLength, i10);
    }

    public final void l(int i10) {
        i(DataType.PeriodMenstruationLength, i10);
    }
}
