package com.mobvoi.mcuwatch.ui.menstrualcycle;

import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.button.MaterialButton;
import com.mobvoi.mcuwatch.ui.menstrualcycle.CalendarActivity;
import com.mobvoi.mcuwatch.ui.menstrualcycle.widget.PeriodSettingCalendarView;
import io.d;
import io.f;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import sh.h;
import sh.k;
/* compiled from: CalendarActivity.kt */
/* loaded from: classes2.dex */
public final class CalendarActivity extends e {

    /* renamed from: i  reason: collision with root package name */
    public static final c f19745i = new c(null);

    /* renamed from: h  reason: collision with root package name */
    private SparseArray<b> f19746h = new SparseArray<>();

    /* compiled from: CalendarActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends androidx.viewpager.widget.a {

        /* renamed from: c  reason: collision with root package name */
        private final Activity f19747c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Date> f19748d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Activity context, List<? extends Date> mDates) {
            i.f(context, "context");
            i.f(mDates, "mDates");
            this.f19747c = context;
            this.f19748d = mDates;
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup container, int i10, Object object) {
            i.f(container, "container");
            i.f(object, "object");
            container.removeView(((b) object).h());
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            List<Date> list = this.f19748d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup container, int i10) {
            i.f(container, "container");
            Activity activity = this.f19747c;
            boolean z10 = false;
            View inflate = LayoutInflater.from(activity).inflate(sh.i.M, container, false);
            i.e(inflate, "from(context)\n                    .inflate(R.layout.calendar_select_fragment, container, false)");
            b bVar = new b(activity, inflate, this.f19748d, i10);
            Activity activity2 = this.f19747c;
            CalendarActivity calendarActivity = activity2 instanceof CalendarActivity ? (CalendarActivity) activity2 : null;
            if (calendarActivity != null) {
                calendarActivity.Z().put(i10, bVar);
                z10 = calendarActivity.Q();
            }
            bVar.i(z10);
            bVar.j();
            container.addView(bVar.h());
            return bVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object object) {
            i.f(view, "view");
            i.f(object, "object");
            return view == ((b) object).h();
        }
    }

    /* compiled from: CalendarActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f19749a;

        /* renamed from: b  reason: collision with root package name */
        private final View f19750b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Date> f19751c;

        /* renamed from: d  reason: collision with root package name */
        private final int f19752d;

        /* renamed from: e  reason: collision with root package name */
        private final PeriodSettingCalendarView f19753e;

        /* renamed from: f  reason: collision with root package name */
        private final MaterialButton f19754f;

        /* renamed from: g  reason: collision with root package name */
        private final MaterialButton f19755g;

        /* renamed from: h  reason: collision with root package name */
        private final d f19756h;

        /* compiled from: CalendarActivity.kt */
        /* loaded from: classes2.dex */
        static final class a extends Lambda implements qo.a<Date> {
            a() {
                super(0);
            }

            /* renamed from: a */
            public final Date invoke() {
                return b.this.e().get(b.this.g());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Activity context, View mContentView, List<? extends Date> mDates, int i10) {
            d a10;
            i.f(context, "context");
            i.f(mContentView, "mContentView");
            i.f(mDates, "mDates");
            this.f19749a = context;
            this.f19750b = mContentView;
            this.f19751c = mDates;
            this.f19752d = i10;
            this.f19753e = (PeriodSettingCalendarView) mContentView.findViewById(h.f34668n0);
            this.f19754f = (MaterialButton) mContentView.findViewById(h.A3);
            this.f19755g = (MaterialButton) mContentView.findViewById(h.f34655j4);
            a10 = f.a(new a());
            this.f19756h = a10;
        }

        private final Date f() {
            return (Date) this.f19756h.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(b this$0, View view) {
            i.f(this$0, "this$0");
            this$0.d().finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(b this$0, View view) {
            i.f(this$0, "this$0");
            Intent intent = new Intent();
            intent.putExtra("monthDate", eg.c.a(System.currentTimeMillis()).getTimeInMillis());
            this$0.d().setResult(-1, intent);
            this$0.d().finish();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(b this$0, Date date, Date date2, Date date3) {
            i.f(this$0, "this$0");
            if (date3 != null) {
                Intent intent = new Intent();
                intent.putExtra("monthDate", date3.getTime());
                this$0.d().setResult(-1, intent);
            }
            this$0.d().finish();
        }

        public final Activity d() {
            return this.f19749a;
        }

        public final List<Date> e() {
            return this.f19751c;
        }

        public final int g() {
            return this.f19752d;
        }

        public final View h() {
            return this.f19750b;
        }

        public final void i(boolean z10) {
            this.f19753e.q(f(), -1, z10);
        }

        public final void j() {
            this.f19754f.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CalendarActivity.b.k(CalendarActivity.b.this, view);
                }
            });
            this.f19755g.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CalendarActivity.b.l(CalendarActivity.b.this, view);
                }
            });
            this.f19753e.setOnItemClickListener(new PeriodSettingCalendarView.a() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.d
                @Override // com.mobvoi.mcuwatch.ui.menstrualcycle.widget.PeriodSettingCalendarView.a
                public final void a(Date date, Date date2, Date date3) {
                    CalendarActivity.b.m(CalendarActivity.b.this, date, date2, date3);
                }
            });
        }
    }

    /* compiled from: CalendarActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final void a(Activity context, int i10, Long l10) {
            i.f(context, "context");
            context.startActivityForResult(new Intent(context, CalendarActivity.class).putExtra("date_mills", l10), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(CalendarActivity this$0) {
        i.f(this$0, "this$0");
        b bVar = this$0.Z().get(this$0.M());
        if (bVar != null) {
            bVar.i(this$0.Q());
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.menstrualcycle.e
    public void H(int i10) {
        super.H(i10);
        I().f37537c.postDelayed(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.a
            @Override // java.lang.Runnable
            public final void run() {
                CalendarActivity.Y(CalendarActivity.this);
            }
        }, 100L);
    }

    @Override // com.mobvoi.mcuwatch.ui.menstrualcycle.e
    public int O() {
        return k.f34890x0;
    }

    protected final SparseArray<b> Z() {
        return this.f19746h;
    }

    /* renamed from: a0 */
    public a N(Activity context, List<? extends Date> mDates) {
        i.f(context, "context");
        i.f(mDates, "mDates");
        return new a(context, mDates);
    }
}
