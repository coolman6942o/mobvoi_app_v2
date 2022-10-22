package com.mobvoi.health.companion.heartrate.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import com.mobvoi.health.companion.heartrate.ui.BodyMindChartDayView;
import com.mobvoi.health.companion.heartrate.ui.BodyMindChartWeekMonthView;
import fg.s;
import fg.t;
import fg.u;
import jh.h;
import nf.k;
/* loaded from: classes2.dex */
public class BodyMindDetailActivity extends h implements k<com.mobvoi.health.companion.heartrate.ui.b> {

    /* loaded from: classes2.dex */
    static class a extends jh.a<com.mobvoi.health.companion.heartrate.ui.b> {

        /* renamed from: c  reason: collision with root package name */
        private final BodyMindChartDayView f18297c;

        /* renamed from: d  reason: collision with root package name */
        private final BodyMindChartDayView f18298d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f18299e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f18300f;

        public a(View view) {
            super(view);
            this.f18297c = (BodyMindChartDayView) view.findViewById(s.I0);
            this.f18298d = (BodyMindChartDayView) view.findViewById(s.C0);
            this.f18300f = (TextView) view.findViewById(s.f26757p5);
            this.f18299e = (TextView) view.findViewById(s.q5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(View view) {
            h.p0(view.getContext(), u.B, u.f26935n2, u.O1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void g(View view) {
            h.p0(view.getContext(), u.A, u.f26929m2, u.O1);
        }

        @Override // jh.a
        public void b(int i10) {
            super.b(i10);
            this.f18299e.setOnClickListener(com.mobvoi.health.companion.heartrate.ui.detail.a.f18330a);
            this.f18300f.setOnClickListener(com.mobvoi.health.companion.heartrate.ui.detail.b.f18331a);
        }

        /* renamed from: h */
        public void c(com.mobvoi.health.companion.heartrate.ui.b bVar) {
            if (bVar != null) {
                this.f18297c.d(bVar.f18267b, 1);
                this.f18298d.d(bVar.f18268c, 2);
                return;
            }
            this.f18297c.d(null, 1);
            this.f18298d.d(null, 2);
        }
    }

    /* loaded from: classes2.dex */
    class b extends androidx.viewpager.widget.a {
        b() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(((jh.a) obj).a());
            ((h) BodyMindDetailActivity.this).f29600g.remove(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            if (((h) BodyMindDetailActivity.this).f29607n == 2) {
                return ((h) BodyMindDetailActivity.this).f29598e.size();
            }
            if (((h) BodyMindDetailActivity.this).f29607n == 3) {
                return ((h) BodyMindDetailActivity.this).f29599f.size();
            }
            if (((h) BodyMindDetailActivity.this).f29607n == 1) {
                return ((h) BodyMindDetailActivity.this).f29597d.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            jh.a aVar;
            Context context = viewGroup.getContext();
            if (((h) BodyMindDetailActivity.this).f29607n == 1) {
                aVar = new a(LayoutInflater.from(context).inflate(t.B, viewGroup, false));
            } else {
                aVar = new c(LayoutInflater.from(context).inflate(t.C, viewGroup, false));
            }
            aVar.b(i10);
            viewGroup.addView(aVar.a());
            ((h) BodyMindDetailActivity.this).f29600g.put(i10, aVar);
            return aVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return ((h) BodyMindDetailActivity.this).f29607n == 1 ? (obj instanceof a) && view == ((a) obj).a() : (obj instanceof c) && view == ((c) obj).a();
        }
    }

    /* loaded from: classes2.dex */
    class c extends jh.a<com.mobvoi.health.companion.heartrate.ui.b> {

        /* renamed from: c  reason: collision with root package name */
        private final BodyMindChartWeekMonthView f18302c;

        /* renamed from: d  reason: collision with root package name */
        private final BodyMindChartWeekMonthView f18303d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f18304e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f18305f;

        public c(View view) {
            super(view);
            this.f18302c = (BodyMindChartWeekMonthView) view.findViewById(s.I0);
            this.f18303d = (BodyMindChartWeekMonthView) view.findViewById(s.C0);
            this.f18305f = (TextView) view.findViewById(s.f26757p5);
            this.f18304e = (TextView) view.findViewById(s.q5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void f(View view) {
            h.p0(view.getContext(), u.B, u.f26935n2, u.O1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void g(View view) {
            h.p0(view.getContext(), u.A, u.f26929m2, u.O1);
        }

        @Override // jh.a
        public void b(int i10) {
            super.b(i10);
            this.f18304e.setOnClickListener(d.f18333a);
            this.f18305f.setOnClickListener(com.mobvoi.health.companion.heartrate.ui.detail.c.f18332a);
        }

        /* renamed from: h */
        public void c(com.mobvoi.health.companion.heartrate.ui.b bVar) {
            if (bVar != null) {
                this.f18302c.d(bVar.f18267b, bVar.f27853a, 1, ((h) BodyMindDetailActivity.this).f29607n);
                this.f18303d.d(bVar.f18268c, bVar.f27853a, 2, ((h) BodyMindDetailActivity.this).f29607n);
                return;
            }
            this.f18302c.d(null, System.currentTimeMillis(), 1, ((h) BodyMindDetailActivity.this).f29607n);
            this.f18303d.d(null, System.currentTimeMillis(), 2, ((h) BodyMindDetailActivity.this).f29607n);
        }
    }

    /* renamed from: K0 */
    public void i(nf.h<com.mobvoi.health.companion.heartrate.ui.b> hVar, com.mobvoi.health.companion.heartrate.ui.b bVar) {
        jh.a aVar = this.f29600g.get(U());
        if (aVar != null) {
            aVar.c(bVar);
        }
    }

    @Override // jh.h
    public androidx.viewpager.widget.a V(int i10) {
        return new b();
    }

    @Override // jh.h
    protected String W() {
        return "bodyMind";
    }

    @Override // jh.h
    public void Z() {
        Intent intent = new Intent(this, HealthDetailCalendarActivity.class);
        intent.putExtra("data_type", this.f29616w);
        intent.putExtra("date_mills", X());
        startActivityForResult(intent, 10001);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f29606m.j0().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f29606m.j0().c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "bodyMind");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "bodyMind");
    }
}
