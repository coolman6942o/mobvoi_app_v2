package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.utils.h;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class w extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private String f24132a;

    /* renamed from: b  reason: collision with root package name */
    private x f24133b;

    private w(Context context, String str, String str2, Drawable drawable) {
        super(context);
        this.f24132a = null;
        this.f24133b = null;
        setOrientation(0);
        this.f24132a = str2;
        x a10 = x.a(context, drawable);
        this.f24133b = a10;
        a10.a(Html.fromHtml(String.format("<u>%s</u>", str)));
        this.f24133b.a(h.a(-13601621, -15909519));
        addView(this.f24133b);
    }

    public static final w a(Context context, JSONObject jSONObject, Drawable drawable) {
        if (jSONObject != null) {
            return new w(context, j.a(jSONObject, "label"), j.a(jSONObject, "href"), drawable);
        }
        return null;
    }

    public final String a() {
        return this.f24132a;
    }

    public final void a(View.OnClickListener onClickListener) {
        x xVar = this.f24133b;
        if (xVar != null) {
            xVar.setOnClickListener(onClickListener);
        }
    }
}
