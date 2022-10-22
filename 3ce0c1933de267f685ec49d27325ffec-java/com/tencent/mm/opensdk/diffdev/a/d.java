package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Base64;
import com.huawei.hms.feature.dynamic.b;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d extends AsyncTask<Void, Void, a> {

    /* renamed from: h  reason: collision with root package name */
    private static String f22461h = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    private String appId;

    /* renamed from: i  reason: collision with root package name */
    private String f22462i;

    /* renamed from: j  reason: collision with root package name */
    private String f22463j;

    /* renamed from: k  reason: collision with root package name */
    private OAuthListener f22464k;

    /* renamed from: l  reason: collision with root package name */
    private f f22465l;
    private String scope;
    private String signature;

    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: m  reason: collision with root package name */
        public OAuthErrCode f22466m;

        /* renamed from: n  reason: collision with root package name */
        public String f22467n;

        /* renamed from: o  reason: collision with root package name */
        public String f22468o;

        /* renamed from: p  reason: collision with root package name */
        public String f22469p;

        /* renamed from: q  reason: collision with root package name */
        public int f22470q;

        /* renamed from: r  reason: collision with root package name */
        public String f22471r;

        /* renamed from: s  reason: collision with root package name */
        public byte[] f22472s;

        private a() {
        }

        public static a a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            a aVar = new a();
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i10 = jSONObject.getInt(b.f13796g);
                        if (i10 != 0) {
                            Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i10)));
                            aVar.f22466m = OAuthErrCode.WechatAuth_Err_NormalErr;
                            aVar.f22470q = i10;
                            aVar.f22471r = jSONObject.optString("errmsg");
                            return aVar;
                        }
                        String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                        if (!(string == null || string.length() == 0)) {
                            byte[] decode = Base64.decode(string, 0);
                            if (!(decode == null || decode.length == 0)) {
                                aVar.f22466m = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.f22472s = decode;
                                aVar.f22467n = jSONObject.getString("uuid");
                                String string2 = jSONObject.getString("appname");
                                aVar.f22468o = string2;
                                Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f22467n, string2, Integer.valueOf(aVar.f22472s.length)));
                                return aVar;
                            }
                            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                            aVar.f22466m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                            return aVar;
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                        aVar.f22466m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    } catch (Exception e10) {
                        format = String.format("parse json fail, ex = %s", e10.getMessage());
                        Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f22466m = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e11) {
                    format = String.format("parse fail, build String fail, ex = %s", e11.getMessage());
                }
            }
            aVar.f22466m = oAuthErrCode;
            return aVar;
        }
    }

    public d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.f22462i = str3;
        this.f22463j = str4;
        this.signature = str5;
        this.f22464k = oAuthListener;
    }

    public final boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        f fVar = this.f22465l;
        return fVar == null ? cancel(true) : fVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format(f22461h, this.appId, this.f22462i, this.f22463j, this.scope, this.signature);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a10 = e.a(format);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.a(a10);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f22466m;
        if (oAuthErrCode == OAuthErrCode.WechatAuth_Err_OK) {
            Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f22472s.length);
            this.f22464k.onAuthGotQrcode(aVar2.f22469p, aVar2.f22472s);
            f fVar = new f(aVar2.f22467n, this.f22464k);
            this.f22465l = fVar;
            if (Build.VERSION.SDK_INT >= 11) {
                fVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                fVar.execute(new Void[0]);
            }
        } else {
            Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
            this.f22464k.onAuthFinish(aVar2.f22466m, null);
        }
    }
}
