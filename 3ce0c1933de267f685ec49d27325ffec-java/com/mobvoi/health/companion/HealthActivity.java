package com.mobvoi.health.companion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.health.common.ui.view.HistogramView;
import com.mobvoi.health.companion.HealthActivity;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import com.mobvoi.health.companion.exercise.ExerciseDetailView;
import com.mobvoi.health.companion.model.ShareExerciseBean;
import com.mobvoi.health.companion.provider.Recorder;
import com.mobvoi.health.companion.ui.DatePicker;
import com.mobvoi.health.core.data.pojo.DataType;
import com.mobvoi.wear.util.UnitsUtility;
import fg.g;
import fg.i;
import fg.o;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kh.n;
import kh.w;
import nf.h;
import nf.j;
import nf.k;
import nf.m;
/* loaded from: classes2.dex */
public class HealthActivity extends com.mobvoi.companion.base.m3.a implements DatePicker.e, DatePicker.f, ViewPager.j, k<n.a>, hg.a {
    private static final long L = TimeUnit.DAYS.toMillis(7);
    private DatePicker A;
    private DatePicker B;
    private SparseArray<oh.a> C;
    private boolean D;
    private ShareExerciseBean E;

    /* renamed from: a  reason: collision with root package name */
    private TextView f18070a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f18071b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18072c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18073d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f18074e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f18075f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f18076g;

    /* renamed from: h  reason: collision with root package name */
    private List<String> f18077h;

    /* renamed from: i  reason: collision with root package name */
    private DatePicker f18078i;

    /* renamed from: j  reason: collision with root package name */
    private ViewPager f18079j;

    /* renamed from: k  reason: collision with root package name */
    private SwipeRefreshLayout f18080k;

    /* renamed from: m  reason: collision with root package name */
    private n f18082m;

    /* renamed from: s  reason: collision with root package name */
    private long f18088s;

    /* renamed from: u  reason: collision with root package name */
    private View f18090u;

    /* renamed from: y  reason: collision with root package name */
    private ImageView f18094y;

    /* renamed from: z  reason: collision with root package name */
    private DatePicker f18095z;

    /* renamed from: l  reason: collision with root package name */
    private final m f18081l = new m();

    /* renamed from: n  reason: collision with root package name */
    private int f18083n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f18084o = -1;

    /* renamed from: p  reason: collision with root package name */
    private int f18085p = -1;

    /* renamed from: q  reason: collision with root package name */
    private int f18086q = -1;

    /* renamed from: r  reason: collision with root package name */
    private int f18087r = -1;

    /* renamed from: t  reason: collision with root package name */
    private int f18089t = 0;

    /* renamed from: v  reason: collision with root package name */
    private SparseArray<e> f18091v = new SparseArray<>();

    /* renamed from: w  reason: collision with root package name */
    private SparseArray<c> f18092w = new SparseArray<>();

    /* renamed from: x  reason: collision with root package name */
    private SparseArray<c> f18093x = new SparseArray<>();
    private int F = 10000;
    private int G = 30;
    private int H = 10;
    private boolean I = false;
    private final View.OnClickListener J = new b();
    private int[] K = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    /* loaded from: classes2.dex */
    class a extends y9.a {
        a(int i10) {
            super(i10);
        }

        @Override // y9.a
        public void a(View view) {
            HealthActivity.this.v0();
        }
    }

    /* loaded from: classes2.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Context context = view.getContext();
            int id2 = view.getId();
            if (id2 == s.V1) {
                sb.a.e(context, "healthMonth", "healthCenter");
                HealthActivity.this.B0(3, false);
            } else if (id2 == s.A5) {
                sb.a.e(context, "healthWeek", "healthCenter");
                HealthActivity.this.B0(2, false);
            } else if (id2 == s.f26731m0) {
                sb.a.e(context, "healthDay", "healthCenter");
                HealthActivity.this.B0(1, false);
            } else if (id2 == s.f26820z) {
                HealthActivity.this.finish();
            } else if (id2 == s.f26700h4) {
                sb.a.d(context, "healthStepHelp");
                new g(HealthActivity.this, 0).show();
            } else if (id2 == s.f26680e5) {
                sb.a.d(context, "healthExerciseHelp");
                new g(HealthActivity.this, 1).show();
            } else if (id2 == s.f26682f0) {
                sb.a.d(context, "healthActiveHelp");
                new g(HealthActivity.this, 2).show();
            } else if (id2 == s.f26701h5) {
                sb.a.e(context, "healthToday", "healthCenter");
                HealthActivity.this.t0();
            } else if (s.N == id2) {
                sb.a.e(context, "healthCal", "healthCenter");
                Intent intent = new Intent(HealthActivity.this, HealthDetailCalendarActivity.class);
                intent.putExtra("data_type", 7);
                intent.putExtra("date_mills", HealthActivity.this.i0());
                HealthActivity.this.startActivityForResult(intent, 10001);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        private int f18098a;

        /* renamed from: b  reason: collision with root package name */
        View f18099b;

        /* renamed from: c  reason: collision with root package name */
        TextView f18100c;

        /* renamed from: d  reason: collision with root package name */
        TextView f18101d;

