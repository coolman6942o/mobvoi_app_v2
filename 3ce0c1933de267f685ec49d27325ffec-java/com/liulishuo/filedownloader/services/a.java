package com.liulishuo.filedownloader.services;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent;
import i9.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import r9.c;
/* compiled from: BaseFileServiceUIGuard.java */
/* loaded from: classes2.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements e, ServiceConnection {

    /* renamed from: b  reason: collision with root package name */
    private volatile INTERFACE f15246b;

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f15247c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<Runnable> f15248d = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private final CALLBACK f15245a = b();

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Class<?> cls) {
        new HashMap();
        new ArrayList();
        this.f15247c = cls;
    }

    private void d(boolean z10) {
        if (!z10 && this.f15246b != null) {
            try {
                e(this.f15246b, this.f15245a);
            } catch (RemoteException e10) {
                e10.printStackTrace();
            }
        }
        if (c.f33469a) {
            c.a(this, "release connect resources %s", this.f15246b);
        }
        this.f15246b = null;
        i9.a.d().a(new DownloadServiceConnectChangedEvent(z10 ? DownloadServiceConnectChangedEvent.ConnectStatus.lost : DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, this.f15247c));
    }

    protected abstract INTERFACE a(IBinder iBinder);

    protected abstract CALLBACK b();

    protected abstract void c(INTERFACE r12, CALLBACK callback) throws RemoteException;

    protected abstract void e(INTERFACE r12, CALLBACK callback) throws RemoteException;

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f15246b = a(iBinder);
        if (c.f33469a) {
            c.a(this, "onServiceConnected %s %s", componentName, this.f15246b);
        }
        try {
            c(this.f15246b, this.f15245a);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
        this.f15248d.clear();
        for (Runnable runnable : (List) this.f15248d.clone()) {
            runnable.run();
        }
        i9.a.d().a(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.f15247c));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (c.f33469a) {
            c.a(this, "onServiceDisconnected %s %s", componentName, this.f15246b);
        }
        d(true);
    }
}
