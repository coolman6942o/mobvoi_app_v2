package com.unionpay.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.unionpay.UPQuerySEPayInfoCallback;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.mi.UPTsmAddon;
import com.unionpay.tsmservice.mi.request.QueryVendorPayStatusRequestParams;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.b;
import com.unionpay.utils.j;
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f23286a;

    /* renamed from: b  reason: collision with root package name */
    private UPQuerySEPayInfoCallback f23287b;

    /* renamed from: c  reason: collision with root package name */
    private UPTsmAddon f23288c;

    /* renamed from: d  reason: collision with root package name */
    private String f23289d;

    /* renamed from: e  reason: collision with root package name */
    private String f23290e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23291f;

    /* renamed from: g  reason: collision with root package name */
    private QueryVendorPayStatusRequestParams f23292g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler.Callback f23293h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler f23294i;

    /* renamed from: j  reason: collision with root package name */
    private final UPTsmAddon.UPTsmConnectionListener f23295j = new i(this);

    public g(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback, boolean z10) {
        String str = "";
        this.f23289d = str;
        this.f23290e = str;
        this.f23291f = false;
        h hVar = new h(this);
        this.f23293h = hVar;
        this.f23294i = new Handler(hVar);
        this.f23286a = context;
        this.f23287b = uPQuerySEPayInfoCallback;
        this.f23291f = z10;
        if (z10) {
            System.loadLibrary("entryexpro");
            String a10 = UPUtils.a(this.f23286a, "mode");
            str = a10 != null ? a10 : str;
            try {
                Integer.decode(!b.c(str) ? "02" : str).intValue();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, int i10, String str) {
        if (i10 == 4000) {
            gVar.a(gVar.f23289d, gVar.f23290e, UPSEInfoResp.ERROR_NOT_SUPPORT, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(g gVar, Bundle bundle) {
        Context context;
        gVar.f23289d = bundle.getString("vendorPayName");
        gVar.f23290e = bundle.getString("vendorPayAliasType");
        int i10 = bundle.getInt("vendorPayStatus");
        String string = bundle.getString("errorDesc");
        int i11 = bundle.getInt("cardNumber", 0);
        if (!TextUtils.isEmpty(gVar.f23290e) && (context = gVar.f23286a) != null) {
            UPUtils.a(context, gVar.f23290e, "se_type");
        }
        if (i10 != 0) {
            if (i10 == 1) {
                gVar.a(gVar.f23289d, gVar.f23290e, UPSEInfoResp.ERROR_NOT_READY, "not ready");
            } else if (i10 == 2 || i10 == 3 || i10 == 4) {
                gVar.a(gVar.f23289d, gVar.f23290e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
            } else {
                gVar.a(gVar.f23289d, gVar.f23290e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
            }
        } else if (i11 > 0) {
            String str = gVar.f23289d;
            String str2 = gVar.f23290e;
            gVar.c();
            UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = gVar.f23287b;
            if (uPQuerySEPayInfoCallback != null) {
                uPQuerySEPayInfoCallback.onResult(str, str2, i11, bundle);
            }
        } else {
            gVar.a(gVar.f23289d, gVar.f23290e, UPSEInfoResp.ERROR_NOT_READY, "card number 0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        c();
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.f23287b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onError(str, str2, str3, str4);
        }
    }

    private boolean a(String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f23286a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        j.a("tsm-client", "tsm version code=" + packageInfo.versionCode);
        return packageInfo.versionCode >= 8;
    }

    private void c() {
        UPTsmAddon uPTsmAddon = this.f23288c;
        if (uPTsmAddon != null) {
            uPTsmAddon.removeConnectionListener(this.f23295j);
            this.f23288c.unbind();
        }
    }

    public final int a() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.f23286a == null || this.f23287b == null) {
            return UPSEInfoResp.PARAM_ERROR;
        }
        if (a("com.unionpay.tsmservice.mi")) {
            UPTsmAddon uPTsmAddon = UPTsmAddon.getInstance(this.f23286a);
            this.f23288c = uPTsmAddon;
            uPTsmAddon.addConnectionListener(this.f23295j);
            j.b("uppay-spay", "type se  bind service");
            UPTsmAddon uPTsmAddon2 = this.f23288c;
            if (uPTsmAddon2 == null || uPTsmAddon2.isConnected()) {
                UPTsmAddon uPTsmAddon3 = this.f23288c;
                if (uPTsmAddon3 != null && uPTsmAddon3.isConnected()) {
                    j.b("uppay", "tsm service already connected");
                    b();
                }
            } else {
                j.b("uppay", "bind service");
                if (!this.f23288c.bind()) {
                    str4 = this.f23289d;
                    str3 = this.f23290e;
                    str2 = UPSEInfoResp.ERROR_NONE;
                    str = "Tsm service bind fail";
                }
            }
            return UPSEInfoResp.SUCCESS;
        } else if (!b.d(this.f23286a, "com.unionpay.tsmservice.mi")) {
            str4 = this.f23289d;
            str3 = this.f23290e;
            str2 = UPSEInfoResp.ERROR_TSM_UNINSTALLED;
            str = "Mi Tsm service apk is not installed";
        } else {
            str4 = this.f23289d;
            str3 = this.f23290e;
            str2 = UPSEInfoResp.ERROR_NOT_SUPPORT;
            str = "Mi Tsm service apk version is low";
        }
        a(str4, str3, str2, str);
        return UPSEInfoResp.SUCCESS;
    }

    public final boolean b() {
        try {
            j.b("uppay", "getVendorPayStatus()");
            if (this.f23292g == null) {
                this.f23292g = new QueryVendorPayStatusRequestParams();
            }
            if (this.f23288c.queryVendorPayStatus(this.f23292g, new j(this.f23294i)) != 0) {
                j.b("uppay", "ret != 0");
                a(this.f23289d, this.f23290e, UPSEInfoResp.ERROR_NOT_SUPPORT, "Mi Tsm service apk version is low");
                return false;
            }
            Handler handler = this.f23294i;
            handler.sendMessageDelayed(Message.obtain(handler, 4, AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED, 0, ""), 5000L);
            return true;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
