package com.mobvoi.mcuwatch.ui.menstrualcycle;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.DateFormat;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.a;
import bh.b;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.health.companion.ui.DatePicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.i;
import sh.k;
import zh.g;
/* compiled from: CalendarBaseActivity.kt */
/* loaded from: classes2.dex */
public abstract class e extends d implements DatePicker.e, DatePicker.f, ViewPager.j {

    /* renamed from: a  reason: collision with root package name */
    private int f19796a;

    /* renamed from: d  reason: collision with root package name */
    private long f19799d;

    /* renamed from: g  reason: collision with root package name */
    public g f19802g;

    /* renamed from: b  reason: collision with root package name */
    private int f19797b = -1;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<Date> f19798c = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private int f19800e = -1;

    /* renamed from: f  reason: collision with root package name */
    private String f19801f = "";

    private final void V(int i10, int i11) {
        if (i10 == 0 && i11 != I().f37537c.getCurrentItem() && i11 != -1) {
            H(i11);
            I().f37537c.R(i11, false);
        }
    }

    private final void W() {
        Calendar a10 = b.a();
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        long timeInMillis = calendar.getTimeInMillis();
        this.f19798c.clear();
        for (int i10 = 0; i10 < 1000; i10++) {
            if (a10.getTimeInMillis() == timeInMillis) {
                this.f19797b = i10;
                this.f19800e = i10;
            }
            this.f19798c.add(a10.getTime());
            a10.add(2, 1);
        }
        int size = this.f19798c.size();
        String[] strArr = new String[size];
        int size2 = this.f19798c.size() - 1;
        if (size2 >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                Date date = this.f19798c.get(i11);
                i.e(date, "dates[i]");
                Date date2 = date;
                date2.getTime();
                strArr[i11] = DateFormat.format(getString(k.f34781c0), date2).toString();
                if (i12 > size2) {
                    break;
                }
                i11 = i12;
            }
        }
        I().f37536b.setDisplayedValues(strArr);
        I().f37536b.setMinValue(0);
        I().f37536b.setMaxValue(size - 1);
        I().f37536b.setValue(this.f19797b);
        I().f37537c.setAdapter(N(this, this.f19798c));
        I().f37537c.setOffscreenPageLimit(0);
        I().f37537c.setCurrentItem(this.f19797b);
        this.f19797b = this.f19797b;
    }

    private final void initView() {
        setTitle(O());
        I().f37536b.setOnScrollListener(this);
        I().f37536b.setOnValueChangedListener(this);
        I().f37536b.setWrapSelectorWheel(false);
        I().f37537c.c(this);
    }

    public void H(int i10) {
    }

    public final g I() {
        g gVar = this.f19802g;
        if (gVar != null) {
            return gVar;
        }
        i.u("binding");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int J() {
        return this.f19800e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<Date> K() {
        return this.f19798c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String L() {
        return this.f19801f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int M() {
        return this.f19797b;
    }

    public abstract a N(Activity activity, List<? extends Date> list);

    public abstract int O();

    public boolean Q() {
        Calendar calendar = Calendar.getInstance();
        int i10 = calendar.get(2);
        int i11 = calendar.get(1);
        calendar.setTime(this.f19798c.get(I().f37537c.getCurrentItem()));
        return calendar.get(2) == i10 && calendar.get(1) == i11;
    }

    public final void S(g gVar) {
        i.f(gVar, "<set-?>");
        this.f19802g = gVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void T(String str) {
        i.f(str, "<set-?>");
        this.f19801f = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void U(int i10) {
        if (i10 >= 0) {
            I().f37537c.R(i10, false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void c(int i10, float f10, int i11) {
    }

    @Override // com.mobvoi.health.companion.ui.DatePicker.f
    public void g(DatePicker datePicker, int i10, int i11) {
        this.f19797b = i11;
        V(this.f19796a, i11);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.l_res_0x7f0e002f;
    }

    @Override // com.mobvoi.health.companion.ui.DatePicker.e
    public void k(DatePicker datePicker, int i10) {
        this.f19796a = i10;
        V(i10, this.f19797b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g b10 = g.b(getContentView().getChildAt(0));
        i.e(b10, "bind(contentView.getChildAt(0))");
        S(b10);
        this.f19799d = getIntent().getLongExtra("date_mills", -1L);
        initView();
        W();
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void u(int i10) {
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void v(int i10) {
        int i11 = this.f19797b;
        if (i11 != i10 && i11 >= 0) {
            H(i10);
            int abs = Math.abs(i10 - this.f19797b);
            if (i10 > this.f19797b) {
                if (abs > 1) {
                    I().f37536b.c(true, abs);
                } else {
                    I().f37536b.b(true);
                }
            } else if (abs > 1) {
                I().f37536b.c(false, abs);
            } else {
                I().f37536b.b(false);
            }
        }
    }
}
