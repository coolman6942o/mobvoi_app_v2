package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.lang.ref.WeakReference;
import m9.a;
import m9.b;
import n9.b;
import r9.c;
/* compiled from: FDServiceSeparateHandler.java */
/* loaded from: classes2.dex */
public class b extends b.a implements b.AbstractC0410b, f {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteCallbackList<a> f15249a = new RemoteCallbackList<>();

    /* renamed from: b  reason: collision with root package name */
    private final d f15250b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<FileDownloadService> f15251c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WeakReference<FileDownloadService> weakReference, d dVar) {
        this.f15251c = weakReference;
        this.f15250b = dVar;
        n9.b.a().c(this);
    }

    private synchronized int B2(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        RemoteCallbackList<a> remoteCallbackList;
        beginBroadcast = this.f15249a.beginBroadcast();
        for (int i10 = 0; i10 < beginBroadcast; i10++) {
            try {
                this.f15249a.getBroadcastItem(i10).e1(messageSnapshot);
            } catch (RemoteException e10) {
                c.c(this, e10, "callback error", new Object[0]);
                remoteCallbackList = this.f15249a;
            }
        }
        remoteCallbackList = this.f15249a;
        remoteCallbackList.finishBroadcast();
        return beginBroadcast;
    }

    @Override // m9.b
    public long F1(int i10) throws RemoteException {
        return this.f15250b.e(i10);
    }

    @Override // m9.b
    public boolean N(int i10) throws RemoteException {
        return this.f15250b.k(i10);
    }

    @Override // m9.b
    public boolean O0(int i10) throws RemoteException {
        return this.f15250b.d(i10);
    }

    @Override // m9.b
    public void O1(a aVar) throws RemoteException {
        this.f15249a.unregister(aVar);
    }

    @Override // com.liulishuo.filedownloader.services.f
    public void U1(Intent intent, int i10, int i11) {
    }

    @Override // m9.b
    public void V() throws RemoteException {
        this.f15250b.c();
    }

    @Override // m9.b
    public long Y0(int i10) throws RemoteException {
        return this.f15250b.g(i10);
    }

    @Override // m9.b
    public void Z0(boolean z10) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.f15251c;
        if (weakReference != null && weakReference.get() != null) {
            this.f15251c.get().stopForeground(z10);
        }
    }

    @Override // n9.b.AbstractC0410b
    public void c(MessageSnapshot messageSnapshot) {
        B2(messageSnapshot);
    }

    @Override // m9.b
    public byte f(int i10) throws RemoteException {
        return this.f15250b.f(i10);
    }

    @Override // m9.b
    public void j2(int i10, Notification notification) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.f15251c;
        if (weakReference != null && weakReference.get() != null) {
            this.f15251c.get().startForeground(i10, notification);
        }
    }

    @Override // m9.b
    public void k(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, FileDownloadHeader fileDownloadHeader, boolean z12) throws RemoteException {
        this.f15250b.n(str, str2, z10, i10, i11, i12, z11, fileDownloadHeader, z12);
    }

    @Override // m9.b
    public boolean k0(String str, String str2) throws RemoteException {
        return this.f15250b.i(str, str2);
    }

    @Override // com.liulishuo.filedownloader.services.f
    public IBinder m1(Intent intent) {
        return this;
    }

    @Override // m9.b
    public boolean o0(int i10) throws RemoteException {
        return this.f15250b.m(i10);
    }

    @Override // com.liulishuo.filedownloader.services.f
    public void onDestroy() {
        n9.b.a().c(null);
    }

    @Override // m9.b
    public void s0(a aVar) throws RemoteException {
        this.f15249a.register(aVar);
    }

    @Override // m9.b
    public boolean u1() throws RemoteException {
        return this.f15250b.j();
    }

    @Override // m9.b
    public void u2() throws RemoteException {
        this.f15250b.l();
    }
}
