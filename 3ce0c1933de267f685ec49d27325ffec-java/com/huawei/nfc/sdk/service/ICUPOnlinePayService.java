package com.huawei.nfc.sdk.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.nfc.sdk.service.ICUPOnlinePayCallBackService;
/* loaded from: classes2.dex */
public interface ICUPOnlinePayService extends IInterface {

    /* loaded from: classes2.dex */
    public abstract class Stub extends Binder implements ICUPOnlinePayService {
        private static final String DESCRIPTOR = "com.huawei.nfc.sdk.service.ICUPOnlinePayService";
        static final int TRANSACTION_getUnionOnlinePayStatus = 2;
        static final int TRANSACTION_supportCapacity = 1;

        /* loaded from: classes2.dex */
        class Proxy implements ICUPOnlinePayService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.huawei.nfc.sdk.service.ICUPOnlinePayService
            public void getUnionOnlinePayStatus(ICUPOnlinePayCallBackService iCUPOnlinePayCallBackService) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iCUPOnlinePayCallBackService != null ? iCUPOnlinePayCallBackService.asBinder() : null);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.nfc.sdk.service.ICUPOnlinePayService
            public boolean supportCapacity(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    boolean z10 = false;
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICUPOnlinePayService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ICUPOnlinePayService)) ? new Proxy(iBinder) : (ICUPOnlinePayService) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean supportCapacity = supportCapacity(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(supportCapacity ? 1 : 0);
                return true;
            } else if (i10 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                getUnionOnlinePayStatus(ICUPOnlinePayCallBackService.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i10 != 1598968902) {
                return super.onTransact(i10, parcel, parcel2, i11);
            } else {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
        }
    }

    void getUnionOnlinePayStatus(ICUPOnlinePayCallBackService iCUPOnlinePayCallBackService);

    boolean supportCapacity(String str);
}
