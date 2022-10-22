package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import k6.b;
/* loaded from: classes.dex */
public interface d extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class a extends zzb implements d {

        /* renamed from: com.google.android.gms.flags.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0112a extends zza implements d {
            C0112a(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.flags.IFlagProvider");
            }

            @Override // com.google.android.gms.flags.d
            public boolean getBooleanFlagValue(String str, boolean z10, int i10) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                zzc.zza(obtainAndWriteInterfaceToken, z10);
                obtainAndWriteInterfaceToken.writeInt(i10);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken);
                boolean zza = zzc.zza(transactAndReadException);
                transactAndReadException.recycle();
                return zza;
            }

            @Override // com.google.android.gms.flags.d
            public int getIntFlagValue(String str, int i10, int i11) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeInt(i10);
                obtainAndWriteInterfaceToken.writeInt(i11);
                Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.flags.d
            public long getLongFlagValue(String str, long j10, int i10) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeLong(j10);
                obtainAndWriteInterfaceToken.writeInt(i10);
                Parcel transactAndReadException = transactAndReadException(4, obtainAndWriteInterfaceToken);
                long readLong = transactAndReadException.readLong();
                transactAndReadException.recycle();
                return readLong;
            }

            @Override // com.google.android.gms.flags.d
            public String getStringFlagValue(String str, String str2, int i10) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeString(str2);
                obtainAndWriteInterfaceToken.writeInt(i10);
                Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
                String readString = transactAndReadException.readString();
                transactAndReadException.recycle();
                return readString;
            }

            @Override // com.google.android.gms.flags.d
            public void init(b bVar) throws RemoteException {
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, bVar);
                transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
            }
        }

        public a() {
            super("com.google.android.gms.flags.IFlagProvider");
        }

        public static d asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
            return queryLocalInterface instanceof d ? (d) queryLocalInterface : new C0112a(iBinder);
        }
    }

    boolean getBooleanFlagValue(String str, boolean z10, int i10) throws RemoteException;

    int getIntFlagValue(String str, int i10, int i11) throws RemoteException;

    long getLongFlagValue(String str, long j10, int i10) throws RemoteException;

    String getStringFlagValue(String str, String str2, int i10) throws RemoteException;

    void init(b bVar) throws RemoteException;
}
