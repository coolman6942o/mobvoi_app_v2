package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class r4 extends ArrayAdapter {

    /* renamed from: a  reason: collision with root package name */
    private int f21898a;

    public r4(Context context, ArrayList arrayList, int i10) {
        super(context, 0, arrayList);
        this.f21898a = i10;
    }

    private static int a(Context context, RelativeLayout relativeLayout, String str, int i10) {
        if (y1.i(str)) {
            return i10;
        }
        TextView textView = new TextView(context);
        int i11 = i10 + 1;
        textView.setId(i11);
        RelativeLayout.LayoutParams i12 = u1.i(-2, -2, 1, 2301);
        i12.addRule(0, 2302);
        i12.addRule(3, i10);
        textView.setText(str);
        u1.D(textView, 83);
        u1.y(textView, "6dip", null, "6dip", null);
        relativeLayout.addView(textView, i12);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return i11;
    }

    public final void b(int i10) {
        this.f21898a = i10;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        q4 q4Var = (q4) getItem(i10);
        Context context = viewGroup.getContext();
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        RelativeLayout relativeLayout = new RelativeLayout(context);
        linearLayout.addView(relativeLayout);
        u1.q(relativeLayout, null, "6dip", null, "6dip");
        String str = "";
        ImageView f10 = u1.f(viewGroup.getContext(), q4Var.a(), str);
        f10.setId(2301);
        RelativeLayout.LayoutParams j10 = u1.j(context, "40dip", "40dip", 9);
        j10.addRule(10);
        relativeLayout.addView(f10, j10);
        u1.q(f10, "6dip", null, null, null);
        ImageView f11 = u1.f(viewGroup.getContext(), "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", "checked");
        f11.setId(2302);
        RelativeLayout.LayoutParams j11 = u1.j(context, "20dip", "20dip", 11);
        j11.addRule(10);
        relativeLayout.addView(f11, j11);
        f11.setColorFilter(t1.f21979f);
        u1.q(f11, null, null, "8dip", null);
        f11.setVisibility(i10 == this.f21898a ? 0 : 4);
        TextView textView = new TextView(context);
        textView.setId(2303);
        textView.setText(q4Var.f());
        u1.A(textView, 83);
        u1.y(textView, "6dip", null, "6dip", null);
        relativeLayout.addView(textView, u1.i(-2, -2, 1, 2301));
        int a10 = a(context, relativeLayout, q4Var.h(), a(context, relativeLayout, q4Var.g(), 2303));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(q4Var.i());
        sb2.append(" ");
        sb2.append(q4Var.j());
        if (y1.m(q4Var.k())) {
            sb2.append("  ");
            sb2.append(q4Var.k());
        }
        if (y1.m(q4Var.l())) {
            sb2.append("  ");
            String l10 = q4Var.l();
            if (!y1.i(l10)) {
                String country = Locale.getDefault().getCountry();
                Locale locale = Locale.US;
                String lowerCase = country.toLowerCase(locale);
                if (y1.i(lowerCase) || !lowerCase.equals(l10.toLowerCase(locale))) {
                    str = "[" + l10 + "]";
                }
            }
            sb2.append(str);
        }
        a(context, relativeLayout, sb2.toString(), a10);
        return linearLayout;
    }
}
