package com.mobvoi.health.companion.temperature;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import fg.s;
import fg.t;
import fg.u;
import java.util.List;
import jh.h;
import nf.k;
/* loaded from: classes2.dex */
public class TemperatureDetailActivity extends h implements k<ih.b> {

    /* loaded from: classes2.dex */
    class a extends androidx.viewpager.widget.a {
        a() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(((b) obj).a());
            ((h) TemperatureDetailActivity.this).f29600g.remove(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            if (((h) TemperatureDetailActivity.this).f29607n == 2) {
                return ((h) TemperatureDetailActivity.this).f29598e.size();
            }
            if (((h) TemperatureDetailActivity.this).f29607n == 3) {
                return ((h) TemperatureDetailActivity.this).f29599f.size();
            }
            if (((h) TemperatureDetailActivity.this).f29607n == 1) {
                return ((h) TemperatureDetailActivity.this).f29597d.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(t.L, viewGroup, false));
            bVar.b(i10);
            viewGroup.addView(bVar.a());
            ((h) TemperatureDetailActivity.this).f29600g.put(i10, bVar);
            return bVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return (obj instanceof b) && view == ((b) obj).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends jh.a<ih.b> {

        /* renamed from: c  reason: collision with root package name */
        private TemperatureDayChartView f19047c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f19048d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f19049e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f19050f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f19051g;

        public b(View view) {
            super(view);
            this.f19047c = (TemperatureDayChartView) view.findViewById(s.Q4);
            this.f19048d = (TextView) view.findViewById(s.N1);
            this.f19049e = (TextView) view.findViewById(s.O1);
            this.f19050f = (TextView) view.findViewById(s.O4);
            this.f19051g = (TextView) view.findViewById(s.P4);
            String str = "celsius".equals(com.mobvoi.companion.base.settings.a.getTempUnit(com.mobvoi.android.common.utils.b.e())) ? "°C" : "°F";
            this.f19051g.setText(str);
            this.f19048d.setText(str);
        }

        @Override // jh.a
        public void b(int i10) {
            super.b(i10);
        }

        /* renamed from: d */
        public void c(ih.b bVar) {
            this.f19047c.setDate(bVar);
            TextView textView = this.f19049e;
            float f10 = bVar.f28275d;
            String str = "-";
            textView.setText(f10 > 0.0f ? TemperatureDetailActivity.this.getString(u.S4, new Object[]{Float.valueOf(f10)}) : str);
            List<ih.a> list = bVar.f28279h;
            if (list != null && list.size() > 0) {
                List<ih.a> list2 = bVar.f28279h;
                TextView textView2 = this.f19050f;
                float f11 = list2.get(list2.size() - 1).f28272b;
                if (f11 > 0.0f) {
                    str = TemperatureDetailActivity.this.getString(u.S4, new Object[]{Float.valueOf(f11)});
                }
                textView2.setText(str);
            }
        }
    }

    /* renamed from: E0 */
    public void i(nf.h<ih.b> hVar, ih.b bVar) {
        jh.a aVar = this.f29600g.get(U());
        if (aVar != null && (aVar instanceof b)) {
            aVar.c(bVar);
        }
    }

    @Override // jh.h
    public androidx.viewpager.widget.a V(int i10) {
        return new a();
    }

    @Override // jh.h
    protected String W() {
        return "tempCenter";
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
        findViewById(s.K4).setVisibility(8);
        this.f29606m.r0().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f29606m.r0().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "tempCenter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "tempCenter");
    }
}
