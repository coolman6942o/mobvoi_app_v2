package com.tencent.mm.opensdk.openapi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.mobvoi.wear.providers.SocialContract;
import com.mobvoi.wear.util.TelephonyUtil;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.a.a;
import com.tencent.mm.opensdk.channel.a.b;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.ChooseCardFromWXCardPackage;
import com.tencent.mm.opensdk.modelbiz.CreateChatroom;
import com.tencent.mm.opensdk.modelbiz.HandleScanResult;
import com.tencent.mm.opensdk.modelbiz.JoinChatroom;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.opensdk.modelbiz.SubscribeMessage;
import com.tencent.mm.opensdk.modelbiz.SubscribeMiniProgramMsg;
import com.tencent.mm.opensdk.modelbiz.WXInvoiceAuthInsert;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgramWithToken;
import com.tencent.mm.opensdk.modelbiz.WXNontaxPay;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessWebview;
import com.tencent.mm.opensdk.modelbiz.WXPayInsurance;
import com.tencent.mm.opensdk.modelbiz.WXPreloadMiniProgram;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.LaunchFromWX;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.modelpay.JumpToOfflinePay;
import com.tencent.mm.opensdk.modelpay.PayResp;
import com.tencent.mm.opensdk.modelpay.WXJointPay;
import com.tencent.mm.opensdk.utils.ILog;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
import com.unionpay.tsmservice.data.Constant;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
/* loaded from: classes2.dex */
class BaseWXApiImplV10 implements IWXAPI {
    protected static final String TAG = "MicroMsg.SDK.WXApiImplV10";
    private static String wxappPayEntryClassname;
    protected String appId;
    protected boolean checkSignature;
    protected Context context;
    protected boolean detached = false;
    private int wxSdkVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseWXApiImplV10(Context context, String str, boolean z10) {
        this.checkSignature = false;
        Log.d(TAG, "<init>, appId = " + str + ", checkSignature = " + z10);
        this.context = context;
        this.appId = str;
        this.checkSignature = z10;
        d.D = context.getApplicationContext();
    }

