package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.upviews.a;
import com.unionpay.mobile.android.utils.g;
import com.unionpay.mobile.android.utils.h;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class AbstractMethod extends LinearLayout implements a.b {

    /* renamed from: a  reason: collision with root package name */
    protected static final int f24169a = com.unionpay.mobile.android.global.b.f23336a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f24170b;

    /* renamed from: c  reason: collision with root package name */
    protected String f24171c;

    /* renamed from: d  reason: collision with root package name */
    protected String f24172d;

    /* renamed from: e  reason: collision with root package name */
    protected b f24173e;

    /* renamed from: f  reason: collision with root package name */
    protected a f24174f;

    /* renamed from: g  reason: collision with root package name */
    private Button f24175g;

    /* renamed from: h  reason: collision with root package name */
    private RelativeLayout f24176h;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i10, boolean z10, int i11, a.C0266a aVar);
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(String str, String str2);
    }

    public AbstractMethod(Context context) {
        this(context, null);
    }

    public AbstractMethod(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractMethod(Context context, AttributeSet attributeSet, int i10) {
        super(context);
        this.f24170b = context;
        setOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(TextView textView) {
        if (textView != null) {
            textView.setTextSize(com.unionpay.mobile.android.global.b.f23346k);
            textView.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(String str) {
        return str == null || str.length() == 0;
    }

    public final void a() {
        this.f24176h = new RelativeLayout(this.f24170b);
        addView(this.f24176h, new LinearLayout.LayoutParams(-1, -2));
        a(this.f24176h);
        RelativeLayout relativeLayout = new RelativeLayout(this.f24170b);
        addView(relativeLayout, new LinearLayout.LayoutParams(-1, -2));
        b(relativeLayout);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f24170b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        addView(relativeLayout2, layoutParams);
        Button button = new Button(this.f24170b);
        this.f24175g = button;
        button.setText(e());
        Button button2 = this.f24175g;
        int i10 = com.unionpay.mobile.android.global.b.f23337b;
        int i11 = com.unionpay.mobile.android.global.b.f23338c;
        button2.setTextColor(h.a(i10, i11, i11, com.unionpay.mobile.android.global.b.f23339d));
        this.f24175g.setTextSize(com.unionpay.mobile.android.global.b.f23344i);
        this.f24175g.setOnClickListener(new com.unionpay.mobile.android.views.order.a(this));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.b.f23349n);
        layoutParams2.addRule(15, -1);
        layoutParams2.topMargin = com.unionpay.mobile.android.global.a.f23315f;
        int a10 = g.a(this.f24170b, 10.0f);
        layoutParams2.rightMargin = a10;
        layoutParams2.leftMargin = a10;
        relativeLayout2.addView(this.f24175g, layoutParams2);
        RelativeLayout relativeLayout3 = new RelativeLayout(this.f24170b);
        addView(relativeLayout3, layoutParams);
        c(relativeLayout3);
        this.f24175g.setEnabled(f());
    }

    public final void a(Drawable drawable) {
        Button button = this.f24175g;
        if (button != null && drawable != null) {
            button.setBackgroundDrawable(drawable);
        }
    }

    public abstract void a(RelativeLayout relativeLayout);

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(a.C0266a aVar) {
    }

    public final void a(a aVar) {
        this.f24174f = aVar;
    }

    public final void a(b bVar) {
        this.f24173e = bVar;
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void a(boolean z10) {
        this.f24175g.setEnabled(!z10);
    }

    public abstract int b();

    public abstract void b(RelativeLayout relativeLayout);

    public abstract a.C0266a c();

    public abstract void c(RelativeLayout relativeLayout);

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.a.b
    public final void c(String str, String str2) {
    }

    public int d() {
        return 0;
    }

    public abstract String e();

    public abstract boolean f();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g() {
        this.f24176h.setVisibility(8);
    }
}
