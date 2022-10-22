package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
/* loaded from: classes2.dex */
public final class ay extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f24331a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f24332b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f24333c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f24334d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f24335e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f24336f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f24337g;

    /* renamed from: h  reason: collision with root package name */
    private int f24338h;

    /* renamed from: i  reason: collision with root package name */
    private int f24339i;

    /* renamed from: j  reason: collision with root package name */
    private int f24340j;

    /* renamed from: k  reason: collision with root package name */
    private a f24341k;

    /* loaded from: classes2.dex */
    public interface a {
        void l();
    }

    public ay(Context context, String str, Drawable drawable, int i10, a aVar) {
        super(context);
        this.f24331a = null;
        this.f24332b = null;
        this.f24333c = null;
        this.f24334d = null;
        this.f24335e = null;
        this.f24338h = 0;
        this.f24339i = 0;
        this.f24340j = 0;
        this.f24331a = context;
        this.f24341k = aVar;
        this.f24340j = g.a(context, 10.0f);
        this.f24335e = drawable;
        this.f24338h = i10;
        b(str);
    }

    public ay(Context context, String str, a aVar) {
        this(context, str, aVar, (byte) 0);
    }

    private ay(Context context, String str, a aVar, byte b10) {
        super(context);
        this.f24331a = null;
        this.f24332b = null;
        this.f24333c = null;
        this.f24334d = null;
        this.f24335e = null;
        this.f24338h = 0;
        this.f24339i = 0;
        this.f24340j = 0;
        this.f24331a = context;
        this.f24341k = aVar;
        this.f24340j = g.a(context, 10.0f);
        b(str);
    }

    private void b(String str) {
        this.f24339i = com.unionpay.mobile.android.global.a.f23320k;
        setLayoutParams(new RelativeLayout.LayoutParams(-1, this.f24339i));
        setBackgroundColor(com.unionpay.mobile.android.global.a.M);
        c a10 = c.a(this.f24331a);
        LinearLayout linearLayout = new LinearLayout(this.f24331a);
        this.f24337g = linearLayout;
        linearLayout.setOnClickListener(new az(this));
        LinearLayout linearLayout2 = this.f24337g;
        int i10 = this.f24340j;
        linearLayout2.setPadding(i10, i10, i10, i10);
        this.f24337g.setGravity(16);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        addView(this.f24337g, layoutParams);
        int a11 = g.a(this.f24331a, 20.0f);
        int a12 = g.a(this.f24331a, 11.0f);
        int i11 = this.f24338h;
        if (i11 != 0) {
            a12 = i11;
        }
        ImageView imageView = new ImageView(this.f24331a);
        Drawable drawable = this.f24335e;
        if (drawable == null) {
            drawable = a10.a(1029, -1, -1);
        }
        imageView.setBackgroundDrawable(drawable);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a12, a11);
        layoutParams2.addRule(15, -1);
        this.f24337g.addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.unionpay.mobile.android.global.a.f23321l, this.f24339i);
        layoutParams3.addRule(13, -1);
        TextView textView = new TextView(this.f24331a);
        this.f24334d = textView;
        textView.setTextSize(20.0f);
        this.f24334d.setTextColor(-1);
        this.f24334d.setText(str);
        this.f24334d.setGravity(17);
        this.f24334d.setSingleLine(true);
        this.f24334d.setEllipsize(TextUtils.TruncateAt.END);
        addView(this.f24334d, layoutParams3);
        if (!TextUtils.isEmpty(null)) {
            int i12 = com.unionpay.mobile.android.global.a.f23314e;
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, this.f24339i);
            layoutParams4.addRule(11, -1);
            layoutParams4.addRule(15, -1);
            layoutParams4.rightMargin = i12;
            TextView textView2 = new TextView(this.f24331a);
            this.f24332b = textView2;
            textView2.setTextSize(16.0f);
            this.f24332b.setTextColor(-1);
            this.f24332b.setText((CharSequence) null);
            this.f24332b.setGravity(16);
            TextView textView3 = this.f24332b;
            textView3.setId(textView3.hashCode());
            addView(this.f24332b, layoutParams4);
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(com.unionpay.mobile.android.global.a.H, com.unionpay.mobile.android.global.a.f23322m);
            layoutParams5.addRule(0, this.f24332b.getId());
            layoutParams5.addRule(15, -1);
            layoutParams5.rightMargin = i12;
            addView(new o(this.f24331a, com.unionpay.mobile.android.global.a.N, 1), layoutParams5);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(com.unionpay.mobile.android.global.a.E, com.unionpay.mobile.android.global.a.D);
        layoutParams6.addRule(11, -1);
        layoutParams6.addRule(15, -1);
        layoutParams6.rightMargin = this.f24340j;
        Drawable a13 = a10.a(1031, -1, -1);
        ImageView imageView2 = new ImageView(this.f24331a);
        this.f24336f = imageView2;
        imageView2.setBackgroundDrawable(a13);
        addView(this.f24336f, layoutParams6);
        int i13 = com.unionpay.mobile.android.global.a.D;
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(i13, i13);
        layoutParams7.addRule(11, -1);
        layoutParams7.addRule(15, -1);
        layoutParams7.rightMargin = this.f24340j;
        ImageView imageView3 = new ImageView(this.f24331a);
        this.f24333c = imageView3;
        addView(imageView3, layoutParams7);
    }

    public final void a() {
        LinearLayout linearLayout = this.f24337g;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void a(int i10) {
        ImageView imageView;
        ImageView imageView2 = this.f24333c;
        if (imageView2 != null) {
            int i11 = 8;
            if (i10 == 0) {
                this.f24336f.setVisibility(8);
                imageView = this.f24333c;
            } else {
                imageView2.setVisibility(8);
                imageView = this.f24336f;
                i11 = 0;
            }
            imageView.setVisibility(i11);
            this.f24333c.setVisibility(i10);
        }
    }

    public final void a(String str) {
        TextView textView = this.f24334d;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
