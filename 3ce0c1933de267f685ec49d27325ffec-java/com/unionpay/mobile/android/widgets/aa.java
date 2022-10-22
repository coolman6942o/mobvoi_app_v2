package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.amap.api.services.core.AMapException;
import com.unionpay.mobile.android.resource.c;
import com.unionpay.mobile.android.utils.j;
import java.util.Objects;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class aa extends z {

    /* renamed from: a  reason: collision with root package name */
    protected int f24276a;

    /* renamed from: b  reason: collision with root package name */
    protected u f24277b;

    /* renamed from: c  reason: collision with root package name */
    private a f24278c;

    /* loaded from: classes2.dex */
    public interface a {
        void a(u uVar, String str);
    }

    public aa(Context context, int i10, JSONObject jSONObject, String str) {
        this(context, i10, jSONObject, str, (byte) 0);
    }

    public aa(Context context, int i10, JSONObject jSONObject, String str, byte b10) {
        super(context, jSONObject, str);
        u uVar;
        c a10;
        int i11;
        String str2;
        u uVar2;
        this.f24277b = null;
        this.f24278c = null;
        this.f24276a = i10;
        c.a(this.f24347d);
        u uVar3 = new u(getContext());
        this.f24277b = uVar3;
        if (this.f24352i) {
            uVar3.a();
            this.f24277b.d();
        }
        this.f24277b.c(i());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.unionpay.mobile.android.global.a.f23323n);
        layoutParams.addRule(15, -1);
        this.f24356m.addView(this.f24277b, layoutParams);
        this.f24277b.b(j.a(jSONObject, "placeholder"));
        this.f24277b.setFocusable(true);
        this.f24277b.a(new ab(this));
        this.f24277b.a(new ac(this));
        this.f24277b.a(c.a(this.f24347d).a(2000, -1, com.unionpay.mobile.android.global.a.f23331v));
        if (!(this instanceof af)) {
            if (this instanceof ap) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.aR;
            } else if (this instanceof ah) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.aT;
            } else if (this instanceof UPWidget) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.aS;
            } else if (this instanceof au) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.aU;
            } else if (this instanceof ao) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.aV;
            } else if (this instanceof e) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.aW;
            } else if (this instanceof ae) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.aX;
            } else if (this instanceof bd) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.aY;
            } else if (this instanceof at) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.aZ;
            } else if (this instanceof av) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.f23444ba;
            } else if (this instanceof f) {
                uVar2 = this.f24277b;
                str2 = com.unionpay.mobile.android.languages.c.bD.f23445bb;
            }
            uVar2.a(str2);
        } else if (!this.f24352i) {
            uVar2 = this.f24277b;
            str2 = com.unionpay.mobile.android.languages.c.bD.aQ;
            uVar2.a(str2);
        } else {
            u uVar4 = this.f24277b;
            uVar4.c(this.f24351h + " " + this.f24350g);
        }
        if (this instanceof k) {
            uVar = this.f24277b;
            a10 = c.a(this.f24347d);
            i11 = AMapException.CODE_AMAP_NOT_SUPPORT_HTTPS;
        } else {
            uVar = this.f24277b;
            a10 = c.a(this.f24347d);
            i11 = AMapException.CODE_AMAP_USER_KEY_RECYCLED;
        }
        uVar.setBackgroundDrawable(a10.a(i11, -1, -1));
    }

    public String a() {
        return this.f24277b.b();
    }

    public void a(Editable editable) {
    }

    public final void a(a aVar) {
        this.f24278c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a(View view) {
        Rect rect;
        int[] iArr;
        Rect rect2;
        Rect rect3;
        Objects.requireNonNull(view);
        view.getGlobalVisibleRect(new Rect());
        Log.e("uppay", "v getGlobalVisibleRect():" + rect.toString());
        Rect rect4 = new Rect();
        ((Activity) this.f24347d).getWindow().getDecorView().findViewById(16908290).getGlobalVisibleRect(rect4);
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr2);
        StringBuilder sb2 = new StringBuilder(" locationW = [");
        boolean z10 = false;
        sb2.append(iArr2[0]);
        sb2.append(",");
        sb2.append(iArr2[1]);
        sb2.append("]");
        Log.e("uppay", sb2.toString());
        view.getLocationOnScreen(new int[2]);
        Log.e("uppay", " locationS = [" + iArr[0] + "," + iArr[1] + "]");
        if (iArr2[1] + view.getHeight() + 10 > rect4.bottom) {
            z10 = true;
        }
        View findViewById = ((Activity) this.f24347d).getWindow().getDecorView().findViewById(16908290);
        findViewById.getLocalVisibleRect(new Rect());
        Log.e("uppay", " getLocalVisibleRect = " + rect2.toString());
        findViewById.getGlobalVisibleRect(new Rect());
        Log.e("uppay", " getGlobalVisibleRect = " + rect3.toString());
        return z10;
    }

    public final boolean a(u uVar) {
        return uVar != null && this.f24277b == uVar;
    }

    public boolean c() {
        return (a() == null || a().length() == 0) ? false : true;
    }

    public final void g() {
        u uVar = this.f24277b;
        if (uVar != null && !this.f24352i) {
            uVar.e();
        }
    }
}
