package com.google.android.gms.flags;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.flags.d;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private boolean f9062a = false;

    /* renamed from: b  reason: collision with root package name */
    private d f9063b = null;

    public <T> T a(a<T> aVar) {
        synchronized (this) {
            if (this.f9062a) {
                return aVar.f(this.f9063b);
            }
            return aVar.g();
        }
    }

    public void b(Context context) {
        synchronized (this) {
            if (!this.f9062a) {
                try {
                    d asInterface = d.a.asInterface(DynamiteModule.d(context, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION_NO_FORCE_STAGING, ModuleDescriptor.MODULE_ID).c("com.google.android.gms.flags.impl.FlagProviderImpl"));
                    this.f9063b = asInterface;
                    asInterface.init(k6.d.A2(context));
                    this.f9062a = true;
                } catch (RemoteException | DynamiteModule.LoadingException e10) {
                    Log.w("FlagValueProvider", "Failed to initialize flags module.", e10);
                }
            }
        }
    }
}
