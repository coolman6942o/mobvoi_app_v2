package com.mobvoi.health.companion.base;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.health.companion.base.HealthDetailCalendarActivity;
import com.mobvoi.health.companion.sport.view.DetailCalendarView;
import com.mobvoi.health.companion.ui.DatePicker;
import eg.c;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import nf.h;
import nf.j;
import nf.k;
import nf.m;
/* loaded from: classes2.dex */
public class HealthDetailCalendarActivity extends com.mobvoi.companion.base.m3.a implements DatePicker.e, DatePicker.f, ViewPager.j, View.OnClickListener, k<List<Integer>> {

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f18133a;

    /* renamed from: b  reason: collision with root package name */
    private DatePicker f18134b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f18135c;

    /* renamed from: e  reason: collision with root package name */
    private int f18137e;

    /* renamed from: g  reason: collision with root package name */
    private int f18139g;

    /* renamed from: h  reason: collision with root package name */
    private long f18140h;

    /* renamed from: j  reason: collision with root package name */
    private SwipeRefreshLayout f18142j;

    /* renamed from: k  reason: collision with root package name */
    private kh.k f18143k;

    /* renamed from: d  reason: collision with root package name */
    private List<Date> f18136d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private int f18138f = -1;

    /* renamed from: i  reason: collision with root package name */
    protected SparseArray<b> f18141i = new SparseArray<>();

    /* renamed from: l  reason: collision with root package name */
    protected final m f18144l = new m();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends androidx.viewpager.widget.a {

        /* renamed from: c  reason: collision with root package name */
        private List<Date> f18145c;

        public a(List<Date> list) {
            this.f18145c = list;
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            viewGroup.removeView(((b) obj).c());
            HealthDetailCalendarActivity.this.f18141i.remove(i10);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            List<Date> list = this.f18145c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(t.f26837k, viewGroup, false));
            bVar.d(i10);
            viewGroup.addView(bVar.c());
            HealthDetailCalendarActivity.this.f18141i.put(i10, bVar);
            return bVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return view == ((b) obj).c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        protected View f18147a;

        /* renamed from: b  reason: collision with root package name */
        private DetailCalendarView f18148b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f18149c;

        /* renamed from: d  reason: collision with root package name */
        private ImageView f18150d;

        /* renamed from: e  reason: collision with root package name */
        private RelativeLayout f18151e;

        public b(View view) {
            this.f18147a = view;
            this.f18148b = (DetailCalendarView) view.findViewById(s.M);
            this.f18150d = (ImageView) view.findViewById(s.M0);
            this.f18149c = (TextView) view.findViewById(s.f26708i5);
            this.f18151e = (RelativeLayout) view.findViewById(s.F2);
            if (HealthDetailCalendarActivity.this.f18139g == 11) {
                this.f18151e.setVisibility(8);
            } else {
                this.f18151e.setVisibility(0);
            }
            if (HealthDetailCalendarActivity.this.f18139g == 4) {
                this.f18150d.setImageResource(q.f26607p2);
            } else {
                this.f18150d.setImageResource(q.f26584k);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(View view) {
            Intent intent = new Intent();
            intent.putExtra("monthDate", c.a(System.currentTimeMillis()).getTimeInMillis());
            HealthDetailCalendarActivity.this.setResult(-1, intent);
            HealthDetailCalendarActivity.this.finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Date date, Date date2, Date date3) {
            if (date3 != null) {
                Intent intent = new Intent();
                intent.putExtra("monthDate", date3.getTime());
                HealthDetailCalendarActivity.this.setResult(-1, intent);
            }
            HealthDetailCalendarActivity.this.finish();
        }

        public View c() {
            return this.f18147a;
        }

        public void d(int i10) {
            Date date = (Date) HealthDetailCalendarActivity.this.f18136d.get(i10);
            DetailCalendarView detailCalendarView = this.f18148b;
            int i11 = HealthDetailCalendarActivity.this.f18139g;
            boolean z10 = true;
            if (i10 != HealthDetailCalendarActivity.this.f18136d.size() - 1) {
                z10 = false;
            }
            detailCalendarView.p(date, i11, z10);
            this.f18149c.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.health.companion.base.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HealthDetailCalendarActivity.b.this.e(view);
                }
            });
            this.f18148b.setOnItemClickListener(new DetailCalendarView.a() { // from class: com.mobvoi.health.companion.base.b
                @Override // com.mobvoi.health.companion.sport.view.DetailCalendarView.a
                public final void a(Date date2, Date date3, Date date4) {
                    HealthDetailCalendarActivity.b.this.f(date2, date3, date4);
                }
            });
        }

