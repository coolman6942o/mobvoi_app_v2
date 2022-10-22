package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.huawei.agconnect.exception.AGCServerException;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;
/* loaded from: classes2.dex */
final class f extends AsyncTask<Void, Void, a> {

    /* renamed from: k  reason: collision with root package name */
    private OAuthListener f22473k;

    /* renamed from: n  reason: collision with root package name */
    private String f22474n;

    /* renamed from: t  reason: collision with root package name */
    private int f22475t;
    private String url;

    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: m  reason: collision with root package name */
        public OAuthErrCode f22476m;

        /* renamed from: u  reason: collision with root package name */
        public String f22477u;

        /* renamed from: v  reason: collision with root package name */
        public int f22478v;

        a() {
        }

        public static a b(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            OAuthErrCode oAuthErrCode2;
            a aVar = new a();
            Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                } catch (Exception e10) {
                    format = String.format("parse fail, build String fail, ex = %s", e10.getMessage());
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                    int i10 = jSONObject.getInt("wx_errcode");
                    aVar.f22478v = i10;
                    Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i10)));
                    int i11 = aVar.f22478v;
                    if (i11 == 408) {
                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                    } else if (i11 != 500) {
                        switch (i11) {
                            case 402:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Timeout;
                                break;
                            case AGCServerException.AUTHENTICATION_FAILED /* 403 */:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Cancel;
                                break;
                            case 404:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                                break;
                            case 405:
                                aVar.f22476m = OAuthErrCode.WechatAuth_Err_OK;
                                aVar.f22477u = jSONObject.getString("wx_code");
                                break;
                            default:
                                oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                break;
                        }
                        return aVar;
                    } else {
                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    aVar.f22476m = oAuthErrCode2;
                    return aVar;
                } catch (Exception e11) {
                    format = String.format("parse json fail, ex = %s", e11.getMessage());
                    Log.e("MicroMsg.SDK.NoopingResult", format);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.f22476m = oAuthErrCode;
                    return aVar;
                }
            }
            aVar.f22476m = oAuthErrCode;
            return aVar;
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.f22474n = str;
        this.f22473k = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ a doInBackground(Void[] voidArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str2 = this.f22474n;
        if (str2 == null || str2.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.url);
                if (this.f22475t == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.f22475t;
                }
                sb2.append(str);
                String sb3 = sb2.toString();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] a10 = e.a(sb3);
                long currentTimeMillis2 = System.currentTimeMillis();
                a b10 = a.b(a10);
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb3, b10.f22476m.toString(), Integer.valueOf(b10.f22478v), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                OAuthErrCode oAuthErrCode2 = b10.f22476m;
                if (oAuthErrCode2 == OAuthErrCode.WechatAuth_Err_OK) {
                    int i10 = b10.f22478v;
                    this.f22475t = i10;
                    if (i10 == g.UUID_SCANED.getCode()) {
                        this.f22473k.onQrcodeScanned();
                    } else if (b10.f22478v != g.UUID_KEEP_CONNECT.getCode() && b10.f22478v == g.UUID_CONFIRM.getCode()) {
                        String str3 = b10.f22477u;
                        if (str3 == null || str3.length() == 0) {
                            Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                            b10.f22476m = OAuthErrCode.WechatAuth_Err_NormalErr;
                        }
                        return b10;
                    }
                } else {
                    Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode2.toString(), Integer.valueOf(b10.f22478v)));
                    return b10;
                }
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.f22476m = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f22473k.onAuthFinish(aVar2.f22476m, aVar2.f22477u);
    }
}
