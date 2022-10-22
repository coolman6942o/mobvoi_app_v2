package com.unionpay.tsmservice;

import android.content.Context;
import android.os.RemoteException;
import com.unionpay.tsmservice.request.AcquireSEAppListRequestParams;
import com.unionpay.tsmservice.request.ActivateVendorPayRequestParams;
import com.unionpay.tsmservice.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.request.AppDataUpdateRequestParams;
import com.unionpay.tsmservice.request.AppDeleteRequestParams;
import com.unionpay.tsmservice.request.AppDownloadApplyRequestParams;
import com.unionpay.tsmservice.request.AppDownloadRequestParams;
import com.unionpay.tsmservice.request.AppLockRequestParams;
import com.unionpay.tsmservice.request.AppUnlockRequestParams;
import com.unionpay.tsmservice.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.request.CheckSSamsungPayRequestParams;
import com.unionpay.tsmservice.request.CloseChannelRequestParams;
import com.unionpay.tsmservice.request.ECashTopUpRequestParams;
import com.unionpay.tsmservice.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.request.ExecuteCmdRequestParams;
import com.unionpay.tsmservice.request.GetAccountBalanceRequestParams;
import com.unionpay.tsmservice.request.GetAccountInfoRequestParams;
import com.unionpay.tsmservice.request.GetAppDetailRequestParams;
import com.unionpay.tsmservice.request.GetAppListRequestParams;
import com.unionpay.tsmservice.request.GetAppStatusRequestParams;
import com.unionpay.tsmservice.request.GetAssociatedAppRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoBySpayRequestParams;
import com.unionpay.tsmservice.request.GetCardInfoRequestParams;
import com.unionpay.tsmservice.request.GetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.request.GetMessageDetailsRequestParams;
import com.unionpay.tsmservice.request.GetSMSAuthCodeRequestParams;
import com.unionpay.tsmservice.request.GetSeAppListRequestParams;
import com.unionpay.tsmservice.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.request.GetTransElementsRequestParams;
import com.unionpay.tsmservice.request.GetTransRecordRequestParams;
import com.unionpay.tsmservice.request.GetTransactionDetailsRequestParams;
import com.unionpay.tsmservice.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.HideAppApplyRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.PreDownloadRequestParams;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.RequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.SendCustomDataRequestParams;
import com.unionpay.tsmservice.request.SetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.SetSamsungDefWalletRequestParams;
import com.unionpay.tsmservice.request.UniteRequestParams;
import com.unionpay.tsmservice.utils.IUPJniInterface;
/* loaded from: classes2.dex */
public class SessionKeyReExchange {

    /* renamed from: a  reason: collision with root package name */
    private UPTsmAddon f24481a;

    /* renamed from: b  reason: collision with root package name */
    private int f24482b;

    /* renamed from: c  reason: collision with root package name */
    private RequestParams f24483c;

    /* renamed from: d  reason: collision with root package name */
    private ITsmCallback f24484d;

    /* renamed from: e  reason: collision with root package name */
    private ITsmProgressCallback f24485e;

    /* renamed from: f  reason: collision with root package name */
    private int f24486f;

    /* renamed from: g  reason: collision with root package name */
    private OnSafetyKeyboardCallback f24487g;

    /* renamed from: h  reason: collision with root package name */
    private Context f24488h;