    private boolean checkSumConsistent(byte[] bArr, byte[] bArr2) {
        String str;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            str = "checkSumConsistent fail, invalid arguments";
        } else if (bArr.length != bArr2.length) {
            str = "checkSumConsistent fail, length is different";
        } else {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                if (bArr[i10] != bArr2[i10]) {
                    return false;
                }
            }
            return true;
        }
        Log.e(TAG, str);
        return false;
    }

    private boolean createChatroom(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/createChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_create_chatroom_group_id", ""), bundle.getString("_wxapi_create_chatroom_chatroom_name", ""), bundle.getString("_wxapi_create_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_create_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private String getTokenFromWX(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/genTokenForOpenSdk"), null, null, new String[]{this.appId, "621086720"}, null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        String string = query.getString(0);
        Log.i(TAG, "getTokenFromWX token is " + string);
        query.close();
        return string;
    }

    private boolean handleWxInternalRespType(String str, IWXAPIEventHandler iWXAPIEventHandler) {
        Uri parse;
        String queryParameter;
        Log.i(TAG, "handleWxInternalRespType, extInfo = " + str);
        try {
            parse = Uri.parse(str);
            queryParameter = parse.getQueryParameter("wx_internal_resptype");
            Log.i(TAG, "handleWxInternalRespType, respType = " + queryParameter);
        } catch (Exception e10) {
            Log.e(TAG, "handleWxInternalRespType fail, ex = " + e10.getMessage());
        }
        if (d.b(queryParameter)) {
            Log.e(TAG, "handleWxInternalRespType fail, respType is null");
            return false;
        } else if (queryParameter.equals("subscribemessage")) {
            SubscribeMessage.Resp resp = new SubscribeMessage.Resp();
            String queryParameter2 = parse.getQueryParameter("ret");
            if (queryParameter2 != null && queryParameter2.length() > 0) {
                resp.errCode = d.c(queryParameter2);
            }
            resp.openId = parse.getQueryParameter("openid");
            resp.templateID = parse.getQueryParameter("template_id");
            resp.scene = d.c(parse.getQueryParameter("scene"));
            resp.action = parse.getQueryParameter(TelephonyUtil.KEY_SIM_ACTION);
            resp.reserved = parse.getQueryParameter("reserved");
            iWXAPIEventHandler.onResp(resp);
            return true;
        } else if (queryParameter.contains("invoice_auth_insert")) {
            WXInvoiceAuthInsert.Resp resp2 = new WXInvoiceAuthInsert.Resp();
            String queryParameter3 = parse.getQueryParameter("ret");
            if (queryParameter3 != null && queryParameter3.length() > 0) {
                resp2.errCode = d.c(queryParameter3);
            }
            resp2.wxOrderId = parse.getQueryParameter("wx_order_id");
            iWXAPIEventHandler.onResp(resp2);
            return true;
        } else if (queryParameter.contains("payinsurance")) {
            WXPayInsurance.Resp resp3 = new WXPayInsurance.Resp();
            String queryParameter4 = parse.getQueryParameter("ret");
            if (queryParameter4 != null && queryParameter4.length() > 0) {
                resp3.errCode = d.c(queryParameter4);
            }
            resp3.wxOrderId = parse.getQueryParameter("wx_order_id");
            iWXAPIEventHandler.onResp(resp3);
            return true;
        } else if (queryParameter.contains("nontaxpay")) {
            WXNontaxPay.Resp resp4 = new WXNontaxPay.Resp();
            String queryParameter5 = parse.getQueryParameter("ret");
            if (queryParameter5 != null && queryParameter5.length() > 0) {
                resp4.errCode = d.c(queryParameter5);
            }
            resp4.wxOrderId = parse.getQueryParameter("wx_order_id");
            iWXAPIEventHandler.onResp(resp4);
            return true;
        } else {
            if (!"subscribeminiprogrammsg".equals(queryParameter) && !"5".equals(queryParameter)) {
                Log.e(TAG, "this open sdk version not support the request type");
                return false;
            }
            SubscribeMiniProgramMsg.Resp resp5 = new SubscribeMiniProgramMsg.Resp();
            String queryParameter6 = parse.getQueryParameter("ret");
            if (queryParameter6 != null && queryParameter6.length() > 0) {
                resp5.errCode = d.c(queryParameter6);
            }
            resp5.openId = parse.getQueryParameter("openid");
            resp5.unionId = parse.getQueryParameter("unionid");
            resp5.nickname = parse.getQueryParameter(SocialContract.RankingUserColumns.NICKNAME);
            resp5.errStr = parse.getQueryParameter("errmsg");
            iWXAPIEventHandler.onResp(resp5);
            return true;
        }
    }

    private boolean joinChatroom(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/joinChatroom"), null, null, new String[]{this.appId, bundle.getString("_wxapi_basereq_transaction", ""), bundle.getString("_wxapi_join_chatroom_group_id", ""), bundle.getString("_wxapi_join_chatroom_chatroom_nickname", ""), bundle.getString("_wxapi_join_chatroom_ext_msg", ""), bundle.getString("_wxapi_basereq_openid", "")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private void launchWXIfNeed() {
        if (Build.VERSION.SDK_INT >= 28) {
            Log.i(TAG, "openWXApp before api call");
            openWXApp();
        }
    }

    private boolean sendAddCardToWX(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/addCardToWX"), null, null, new String[]{this.appId, bundle.getString("_wxapi_add_card_to_wx_card_list"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendChooseCardFromWX(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/chooseCardFromWX"), null, null, new String[]{bundle.getString("_wxapi_choose_card_from_wx_card_app_id"), bundle.getString("_wxapi_choose_card_from_wx_card_location_id"), bundle.getString("_wxapi_choose_card_from_wx_card_sign_type"), bundle.getString("_wxapi_choose_card_from_wx_card_card_sign"), bundle.getString("_wxapi_choose_card_from_wx_card_time_stamp"), bundle.getString("_wxapi_choose_card_from_wx_card_nonce_str"), bundle.getString("_wxapi_choose_card_from_wx_card_card_id"), bundle.getString("_wxapi_choose_card_from_wx_card_card_type"), bundle.getString("_wxapi_choose_card_from_wx_card_can_multi_select"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendHandleScanResult(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/handleScanResult"), null, null, new String[]{this.appId, bundle.getString("_wxapi_scan_qrcode_result")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendInvoiceAuthInsert(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "2", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXInvoiceAuthInsert.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendJumpToOfflinePayReq(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/jumpToOfflinePay"), null, null, new String[]{this.appId}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogram(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        WXLaunchMiniProgram.Req req = (WXLaunchMiniProgram.Req) baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogram");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(req.miniprogramType);
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, req.userName, req.path, sb2.toString(), req.extData}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendLaunchWXMiniprogramWithToken(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/launchWXMiniprogramWithToken"), null, null, new String[]{this.appId, ((WXLaunchMiniProgramWithToken.Req) baseReq).token}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendNonTaxPay(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, Constant.APPLY_MODE_DECIDED_BY_BANK, URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXNontaxPay.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusiLuckyMoney(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusiLuckyMoney"), null, null, new String[]{this.appId, bundle.getString("_wxapi_open_busi_lucky_money_timeStamp"), bundle.getString("_wxapi_open_busi_lucky_money_nonceStr"), bundle.getString("_wxapi_open_busi_lucky_money_signType"), bundle.getString("_wxapi_open_busi_lucky_money_signature"), bundle.getString("_wxapi_open_busi_lucky_money_package")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusinessView(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        WXOpenBusinessView.Req req = (WXOpenBusinessView.Req) baseReq;
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessView"), null, null, new String[]{this.appId, req.businessType, req.query, req.extInfo, req.transaction}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenBusinessWebview(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        WXOpenBusinessWebview.Req req = (WXOpenBusinessWebview.Req) baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/openBusinessWebview");
        HashMap<String, String> hashMap = req.queryInfo;
        String jSONObject = (hashMap == null || hashMap.size() <= 0) ? "" : new JSONObject(req.queryInfo).toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(req.businessType);
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, sb2.toString(), jSONObject}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendOpenRankListReq(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openRankList"), null, null, new String[0], null);
        if (query == null) {
            return true;
        }
        query.close();
        return true;
    }

    private boolean sendOpenWebview(Context context, Bundle bundle) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openWebview"), null, null, new String[]{this.appId, bundle.getString("_wxapi_jump_to_webview_url"), bundle.getString("_wxapi_basereq_transaction")}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayInSurance(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "4", URLEncoder.encode(String.format("url=%s", URLEncoder.encode(((WXPayInsurance.Req) baseReq).url)))}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendPayReq(Context context, Bundle bundle) {
        if (wxappPayEntryClassname == null) {
            wxappPayEntryClassname = new MMSharedPreferences(context).getString("_wxapp_pay_entry_classname_", null);
            Log.d(TAG, "pay, set wxappPayEntryClassname = " + wxappPayEntryClassname);
            if (wxappPayEntryClassname == null) {
                try {
                    wxappPayEntryClassname = context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getString("com.tencent.mm.BuildInfo.OPEN_SDK_PAY_ENTRY_CLASSNAME", null);
                } catch (Exception e10) {
                    Log.e(TAG, "get from metaData failed : " + e10.getMessage());
                }
            }
            if (wxappPayEntryClassname == null) {
                Log.e(TAG, "pay fail, wxappPayEntryClassname is null");
                return false;
            }
        }
        MMessageActV2.Args args = new MMessageActV2.Args();
        args.bundle = bundle;
        args.targetPkgName = "com.tencent.mm";
        args.targetClassName = wxappPayEntryClassname;
        return MMessageActV2.send(context, args);
    }

    private boolean sendPreloadWXMiniprogram(Context context, BaseReq baseReq) {
        WXPreloadMiniProgram.Req req = (WXPreloadMiniProgram.Req) baseReq;
        ContentResolver contentResolver = context.getContentResolver();
        Uri parse = Uri.parse("content://com.tencent.mm.sdk.comm.provider/preloadWXMiniprogram");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(req.miniprogramType);
        Cursor query = contentResolver.query(parse, null, null, new String[]{this.appId, req.userName, req.path, sb2.toString(), req.extData}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendSubscribeMessage(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        SubscribeMessage.Req req = (SubscribeMessage.Req) baseReq;
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "1", String.valueOf(req.scene), req.templateID, req.reserved}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    private boolean sendSubscribeMiniProgramMsg(Context context, BaseReq baseReq) {
        launchWXIfNeed();
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.tencent.mm.sdk.comm.provider/openTypeWebview"), null, null, new String[]{this.appId, "5", ((SubscribeMiniProgramMsg.Req) baseReq).miniProgramAppId}, null);
        if (query != null) {
            query.close();
        }
        return true;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void detach() {
        Log.d(TAG, "detach");
        this.detached = true;
        this.context = null;
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public int getWXAppSupportAPI() {
        if (this.detached) {
            throw new IllegalStateException("getWXAppSupportAPI fail, WXMsgImpl has been detached");
        } else if (!isWXAppInstalled()) {
            Log.e(TAG, "open wx app failed, not installed or signature check failed");
            return 0;
        } else {
            this.wxSdkVersion = 0;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            d.H.submit(new Runnable() { // from class: com.tencent.mm.opensdk.openapi.BaseWXApiImplV10.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MMSharedPreferences mMSharedPreferences = new MMSharedPreferences(BaseWXApiImplV10.this.context);
                        BaseWXApiImplV10.this.wxSdkVersion = mMSharedPreferences.getInt("_build_info_sdk_int_", 0);
                    } catch (Exception e10) {
                        Log.w(BaseWXApiImplV10.TAG, e10.getMessage());
                    }
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(1000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e10) {
                Log.w(TAG, e10.getMessage());
            }
            Log.d(TAG, "wxSdkVersion = " + this.wxSdkVersion);
            if (this.wxSdkVersion == 0) {
                try {
                    this.wxSdkVersion = this.context.getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
                    Log.d(TAG, "OPEN_SDK_VERSION = " + this.wxSdkVersion);
                } catch (Exception e11) {
                    Log.e(TAG, "get from metaData failed : " + e11.getMessage());
                }
            }
            return this.wxSdkVersion;
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean handleIntent(Intent intent, IWXAPIEventHandler iWXAPIEventHandler) {
        try {
        } catch (Exception e10) {
            Log.e(TAG, "handleIntent fail, ex = " + e10.getMessage());
        }
        if (!WXApiImplComm.isIntentFromWx(intent, ConstantsAPI.Token.WX_TOKEN_VALUE_MSG)) {
            Log.i(TAG, "handleIntent fail, intent not from weixin msg");
            return false;
        } else if (!this.detached) {
            String stringExtra = intent.getStringExtra(ConstantsAPI.CONTENT);
            int intExtra = intent.getIntExtra(ConstantsAPI.SDK_VERSION, 0);
            String stringExtra2 = intent.getStringExtra(ConstantsAPI.APP_PACKAGE);
            if (!(stringExtra2 == null || stringExtra2.length() == 0)) {
                if (!checkSumConsistent(intent.getByteArrayExtra(ConstantsAPI.CHECK_SUM), b.a(stringExtra, intExtra, stringExtra2))) {
                    Log.e(TAG, "checksum fail");
                    return false;
                }
                int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
                Log.i(TAG, "handleIntent, cmd = " + intExtra2);
                switch (intExtra2) {
                    case 1:
                        iWXAPIEventHandler.onResp(new SendAuth.Resp(intent.getExtras()));
                        return true;
                    case 2:
                        iWXAPIEventHandler.onResp(new SendMessageToWX.Resp(intent.getExtras()));
                        return true;
                    case 3:
                        iWXAPIEventHandler.onReq(new GetMessageFromWX.Req(intent.getExtras()));
                        return true;
                    case 4:
                        ShowMessageFromWX.Req req = new ShowMessageFromWX.Req(intent.getExtras());
                        String str = req.message.messageExt;
                        if (str == null || !str.contains("wx_internal_resptype")) {
                            if (str != null && str.contains("openbusinesswebview")) {
                                try {
                                    Uri parse = Uri.parse(str);
                                    if (parse == null || !"openbusinesswebview".equals(parse.getHost())) {
                                        Log.d(TAG, "not openbusinesswebview %" + str);
                                    } else {
                                        WXOpenBusinessWebview.Resp resp = new WXOpenBusinessWebview.Resp();
                                        String queryParameter = parse.getQueryParameter("ret");
                                        if (queryParameter != null && queryParameter.length() > 0) {
                                            resp.errCode = d.c(queryParameter);
                                        }
                                        resp.resultInfo = parse.getQueryParameter("resultInfo");
                                        resp.errStr = parse.getQueryParameter("errmsg");
                                        String queryParameter2 = parse.getQueryParameter("type");
                                        if (queryParameter2 != null && queryParameter2.length() > 0) {
                                            resp.businessType = d.c(queryParameter2);
                                        }
                                        iWXAPIEventHandler.onResp(resp);
                                        return true;
                                    }
                                } catch (Exception e11) {
                                    Log.e(TAG, "parse fail, ex = " + e11.getMessage());
                                }
                            }
                            iWXAPIEventHandler.onReq(req);
                            return true;
                        }
                        boolean handleWxInternalRespType = handleWxInternalRespType(str, iWXAPIEventHandler);
                        Log.i(TAG, "handleIntent, extInfo contains wx_internal_resptype, ret = " + handleWxInternalRespType);
                        return handleWxInternalRespType;
                    case 5:
                        iWXAPIEventHandler.onResp(new PayResp(intent.getExtras()));
                        return true;
                    case 6:
                        iWXAPIEventHandler.onReq(new LaunchFromWX.Req(intent.getExtras()));
                        return true;
                    case 7:
                    case 8:
                    case 10:
                    case 11:
                    case 13:
                    case 18:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    default:
                        Log.e(TAG, "unknown cmd = " + intExtra2);
                        break;
                    case 9:
                        iWXAPIEventHandler.onResp(new AddCardToWXCardPackage.Resp(intent.getExtras()));
                        return true;
                    case 12:
                        iWXAPIEventHandler.onResp(new OpenWebview.Resp(intent.getExtras()));
                        return true;
                    case 14:
                        iWXAPIEventHandler.onResp(new CreateChatroom.Resp(intent.getExtras()));
                        return true;
                    case 15:
                        iWXAPIEventHandler.onResp(new JoinChatroom.Resp(intent.getExtras()));
                        return true;
                    case 16:
                        iWXAPIEventHandler.onResp(new ChooseCardFromWXCardPackage.Resp(intent.getExtras()));
                        return true;
                    case 17:
                        iWXAPIEventHandler.onResp(new HandleScanResult.Resp(intent.getExtras()));
                        return true;
                    case 19:
                        iWXAPIEventHandler.onResp(new WXLaunchMiniProgram.Resp(intent.getExtras()));
                        return true;
                    case 24:
                        iWXAPIEventHandler.onResp(new JumpToOfflinePay.Resp(intent.getExtras()));
                        return true;
                    case 25:
                        iWXAPIEventHandler.onResp(new WXOpenBusinessWebview.Resp(intent.getExtras()));
                        return true;
                    case 26:
                        iWXAPIEventHandler.onResp(new WXOpenBusinessView.Resp(intent.getExtras()));
                        return true;
                    case 27:
                        iWXAPIEventHandler.onResp(new WXJointPay.JointPayResp(intent.getExtras()));
                        return true;
                    case 28:
                        iWXAPIEventHandler.onResp(new WXPreloadMiniProgram.Resp(intent.getExtras()));
                        return true;
                    case 29:
                        iWXAPIEventHandler.onResp(new WXLaunchMiniProgramWithToken.Resp(intent.getExtras()));
                        return true;
                }
                return false;
            }
            Log.e(TAG, "invalid argument");
            return false;
        } else {
            throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean isWXAppInstalled() {
        if (!this.detached) {
            try {
                PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo("com.tencent.mm", 64);
                if (packageInfo == null) {
                    return false;
                }
                return WXApiImplComm.validateAppSignature(this.context, packageInfo.signatures, this.checkSignature);
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        } else {
            throw new IllegalStateException("isWXAppInstalled fail, WXMsgImpl has been detached");
        }
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean openWXApp() {
        String str;
        if (!this.detached) {
            if (!isWXAppInstalled()) {
                str = "open wx app failed, not installed or signature check failed";
            } else {
                try {
                    Context context = this.context;
                    context.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm"));
                    return true;
                } catch (Exception e10) {
                    str = "startActivity fail, exception = " + e10.getMessage();
                }
            }
            Log.e(TAG, str);
            return false;
        }
        throw new IllegalStateException("openWXApp fail, WXMsgImpl has been detached");
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean registerApp(String str) {
        return registerApp(str, 0L);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean registerApp(String str, long j10) {
        if (this.detached) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "register app failed for wechat app signature check failed");
            return false;
        } else {
            Log.d(TAG, "registerApp, appId = " + str);
            if (str != null) {
                this.appId = str;
            }
            Log.d(TAG, "registerApp, appId = " + str);
            if (str != null) {
                this.appId = str;
            }
            Log.d(TAG, "register app " + this.context.getPackageName());
            a.C0252a aVar = new a.C0252a();
            aVar.f22454a = "com.tencent.mm";
            aVar.action = ConstantsAPI.ACTION_HANDLE_APP_REGISTER;
            aVar.content = "weixin://registerapp?appid=" + this.appId;
            aVar.f22455b = j10;
            return a.a(this.context, aVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x020a  */
    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sendReq(BaseReq baseReq) {
        StringBuilder sb2;
        String str;
        WXWebpageObject wXWebpageObject;
        String str2;
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                str2 = "sendReq failed for wechat app signature check failed";
            } else if (!baseReq.checkArgs()) {
                str2 = "sendReq checkArgs fail";
            } else {
                Log.i(TAG, "sendReq, req type = " + baseReq.getType());
                Bundle bundle = new Bundle();
                baseReq.toBundle(bundle);
                if (baseReq.getType() == 5 || baseReq.getType() == 27) {
                    return sendPayReq(this.context, bundle);
                }
                if (baseReq.getType() == 9) {
                    return sendAddCardToWX(this.context, bundle);
                }
                if (baseReq.getType() == 16) {
                    return sendChooseCardFromWX(this.context, bundle);
                }
                if (baseReq.getType() == 11) {
                    return sendOpenRankListReq(this.context, bundle);
                }
                if (baseReq.getType() == 12) {
                    return sendOpenWebview(this.context, bundle);
                }
                if (baseReq.getType() == 25) {
                    return sendOpenBusinessWebview(this.context, baseReq);
                }
                if (baseReq.getType() == 13) {
                    return sendOpenBusiLuckyMoney(this.context, bundle);
                }
                if (baseReq.getType() == 14) {
                    return createChatroom(this.context, bundle);
                }
                if (baseReq.getType() == 15) {
                    return joinChatroom(this.context, bundle);
                }
                if (baseReq.getType() == 17) {
                    return sendHandleScanResult(this.context, bundle);
                }
                if (baseReq.getType() == 18) {
                    return sendSubscribeMessage(this.context, baseReq);
                }
                if (baseReq.getType() == 28) {
                    return sendPreloadWXMiniprogram(this.context, baseReq);
                }
                if (baseReq.getType() == 29) {
                    return sendLaunchWXMiniprogramWithToken(this.context, baseReq);
                }
                if (baseReq.getType() == 23) {
                    return sendSubscribeMiniProgramMsg(this.context, baseReq);
                }
                if (baseReq.getType() == 19) {
                    return sendLaunchWXMiniprogram(this.context, baseReq);
                }
                if (baseReq.getType() == 26) {
                    return sendOpenBusinessView(this.context, baseReq);
                }
                if (baseReq.getType() == 20) {
                    return sendInvoiceAuthInsert(this.context, baseReq);
                }
                if (baseReq.getType() == 21) {
                    return sendNonTaxPay(this.context, baseReq);
                }
                if (baseReq.getType() == 22) {
                    return sendPayInSurance(this.context, baseReq);
                }
                if (baseReq.getType() == 24) {
                    return sendJumpToOfflinePayReq(this.context, bundle);
                }
                if (baseReq.getType() == 2) {
                    SendMessageToWX.Req req = (SendMessageToWX.Req) baseReq;
                    int type = req.message.getType();
                    if (d.a(type)) {
                        if (getWXAppSupportAPI() < 620756993) {
                            wXWebpageObject = new WXWebpageObject();
                        } else if (type != 46 || getWXAppSupportAPI() >= 620953856) {
                            WXMiniProgramObject wXMiniProgramObject = (WXMiniProgramObject) req.message.mediaObject;
                            wXMiniProgramObject.userName += "@app";
                            String str3 = wXMiniProgramObject.path;
                            if (!d.b(str3)) {
                                String[] split = str3.split("\\?");
                                if (split.length > 1) {
                                    sb2 = new StringBuilder();
                                    sb2.append(split[0]);
                                    sb2.append(".html?");
                                    str = split[1];
                                } else {
                                    sb2 = new StringBuilder();
                                    sb2.append(split[0]);
                                    str = ".html";
                                }
                                sb2.append(str);
                                wXMiniProgramObject.path = sb2.toString();
                            }
                            if (req.scene != 3) {
                                req.scene = 0;
                            }
                            baseReq.toBundle(bundle);
                        } else {
                            wXWebpageObject = new WXWebpageObject();
                        }
                        wXWebpageObject.webpageUrl = bundle.getString("_wxminiprogram_webpageurl");
                        req.message.mediaObject = wXWebpageObject;
                        if (req.scene != 3) {
                        }
                        baseReq.toBundle(bundle);
                    }
                }
                MMessageActV2.Args args = new MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendreq?appid=" + this.appId;
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                if (baseReq.getType() == 2) {
                    try {
                        args.token = getTokenFromWX(this.context);
                    } catch (Exception e10) {
                        Log.e(TAG, "getTokenFromWX fail, exception = " + e10.getMessage());
                    }
                }
                return MMessageActV2.send(this.context, args);
            }
            Log.e(TAG, str2);
            return false;
        }
        throw new IllegalStateException("sendReq fail, WXMsgImpl has been detached");
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public boolean sendResp(BaseResp baseResp) {
        String str;
        if (!this.detached) {
            if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
                str = "sendResp failed for wechat app signature check failed";
            } else if (!baseResp.checkArgs()) {
                str = "sendResp checkArgs fail";
            } else {
                Bundle bundle = new Bundle();
                baseResp.toBundle(bundle);
                MMessageActV2.Args args = new MMessageActV2.Args();
                args.bundle = bundle;
                args.content = "weixin://sendresp?appid=" + this.appId;
                args.targetPkgName = "com.tencent.mm";
                args.targetClassName = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
                return MMessageActV2.send(this.context, args);
            }
            Log.e(TAG, str);
            return false;
        }
        throw new IllegalStateException("sendResp fail, WXMsgImpl has been detached");
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void setLogImpl(ILog iLog) {
        Log.setLogImpl(iLog);
    }

    @Override // com.tencent.mm.opensdk.openapi.IWXAPI
    public void unregisterApp() {
        if (this.detached) {
            throw new IllegalStateException("unregisterApp fail, WXMsgImpl has been detached");
        } else if (!WXApiImplComm.validateAppSignatureForPackage(this.context, "com.tencent.mm", this.checkSignature)) {
            Log.e(TAG, "unregister app failed for wechat app signature check failed");
        } else {
            Log.d(TAG, "unregisterApp, appId = " + this.appId);
            String str = this.appId;
            if (str == null || str.length() == 0) {
                Log.e(TAG, "unregisterApp fail, appId is empty");
                return;
            }
            Log.d(TAG, "unregister app " + this.context.getPackageName());
            a.C0252a aVar = new a.C0252a();
            aVar.f22454a = "com.tencent.mm";
            aVar.action = ConstantsAPI.ACTION_HANDLE_APP_UNREGISTER;
            aVar.content = "weixin://unregisterapp?appid=" + this.appId;
            a.a(this.context, aVar);
        }
    }
}
