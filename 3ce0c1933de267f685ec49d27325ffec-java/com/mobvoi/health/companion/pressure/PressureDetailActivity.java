package com.mobvoi.health.companion.pressure;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import com.mobvoi.health.companion.pressure.a;
import fg.s;
import fg.t;
import fg.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import jh.h;
import nf.k;
/* loaded from: classes2.dex */
public class PressureDetailActivity extends h implements k<com.mobvoi.health.companion.pressure.a> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends jh.a<com.mobvoi.health.companion.pressure.a> {

        /* renamed from: c  reason: collision with root package name */
        private PressureDetailView f18428c;

        /* renamed from: d  reason: collision with root package name */
        private PressureLevelPercentBar f18429d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f18430e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f18431f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f18432g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f18433h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f18434i;

        /* renamed from: j  reason: collision with root package name */
        private TextView f18435j;

        /* renamed from: k  reason: collision with root package name */
        private TextView f18436k;

        /* renamed from: l  reason: collision with root package name */
        private TextView f18437l;

        public a(View view) {
            super(view);
            this.f18428c = (PressureDetailView) view.findViewById(s.f26795v2);
            this.f18429d = (PressureLevelPercentBar) view.findViewById(s.f26823z2);
            this.f18430e = (TextView) view.findViewById(s.f26785u);
            this.f18431f = (TextView) view.findViewById(s.f26798v5);
            this.f18432g = (TextView) view.findViewById(s.M1);
            this.f18433h = (TextView) view.findViewById(s.T1);
            TextView textView = (TextView) view.findViewById(s.f26728l4);
            TextView textView2 = (TextView) view.findViewById(s.f26735m4);
            this.f18434i = (TextView) view.findViewById(s.A2);
            this.f18435j = (TextView) view.findViewById(s.f26809x2);
            this.f18436k = (TextView) view.findViewById(s.f26816y2);
            this.f18437l = (TextView) view.findViewById(s.f26802w2);
        }

        @Override // jh.a
        public void b(int i10) {
            super.b(i10);
        }

        /* renamed from: d */
        public void c(com.mobvoi.health.companion.pressure.a aVar) {
            List<a.b> list;
            this.f18428c.d(aVar, ((h) PressureDetailActivity.this).f29607n);
            this.f18431f.setVisibility(8);
            if (aVar != null) {
                this.f18430e.setText(String.valueOf(Math.round(aVar.f18474c.f18478d)));
                String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(aVar.f18474c.f18475a));
                if (((h) PressureDetailActivity.this).f29607n == 1 && this.f29587b == ((h) PressureDetailActivity.this).f29606m.s().size() - 1 && (list = aVar.f18473b) != null && list.size() > 0 && aVar.f18474c.f18475a > 0) {
                    this.f18431f.setVisibility(0);
                    this.f18431f.setText(PressureDetailActivity.this.getString(u.f26966s3, new Object[]{format}));
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(new rg.a(aVar.f18474c.f18479e, PressureRateLevel.RELAX));
                arrayList.add(new rg.a(aVar.f18474c.f18480f, PressureRateLevel.LOW));
                arrayList.add(new rg.a(aVar.f18474c.f18481g, PressureRateLevel.MEDIUM));
                arrayList.add(new rg.a(aVar.f18474c.f18482h, PressureRateLevel.HIGH));
                this.f18429d.setPercents(arrayList);
                this.f18432g.setText(String.valueOf(Math.round(aVar.f18474c.f18476b)));
                this.f18433h.setText(String.valueOf(Math.round(aVar.f18474c.f18477c)));
                TextView textView = this.f18434i;
                textView.setText(aVar.f18474c.f18479e + "%");
                TextView textView2 = this.f18435j;
                textView2.setText(aVar.f18474c.f18480f + "%");
                TextView textView3 = this.f18436k;
                textView3.setText(aVar.f18474c.f18481g + "%");
                TextView textView4 = this.f18437l;
                textView4.setText(aVar.f18474c.f18482h + "%");
            }
        }
    }

    /* loaded from: classes2.dex */
    class b extends androidx.viewpager.widget.a {
        b() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(((a) obj).a());
            ((h) PressureDetailActivity.this).f29600g.remove(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            if (((h) PressureDetailActivity.this).f29607n == 2) {
                return ((h) PressureDetailActivity.this).f29598e.size();
            }
            if (((h) PressureDetailActivity.this).f29607n == 3) {
                return ((h) PressureDetailActivity.this).f29599f.size();
            }
            if (((h) PressureDetailActivity.this).f29607n == 1) {
                return ((h) PressureDetailActivity.this).f29597d.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(t.D, viewGroup, false));
            aVar.b(i10);
            viewGroup.addView(aVar.a());
            ((h) PressureDetailActivity.this).f29600g.put(i10, aVar);
            return aVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return (obj instanceof a) && view == ((a) obj).a();
        }
    }

    /* renamed from: H0 */
    public void i(nf.h<com.mobvoi.health.companion.pressure.a> hVar, com.mobvoi.health.companion.pressure.a aVar) {
        jh.a aVar2 = this.f29600g.get(U());
        if (aVar2 != null && (aVar2 instanceof a)) {
            aVar2.c(aVar);
        }
    }

    @Override // jh.h
    public androidx.viewpager.widget.a V(int i10) {
        return new b();
    }

    @Override // jh.h
    protected String W() {
        return "pressureCenter";
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
        this.f29606m.n0().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f29606m.n0().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "pressureCenter");
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "pressureCenter");
    }
}