        /* renamed from: e  reason: collision with root package name */
        ExerciseDetailView f18102e;

        /* renamed from: f  reason: collision with root package name */
        TextView f18103f;

        /* renamed from: g  reason: collision with root package name */
        TextView f18104g;

        /* renamed from: h  reason: collision with root package name */
        ExerciseDetailView f18105h;

        /* renamed from: i  reason: collision with root package name */
        TextView f18106i;

        /* renamed from: j  reason: collision with root package name */
        TextView f18107j;

        /* renamed from: k  reason: collision with root package name */
        ExerciseDetailView f18108k;

        /* renamed from: l  reason: collision with root package name */
        View f18109l;

        /* renamed from: m  reason: collision with root package name */
        View f18110m;

        c(View view, int i10) {
            this.f18098a = i10;
            this.f18099b = view;
            this.f18100c = (TextView) view.findViewById(s.f26672d4);
            this.f18102e = (ExerciseDetailView) view.findViewById(s.f26665c4);
            this.f18103f = (TextView) view.findViewById(s.f26652a5);
            this.f18105h = (ExerciseDetailView) view.findViewById(s.W4);
            this.f18106i = (TextView) view.findViewById(s.f26654b0);
            this.f18108k = (ExerciseDetailView) view.findViewById(s.f26647a0);
            TextView textView = (TextView) view.findViewById(s.f26679e4);
            TextView textView2 = (TextView) view.findViewById(s.f26659b5);
            TextView textView3 = (TextView) view.findViewById(s.f26689g0);
            this.f18101d = (TextView) view.findViewById(s.f26686f4);
            this.f18104g = (TextView) view.findViewById(s.f26666c5);
            this.f18107j = (TextView) view.findViewById(s.f26668d0);
            ((TextView) view.findViewById(s.f26700h4)).setOnClickListener(HealthActivity.this.J);
            ((TextView) view.findViewById(s.f26680e5)).setOnClickListener(HealthActivity.this.J);
            ((TextView) view.findViewById(s.f26682f0)).setOnClickListener(HealthActivity.this.J);
            view.findViewById(s.f26693g4);
            this.f18109l = view.findViewById(s.f26673d5);
            this.f18110m = view.findViewById(s.f26675e0);
            this.f18109l.setVisibility(0);
            this.f18110m.setVisibility(0);
        }

        public View a() {
            return this.f18099b;
        }

        public void b(int i10) {
            int i11;
            mg.a aVar = new mg.a(HealthActivity.this.F, HealthActivity.this.G, HealthActivity.this.H);
            if (this.f18098a == 3) {
                HealthActivity.this.f18082m.X(HealthActivity.this.C, aVar, i10);
                i11 = HealthActivity.this.h0(aVar.f30774a);
            } else {
                HealthActivity.this.f18082m.Y(HealthActivity.this.C, aVar, i10);
                i11 = 7;
            }
            this.f18100c.setText(String.valueOf(aVar.f30782i));
            this.f18103f.setText(String.valueOf(aVar.f30783j));
            this.f18106i.setText(String.valueOf(aVar.f30784k));
            this.f18102e.d(aVar.f30776c, HealthActivity.this.F, aVar.f30779f, aVar.f30774a);
            this.f18105h.d(aVar.f30777d, HealthActivity.this.G, aVar.f30780g, aVar.f30774a);
            this.f18108k.d(aVar.f30778e, HealthActivity.this.H, aVar.f30781h, aVar.f30774a);
            TextView textView = this.f18101d;
            textView.setText(aVar.f30787n + "/" + i11);
            TextView textView2 = this.f18104g;
            textView2.setText(aVar.f30788o + "/" + i11);
            TextView textView3 = this.f18107j;
            textView3.setText(aVar.f30789p + "/" + i11);
        }

