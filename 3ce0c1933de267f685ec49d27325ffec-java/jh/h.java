package jh;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.mobvoi.android.common.utils.d;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.companion.base.m3.a;
import com.mobvoi.health.companion.ui.DatePicker;
import com.mobvoi.health.companion.ui.ShowWeeksDatePicker;
import eg.c;
import fg.i;
import fg.o;
import fg.q;
import fg.s;
import fg.t;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kh.w;
import nf.j;
import nf.m;
import og.u;
import rx.subjects.b;
/* compiled from: HealthDetailsBaseActivity.java */
/* loaded from: classes2.dex */
public abstract class h extends a implements DatePicker.e, DatePicker.f, ViewPager.j, hg.a {
    private static final long A = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a  reason: collision with root package name */
    protected TextView f29594a;

    /* renamed from: b  reason: collision with root package name */
    protected TextView f29595b;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f29596c;

    /* renamed from: d  reason: collision with root package name */
    protected List<String> f29597d;

    /* renamed from: e  reason: collision with root package name */
    protected List<String> f29598e;

    /* renamed from: f  reason: collision with root package name */
    protected List<String> f29599f;

    /* renamed from: h  reason: collision with root package name */
    private ViewPager f29601h;

    /* renamed from: i  reason: collision with root package name */
    protected SwipeRefreshLayout f29602i;

    /* renamed from: j  reason: collision with root package name */
    protected DatePicker f29603j;

    /* renamed from: k  reason: collision with root package name */
    protected View f29604k;

    /* renamed from: m  reason: collision with root package name */
    protected u f29606m;

    /* renamed from: r  reason: collision with root package name */
    protected ImageView f29611r;

    /* renamed from: s  reason: collision with root package name */
    protected TextView f29612s;

    /* renamed from: t  reason: collision with root package name */
    protected ShowWeeksDatePicker f29613t;

    /* renamed from: u  reason: collision with root package name */
    protected DatePicker f29614u;

    /* renamed from: v  reason: collision with root package name */
    protected DatePicker f29615v;

    /* renamed from: w  reason: collision with root package name */
    protected int f29616w;

    /* renamed from: x  reason: collision with root package name */
    protected long f29617x;

    /* renamed from: g  reason: collision with root package name */
    protected SparseArray<a> f29600g = new SparseArray<>();

    /* renamed from: l  reason: collision with root package name */
    protected final m f29605l = new m();

    /* renamed from: n  reason: collision with root package name */
    protected int f29607n = -1;

    /* renamed from: o  reason: collision with root package name */
    protected int f29608o = -1;

    /* renamed from: p  reason: collision with root package name */
    protected int f29609p = -1;

    /* renamed from: q  reason: collision with root package name */
    protected int f29610q = -1;

    /* renamed from: y  reason: collision with root package name */
    private b<Integer> f29618y = b.o0();

