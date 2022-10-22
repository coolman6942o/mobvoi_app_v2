package com.mobvoi.health.companion.heartrate.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import com.mobvoi.health.companion.heartrate.ui.HeartRateDetailView;
import com.mobvoi.health.companion.heartrate.ui.c;
import fg.s;
import fg.t;
import fg.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import jh.h;
import nf.k;
/* loaded from: classes2.dex */
public class HeartRateDetailActivity extends h implements k<c> {
    private boolean B;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends jh.a<c> {

        /* renamed from: c  reason: collision with root package name */
        private HeartRateDetailView f18312c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f18313d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f18314e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f18315f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f18316g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f18317h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f18318i;

        /* renamed from: j  reason: collision with root package name */
        private TextView f18319j;

        /* renamed from: k  reason: collision with root package name */
        private TextView f18320k;

        /* renamed from: l  reason: collision with root package name */
        private TextView f18321l;

        /* renamed from: m  reason: collision with root package name */
        private TextView f18322m;

        /* renamed from: n  reason: collision with root package name */
        private TextView f18323n;

        /* renamed from: o  reason: collision with root package name */
        private HeartHealthView f18324o;

        /* renamed from: p  reason: collision with root package name */
        private HeartHealthView f18325p;

        /* renamed from: q  reason: collision with root package name */
        private HeartHealthView f18326q;

        /* renamed from: r  reason: collision with root package name */
        private LinearLayout f18327r;

        public a(View view) {
            super(view);
            this.f18312c = (HeartRateDetailView) view.findViewById(s.f26655b1);
            this.f18314e = (TextView) view.findViewById(s.D2);
            this.f18315f = (TextView) view.findViewById(s.E2);
            this.f18313d = (TextView) view.findViewById(s.C2);
            this.f18316g = (TextView) view.findViewById(s.f26798v5);
            this.f18317h = (TextView) view.findViewById(s.f26648a1);
            this.f18318i = (TextView) view.findViewById(s.K1);
            this.f18319j = (TextView) view.findViewById(s.S1);
            this.f18320k = (TextView) view.findViewById(s.L1);
            this.f18321l = (TextView) view.findViewById(s.U1);
            TextView textView = (TextView) view.findViewById(s.P0);
            this.f18322m = (TextView) view.findViewById(s.J1);
            this.f18323n = (TextView) view.findViewById(s.R1);
            this.f18324o = (HeartHealthView) view.findViewById(s.f26695h);
            this.f18325p = (HeartHealthView) view.findViewById(s.f26662c1);
            this.f18326q = (HeartHealthView) view.findViewById(s.f26788u2);
            this.f18327r = (LinearLayout) view.findViewById(s.Z0);
        }

        @Override // jh.a
        public void b(int i10) {
            super.b(i10);
        }

        /* JADX WARN: Removed duplicated region for block: B:65:0x0183  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0211  */
        /* JADX WARN: Removed duplicated region for block: B:87:0x0217  */
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(c cVar) {
            boolean z10;
            boolean i10;
            Map<Integer, List<rh.a>> map;
            List<c.b> list;
            this.f18312c.e(cVar, ((h) HeartRateDetailActivity.this).f29607n);
            this.f18316g.setVisibility(8);
            String str = "";
            String str2 = "-";
            if (cVar != null) {
                if (HeartRateDetailActivity.this.B) {
                    this.f18313d.setText(u.P3);
                    TextView textView = this.f18314e;
                    int i11 = cVar.f18273c.f18284f;
                    textView.setText(i11 > 0 ? String.valueOf(i11) : str2);
                    this.f18315f.setVisibility(cVar.f18273c.f18284f > 0 ? 0 : 8);
                } else {
                    this.f18313d.setText(u.O3);
                    TextView textView2 = this.f18314e;
                    int i12 = cVar.f18273c.f18283e;
                    textView2.setText(i12 > 0 ? String.valueOf(i12) : str2);
                    this.f18315f.setVisibility(cVar.f18273c.f18283e > 0 ? 0 : 8);
                }
                String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(cVar.f18273c.f18279a));
                if (((h) HeartRateDetailActivity.this).f29607n == 1 && this.f29587b == ((h) HeartRateDetailActivity.this).f29606m.s().size() - 1 && (list = cVar.f18272b) != null && list.size() > 0 && cVar.f18273c.f18279a > 0) {
                    this.f18316g.setVisibility(0);
                    this.f18316g.setText(HeartRateDetailActivity.this.getString(u.f26966s3, new Object[]{format}));
                }
                TextView textView3 = this.f18318i;
                float f10 = cVar.f18273c.f18280b;
                textView3.setText(f10 > 0.0f ? String.valueOf(Math.round(f10)) : str2);
                this.f18322m.setVisibility(cVar.f18273c.f18280b > 0.0f ? 0 : 4);
                this.f18322m.setText(cVar.f18273c.f18280b > 0.0f ? HeartRateDetailActivity.this.getString(u.f26881e2) : str);
                TextView textView4 = this.f18319j;
                float f11 = cVar.f18273c.f18281c;
                if (f11 > 0.0f) {
                    str2 = String.valueOf(Math.round(f11));
                }
                textView4.setText(str2);
                this.f18323n.setVisibility(cVar.f18273c.f18281c > 0.0f ? 0 : 4);
                TextView textView5 = this.f18323n;
                if (cVar.f18273c.f18281c > 0.0f) {
                    str = HeartRateDetailActivity.this.getString(u.f26881e2);
                }
                textView5.setText(str);
                this.f18320k.setText(String.valueOf(Math.round(cVar.f18273c.f18286h)));
                this.f18321l.setText(String.valueOf(Math.round(cVar.f18273c.f18285g)));
                if (((h) HeartRateDetailActivity.this).f29607n == 1) {
                    c.a aVar = cVar.f18273c;
                    if (aVar.f18285g + aVar.f18286h > 3) {
                        z10 = true;
                        this.f18317h.setVisibility(!z10 ? 0 : 8);
                        i10 = of.h.b().i(HeartRateDetailActivity.this);
                        map = cVar.f18274d;
                        if (map != null || map.size() == 0) {
                            if (!i10) {
                                this.f18327r.setVisibility(0);
                            } else {
                                this.f18327r.setVisibility(8);
                            }
                            this.f18325p.setVisibility(8);
                            this.f18324o.setVisibility(8);
                            this.f18326q.setVisibility(8);
                            return;
                        }
                        this.f18327r.setVisibility(8);
                        if (i10) {
                            ArrayList arrayList = new ArrayList();
                            for (Map.Entry<Integer, List<rh.a>> entry : cVar.f18274d.entrySet()) {
                                int intValue = entry.getKey().intValue();
                                if (intValue == 1) {
                                    this.f18324o.d(1, ((h) HeartRateDetailActivity.this).f29607n, entry.getValue());
                                } else if (intValue == 2 || intValue == 3) {
                                    arrayList.addAll(entry.getValue());
                                } else if (intValue == 4) {
                                    this.f18326q.d(4, ((h) HeartRateDetailActivity.this).f29607n, entry.getValue());
                                }
                            }
                            this.f18325p.d(2, ((h) HeartRateDetailActivity.this).f29607n, arrayList);
                            return;
                        }
                        return;
                    }
                }
                z10 = false;
                this.f18317h.setVisibility(!z10 ? 0 : 8);
                i10 = of.h.b().i(HeartRateDetailActivity.this);
                map = cVar.f18274d;
                if (map != null) {
                }
                if (!i10) {
                }
                this.f18325p.setVisibility(8);
                this.f18324o.setVisibility(8);
                this.f18326q.setVisibility(8);
                return;
            }
            this.f18318i.setText(str2);
            this.f18322m.setVisibility(4);
            this.f18319j.setText(str2);
            this.f18323n.setVisibility(4);
            this.f18322m.setText(str);
            this.f18323n.setText(str);
            this.f18315f.setVisibility(8);
        }
    }

    /* loaded from: classes2.dex */
    class b extends androidx.viewpager.widget.a {
        b() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(((a) obj).a());
            ((h) HeartRateDetailActivity.this).f29600g.remove(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            if (((h) HeartRateDetailActivity.this).f29607n == 2) {
                return ((h) HeartRateDetailActivity.this).f29598e.size();
            }
            if (((h) HeartRateDetailActivity.this).f29607n == 3) {
                return ((h) HeartRateDetailActivity.this).f29599f.size();
            }
            if (((h) HeartRateDetailActivity.this).f29607n == 1) {
                return ((h) HeartRateDetailActivity.this).f29597d.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(t.f26852z, viewGroup, false));
            aVar.b(i10);
            viewGroup.addView(aVar.a());
            ((h) HeartRateDetailActivity.this).f29600g.put(i10, aVar);
            return aVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return (obj instanceof a) && view == ((a) obj).a();
        }
    }

    public static void M0(Context context, boolean z10) {
        Intent intent = new Intent(context, HeartRateDetailActivity.class);
        intent.putExtra("extra.health_data_type", z10 ? 9 : 1);
        intent.putExtra("extra.START_TIME", eg.c.a(System.currentTimeMillis()).getTimeInMillis());
        intent.putExtra("data_type", 1);
        intent.putExtra("data_has_lite_watch", z10);
        context.startActivity(intent);
    }

    /* renamed from: N0 */
    public void i(nf.h<c> hVar, c cVar) {
        jh.a aVar = this.f29600g.get(U());
        if (aVar != null && (aVar instanceof a)) {
            aVar.c(cVar);
        }
    }

    @Override // jh.h
    public androidx.viewpager.widget.a V(int i10) {
        return new b();
    }

    @Override // jh.h
    protected String W() {
        return "hrCenter";
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
        this.B = getIntent().getBooleanExtra("data_has_lite_watch", false);
        this.f29606m.k0().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f29606m.k0().d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "hrCenter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "hrCenter");
    }
}
