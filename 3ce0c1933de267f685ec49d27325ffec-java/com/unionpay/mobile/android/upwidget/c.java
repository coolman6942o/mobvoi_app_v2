package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amap.api.services.core.AMapException;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class c extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f24038a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f24039b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f24040c;

    /* renamed from: d  reason: collision with root package name */
    private Context f24041d;

    /* renamed from: e  reason: collision with root package name */
    private String f24042e;

    /* renamed from: f  reason: collision with root package name */
    private String f24043f;

    /* renamed from: g  reason: collision with root package name */
    private String f24044g;

    /* renamed from: i  reason: collision with root package name */
    private int f24046i;

    /* renamed from: j  reason: collision with root package name */
    private int f24047j;

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f24048k;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24045h = false;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<View.OnClickListener> f24049l = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    private View.OnClickListener f24050m = new d(this);

    public c(Context context, List<Map<String, Object>> list, String str, String str2, String str3, int i10, int i11) {
        this.f24042e = null;
        this.f24043f = null;
        this.f24044g = null;
        this.f24046i = 1;
        this.f24047j = 0;
        this.f24041d = context;
        this.f24048k = list;
        this.f24042e = str;
        this.f24043f = str2;
        this.f24044g = str3;
        this.f24046i = i10;
        this.f24047j = i11;
        this.f24038a = com.unionpay.mobile.android.resource.c.a(context).a(1015, -1, -1);
        this.f24039b = com.unionpay.mobile.android.resource.c.a(this.f24041d).a(1016, -1, -1);
        this.f24040c = com.unionpay.mobile.android.resource.c.a(this.f24041d).a(1002, -1, -1);
    }

    private boolean d() {
        String str = this.f24042e;
        return str != null && !TextUtils.isEmpty(str);
    }

    private boolean d(int i10) {
        Object obj;
        int c10 = i10 - c();
        return c10 == this.f24048k.size() || (obj = this.f24048k.get(c10).get("available")) == null || Boolean.FALSE != ((Boolean) obj);
    }

    private boolean e() {
        String str = this.f24043f;
        return str != null && !TextUtils.isEmpty(str);
    }

    public final void a() {
        this.f24045h = !this.f24045h;
    }

    public final void a(int i10) {
        this.f24046i = i10;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.f24049l.add(onClickListener);
    }

    public final void a(String str) {
        this.f24042e = str;
    }

    public final Spanned b(int i10) {
        int c10 = i10 - c();
        if (c10 == this.f24048k.size()) {
            return null;
        }
        Map<String, Object> map = this.f24048k.get(c10);
        return Html.fromHtml(((String) map.get("text1")) + " " + ((String) map.get("text2")));
    }

    public final void b(String str) {
        this.f24044g = str;
    }

    public final boolean b() {
        return this.f24045h;
    }

    public final int c() {
        return d() ? 1 : 0;
    }

    public final boolean c(int i10) {
        Object obj;
        int c10 = i10 - c();
        return c10 == this.f24048k.size() || (obj = this.f24048k.get(c10).get("editable")) == null || Boolean.FALSE != ((Boolean) obj);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<Map<String, Object>> list = this.f24048k;
        if (list == null) {
            return 0;
        }
        return list.size() + c() + (e() ? 1 : 0);
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i10) {
        List<Map<String, Object>> list;
        if (i10 == 0 || (list = this.f24048k) == null || i10 >= list.size()) {
            return null;
        }
        return this.f24048k.get(i10 - c());
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0165, code lost:
        if (r5 != null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01ed, code lost:
        if (r9 != false) goto L52;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        int i11;
        LinearLayout linearLayout = new LinearLayout(this.f24041d);
        boolean z10 = true;
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(this.f24041d);
        int i12 = b.f23342g;
        relativeLayout.setPadding(i12, i12, i12, i12);
        linearLayout.addView(relativeLayout);
        LinearLayout linearLayout2 = new LinearLayout(this.f24041d);
        linearLayout2.setBackgroundColor(-3419943);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        boolean z11 = i10 - c() == this.f24048k.size();
        if (!d() || i10 != 0) {
            if (!e() || !z11) {
                ImageView imageView = new ImageView(this.f24041d);
                imageView.setVisibility(4);
                imageView.setId(imageView.hashCode());
                TextView textView = new TextView(this.f24041d);
                textView.setSingleLine(true);
                textView.setEllipsize(TextUtils.TruncateAt.END);
                textView.setText(b(i10));
                textView.setTextSize(b.f23346k);
                textView.setTextColor(-10066330);
                int a10 = g.a(this.f24041d, 20.0f);
                int i13 = this.f24047j;
                if (i13 == 0) {
                    boolean z12 = this.f24045h;
                    Drawable drawable = z12 ? this.f24039b : this.f24038a;
                    if (z12 || this.f24046i != i10 || drawable == null) {
                        i11 = 0;
                        if (c(i10)) {
                            if (this.f24045h) {
                            }
                        }
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a10, a10);
                        layoutParams2.addRule(15, -1);
                        layoutParams2.addRule(9, -1);
                        relativeLayout.addView(imageView, layoutParams2);
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams3.addRule(15, -1);
                        layoutParams3.addRule(1, imageView.hashCode());
                        layoutParams3.leftMargin = b.f23342g;
                        relativeLayout.addView(textView, layoutParams3);
                    } else {
                        i11 = 0;
                    }
                    imageView.setVisibility(i11);
                    imageView.setBackgroundDrawable(drawable);
                    RelativeLayout.LayoutParams layoutParams22 = new RelativeLayout.LayoutParams(a10, a10);
                    layoutParams22.addRule(15, -1);
                    layoutParams22.addRule(9, -1);
                    relativeLayout.addView(imageView, layoutParams22);
                    RelativeLayout.LayoutParams layoutParams32 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams32.addRule(15, -1);
                    layoutParams32.addRule(1, imageView.hashCode());
                    layoutParams32.leftMargin = b.f23342g;
                    relativeLayout.addView(textView, layoutParams32);
                } else if (i13 == 1) {
                    int i14 = this.f24046i == i10 ? AMapException.CODE_AMAP_INVALID_USER_SCODE : AMapException.CODE_AMAP_INVALID_USER_DOMAIN;
                    int a11 = g.a(this.f24041d, 20.0f);
                    Drawable a12 = com.unionpay.mobile.android.resource.c.a(this.f24041d).a(i14, a10, a10);
                    if (d(i10)) {
                        imageView.setVisibility(0);
                    }
                    imageView.setBackgroundDrawable(a12);
                    RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a11, a11);
                    layoutParams4.addRule(15, -1);
                    layoutParams4.addRule(11, -1);
                    relativeLayout.addView(imageView, layoutParams4);
                    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
                    layoutParams5.addRule(15, -1);
                    layoutParams5.addRule(9, -1);
                    layoutParams5.addRule(0, imageView.hashCode());
                    layoutParams5.rightMargin = b.f23342g;
                    relativeLayout.addView(textView, layoutParams5);
                    layoutParams.leftMargin = i12;
                }
                if (e()) {
                }
            } else {
                TextView textView2 = new TextView(this.f24041d);
                textView2.setText(this.f24043f);
                textView2.setTextSize(b.f23346k);
                textView2.setTextColor(-10066330);
                RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams6.addRule(15, -1);
                layoutParams6.addRule(9, -1);
                relativeLayout.addView(textView2, layoutParams6);
                ImageView imageView2 = new ImageView(this.f24041d);
                imageView2.setBackgroundDrawable(this.f24040c);
                int a13 = g.a(this.f24041d, 20.0f);
                RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(a13, a13);
                layoutParams7.addRule(15, -1);
                layoutParams7.addRule(11, -1);
                relativeLayout.addView(imageView2, layoutParams7);
            }
            return linearLayout;
        }
        TextView textView3 = new TextView(this.f24041d);
        textView3.setText(this.f24042e);
        textView3.setTextSize(b.f23346k);
        textView3.setTextColor(-13421773);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(9, -1);
        layoutParams8.addRule(15, -1);
        layoutParams8.leftMargin = b.f23341f;
        relativeLayout.addView(textView3, layoutParams8);
        String str = this.f24044g;
        if (str == null || TextUtils.isEmpty(str)) {
            z10 = false;
        }
        if (z10) {
            TextView textView4 = new TextView(this.f24041d);
            textView4.setText(this.f24044g);
            textView4.setTextSize(b.f23346k);
            textView4.setTextColor(-13421773);
            textView4.setOnClickListener(this.f24050m);
            RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams9.addRule(11, -1);
            layoutParams9.addRule(15, -1);
            layoutParams9.rightMargin = b.f23341f;
            relativeLayout.addView(textView4, layoutParams9);
        }
        linearLayout.addView(linearLayout2, layoutParams);
        return linearLayout;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i10) {
        if ((!d() || i10 != 0) && d(i10)) {
            return super.isEnabled(i10);
        }
        return false;
    }
}
