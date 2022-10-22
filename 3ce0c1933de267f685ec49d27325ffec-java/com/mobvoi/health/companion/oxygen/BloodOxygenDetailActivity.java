package com.mobvoi.health.companion.oxygen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import com.mobvoi.health.companion.oxygen.a;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import jh.h;
import nf.k;
/* loaded from: classes2.dex */
public class BloodOxygenDetailActivity extends h implements k<com.mobvoi.health.companion.oxygen.a> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends jh.a<com.mobvoi.health.companion.oxygen.a> {

        /* renamed from: c  reason: collision with root package name */
        private BloodOxygenDetailView f18376c;

        /* renamed from: d  reason: collision with root package name */
        private final TextView f18377d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f18378e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f18379f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f18380g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f18381h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f18382i;

        /* renamed from: j  reason: collision with root package name */
        private ImageView f18383j;

        /* renamed from: k  reason: collision with root package name */
        private TextView f18384k;

        /* renamed from: l  reason: collision with root package name */
        private TextView f18385l;

        /* renamed from: m  reason: collision with root package name */
        private TextView f18386m;

        public a(View view) {
            super(view);
            this.f18376c = (BloodOxygenDetailView) view.findViewById(s.B);
            this.f18377d = (TextView) view.findViewById(s.f26785u);
            this.f18378e = (TextView) view.findViewById(s.f26792v);
            this.f18383j = (ImageView) view.findViewById(s.G);
            this.f18379f = (TextView) view.findViewById(s.f26798v5);
            this.f18380g = (TextView) view.findViewById(s.H1);
            this.f18381h = (TextView) view.findViewById(s.Q1);
            this.f18382i = (TextView) view.findViewById(s.E1);
            this.f18384k = (TextView) view.findViewById(s.F1);
            this.f18385l = (TextView) view.findViewById(s.P1);
            this.f18386m = (TextView) view.findViewById(s.I1);
            TextView textView = (TextView) view.findViewById(s.A);
        }

        @Override // jh.a
        public void b(int i10) {
            super.b(i10);
        }

        /* renamed from: d */
        public void c(com.mobvoi.health.companion.oxygen.a aVar) {
            List<a.b> list;
            this.f18376c.d(aVar, ((h) BloodOxygenDetailActivity.this).f29607n);
            int i10 = 8;
            this.f18379f.setVisibility(8);
            String str = "";
            String str2 = "-";
            if (aVar != null) {
                this.f18383j.setVisibility(0);
                float f10 = aVar.f18416c.f18422f;
                boolean z10 = f10 > 0.0f;
                this.f18377d.setText(z10 ? String.valueOf(Math.round(f10)) : str2);
                TextView textView = this.f18378e;
                if (z10) {
                    i10 = 0;
                }
                textView.setVisibility(i10);
                this.f18383j.setImageResource(aVar.f18416c.f18422f < 85.0f ? q.O : q.P);
                String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(aVar.f18416c.f18417a));
                if (((h) BloodOxygenDetailActivity.this).f29607n == 1 && this.f29587b == ((h) BloodOxygenDetailActivity.this).f29606m.s().size() - 1 && (list = aVar.f18415b) != null && list.size() > 0 && aVar.f18416c.f18417a > 0) {
                    this.f18379f.setVisibility(0);
                    this.f18379f.setText(BloodOxygenDetailActivity.this.getString(u.f26966s3, new Object[]{format}));
                }
                TextView textView2 = this.f18380g;
                float f11 = aVar.f18416c.f18420d;
                textView2.setText(f11 > 0.0f ? String.valueOf(Math.round(f11)) : str2);
                TextView textView3 = this.f18381h;
                float f12 = aVar.f18416c.f18421e;
                if (f12 > 0.0f) {
                    str2 = String.valueOf(Math.round(f12));
                }
                textView3.setText(str2);
                this.f18382i.setText(String.valueOf(aVar.f18416c.f18423g));
                this.f18384k.setText(aVar.f18416c.f18423g > 0 ? BloodOxygenDetailActivity.this.getString(u.X4) : str);
                this.f18385l.setText(aVar.f18416c.f18421e > 0.0f ? BloodOxygenDetailActivity.this.getString(u.f26877d4) : str);
                TextView textView4 = this.f18386m;
                if (aVar.f18416c.f18420d > 0.0f) {
                    str = BloodOxygenDetailActivity.this.getString(u.f26877d4);
                }
                textView4.setText(str);
                return;
            }
            this.f18383j.setVisibility(8);
            this.f18378e.setVisibility(8);
            this.f18380g.setText(str2);
            this.f18381h.setText(str2);
            this.f18382i.setText(str2);
            this.f18384k.setText(str);
            this.f18385l.setText(str);
            this.f18386m.setText(str);
        }
    }

    /* loaded from: classes2.dex */
    class b extends androidx.viewpager.widget.a {
        b() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(((a) obj).a());
            ((h) BloodOxygenDetailActivity.this).f29600g.remove(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            if (((h) BloodOxygenDetailActivity.this).f29607n == 2) {
                return ((h) BloodOxygenDetailActivity.this).f29598e.size();
            }
            if (((h) BloodOxygenDetailActivity.this).f29607n == 3) {
                return ((h) BloodOxygenDetailActivity.this).f29599f.size();
            }
            if (((h) BloodOxygenDetailActivity.this).f29607n == 1) {
                return ((h) BloodOxygenDetailActivity.this).f29597d.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(t.f26835i, viewGroup, false));
            aVar.b(i10);
            viewGroup.addView(aVar.a());
            ((h) BloodOxygenDetailActivity.this).f29600g.put(i10, aVar);
            return aVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return (obj instanceof a) && view == ((a) obj).a();
        }
    }

    /* renamed from: H0 */
    public void i(nf.h<com.mobvoi.health.companion.oxygen.a> hVar, com.mobvoi.health.companion.oxygen.a aVar) {
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
        return "boCenter";
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
        this.f29606m.i0().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f29606m.i0().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "boCenter");
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z10) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "boCenter");
    }
}
