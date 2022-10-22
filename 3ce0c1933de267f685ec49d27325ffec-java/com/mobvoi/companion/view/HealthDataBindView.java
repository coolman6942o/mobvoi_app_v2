package com.mobvoi.companion.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ce.b;
import ce.e;
import ce.f;
import ce.h;
import ce.j;
import com.mobvoi.assistant.account.AccountConstant;
import com.mobvoi.companion.unit.UnitPolicy;
import com.mobvoi.companion.view.HealthDataBindView;
import com.mobvoi.health.common.data.db.c;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kd.d;
import nf.j;
import nf.l;
import wd.a;
/* loaded from: classes2.dex */
public class HealthDataBindView extends FrameLayout {

    /* renamed from: n  reason: collision with root package name */
    private static final int f17647n = b.f5745b;

    /* renamed from: a  reason: collision with root package name */
    protected View f17648a;

    /* renamed from: b  reason: collision with root package name */
    protected TextView f17649b;

    /* renamed from: c  reason: collision with root package name */
    protected TextView f17650c;

    /* renamed from: d  reason: collision with root package name */
    private a f17651d;

    /* renamed from: e  reason: collision with root package name */
    private int f17652e;

    /* renamed from: f  reason: collision with root package name */
    private int f17653f;

    /* renamed from: g  reason: collision with root package name */
    private int f17654g;

    /* renamed from: h  reason: collision with root package name */
    private int f17655h;

    /* renamed from: i  reason: collision with root package name */
    private Object f17656i;

    /* renamed from: j  reason: collision with root package name */
    private LayoutInflater f17657j;

    /* renamed from: k  reason: collision with root package name */
    private com.mobvoi.health.common.data.db.a f17658k;

    /* renamed from: l  reason: collision with root package name */
    private l f17659l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17660m = true;

    public HealthDataBindView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d(attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(c.a aVar) {
        g(this.f17656i);
    }

    private void g(Object obj) {
        int i10 = this.f17655h;
        if (i10 == 0) {
            m((String) obj);
        } else if (1 == i10) {
            k(((Integer) obj).intValue());
        } else if (2 == i10) {
            i(((Long) obj).longValue());
        } else if (3 == i10) {
            p(((Float) obj).floatValue());
        } else if (4 == i10) {
            l(((Float) obj).floatValue());
        } else if (5 == i10) {
            n(((Integer) obj).intValue());
        } else if (6 == i10) {
            j(((Integer) obj).intValue());
        } else if (7 == i10) {
            h(((Integer) obj).intValue());
        } else if (8 == i10) {
            o();
        }
    }

    private void h(int i10) {
        if (i10 <= 0) {
            i10 = 10;
        }
        this.f17650c.setText(getContext().getString(h.f5838c, Integer.valueOf(i10)));
    }

    private void i(long j10) {
        String f10 = ta.a.f();
        if (j10 != -1) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(TimeUnit.SECONDS.toMillis(j10));
            f10 = simpleDateFormat.format(calendar.getTime());
        }
        if (!TextUtils.isEmpty(f10)) {
            this.f17650c.setText(d.c(f10));
        }
    }

    private void j(int i10) {
        this.f17650c.setText(getContext().getString(h.f5836b, i10 > 0 ? String.valueOf(i10) : "30"));
    }

    private void k(int i10) {
        int i11;
        Context context;
        Context context2;
        int i12;
        AccountConstant.Sex sex = AccountConstant.Sex.values()[ta.a.t()];
        if (i10 != -1) {
            TextView textView = this.f17650c;
            if (i10 == 1) {
                context2 = getContext();
                i12 = h.G;
            } else {
                context2 = getContext();
                i12 = h.E;
            }
            textView.setText(context2.getString(i12));
            return;
        }
        TextView textView2 = this.f17650c;
        if (sex == AccountConstant.Sex.MALE) {
            context = getContext();
            i11 = h.G;
        } else {
            context = getContext();
            i11 = h.E;
        }
        textView2.setText(context.getString(i11));
    }

    private void l(float f10) {
        String i10 = this.f17651d.i(f10);
        if (com.mobvoi.companion.base.settings.a.isUnitMetric(getContext())) {
            if (f10 > 0.0f) {
                this.f17650c.setText(i10);
            }
        } else if (!TextUtils.isEmpty(i10)) {
            this.f17650c.setText(i10);
        }
    }

    private void m(String str) {
        this.f17650c.setText(str);
    }

    private void n(int i10) {
        this.f17650c.setText(getContext().getString(h.Y, i10 > 0 ? String.valueOf(i10) : "10000"));
    }

    private void o() {
        String z10 = xd.c.x().z(getContext());
        String string = getContext().getString(h.J);
        if ("imperial".equals(z10)) {
            string = getContext().getString(h.I);
        }
        this.f17650c.setText(string);
    }

    private void p(float f10) {
        String g10 = this.f17651d.g(f10);
        if (com.mobvoi.companion.base.settings.a.isUnitMetric(getContext())) {
            if (f10 > 0.0f) {
                this.f17650c.setText(getContext().getString(h.A, Integer.valueOf((int) f10)));
            }
        } else if (!TextUtils.isEmpty(g10)) {
            this.f17650c.setText(g10);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.f17648a.setOnClickListener(onClickListener);
    }

    public void c(int i10, Object obj) {
        this.f17655h = i10;
        this.f17656i = obj;
        g(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(AttributeSet attributeSet, int i10) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, j.f5885a, i10, 0);
            this.f17652e = obtainStyledAttributes.getResourceId(j.f5888d, 0);
            this.f17653f = obtainStyledAttributes.getResourceId(j.f5889e, androidx.core.content.b.c(getContext(), f17647n));
            this.f17654g = obtainStyledAttributes.getResourceId(j.f5886b, -1);
            this.f17660m = obtainStyledAttributes.getBoolean(j.f5887c, true);
            obtainStyledAttributes.recycle();
        }
        if (this.f17657j == null) {
            this.f17657j = LayoutInflater.from(getContext());
        }
        e();
        this.f17651d = UnitPolicy.b();
        com.mobvoi.health.common.data.db.a z10 = ig.b.J().z();
        this.f17658k = z10;
        this.f17659l = nf.j.b(z10.t(), new j.a() { // from class: ae.a
            @Override // nf.j.a
            public final void call(Object obj) {
                HealthDataBindView.this.f((c.a) obj);
            }
        });
    }

    protected void e() {
        View inflate = LayoutInflater.from(getContext()).inflate(f.f5824r, (ViewGroup) this, true);
        this.f17648a = inflate;
        this.f17649b = (TextView) inflate.findViewById(e.f5801u);
        this.f17650c = (TextView) this.f17648a.findViewById(e.f5799s);
        this.f17649b.setTextColor(this.f17653f);
        this.f17649b.setText(this.f17652e);
        ImageView imageView = (ImageView) this.f17648a.findViewById(e.f5806z);
        int i10 = this.f17654g;
        if (i10 > 0) {
            imageView.setImageResource(i10);
            imageView.setVisibility(0);
            return;
        }
        imageView.setVisibility(8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f17659l.clear();
    }

    public void setValue(String str) {
        this.f17650c.setText(str);
    }
}