    /* renamed from: i  reason: collision with root package name */
    private int f24489i;

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i10, null, iTsmCallback);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, RequestParams requestParams, ITsmCallback iTsmCallback) {
        this(uPTsmAddon, i10, requestParams, iTsmCallback, null);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
        this(uPTsmAddon, i10, requestParams, iTsmCallback, iTsmProgressCallback, 1000);
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, RequestParams requestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback, int i11) {
        this.f24482b = -1;
        this.f24486f = 1000;
        this.f24481a = uPTsmAddon;
        this.f24482b = i10;
        this.f24483c = requestParams;
        this.f24484d = iTsmCallback;
        this.f24485e = iTsmProgressCallback;
        this.f24486f = i11;
    }

    public SessionKeyReExchange(UPTsmAddon uPTsmAddon, int i10, SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i11, OnSafetyKeyboardCallback onSafetyKeyboardCallback, Context context) {
        this.f24482b = -1;
        this.f24486f = 1000;
        this.f24481a = uPTsmAddon;
        this.f24482b = i10;
        this.f24489i = i11;
        this.f24483c = safetyKeyboardRequestParams;
        this.f24487g = onSafetyKeyboardCallback;
        this.f24488h = context;
    }

    public int reExchangeKey() throws RemoteException {
        String[] strArr = new String[1];
        int pubKey = this.f24481a.getPubKey(1000, strArr);
        if (pubKey != 0) {
            return pubKey;
        }
        int exchangeKey = this.f24481a.exchangeKey(IUPJniInterface.rER(strArr[0], IUPJniInterface.mSK()), strArr);
        if (exchangeKey != 0) {
            return exchangeKey;
        }
        String dMG = IUPJniInterface.dMG(strArr[0], this.f24481a.getCryptType());
        IUPJniInterface.sSK(dMG);
        Context context = this.f24481a.getContext();
        if (context != null) {
            IUPJniInterface.uSKT(context.getPackageName(), dMG);
        }
        int i10 = this.f24482b;
        if (i10 != 1000) {
            switch (i10) {
                case 0:
                    return this.f24481a.init((InitRequestParams) this.f24483c, this.f24484d);
                case 1:
                    return this.f24481a.getAssociatedApp((GetAssociatedAppRequestParams) this.f24483c, this.f24484d);
                case 2:
                    return this.f24481a.getAppList((GetAppListRequestParams) this.f24483c, this.f24484d);
                case 3:
                    return this.f24481a.getSEAppList((GetSeAppListRequestParams) this.f24483c, this.f24484d);
                case 4:
                    return this.f24481a.getAppDetail((GetAppDetailRequestParams) this.f24483c, this.f24484d);
                case 5:
                    return this.f24481a.getAppStatus((GetAppStatusRequestParams) this.f24483c, this.f24484d);
                case 6:
                    return this.f24481a.getCardInfo((GetCardInfoRequestParams) this.f24483c, this.f24484d);
                case 7:
                    return this.f24481a.getAccountInfo((GetAccountInfoRequestParams) this.f24483c, this.f24484d);
                case 8:
                    return this.f24481a.getAccountBalance((GetAccountBalanceRequestParams) this.f24483c, this.f24484d);
                case 9:
                    return this.f24481a.getTransElements((GetTransElementsRequestParams) this.f24483c, this.f24484d);
                case 10:
                    return this.f24481a.getTransRecord((GetTransRecordRequestParams) this.f24483c, this.f24484d);
                case 11:
                    return this.f24481a.getSMSAuthCode((GetSMSAuthCodeRequestParams) this.f24483c, this.f24484d);
                case 12:
                    return this.f24481a.getSeId((GetSeIdRequestParams) this.f24483c, this.f24484d);
                case 13:
                    return this.f24481a.getDefaultCard((GetDefaultCardRequestParams) this.f24483c, this.f24484d);
                case 14:
                    return this.f24481a.setDefaultCard((SetDefaultCardRequestParams) this.f24483c, this.f24484d);
                case 15:
                    return this.f24481a.appDownloadApply((AppDownloadApplyRequestParams) this.f24483c, this.f24484d);
                case 16:
                    return this.f24481a.appDownload((AppDownloadRequestParams) this.f24483c, this.f24484d, this.f24485e);
                case 17:
                    return this.f24481a.appDelete((AppDeleteRequestParams) this.f24483c, this.f24484d, this.f24485e);
                case 18:
                    return this.f24481a.appDataUpdate((AppDataUpdateRequestParams) this.f24483c, this.f24484d, this.f24485e);
                case 19:
                    return this.f24481a.eCashTopUp((ECashTopUpRequestParams) this.f24483c, this.f24484d);
                case 20:
                    return this.f24481a.openChannel((OpenChannelRequestParams) this.f24483c, this.f24484d);
                case 21:
                    return this.f24481a.closeChannel((CloseChannelRequestParams) this.f24483c, this.f24484d);
                case 22:
                    return this.f24481a.sendApdu((SendApduRequestParams) this.f24483c, this.f24484d);
                case 23:
                    return this.f24481a.encryptData((EncryptDataRequestParams) this.f24483c, this.f24484d);
                case 24:
                    return this.f24481a.hideAppApply((HideAppApplyRequestParams) this.f24483c, this.f24484d);
                case 25:
                    return this.f24481a.executeCmd((ExecuteCmdRequestParams) this.f24483c, this.f24484d, this.f24485e);
                case 26:
                    return this.f24481a.appLock((AppLockRequestParams) this.f24483c, this.f24484d);
                case 27:
                    return this.f24481a.appUnlock((AppUnlockRequestParams) this.f24483c, this.f24484d);
                case 28:
                    return this.f24481a.getCardInfoBySamsungPay((GetCardInfoBySpayRequestParams) this.f24483c, this.f24484d);
                case 29:
                    return this.f24481a.checkSSamsungPay((CheckSSamsungPayRequestParams) this.f24483c, this.f24484d);
                case 30:
                    return this.f24481a.setSamsungDefaultWallet((SetSamsungDefWalletRequestParams) this.f24483c, this.f24484d);
                case 31:
                    return this.f24481a.getEncryptData((GetEncryptDataRequestParams) this.f24483c, this.f24484d);
                case 32:
                    return this.f24481a.setSafetyKeyboardBitmap((SafetyKeyboardRequestParams) this.f24483c);
                case 33:
                    return this.f24481a.clearEncryptData(this.f24489i);
                case 34:
                    return this.f24481a.hideKeyboard();
                case 35:
                    return this.f24481a.cardListStatusChanged((CardListStatusChangedRequestParams) this.f24483c, this.f24484d);
                case 36:
                    return this.f24481a.getVendorPayStatus((GetVendorPayStatusRequestParams) this.f24483c, this.f24484d);
                case 37:
                    return this.f24481a.activateVendorPay((ActivateVendorPayRequestParams) this.f24483c, this.f24484d);
                case 38:
                    return this.f24481a.addCardToVendorPay((AddCardToVendorPayRequestParams) this.f24483c, this.f24484d, this.f24485e);
                case 39:
                    return this.f24481a.onlinePaymentVerify((OnlinePaymentVerifyRequestParams) this.f24483c, this.f24484d);
                case 40:
                    return this.f24481a.preDownload((PreDownloadRequestParams) this.f24483c, this.f24484d, this.f24485e);
                case 41:
                    return this.f24481a.queryVendorPayStatus((QueryVendorPayStatusRequestParams) this.f24483c, this.f24484d);
                case 42:
                    return this.f24481a.acquireSEAppList((AcquireSEAppListRequestParams) this.f24483c, this.f24484d);
                case 43:
                    return this.f24481a.getTransactionDetails((GetTransactionDetailsRequestParams) this.f24483c, this.f24484d);
                case 44:
                    return this.f24481a.getMessageDetails((GetMessageDetailsRequestParams) this.f24483c, this.f24484d);
                case 45:
                    return this.f24481a.sendCustomData((SendCustomDataRequestParams) this.f24483c, this.f24484d);
                case 46:
                    return this.f24481a.createSSD((UniteRequestParams) this.f24483c, this.f24484d);
                default:
                    return 0;
            }
        } else {
            return this.f24481a.showSafetyKeyboard((SafetyKeyboardRequestParams) this.f24483c, this.f24489i, this.f24487g, this.f24488h);
        }
    }
}
