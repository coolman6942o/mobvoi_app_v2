package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.unionpay.mobile.android.global.a;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.mobile.android.widgets.u;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class UPWidget extends aa implements u.b {

    /* renamed from: o  reason: collision with root package name */
    private static final int f24254o = a.f23329t / 3;

    /* renamed from: p  reason: collision with root package name */
    private long f24256p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f24257q = true;

    /* renamed from: r  reason: collision with root package name */
    private String f24258r = null;

    /* renamed from: c  reason: collision with root package name */
    protected int f24255c = 0;

    /* renamed from: s  reason: collision with root package name */
    private boolean f24259s = false;

    /* renamed from: t  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f24260t = new aw(this);

    /* renamed from: u  reason: collision with root package name */
    private bb f24261u = null;

    /* renamed from: v  reason: collision with root package name */
    private View.OnClickListener f24262v = new ax(this);

    public UPWidget(Context context, long j10, int i10, JSONObject jSONObject, String str) {
        super(context, i10, jSONObject, str);
        this.f24256p = j10;
        ((aa) this).f24277b.a((u.b) this);
        ((aa) this).f24277b.a(new InputFilter.LengthFilter(6));
        ((aa) this).f24277b.f();
        ((aa) this).f24277b.d();
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void appendOnce(long j10, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(UPWidget uPWidget) {
        k.a("kb", "pwdInputFinished() +++");
        k.a("kb", "size = " + uPWidget.f24255c);
        uPWidget.k();
        k.a("kb", "pwdInputFinished() ---");
    }

    private native void clearAll(long j10);

    /* JADX INFO: Access modifiers changed from: private */
    public native void deleteOnce(long j10);

    private native String getMsg(long j10);

    private native String getMsgExtra(long j10, String str);

    private void w() {
        if (x() != null) {
            x().getViewTreeObserver().removeGlobalOnLayoutListener(this.f24260t);
        }
        bb bbVar = this.f24261u;
        if (bbVar != null && bbVar.b()) {
            this.f24261u.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View x() {
        return ((Activity) this.f24347d).findViewById(8888);
    }

    @Override // com.unionpay.mobile.android.widgets.aa, com.unionpay.mobile.android.widgets.ba.a
    public final String a() {
        return this.f24257q ? getMsgExtra(this.f24256p, this.f24258r) : getMsg(this.f24256p);
    }

    public final void a(long j10) {
        this.f24256p = j10;
    }

    @Override // com.unionpay.mobile.android.widgets.u.a
    public final void a(boolean z10) {
        this.f24259s = z10;
        if (z10) {
            boolean z11 = false;
            ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(((aa) this).f24277b.getWindowToken(), 0);
            z11 = true;
            int height = x().getRootView().getHeight() - x().getHeight();
            Rect rect = new Rect();
            getWindowVisibleDisplayFrame(rect);
            if (height == rect.top) {
            }
            if (z11) {
                l();
            } else if (!j()) {
                k.a("uppay", "key board is closing..");
                k.a("uppay", "registerKeyboardDissmisslisner() +++");
                if (x() != null) {
                    x().getViewTreeObserver().addOnGlobalLayoutListener(this.f24260t);
                }
                k.a("uppay", "registerKeyboardDissmisslisner() ---");
            }
        } else {
            w();
        }
    }

    @Override // com.unionpay.mobile.android.widgets.u.b
    public final void a_() {
        if (this.f24259s && !j()) {
            l();
        }
    }

    public final void b(String str) {
        this.f24258r = str;
    }

    public final void b(boolean z10) {
        this.f24257q = z10;
    }

    @Override // com.unionpay.mobile.android.widgets.ba.a
    public final boolean b() {
        return this.f24255c == 6;
    }

    @Override // com.unionpay.mobile.android.widgets.aa, com.unionpay.mobile.android.widgets.ba.a
    public final boolean c() {
        k.a("uppay", "emptyCheck() +++ ");
        k.a("uppay", "mPINCounts =  " + this.f24255c);
        k.a("uppay", "emptyCheck() --- ");
        return this.f24255c != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.ba
    public final String d() {
        return "_bank_pwd";
    }

    @Override // com.unionpay.mobile.android.widgets.u.b
    public final void e() {
        clearAll(this.f24256p);
        this.f24255c = 0;
    }

    public final boolean j() {
        bb bbVar = this.f24261u;
        return bbVar != null && bbVar.b();
    }

    public final void k() {
        k.a("uppay", "closeCustomKeyboard() +++");
        if (j()) {
            w();
        }
        k.a("uppay", "closeCustomKeyboard() ---");
    }

    public final void l() {
        if (this.f24259s && !j()) {
            bb bbVar = new bb(getContext(), this.f24262v, this);
            this.f24261u = bbVar;
            bbVar.a(this);
            String str = "";
            for (int i10 = 0; i10 < this.f24255c; i10++) {
                str = str + MessageProxyConstants.NODE_ID_ANY;
            }
            ((aa) this).f24277b.c(str);
            ((aa) this).f24277b.b(str.length());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k();
    }
}
