package com.paypal.android.sdk;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.text.method.LinkMovementMethod;
import android.util.Base64;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public final class u1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Map f22008a;

    /* renamed from: b  reason: collision with root package name */
    private static Pattern f22009b = Pattern.compile("^\\s*(\\d+(\\.\\d+)*)\\s*([a-zA-Z]+)\\s*$");

    /* renamed from: c  reason: collision with root package name */
    private static HashMap f22010c = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("px", 0);
        hashMap.put("dip", 1);
        hashMap.put("dp", 1);
        hashMap.put("sp", 2);
        hashMap.put("pt", 3);
        hashMap.put("in", 4);
        hashMap.put("mm", 5);
        f22008a = Collections.unmodifiableMap(hashMap);
    }

    public static void A(TextView textView, int i10) {
        textView.setTextSize(18.0f);
        textView.setTypeface(t1.B);
        textView.setSingleLine(true);
        textView.setGravity(i10);
        textView.setTextColor(t1.f21993t);
    }

    public static Bitmap B(String str, Context context) {
        return b(str, context, 240);
    }

    public static void C(TextView textView, int i10) {
        textView.setTextSize(16.0f);
        textView.setTypeface(t1.C);
        textView.setSingleLine(true);
        textView.setGravity(83);
        textView.setTextColor(t1.f21993t);
    }

    public static void D(TextView textView, int i10) {
        textView.setTextSize(14.0f);
        textView.setTypeface(t1.D);
        textView.setSingleLine(true);
        textView.setGravity(i10);
        textView.setTextColor(t1.f21993t);
    }

    public static void E(TextView textView, int i10) {
        textView.setTextSize(13.0f);
        textView.setTypeface(t1.D);
        textView.setSingleLine(true);
        textView.setGravity(83);
        textView.setTextColor(t1.f21993t);
    }

    public static int a(String str, Context context) {
        if (str == null) {
            return 0;
        }
        return (int) v(str, context);
    }

    public static Bitmap b(String str, Context context, int i10) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inTargetDensity = context != null ? context.getResources().getDisplayMetrics().densityDpi : 160;
        options.inDensity = 240;
        options.inScaled = false;
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
    }

    public static View c(LinearLayout linearLayout) {
        View view = new View(linearLayout.getContext());
        linearLayout.addView(view);
        view.setBackground(new ColorDrawable(t1.f21992s));
        n(view, -1, "1dip");
        y(view, null, "12dip", null, "12dip");
        return view;
    }

    public static ViewGroup.LayoutParams d() {
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public static ViewGroup e(Context context) {
        ScrollView scrollView = new ScrollView(context);
        scrollView.setBackgroundColor(t1.f21982i);
        return scrollView;
    }

    public static ImageView f(Context context, String str, String str2) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setImageBitmap(B(str, context));
        imageView.setAdjustViewBounds(true);
        imageView.setContentDescription(str2);
        return imageView;
    }

    public static LinearLayout g(Context context, boolean z10, int i10, LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(context);
        if (i10 != 0) {
            linearLayout2.setId(i10);
        }
        linearLayout.addView(linearLayout2);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(0);
        r(linearLayout2, z10, context);
        n(linearLayout2, -1, "58dip");
        y(linearLayout2, null, null, null, "4dip");
        return linearLayout2;
    }

    public static LinearLayout h(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(t1.f21982i);
        viewGroup.addView(linearLayout);
        m(linearLayout, -1, -2);
        return linearLayout;
    }

    public static RelativeLayout.LayoutParams i(int i10, int i11, int i12, int i13) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(i12, i13);
        return layoutParams;
    }

    public static RelativeLayout.LayoutParams j(Context context, String str, String str2, int i10) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a(str, context), a(str2, context));
        layoutParams.addRule(i10);
        return layoutParams;
    }

    public static void k(View view) {
        y(view, "4dip", null, "4dip", null);
    }

    public static void l(View view, int i10, float f10) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = i10;
            layoutParams2.weight = f10;
        }
    }

    public static void m(View view, int i10, int i11) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i10;
        layoutParams.height = i11;
    }

    public static void n(View view, int i10, String str) {
        m(view, i10, a(str, view.getContext()));
    }

    public static void o(View view, String str, int i10) {
        m(view, a(str, view.getContext()), -2);
    }

    public static void p(View view, String str, String str2) {
        y(view, "4dip", str, "4dip", str2);
    }

    public static void q(View view, String str, String str2, String str3, String str4) {
        Context context = view.getContext();
        view.setPadding(a(str, context), a(str2, context), a(str3, context), a(str4, context));
    }

    public static void r(View view, boolean z10, Context context) {
        m(view, -1, -2);
        q(view, "10dip", "0dip", "10dip", "0dip");
        view.setBackground(z10 ? t1.c(context) : t1.d(context));
        view.setFocusable(true);
        view.setMinimumHeight(a("54dip", context));
        if (view instanceof TextView) {
            t((TextView) view);
        }
        if (!(view instanceof Button)) {
            view.setClickable(true);
        }
    }

    public static void s(Button button) {
        u(button, 17);
    }

    public static void t(TextView textView) {
        textView.setGravity(17);
        textView.setTextColor(-1);
        textView.setTextSize(20.0f);
        textView.setTypeface(t1.f21999z);
    }

    public static void u(TextView textView, int i10) {
        q(textView, "2dip", "2dip", "2dip", "2dip");
        textView.setTypeface(t1.A);
        ColorStateList colorStateList = t1.G;
        textView.setTextColor(colorStateList);
        textView.setBackground(t1.e(textView.getContext()));
        textView.setAutoLinkMask(15);
        textView.setTextSize(14.0f);
        textView.setTextColor(colorStateList);
        textView.setGravity(i10);
    }

    public static float v(String str, Context context) {
        if (str == null) {
            return 0.0f;
        }
        String lowerCase = str.toLowerCase();
        if (f22010c.containsKey(lowerCase)) {
            return ((Float) f22010c.get(lowerCase)).floatValue();
        }
        Matcher matcher = f22009b.matcher(lowerCase);
        if (matcher.matches()) {
            float parseFloat = Float.parseFloat(matcher.group(1));
            Integer num = (Integer) f22008a.get(matcher.group(3).toLowerCase());
            if (num == null) {
                num = 1;
            }
            float applyDimension = TypedValue.applyDimension(num.intValue(), parseFloat, context.getResources().getDisplayMetrics());
            f22010c.put(lowerCase, Float.valueOf(applyDimension));
            return applyDimension;
        }
        throw new NumberFormatException();
    }

    public static LinearLayout w(ViewGroup viewGroup) {
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        linearLayout.setOrientation(1);
        q(linearLayout, "10dip", "14dip", "10dip", "14dip");
        viewGroup.addView(linearLayout, d());
        return linearLayout;
    }

    public static void x(View view, String str, String str2) {
        Context context = view.getContext();
        m(view, a(str, context), a(str2, context));
    }

    public static void y(View view, String str, String str2, String str3, String str4) {
        Context context = view.getContext();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(a(str, context), a(str2, context), a(str3, context), a(str4, context));
        }
    }

    public static void z(TextView textView) {
        textView.setTextColor(t1.f21997x);
        textView.setLinkTextColor(t1.G);
        textView.setTypeface(t1.F);
        textView.setTextSize(13.0f);
        textView.setSingleLine(false);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
