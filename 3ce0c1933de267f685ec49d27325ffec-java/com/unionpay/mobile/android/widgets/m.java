package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.realsil.sdk.dfu.DfuException;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public final class m {

    /* renamed from: k  reason: collision with root package name */
    private static final float f24413k;

    /* renamed from: l  reason: collision with root package name */
    private static final float f24414l;

    /* renamed from: m  reason: collision with root package name */
    private static final float f24415m = b.f23345j;

    /* renamed from: a  reason: collision with root package name */
    private Context f24416a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f24417b;

    /* renamed from: c  reason: collision with root package name */
    private WeakReference<View.OnClickListener> f24418c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f24419d;

    /* renamed from: e  reason: collision with root package name */
    private WeakReference<View.OnClickListener> f24420e;

    /* renamed from: f  reason: collision with root package name */
    private int f24421f;

    /* renamed from: g  reason: collision with root package name */
    private c f24422g;

    /* renamed from: h  reason: collision with root package name */
    private Dialog f24423h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f24424i;

    /* renamed from: j  reason: collision with root package name */
    private WeakReference<DialogInterface.OnDismissListener> f24425j;

    static {
        float f10 = b.f23346k;
        f24413k = f10;
        f24414l = f10;
    }

    public m(Context context) {
        this(context, (byte) 0);
    }

    private m(Context context, byte b10) {
        this.f24416a = null;
        this.f24417b = null;
        this.f24418c = null;
        this.f24419d = null;
        this.f24420e = null;
        this.f24421f = 0;
        this.f24422g = null;
        this.f24423h = null;
        this.f24424i = null;
        this.f24425j = null;
        this.f24416a = context;
        this.f24425j = new WeakReference<>(null);
        c a10 = c.a(context);
        this.f24422g = a10;
        int i10 = a.I - (a.f23311b * 4);
        this.f24421f = i10;
        this.f24424i = a10.a(DfuException.ERROR_GATT_INVALID_PDU, i10 / 2, -1);
    }

    private RelativeLayout a(Context context) {
        c();
        this.f24423h = new n(this, context);
        WeakReference<DialogInterface.OnDismissListener> weakReference = this.f24425j;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.f24423h.setOnDismissListener(this.f24425j.get());
        }
        this.f24423h.setCanceledOnTouchOutside(false);
        this.f24423h.setOwnerActivity((Activity) context);
        this.f24423h.requestWindowFeature(1);
        this.f24423h.getWindow().setBackgroundDrawable(this.f24422g.a(4004, -1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(this.f24416a);
        this.f24423h.getWindow().setBackgroundDrawable(this.f24422g.a(4004, -1, -1));
        this.f24423h.setContentView(relativeLayout, new RelativeLayout.LayoutParams(this.f24421f, -2));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f24416a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        relativeLayout.addView(relativeLayout2, layoutParams);
        return relativeLayout;
    }

    private boolean d() {
        return ((Activity) this.f24416a).isFinishing();
    }

    public final void a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f24418c = new WeakReference<>(onClickListener);
        this.f24420e = new WeakReference<>(onClickListener2);
    }

    public final void a(String str) {
        int a10 = g.a(this.f24416a, 12.0f);
        g.a(this.f24416a, 20.0f);
        RelativeLayout a11 = a(this.f24416a);
        a11.setBackgroundColor(a.M);
        Dialog dialog = this.f24423h;
        if (dialog != null) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.alpha = 0.7f;
            this.f24423h.getWindow().setAttributes(attributes);
        }
        LinearLayout linearLayout = new LinearLayout(this.f24416a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int i10 = this.f24421f - (a.f23319j << 1);
        ImageView imageView = new ImageView(this.f24416a);
        imageView.setImageDrawable(this.f24424i);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i10, -2));
        TextView textView = new TextView(this.f24416a);
        textView.setTextSize(f24414l);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = a10;
        linearLayout.addView(textView, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.f24416a);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        int i11 = a.f23325p;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i11, i11);
        layoutParams2.topMargin = a10;
        linearLayout.addView(new ProgressBar(this.f24416a), layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(10, -1);
        layoutParams3.addRule(14, -1);
        int a12 = g.a(this.f24416a, 20.0f);
        a11.setPadding(a12, a12, a12, a12);
        a11.addView(linearLayout, layoutParams3);
        Dialog dialog2 = this.f24423h;
        if (dialog2 != null && !dialog2.isShowing() && !d()) {
            this.f24423h.show();
        }
    }

    public final void a(String str, String str2, String str3) {
        RelativeLayout a10 = a(this.f24416a);
        int i10 = a.f23311b;
        LinearLayout linearLayout = new LinearLayout(this.f24416a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        a10.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        if (!(str == null || str.length() == 0)) {
            TextView textView = new TextView(this.f24416a);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(f24413k);
            textView.setTextColor(-13421773);
            textView.setText(str);
            textView.setGravity(17);
            textView.setPadding(i10, i10 << 1, i10, i10);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        }
        TextView textView2 = new TextView(this.f24416a);
        textView2.setTextSize(f24414l);
        textView2.setTextColor(-13421773);
        textView2.setText(str2);
        textView2.setPadding(i10, i10, i10, 0);
        textView2.setGravity(17);
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.f24416a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = a.f23311b << 1;
        linearLayout.addView(frameLayout, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.f24416a);
        linearLayout2.setOrientation(1);
        frameLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout3 = new LinearLayout(this.f24416a);
        linearLayout3.setOrientation(0);
        linearLayout3.setBackgroundColor(-7829368);
        new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.f24416a);
        linearLayout2.addView(linearLayout4, new LinearLayout.LayoutParams(-1, -2));
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(17);
        TextView textView3 = new TextView(this.f24416a);
        this.f24417b = textView3;
        textView3.setPadding(5, 5, 5, 5);
        this.f24417b.getPaint().setFakeBoldText(true);
        this.f24417b.setText(str3);
        this.f24417b.setTextSize(f24415m);
        this.f24417b.setTextColor(h.a(-15364869, -5846275));
        this.f24417b.setGravity(17);
        int i11 = a.f23324o;
        WeakReference<View.OnClickListener> weakReference = this.f24418c;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.f24417b.setOnClickListener(this.f24418c.get());
        }
        linearLayout4.addView(this.f24417b, new LinearLayout.LayoutParams(-1, i11));
        frameLayout.addView(new o(this.f24416a), new FrameLayout.LayoutParams(-1, a.H));
        Dialog dialog = this.f24423h;
        if (dialog != null && !dialog.isShowing() && !d()) {
            this.f24423h.show();
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, str4, true);
    }

    public final void a(String str, String str2, String str3, String str4, boolean z10) {
        RelativeLayout a10 = a(this.f24416a);
        int i10 = a.f23311b;
        LinearLayout linearLayout = new LinearLayout(this.f24416a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        a10.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        if (!(str == null || str.length() == 0)) {
            TextView textView = new TextView(this.f24416a);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(f24413k);
            textView.setTextColor(-13421773);
            textView.setText(str);
            textView.setGravity(17);
            textView.setPadding(i10, i10 << 1, i10, i10);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        }
        TextView textView2 = new TextView(this.f24416a);
        textView2.setTextSize(f24414l);
        textView2.setTextColor(-13421773);
        textView2.setText(str2);
        textView2.setPadding(i10, i10, i10, 0);
        textView2.setGravity(17);
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        int a11 = g.a(this.f24416a, 1.0f);
        LinearLayout linearLayout2 = new LinearLayout(this.f24416a);
        linearLayout2.setOrientation(0);
        linearLayout2.setBackgroundColor(-7829368);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, a11);
        layoutParams.topMargin = a.f23311b << 1;
        linearLayout.addView(linearLayout2, layoutParams);
        LinearLayout linearLayout3 = new LinearLayout(this.f24416a);
        linearLayout3.setBackgroundColor(-1);
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(17);
        int i11 = (this.f24421f - a.H) >> 1;
        TextView textView3 = new TextView(this.f24416a);
        this.f24417b = textView3;
        if (!z10) {
            textView3.getPaint().setFakeBoldText(true);
        }
        this.f24417b.setText(str3);
        TextView textView4 = this.f24417b;
        float f10 = f24415m;
        textView4.setTextSize(f10);
        this.f24417b.setTextColor(h.a(-15364869, -5846275));
        this.f24417b.setGravity(17);
        int i12 = a.f23324o;
        WeakReference<View.OnClickListener> weakReference = this.f24418c;
        if (!(weakReference == null || weakReference.get() == null)) {
            this.f24417b.setOnClickListener(this.f24418c.get());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i11, i12);
        layoutParams2.leftMargin = 5;
        layoutParams2.bottomMargin = 5;
        linearLayout3.addView(this.f24417b, layoutParams2);
        LinearLayout linearLayout4 = new LinearLayout(this.f24416a);
        linearLayout4.setOrientation(1);
        linearLayout4.setBackgroundColor(-7829368);
        linearLayout3.addView(linearLayout4, new LinearLayout.LayoutParams(a11, -1));
        TextView textView5 = new TextView(this.f24416a);
        this.f24419d = textView5;
        if (z10) {
            textView5.getPaint().setFakeBoldText(true);
        }
        this.f24419d.setText(str4);
        this.f24419d.setTextSize(f10);
        this.f24419d.setTextColor(h.a(-15364869, -5846275));
        this.f24419d.setGravity(17);
        WeakReference<View.OnClickListener> weakReference2 = this.f24420e;
        if (!(weakReference2 == null || weakReference2.get() == null)) {
            this.f24419d.setOnClickListener(this.f24420e.get());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i11, i12);
        layoutParams3.leftMargin = 5;
        layoutParams3.bottomMargin = 5;
        linearLayout3.addView(this.f24419d, layoutParams3);
        Dialog dialog = this.f24423h;
        if (dialog != null && !dialog.isShowing() && !d()) {
            this.f24423h.show();
        }
    }

    public final boolean a() {
        Dialog dialog = this.f24423h;
        return dialog != null && dialog.isShowing();
    }

    public final void b() {
        Dialog dialog = this.f24423h;
        if (dialog != null) {
            dialog.hide();
            this.f24423h.show();
        }
    }

    public final void c() {
        Dialog dialog = this.f24423h;
        if (dialog != null && dialog.isShowing()) {
            this.f24423h.dismiss();
            this.f24423h = null;
        }
    }
}
