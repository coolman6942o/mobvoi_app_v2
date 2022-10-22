package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import java.lang.ref.WeakReference;
import m9.b;
/* compiled from: FDServiceSharedHandler.java */
/* loaded from: classes2.dex */
public class c extends b.a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final d f15252a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<FileDownloadService> f15253b;

    /* compiled from: FDServiceSharedHandler.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b(c cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WeakReference<FileDownloadService> weakReference, d dVar) {
        this.f15253b = weakReference;
        this.f15252a = dVar;
    }

    @Override // m9.b
    public long F1(int i10) {
        return this.f15252a.e(i10);
    }

    @Override // m9.b
    public boolean N(int i10) {
        return this.f15252a.k(i10);
    }

    @Override // m9.b
    public boolean O0(int i10) {
        return this.f15252a.d(i10);
    }

    @Override // m9.b
    public void O1(m9.a aVar) {
    }

    @Override // com.liulishuo.filedownloader.services.f
    public void U1(Intent intent, int i10, int i11) {
        i9.b.a().b(this);
    }

    @Override // m9.b
    public void V() {
        this.f15252a.c();
    }

    @Override // m9.b
    public long Y0(int i10) {
        return this.f15252a.g(i10);
    }

    @Override // m9.b
    public void Z0(boolean z10) {
        WeakReference<FileDownloadService> weakReference = this.f15253b;
        if (weakReference != null && weakReference.get() != null) {
            this.f15253b.get().stopForeground(z10);
        }
    }

    @Override // m9.b
    public byte f(int i10) {
        return this.f15252a.f(i10);
    }

    @Override // m9.b
    public void j2(int i10, Notification notification) {
        WeakReference<FileDownloadService> weakReference = this.f15253b;
        if (weakReference != null && weakReference.get() != null) {
            this.f15253b.get().startForeground(i10, notification);
        }
    }

    @Override // m9.b
    public void k(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, FileDownloadHeader fileDownloadHeader, boolean z12) {
        this.f15252a.n(str, str2, z10, i10, i11, i12, z11, fileDownloadHeader, z12);
    }

    @Override // m9.b
    public boolean k0(String str, String str2) {
        return this.f15252a.i(str, str2);
    }

    @Override // com.liulishuo.filedownloader.services.f
    public IBinder m1(Intent intent) {
        return null;
    }

    @Override // m9.b
    public boolean o0(int i10) {
        return this.f15252a.m(i10);
    }

    @Override // com.liulishuo.filedownloader.services.f
    public void onDestroy() {
        i9.b.a().a();
    }

    @Override // m9.b
    public void s0(m9.a aVar) {
    }

    @Override // m9.b
    public boolean u1() {
        return this.f15252a.j();
    }

    @Override // m9.b
    public void u2() {
        this.f15252a.l();
    }
}
