package com.mobvoi.mcuwatch.ui.menstrualcycle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mobvoi.mcuwatch.ui.menstrualcycle.MenstrualDetailsActivity;
import com.mobvoi.mcuwatch.ui.menstrualcycle.widget.MenstrualDetailCalendarView;
import io.d;
import io.f;
import io.m;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import sh.h;
import sh.j;
import sh.k;
/* compiled from: MenstrualDetailsActivity.kt */
/* loaded from: classes2.dex */
public final class MenstrualDetailsActivity extends e {

    /* renamed from: j  reason: collision with root package name */
    public static final c f19757j = new c(null);

    /* renamed from: h  reason: collision with root package name */
    private SparseArray<b> f19758h = new SparseArray<>();

    /* renamed from: i  reason: collision with root package name */
    private nk.a f19759i;

    /* compiled from: MenstrualDetailsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a extends androidx.viewpager.widget.a {

        /* renamed from: c  reason: collision with root package name */
        private final Activity f19760c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Date> f19761d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Activity context, List<? extends Date> mDates) {
            i.f(context, "context");
            i.f(mDates, "mDates");
            this.f19760c = context;
            this.f19761d = mDates;
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup container, int i10, Object object) {
            i.f(container, "container");
            i.f(object, "object");
            container.removeView(((b) object).i());
            Activity activity = this.f19760c;
            MenstrualDetailsActivity menstrualDetailsActivity = activity instanceof MenstrualDetailsActivity ? (MenstrualDetailsActivity) activity : null;
            if (menstrualDetailsActivity != null) {
                menstrualDetailsActivity.c0().remove(i10);
            }
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            List<Date> list = this.f19761d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup container, int i10) {
            i.f(container, "container");
            Activity activity = this.f19760c;
            boolean z10 = false;
            View inflate = LayoutInflater.from(activity).inflate(sh.i.f34731b1, container, false);
            i.e(inflate, "from(context)\n                    .inflate(R.layout.menstrual_select_fragment, container, false)");
            b bVar = new b(activity, inflate, this.f19761d, i10);
            Activity activity2 = this.f19760c;
            MenstrualDetailsActivity menstrualDetailsActivity = activity2 instanceof MenstrualDetailsActivity ? (MenstrualDetailsActivity) activity2 : null;
            if (menstrualDetailsActivity != null) {
                menstrualDetailsActivity.c0().put(i10, bVar);
                z10 = menstrualDetailsActivity.Q();
            }
            container.addView(bVar.i());
            bVar.j(z10);
            return bVar;
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object object) {
            i.f(view, "view");
            i.f(object, "object");
            return view == ((b) object).i();
        }
    }

    /* compiled from: MenstrualDetailsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f19762a;

        /* renamed from: b  reason: collision with root package name */
        private final View f19763b;

        /* renamed from: c  reason: collision with root package name */
        private final List<Date> f19764c;

        /* renamed from: d  reason: collision with root package name */
        private final int f19765d;

        /* renamed from: e  reason: collision with root package name */
        private final d f19766e;

        /* renamed from: f  reason: collision with root package name */
        private final MenstrualDetailCalendarView f19767f;

        /* renamed from: g  reason: collision with root package name */
        private final TextView f19768g;

        /* renamed from: h  reason: collision with root package name */
        private final MaterialButton f19769h;

        /* renamed from: i  reason: collision with root package name */
        private final SwitchMaterial f19770i;

        /* compiled from: MenstrualDetailsActivity.kt */
        /* loaded from: classes2.dex */
        static final class a extends Lambda implements qo.a<Date> {
            a() {
                super(0);
            }

            /* renamed from: a */
            public final Date invoke() {
                return b.this.f().get(b.this.h());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Activity context, View mContentView, List<? extends Date> mDates, int i10) {
            d a10;
            i.f(context, "context");
            i.f(mContentView, "mContentView");
            i.f(mDates, "mDates");
            this.f19762a = context;
            this.f19763b = mContentView;
            this.f19764c = mDates;
            this.f19765d = i10;
            a10 = f.a(new a());
            this.f19766e = a10;
            this.f19767f = (MenstrualDetailCalendarView) mContentView.findViewById(h.f34668n0);
            this.f19768g = (TextView) mContentView.findViewById(h.S3);
            this.f19769h = (MaterialButton) mContentView.findViewById(h.T3);
            this.f19770i = (SwitchMaterial) mContentView.findViewById(h.Y2);
        }

        private final Date g() {
            return (Date) this.f19766e.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(b this$0, String str, boolean z10) {
            int i10;
            i.f(this$0, "this$0");
            i.e(str, "str");
            this$0.o(str);
            MaterialButton materialButton = this$0.f19769h;
            if (z10) {
                Activity e10 = this$0.e();
                MenstrualDetailsActivity menstrualDetailsActivity = e10 instanceof MenstrualDetailsActivity ? (MenstrualDetailsActivity) e10 : null;
                if (menstrualDetailsActivity != null) {
                    menstrualDetailsActivity.T(str);
                    m mVar = m.f28349a;
                }
                i10 = 8;
            } else {
                i10 = 0;
            }
            materialButton.setVisibility(i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(b this$0, View view) {
            i.f(this$0, "this$0");
            Activity e10 = this$0.e();
            MenstrualDetailsActivity menstrualDetailsActivity = e10 instanceof MenstrualDetailsActivity ? (MenstrualDetailsActivity) e10 : null;
            if (menstrualDetailsActivity != null) {
                menstrualDetailsActivity.U(menstrualDetailsActivity.J());
            }
            this$0.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void m(CompoundButton compoundButton, boolean z10) {
            aj.a.f215a.j(z10);
            com.mobvoi.mcuwatch.ui.menstrualcycle.data.b.f19786a.d();
        }

        public final void d() {
            this.f19767f.b();
        }

        public final Activity e() {
            return this.f19762a;
        }

        public final List<Date> f() {
            return this.f19764c;
        }

        public final int h() {
            return this.f19765d;
        }

        public final View i() {
            return this.f19763b;
        }

        public final void j(boolean z10) {
            this.f19767f.y(g(), -1, z10);
            this.f19767f.setOnItemClickListener(new MenstrualDetailCalendarView.a() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.k
                @Override // com.mobvoi.mcuwatch.ui.menstrualcycle.widget.MenstrualDetailCalendarView.a
                public final void a(String str, boolean z11) {
                    MenstrualDetailsActivity.b.k(MenstrualDetailsActivity.b.this, str, z11);
                }
            });
            this.f19769h.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MenstrualDetailsActivity.b.l(MenstrualDetailsActivity.b.this, view);
                }
            });
            this.f19770i.setOnCheckedChangeListener(j.f19809a);
        }

        public final void n(com.mobvoi.mcuwatch.ui.menstrualcycle.data.a aVar, boolean z10) {
            this.f19767f.y(g(), -1, z10);
            this.f19767f.setPeriodCycle(aVar);
            Activity activity = this.f19762a;
            MenstrualDetailsActivity menstrualDetailsActivity = activity instanceof MenstrualDetailsActivity ? (MenstrualDetailsActivity) activity : null;
            if (menstrualDetailsActivity != null) {
                o(menstrualDetailsActivity.L());
            }
            this.f19769h.setVisibility(z10 ? 8 : 0);
            this.f19770i.setChecked(aj.a.f215a.g());
        }

        public final void o(String str) {
            i.f(str, "str");
            this.f19768g.setText(str);
        }
    }

    /* compiled from: MenstrualDetailsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final void a(Context context) {
            i.f(context, "context");
            context.startActivity(new Intent(context, MenstrualDetailsActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(MenstrualDetailsActivity this$0, nk.a data) {
        i.f(this$0, "this$0");
        i.f(data, "$data");
        b bVar = this$0.c0().get(this$0.M());
        if (bVar != null && !this$0.b0(data)) {
            com.mobvoi.mcuwatch.ui.menstrualcycle.data.b bVar2 = com.mobvoi.mcuwatch.ui.menstrualcycle.data.b.f19786a;
            Date date = this$0.K().get(this$0.M());
            i.e(date, "dates[mCurrentIndex]");
            bVar.n(bVar2.f(date, data), this$0.Q());
        }
    }

    private final boolean b0(nk.a aVar) {
        Calendar calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        calendar.setTime(new Date(aVar.c()));
        return calendar.getTimeInMillis() > timeInMillis;
    }

    private final void e0() {
        aj.a aVar = aj.a.f215a;
        nk.a aVar2 = new nk.a(aVar.e(), aVar.c(), aVar.b());
        this.f19759i = aVar2;
        i.d(aVar2);
        h0(aVar2);
        I().f37537c.post(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.f
            @Override // java.lang.Runnable
            public final void run() {
                MenstrualDetailsActivity.f0(MenstrualDetailsActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(MenstrualDetailsActivity this$0) {
        i.f(this$0, "this$0");
        b bVar = this$0.c0().get(this$0.M());
        if (bVar != null) {
            bVar.d();
        }
    }

    private final void g0() {
    }

    private final void h0(final nk.a aVar) {
        I().f37537c.post(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.g
            @Override // java.lang.Runnable
            public final void run() {
                MenstrualDetailsActivity.i0(MenstrualDetailsActivity.this, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(MenstrualDetailsActivity this$0, nk.a data) {
        i.f(this$0, "this$0");
        i.f(data, "$data");
        b bVar = this$0.c0().get(this$0.M());
        if (bVar != null) {
            com.mobvoi.mcuwatch.ui.menstrualcycle.data.b bVar2 = com.mobvoi.mcuwatch.ui.menstrualcycle.data.b.f19786a;
            Date date = this$0.K().get(this$0.M());
            i.e(date, "dates[mCurrentIndex]");
            bVar.n(bVar2.f(date, data), this$0.Q());
            bVar.d();
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.menstrualcycle.e
    public void H(int i10) {
        super.H(i10);
        final nk.a aVar = this.f19759i;
        if (aVar != null) {
            I().f37537c.postDelayed(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.menstrualcycle.h
                @Override // java.lang.Runnable
                public final void run() {
                    MenstrualDetailsActivity.a0(MenstrualDetailsActivity.this, aVar);
                }
            }, 100L);
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.menstrualcycle.e
    public int O() {
        return k.f34869t1;
    }

    protected final SparseArray<b> c0() {
        return this.f19758h;
    }

    /* renamed from: d0 */
    public a N(Activity context, List<? extends Date> mDates) {
        i.f(context, "context");
        i.f(mDates, "mDates");
        return new a(context, mDates);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1 && i11 == 3 && intent != null) {
            nk.a aVar = new nk.a(intent.getLongExtra("startDate", -1L), intent.getIntExtra("menstruationLength", 0), intent.getIntExtra("cycleLength", 0));
            this.f19759i = aVar;
            i.d(aVar);
            h0(aVar);
            com.mobvoi.mcuwatch.ui.menstrualcycle.data.b.f19786a.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.mcuwatch.ui.menstrualcycle.e, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g0();
        e0();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        i.f(menu, "menu");
        getMenuInflater().inflate(j.a_res_0x7f0f000a, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        i.f(item, "item");
        if (item.getItemId() == h.c_res_0x7f0b0075) {
            Intent intent = new Intent(this, MenstrualSettingActivity.class);
            nk.a aVar = this.f19759i;
            if (aVar != null) {
                intent.putExtra("startDate", aVar.c());
                intent.putExtra("menstruationLength", aVar.b());
                intent.putExtra("cycleLength", aVar.a());
            }
            startActivityForResult(intent, 1);
        }
        return super.onOptionsItemSelected(item);
    }
}
