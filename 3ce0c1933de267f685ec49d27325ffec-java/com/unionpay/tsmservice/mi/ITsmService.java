package com.unionpay.tsmservice.mi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.unionpay.tsmservice.mi.ITsmActivityCallback;
import com.unionpay.tsmservice.mi.ITsmCallback;
import com.unionpay.tsmservice.mi.ITsmProgressCallback;
import com.unionpay.tsmservice.mi.OnSafetyKeyboardCallback;
import com.unionpay.tsmservice.mi.request.AcquireSEAppListRequestParams;
import com.unionpay.tsmservice.mi.request.AddCardToVendorPayRequestParams;
import com.unionpay.tsmservice.mi.request.CancelPayRequestParams;
import com.unionpay.tsmservice.mi.request.CardListStatusChangedRequestParams;
import com.unionpay.tsmservice.mi.request.ClearEncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.EncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.GetEncryptDataRequestParams;
import com.unionpay.tsmservice.mi.request.GetMessageDetailsRequestParams;
import com.unionpay.tsmservice.mi.request.GetSeIdRequestParams;
import com.unionpay.tsmservice.mi.request.GetTransactionDetailsRequestParams;
import com.unionpay.tsmservice.mi.request.GetVendorPayStatusRequestParams;
import com.unionpay.tsmservice.mi.request.HideSafetyKeyboardRequestParams;
import com.unionpay.tsmservice.mi.request.InitRequestParams;
import com.unionpay.tsmservice.mi.request.OnlinePaymentVerifyRequestParams;
import com.unionpay.tsmservice.mi.request.PayResultNotifyRequestParams;
import com.unionpay.tsmservice.mi.request.PinRequestRequestParams;
import com.unionpay.tsmservice.mi.request.QueryVendorPayStatusRequestParams;
import com.unionpay.tsmservice.mi.request.SafetyKeyboardRequestParams;
/* loaded from: classes2.dex */
public interface ITsmService extends IInterface {

    /* loaded from: classes2.dex */
    public abstract class Stub extends Binder implements ITsmService {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public final class a implements ITsmService {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f24531a;

