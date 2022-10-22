package com.unionpay.tsmservice.mi;

import android.content.Context;
import com.unionpay.tsmservice.mi.request.AcquireSEAppListRequestParams;
import com.unionpay.tsmservice.mi.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.mi.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.mi.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.GetMessageDetailsRequestParams;
import com.unionpay.tsmservice.mi.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.mi.request.GetTransactionDetailsRequestParams;
import com.unionpay.tsmservice.mi.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.mi.request.InitRequestParams;
import com.unionpay.tsmservice.mi.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.mi.request.PayResultNotifyRequestParams;
import com.unionpay.tsmservice.mi.request.PinRequestRequestParams;
import com.unionpay.tsmservice.mi.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.mi.request.RequestParams;
import com.unionpay.tsmservice.mi.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.mi.utils.IUPJniInterface;
/* loaded from: classes2.dex */
public class SessionKeyReExchange {

    /* renamed from: a  reason: collision with root package name */
    private UPTsmAddon f24533a;

    /* renamed from: b  reason: collision with root package name */
    private int f24534b;

    /* renamed from: c  reason: collision with root package name */
    private RequestParams f24535c;

    /* renamed from: d  reason: collision with root package name */
    private ITsmCallback f24536d;

    /* renamed from: e  reason: collision with root package name */
    private ITsmProgressCallback f24537e;

    /* renamed from: f  reason: collision with root package name */
    private int f24538f;

    /* renamed from: g  reason: collision with root package name */
    private OnSafetyKeyboardCallback f24539g;

    /* renamed from: h  reason: collision with root package name */
    private Context f24540h;

    /* renamed from: i  reason: collision with root package name */
    private int f24541i;

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i10, null, iTsmCallback);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, RequestParams requestParams, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i10, requestParams, iTsmCallback, 1000);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, RequestParams requestParams, ITsmCallback iTsmCallback, int i11) {
        this.f24534b = -1;
        this.f24538f = 1000;
        this.f24533a = uPTsmAddon;
        this.f24534b = i10;
        this.f24535c = requestParams;
        this.f24536d = iTsmCallback;
        this.f24538f = i11;
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        this(uPTsmAddon, i10, requestParams, iTsmCallback, iTsmProgressCallback, 1000);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback, int i11) {
        this.f24534b = -1;
        this.f24538f = 1000;
        this.f24533a = uPTsmAddon;
        this.f24534b = i10;
        this.f24535c = requestParams;
        this.f24536d = iTsmCallback;
        this.f24537e = iTsmProgressCallback;
        this.f24538f = i11;
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i11, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        this.f24534b = -1;
        this.f24538f = 1000;
        this.f24533a = uPTsmAddon;
        this.f24534b = i10;
        this.f24541i = i11;
        this.f24535c = safetyKeyboardRequestParams;
        this.f24539g = onSafetyKeyboardCallback;
        this.f24540h = context;
    }

    public int reExchangeKey() {
        String[] strArr = new String[1];
        int pubKey = this.f24533a.getPubKey(1000, strArr);
        if (pubKey != 0) {
            return pubKey;
        }
        int exchangeKey = this.f24533a.exchangeKey(IUPJniInterface.rER(strArr[0], IUPJniInterface.mSK()), strArr);
        if (exchangeKey != 0) {
            return exchangeKey;
        }
        String dMG = IUPJniInterface.dMG(strArr[0]);
        IUPJniInterface.sSK(dMG);
        Context context = this.f24533a.getContext();
        if (context != null) {
            IUPJniInterface.uSKT(context.getPackageName(), dMG);
        }
        int i10 = this.f24534b;
        if (i10 != 1000) {
            switch (i10) {
                case 0:
                    return this.f24533a.init((InitRequestParams) this.f24535c, this.f24536d);
                case 1:
                    return this.f24533a.encryptData((EncryptDataRequestParams) this.f24535c, this.f24536d);
                case 2:
                    return this.f24533a.getEncryptData((GetEncryptDataRequestParams) this.f24535c, this.f24536d);
                case 3:
                    return this.f24533a.setSafetyKeyboardBitmap((SafetyKeyboardRequestParams) this.f24535c);
                case 4:
                    return this.f24533a.clearEncryptData(this.f24541i);
                case 5:
                    return this.f24533a.hideKeyboard();
                case 6:
                    return this.f24533a.acquireSEAppList((AcquireSEAppListRequestParams) this.f24535c, this.f24536d);
                case 7:
                    return this.f24533a.cardListStatusChanged((CardListStatusChangedRequestParams) this.f24535c, this.f24536d);
                case 8:
                    return this.f24533a.queryVendorPayStatus((QueryVendorPayStatusRequestParams) this.f24535c, this.f24536d);
                case 9:
                    return this.f24533a.getVendorPayStatus((GetVendorPayStatusRequestParams) this.f24535c, this.f24536d);
                case 10:
                    return this.f24533a.onlinePaymentVerify((OnlinePaymentVerifyRequestParams) this.f24535c, this.f24536d);
                case 11:
                    return this.f24533a.pinRequest((PinRequestRequestParams) this.f24535c, this.f24536d);
                case 12:
                    return this.f24533a.payResultNotify((PayResultNotifyRequestParams) this.f24535c, this.f24536d);
                case 13:
                    return this.f24533a.cancelPay();
                case 14:
                    return this.f24533a.getVendorPayStatusForBankApp((GetVendorPayStatusRequestParams) this.f24535c, this.f24536d);
                case 15:
                    return this.f24533a.getSeId((GetSeIdRequestParams) this.f24535c, this.f24536d);
                case 16:
                    return this.f24533a.addCardToVendorPay((AddCardToVendorPayRequestParams) this.f24535c, this.f24536d, this.f24537e);
                case 17:
                    return this.f24533a.getTransactionDetails((GetTransactionDetailsRequestParams) this.f24535c, this.f24536d);
                case 18:
                    return this.f24533a.getMessageDetails((GetMessageDetailsRequestParams) this.f24535c, this.f24536d);
                default:
                    return 0;
            }
        } else {
            return this.f24533a.showSafetyKeyboard((SafetyKeyboardRequestParams) this.f24535c, this.f24541i, this.f24539g, this.f24540h);
        }
    }
}
