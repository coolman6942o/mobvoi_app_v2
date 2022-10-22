package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.b;
import com.unionpay.mobile.android.languages.c;
import com.unionpay.mobile.android.utils.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ap extends aa implements Handler.Callback {

    /* renamed from: c  reason: collision with root package name */
    private a f24318c;

    /* renamed from: o  reason: collision with root package name */
    private TextView f24319o;

    /* renamed from: p  reason: collision with root package name */
    private Handler f24320p;

    /* renamed from: q  reason: collision with root package name */
    private int f24321q;

    /* loaded from: classes2.dex */
    public interface a {
        void a(z zVar);
    }

    public ap(Context context, int i10, JSONObject jSONObject, String str) {
        super(context, i10, jSONObject, str);
        this.f24318c = null;
        this.f24319o = null;
        this.f24320p = null;
        this.f24321q = 0;
        j();
        this.f24318c = null;
    }

    public ap(Context context, int i10, JSONObject jSONObject, String str, byte b10) {
        super(context, i10, jSONObject, str);
        this.f24318c = null;
        this.f24319o = null;
        this.f24320p = null;
        this.f24321q = 0;
        j();
    }

    private void a(boolean z10, String str) {
        this.f24319o.setText(str);
        this.f24319o.setEnabled(z10);
    }

    private void j() {
        ((aa) this).f24277b.a(new InputFilter.LengthFilter(6));
        ((aa) this).f24277b.a(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, b.f23349n);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        ((aa) this).f24277b.setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(this.f24347d);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-3419943);
        new LinearLayout.LayoutParams(1, -1);
        TextView textView = new TextView(getContext());
        this.f24319o = textView;
        textView.setGravity(17);
        this.f24319o.setText(c.bD.f23481w);
        this.f24319o.setTextColor(h.a(-10705958, -5846275, -5846275, -6710887));
        this.f24319o.setTextSize(b.f23346k);
        this.f24319o.setOnClickListener(new aq(this));
        ((aa) this).f24277b.a(this.f24319o, new LinearLayout.LayoutParams(-2, -1));
    }

    public final void a(int i10) {
        this.f24320p = new Handler(this);
        ar arVar = new ar(this, i10);
        a(false, String.format(c.bD.f23482x, Integer.valueOf(i10)));
        arVar.start();
    }

    public final void a(a aVar) {
        this.f24318c = aVar;
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        return this.f24352i || 6 == a().length();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_input_msg";
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            int i11 = message.arg1;
            this.f24321q = i11;
            c cVar = c.bD;
            if (cVar != null) {
                a(false, String.format(cVar.f23482x, Integer.valueOf(i11)));
            }
            return true;
        } else if (i10 != 1) {
            return false;
        } else {
            c cVar2 = c.bD;
            if (cVar2 != null) {
                a(true, cVar2.f23483y);
            }
            this.f24320p = null;
            return true;
        }
    }
}