        public void g(List<Integer> list) {
            this.f18148b.setSportDates(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(Object obj) {
        S();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        W(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O() {
        W(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q() {
        this.f18142j.setRefreshing(false);
        W(false);
    }

    private void S() {
        l.a().postDelayed(new Runnable() { // from class: hg.c
            @Override // java.lang.Runnable
            public final void run() {
                HealthDetailCalendarActivity.this.Q();
            }
        }, 1000L);
    }

    private void T(int i10, int i11) {
        if (i10 == 0 && i11 != this.f18133a.getCurrentItem() && i11 != -1) {
            this.f18133a.R(i11, false);
        }
    }

    private void U() {
        Calendar a10 = bh.b.a();
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        this.f18136d.clear();
        while (a10.getTimeInMillis() <= timeInMillis) {
            this.f18136d.add(a10.getTime());
            a10.add(2, 1);
        }
        int size = this.f18136d.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < this.f18136d.size(); i10++) {
            Date date = this.f18136d.get(i10);
            date.getTime();
            strArr[i10] = DateFormat.format(getString(u.f26902i), date).toString();
        }
        this.f18134b.setDisplayedValues(strArr);
        this.f18134b.setMinValue(0);
        int i11 = size - 1;
        this.f18134b.setMaxValue(i11);
        this.f18134b.setValue(i11);
        this.f18133a.setAdapter(new a(this.f18136d));
        this.f18133a.setOffscreenPageLimit(1);
        this.f18133a.setCurrentItem(this.f18136d.size() - 1);
        this.f18138f = this.f18136d.size() - 1;
    }

    private void init() {
        this.f18134b.setOnScrollListener(this);
        this.f18134b.setOnValueChangedListener(this);
        this.f18134b.setWrapSelectorWheel(false);
        this.f18133a.c(this);
        this.f18135c.setOnClickListener(this);
    }

    /* renamed from: V */
    public void i(h<List<Integer>> hVar, List<Integer> list) {
        this.f18142j.setRefreshing(false);
        b bVar = this.f18141i.get(this.f18138f);
        if (bVar != null) {
            bVar.g(list);
        }
    }

    protected void W(boolean z10) {
        if (this.f18143k != null && this.f18138f > 0) {
            int size = this.f18136d.size();
            int i10 = this.f18138f;
            if (size > i10) {
                Date date = this.f18136d.get(i10);
                long time = bh.b.c(date).getTime();
                long time2 = bh.b.b(date).getTime();
                if (z10) {
                    this.f18143k.p(time, time2);
                } else {
                    this.f18143k.J(time, time2);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void c(int i10, float f10, int i11) {
    }

    @Override // com.mobvoi.health.companion.ui.DatePicker.f
    public void g(DatePicker datePicker, int i10, int i11) {
        this.f18138f = i11;
        T(this.f18137e, i11);
        W(false);
    }

    @Override // com.mobvoi.health.companion.ui.DatePicker.e
    public void k(DatePicker datePicker, int i10) {
        this.f18137e = i10;
        T(i10, this.f18138f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == s.f26806x) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f26838l);
        Intent intent = getIntent();
        this.f18139g = intent.getIntExtra("data_type", -1);
        this.f18140h = intent.getLongExtra("date_mills", -1L);
        this.f18133a = (ViewPager) findViewById(s.f26812x5);
        this.f18134b = (DatePicker) findViewById(s.f26696h0);
        this.f18142j = (SwipeRefreshLayout) findViewById(s.J4);
        this.f18135c = (ImageView) findViewById(s.f26806x);
        kh.k kVar = new kh.k(this, this.f18139g);
        this.f18143k = kVar;
        kVar.b();
        this.f18144l.a(j.b(this.f18143k.x(), new j.a() { // from class: hg.e
            @Override // nf.j.a
            public final void call(Object obj) {
                HealthDetailCalendarActivity.this.M(obj);
            }
        }));
        this.f18143k.Y().a(this);
        this.f18142j.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: hg.b
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void y() {
                HealthDetailCalendarActivity.this.N();
            }
        });
        init();
        U();
        this.f18142j.setRefreshing(true);
        l.a().postDelayed(new Runnable() { // from class: hg.d
            @Override // java.lang.Runnable
            public final void run() {
                HealthDetailCalendarActivity.this.O();
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        this.f18143k.Y().d();
        this.f18144l.clear();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        sb.a.h(this, "calendar");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        sb.a.i(this, "calendar");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f18143k.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f18143k.d();
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void u(int i10) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void v(int i10) {
        int i11 = this.f18138f;
        if (i11 != i10 && i11 >= 0) {
            if (i10 > i11) {
                this.f18134b.b(true);
            } else {
                this.f18134b.b(false);
            }
        }
    }
}
