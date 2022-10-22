package com.liulishuo.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.lang.ref.WeakReference;
import r9.b;
import r9.d;
import r9.e;
@SuppressLint({"Registered"})
/* loaded from: classes2.dex */
public class FileDownloadService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private f f15244a;

    /* loaded from: classes2.dex */
    public static class SeparateProcessService extends FileDownloadService {
    }

    /* loaded from: classes2.dex */
    public static class SharedMainProcessService extends FileDownloadService {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f15244a.m1(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        b.b(this);
        try {
            e.O(d.a().f33470a);
            e.P(d.a().f33471b);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        }
        d dVar = new d();
        if (d.a().f33473d) {
            this.f15244a = new c(new WeakReference(this), dVar);
        } else {
            this.f15244a = new b(new WeakReference(this), dVar);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f15244a.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        this.f15244a.U1(intent, i10, i11);
        return 1;
    }
}
