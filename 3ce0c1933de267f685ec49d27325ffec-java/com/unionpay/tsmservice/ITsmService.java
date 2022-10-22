package com.unionpay.tsmservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.unionpay.tsmservice.ITsmActivityCallback;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.ITsmProgressCallback;
import com.unionpay.tsmservice.OnSafetyKeyboardCallback;
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
import com.unionpay.tsmservice.request.CheckSupportCardApplyRequestParams;
import com.unionpay.tsmservice.request.ClearEncryptDataRequestParams;
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
import com.unionpay.tsmservice.request.GetCurrentWalletClientRequestParams;
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
import com.unionpay.tsmservice.request.HideSafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.InitRequestParams;
import com.unionpay.tsmservice.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.request.OpenChannelRequestParams;
import com.unionpay.tsmservice.request.PreDownloadRequestParams;
import com.unionpay.tsmservice.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.request.SafetyKeyboardRequestParams;
import com.unionpay.tsmservice.request.SendApduRequestParams;
import com.unionpay.tsmservice.request.SendCustomDataRequestParams;
import com.unionpay.tsmservice.request.SetDefaultCardRequestParams;
import com.unionpay.tsmservice.request.SetSamsungDefWalletRequestParams;
import com.unionpay.tsmservice.request.StartCardApplyRequestParams;
import com.unionpay.tsmservice.request.UniteRequestParams;
/* loaded from: classes2.dex */
public interface ITsmService extends IInterface {

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements ITsmService {

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class a implements ITsmService {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f24479a;

            a(IBinder iBinder) {
                this.f24479a = iBinder;
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int acquireSEAppList(AcquireSEAppListRequestParams acquireSEAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (acquireSEAppListRequestParams != null) {
                        obtain.writeInt(1);
                        acquireSEAppListRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int activateVendorPay(ActivateVendorPayRequestParams activateVendorPayRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (activateVendorPayRequestParams != null) {
                        obtain.writeInt(1);
                        activateVendorPayRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int addCardToVendorPay(AddCardToVendorPayRequestParams addCardToVendorPayRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (addCardToVendorPayRequestParams != null) {
                        obtain.writeInt(1);
                        addCardToVendorPayRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f24479a.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int appDataUpdate(AppDataUpdateRequestParams appDataUpdateRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (appDataUpdateRequestParams != null) {
                        obtain.writeInt(1);
                        appDataUpdateRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f24479a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int appDelete(AppDeleteRequestParams appDeleteRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (appDeleteRequestParams != null) {
                        obtain.writeInt(1);
                        appDeleteRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f24479a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int appDownload(AppDownloadRequestParams appDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (appDownloadRequestParams != null) {
                        obtain.writeInt(1);
                        appDownloadRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f24479a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int appDownloadApply(AppDownloadApplyRequestParams appDownloadApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (appDownloadApplyRequestParams != null) {
                        obtain.writeInt(1);
                        appDownloadApplyRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int appLock(AppLockRequestParams appLockRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (appLockRequestParams != null) {
                        obtain.writeInt(1);
                        appLockRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int appUnlock(AppUnlockRequestParams appUnlockRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (appUnlockRequestParams != null) {
                        obtain.writeInt(1);
                        appUnlockRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f24479a;
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int cardListStatusChanged(CardListStatusChangedRequestParams cardListStatusChangedRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (cardListStatusChangedRequestParams != null) {
                        obtain.writeInt(1);
                        cardListStatusChangedRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int checkSSamsungPay(CheckSSamsungPayRequestParams checkSSamsungPayRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (checkSSamsungPayRequestParams != null) {
                        obtain.writeInt(1);
                        checkSSamsungPayRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int checkSupportCardApply(CheckSupportCardApplyRequestParams checkSupportCardApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (checkSupportCardApplyRequestParams != null) {
                        obtain.writeInt(1);
                        checkSupportCardApplyRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int clearEncryptData(int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    obtain.writeInt(i10);
                    this.f24479a.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int clearKeyboardEncryptData(ClearEncryptDataRequestParams clearEncryptDataRequestParams, int i10) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (clearEncryptDataRequestParams != null) {
                        obtain.writeInt(1);
                        clearEncryptDataRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i10);
                    this.f24479a.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int closeChannel(CloseChannelRequestParams closeChannelRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (closeChannelRequestParams != null) {
                        obtain.writeInt(1);
                        closeChannelRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int createSSD(UniteRequestParams uniteRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (uniteRequestParams != null) {
                        obtain.writeInt(1);
                        uniteRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int eCashTopUp(ECashTopUpRequestParams eCashTopUpRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (eCashTopUpRequestParams != null) {
                        obtain.writeInt(1);
                        eCashTopUpRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (encryptDataRequestParams != null) {
                        obtain.writeInt(1);
                        encryptDataRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int exchangeKey(String str, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    obtain.writeString(str);
                    if (strArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(strArr.length);
                    }
                    this.f24479a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readStringArray(strArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int executeCmd(ExecuteCmdRequestParams executeCmdRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (executeCmdRequestParams != null) {
                        obtain.writeInt(1);
                        executeCmdRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f24479a.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getAccountBalance(GetAccountBalanceRequestParams getAccountBalanceRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getAccountBalanceRequestParams != null) {
                        obtain.writeInt(1);
                        getAccountBalanceRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getAccountInfo(GetAccountInfoRequestParams getAccountInfoRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getAccountInfoRequestParams != null) {
                        obtain.writeInt(1);
                        getAccountInfoRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getAppDetail(GetAppDetailRequestParams getAppDetailRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getAppDetailRequestParams != null) {
                        obtain.writeInt(1);
                        getAppDetailRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getAppList(GetAppListRequestParams getAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getAppListRequestParams != null) {
                        obtain.writeInt(1);
                        getAppListRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getAppStatus(GetAppStatusRequestParams getAppStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getAppStatusRequestParams != null) {
                        obtain.writeInt(1);
                        getAppStatusRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getAssociatedApp(GetAssociatedAppRequestParams getAssociatedAppRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getAssociatedAppRequestParams != null) {
                        obtain.writeInt(1);
                        getAssociatedAppRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getCardInfo(GetCardInfoRequestParams getCardInfoRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getCardInfoRequestParams != null) {
                        obtain.writeInt(1);
                        getCardInfoRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getCardInfoBySpayRequestParams != null) {
                        obtain.writeInt(1);
                        getCardInfoBySpayRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getCurrentWalletClient(GetCurrentWalletClientRequestParams getCurrentWalletClientRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getCurrentWalletClientRequestParams != null) {
                        obtain.writeInt(1);
                        getCurrentWalletClientRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getDefaultCard(GetDefaultCardRequestParams getDefaultCardRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getDefaultCardRequestParams != null) {
                        obtain.writeInt(1);
                        getDefaultCardRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getEncryptDataRequestParams != null) {
                        obtain.writeInt(1);
                        getEncryptDataRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getMessageDetails(GetMessageDetailsRequestParams getMessageDetailsRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getMessageDetailsRequestParams != null) {
                        obtain.writeInt(1);
                        getMessageDetailsRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getPubKey(int i10, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    obtain.writeInt(i10);
                    if (strArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(strArr.length);
                    }
                    this.f24479a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readStringArray(strArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getSEAppList(GetSeAppListRequestParams getSeAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getSeAppListRequestParams != null) {
                        obtain.writeInt(1);
                        getSeAppListRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getSEId(GetSeIdRequestParams getSeIdRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getSeIdRequestParams != null) {
                        obtain.writeInt(1);
                        getSeIdRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getSMSAuthCode(GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getSMSAuthCodeRequestParams != null) {
                        obtain.writeInt(1);
                        getSMSAuthCodeRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getTransElements(GetTransElementsRequestParams getTransElementsRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getTransElementsRequestParams != null) {
                        obtain.writeInt(1);
                        getTransElementsRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getTransRecord(GetTransRecordRequestParams getTransRecordRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getTransRecordRequestParams != null) {
                        obtain.writeInt(1);
                        getTransRecordRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getTransactionDetails(GetTransactionDetailsRequestParams getTransactionDetailsRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getTransactionDetailsRequestParams != null) {
                        obtain.writeInt(1);
                        getTransactionDetailsRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int getVendorPayStatus(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (getVendorPayStatusRequestParams != null) {
                        obtain.writeInt(1);
                        getVendorPayStatusRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int hideAppApply(HideAppApplyRequestParams hideAppApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (hideAppApplyRequestParams != null) {
                        obtain.writeInt(1);
                        hideAppApplyRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int hideKeyboard() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    this.f24479a.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int hideSafetyKeyboard(HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (hideSafetyKeyboardRequestParams != null) {
                        obtain.writeInt(1);
                        hideSafetyKeyboardRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24479a.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (initRequestParams != null) {
                        obtain.writeInt(1);
                        initRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int onlinePaymentVerify(OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (onlinePaymentVerifyRequestParams != null) {
                        obtain.writeInt(1);
                        onlinePaymentVerifyRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int openChannel(OpenChannelRequestParams openChannelRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (openChannelRequestParams != null) {
                        obtain.writeInt(1);
                        openChannelRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int preDownload(PreDownloadRequestParams preDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (preDownloadRequestParams != null) {
                        obtain.writeInt(1);
                        preDownloadRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    if (iTsmProgressCallback != null) {
                        iBinder = iTsmProgressCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f24479a.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int queryVendorPayStatus(QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (queryVendorPayStatusRequestParams != null) {
                        obtain.writeInt(1);
                        queryVendorPayStatusRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int sendApdu(SendApduRequestParams sendApduRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (sendApduRequestParams != null) {
                        obtain.writeInt(1);
                        sendApduRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int sendCustomData(SendCustomDataRequestParams sendCustomDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (sendCustomDataRequestParams != null) {
                        obtain.writeInt(1);
                        sendCustomDataRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int setDefaultCard(SetDefaultCardRequestParams setDefaultCardRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (setDefaultCardRequestParams != null) {
                        obtain.writeInt(1);
                        setDefaultCardRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (safetyKeyboardRequestParams != null) {
                        obtain.writeInt(1);
                        safetyKeyboardRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24479a.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams setSamsungDefWalletRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (setSamsungDefWalletRequestParams != null) {
                        obtain.writeInt(1);
                        setSamsungDefWalletRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i10, OnSafetyKeyboardCallback onSafetyKeyboardCallback, ITsmActivityCallback iTsmActivityCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (safetyKeyboardRequestParams != null) {
                        obtain.writeInt(1);
                        safetyKeyboardRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i10);
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(onSafetyKeyboardCallback != null ? onSafetyKeyboardCallback.asBinder() : null);
                    if (iTsmActivityCallback != null) {
                        iBinder = iTsmActivityCallback.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f24479a.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.ITsmService
            public final int startCardApply(StartCardApplyRequestParams startCardApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.ITsmService");
                    if (startCardApplyRequestParams != null) {
                        obtain.writeInt(1);
                        startCardApplyRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24479a.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.ITsmService");
        }

        public static ITsmService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.ITsmService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmService)) ? new a(iBinder) : (ITsmService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1598968902) {
                InitRequestParams initRequestParams = null;
                UniteRequestParams uniteRequestParams = null;
                SendCustomDataRequestParams sendCustomDataRequestParams = null;
                GetMessageDetailsRequestParams getMessageDetailsRequestParams = null;
                GetTransactionDetailsRequestParams getTransactionDetailsRequestParams = null;
                AcquireSEAppListRequestParams acquireSEAppListRequestParams = null;
                QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams = null;
                PreDownloadRequestParams preDownloadRequestParams = null;
                HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams = null;
                ClearEncryptDataRequestParams clearEncryptDataRequestParams = null;
                OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams = null;
                AddCardToVendorPayRequestParams addCardToVendorPayRequestParams = null;
                ActivateVendorPayRequestParams activateVendorPayRequestParams = null;
                GetVendorPayStatusRequestParams getVendorPayStatusRequestParams = null;
                CardListStatusChangedRequestParams cardListStatusChangedRequestParams = null;
                GetCurrentWalletClientRequestParams getCurrentWalletClientRequestParams = null;
                StartCardApplyRequestParams startCardApplyRequestParams = null;
                CheckSupportCardApplyRequestParams checkSupportCardApplyRequestParams = null;
                GetEncryptDataRequestParams getEncryptDataRequestParams = null;
                SafetyKeyboardRequestParams safetyKeyboardRequestParams = null;
                SafetyKeyboardRequestParams safetyKeyboardRequestParams2 = null;
                SetSamsungDefWalletRequestParams setSamsungDefWalletRequestParams = null;
                CheckSSamsungPayRequestParams checkSSamsungPayRequestParams = null;
                GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams = null;
                ExecuteCmdRequestParams executeCmdRequestParams = null;
                HideAppApplyRequestParams hideAppApplyRequestParams = null;
                CloseChannelRequestParams closeChannelRequestParams = null;
                SendApduRequestParams sendApduRequestParams = null;
                OpenChannelRequestParams openChannelRequestParams = null;
                GetDefaultCardRequestParams getDefaultCardRequestParams = null;
                SetDefaultCardRequestParams setDefaultCardRequestParams = null;
                GetCardInfoRequestParams getCardInfoRequestParams = null;
                GetAccountBalanceRequestParams getAccountBalanceRequestParams = null;
                GetAccountInfoRequestParams getAccountInfoRequestParams = null;
                GetTransRecordRequestParams getTransRecordRequestParams = null;
                ECashTopUpRequestParams eCashTopUpRequestParams = null;
                GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams = null;
                AppUnlockRequestParams appUnlockRequestParams = null;
                AppLockRequestParams appLockRequestParams = null;
                AppDataUpdateRequestParams appDataUpdateRequestParams = null;
                AppDeleteRequestParams appDeleteRequestParams = null;
                AppDownloadRequestParams appDownloadRequestParams = null;
                AppDownloadApplyRequestParams appDownloadApplyRequestParams = null;
                GetTransElementsRequestParams getTransElementsRequestParams = null;
                GetAppDetailRequestParams getAppDetailRequestParams = null;
                GetAppStatusRequestParams getAppStatusRequestParams = null;
                GetAppListRequestParams getAppListRequestParams = null;
                GetSeAppListRequestParams getSeAppListRequestParams = null;
                GetAssociatedAppRequestParams getAssociatedAppRequestParams = null;
                GetSeIdRequestParams getSeIdRequestParams = null;
                EncryptDataRequestParams encryptDataRequestParams = null;
                String[] strArr = null;
                String[] strArr2 = null;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            initRequestParams = InitRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int init = init(initRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(init);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        int readInt = parcel.readInt();
                        int readInt2 = parcel.readInt();
                        if (readInt2 >= 0) {
                            strArr2 = new String[readInt2];
                        }
                        int pubKey = getPubKey(readInt, strArr2);
                        parcel2.writeNoException();
                        parcel2.writeInt(pubKey);
                        parcel2.writeStringArray(strArr2);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        String readString = parcel.readString();
                        int readInt3 = parcel.readInt();
                        if (readInt3 >= 0) {
                            strArr = new String[readInt3];
                        }
                        int exchangeKey = exchangeKey(readString, strArr);
                        parcel2.writeNoException();
                        parcel2.writeInt(exchangeKey);
                        parcel2.writeStringArray(strArr);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            encryptDataRequestParams = EncryptDataRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int encryptData = encryptData(encryptDataRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(encryptData);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getSeIdRequestParams = GetSeIdRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int sEId = getSEId(getSeIdRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(sEId);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getAssociatedAppRequestParams = GetAssociatedAppRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int associatedApp = getAssociatedApp(getAssociatedAppRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(associatedApp);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getSeAppListRequestParams = GetSeAppListRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int sEAppList = getSEAppList(getSeAppListRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(sEAppList);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getAppListRequestParams = GetAppListRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int appList = getAppList(getAppListRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(appList);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getAppStatusRequestParams = GetAppStatusRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int appStatus = getAppStatus(getAppStatusRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(appStatus);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getAppDetailRequestParams = GetAppDetailRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int appDetail = getAppDetail(getAppDetailRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(appDetail);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getTransElementsRequestParams = GetTransElementsRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int transElements = getTransElements(getTransElementsRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(transElements);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            appDownloadApplyRequestParams = AppDownloadApplyRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int appDownloadApply = appDownloadApply(appDownloadApplyRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(appDownloadApply);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            appDownloadRequestParams = AppDownloadRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int appDownload = appDownload(appDownloadRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(appDownload);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            appDeleteRequestParams = AppDeleteRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int appDelete = appDelete(appDeleteRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(appDelete);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            appDataUpdateRequestParams = AppDataUpdateRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int appDataUpdate = appDataUpdate(appDataUpdateRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(appDataUpdate);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            appLockRequestParams = AppLockRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int appLock = appLock(appLockRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(appLock);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            appUnlockRequestParams = AppUnlockRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int appUnlock = appUnlock(appUnlockRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(appUnlock);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getSMSAuthCodeRequestParams = GetSMSAuthCodeRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int sMSAuthCode = getSMSAuthCode(getSMSAuthCodeRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(sMSAuthCode);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            eCashTopUpRequestParams = ECashTopUpRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int eCashTopUp = eCashTopUp(eCashTopUpRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(eCashTopUp);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getTransRecordRequestParams = GetTransRecordRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int transRecord = getTransRecord(getTransRecordRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(transRecord);
                        return true;
                    case 21:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getAccountInfoRequestParams = GetAccountInfoRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int accountInfo = getAccountInfo(getAccountInfoRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(accountInfo);
                        return true;
                    case 22:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getAccountBalanceRequestParams = GetAccountBalanceRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int accountBalance = getAccountBalance(getAccountBalanceRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(accountBalance);
                        return true;
                    case 23:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getCardInfoRequestParams = GetCardInfoRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int cardInfo = getCardInfo(getCardInfoRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(cardInfo);
                        return true;
                    case 24:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            setDefaultCardRequestParams = SetDefaultCardRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int defaultCard = setDefaultCard(setDefaultCardRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(defaultCard);
                        return true;
                    case 25:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getDefaultCardRequestParams = GetDefaultCardRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int defaultCard2 = getDefaultCard(getDefaultCardRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(defaultCard2);
                        return true;
                    case 26:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            openChannelRequestParams = OpenChannelRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int openChannel = openChannel(openChannelRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(openChannel);
                        return true;
                    case 27:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            sendApduRequestParams = SendApduRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int sendApdu = sendApdu(sendApduRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(sendApdu);
                        return true;
                    case 28:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            closeChannelRequestParams = CloseChannelRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int closeChannel = closeChannel(closeChannelRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(closeChannel);
                        return true;
                    case 29:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            hideAppApplyRequestParams = HideAppApplyRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int hideAppApply = hideAppApply(hideAppApplyRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(hideAppApply);
                        return true;
                    case 30:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            executeCmdRequestParams = ExecuteCmdRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int executeCmd = executeCmd(executeCmdRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(executeCmd);
                        return true;
                    case 31:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getCardInfoBySpayRequestParams = GetCardInfoBySpayRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int cardInfoBySamsungPay = getCardInfoBySamsungPay(getCardInfoBySpayRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(cardInfoBySamsungPay);
                        return true;
                    case 32:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            checkSSamsungPayRequestParams = CheckSSamsungPayRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int checkSSamsungPay = checkSSamsungPay(checkSSamsungPayRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(checkSSamsungPay);
                        return true;
                    case 33:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            setSamsungDefWalletRequestParams = SetSamsungDefWalletRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int samsungDefaultWallet = setSamsungDefaultWallet(setSamsungDefWalletRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(samsungDefaultWallet);
                        return true;
                    case 34:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            safetyKeyboardRequestParams2 = SafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int showSafetyKeyboard = showSafetyKeyboard(safetyKeyboardRequestParams2, parcel.readInt(), OnSafetyKeyboardCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmActivityCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(showSafetyKeyboard);
                        return true;
                    case 35:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            safetyKeyboardRequestParams = SafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int safetyKeyboardBitmap = setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
                        parcel2.writeNoException();
                        parcel2.writeInt(safetyKeyboardBitmap);
                        return true;
                    case 36:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getEncryptDataRequestParams = GetEncryptDataRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int encryptData2 = getEncryptData(getEncryptDataRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(encryptData2);
                        return true;
                    case 37:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        int clearEncryptData = clearEncryptData(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(clearEncryptData);
                        return true;
                    case 38:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        int hideKeyboard = hideKeyboard();
                        parcel2.writeNoException();
                        parcel2.writeInt(hideKeyboard);
                        return true;
                    case 39:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            checkSupportCardApplyRequestParams = CheckSupportCardApplyRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int checkSupportCardApply = checkSupportCardApply(checkSupportCardApplyRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(checkSupportCardApply);
                        return true;
                    case 40:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            startCardApplyRequestParams = StartCardApplyRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int startCardApply = startCardApply(startCardApplyRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(startCardApply);
                        return true;
                    case 41:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getCurrentWalletClientRequestParams = GetCurrentWalletClientRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int currentWalletClient = getCurrentWalletClient(getCurrentWalletClientRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(currentWalletClient);
                        return true;
                    case 42:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            cardListStatusChangedRequestParams = CardListStatusChangedRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int cardListStatusChanged = cardListStatusChanged(cardListStatusChangedRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(cardListStatusChanged);
                        return true;
                    case 43:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getVendorPayStatusRequestParams = GetVendorPayStatusRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int vendorPayStatus = getVendorPayStatus(getVendorPayStatusRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(vendorPayStatus);
                        return true;
                    case 44:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            activateVendorPayRequestParams = ActivateVendorPayRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int activateVendorPay = activateVendorPay(activateVendorPayRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(activateVendorPay);
                        return true;
                    case 45:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            addCardToVendorPayRequestParams = AddCardToVendorPayRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int addCardToVendorPay = addCardToVendorPay(addCardToVendorPayRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(addCardToVendorPay);
                        return true;
                    case 46:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            onlinePaymentVerifyRequestParams = OnlinePaymentVerifyRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int onlinePaymentVerify = onlinePaymentVerify(onlinePaymentVerifyRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(onlinePaymentVerify);
                        return true;
                    case 47:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            clearEncryptDataRequestParams = ClearEncryptDataRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int clearKeyboardEncryptData = clearKeyboardEncryptData(clearEncryptDataRequestParams, parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(clearKeyboardEncryptData);
                        return true;
                    case 48:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            hideSafetyKeyboardRequestParams = HideSafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int hideSafetyKeyboard = hideSafetyKeyboard(hideSafetyKeyboardRequestParams);
                        parcel2.writeNoException();
                        parcel2.writeInt(hideSafetyKeyboard);
                        return true;
                    case 49:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            preDownloadRequestParams = PreDownloadRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int preDownload = preDownload(preDownloadRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(preDownload);
                        return true;
                    case 50:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            queryVendorPayStatusRequestParams = QueryVendorPayStatusRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int queryVendorPayStatus = queryVendorPayStatus(queryVendorPayStatusRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(queryVendorPayStatus);
                        return true;
                    case 51:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            acquireSEAppListRequestParams = AcquireSEAppListRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int acquireSEAppList = acquireSEAppList(acquireSEAppListRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(acquireSEAppList);
                        return true;
                    case 52:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getTransactionDetailsRequestParams = GetTransactionDetailsRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int transactionDetails = getTransactionDetails(getTransactionDetailsRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(transactionDetails);
                        return true;
                    case 53:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            getMessageDetailsRequestParams = GetMessageDetailsRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int messageDetails = getMessageDetails(getMessageDetailsRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(messageDetails);
                        return true;
                    case 54:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            sendCustomDataRequestParams = SendCustomDataRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int sendCustomData = sendCustomData(sendCustomDataRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(sendCustomData);
                        return true;
                    case 55:
                        parcel.enforceInterface("com.unionpay.tsmservice.ITsmService");
                        if (parcel.readInt() != 0) {
                            uniteRequestParams = UniteRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int createSSD = createSSD(uniteRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(createSSD);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            } else {
                parcel2.writeString("com.unionpay.tsmservice.ITsmService");
                return true;
            }
        }
    }

    int acquireSEAppList(AcquireSEAppListRequestParams acquireSEAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int activateVendorPay(ActivateVendorPayRequestParams activateVendorPayRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int addCardToVendorPay(AddCardToVendorPayRequestParams addCardToVendorPayRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int appDataUpdate(AppDataUpdateRequestParams appDataUpdateRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int appDelete(AppDeleteRequestParams appDeleteRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int appDownload(AppDownloadRequestParams appDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int appDownloadApply(AppDownloadApplyRequestParams appDownloadApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int appLock(AppLockRequestParams appLockRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int appUnlock(AppUnlockRequestParams appUnlockRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int cardListStatusChanged(CardListStatusChangedRequestParams cardListStatusChangedRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int checkSSamsungPay(CheckSSamsungPayRequestParams checkSSamsungPayRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int checkSupportCardApply(CheckSupportCardApplyRequestParams checkSupportCardApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int clearEncryptData(int i10) throws RemoteException;

    int clearKeyboardEncryptData(ClearEncryptDataRequestParams clearEncryptDataRequestParams, int i10) throws RemoteException;

    int closeChannel(CloseChannelRequestParams closeChannelRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int createSSD(UniteRequestParams uniteRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int eCashTopUp(ECashTopUpRequestParams eCashTopUpRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int exchangeKey(String str, String[] strArr) throws RemoteException;

    int executeCmd(ExecuteCmdRequestParams executeCmdRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int getAccountBalance(GetAccountBalanceRequestParams getAccountBalanceRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getAccountInfo(GetAccountInfoRequestParams getAccountInfoRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getAppDetail(GetAppDetailRequestParams getAppDetailRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getAppList(GetAppListRequestParams getAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getAppStatus(GetAppStatusRequestParams getAppStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getAssociatedApp(GetAssociatedAppRequestParams getAssociatedAppRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getCardInfo(GetCardInfoRequestParams getCardInfoRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getCardInfoBySamsungPay(GetCardInfoBySpayRequestParams getCardInfoBySpayRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getCurrentWalletClient(GetCurrentWalletClientRequestParams getCurrentWalletClientRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getDefaultCard(GetDefaultCardRequestParams getDefaultCardRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getMessageDetails(GetMessageDetailsRequestParams getMessageDetailsRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getPubKey(int i10, String[] strArr) throws RemoteException;

    int getSEAppList(GetSeAppListRequestParams getSeAppListRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getSEId(GetSeIdRequestParams getSeIdRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getSMSAuthCode(GetSMSAuthCodeRequestParams getSMSAuthCodeRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getTransElements(GetTransElementsRequestParams getTransElementsRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getTransRecord(GetTransRecordRequestParams getTransRecordRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getTransactionDetails(GetTransactionDetailsRequestParams getTransactionDetailsRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int getVendorPayStatus(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int hideAppApply(HideAppApplyRequestParams hideAppApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int hideKeyboard() throws RemoteException;

    int hideSafetyKeyboard(HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams) throws RemoteException;

    int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int onlinePaymentVerify(OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int openChannel(OpenChannelRequestParams openChannelRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int preDownload(PreDownloadRequestParams preDownloadRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) throws RemoteException;

    int queryVendorPayStatus(QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int sendApdu(SendApduRequestParams sendApduRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int sendCustomData(SendCustomDataRequestParams sendCustomDataRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int setDefaultCard(SetDefaultCardRequestParams setDefaultCardRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) throws RemoteException;

    int setSamsungDefaultWallet(SetSamsungDefWalletRequestParams setSamsungDefWalletRequestParams, ITsmCallback iTsmCallback) throws RemoteException;

    int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i10, OnSafetyKeyboardCallback onSafetyKeyboardCallback, ITsmActivityCallback iTsmActivityCallback) throws RemoteException;

    int startCardApply(StartCardApplyRequestParams startCardApplyRequestParams, ITsmCallback iTsmCallback) throws RemoteException;
}
