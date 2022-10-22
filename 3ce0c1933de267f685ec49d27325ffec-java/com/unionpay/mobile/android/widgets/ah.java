package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.utils.j;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ah extends aa {

    /* renamed from: c  reason: collision with root package name */
    private a f24295c;

    /* renamed from: o  reason: collision with root package name */
    private String f24296o;

    /* renamed from: p  reason: collision with root package name */
    private String f24297p;

    /* loaded from: classes2.dex */
    public interface a {
        void e(String str);
    }

    public ah(Context context, int i10, JSONObject jSONObject, String str) {
        this(context, i10, jSONObject, str, (byte) 0);
    }

    private ah(Context context, int i10, JSONObject jSONObject, String str, byte b10) {
        super(context, i10, jSONObject, str);
        this.f24295c = null;
        this.f24296o = null;
        this.f24297p = null;
        this.f24296o = j.a(jSONObject, "button_label");
        this.f24297p = j.a(jSONObject, "button_action");
        ((aa) this).f24277b.a(new InputFilter.LengthFilter(11));
        ((aa) this).f24277b.a(2);
        String str2 = this.f24296o;
        if (str2 != null && str2.length() > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, b.f23349n);
            layoutParams.addRule(9, -1);
            layoutParams.addRule(15, -1);
            ((aa) this).f24277b.setLayoutParams(layoutParams);
            TextView textView = new TextView(getContext());
            textView.setGravity(17);
            textView.setText(this.f24296o);
            textView.setTextColor(-7829368);
            textView.setTextSize(b.f23346k);
            textView.setOnClickListener(new ai(this));
            ((aa) this).f24277b.a(textView, new LinearLayout.LayoutParams(-2, -1));
        }
    }

    @Override // com.unionpay.mobile.android.widgets.aa, com.unionpay.mobile.android.widgets.ba.a
    public final String a() {
        return ((aa) this).f24277b.b();
    }

    public final void a(a aVar) {
        this.f24295c = aVar;
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        if (this.f24352i) {
            return true;
        }
        String str = this.f24353j;
        return (str == null || TextUtils.isEmpty(str)) ? 11 == a().length() && a().startsWith("1") : a().matches(this.f24353j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_input_phoneNO";
    }
}
