package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.nocard.views.bh;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.ad;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class m extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private Context f24233a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f24234b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f24235c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f24236d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f24237e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f24238f;

    public m(Context context) {
        super(context);
        this.f24233a = context;
        int a10 = g.a(context, 10.0f);
        setPadding(a10, a10, a10, a10);
        setBackgroundColor(-1);
        setOnClickListener(new n(this));
        int a11 = g.a(context, 15.0f);
        ImageView imageView = new ImageView(context);
        this.f24234b = imageView;
        imageView.setId(imageView.hashCode());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a11, a11);
        layoutParams.addRule(11, -1);
        layoutParams.addRule(12, -1);
        addView(this.f24234b, layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f24235c = linearLayout;
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.rightMargin = a10;
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(0, this.f24234b.getId());
        addView(this.f24235c, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(m mVar) {
        int i10 = 8;
        if (mVar.f24236d.getVisibility() == 8) {
            i10 = 0;
        }
        mVar.f24236d.setVisibility(i10);
        mVar.f24234b.setBackgroundDrawable(i10 == 0 ? mVar.f24237e : mVar.f24238f);
    }

    public final void a(Drawable drawable, Drawable drawable2) {
        this.f24237e = drawable;
        this.f24238f = drawable2;
    }

    public final void a(boolean z10, JSONArray jSONArray, JSONObject jSONObject) {
        this.f24235c.removeAllViews();
        Drawable drawable = this.f24238f;
        if (drawable != null) {
            this.f24234b.setBackgroundDrawable(drawable);
        }
        int i10 = (jSONArray == null || jSONArray.length() == 0) ? 0 : 1;
        if (!z10 && jSONArray != null) {
            i10 = 2;
            if (jSONArray.length() <= 2) {
                i10 = jSONArray.length();
            }
        }
        if (jSONArray == null || i10 == 0) {
            k.c("uppay", "init order detail = null!!!");
            return;
        }
        this.f24235c.addView(bh.a(this.f24233a, jSONArray, 0, i10), new LinearLayout.LayoutParams(-1, -2));
        this.f24236d = bh.a(this.f24233a, jSONArray, i10, jSONArray.length());
        if (jSONObject != null) {
            ad adVar = new ad(this.f24233a, jSONObject, "");
            adVar.g();
            adVar.a(b.f23348m);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = g.a(this.f24233a, 8.0f);
            this.f24236d.addView(adVar, layoutParams);
        }
        this.f24236d.setVisibility(8);
        this.f24235c.addView(this.f24236d, new LinearLayout.LayoutParams(-1, -2));
    }
}
