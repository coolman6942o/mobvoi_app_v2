package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
/* loaded from: classes.dex */
final class g0 {

    /* renamed from: a  reason: collision with root package name */
    private final Messenger f12481a;

    /* renamed from: b  reason: collision with root package name */
    private final zzi f12482b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(IBinder iBinder) throws RemoteException {
        String interfaceDescriptor = iBinder.getInterfaceDescriptor();
        if ("android.os.IMessenger".equals(interfaceDescriptor)) {
            this.f12481a = new Messenger(iBinder);
            this.f12482b = null;
        } else if ("com.google.android.gms.iid.IMessengerCompat".equals(interfaceDescriptor)) {
            this.f12482b = new zzi(iBinder);
            this.f12481a = null;
        } else {
            String valueOf = String.valueOf(interfaceDescriptor);
            Log.w("MessengerIpcClient", valueOf.length() != 0 ? "Invalid interface descriptor: ".concat(valueOf) : new String("Invalid interface descriptor: "));
            throw new RemoteException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Message message) throws RemoteException {
        Messenger messenger = this.f12481a;
        if (messenger != null) {
            messenger.send(message);
            return;
        }
        zzi zziVar = this.f12482b;
        if (zziVar != null) {
            zziVar.b(message);
            return;
        }
        throw new IllegalStateException("Both messengers are null");
    }
}