    /* renamed from: z  reason: collision with root package name */
    private final View.OnClickListener f29619z = new View.OnClickListener() { // from class: jh.b
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            h.this.a0(view);
        }
    };

    private void M(int i10) {
        this.f29618y.onNext(Integer.valueOf(i10));
    }

    private void N(int i10) {
        int i11 = this.f29607n;
        if (i11 == 1) {
            this.f29608o = i10;
        } else if (i11 == 2) {
            this.f29609p = i10;
        } else if (i11 == 3) {
            this.f29610q = i10;
        }
    }

    private void O(int i10) {
        this.f29608o = this.f29606m.s().size() - 1;
        this.f29609p = this.f29606m.y().size() - 1;
        this.f29610q = this.f29606m.v().size() - 1;
        k.c("health_base", "changeIndex default dayIndex : %s, weekIndex : %s, monthIndex : %s", Integer.valueOf(this.f29608o), Integer.valueOf(this.f29609p), Integer.valueOf(this.f29610q));
        if (this.f29617x >= 0) {
            if (i10 == 1) {
                List<Long> s10 = this.f29606m.s();
                for (int size = (s10 == null ? 0 : s10.size()) - 1; size >= 0; size--) {
                    if (s10.get(size).longValue() == this.f29617x) {
                        this.f29608o = size;
                    }
                }
            } else if (i10 == 2) {
                List<w.d> y10 = this.f29606m.y();
                int size2 = y10 == null ? 0 : y10.size();
                long millis = TimeUnit.DAYS.toMillis(7L);
                int i11 = size2 - 1;
                while (true) {
                    if (i11 < 0) {
                        break;
                    }
                    long j10 = this.f29617x;
                    long j11 = y10.get(i11).f29973a;
                    if (j10 >= j11 && j10 < j11 + millis) {
                        this.f29609p = i11;
                        break;
                    }
                    i11--;
                }
            } else if (i10 == 3) {
                List<Long> v10 = this.f29606m.v();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.f29617x);
                long timeInMillis = c.o(calendar).getTimeInMillis();
                Calendar calendar2 = Calendar.getInstance();
                int size3 = (v10 == null ? 0 : v10.size()) - 1;
                while (true) {
                    if (size3 < 0) {
                        break;
                    }
                    calendar2.setTimeInMillis(v10.get(size3).longValue());
                    if (c.o(calendar2).getTimeInMillis() == timeInMillis) {
                        this.f29610q = size3;
                        break;
                    }
                    size3--;
                }
            }
            k.c("health_base", "changeIndex after parsing dayIndex : %s, weekIndex : %s, monthIndex : %s", Integer.valueOf(this.f29608o), Integer.valueOf(this.f29609p), Integer.valueOf(this.f29610q));
        }
    }

    private void S() {
        List<String> list = this.f29597d;
        if (list != null) {
            list.clear();
        }
        this.f29597d = new ArrayList();
        List<Long> s10 = this.f29606m.s();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s10.get(0).longValue());
        int i10 = calendar.get(2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM", Locale.getDefault());
        String[] stringArray = getResources().getStringArray(fg.m.f26441c);
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
                this.f29597d.add(simpleDateFormat.format(calendar.getTime()) + "," + str);
            } else {
                this.f29597d.add(calendar.get(5) + "," + str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view) {
        int id2 = view.getId();
        if (id2 == s.V1) {
            sb.a.e(this, "healthMonth", W());
            u0(3, false);
        } else if (id2 == s.A5) {
            sb.a.e(this, "healthWeek", W());
            u0(2, false);
        } else if (id2 == s.f26731m0) {
            sb.a.e(this, "healthDay", W());
            u0(1, false);
        } else if (id2 == s.f26820z) {
            finish();
        } else if (id2 == s.f26701h5) {
            sb.a.e(this, "healthToday", W());
            m0();
        } else if (id2 == s.N) {
            sb.a.e(this, "healthCal", W());
            Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(Object obj) {
        h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0() {
        t0(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d0() {
        t0(false);
        this.f29602i.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0(Integer num) {
        k.c("health_base", "real query data,  index = %s", num);
        t0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0() {
        t0(false);
    }

    private void g0() {
        List<String> list = this.f29599f;
        if (list != null) {
            list.clear();
        }
        this.f29599f = new ArrayList();
        List<Long> v10 = this.f29606m.v();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(v10.get(0).longValue());
        int i10 = calendar.get(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM", Locale.getDefault());
        for (int i11 = 0; i11 < v10.size(); i11++) {
            calendar.setTimeInMillis(v10.get(i11).longValue());
            if (i10 != calendar.get(1)) {
                i10 = calendar.get(1);
                this.f29599f.add(String.valueOf(i10));
            } else {
                this.f29599f.add(simpleDateFormat.format(calendar.getTime()));
            }
        }
    }

    private void h0() {
        l.a().postDelayed(new Runnable() { // from class: jh.d
            @Override // java.lang.Runnable
            public final void run() {
                h.this.d0();
            }
        }, 1000L);
    }

    private void j0() {
    }

    private void l0(int i10) {
        int color = getColor(o.f26462i);
        this.f29596c.setTextColor(color);
        this.f29594a.setTextColor(color);
        this.f29595b.setTextColor(color);
        this.f29596c.setBackground(null);
        this.f29594a.setBackground(null);
        this.f29595b.setBackground(null);
        if (i10 == 1) {
            this.f29596c.setTextColor(-1);
            this.f29596c.setBackgroundResource(q.V);
        } else if (i10 == 2) {
            this.f29595b.setTextColor(-1);
            this.f29595b.setBackgroundResource(q.V);
        } else if (i10 == 3) {
            this.f29594a.setTextColor(-1);
            this.f29594a.setBackgroundResource(q.V);
        }
    }

    private void m0() {
        int i10;
        int i11;
        int i12 = this.f29607n;
        if (i12 == 1) {
            i11 = this.f29597d.size();
        } else if (i12 == 2) {
            i11 = this.f29598e.size();
        } else if (i12 != 3) {
            i10 = 0;
            this.f29603j.setValue(i10);
            N(i10);
            t0(false);
            this.f29611r.setVisibility(8);
        } else {
            i11 = this.f29599f.size();
        }
        i10 = i11 - 1;
        this.f29603j.setValue(i10);
        N(i10);
        t0(false);
        this.f29611r.setVisibility(8);
    }

    private void n0(int i10) {
        int i11 = this.f29607n;
        if (i11 == 1) {
            this.f29597d.size();
        } else if (i11 == 2) {
            this.f29598e.size();
        } else if (i11 == 3) {
            this.f29599f.size();
        }
    }

    private void o0() {
        this.f29618y.i(400L, TimeUnit.MILLISECONDS).H(xp.a.b()).X(new yp.b() { // from class: jh.g
            @Override // yp.b
            public final void call(Object obj) {
                h.this.e0((Integer) obj);
            }
        });
    }

    public static void p0(Context context, int i10, int i11, int i12) {
        new k7.b(context).d(true).q(i10).h(i11).m(i12, null).t();
    }

    public static void q0(Context context, Class<?> cls) {
        r0(context, cls, 1, c.a(System.currentTimeMillis()).getTimeInMillis());
    }

    public static void r0(Context context, Class<?> cls, int i10, long j10) {
        Intent intent = new Intent(context, cls);
        intent.putExtra("extra.health_data_type", fg.l.a(cls));
        intent.putExtra("extra.START_TIME", j10);
        intent.putExtra("data_type", i10);
        context.startActivity(intent);
    }

    public static void s0(Context context, Class<?> cls, String str, long j10) {
        int i10 = 1;
        if (!String.valueOf(1).equals(str)) {
            if (String.valueOf(2).equals(str)) {
                i10 = 2;
            } else if (String.valueOf(3).equals(str)) {
                i10 = 3;
            }
        }
        r0(context, cls, i10, j10);
    }

    private void u0(int i10, boolean z10) {
        if (this.f29607n != i10) {
            this.f29607n = i10;
            j0();
            l0(i10);
            if (i10 == 1) {
                S();
                ShowWeeksDatePicker showWeeksDatePicker = this.f29613t;
                this.f29603j = showWeeksDatePicker;
                showWeeksDatePicker.setVisibility(0);
                this.f29614u.setVisibility(8);
                this.f29615v.setVisibility(8);
                this.f29613t.setWrapSelectorWheel(false);
                this.f29613t.setIndecseNumber(7);
                this.f29613t.setMinValue(0);
                this.f29613t.setMaxValue(this.f29597d.size() - 1);
                this.f29613t.setDisplayedValues((String[]) this.f29597d.toArray(new String[0]));
                this.f29613t.setValue(this.f29608o);
                this.f29600g.clear();
                this.f29601h.setAdapter(V(this.f29607n));
                this.f29601h.setCurrentItem(this.f29608o);
                this.f29597d.size();
            } else if (i10 == 2) {
                v0();
                this.f29603j = this.f29614u;
                this.f29613t.setVisibility(8);
                this.f29614u.setVisibility(0);
                this.f29615v.setVisibility(8);
                this.f29614u.setWrapSelectorWheel(false);
                this.f29614u.setIndecseNumber(3);
                this.f29614u.setMinValue(0);
                this.f29614u.setMaxValue(this.f29598e.size() - 1);
                this.f29614u.setDisplayedValues((String[]) this.f29598e.toArray(new String[0]));
                this.f29614u.setValue(this.f29609p);
                this.f29600g.clear();
                this.f29601h.setAdapter(V(this.f29607n));
                this.f29601h.setCurrentItem(this.f29609p);
                this.f29598e.size();
            } else if (i10 == 3) {
                g0();
                this.f29603j = this.f29615v;
                this.f29613t.setVisibility(8);
                this.f29614u.setVisibility(8);
                this.f29615v.setVisibility(0);
                this.f29615v.setWrapSelectorWheel(false);
                this.f29615v.setIndecseNumber(7);
                this.f29615v.setMinValue(0);
                this.f29615v.setMaxValue(this.f29599f.size() - 1);
                this.f29615v.setDisplayedValues((String[]) this.f29599f.toArray(new String[0]));
                this.f29615v.setValue(this.f29610q);
                this.f29600g.clear();
                this.f29601h.setAdapter(V(this.f29607n));
                this.f29601h.setCurrentItem(this.f29610q);
                this.f29599f.size();
            }
            if (z10) {
                l.a().postDelayed(new Runnable() { // from class: jh.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.this.f0();
                    }
                }, 200L);
            } else {
                t0(false);
            }
        }
    }

    private void v0() {
        List<w.d> y10 = this.f29606m.y();
        List<String> list = this.f29598e;
        if (list != null) {
            list.clear();
        } else {
            this.f29598e = new ArrayList();
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
            this.f29598e.add(sb2.toString());
            sb2.setLength(0);
        }
    }

    protected void Q(long j10) {
        List<w.d> y10 = this.f29606m.y();
        int i10 = 0;
        int size = y10 == null ? 0 : y10.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            w.d dVar = y10.get(i11);
            if (j10 >= dVar.f29973a && j10 <= dVar.f29974b) {
                this.f29609p = i11;
                break;
            }
            i11++;
        }
        List<Long> v10 = this.f29606m.v();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j10);
        long timeInMillis = c.o(calendar).getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance();
        if (v10 != null) {
            i10 = v10.size();
        }
        for (int i12 = i10 - 1; i12 >= 0; i12--) {
            calendar2.setTimeInMillis(v10.get(i12).longValue());
            if (c.o(calendar2).getTimeInMillis() == timeInMillis) {
                this.f29610q = i12;
                return;
            }
        }
    }

    protected void T(long j10) {
        if (this.f29606m != null) {
            long millis = j10 + TimeUnit.DAYS.toMillis(1L);
            long j11 = millis - A;
            k.a("health_base", "fetchNeighborRecords " + d.a(j11) + " - " + d.a(millis));
            this.f29606m.p(j11, millis);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int U() {
        int i10 = this.f29607n;
        if (i10 == 1) {
            return this.f29608o;
        }
        if (i10 == 2) {
            return this.f29609p;
        }
        if (i10 != 3) {
            return -1;
        }
        return this.f29610q;
    }

    public abstract androidx.viewpager.widget.a V(int i10);

    protected String W() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long X() {
        long l02 = this.f29606m.l0(this.f29608o);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l02);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    protected void Y(long j10) {
        List<Long> s10 = this.f29606m.s();
        int size = s10 == null ? 0 : s10.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            } else if (s10.get(i10).longValue() == j10) {
                this.f29608o = i10;
                break;
            } else {
                i10++;
            }
        }
        Q(j10);
        if (this.f29607n != 1) {
            u0(1, false);
            return;
        }
        this.f29603j.setValue(this.f29608o);
        k0(this.f29608o);
        n0(this.f29608o);
        t0(false);
    }

    public abstract void Z();

    @Override // androidx.viewpager.widget.ViewPager.j
    public void c(int i10, float f10, int i11) {
    }

    @Override // com.mobvoi.health.companion.ui.DatePicker.f
    public void g(DatePicker datePicker, int i10, int i11) {
        List<Long> s10;
        N(i11);
        int U = U();
        k0(U);
        n0(i11);
        M(U);
        if (this.f29607n == 1 && (s10 = this.f29606m.s()) != null && !s10.isEmpty()) {
            Q(s10.get(this.f29608o).longValue());
        }
    }

    protected void i0() {
    }

    @Override // com.mobvoi.health.companion.ui.DatePicker.e
    public void k(DatePicker datePicker, int i10) {
    }

    public void k0(int i10) {
        if (i10 != this.f29601h.getCurrentItem()) {
            this.f29601h.R(i10, false);
        }
    }

    public void n(long j10, long j11) {
        String string = getString(fg.u.f26920l);
        int i10 = this.f29607n;
        if (i10 == 2) {
            string = getString(fg.u.f26914k);
        } else if (i10 == 3) {
            string = getString(fg.u.f26908j);
        }
        this.f29612s.setText(new SimpleDateFormat(string, Locale.getDefault()).format(new Date(j10)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 16) {
            i0();
        } else if (i11 == -1 && intent != null) {
            Y(intent.getLongExtra("monthDate", -1L));
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
        setContentView(t.f26828b);
        o0();
        ImageView imageView = (ImageView) findViewById(s.f26701h5);
        this.f29611r = imageView;
        imageView.setOnClickListener(this.f29619z);
        Intent intent = getIntent();
        this.f29616w = intent.getIntExtra("extra.health_data_type", -1);
        this.f29617x = intent.getLongExtra("extra.START_TIME", -1L);
        int intExtra = intent.getIntExtra("data_type", 1);
        k.c("health_base", "get start dateType : %s ", Integer.valueOf(intExtra));
        u uVar = new u(this, this.f29616w);
        this.f29606m = uVar;
        uVar.W0(this);
        findViewById(s.f26820z).setOnClickListener(this.f29619z);
        findViewById(s.N).setOnClickListener(this.f29619z);
        this.f29604k = findViewById(s.f26813y);
        this.f29595b = (TextView) findViewById(s.A5);
        this.f29594a = (TextView) findViewById(s.V1);
        this.f29596c = (TextView) findViewById(s.f26731m0);
        this.f29613t = (ShowWeeksDatePicker) findViewById(s.f26703i0);
        this.f29614u = (DatePicker) findViewById(s.f26717k0);
        this.f29615v = (DatePicker) findViewById(s.f26710j0);
        this.f29612s = (TextView) findViewById(s.V);
        this.f29595b.setOnClickListener(this.f29619z);
        this.f29594a.setOnClickListener(this.f29619z);
        this.f29596c.setOnClickListener(this.f29619z);
        this.f29613t.setOnScrollListener(this);
        this.f29613t.setOnValueChangedListener(this);
        this.f29614u.setOnScrollListener(this);
        this.f29614u.setOnValueChangedListener(this);
        this.f29615v.setOnScrollListener(this);
        this.f29615v.setOnValueChangedListener(this);
        ViewPager viewPager = (ViewPager) findViewById(s.f26805w5);
        this.f29601h = viewPager;
        viewPager.c(this);
        this.f29601h.setOffscreenPageLimit(1);
        this.f29605l.a(j.b(this.f29606m.x(), new j.a() { // from class: jh.f
            @Override // nf.j.a
            public final void call(Object obj) {
                h.this.b0(obj);
            }
        }));
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(s.J4);
        this.f29602i = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: jh.c
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
            public final void y() {
                h.this.c0();
            }
        });
        O(intExtra);
        u0(intExtra, true);
        long b10 = c.b(System.currentTimeMillis());
        long a10 = i.a(this, "health_fetch_time");
        if (a10 < 0 || a10 + A < b10) {
            this.f29602i.setRefreshing(true);
            T(b10);
            i.b(this, "health_fetch_time", b10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f29618y.onCompleted();
        this.f29605l.clear();
        this.f29601h.N(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f29606m.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f29606m.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t0(boolean z10) {
        int i10;
        int i11 = this.f29607n;
        if (i11 == 1) {
            int i12 = this.f29608o;
            if (i12 >= 0) {
                this.f29606m.Y0(i12, z10, i11);
            }
        } else if (i11 == 2) {
            int i13 = this.f29609p;
            if (i13 >= 0) {
                this.f29606m.a1(i13, z10, i11);
            }
        } else if (i11 == 3 && (i10 = this.f29610q) >= 0) {
            this.f29606m.Z0(i10, z10, i11);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void u(int i10) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void v(int i10) {
        int U = U();
        if (U != i10 && U >= 0) {
            if (i10 > U) {
                this.f29603j.b(true);
            } else {
                this.f29603j.b(false);
            }
        }
    }
}
