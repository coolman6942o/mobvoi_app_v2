package com.unionpay.uppay;

import android.content.Intent;
import android.nfc.NfcManager;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import com.unionpay.mobile.android.hce.f;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.nocard.utils.UPPayEngine;
import com.unionpay.mobile.android.pboctransaction.nfc.b;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.mobile.android.pro.views.a;
import com.unionpay.mobile.android.pro.views.j;
import com.unionpay.mobile.android.pro.views.k;
import com.unionpay.mobile.android.pro.views.v;
import com.unionpay.mobile.android.pro.views.x;
import com.unionpay.mobile.android.utils.n;
/* loaded from: classes2.dex */
public final class PayActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    public static String f24577a = "";

    /* renamed from: f  reason: collision with root package name */
    private n f24580f;

    /* renamed from: d  reason: collision with root package name */
    private b f24578d = null;

    /* renamed from: e  reason: collision with root package name */
    private f f24579e = null;

    /* renamed from: g  reason: collision with root package name */
    private k f24581g = null;

    static {
        System.loadLibrary("entryexpro");
    }

    @Override // com.unionpay.mobile.android.plugin.a
    public final com.unionpay.mobile.android.nocard.views.b a(int i10, e eVar) {
        a aVar;
        if (i10 == 1) {
            j jVar = new j(this);
            jVar.a(a());
            return jVar;
        } else if (i10 == 2) {
            return new v(this, eVar);
        } else {
            if (i10 == 6) {
                return new x(this, eVar);
            }
            if (i10 == 17) {
                k kVar = new k(this, eVar, (UPPayEngine) a(UPPayEngine.class.toString()));
                this.f24581g = kVar;
                kVar.f23941r = c();
                this.f24581g.a(this.f23854c);
                aVar = kVar;
            } else if (i10 != 18) {
                return null;
            } else {
                aVar = new a(this, eVar, (UPPayEngine) a(UPPayEngine.class.toString()));
            }
            return aVar;
        }
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity
    public final Object a(String str) {
        if (b.class.toString().equalsIgnoreCase(str)) {
            if (this.f24578d == null) {
                this.f24578d = new b(this, c());
            }
            return this.f24578d;
        } else if (!f.class.toString().equalsIgnoreCase(str)) {
            return super.a(str);
        } else {
            if (this.f24579e == null) {
                this.f24579e = new f(this);
            }
            return this.f24579e;
        }
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity
    public final boolean a() {
        if (Build.VERSION.SDK_INT < 10) {
            return false;
        }
        return (getPackageManager().checkPermission("android.permission.NFC", com.unionpay.mobile.android.utils.f.a(this)) == 0) && ((NfcManager) getSystemService("nfc")).getDefaultAdapter() != null;
    }

    @Override // com.unionpay.mobile.android.plugin.b
    public final UPPayEngine d() {
        n nVar = new n(this);
        this.f24580f = nVar;
        return nVar;
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity, android.app.Activity
    protected final void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        k kVar = this.f24581g;
        if (kVar != null && kVar.getParent() != null) {
            this.f24581g.a(this.f23854c);
        }
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity, android.app.Activity
    protected final void onDestroy() {
        super.onDestroy();
        b bVar = this.f24578d;
        if (bVar != null) {
            bVar.a();
            this.f24578d = null;
        }
        this.f24580f.h();
        this.f24580f = null;
        this.f24581g = null;
        f24577a = "";
    }

    @Override // android.app.Activity
    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Parcelable parcelableExtra = intent.getParcelableExtra("android.nfc.extra.TAG");
        if (parcelableExtra != null) {
            Log.d("NFCTAG", intent.getAction());
            b.C0264b bVar = new b.C0264b(IsoDep.get((Tag) parcelableExtra));
            bVar.a();
            com.unionpay.mobile.android.pboctransaction.nfc.a aVar = new com.unionpay.mobile.android.pboctransaction.nfc.a((com.unionpay.mobile.android.fully.a) a(UPPayEngine.class.toString()), bVar);
            k kVar = this.f24581g;
            if (kVar != null && kVar.getParent() != null) {
                this.f24581g.a(aVar);
            }
        }
    }

    @Override // com.unionpay.mobile.android.plugin.BaseActivity, android.app.Activity
    protected final void onResume() {
        super.onResume();
        k kVar = this.f24581g;
        if (kVar != null && kVar.getParent() != null) {
            this.f24581g.a(this.f23854c);
        }
    }
}
