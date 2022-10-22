package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.h;
/* loaded from: classes2.dex */
public final class x extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f24134a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f24135b;

    private x(Context context, Drawable drawable) {
        super(context);
        this.f24134a = null;
        this.f24135b = null;
        this.f24134a = context;
        setOrientation(0);
        Context context2 = this.f24134a;
        if (drawable != null) {
            ImageView imageView = new ImageView(context2);
            imageView.setBackgroundDrawable(drawable);
            int i10 = b.f23350o;
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i10, i10);
            layoutParams.gravity = 16;
            addView(imageView, layoutParams);
        }
        this.f24135b = new TextView(context2);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        if (drawable != null) {
            layoutParams2.leftMargin = a.f23313d;
        }
        addView(this.f24135b, layoutParams2);
    }

    public static x a(Context context, Drawable drawable) {
        x xVar = new x(context, drawable);
        TextView textView = xVar.f24135b;
        if (textView != null) {
            textView.setTextSize(16.0f);
        }
        xVar.a(h.a(-16758391, -65536));
        return xVar;
    }

    public final void a(ColorStateList colorStateList) {
        TextView textView = this.f24135b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final void a(CharSequence charSequence) {
        TextView textView = this.f24135b;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f24135b;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }
}
