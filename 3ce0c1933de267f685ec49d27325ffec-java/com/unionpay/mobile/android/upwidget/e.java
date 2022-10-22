package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public final class e extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f24052a;

    /* renamed from: b  reason: collision with root package name */
    private Context f24053b;

    /* renamed from: c  reason: collision with root package name */
    private String f24054c;

    /* renamed from: e  reason: collision with root package name */
    private int f24056e;

    /* renamed from: f  reason: collision with root package name */
    private List<Map<String, Object>> f24057f;

    /* renamed from: d  reason: collision with root package name */
    private String f24055d = null;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<View.OnClickListener> f24058g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private View.OnClickListener f24059h = new f(this);

    public e(Context context, List<Map<String, Object>> list, String str) {
        this.f24054c = null;
        this.f24056e = 1;
        this.f24053b = context;
        this.f24057f = list;
        this.f24054c = str;
        this.f24056e = 0;
        this.f24052a = c.a(context).a(1015, -1, -1);
    }

    private boolean b() {
        String str = this.f24054c;
        return str != null && !TextUtils.isEmpty(str);
    }

    private boolean b(int i10) {
        Object obj;
        int a10 = i10 - a();
        List<Map<String, Object>> list = this.f24057f;
        return list == null || a10 == list.size() || (obj = this.f24057f.get(a10).get("available")) == null || Boolean.FALSE != ((Boolean) obj);
    }

    public final int a() {
        return b() ? 1 : 0;
    }

    public final void a(int i10) {
        this.f24056e = i10;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<Map<String, Object>> list = this.f24057f;
        int i10 = 0;
        if (list == null) {
            return 0;
        }
        int size = list.size() + a();
        String str = this.f24055d;
        if (str != null && !TextUtils.isEmpty(str)) {
            i10 = 1;
        }
        return size + i10;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i10) {
        List<Map<String, Object>> list;
        if (i10 == 0 || (list = this.f24057f) == null || i10 >= list.size()) {
            return null;
        }
        return this.f24057f.get(i10 - a());
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        getItem(i10);
        Map<String, Object> map = this.f24057f.get(i10 - a());
        List list = (List) map.get("keys");
        List list2 = (List) map.get("values");
        LinearLayout linearLayout = new LinearLayout(this.f24053b);
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(this.f24053b);
        int i11 = b.f23342g;
        relativeLayout.setPadding(i11, i11, i11, i11);
        linearLayout.addView(relativeLayout);
        LinearLayout linearLayout2 = new LinearLayout(this.f24053b);
        linearLayout2.setBackgroundColor(-3419943);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        ImageView imageView = new ImageView(this.f24053b);
        imageView.setVisibility(4);
        imageView.setId(imageView.hashCode());
        TextView textView = new TextView(this.f24053b);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText((String) map.get("style"));
        textView.setTextSize(b.f23344i);
        textView.setTextColor(-10066330);
        int a10 = g.a(this.f24053b, 20.0f);
        int i12 = this.f24056e == i10 ? AMapException.CODE_AMAP_INVALID_USER_SCODE : AMapException.CODE_AMAP_INVALID_USER_DOMAIN;
        int a11 = g.a(this.f24053b, 20.0f);
        Drawable a12 = c.a(this.f24053b).a(i12, a10, a10);
        if (b(i10)) {
            imageView.setVisibility(0);
        }
        imageView.setBackgroundDrawable(a12);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a11, a11);
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(9, -1);
        relativeLayout.addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15, -1);
        int hashCode = imageView.hashCode();
        boolean z10 = true;
        layoutParams3.addRule(1, hashCode);
        layoutParams3.leftMargin = b.f23342g;
        relativeLayout.addView(textView, layoutParams3);
        LinearLayout linearLayout3 = new LinearLayout(this.f24053b);
        linearLayout3.setOrientation(1);
        int i13 = 5;
        linearLayout3.setGravity(5);
        linearLayout3.setId(linearLayout3.hashCode());
        LinearLayout linearLayout4 = new LinearLayout(this.f24053b);
        linearLayout4.setOrientation(1);
        linearLayout4.setGravity(5);
        linearLayout4.setId(linearLayout4.hashCode());
        int i14 = 0;
        while (i14 < list.size()) {
            TextView textView2 = new TextView(this.f24053b);
            textView2.setSingleLine(z10);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setText((CharSequence) list.get(i14));
            textView2.setTextSize(b.f23346k);
            textView2.setTextColor(-6710887);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = i13;
            linearLayout3.addView(textView2, layoutParams4);
            TextView textView3 = new TextView(this.f24053b);
            textView3.setSingleLine(true);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            textView3.setText((CharSequence) list2.get(i14));
            textView3.setTextSize(b.f23346k);
            textView3.setTextColor(-6710887);
            linearLayout4.addView(textView3, layoutParams4);
            i14++;
            i13 = 5;
            z10 = true;
        }
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(g.a(this.f24053b, 120.0f), -2);
        layoutParams5.addRule(11, -1);
        relativeLayout.addView(linearLayout4, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(g.a(this.f24053b, 100.0f), -2);
        layoutParams6.addRule(0, linearLayout4.getId());
        relativeLayout.addView(linearLayout3, layoutParams6);
        layoutParams.rightMargin = i11;
        layoutParams.leftMargin = i11;
        linearLayout.addView(linearLayout2, layoutParams);
        return linearLayout;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i10) {
        if ((!b() || i10 != 0) && b(i10)) {
            return super.isEnabled(i10);
        }
        return false;
    }
}
