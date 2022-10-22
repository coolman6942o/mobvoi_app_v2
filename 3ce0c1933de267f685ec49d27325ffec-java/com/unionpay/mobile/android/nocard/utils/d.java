package com.unionpay.mobile.android.nocard.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.unionpay.mobile.android.callback.UPAndroidCallback;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.plugin.BaseActivity;
import com.unionpay.mobile.android.utils.k;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static UPAndroidCallback f23581a;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
        if (r3 != 1000) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, b bVar) {
        String str;
        String str2;
        String str3;
        k.b("uppay", "exit() +++");
        k.a("uppay", "reqId=" + bVar.I.f23861a);
        BaseActivity baseActivity = (BaseActivity) context;
        if (bVar.I.f23866f.length() > 0) {
            k.a("uppay", "result=" + bVar.I.f23866f);
            int i10 = bVar.I.f23861a;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 == 3) {
                            k.b("uppay", "notifyTencentJarResult() +++");
                            Intent intent = new Intent();
                            intent.putExtra("pay_result", bVar.I.f23866f);
                            intent.putExtra("tencentWID", bVar.I.f23868h);
                            intent.putExtra("tencentUID", bVar.I.f23867g);
                            intent.putExtra("bankInfo", bVar.I.f23870j);
                            intent.putExtra("cardType", bVar.I.f23871k);
                            intent.putExtra("cardNo", bVar.I.f23869i);
                            baseActivity.setResult(-1, intent);
                            str2 = "notifyTencentJarResult() ---";
                            k.b("uppay", str2);
                        } else if (i10 != 4) {
                            if (i10 != 5) {
                            }
                        }
                    }
                }
                k.b("uppay", " notifyBrowserResult() +++ ");
                Intent intent2 = null;
                String str4 = bVar.I.f23866f;
                String str5 = str4.equalsIgnoreCase(Constant.CASH_LOAD_FAIL) ? "1" : str4.equalsIgnoreCase(Constant.CASH_LOAD_CANCEL) ? "-1" : "0";
                int i11 = bVar.I.f23861a;
                if (i11 == 1) {
                    intent2 = new Intent(bVar.I.f23862b);
                    k.b("uppay", " other browser ");
                    k.a("uppay", " result Action=" + bVar.I.f23862b);
                } else if (i11 == 4) {
                    Intent intent3 = new Intent("com.UCMobile.PluginApp.ActivityState");
                    intent3.putExtra("ActivityState", "inactive");
                    intent3.addCategory("android.intent.category.DEFAULT");
                    baseActivity.sendBroadcast(intent3);
                    intent2 = new Intent("com.unionpay.uppay.resultURL");
                    k.b("uppay", " uc browser ");
                }
                if (!TextUtils.isEmpty(bVar.f23542r) && !"exit".equalsIgnoreCase(bVar.f23542r)) {
                    String str6 = bVar.f23542r + str5;
                    k.a("uppay", "result URL= " + str6);
                    try {
                        if (1000 == bVar.I.f23861a) {
                            Intent intent4 = new Intent("android.intent.action.VIEW", Uri.parse(str6));
                            intent4.addCategory("android.intent.category.BROWSABLE");
                            baseActivity.startActivity(intent4);
                        } else {
                            intent2.putExtra("ResultURL", str6);
                            k.a("browser", intent2.toURI());
                            baseActivity.sendBroadcast(intent2);
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    str2 = " notifyBrowserResult() --- ";
                    k.b("uppay", str2);
                }
            }
            k.b("uppay", "notifyAppResult() +++");
            Intent intent5 = new Intent();
            intent5.putExtra("pay_result", bVar.I.f23866f);
            intent5.putExtra("result_data", bVar.f23523bj);
            String str7 = bVar.V;
            if (str7 != null && str7.length() > 0 && (str3 = bVar.W) != null && str3.length() > 0 && !bVar.U) {
                intent5.putExtra("notify_url", bVar.V);
                intent5.putExtra("notify_msg", bVar.W);
            }
            String str8 = bVar.f23538n;
            if (str8 != null) {
                intent5.putExtra("qn", str8);
                intent5.putExtra("sid", bVar.f23535k);
                intent5.putExtra("secret", bVar.f23536l);
            }
            UPAndroidCallback uPAndroidCallback = f23581a;
            if (uPAndroidCallback != null) {
                uPAndroidCallback.UPAndroidOK(bVar.I.f23866f, bVar.f23538n, bVar.f23535k, bVar.f23536l);
            }
            baseActivity.setResult(-1, intent5);
            str2 = "notifyAppResult() ---";
            k.b("uppay", str2);
        }
        String str9 = bVar.V;
        if (str9 != null && str9.length() > 0 && (str = bVar.W) != null && str.length() > 0) {
            boolean z10 = bVar.U;
            String str10 = bVar.V;
            String str11 = bVar.W;
            if (z10) {
                new Thread(new e(str10, str11, context)).start();
            }
        }
        baseActivity.finish();
        k.b("uppay", "exit() +++");
    }
}
