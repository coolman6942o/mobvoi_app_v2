package com.paypal.android.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
/* loaded from: classes2.dex */
public final class p4 {

    /* renamed from: a  reason: collision with root package name */
    public TableLayout f21506a;

    /* renamed from: b  reason: collision with root package name */
    public TableLayout f21507b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f21508c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f21509d;

    /* renamed from: e  reason: collision with root package name */
    private int f21510e;

    public p4(Context context, String str) {
        TableLayout tableLayout = new TableLayout(context);
        this.f21507b = tableLayout;
        tableLayout.setColumnShrinkable(0, false);
        this.f21507b.setColumnStretchable(0, false);
        this.f21507b.setColumnStretchable(1, false);
        this.f21507b.setColumnShrinkable(1, false);
        TableRow tableRow = new TableRow(context);
        this.f21507b.addView(tableRow);
        TextView textView = new TextView(context);
        this.f21509d = textView;
        int i10 = t1.f21995v;
        textView.setTextColor(i10);
        this.f21509d.setText("Item");
        this.f21509d.setSingleLine(true);
        this.f21509d.setGravity(83);
        this.f21509d.setTextSize(18.0f);
        this.f21509d.setTextColor(i10);
        this.f21509d.setTypeface(t1.D);
        tableRow.addView(this.f21509d);
        u1.l(this.f21509d, 16, 1.0f);
        this.f21510e = u1.a("10dip", context);
        u1.y(this.f21509d, null, null, "10dip", null);
        TextView textView2 = new TextView(context);
        this.f21508c = textView2;
        textView2.setTextSize(18.0f);
        this.f21508c.setTypeface(t1.E);
        this.f21508c.setText(str);
        this.f21508c.setSingleLine(true);
        this.f21508c.setGravity(85);
        this.f21508c.setTextColor(t1.f21996w);
        tableRow.addView(this.f21508c);
        u1.l(this.f21508c, 5, 1.0f);
        this.f21506a = this.f21507b;
    }

    public final void a() {
        TextView textView = this.f21508c;
        TextView textView2 = this.f21509d;
        int measureText = (int) textView.getPaint().measureText(textView.getText().toString());
        int width = (this.f21507b.getWidth() - measureText) - this.f21510e;
        CharSequence ellipsize = TextUtils.ellipsize(textView2.getText(), textView2.getPaint(), width, TextUtils.TruncateAt.END);
        textView2.setWidth(width);
        textView.setWidth(measureText);
        textView2.setText(ellipsize);
    }
}
