package com.mobvoi.mcuwatch.ui.arty;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.mcuwatch.ui.arty.ArtyAboutActivity;
import sh.b;
import sh.d;
import sh.e;
import sh.f;
import sh.g;
import sh.h;
import sh.i;
import sh.k;
/* loaded from: classes2.dex */
public class ArtyAboutActivity extends com.mobvoi.companion.base.m3.a {

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f19281a;

    /* renamed from: b  reason: collision with root package name */
    TextView f19282b;

    /* renamed from: c  reason: collision with root package name */
    RelativeLayout f19283c;

    /* renamed from: d  reason: collision with root package name */
    TextView f19284d;

    /* renamed from: e  reason: collision with root package name */
    TextView f19285e;

    /* renamed from: f  reason: collision with root package name */
    ConstraintLayout f19286f;

    /* renamed from: g  reason: collision with root package name */
    View f19287g;

    /* renamed from: h  reason: collision with root package name */
    private int f19288h;

    /* renamed from: j  reason: collision with root package name */
    private Drawable[] f19290j;

    /* renamed from: k  reason: collision with root package name */
    private String[] f19291k;

    /* renamed from: l  reason: collision with root package name */
    private String[] f19292l;

    /* renamed from: m  reason: collision with root package name */
    private Typeface f19293m;

    /* renamed from: i  reason: collision with root package name */
    LinearLayout.LayoutParams f19289i = new LinearLayout.LayoutParams(-1, -2);

