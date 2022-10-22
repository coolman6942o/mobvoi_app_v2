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
import java.util.Iterator;
/* loaded from: classes2.dex */
public final class e4 extends ArrayAdapter {

    /* renamed from: a  reason: collision with root package name */
    private int f21177a;

    public e4(Context context, ArrayList arrayList, int i10) {
        super(context, 0, arrayList);
        this.f21177a = i10;
    }

    private static void b(Context context, RelativeLayout relativeLayout, d4 d4Var) {
        LinearLayout linearLayout = new LinearLayout(context);
        int i10 = 2304;
        linearLayout.setId(2304);
        int i11 = 0;
        linearLayout.setOrientation(0);
        int i12 = 2301;
        RelativeLayout.LayoutParams i13 = u1.i(-2, -2, 1, 2301);
        i13.addRule(0, 2303);
        relativeLayout.addView(linearLayout, i13);
        TextView textView = new TextView(context);
        textView.setId(2302);
        u1.A(textView, 83);
        linearLayout.addView(textView);
        u1.y(textView, "6dip", null, null, null);
        TextView textView2 = new TextView(context);
        u1.D(textView2, 83);
        linearLayout.addView(textView2);
        u1.y(textView2, "6dip", null, "6dip", null);
        if (d4Var.e()) {
            TextView textView3 = new TextView(context);
            textView3.setId(2306);
            u1.C(textView3, 83);
            RelativeLayout.LayoutParams i14 = u1.i(-2, -2, 1, 2301);
            i14.addRule(0, 2303);
            i14.addRule(3, 2304);
            relativeLayout.addView(textView3, i14);
            u1.y(textView3, "6dip", null, null, null);
            textView3.setText(z3.a(ft.PAY_AFTER_DELIVERY));
            i10 = 2306;
        }
        Iterator it = d4Var.f().iterator();
        int i15 = 2500;
        int i16 = 2400;
        while (it.hasNext()) {
            f4 f4Var = (f4) it.next();
            TextView textView4 = new TextView(context);
            textView4.setId(i16);
            textView4.setText(f4Var.b() + " " + f4Var.d());
            RelativeLayout.LayoutParams i17 = u1.i(-2, -2, 1, i12);
            i17.addRule(i11, i15);
            if (textView4.getId() == 2400) {
                i17.addRule(3, i10);
            } else {
                i17.addRule(3, textView4.getId() - 1);
            }
            relativeLayout.addView(textView4, i17);
            u1.E(textView4, 83);
            u1.y(textView4, "6dip", null, null, null);
            textView4.setEllipsize(TextUtils.TruncateAt.END);
            TextView textView5 = new TextView(context);
            textView5.setId(i15);
            textView5.setText(f4Var.e());
            RelativeLayout.LayoutParams i18 = u1.i(-2, -2, i11, 2303);
            i18.addRule(8, i16);
            relativeLayout.addView(textView5, i18);
            u1.D(textView5, 85);
            u1.y(textView5, "6dip", null, "6dip", null);
            i16++;
            i15++;
            i11 = 0;
            i12 = 2301;
        }
        textView.setText(d4Var.c());
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setText(d4Var.d());
        textView2.setEllipsize(TextUtils.TruncateAt.END);
    }

    public final void a(int i10) {
        this.f21177a = i10;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        int i11;
        d4 d4Var = (d4) getItem(i10);
        LinearLayout linearLayout = new LinearLayout(viewGroup.getContext());
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        linearLayout.addView(relativeLayout);
        u1.q(relativeLayout, null, "6dip", null, "6dip");
        ImageView f10 = u1.f(viewGroup.getContext(), d4Var.a(), "");
        f10.setId(2301);
        RelativeLayout.LayoutParams j10 = u1.j(viewGroup.getContext(), "30dip", "30dip", 9);
        j10.addRule(10);
        relativeLayout.addView(f10, j10);
        u1.q(f10, "4dip", null, null, null);
        ImageView f11 = u1.f(viewGroup.getContext(), "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", "checked");
        f11.setId(2303);
        RelativeLayout.LayoutParams j11 = u1.j(viewGroup.getContext(), "20dip", "20dip", 11);
        j11.addRule(10);
        relativeLayout.addView(f11, j11);
        f11.setColorFilter(t1.f21979f);
        u1.q(f11, null, null, "8dip", null);
        if (i10 != this.f21177a) {
            f11.setVisibility(4);
        }
        if (d4Var.g()) {
            Context context = viewGroup.getContext();
            TextView textView = new TextView(context);
            textView.setId(2302);
            u1.A(textView, 83);
            RelativeLayout.LayoutParams i12 = u1.i(-2, -2, 1, 2301);
            i12.addRule(0, 2303);
            relativeLayout.addView(textView, i12);
            u1.y(textView, "6dip", null, null, null);
            if (d4Var.e()) {
                TextView textView2 = new TextView(context);
                textView2.setId(2306);
                u1.C(textView2, 83);
                RelativeLayout.LayoutParams i13 = u1.i(-2, -2, 1, 2301);
                i13.addRule(0, 2303);
                i13.addRule(3, 2302);
                relativeLayout.addView(textView2, i13);
                u1.y(textView2, "6dip", null, null, null);
                textView2.setText(z3.a(ft.PAY_AFTER_DELIVERY));
                i11 = 2306;
            } else {
                i11 = 2302;
            }
            TextView textView3 = new TextView(context);
            textView3.setId(2305);
            u1.D(textView3, 83);
            RelativeLayout.LayoutParams i14 = u1.i(-2, -2, 1, 2301);
            i14.addRule(3, i11);
            relativeLayout.addView(textView3, i14);
            u1.y(textView3, "6dip", null, null, null);
            TextView textView4 = new TextView(context);
            RelativeLayout.LayoutParams i15 = u1.i(-2, -2, 0, 2303);
            i15.addRule(8, 2305);
            relativeLayout.addView(textView4, i15);
            u1.D(textView4, 85);
            u1.y(textView4, null, null, "6dip", null);
            textView.setText(d4Var.c());
            textView3.setText(d4Var.d());
            textView4.setText(d4Var.f().a(0).e());
        } else {
            b(viewGroup.getContext(), relativeLayout, d4Var);
        }
        return linearLayout;
    }
}
