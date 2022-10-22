package com.mobvoi.health.companion.noise;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import com.mobvoi.health.companion.noise.a;
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
public class NoiseDetailActivity extends h implements k<com.mobvoi.health.companion.noise.a> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends jh.a<com.mobvoi.health.companion.noise.a> {

        /* renamed from: c  reason: collision with root package name */
        private NoiseDetailView f18334c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f18335d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f18336e;

        public a(View view) {
            super(view);
            this.f18334c = (NoiseDetailView) view.findViewById(s.X1);
            this.f18335d = (TextView) view.findViewById(s.Y1);
            this.f18336e = (TextView) view.findViewById(s.f26798v5);
            TextView textView = (TextView) view.findViewById(s.f26684f2);
            TextView textView2 = (TextView) view.findViewById(s.N0);
            TextView textView3 = (TextView) view.findViewById(s.f26677e2);
            TextView textView4 = (TextView) view.findViewById(s.f26670d2);
            TextView textView5 = (TextView) view.findViewById(s.f26663c2);
            TextView textView6 = (TextView) view.findViewById(s.f26656b2);
            TextView textView7 = (TextView) view.findViewById(s.f26649a2);
            TextView textView8 = (TextView) view.findViewById(s.Z1);
        }

        @Override // jh.a
        public void b(int i10) {
            super.b(i10);
        }

        /* renamed from: d */
        public void c(com.mobvoi.health.companion.noise.a aVar) {
            List<a.b> list;
            this.f18334c.d(aVar, ((h) NoiseDetailActivity.this).f29607n);
            this.f18336e.setVisibility(8);
            if (aVar != null) {
                TextView textView = this.f18335d;
                textView.setText(Math.round(aVar.f18365c.f18368c) + " - " + Math.round(aVar.f18365c.f18367b));
                String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(aVar.f18365c.f18366a));
                if (((h) NoiseDetailActivity.this).f29607n == 1 && this.f29587b == ((h) NoiseDetailActivity.this).f29606m.s().size() - 1 && (list = aVar.f18364b) != null && list.size() > 0 && aVar.f18365c.f18366a > 0) {
                    this.f18336e.setVisibility(0);
                    this.f18336e.setText(NoiseDetailActivity.this.getString(u.f26966s3, new Object[]{format}));
                }
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
            ((h) NoiseDetailActivity.this).f29600g.remove(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            if (((h) NoiseDetailActivity.this).f29607n == 2) {
                return ((h) NoiseDetailActivity.this).f29598e.size();
            }
            if (((h) NoiseDetailActivity.this).f29607n == 3) {
                return ((h) NoiseDetailActivity.this).f29599f.size();
            }
            if (((h) NoiseDetailActivity.this).f29607n == 1) {
                return ((h) NoiseDetailActivity.this).f29597d.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(t.f26839m, viewGroup, false));
            aVar.b(i10);
            viewGroup.addView(aVar.a());
            ((h) NoiseDetailActivity.this).f29600g.put(i10, aVar);
            return aVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return (obj instanceof a) && view == ((a) obj).a();
        }
    }

    /* renamed from: H0 */
    public void i(nf.h<com.mobvoi.health.companion.noise.a> hVar, com.mobvoi.health.companion.noise.a aVar) {
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
        return "noiseCenter";
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
        this.f29606m.m0().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f29606m.m0().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "noiseCenter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "noiseCenter");
    }
}