    /* renamed from: n  reason: collision with root package name */
    private boolean f19294n = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int measuredHeight = ArtyAboutActivity.this.f19281a.getMeasuredHeight();
            if (ArtyAboutActivity.this.f19285e.getVisibility() == 0) {
                measuredHeight += ArtyAboutActivity.this.f19285e.getMeasuredHeight();
            }
            Rect rect = new Rect();
            ArtyAboutActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = rect.top + ArtyAboutActivity.this.f19283c.getHeight() + measuredHeight;
            int i10 = rect.bottom;
            int dimension = (int) ArtyAboutActivity.this.getResources().getDimension(e.H0);
            int i11 = i10 - height;
            if (i11 > dimension) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) ArtyAboutActivity.this.f19287g.getLayoutParams();
                layoutParams.height = (i11 - dimension) + layoutParams.height;
                ArtyAboutActivity.this.f19287g.setLayoutParams(layoutParams);
            }
            float dimension2 = ArtyAboutActivity.this.getResources().getDimension(e.f34494j);
            int b10 = j7.a.b(ArtyAboutActivity.this, 16842801, -1);
            int b11 = j7.a.b(ArtyAboutActivity.this, 16842800, -16777216);
            RelativeLayout relativeLayout = new RelativeLayout(ArtyAboutActivity.this);
            relativeLayout.setBackgroundColor(b10);
            TextView textView = new TextView(ArtyAboutActivity.this);
            textView.setText(ArtyAboutActivity.this.getString(k.j_res_0x7f1400ca));
            textView.setTextColor(b11);
            textView.setTextSize(16.0f);
            textView.setTypeface(ArtyAboutActivity.this.f19293m);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(15);
            layoutParams2.leftMargin = (int) ArtyAboutActivity.this.getResources().getDimension(e.f34473c);
            layoutParams2.topMargin = (int) ArtyAboutActivity.this.getResources().getDimension(e.f34476d);
            relativeLayout.addView(textView, layoutParams2);
            View view = new View(ArtyAboutActivity.this);
            view.setBackgroundColor(ArtyAboutActivity.this.getResources().getColor(d.f34461u));
            int i12 = (int) dimension2;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i12);
            layoutParams3.topMargin = (int) ArtyAboutActivity.this.getResources().getDimension(e.f34470b);
            relativeLayout.addView(view, layoutParams3);
            ArtyAboutActivity artyAboutActivity = ArtyAboutActivity.this;
            artyAboutActivity.f19281a.addView(relativeLayout, artyAboutActivity.f19289i);
            int dimension3 = (int) ArtyAboutActivity.this.getResources().getDimension(e.f34488h);
            int dimension4 = (int) ArtyAboutActivity.this.getResources().getDimension(e.f34491i);
            int dimension5 = (int) ArtyAboutActivity.this.getResources().getDimension(e.f34482f);
            for (int i13 = 0; i13 < ArtyAboutActivity.this.f19291k.length; i13++) {
                RelativeLayout relativeLayout2 = new RelativeLayout(ArtyAboutActivity.this);
                relativeLayout2.setBackgroundColor(b10);
                TextView textView2 = new TextView(ArtyAboutActivity.this);
                textView2.setText(ArtyAboutActivity.this.f19291k[i13]);
                textView2.setTextColor(b11);
                textView2.setTextSize(24.0f);
                textView2.setTypeface(ArtyAboutActivity.this.f19293m);
                RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams4.leftMargin = dimension4;
                layoutParams4.topMargin = dimension3;
                layoutParams4.bottomMargin = dimension3;
                layoutParams4.addRule(15);
                relativeLayout2.addView(textView2, layoutParams4);
                ImageView imageView = new ImageView(ArtyAboutActivity.this);
                imageView.setBackground(ArtyAboutActivity.this.f19290j[i13]);
                RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams5.leftMargin = dimension5;
                layoutParams5.addRule(15);
                relativeLayout2.addView(imageView, layoutParams5);
                TextView textView3 = new TextView(ArtyAboutActivity.this);
                textView3.setText(ArtyAboutActivity.this.f19288h == 3 ? ArtyAboutActivity.this.f19292l[3 - i13] : ArtyAboutActivity.this.f19292l[i13]);
                textView3.setTextColor(b11);
                textView3.setTextSize(18.0f);
                textView3.setTypeface(ArtyAboutActivity.this.f19293m);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams6.rightMargin = dimension5;
                layoutParams6.addRule(15);
                layoutParams6.addRule(11);
                relativeLayout2.addView(textView3, layoutParams6);
                if (i13 < 3) {
                    View view2 = new View(ArtyAboutActivity.this);
                    view2.setBackgroundColor(ArtyAboutActivity.this.getResources().getColor(d.f34461u));
                    RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, i12);
                    layoutParams7.topMargin = (int) ArtyAboutActivity.this.getResources().getDimension(e.f34485g);
                    layoutParams7.leftMargin = dimension5;
                    layoutParams7.rightMargin = dimension5;
                    relativeLayout2.addView(view2, layoutParams7);
                }
                ArtyAboutActivity artyAboutActivity2 = ArtyAboutActivity.this;
                artyAboutActivity2.f19281a.addView(relativeLayout2, artyAboutActivity2.f19289i);
            }
            View view3 = new View(ArtyAboutActivity.this);
            view3.setBackgroundColor(b10);
            ArtyAboutActivity.this.f19281a.addView(view3, new LinearLayout.LayoutParams(-1, -1));
            if (Build.VERSION.SDK_INT >= 16) {
                ArtyAboutActivity.this.f19282b.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                ArtyAboutActivity.this.f19282b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    private void M() {
        this.f19282b.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        finish();
    }

    private void Q(String str, int i10, String str2) {
        this.f19284d.setText(str);
        if (i10 > 0) {
            this.f19284d.setCompoundDrawablesWithIntrinsicBounds(0, i10, 0, 0);
            TextView textView = this.f19284d;
            Resources resources = getResources();
            int i11 = e.S0;
            textView.setPadding(0, (int) (resources.getDimension(i11) * 2.0f), 0, (int) getResources().getDimension(i11));
        }
        this.f19282b.setText(str2);
    }

    public static void S(Context context, int i10) {
        Intent intent = new Intent(context, ArtyAboutActivity.class);
        intent.putExtra("data_type", i10);
        context.startActivity(intent);
    }

    protected void N() {
        this.f19291k = getResources().getStringArray(b.m_res_0x7f030015);
        this.f19292l = getResources().getStringArray(b.n_res_0x7f030016);
        this.f19290j = new Drawable[]{getResources().getDrawable(f.f34606z1), getResources().getDrawable(f.f34603y1), getResources().getDrawable(f.B1), getResources().getDrawable(f.A1)};
        this.f19288h = getIntent().getIntExtra("data_type", 0);
    }

    protected void initView() {
        setContentView(i.g_res_0x7f0e0025);
        this.f19283c = (RelativeLayout) findViewById(h.f34675o3);
        this.f19284d = (TextView) findViewById(h.f34671n3);
        this.f19281a = (LinearLayout) findViewById(h.B0);
        this.f19282b = (TextView) findViewById(h.f34706v3);
        this.f19285e = (TextView) findViewById(h.f34711w3);
        this.f19286f = (ConstraintLayout) findViewById(h.a_res_0x7f0b0020);
        this.f19287g = findViewById(h.S0);
        findViewById(h.P).setOnClickListener(new View.OnClickListener() { // from class: ri.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtyAboutActivity.this.O(view);
            }
        });
        Typeface h10 = a0.h.h(this, g.f34608b);
        this.f19293m = h10;
        this.f19284d.setTypeface(h10);
        this.f19284d.setTextSize(2, 24.0f);
        int i10 = this.f19288h;
        if (i10 == 0) {
            this.f19285e.setVisibility(0);
            Q(getString(k.s_res_0x7f1400d9), f.L0, getString(k.r_res_0x7f1400d7));
            M();
        } else if (i10 == 1) {
            Q(getString(k.u_res_0x7f1400db), f.f34567m1, getString(k.t_res_0x7f1400da));
        } else if (i10 == 2) {
            Q(getString(k.m_res_0x7f1400d2), f.X0, getString(k.l_res_0x7f1400d1));
            M();
        } else if (i10 == 3) {
            Q(getString(k.o_res_0x7f1400d4), f.f34537c1, getString(k.n_res_0x7f1400d3));
            M();
        } else if (i10 == 4) {
            Q(getString(k.h_res_0x7f1400c8), f.G0, getString(k.g_res_0x7f1400c7));
        } else if (i10 == 5) {
            Q(getString(k.q_res_0x7f1400d6), -1, getString(k.k_res_0x7f1400cd));
            this.f19286f.setVisibility(0);
        }
        this.f19294n = true;
    }

    @Override // com.mobvoi.companion.base.m3.a
    public boolean needFitsSystemWindows() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        N();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (!this.f19294n) {
            initView();
        }
    }
}
