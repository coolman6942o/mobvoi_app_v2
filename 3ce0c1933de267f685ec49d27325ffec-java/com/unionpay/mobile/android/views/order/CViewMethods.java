package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.g;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class CViewMethods extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final Integer f24177a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final Integer f24178b = -2;

    /* renamed from: c  reason: collision with root package name */
    private static final int f24179c = b.f23336a;

    /* renamed from: d  reason: collision with root package name */
    private Context f24180d;

    /* renamed from: e  reason: collision with root package name */
    private int f24181e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f24182f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap<Integer, String> f24183g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap<Integer, Drawable> f24184h;

    /* renamed from: i  reason: collision with root package name */
    private String f24185i;

    /* renamed from: j  reason: collision with root package name */
    private a f24186j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f24187k;

    /* loaded from: classes2.dex */
    public interface a {
        void c(int i10);
    }

    public CViewMethods(Context context) {
        this(context, null);
    }

    public CViewMethods(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CViewMethods(Context context, AttributeSet attributeSet, int i10) {
        super(context);
        this.f24180d = context;
        this.f24181e = l.f24227a.intValue();
        setOrientation(1);
    }

    private void a(LinearLayout linearLayout, int i10) {
        String str;
        Drawable drawable;
        float f10 = b.f23346k;
        RelativeLayout relativeLayout = new RelativeLayout(this.f24180d);
        relativeLayout.setClickable(true);
        Drawable drawable2 = this.f24187k;
        if (drawable2 != null) {
            relativeLayout.setBackgroundDrawable(drawable2.getConstantState().newDrawable());
        }
        relativeLayout.setOnClickListener(new h(this, i10));
        Integer num = f24177a;
        linearLayout.addView(relativeLayout, new LinearLayout.LayoutParams(num.intValue(), b.f23349n));
        ImageView imageView = new ImageView(this.f24180d);
        imageView.setId(imageView.hashCode());
        HashMap<Integer, Drawable> hashMap = this.f24184h;
        if (!(hashMap == null || (drawable = hashMap.get(Integer.valueOf(i10))) == null)) {
            imageView.setBackgroundDrawable(drawable);
        }
        int a10 = g.a(this.f24180d, 15.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a10, a10);
        layoutParams.addRule(15, -1);
        layoutParams.addRule(11, -1);
        int i11 = f24179c;
        layoutParams.rightMargin = i11;
        relativeLayout.addView(imageView, layoutParams);
        TextView textView = new TextView(this.f24180d);
        textView.setClickable(false);
        textView.setTextSize(f10);
        textView.setTextColor(-13421773);
        HashMap<Integer, String> hashMap2 = this.f24183g;
        if (!(hashMap2 == null || (str = hashMap2.get(Integer.valueOf(i10))) == null)) {
            textView.setText(Html.fromHtml(str));
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(num.intValue(), f24178b.intValue());
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(0, imageView.getId());
        layoutParams2.leftMargin = i11;
        relativeLayout.addView(textView, layoutParams2);
    }

    public final CViewMethods a(int i10) {
        if (i10 > 0) {
            this.f24181e = i10;
        }
        return this;
    }

    public final CViewMethods a(Drawable drawable) {
        this.f24187k = drawable;
        return this;
    }

    public final CViewMethods a(a aVar) {
        this.f24186j = aVar;
        return this;
    }

    public final CViewMethods a(String str) {
        this.f24185i = str;
        return this;
    }

    public final CViewMethods a(HashMap<Integer, String> hashMap) {
        this.f24183g = hashMap;
        return this;
    }

    public final void a() {
        TextView textView;
        removeAllViews();
        if (this.f24181e == l.f24227a.intValue()) {
            setVisibility(8);
            return;
        }
        TextView textView2 = new TextView(this.f24180d);
        this.f24182f = textView2;
        textView2.setTextColor(-13421773);
        this.f24182f.setTextSize(b.f23346k);
        String str = this.f24185i;
        if (!(str == null || (textView = this.f24182f) == null)) {
            textView.setText(str);
        }
        this.f24182f.setGravity(19);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(f24177a.intValue(), f24178b.intValue());
        layoutParams.gravity = 19;
        int i10 = f24179c;
        layoutParams.topMargin = i10;
        layoutParams.leftMargin = g.a(this.f24180d, 10.0f);
        addView(this.f24182f, layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.f24180d);
        linearLayout.setBackgroundColor(-3419943);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams2.topMargin = i10;
        addView(linearLayout, layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout linearLayout2 = new LinearLayout(this.f24180d);
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(-1);
        addView(linearLayout2, layoutParams3);
        Integer num = l.f24228b;
        if (num.intValue() == (num.intValue() & this.f24181e)) {
            a(linearLayout2, num.intValue());
        }
        Integer num2 = l.f24229c;
        if (num2.intValue() == (num2.intValue() & this.f24181e)) {
            a(linearLayout2, num2.intValue());
        }
        Integer num3 = l.f24231e;
        if (num3.intValue() == (num3.intValue() & this.f24181e)) {
            LinearLayout linearLayout3 = new LinearLayout(this.f24180d);
            linearLayout3.setBackgroundColor(-3419943);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams4.leftMargin = g.a(this.f24180d, 10.0f);
            linearLayout2.addView(linearLayout3, layoutParams4);
            a(linearLayout2, num3.intValue());
        }
        Integer num4 = l.f24230d;
        if (num4.intValue() == (num4.intValue() & this.f24181e)) {
            LinearLayout linearLayout4 = new LinearLayout(this.f24180d);
            linearLayout4.setBackgroundColor(-3419943);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams5.leftMargin = g.a(this.f24180d, 10.0f);
            linearLayout2.addView(linearLayout4, layoutParams5);
            a(linearLayout2, num4.intValue());
        }
        Integer num5 = l.f24232f;
        if (num5.intValue() == (num5.intValue() & this.f24181e)) {
            LinearLayout linearLayout5 = new LinearLayout(this.f24180d);
            linearLayout5.setBackgroundColor(-3419943);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, 1);
            layoutParams6.leftMargin = g.a(this.f24180d, 10.0f);
            linearLayout2.addView(linearLayout5, layoutParams6);
            a(linearLayout2, num5.intValue());
        }
        LinearLayout linearLayout6 = new LinearLayout(this.f24180d);
        linearLayout6.setBackgroundColor(-3419943);
        addView(linearLayout6, new LinearLayout.LayoutParams(-1, 1));
    }

    public final CViewMethods b(HashMap<Integer, Drawable> hashMap) {
        this.f24184h = hashMap;
        return this;
    }
}
