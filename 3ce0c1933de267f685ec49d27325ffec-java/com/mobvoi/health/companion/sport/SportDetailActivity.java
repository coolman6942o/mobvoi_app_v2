package com.mobvoi.health.companion.sport;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bh.e;
import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.health.companion.HealthSportDetailsActivity;
import com.mobvoi.health.companion.McuHealthSportDetailsActivity;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import com.mobvoi.health.companion.sport.SportDetailActivity;
import com.mobvoi.health.companion.sport.view.a;
import com.mobvoi.health.companion.sport.view.b;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import java.util.ArrayList;
import java.util.List;
import jh.h;
import nf.k;
import ug.n;
/* loaded from: classes2.dex */
public class SportDetailActivity extends h implements k<n> {
    private boolean B;
    private com.mobvoi.health.companion.sport.view.b D;
    private Drawable E;
    private Drawable F;
    private boolean G;
    private kg.k H;
    private List<SportType> C = new ArrayList();
    private b.a I = new b.a() { // from class: ug.d
        @Override // com.mobvoi.health.companion.sport.view.b.a
        public final void a(SportType sportType) {
            SportDetailActivity.this.Q0(sportType);
        }
    };

    /* loaded from: classes2.dex */
    class a implements rx.d<lg.a> {
        a() {
        }

