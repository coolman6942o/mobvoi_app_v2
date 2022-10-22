package com.unionpay.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alipay.sdk.app.PayTask;
import com.amap.api.services.core.AMapException;
import com.huawei.nfc.sdk.service.HwOpenPayTask;
import com.unionpay.UPQuerySEPayInfoCallback;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.UPTsmAddon;
import com.unionpay.tsmservice.data.Constant;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.utils.UPUtils;
import com.unionpay.utils.j;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f23271a;

    /* renamed from: b  reason: collision with root package name */
    private UPQuerySEPayInfoCallback f23272b;

    /* renamed from: c  reason: collision with root package name */
    private UPTsmAddon f23273c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23276f;

    /* renamed from: h  reason: collision with root package name */
    private QueryVendorPayStatusRequestParams f23278h;

    /* renamed from: i  reason: collision with root package name */
    private final Handler.Callback f23279i;

    /* renamed from: j  reason: collision with root package name */
    private final Handler f23280j;

    /* renamed from: d  reason: collision with root package name */
    private String f23274d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f23275e = "";

    /* renamed from: g  reason: collision with root package name */
    private boolean f23277g = false;

    /* renamed from: k  reason: collision with root package name */
    private final UPTsmAddon.UPTsmConnectionListener f23281k = new e(this);

    public b(Context context, UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback, boolean z10) {
        this.f23276f = false;
        c cVar = new c(this);
        this.f23279i = cVar;
        this.f23280j = new Handler(cVar);
        this.f23271a = context;
        this.f23272b = uPQuerySEPayInfoCallback;
        this.f23276f = z10;
        if (z10) {
            System.loadLibrary("entryexpro");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, int i10, String str) {
        if (i10 == 4000) {
            bVar.a(bVar.f23274d, bVar.f23275e, UPSEInfoResp.ERROR_NOT_SUPPORT, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, Bundle bundle) {
        Context context;
        bVar.f23274d = bundle.getString("vendorPayName");
        bVar.f23275e = bundle.getString("vendorPayAliasType");
        int i10 = bundle.getInt("vendorPayStatus");
        String string = bundle.getString("errorDesc");
        int i11 = bundle.getInt("cardNumber", 0);
        if (!TextUtils.isEmpty(bVar.f23275e) && (context = bVar.f23271a) != null) {
            UPUtils.a(context, bVar.f23275e, "se_type");
        }
        if (i10 != 0) {
            if (i10 == 1) {
                bVar.a(bVar.f23274d, bVar.f23275e, UPSEInfoResp.ERROR_NOT_READY, "not ready");
            } else if (i10 == 2 || i10 == 3 || i10 == 4) {
                bVar.a(bVar.f23274d, bVar.f23275e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
            } else {
                bVar.a(bVar.f23274d, bVar.f23275e, UPSEInfoResp.ERROR_NOT_SUPPORT, string);
            }
        } else if (i11 > 0) {
            bVar.a(bVar.f23274d, bVar.f23275e, i11, bundle);
        } else {
            bVar.a(bVar.f23274d, bVar.f23275e, UPSEInfoResp.ERROR_NOT_READY, "card number 0");
        }
    }

    private void a(String str, String str2, int i10, Bundle bundle) {
        d();
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.f23272b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onResult(str, str2, i10, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3, String str4) {
        d();
        UPQuerySEPayInfoCallback uPQuerySEPayInfoCallback = this.f23272b;
        if (uPQuerySEPayInfoCallback != null) {
            uPQuerySEPayInfoCallback.onError(str, str2, str3, str4);
        }
    }

    private boolean a(String str) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.f23271a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (packageInfo == null) {
            return false;
        }
        j.a("tsm-client", "tsm version code=" + packageInfo.versionCode);
        return packageInfo.versionCode >= 18;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(b bVar, Bundle bundle) {
        if (bundle != null) {
            bVar.f23274d = "Huawei Pay";
            bVar.f23275e = Constant.RECHARGE_MODE_DESIGNATED_AND_CACH;
            if ("0000".equals(bundle.getString(Constant.KEY_RESULT_CODE))) {
                bVar.a(bVar.f23274d, bVar.f23275e, bundle.getInt("cardNumber"), bundle);
                return;
            }
            bVar.a(bVar.f23274d, bVar.f23275e, UPSEInfoResp.ERROR_NOT_READY, "not ready");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str;
        String str2;
        String str3;
        String str4;
        if (a("com.unionpay.tsmservice")) {
            UPTsmAddon uPTsmAddon = UPTsmAddon.getInstance(this.f23271a);
            this.f23273c = uPTsmAddon;
            uPTsmAddon.addConnectionListener(this.f23281k);
            j.b("uppay-spay", "type se  bind service");
            UPTsmAddon uPTsmAddon2 = this.f23273c;
            if (uPTsmAddon2 == null || uPTsmAddon2.isConnected()) {
                UPTsmAddon uPTsmAddon3 = this.f23273c;
                if (uPTsmAddon3 != null && uPTsmAddon3.isConnected()) {
                    j.b("uppay", "tsm service already connected");
                    b();
                    return;
                }
                return;
            }
            j.b("uppay", "bind service");
            if (!this.f23273c.bind()) {
                a(this.f23274d, this.f23275e, UPSEInfoResp.ERROR_NONE, "Tsm service bind fail");
                return;
            }
            return;
        }
        if (!com.unionpay.utils.b.d(this.f23271a, "com.unionpay.tsmservice")) {
            str = this.f23274d;
            str2 = this.f23275e;
            str3 = UPSEInfoResp.ERROR_TSM_UNINSTALLED;
            str4 = "Tsm service apk is not installed";
        } else {
            str = this.f23274d;
            str2 = this.f23275e;
            str3 = UPSEInfoResp.ERROR_NOT_SUPPORT;
            str4 = "Tsm service apk version is low";
        }
        a(str, str2, str3, str4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(b bVar, Bundle bundle) {
        if (bundle != null) {
            bVar.f23274d = "Huawei Pay";
            bVar.f23275e = Constant.RECHARGE_MODE_DESIGNATED_AND_CACH;
            String string = bundle.getString("errorCode");
            bVar.a(bVar.f23274d, bVar.f23275e, "0002".equals(string) ? UPSEInfoResp.ERROR_NOT_READY : UPSEInfoResp.ERROR_NOT_SUPPORT, bundle.getString("errorDesc"));
        }
    }

    private void d() {
        UPTsmAddon uPTsmAddon = this.f23273c;
        if (uPTsmAddon != null) {
            uPTsmAddon.removeConnectionListener(this.f23281k);
            this.f23273c.unbind();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void e(b bVar) {
        HwOpenPayTask hwOpenPayTask = new HwOpenPayTask(bVar.f23271a);
        j.b("uppay", "queryHwPayStatus start");
        bVar.f23280j.sendEmptyMessageDelayed(4003, PayTask.f6879j);
        hwOpenPayTask.getUnionOnlinePayStatus(new f(bVar));
    }

    public final int a() {
        if (this.f23271a == null || this.f23272b == null) {
            return UPSEInfoResp.PARAM_ERROR;
        }
        this.f23277g = false;
        if (com.unionpay.utils.b.a()) {
            HwOpenPayTask hwOpenPayTask = new HwOpenPayTask(this.f23271a);
            j.b("uppay", "supportCapacity");
            this.f23280j.sendEmptyMessageDelayed(4005, 2000L);
            hwOpenPayTask.supportCapacity("UNIONONLINEPAY", new d(this));
        } else {
            c();
        }
        return UPSEInfoResp.SUCCESS;
    }

    public final boolean b() {
        try {
            j.b("uppay", "getVendorPayStatus()");
            if (this.f23278h == null) {
                this.f23278h = new QueryVendorPayStatusRequestParams();
            }
            if (this.f23273c.queryVendorPayStatus(this.f23278h, new a(this.f23280j)) != 0) {
                j.b("uppay", "ret != 0");
                a(this.f23274d, this.f23275e, UPSEInfoResp.ERROR_NOT_SUPPORT, "Tsm service apk version is low");
                return false;
            }
            Handler handler = this.f23280j;
            handler.sendMessageDelayed(Message.obtain(handler, 4, AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED, 0, ""), 5000L);
            return true;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
