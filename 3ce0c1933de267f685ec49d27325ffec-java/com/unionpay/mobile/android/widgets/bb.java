package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public final class bb {

    /* renamed from: a  reason: collision with root package name */
    private static int f24363a = com.unionpay.mobile.android.global.a.f23327r;

    /* renamed from: b  reason: collision with root package name */
    private static int f24364b = 40;

    /* renamed from: i  reason: collision with root package name */
    private static List<Integer> f24365i = new ArrayList(10);

    /* renamed from: c  reason: collision with root package name */
    private Context f24366c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f24367d;

    /* renamed from: e  reason: collision with root package name */
    private PopupWindow f24368e;

    /* renamed from: f  reason: collision with root package name */
    private View f24369f;

    /* renamed from: g  reason: collision with root package name */
    private ScrollView f24370g;

    /* renamed from: h  reason: collision with root package name */
    private int f24371h = -1;

    /* renamed from: j  reason: collision with root package name */
    private PopupWindow.OnDismissListener f24372j = new bc(this);

    /* loaded from: classes2.dex */
    private class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(bb bbVar, byte b10) {
            this();
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return bb.f24365i.size() + 2;
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i10) {
            return null;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public final View getView(int i10, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout = new LinearLayout(bb.this.f24366c);
            Drawable a10 = c.a(bb.this.f24366c).a(1022, -1, -1);
            Drawable a11 = c.a(bb.this.f24366c).a(1022, -1, -1);
            linearLayout.setBackgroundDrawable(h.a(a10, a11, a11, a10));
            linearLayout.setMinimumHeight(g.a(bb.this.f24366c, 55.0f));
            linearLayout.setClickable(true);
            linearLayout.setOnClickListener(bb.this.f24367d);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            int i11 = 10;
            if (i10 == 9 || i10 == 11) {
                ImageView imageView = new ImageView(bb.this.f24366c);
                if (i10 != 9) {
                    i11 = 20;
                }
                imageView.setImageDrawable(c.a(bb.this.f24366c).a(i10 == 9 ? 1024 : 1025, -1, g.a(bb.this.f24366c, 20.0f)));
                linearLayout.setId(i11);
                linearLayout.addView(imageView, layoutParams);
            } else {
                TextView textView = new TextView(bb.this.f24366c);
                textView.setTextColor(-1);
                textView.getPaint().setFakeBoldText(true);
                textView.setTextSize(30.0f);
                textView.setGravity(17);
                if (i10 == 10) {
                    i10 = 9;
                }
                int intValue = ((Integer) bb.f24365i.get(i10)).intValue();
                linearLayout.setId(intValue);
                textView.setText(String.valueOf(intValue));
                linearLayout.addView(textView, layoutParams);
            }
            return linearLayout;
        }
    }

    /* loaded from: classes2.dex */
    private class b extends LinearLayout {
        public b(Context context) {
            super(context);
            setOrientation(1);
            setBackgroundColor(-11316397);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            LinearLayout linearLayout = new LinearLayout(context);
            int a10 = g.a(context, 5.0f);
            linearLayout.setPadding(0, a10, 0, a10);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(-13816531);
            linearLayout.setOrientation(0);
            Drawable a11 = c.a(context).a(1020, -1, g.a(context, 24.0f));
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(a11);
            linearLayout.addView(imageView);
            addView(linearLayout, layoutParams);
            Collections.shuffle(bb.f24365i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            GridView gridView = new GridView(context);
            gridView.setNumColumns(3);
            gridView.setAdapter((ListAdapter) new a(bb.this, (byte) 0));
            gridView.setGravity(17);
            gridView.setStretchMode(2);
            gridView.setHorizontalScrollBarEnabled(false);
            gridView.setVerticalScrollBarEnabled(false);
            gridView.setEnabled(true);
            int a12 = g.a(bb.this.f24366c, 1.0f);
            gridView.setHorizontalSpacing(a12);
            gridView.setVerticalSpacing(a12);
            int i10 = -a12;
            gridView.setPadding(i10, a12, i10, i10);
            addView(gridView, layoutParams2);
        }
    }

    static {
        for (int i10 = 0; i10 < 10; i10++) {
            f24365i.add(Integer.valueOf(i10));
        }
    }

    public bb(Context context, View.OnClickListener onClickListener, View view) {
        this.f24366c = null;
        this.f24367d = null;
        this.f24368e = null;
        this.f24369f = null;
        this.f24370g = null;
        this.f24366c = context;
        this.f24367d = onClickListener;
        f24363a = g.a(context, 55.0f);
        f24364b = g.a(this.f24366c, 40.0f);
        ViewParent viewParent = (ViewParent) view;
        while (true) {
            if (viewParent == null) {
                break;
            } else if (viewParent instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) viewParent;
                this.f24370g = scrollView;
                k.a("UPWidgetKeyBoard", "mSV : " + this.f24370g.toString());
                k.a("UPWidgetKeyBoard", "mSV H:" + this.f24370g.getHeight());
                this.f24369f = scrollView.getChildAt(0);
                break;
            } else {
                viewParent = viewParent.getParent();
            }
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        new RelativeLayout.LayoutParams(-1, -2).setMargins(0, 0, 0, 0);
        relativeLayout.setBackgroundColor(-1342177280);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setBackgroundColor(-13290188);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        relativeLayout.addView(relativeLayout2, layoutParams);
        relativeLayout2.addView(new b(this.f24366c), layoutParams);
        this.f24368e = new PopupWindow((View) relativeLayout, -1, -2, true);
        new RelativeLayout.LayoutParams(-1, -2);
        this.f24368e.setBackgroundDrawable(new BitmapDrawable());
        this.f24368e.setOutsideTouchable(false);
        this.f24368e.setFocusable(false);
        this.f24368e.setOnDismissListener(this.f24372j);
    }

    private static int d() {
        int i10 = (f24363a * 4) + f24364b;
        k.c("UPWidgetKeyBoard", "kbH=" + i10);
        return i10;
    }

    public final void a() {
        PopupWindow popupWindow = this.f24368e;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    public final void a(View view) {
        PopupWindow popupWindow = this.f24368e;
        if (popupWindow != null) {
            popupWindow.showAtLocation(view, 80, 0, 0);
            if (this.f24369f != null) {
                view.setVisibility(0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f24370g.getLayoutParams();
                this.f24371h = marginLayoutParams.height;
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                marginLayoutParams.height = ((com.unionpay.mobile.android.global.a.f23329t - rect.top) - com.unionpay.mobile.android.global.a.f23320k) - d();
                k.a("UPWidgetKeyBoard", "height = " + marginLayoutParams.height);
                marginLayoutParams.bottomMargin = d();
                this.f24370g.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final boolean b() {
        return this.f24368e.isShowing();
    }
}