        public void c(int i10) {
            b(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d extends androidx.viewpager.widget.a {

        /* renamed from: c  reason: collision with root package name */
        private int f18112c;

        public d(int i10) {
            this.f18112c = i10;
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(((c) obj).a());
            if (this.f18112c == 3) {
                HealthActivity.this.f18093x.remove(i10);
            } else {
                HealthActivity.this.f18092w.remove(i10);
            }
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return this.f18112c == 3 ? HealthActivity.this.f18077h.size() : HealthActivity.this.f18076g.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            c cVar = new c(LayoutInflater.from(viewGroup.getContext()).inflate(this.f18112c == 3 ? t.A : t.M, viewGroup, false), this.f18112c);
            HealthActivity.this.f18093x.put(i10, cVar);
            if (this.f18112c == 3) {
                HealthActivity.this.f18093x.put(i10, cVar);
            } else {
                HealthActivity.this.f18092w.put(i10, cVar);
            }
            cVar.b(i10);
            viewGroup.addView(cVar.a());
            return cVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return (obj instanceof c) && view == ((c) obj).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        View f18114a;

        /* renamed from: b  reason: collision with root package name */
        TextView f18115b;

        /* renamed from: c  reason: collision with root package name */
        TextView f18116c;

        /* renamed from: d  reason: collision with root package name */
        TextView f18117d;

        /* renamed from: e  reason: collision with root package name */
        ExerciseDetailView f18118e;

        /* renamed from: f  reason: collision with root package name */
        TextView f18119f;

        /* renamed from: g  reason: collision with root package name */
        TextView f18120g;

        /* renamed from: h  reason: collision with root package name */
        TextView f18121h;

        /* renamed from: i  reason: collision with root package name */
        ExerciseDetailView f18122i;

        /* renamed from: j  reason: collision with root package name */
        TextView f18123j;

        /* renamed from: k  reason: collision with root package name */
        TextView f18124k;

        /* renamed from: l  reason: collision with root package name */
        TextView f18125l;

        /* renamed from: m  reason: collision with root package name */
        TextView f18126m;

        /* renamed from: n  reason: collision with root package name */
        TextView f18127n;

        /* renamed from: o  reason: collision with root package name */
        HistogramView f18128o;

        /* renamed from: p  reason: collision with root package name */
        View f18129p;

        /* renamed from: q  reason: collision with root package name */
        View f18130q;

        e(View view) {
            this.f18114a = view;
            this.f18115b = (TextView) view.findViewById(s.f26672d4);
            TextView textView = (TextView) view.findViewById(s.f26679e4);
            this.f18117d = (TextView) view.findViewById(s.f26686f4);
            this.f18118e = (ExerciseDetailView) view.findViewById(s.f26665c4);
            this.f18119f = (TextView) view.findViewById(s.f26652a5);
            this.f18120g = (TextView) view.findViewById(s.f26666c5);
            this.f18122i = (ExerciseDetailView) view.findViewById(s.W4);
            this.f18123j = (TextView) view.findViewById(s.f26654b0);
            this.f18124k = (TextView) view.findViewById(s.f26668d0);
            this.f18128o = (HistogramView) view.findViewById(s.f26647a0);
            TextView textView2 = (TextView) view.findViewById(s.D0);
            TextView textView3 = (TextView) view.findViewById(s.E0);
            this.f18121h = (TextView) view.findViewById(s.F0);
            TextView textView4 = (TextView) view.findViewById(s.f26646a);
            TextView textView5 = (TextView) view.findViewById(s.f26653b);
            this.f18125l = (TextView) view.findViewById(s.f26660c);
            TextView textView6 = (TextView) view.findViewById(s.f26707i4);
            TextView textView7 = (TextView) view.findViewById(s.f26714j4);
            this.f18116c = (TextView) view.findViewById(s.f26721k4);
            TextView textView8 = (TextView) view.findViewById(s.f26772s0);
            TextView textView9 = (TextView) view.findViewById(s.f26779t0);
            this.f18126m = (TextView) view.findViewById(s.f26786u0);
            this.f18127n = (TextView) view.findViewById(s.S);
            TextView textView10 = (TextView) view.findViewById(s.R);
            TextView textView11 = (TextView) view.findViewById(s.Q);
            if (HealthActivity.this.D) {
                textView9.setText(u.f26869c2);
            } else {
                textView9.setText(u.f26875d2);
            }
            ((TextView) view.findViewById(s.f26700h4)).setOnClickListener(HealthActivity.this.J);
            ((TextView) view.findViewById(s.f26680e5)).setOnClickListener(HealthActivity.this.J);
            ((TextView) view.findViewById(s.f26682f0)).setOnClickListener(HealthActivity.this.J);
            TextView textView12 = (TextView) view.findViewById(s.f26659b5);
            TextView textView13 = (TextView) view.findViewById(s.f26661c0);
            view.findViewById(s.f26693g4);
            this.f18129p = view.findViewById(s.f26673d5);
            this.f18130q = view.findViewById(s.f26675e0);
            this.f18129p.setVisibility(0);
            this.f18130q.setVisibility(0);
        }

        private void c(HistogramView histogramView, List<Recorder.Item> list) {
            if (list != null && list.size() > 0) {
                List<HistogramView.b> items = histogramView.getItems();
                for (HistogramView.b bVar : items) {
                    bVar.f18012a = 0.0f;
                }
                for (Recorder.Item item : list) {
                    items.get(item.time).f18012a = 1.0f;
                }
                histogramView.invalidate();
            }
        }

        private void d(int i10, HistogramView histogramView) {
            int color = histogramView.getContext().getResources().getColor(i10);
            HistogramView.d drawStyle = histogramView.getDrawStyle();
            drawStyle.f18025g = color;
            drawStyle.f18028j = cg.a.a(color, 0.3f);
            histogramView.j();
        }

        private void f(int i10) {
            int i11;
            float f10;
            int i12;
            int i13;
            int i14;
            int i15;
            float f11;
            oh.a R;
            mg.a aVar = new mg.a();
            if (i10 <= 0 || (R = HealthActivity.this.f18082m.R(HealthActivity.this.C, i10)) == null) {
                f10 = 0.0f;
                i15 = 0;
                i14 = 0;
                i13 = 0;
                i12 = 0;
                i11 = 0;
            } else {
                i15 = R.e(DataType.Step);
                i14 = R.e(DataType.Exercise);
                i13 = ph.a.b(i14);
                i12 = R.e(DataType.Active);
                f10 = R.e(DataType.Distance);
                i11 = R.e(DataType.Calorie);
                HealthActivity.this.f18082m.S(R, aVar);
            }
            if (HealthActivity.this.D) {
                f11 = UnitsUtility.Length.m2mile(f10);
            } else {
                f11 = UnitsUtility.Length.m2km(f10);
            }
            this.f18126m.setText(String.format(HealthActivity.this.getString(u.f26968t), Float.valueOf(f11)));
            this.f18127n.setText(String.valueOf(i11));
            this.f18116c.setText(String.valueOf(i15));
            this.f18121h.setText(String.valueOf(i13));
            this.f18125l.setText(String.valueOf(i12));
            this.f18115b.setText(i15 + "/" + HealthActivity.this.F);
            this.f18119f.setText(i13 + "/" + HealthActivity.this.G);
            this.f18123j.setText(i12 + "/" + HealthActivity.this.H);
            String string = HealthActivity.this.getResources().getString(u.f26877d4);
            String valueOf = String.valueOf(eg.b.b(i15, HealthActivity.this.F));
            this.f18117d.setText(valueOf + string);
            String valueOf2 = String.valueOf(eg.b.b(i12, HealthActivity.this.H));
            this.f18124k.setText(valueOf2 + string);
            String valueOf3 = String.valueOf(eg.b.b(i14, HealthActivity.this.G * 60));
            this.f18120g.setText(valueOf3 + string);
            this.f18118e.d(aVar.f30776c, HealthActivity.this.F, aVar.f30779f, aVar.f30774a);
            this.f18122i.d(aVar.f30777d, HealthActivity.this.G, aVar.f30780g, aVar.f30774a);
            c(this.f18128o, aVar.f30778e);
        }

        public View a() {
            return this.f18114a;
        }

        @SuppressLint({"SetTextI18n"})
        public void b(int i10) {
            HistogramView.d drawStyle = this.f18128o.getDrawStyle();
            drawStyle.f18023e = new float[]{4.0f, 1.0f};
            drawStyle.f18024f = 0.16f;
            List<HistogramView.b> a10 = com.mobvoi.health.common.ui.view.a.a(24);
            if (!a10.isEmpty()) {
                a10.get(0).f18014c = "1";
            }
            this.f18128o.setProgress(a10);
            d(o.f26454e, this.f18128o);
            f(i10);
        }

        public void e(int i10) {
            b(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class f extends androidx.viewpager.widget.a {
        f() {
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(((e) obj).a());
            HealthActivity.this.f18091v.remove(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return HealthActivity.this.f18075f.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            e eVar = new e(LayoutInflater.from(viewGroup.getContext()).inflate(t.f26836j, viewGroup, false));
            HealthActivity.this.f18091v.put(i10, eVar);
            eVar.b(i10);
            viewGroup.addView(eVar.a());
            return eVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return (obj instanceof e) && view == ((e) obj).a();
        }
    }

    private void A0() {
        boolean z10 = true;
        if (this.f18090u == null) {
            int currentItem = this.f18079j.getCurrentItem();
            int i10 = this.f18084o;
            if (i10 == 1) {
                e eVar = this.f18091v.get(currentItem);
                if (eVar != null) {
                    this.f18090u = eVar.a();
                }
            } else if (i10 == 2) {
                c cVar = this.f18092w.get(currentItem);
                if (cVar != null) {
                    this.f18090u = cVar.a();
                }
            } else {
                c cVar2 = this.f18093x.get(currentItem);
                if (cVar2 != null) {
                    this.f18090u = cVar2.a();
                }
            }
        }
        View view = this.f18090u;
        if (view == null || view.canScrollVertically(-1) || this.f18089t != 0) {
            z10 = false;
        }
        this.f18080k.setEnabled(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(int i10, boolean z10) {
        if (this.f18084o != i10) {
            this.f18084o = i10;
            q0();
            s0(i10);
            if (i10 == 1) {
                e0();
                DatePicker datePicker = this.f18095z;
                this.f18078i = datePicker;
                datePicker.setVisibility(0);
                this.A.setVisibility(8);
                this.B.setVisibility(8);
                this.f18095z.setWrapSelectorWheel(false);
                this.f18095z.setIndecseNumber(7);
                this.f18095z.setMinValue(0);
                this.f18095z.setMaxValue(this.f18075f.size() - 1);
                this.f18095z.setDisplayedValues((String[]) this.f18075f.toArray(new String[0]));
                this.f18095z.setValue(this.f18085p);
                this.f18079j.setAdapter(new f());
                this.f18079j.setCurrentItem(this.f18085p);
                this.f18075f.size();
            } else if (i10 == 2) {
                C0();
                this.f18078i = this.A;
                this.f18095z.setVisibility(8);
                this.A.setVisibility(0);
                this.B.setVisibility(8);
                this.A.setWrapSelectorWheel(false);
                this.A.setIndecseNumber(3);
                this.A.setMinValue(0);
                this.A.setMaxValue(this.f18076g.size() - 1);
                this.A.setDisplayedValues((String[]) this.f18076g.toArray(new String[0]));
                this.A.setValue(this.f18086q);
                this.f18079j.setAdapter(new d(i10));
                this.f18079j.setCurrentItem(this.f18086q);
                this.f18076g.size();
            } else if (i10 == 3) {
                n0();
                this.f18078i = this.B;
                this.f18095z.setVisibility(8);
                this.A.setVisibility(8);
                this.B.setVisibility(0);
                this.B.setWrapSelectorWheel(false);
                this.B.setIndecseNumber(7);
                this.B.setMinValue(0);
                this.B.setMaxValue(this.f18077h.size() - 1);
                this.B.setDisplayedValues((String[]) this.f18077h.toArray(new String[0]));
                this.B.setValue(this.f18087r);
                this.f18079j.setAdapter(new d(i10));
                this.f18079j.setCurrentItem(this.f18087r);
                this.f18077h.size();
            }
            if (z10) {
                l.a().postDelayed(new Runnable() { // from class: fg.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        HealthActivity.this.m0();
                    }
                }, 200L);
            } else {
                z0(false);
            }
        }
    }

    private void C0() {
        List<w.d> y10 = this.f18082m.y();
        List<String> list = this.f18076g;
        if (list != null) {
            list.clear();
        } else {
            this.f18076g = new ArrayList();
        }
        StringBuilder sb2 = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd", Locale.getDefault());
        for (int i10 = 0; i10 < y10.size(); i10++) {
            w.d dVar = y10.get(i10);
            calendar.setTimeInMillis(dVar.f29973a);
            sb2.append(simpleDateFormat.format(calendar.getTime()));
            sb2.append("-");
            calendar.setTimeInMillis(dVar.f29974b);
            sb2.append(simpleDateFormat.format(calendar.getTime()));
            this.f18076g.add(sb2.toString());
            sb2.setLength(0);
        }
    }

    private void c0(int i10) {
        int i11 = this.f18084o;
        if (i11 == 1) {
            this.f18085p = i10;
        } else if (i11 == 2) {
            this.f18086q = i10;
        } else if (i11 == 3) {
            this.f18087r = i10;
        }
    }

    private void d0(int i10) {
        this.f18085p = this.f18082m.s().size() - 1;
        this.f18086q = this.f18082m.y().size() - 1;
        this.f18087r = this.f18082m.v().size() - 1;
        com.mobvoi.android.common.utils.k.c("HealthActivity", "changeIndex default dayIndex : %s, weekIndex : %s, monthIndex : %s", Integer.valueOf(this.f18085p), Integer.valueOf(this.f18086q), Integer.valueOf(this.f18087r));
        if (this.f18088s >= 0) {
            if (i10 == 1) {
                List<Long> s10 = this.f18082m.s();
                for (int size = (s10 == null ? 0 : s10.size()) - 1; size >= 0; size--) {
                    if (s10.get(size).longValue() == this.f18088s) {
                        this.f18085p = size;
                    }
                }
            } else if (i10 == 2) {
                List<w.d> y10 = this.f18082m.y();
                int size2 = y10 == null ? 0 : y10.size();
                long millis = TimeUnit.DAYS.toMillis(7L);
                int i11 = size2 - 1;
                while (true) {
                    if (i11 < 0) {
                        break;
                    }
                    long j10 = this.f18088s;
                    long j11 = y10.get(i11).f29973a;
                    if (j10 >= j11 && j10 < j11 + millis) {
                        this.f18086q = i11;
                        break;
                    }
                    i11--;
                }
            } else if (i10 == 3) {
                List<Long> v10 = this.f18082m.v();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.f18088s);
                long timeInMillis = eg.c.o(calendar).getTimeInMillis();
                Calendar calendar2 = Calendar.getInstance();
                int size3 = (v10 == null ? 0 : v10.size()) - 1;
                while (true) {
                    if (size3 < 0) {
                        break;
                    }
                    calendar2.setTimeInMillis(v10.get(size3).longValue());
                    if (eg.c.o(calendar2).getTimeInMillis() == timeInMillis) {
                        this.f18087r = size3;
                        break;
                    }
                    size3--;
                }
            }
            com.mobvoi.android.common.utils.k.c("HealthActivity", "changeIndex after parsing dayIndex : %s, weekIndex : %s, monthIndex : %s", Integer.valueOf(this.f18085p), Integer.valueOf(this.f18086q), Integer.valueOf(this.f18087r));
        }
    }

    private void e0() {
        List<String> list = this.f18075f;
        if (list != null) {
            list.clear();
        }
        this.f18075f = new ArrayList();
        List<Long> s10 = this.f18082m.s();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s10.get(0).longValue());
        int i10 = calendar.get(2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM", Locale.getDefault());
        String[] stringArray = getResources().getStringArray(fg.m.f26442d);
        for (int i11 = 0; i11 < s10.size(); i11++) {
            calendar.setTimeInMillis(s10.get(i11).longValue());
            int i12 = 7;
            int i13 = calendar.get(7) - 1;
            if (i13 != 0) {
                i12 = i13;
            }
            String str = stringArray[i12 - 1];
            if (i10 != calendar.get(2)) {
                i10 = calendar.get(2);
                this.f18075f.add(simpleDateFormat.format(calendar.getTime()) + "," + str);
            } else {
                this.f18075f.add(calendar.get(5) + "," + str);
            }
        }
    }

    private int g0() {
        int i10 = this.f18084o;
        if (i10 == 1) {
            return this.f18085p;
        }
        if (i10 == 2) {
            return this.f18086q;
        }
        if (i10 != 3) {
            return -1;
        }
        return this.f18087r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0() {
        z0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(Object obj) {
        p0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0() {
        z0(false);
    }

    private void n0() {
        List<String> list = this.f18077h;
        if (list != null) {
            list.clear();
        }
        this.f18077h = new ArrayList();
        List<Long> v10 = this.f18082m.v();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(v10.get(0).longValue());
        int i10 = calendar.get(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM", Locale.getDefault());
        for (int i11 = 0; i11 < v10.size(); i11++) {
            calendar.setTimeInMillis(v10.get(i11).longValue());
            if (i10 != calendar.get(1)) {
                i10 = calendar.get(1);
                this.f18077h.add(String.valueOf(i10));
            } else {
                this.f18077h.add(simpleDateFormat.format(calendar.getTime()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(SparseArray<oh.a> sparseArray) {
        this.f18080k.setRefreshing(false);
        this.C = sparseArray;
        int g02 = g0();
        if (g02 >= 0) {
            int i10 = this.f18084o;
            if (i10 == 1) {
                e eVar = this.f18091v.get(g02);
                if (eVar != null) {
                    eVar.e(g02);
                }
            } else if (i10 == 2) {
                c cVar = this.f18092w.get(g02);
                if (cVar != null) {
                    cVar.c(g02);
                }
            } else {
                c cVar2 = this.f18093x.get(g02);
                if (cVar2 != null) {
                    cVar2.c(g02);
                }
            }
        }
    }

    private void p0() {
        this.f18080k.setRefreshing(false);
    }

    private void q0() {
    }

    private void r0(int i10, int i11) {
        if (i10 == 0 && i11 != this.f18079j.getCurrentItem()) {
            this.f18079j.R(i11, false);
        }
    }

    private void s0(int i10) {
        int color = getResources().getColor(o.f26462i);
        int color2 = getResources().getColor(o.f26491w0);
        this.f18072c.setTextColor(color);
        this.f18070a.setTextColor(color);
        this.f18071b.setTextColor(color);
        this.f18072c.setBackground(null);
        this.f18070a.setBackground(null);
        this.f18071b.setBackground(null);
        if (i10 == 1) {
            this.f18072c.setTextColor(color2);
            this.f18072c.setBackgroundResource(q.V);
        } else if (i10 == 2) {
            this.f18071b.setTextColor(color2);
            this.f18071b.setBackgroundResource(q.V);
        } else if (i10 == 3) {
            this.f18070a.setTextColor(color2);
            this.f18070a.setBackgroundResource(q.V);
        }
    }

    public static void start(Context context) {
        w0(context, 1, eg.c.a(System.currentTimeMillis()).getTimeInMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        int i10;
        int i11;
        int i12 = this.f18084o;
        if (i12 == 1) {
            i11 = this.f18075f.size();
        } else if (i12 == 2) {
            i11 = this.f18076g.size();
        } else if (i12 != 3) {
            i10 = 0;
            this.f18078i.setValue(i10);
            c0(i10);
            r0(this.f18083n, g0());
            z0(false);
            this.f18094y.setVisibility(8);
        } else {
            i11 = this.f18077h.size();
        }
        i10 = i11 - 1;
        this.f18078i.setValue(i10);
        c0(i10);
        r0(this.f18083n, g0());
        z0(false);
        this.f18094y.setVisibility(8);
    }

    private void u0(int i10) {
        int i11 = this.f18084o;
        if (i11 == 1) {
            this.f18075f.size();
        } else if (i11 == 2) {
            this.f18076g.size();
        } else if (i11 == 3) {
            this.f18077h.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.E = null;
        if (this.f18084o == 1) {
            int i10 = this.f18085p;
            if (i10 >= 0) {
                oh.a R = this.f18082m.R(this.C, i10);
                ShareExerciseBean shareExerciseBean = new ShareExerciseBean();
                this.E = shareExerciseBean;
                shareExerciseBean.dateType = 1;
                shareExerciseBean.stepGoal = this.F;
                if (R != null) {
                    mg.a aVar = new mg.a();
                    this.E.step = R.e(DataType.Step);
                    this.E.distance = R.e(DataType.Distance);
                    this.E.calorie = R.e(DataType.Calorie);
                    this.f18082m.S(R, aVar);
                    ShareExerciseBean shareExerciseBean2 = this.E;
                    shareExerciseBean2.stepMax = aVar.f30779f;
                    shareExerciseBean2.stepList = aVar.f30776c;
                    shareExerciseBean2.startMills = aVar.f30774a;
                } else {
                    shareExerciseBean.startMills = this.f18082m.W(this.f18085p);
                }
            } else {
                return;
            }
        } else {
            mg.a aVar2 = new mg.a(this.F, this.G, this.H);
            ShareExerciseBean shareExerciseBean3 = new ShareExerciseBean();
            this.E = shareExerciseBean3;
            int i11 = this.f18084o;
            if (i11 == 3) {
                int i12 = this.f18087r;
                if (i12 >= 0) {
                    shareExerciseBean3.dateType = 3;
                    this.f18082m.X(this.C, aVar2, i12);
                } else {
                    return;
                }
            } else if (i11 == 2) {
                int i13 = this.f18086q;
                if (i13 >= 0) {
                    shareExerciseBean3.dateType = 2;
                    this.f18082m.Y(this.C, aVar2, i13);
                } else {
                    return;
                }
            }
            ShareExerciseBean shareExerciseBean4 = this.E;
            shareExerciseBean4.step = aVar2.f30782i;
            shareExerciseBean4.calorie = aVar2.f30785l;
            shareExerciseBean4.distance = aVar2.f30786m;
            shareExerciseBean4.startMills = aVar2.f30774a;
            shareExerciseBean4.endMills = aVar2.f30775b - 1;
            shareExerciseBean4.stepGoal = this.F;
            shareExerciseBean4.stepMax = aVar2.f30779f;
            shareExerciseBean4.stepList = aVar2.f30776c;
        }
        if (this.E != null) {
            Intent intent = new Intent("com.mobvoi.companion.action.HEALTH_SHARE");
            intent.setPackage(getPackageName());
            intent.putExtra("share_info", this.E);
            startActivity(intent);
        }
    }

    public static void w0(Context context, int i10, long j10) {
        Intent intent = new Intent(context, HealthActivity.class);
        intent.putExtra("data_type", i10);
        intent.putExtra("extra.START_TIME", j10);
        context.startActivity(intent);
    }

    public static void x0(Context context, String str, long j10) {
        int i10 = 1;
        if (!String.valueOf(1).equals(str)) {
            if (String.valueOf(2).equals(str)) {
                i10 = 2;
            } else if (String.valueOf(3).equals(str)) {
                i10 = 3;
            }
        }
        w0(context, i10, j10);
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void c(int i10, float f10, int i11) {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        A0();
        return super.dispatchTouchEvent(motionEvent);
    }

    protected void f0(long j10) {
        if (this.f18082m != null) {
            long millis = j10 + TimeUnit.DAYS.toMillis(1L);
            this.f18082m.p(millis - L, millis);
        }
    }

    @Override // com.mobvoi.health.companion.ui.DatePicker.f
    public void g(DatePicker datePicker, int i10, int i11) {
        c0(i11);
        r0(this.f18083n, g0());
        u0(i11);
        z0(false);
    }

    public int h0(long j10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        int i10 = calendar.get(1);
        int i11 = calendar.get(2);
        if ((i10 % 4 == 0 && i10 % 100 != 0) || i10 % AGCServerException.AUTHENTICATION_INVALID == 0) {
            this.K[1] = 29;
        }
        return this.K[i11];
    }

    protected long i0() {
        long W = this.f18082m.W(this.f18085p);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(W);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    protected void j0(long j10) {
        List<Long> s10 = this.f18082m.s();
        int size = s10 == null ? 0 : s10.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            } else if (s10.get(i10).longValue() == j10) {
                this.f18085p = i10;
                break;
            } else {
                i10++;
            }
        }
        List<w.d> y10 = this.f18082m.y();
        int size2 = y10 == null ? 0 : y10.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size2) {
                break;
            }
            w.d dVar = y10.get(i11);
            if (j10 >= dVar.f29973a && j10 < dVar.f29974b) {
                this.f18086q = i11;
                break;
            }
            i11++;
        }
        List<Long> v10 = this.f18082m.v();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        long timeInMillis = eg.c.o(calendar).getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance();
        int size3 = (v10 == null ? 0 : v10.size()) - 1;
        while (true) {
            if (size3 < 0) {
                break;
            }
            calendar2.setTimeInMillis(v10.get(size3).longValue());
            if (eg.c.o(calendar2).getTimeInMillis() == timeInMillis) {
                this.f18087r = size3;
                break;
            }
            size3--;
        }
        if (this.f18084o != 1) {
            B0(1, false);
            return;
        }
        this.f18078i.setValue(this.f18085p);
        r0(this.f18083n, this.f18085p);
        u0(this.f18085p);
        z0(false);
    }

    @Override // com.mobvoi.health.companion.ui.DatePicker.e
    public void k(DatePicker datePicker, int i10) {
        this.f18083n = i10;
        r0(i10, g0());
    }

    @Override // hg.a
    public void n(long j10, long j11) {
        String string = getString(u.f26920l);
        int i10 = this.f18084o;
        if (i10 == 2) {
            string = getString(u.f26914k);
        } else if (i10 == 3) {
            string = getString(u.f26908j);
        }
        this.f18073d.setText(new SimpleDateFormat(string, Locale.getDefault()).format(new Date(j10)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && intent != null) {
            j0(intent.getLongExtra("monthDate", -1L));
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f26827a);
        this.f18094y = (ImageView) findViewById(s.f26701h5);
        ImageView imageView = (ImageView) findViewById(s.H2);
        this.f18074e = imageView;
        imageView.setOnClickListener(new a(1));
        this.f18094y.setOnClickListener(this.J);
        findViewById(s.N).setOnClickListener(this.J);
        n nVar = new n();
        this.f18082m = nVar;
        nVar.c0(this);
        findViewById(s.f26820z).setOnClickListener(this.J);
        this.f18073d = (TextView) findViewById(s.V);
        this.f18071b = (TextView) findViewById(s.A5);
        this.f18070a = (TextView) findViewById(s.V1);
        this.f18072c = (TextView) findViewById(s.f26731m0);
        this.f18095z = (DatePicker) findViewById(s.f26703i0);
        this.A = (DatePicker) findViewById(s.f26717k0);
        this.B = (DatePicker) findViewById(s.f26710j0);
        this.f18071b.setOnClickListener(this.J);
        this.f18070a.setOnClickListener(this.J);
        this.f18072c.setOnClickListener(this.J);
        this.f18095z.setOnScrollListener(this);
        this.f18095z.setOnValueChangedListener(this);
        this.A.setOnScrollListener(this);
        this.A.setOnValueChangedListener(this);
        this.B.setOnScrollListener(this);
        this.B.setOnValueChangedListener(this);
        this.D = "imperial".equals(com.mobvoi.companion.base.settings.a.getUnit(this));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(s.J4);
        this.f18080k = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: fg.a
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void y() {
                HealthActivity.this.k0();
            }
        });
        this.f18081l.a(j.b(this.f18082m.x(), new j.a() { // from class: fg.d
            @Override // nf.j.a
            public final void call(Object obj) {
                HealthActivity.this.l0(obj);
            }
        }));
        this.f18081l.a(j.b(this.f18082m.r(), new j.a() { // from class: fg.c
            @Override // nf.j.a
            public final void call(Object obj) {
                HealthActivity.this.o0((SparseArray) obj);
            }
        }));
        this.f18082m.b0();
        this.f18082m.T().a(this);
        ViewPager viewPager = (ViewPager) findViewById(s.f26805w5);
        this.f18079j = viewPager;
        viewPager.c(this);
        this.f18079j.setOffscreenPageLimit(1);
        Intent intent = getIntent();
        this.f18088s = intent.getLongExtra("extra.START_TIME", -1L);
        int intExtra = intent.getIntExtra("data_type", 1);
        com.mobvoi.android.common.utils.k.c("HealthActivity", "get start dateType : %s ", Integer.valueOf(intExtra));
        d0(intExtra);
        B0(intExtra, true);
        long b10 = eg.c.b(System.currentTimeMillis());
        long a10 = i.a(this, "health_fetch_time");
        if (a10 < 0 || a10 + L < b10) {
            this.f18080k.setRefreshing(true);
            f0(b10);
            i.b(this, "health_fetch_time", b10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f18081l.clear();
        n nVar = this.f18082m;
        if (nVar != null) {
            nVar.d();
            this.f18082m.T().d();
        }
        this.f18079j.N(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "healthCenter");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "healthCenter");
        fg.f.b(this);
        if (this.I) {
            z0(false);
        } else {
            this.I = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f18082m.b();
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void u(int i10) {
        this.f18089t = i10;
        A0();
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void v(int i10) {
        int g02 = g0();
        if (g02 != i10 && g02 >= 0) {
            if (i10 > g02) {
                this.f18078i.b(true);
            } else {
                this.f18078i.b(false);
            }
        }
        int i11 = this.f18084o;
        if (i11 == 1) {
            e eVar = this.f18091v.get(i10);
            if (eVar != null) {
                this.f18090u = eVar.a();
            }
        } else if (i11 == 2) {
            c cVar = this.f18092w.get(i10);
            if (cVar != null) {
                this.f18090u = cVar.a();
            }
        } else {
            c cVar2 = this.f18093x.get(i10);
            if (cVar2 != null) {
                this.f18090u = cVar2.a();
            }
        }
    }

    /* renamed from: y0 */
    public void i(h<n.a> hVar, n.a aVar) {
        this.F = aVar.f29936a;
        this.G = aVar.f29937b;
        this.H = aVar.f29938c;
        int g02 = g0();
        if (g02 >= 0) {
            int i10 = this.f18084o;
            if (i10 == 1) {
                e eVar = this.f18091v.get(g02);
                if (eVar != null) {
                    eVar.e(g02);
                }
            } else if (i10 == 2) {
                c cVar = this.f18092w.get(g02);
                if (cVar != null) {
                    cVar.c(g02);
                }
            } else {
                c cVar2 = this.f18093x.get(g02);
                if (cVar2 != null) {
                    cVar2.c(g02);
                }
            }
        }
    }

    protected void z0(boolean z10) {
        int i10;
        int i11 = this.f18084o;
        if (i11 == 1) {
            int i12 = this.f18085p;
            if (i12 >= 0) {
                this.f18082m.d0(i12, z10);
            }
        } else if (i11 == 2) {
            int i13 = this.f18086q;
            if (i13 >= 0) {
                this.f18082m.f0(i13, z10);
            }
        } else if (i11 == 3 && (i10 = this.f18087r) >= 0) {
            this.f18082m.e0(i10, z10);
        }
    }
}
