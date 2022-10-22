package com.mobvoi.mcuwatch.ui.arty.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtySelectCommonView;
import com.mobvoi.wear.util.DimensionUtils;
import sh.c;
import sh.d;
import sh.f;
import sh.g;
import sh.h;
import sh.i;
/* loaded from: classes2.dex */
public class ArtySelectCommonView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f19439a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f19440b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f19441c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f19442d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f19443e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f19444f;

    /* renamed from: g  reason: collision with root package name */
    private a f19445g;

    /* renamed from: h  reason: collision with root package name */
    private Typeface f19446h;

    /* renamed from: i  reason: collision with root package name */
    private int f19447i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface a {
        void a(int i10);
    }

    public ArtySelectCommonView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        if (this.f19442d.getVisibility() == 8) {
            this.f19443e.setBackgroundResource(f.N0);
            this.f19442d.setVisibility(0);
            return;
        }
        this.f19443e.setBackgroundResource(f.I0);
        this.f19442d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(TextView textView, View view) {
        this.f19443e.setBackgroundResource(f.I0);
        this.f19440b.setText(textView.getText());
        this.f19442d.setVisibility(8);
        this.f19445g.a(((Integer) textView.getTag()).intValue());
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(getResources().getColor(d.f34449i, null));
        gradientDrawable.setCornerRadius(DimensionUtils.dp2px(this.f19439a, 15.0f));
        setBackground(gradientDrawable);
        LayoutInflater.from(this.f19439a).inflate(i.M0, (ViewGroup) this, true);
        this.f19440b = (TextView) findViewById(h.R2);
        this.f19441c = (RelativeLayout) findViewById(h.H2);
        this.f19442d = (LinearLayout) findViewById(h.f34617b2);
        this.f19443e = (ImageView) findViewById(h.f34688r1);
        Typeface h10 = a0.h.h(this.f19439a, g.f34608b);
        this.f19446h = h10;
        this.f19440b.setTypeface(h10, 1);
        this.f19441c.setOnClickListener(new View.OnClickListener() { // from class: ui.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ArtySelectCommonView.this.c(view);
            }
        });
    }

    public void setItemSelectListener(a aVar) {
        this.f19445g = aVar;
    }

    public void setSelectItem(String[] strArr) {
        if (strArr != null && strArr.length > 0) {
            this.f19444f = strArr;
            this.f19440b.setText(strArr[0]);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            int i10 = 0;
            for (String str : strArr) {
                final TextView textView = new TextView(this.f19439a);
                textView.setText(str);
                textView.setTextSize(2, 16.0f);
                textView.setTextColor(this.f19447i);
                textView.setGravity(17);
                textView.setTag(Integer.valueOf(i10));
                textView.setTypeface(this.f19446h, 1);
                textView.setPadding(0, 10, 0, 10);
                textView.setOnClickListener(new View.OnClickListener() { // from class: ui.k
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ArtySelectCommonView.this.d(textView, view);
                    }
                });
                this.f19442d.addView(textView, layoutParams);
                i10++;
            }
        }
    }

    public ArtySelectCommonView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19439a = context;
        this.f19447i = j7.a.e(this, c.f34440b, -7829368);
    }
}
