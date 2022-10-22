package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import c7.s0;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, s0<T>> f10219a = new HashMap();

    public final void a(IBinder iBinder) {
        i jVar;
        synchronized (this.f10219a) {
            if (iBinder == null) {
                jVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
                if (queryLocalInterface instanceof i) {
                    jVar = (i) queryLocalInterface;
                } else {
                    jVar = new j(iBinder);
                }
            }
            v vVar = new v();
            for (Map.Entry<T, s0<T>> entry : this.f10219a.entrySet()) {
                s0<T> value = entry.getValue();
                try {
                    jVar.e0(vVar, new zzd(value));
                    if (Log.isLoggable("WearableClient", 3)) {
                        String valueOf = String.valueOf(entry.getKey());
                        String valueOf2 = String.valueOf(value);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 27 + valueOf2.length());
                        sb2.append("onPostInitHandler: added: ");
                        sb2.append(valueOf);
                        sb2.append("/");
                        sb2.append(valueOf2);
                        Log.d("WearableClient", sb2.toString());
                    }
                } catch (RemoteException unused) {
                    String valueOf3 = String.valueOf(entry.getKey());
                    String valueOf4 = String.valueOf(value);
                    StringBuilder sb3 = new StringBuilder(valueOf3.length() + 32 + valueOf4.length());
                    sb3.append("onPostInitHandler: Didn't add: ");
                    sb3.append(valueOf3);
                    sb3.append("/");
                    sb3.append(valueOf4);
                    Log.w("WearableClient", sb3.toString());
                }
            }
        }
    }
}