        /* renamed from: b */
        public void onNext(lg.a aVar) {
            SportDetailActivity.this.L0(aVar);
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            List<SportType> b10 = e.b(ta.a.d());
            if (b10 != null && b10.size() > 0) {
                SportDetailActivity.this.C.addAll(b10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends BaseQuickAdapter<ug.e, BaseViewHolder> {
        public b(List<ug.e> list) {
            super(t.f26843q, list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(ug.e eVar, View view) {
            Intent intent = new Intent(view.getContext(), SportDetailActivity.this.N0(ig.b.J().h().a(eVar.f35418b)) ? McuHealthSportDetailsActivity.class : HealthSportDetailsActivity.class);
            intent.putExtra("sportId", eVar.f35417a);
            intent.putExtra("type", eVar.f35419c);
            SportDetailActivity.this.startActivityForResult(intent, 101);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public void convert(BaseViewHolder baseViewHolder, final ug.e eVar) {
            String str;
            TextView textView = (TextView) baseViewHolder.getView(s.f26738n0);
            TextView textView2 = (TextView) baseViewHolder.getView(s.S3);
            TextView textView3 = (TextView) baseViewHolder.getView(s.N3);
            TextView textView4 = (TextView) baseViewHolder.getView(s.f26724l0);
            ImageView imageView = (ImageView) baseViewHolder.getView(s.f26658b4);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(s.f26702i);
            SportType sportType = eVar.f35419c;
            if (sportType == SportType.AutoRunning || sportType == SportType.AutoWalking || sportType == SportType.AutoCycling) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(q.f26544a);
                imageView.setBackgroundResource(q.T);
            } else if (sportType == SportType.Gymnastics || sportType == SportType.Spinning) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(q.f26580j);
                imageView.setBackgroundResource(q.U);
            } else {
                imageView2.setVisibility(8);
                imageView.setBackgroundResource(q.U);
            }
            a.C0219a e10 = com.mobvoi.health.companion.sport.view.a.d().e(eVar.f35419c);
            imageView.setImageDrawable(androidx.core.content.b.e(this.mContext, e10.f18992a));
            String string = this.mContext.getString(e10.f18994c);
            String str2 = "";
            if (eVar.b()) {
                SportDataType sportDataType = SportDataType.Calorie;
                str2 = lf.c.d(sportDataType, eVar.f35424h, SportDetailActivity.this.B);
                str = lf.c.a(SportDetailActivity.this.getResources(), SportDetailActivity.this.B, sportDataType);
            } else if (eVar.a()) {
                SportDataType sportDataType2 = SportDataType.HeartRate;
                str2 = lf.c.d(sportDataType2, eVar.f35426j, SportDetailActivity.this.B);
                str = lf.c.a(SportDetailActivity.this.getResources(), SportDetailActivity.this.B, sportDataType2).toLowerCase();
            } else {
                int i10 = eVar.f35425i;
                if (i10 > 0) {
                    SportDataType sportDataType3 = SportDataType.Distance;
                    str2 = lf.c.d(sportDataType3, i10, SportDetailActivity.this.B);
                    str = lf.c.a(SportDetailActivity.this.getResources(), SportDetailActivity.this.B, sportDataType3);
                } else {
                    str = str2;
                }
            }
            textView.setText(SportDetailActivity.this.getString(u.f26967s4, new Object[]{string, str2, str}));
            baseViewHolder.setText(s.Y3, SportDetailActivity.this.getString(u.E2, new Object[]{DateFormat.format("HH:mm", eVar.f35420d).toString(), DateFormat.format("HH:mm", eVar.f35421e).toString()}));
            textView2.setText(lf.c.e(eVar.f35422f, false));
            textView3.setText(lf.c.d(SportDataType.Calorie, eVar.f35424h, SportDetailActivity.this.B));
            textView4.setText(DateFormat.format(SportDetailActivity.this.getString(u.f26973t4), eVar.f35420d).toString());
            baseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.health.companion.sport.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SportDetailActivity.b.this.e(eVar, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c extends jh.a<n> {

        /* renamed from: c  reason: collision with root package name */
        private TextView f18794c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f18795d;

        /* renamed from: e  reason: collision with root package name */
        private TextView f18796e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f18797f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f18798g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f18799h;

        /* renamed from: i  reason: collision with root package name */
        private RecyclerView f18800i;

        /* renamed from: j  reason: collision with root package name */
        private b f18801j;

        public c(View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(s.Z3);
            this.f18794c = (TextView) view.findViewById(s.f26651a4);
            TextView textView2 = (TextView) view.findViewById(s.Q3);
            this.f18795d = (TextView) view.findViewById(s.R3);
            TextView textView3 = (TextView) view.findViewById(s.T3);
            this.f18796e = (TextView) view.findViewById(s.U3);
            TextView textView4 = (TextView) view.findViewById(s.O3);
            this.f18797f = (TextView) view.findViewById(s.P3);
            TextView textView5 = (TextView) view.findViewById(s.V3);
            this.f18798g = (TextView) view.findViewById(s.W3);
            TextView textView6 = (TextView) view.findViewById(s.L3);
            this.f18799h = (TextView) view.findViewById(s.M3);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(s.B2);
            this.f18800i = recyclerView;
            recyclerView.setLayoutManager(new LinearLayoutManager(SportDetailActivity.this));
            b bVar = new b(null);
            this.f18801j = bVar;
            bVar.bindToRecyclerView(this.f18800i);
        }

        @Override // jh.a
        public void b(int i10) {
            super.b(i10);
        }

        /* renamed from: d */
        public void c(n nVar) {
            int i10;
            this.f18801j.setNewData(nVar.f35437b);
            TextView textView = this.f18794c;
            textView.setText(nVar.f35438c + " " + SportDetailActivity.this.getString(u.X4));
            SportDataType sportDataType = SportDataType.Distance;
            String d10 = lf.c.d(sportDataType, (float) nVar.f35440e, SportDetailActivity.this.B);
            String a10 = lf.c.a(SportDetailActivity.this.getResources(), SportDetailActivity.this.B, sportDataType);
            TextView textView2 = this.f18795d;
            textView2.setText(d10 + " " + a10);
            String string = SportDetailActivity.this.getString(u.f26947p2);
            String string2 = SportDetailActivity.this.getString(u.f26953q2);
            int i11 = nVar.f35441f / 60000;
            TextView textView3 = this.f18796e;
            textView3.setText((i11 / 60) + " " + string + " " + (i11 % 60) + " " + string2);
            TextView textView4 = this.f18797f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(lf.c.d(SportDataType.Calorie, (float) nVar.f35439d, SportDetailActivity.this.B));
            sb2.append(" ");
            sb2.append(SportDetailActivity.this.getString(u.f27001y2));
            textView4.setText(sb2.toString());
            TextView textView5 = this.f18798g;
            StringBuilder sb3 = new StringBuilder();
            int i12 = nVar.f35442g;
            sb3.append(i12 > 0 ? lf.c.d(SportDataType.HeartRate, i12, SportDetailActivity.this.B) : "-");
            sb3.append(" ");
            sb3.append(SportDetailActivity.this.getString(u.f26881e2));
            textView5.setText(sb3.toString());
            SportDataType sportDataType2 = SportDataType.Pace;
            int i13 = nVar.f35441f;
            String d11 = lf.c.d(sportDataType2, (i13 <= 0 || (i10 = nVar.f35440e) <= 0) ? 0.0f : (i13 / 1000.0f) / i10, SportDetailActivity.this.B);
            String a11 = lf.c.a(SportDetailActivity.this.getResources(), SportDetailActivity.this.B, sportDataType2);
            TextView textView6 = this.f18799h;
            textView6.setText(d11 + " " + a11);
        }
    }

    /* loaded from: classes2.dex */
    class d extends androidx.viewpager.widget.a {
        d() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(((c) obj).a());
            ((h) SportDetailActivity.this).f29600g.remove(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            if (((h) SportDetailActivity.this).f29607n == 2) {
                return ((h) SportDetailActivity.this).f29598e.size();
            }
            if (((h) SportDetailActivity.this).f29607n == 3) {
                return ((h) SportDetailActivity.this).f29599f.size();
            }
            if (((h) SportDetailActivity.this).f29607n == 1) {
                return ((h) SportDetailActivity.this).f29597d.size();
            }
            return 0;
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            c cVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(t.E, viewGroup, false));
            cVar.b(i10);
            viewGroup.addView(cVar.a());
            ((h) SportDetailActivity.this).f29600g.put(i10, cVar);
            return cVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return (obj instanceof c) && view == ((c) obj).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(lg.a aVar) {
        List<SportType> list;
        if (aVar == null || (list = aVar.motionTypes) == null || list.size() <= 0) {
            List<SportType> b10 = e.b(ta.a.d());
            if (b10 != null && b10.size() > 0) {
                this.C.addAll(b10);
                return;
            }
            return;
        }
        this.C.addAll(aVar.motionTypes);
        e.c(ta.a.d(), JSON.toJSONString(aVar.motionTypes));
    }

    private void M0() {
        this.C.add(0, SportType.Unknown);
        this.f29612s.setOnClickListener(new View.OnClickListener() { // from class: ug.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportDetailActivity.this.P0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean N0(qf.d dVar) {
        if (dVar != null && !dVar.f33137d.contains("GTW")) {
            return "ticLite".equals(dVar.f33138e);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O0() {
        this.f29612s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.F, (Drawable) null);
        com.mobvoi.health.companion.sport.view.b bVar = this.D;
        if (bVar != null) {
            bVar.f(this, 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(View view) {
        this.f29612s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.E, (Drawable) null);
        com.mobvoi.health.companion.sport.view.b bVar = new com.mobvoi.health.companion.sport.view.b(this, this.C, this.f29606m.q0(), this.I);
        this.D = bVar;
        bVar.showAsDropDown(this.f29604k);
        this.D.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: ug.c
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                SportDetailActivity.this.O0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(SportType sportType) {
        if (this.f29606m.q0() != sportType) {
            this.f29612s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.F, (Drawable) null);
            if (sportType == SportType.Unknown) {
                this.f29612s.setText(u.f26884f);
            } else {
                this.f29612s.setText(com.mobvoi.health.companion.sport.view.a.d().e(sportType).f18994c);
            }
            this.f29606m.X0(sportType);
            t0(false);
        }
    }

    public static void R0(Context context, boolean z10) {
        Intent intent = new Intent(context, SportDetailActivity.class);
        intent.putExtra("extra.health_data_type", 6);
        intent.putExtra("extra.START_TIME", eg.c.a(System.currentTimeMillis()).getTimeInMillis());
        intent.putExtra("data_type", 1);
        intent.putExtra("data_for_care", z10);
        context.startActivity(intent);
    }

    /* renamed from: S0 */
    public void i(nf.h<n> hVar, n nVar) {
        jh.a aVar = this.f29600g.get(U());
        if (aVar != null && (aVar instanceof c)) {
            aVar.c(nVar);
            this.f29602i.setRefreshing(false);
        }
    }

    @Override // jh.h
    public androidx.viewpager.widget.a V(int i10) {
        return new d();
    }

    @Override // jh.h
    protected String W() {
        return "fitCenter";
    }

    @Override // jh.h
    public void Z() {
        Intent intent = new Intent(this, HealthDetailCalendarActivity.class);
        intent.putExtra("data_type", this.f29616w);
        intent.putExtra("date_mills", X());
        startActivityForResult(intent, 10001);
    }

    @Override // jh.h, hg.a
    public void n(long j10, long j11) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == 101) {
            this.f29602i.setRefreshing(true);
            t0(false);
        }
        if (i11 == -1 && i10 == 1001) {
            this.C.clear();
            this.C.add(0, SportType.Unknown);
            L0(null);
            this.D.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.B = !com.mobvoi.companion.base.settings.a.isUnitMetric(this);
        this.f29606m.p0().a(this);
        this.F = androidx.core.content.b.e(this, q.f26619s2);
        this.E = androidx.core.content.b.e(this, q.f26623t2);
        int i10 = -1;
        boolean f10 = j7.a.f(j7.a.b(this, 16842801, -1));
        this.F.setTintList(ColorStateList.valueOf(f10 ? -16777216 : -1));
        Drawable drawable = this.E;
        if (f10) {
            i10 = -16777216;
        }
        drawable.setTintList(ColorStateList.valueOf(i10));
        this.f29612s.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.F, (Drawable) null);
        this.f29612s.setText(u.f26884f);
        if (getIntent() != null) {
            boolean booleanExtra = getIntent().getBooleanExtra("data_for_care", false);
            this.G = booleanExtra;
            com.mobvoi.android.common.utils.k.c("SportDetail", "sport show data for tic care dataForCare : %s", Boolean.valueOf(booleanExtra));
        }
        kg.k kVar = new kg.k(this);
        this.H = kVar;
        kVar.j().Z(cq.a.c()).H(xp.a.b()).U(new a());
        M0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f29606m.p0().d();
        com.mobvoi.android.common.utils.k.c("SportDetail", "onDestroy dataForCare : %s", Boolean.valueOf(this.G));
        if (this.G) {
            com.mobvoi.health.companion.system.c.a().j(ta.a.x(), ta.a.d(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "fitCenter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // jh.h, androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "fitCenter");
    }
}
