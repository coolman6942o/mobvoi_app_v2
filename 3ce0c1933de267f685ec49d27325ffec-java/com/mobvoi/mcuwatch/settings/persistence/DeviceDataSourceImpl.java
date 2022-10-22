package com.mobvoi.mcuwatch.settings.persistence;

import android.os.Looper;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.db.AppDataBase;
import com.mobvoi.mcuwatch.settings.persistence.DeviceDataSourceImpl;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import ni.a;
import pk.f;
import rx.c;
import rx.subjects.b;
import rx.subjects.d;
/* loaded from: classes2.dex */
public enum DeviceDataSourceImpl implements a {
    INSTANCE(AppDataBase.E().D());
    
    private static final String TAG = "DeviceDataSource";
    private final oi.a mInfoDao;
    private final d<pi.a, pi.a> mChangeBus = b.o0();
    private final d<String, String> mDelBus = b.o0();
    private final Executor daoExecutor = Executors.newCachedThreadPool();

    DeviceDataSourceImpl(oi.a aVar) {
        this.mInfoDao = aVar;
    }

    public static a getInstance() {
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void l(f fVar) {
        pi.a queryDevice = this.mInfoDao.queryDevice(fVar.a());
        if (queryDevice == null) {
            queryDevice = new pi.a();
        }
        queryDevice.macAddress = fVar.a();
        queryDevice.name = fVar.b();
        insertDeviceInfo(queryDevice);
    }

    private boolean i() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(String str) {
        this.mInfoDao.deleteDevice(str);
        this.mDelBus.onNext(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(pi.a aVar) {
        this.mInfoDao.a(aVar);
        this.mChangeBus.onNext(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ pi.a m(String str) throws Exception {
        return this.mInfoDao.queryDevice(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(pi.a aVar) {
        this.mInfoDao.b(aVar);
        this.mChangeBus.onNext(aVar);
    }

    @Override // ni.a
    public c<pi.a> dataChange() {
        return this.mChangeBus;
    }

    @Override // ni.a
    public void deleteDevice(final String str) {
        if (i()) {
            this.daoExecutor.execute(new Runnable() { // from class: ni.b
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceDataSourceImpl.this.j(str);
                }
            });
            return;
        }
        this.mInfoDao.deleteDevice(str);
        this.mDelBus.onNext(str);
    }

    @Override // ni.a
    public c<String> deviceDel() {
        return this.mDelBus;
    }

    public void insertDeviceInfo(final pi.a aVar) {
        if (i()) {
            this.daoExecutor.execute(new Runnable() { // from class: ni.d
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceDataSourceImpl.this.k(aVar);
                }
            });
        } else {
            this.mInfoDao.a(aVar);
            this.mChangeBus.onNext(aVar);
        }
        k.d(TAG, "insertDeviceInfo" + aVar);
    }

    @Override // ni.a
    public void insertOrUpdateInfo(final f fVar) {
        if (i()) {
            this.daoExecutor.execute(new Runnable() { // from class: ni.e
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceDataSourceImpl.this.l(fVar);
                }
            });
        } else {
            l(fVar);
        }
    }

    @Override // ni.a
    public c<pi.a> queryDevice(final String str) {
        return c.x(new Callable() { // from class: ni.f
            @Override // java.util.concurrent.Callable
            public final Object call() {
                pi.a m10;
                m10 = DeviceDataSourceImpl.this.m(str);
                return m10;
            }
        }).Z(cq.a.c());
    }

    @Override // ni.a
    public c<List<pi.a>> queryDevices() {
        final oi.a aVar = this.mInfoDao;
        Objects.requireNonNull(aVar);
        return c.x(new Callable() { // from class: ni.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return oi.a.this.queryDevices();
            }
        }).Z(cq.a.c());
    }

    public void updateDeviceInfo(final pi.a aVar) {
        if (i()) {
            this.daoExecutor.execute(new Runnable() { // from class: ni.c
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceDataSourceImpl.this.n(aVar);
                }
            });
            return;
        }
        this.mInfoDao.b(aVar);
        this.mChangeBus.onNext(aVar);
    }
}