            a(IBinder iBinder) {
                this.f24531a = iBinder;
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int acquireSEAppList(AcquireSEAppListRequestParams acquireSEAppListRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (acquireSEAppListRequestParams != null) {
                        obtain.writeInt(1);
                        acquireSEAppListRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int addCardToVendorPay(AddCardToVendorPayRequestParams addCardToVendorPayRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
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
                    this.f24531a.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f24531a;
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int cancelPay(CancelPayRequestParams cancelPayRequestParams) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (cancelPayRequestParams != null) {
                        obtain.writeInt(1);
                        cancelPayRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24531a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int cardListStatusChanged(CardListStatusChangedRequestParams cardListStatusChangedRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (cardListStatusChangedRequestParams != null) {
                        obtain.writeInt(1);
                        cardListStatusChangedRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int clearEncryptData(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    obtain.writeInt(i10);
                    this.f24531a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int clearKeyboardEncryptData(ClearEncryptDataRequestParams clearEncryptDataRequestParams, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (clearEncryptDataRequestParams != null) {
                        obtain.writeInt(1);
                        clearEncryptDataRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i10);
                    this.f24531a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (encryptDataRequestParams != null) {
                        obtain.writeInt(1);
                        encryptDataRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int exchangeKey(String str, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    obtain.writeString(str);
                    if (strArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(strArr.length);
                    }
                    this.f24531a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readStringArray(strArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getEncryptDataRequestParams != null) {
                        obtain.writeInt(1);
                        getEncryptDataRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getMessageDetails(GetMessageDetailsRequestParams getMessageDetailsRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getMessageDetailsRequestParams != null) {
                        obtain.writeInt(1);
                        getMessageDetailsRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getPubKey(int i10, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    obtain.writeInt(i10);
                    if (strArr == null) {
                        obtain.writeInt(-1);
                    } else {
                        obtain.writeInt(strArr.length);
                    }
                    this.f24531a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readStringArray(strArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getSEId(GetSeIdRequestParams getSeIdRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getSeIdRequestParams != null) {
                        obtain.writeInt(1);
                        getSeIdRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getTransactionDetails(GetTransactionDetailsRequestParams getTransactionDetailsRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getTransactionDetailsRequestParams != null) {
                        obtain.writeInt(1);
                        getTransactionDetailsRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getVendorPayStatus(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getVendorPayStatusRequestParams != null) {
                        obtain.writeInt(1);
                        getVendorPayStatusRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int getVendorPayStatusForBankApp(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (getVendorPayStatusRequestParams != null) {
                        obtain.writeInt(1);
                        getVendorPayStatusRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int hideKeyboard() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    this.f24531a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int hideSafetyKeyboard(HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (hideSafetyKeyboardRequestParams != null) {
                        obtain.writeInt(1);
                        hideSafetyKeyboardRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24531a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (initRequestParams != null) {
                        obtain.writeInt(1);
                        initRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int onlinePaymentVerify(OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (onlinePaymentVerifyRequestParams != null) {
                        obtain.writeInt(1);
                        onlinePaymentVerifyRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int payResultNotify(PayResultNotifyRequestParams payResultNotifyRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (payResultNotifyRequestParams != null) {
                        obtain.writeInt(1);
                        payResultNotifyRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int pinRequest(PinRequestRequestParams pinRequestRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (pinRequestRequestParams != null) {
                        obtain.writeInt(1);
                        pinRequestRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int queryVendorPayStatus(QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams, ITsmCallback iTsmCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (queryVendorPayStatusRequestParams != null) {
                        obtain.writeInt(1);
                        queryVendorPayStatusRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iTsmCallback != null ? iTsmCallback.asBinder() : null);
                    this.f24531a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
                    if (safetyKeyboardRequestParams != null) {
                        obtain.writeInt(1);
                        safetyKeyboardRequestParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f24531a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.unionpay.tsmservice.mi.ITsmService
            public final int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i10, OnSafetyKeyboardCallback onSafetyKeyboardCallback, ITsmActivityCallback iTsmActivityCallback) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.unionpay.tsmservice.mi.ITsmService");
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
                    this.f24531a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.unionpay.tsmservice.mi.ITsmService");
        }

        public static ITsmService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.unionpay.tsmservice.mi.ITsmService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITsmService)) ? new a(iBinder) : (ITsmService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 != 1598968902) {
                InitRequestParams initRequestParams = null;
                GetMessageDetailsRequestParams getMessageDetailsRequestParams = null;
                GetTransactionDetailsRequestParams getTransactionDetailsRequestParams = null;
                AddCardToVendorPayRequestParams addCardToVendorPayRequestParams = null;
                GetSeIdRequestParams getSeIdRequestParams = null;
                GetVendorPayStatusRequestParams getVendorPayStatusRequestParams = null;
                PayResultNotifyRequestParams payResultNotifyRequestParams = null;
                CancelPayRequestParams cancelPayRequestParams = null;
                PinRequestRequestParams pinRequestRequestParams = null;
                OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams = null;
                GetVendorPayStatusRequestParams getVendorPayStatusRequestParams2 = null;
                QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams = null;
                CardListStatusChangedRequestParams cardListStatusChangedRequestParams = null;
                AcquireSEAppListRequestParams acquireSEAppListRequestParams = null;
                HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams = null;
                ClearEncryptDataRequestParams clearEncryptDataRequestParams = null;
                GetEncryptDataRequestParams getEncryptDataRequestParams = null;
                SafetyKeyboardRequestParams safetyKeyboardRequestParams = null;
                SafetyKeyboardRequestParams safetyKeyboardRequestParams2 = null;
                EncryptDataRequestParams encryptDataRequestParams = null;
                String[] strArr = null;
                String[] strArr2 = null;
                switch (i10) {
                    case 1:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            initRequestParams = (InitRequestParams) InitRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int init = init(initRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(init);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
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
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
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
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            encryptDataRequestParams = (EncryptDataRequestParams) EncryptDataRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int encryptData = encryptData(encryptDataRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(encryptData);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            safetyKeyboardRequestParams2 = (SafetyKeyboardRequestParams) SafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int showSafetyKeyboard = showSafetyKeyboard(safetyKeyboardRequestParams2, parcel.readInt(), OnSafetyKeyboardCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmActivityCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(showSafetyKeyboard);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            safetyKeyboardRequestParams = (SafetyKeyboardRequestParams) SafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int safetyKeyboardBitmap = setSafetyKeyboardBitmap(safetyKeyboardRequestParams);
                        parcel2.writeNoException();
                        parcel2.writeInt(safetyKeyboardBitmap);
                        return true;
                    case 7:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            getEncryptDataRequestParams = (GetEncryptDataRequestParams) GetEncryptDataRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int encryptData2 = getEncryptData(getEncryptDataRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(encryptData2);
                        return true;
                    case 8:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        int clearEncryptData = clearEncryptData(parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(clearEncryptData);
                        return true;
                    case 9:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        int hideKeyboard = hideKeyboard();
                        parcel2.writeNoException();
                        parcel2.writeInt(hideKeyboard);
                        return true;
                    case 10:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            clearEncryptDataRequestParams = (ClearEncryptDataRequestParams) ClearEncryptDataRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int clearKeyboardEncryptData = clearKeyboardEncryptData(clearEncryptDataRequestParams, parcel.readInt());
                        parcel2.writeNoException();
                        parcel2.writeInt(clearKeyboardEncryptData);
                        return true;
                    case 11:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            hideSafetyKeyboardRequestParams = (HideSafetyKeyboardRequestParams) HideSafetyKeyboardRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int hideSafetyKeyboard = hideSafetyKeyboard(hideSafetyKeyboardRequestParams);
                        parcel2.writeNoException();
                        parcel2.writeInt(hideSafetyKeyboard);
                        return true;
                    case 12:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            acquireSEAppListRequestParams = (AcquireSEAppListRequestParams) AcquireSEAppListRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int acquireSEAppList = acquireSEAppList(acquireSEAppListRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(acquireSEAppList);
                        return true;
                    case 13:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            cardListStatusChangedRequestParams = (CardListStatusChangedRequestParams) CardListStatusChangedRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int cardListStatusChanged = cardListStatusChanged(cardListStatusChangedRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(cardListStatusChanged);
                        return true;
                    case 14:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            queryVendorPayStatusRequestParams = (QueryVendorPayStatusRequestParams) QueryVendorPayStatusRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int queryVendorPayStatus = queryVendorPayStatus(queryVendorPayStatusRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(queryVendorPayStatus);
                        return true;
                    case 15:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            getVendorPayStatusRequestParams2 = (GetVendorPayStatusRequestParams) GetVendorPayStatusRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int vendorPayStatus = getVendorPayStatus(getVendorPayStatusRequestParams2, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(vendorPayStatus);
                        return true;
                    case 16:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            onlinePaymentVerifyRequestParams = (OnlinePaymentVerifyRequestParams) OnlinePaymentVerifyRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int onlinePaymentVerify = onlinePaymentVerify(onlinePaymentVerifyRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(onlinePaymentVerify);
                        return true;
                    case 17:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            pinRequestRequestParams = (PinRequestRequestParams) PinRequestRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int pinRequest = pinRequest(pinRequestRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(pinRequest);
                        return true;
                    case 18:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            cancelPayRequestParams = (CancelPayRequestParams) CancelPayRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int cancelPay = cancelPay(cancelPayRequestParams);
                        parcel2.writeNoException();
                        parcel2.writeInt(cancelPay);
                        return true;
                    case 19:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            payResultNotifyRequestParams = (PayResultNotifyRequestParams) PayResultNotifyRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int payResultNotify = payResultNotify(payResultNotifyRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(payResultNotify);
                        return true;
                    case 20:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            getVendorPayStatusRequestParams = (GetVendorPayStatusRequestParams) GetVendorPayStatusRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int vendorPayStatusForBankApp = getVendorPayStatusForBankApp(getVendorPayStatusRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(vendorPayStatusForBankApp);
                        return true;
                    case 21:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            getSeIdRequestParams = (GetSeIdRequestParams) GetSeIdRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int sEId = getSEId(getSeIdRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(sEId);
                        return true;
                    case 22:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            addCardToVendorPayRequestParams = (AddCardToVendorPayRequestParams) AddCardToVendorPayRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int addCardToVendorPay = addCardToVendorPay(addCardToVendorPayRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()), ITsmProgressCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(addCardToVendorPay);
                        return true;
                    case 23:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            getTransactionDetailsRequestParams = (GetTransactionDetailsRequestParams) GetTransactionDetailsRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int transactionDetails = getTransactionDetails(getTransactionDetailsRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(transactionDetails);
                        return true;
                    case 24:
                        parcel.enforceInterface("com.unionpay.tsmservice.mi.ITsmService");
                        if (parcel.readInt() != 0) {
                            getMessageDetailsRequestParams = (GetMessageDetailsRequestParams) GetMessageDetailsRequestParams.CREATOR.createFromParcel(parcel);
                        }
                        int messageDetails = getMessageDetails(getMessageDetailsRequestParams, ITsmCallback.Stub.asInterface(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        parcel2.writeInt(messageDetails);
                        return true;
                    default:
                        return super.onTransact(i10, parcel, parcel2, i11);
                }
            } else {
                parcel2.writeString("com.unionpay.tsmservice.mi.ITsmService");
                return true;
            }
        }
    }

    int acquireSEAppList(AcquireSEAppListRequestParams acquireSEAppListRequestParams, ITsmCallback iTsmCallback);

    int addCardToVendorPay(AddCardToVendorPayRequestParams addCardToVendorPayRequestParams, ITsmCallback iTsmCallback, ITsmProgressCallback iTsmProgressCallback);

    int cancelPay(CancelPayRequestParams cancelPayRequestParams);

    int cardListStatusChanged(CardListStatusChangedRequestParams cardListStatusChangedRequestParams, ITsmCallback iTsmCallback);

    int clearEncryptData(int i10);

    int clearKeyboardEncryptData(ClearEncryptDataRequestParams clearEncryptDataRequestParams, int i10);

    int encryptData(EncryptDataRequestParams encryptDataRequestParams, ITsmCallback iTsmCallback);

    int exchangeKey(String str, String[] strArr);

    int getEncryptData(GetEncryptDataRequestParams getEncryptDataRequestParams, ITsmCallback iTsmCallback);

    int getMessageDetails(GetMessageDetailsRequestParams getMessageDetailsRequestParams, ITsmCallback iTsmCallback);

    int getPubKey(int i10, String[] strArr);

    int getSEId(GetSeIdRequestParams getSeIdRequestParams, ITsmCallback iTsmCallback);

    int getTransactionDetails(GetTransactionDetailsRequestParams getTransactionDetailsRequestParams, ITsmCallback iTsmCallback);

    int getVendorPayStatus(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback);

    int getVendorPayStatusForBankApp(GetVendorPayStatusRequestParams getVendorPayStatusRequestParams, ITsmCallback iTsmCallback);

    int hideKeyboard();

    int hideSafetyKeyboard(HideSafetyKeyboardRequestParams hideSafetyKeyboardRequestParams);

    int init(InitRequestParams initRequestParams, ITsmCallback iTsmCallback);

    int onlinePaymentVerify(OnlinePaymentVerifyRequestParams onlinePaymentVerifyRequestParams, ITsmCallback iTsmCallback);

    int payResultNotify(PayResultNotifyRequestParams payResultNotifyRequestParams, ITsmCallback iTsmCallback);

    int pinRequest(PinRequestRequestParams pinRequestRequestParams, ITsmCallback iTsmCallback);

    int queryVendorPayStatus(QueryVendorPayStatusRequestParams queryVendorPayStatusRequestParams, ITsmCallback iTsmCallback);

    int setSafetyKeyboardBitmap(SafetyKeyboardRequestParams safetyKeyboardRequestParams);

    int showSafetyKeyboard(SafetyKeyboardRequestParams safetyKeyboardRequestParams, int i10, OnSafetyKeyboardCallback onSafetyKeyboardCallback, ITsmActivityCallback iTsmActivityCallback);
}
