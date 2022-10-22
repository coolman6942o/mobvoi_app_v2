package com.liulishuo.filedownloader.services;

import android.util.SparseArray;
import com.liulishuo.filedownloader.download.d;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import r9.a;
import r9.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDownloadThreadPool.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: b  reason: collision with root package name */
    private ThreadPoolExecutor f15257b;

    /* renamed from: c  reason: collision with root package name */
    private int f15258c;

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<d> f15256a = new SparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private int f15259d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(int i10) {
        this.f15257b = a.a(i10, "Network");
        this.f15258c = i10;
    }

    private synchronized void d() {
        SparseArray<d> sparseArray = new SparseArray<>();
        int size = this.f15256a.size();
        for (int i10 = 0; i10 < size; i10++) {
            int keyAt = this.f15256a.keyAt(i10);
            d dVar = this.f15256a.get(keyAt);
            if (dVar.o()) {
                sparseArray.put(keyAt, dVar);
            }
        }
        this.f15256a = sparseArray;
    }

    public void a(int i10) {
        d();
        synchronized (this) {
            d dVar = this.f15256a.get(i10);
            if (dVar != null) {
                dVar.q();
                boolean remove = this.f15257b.remove(dVar);
                if (c.f33469a) {
                    c.a(this, "successful cancel %d %B", Integer.valueOf(i10), Boolean.valueOf(remove));
                }
            }
            this.f15256a.remove(i10);
        }
    }

    public synchronized int b() {
        d();
        return this.f15256a.size();
    }

    public void c(d dVar) {
        dVar.r();
        synchronized (this) {
            this.f15256a.put(dVar.j(), dVar);
        }
        this.f15257b.execute(dVar);
        int i10 = this.f15259d;
        if (i10 >= 600) {
            d();
            this.f15259d = 0;
            return;
        }
        this.f15259d = i10 + 1;
    }

    public int e(String str, int i10) {
        if (str == null) {
            return 0;
        }
        int size = this.f15256a.size();
        for (int i11 = 0; i11 < size; i11++) {
            d valueAt = this.f15256a.valueAt(i11);
            if (valueAt != null && valueAt.o() && valueAt.j() != i10 && str.equals(valueAt.k())) {
                return valueAt.j();
            }
        }
        return 0;
    }

    public synchronized List<Integer> f() {
        ArrayList arrayList;
        d();
        arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f15256a.size(); i10++) {
            SparseArray<d> sparseArray = this.f15256a;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i10)).j()));
        }
        return arrayList;
    }

    public boolean g(int i10) {
        d dVar = this.f15256a.get(i10);
        return dVar != null && dVar.o();
    }

    public synchronized boolean h(int i10) {
        if (b() > 0) {
            c.i(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int b10 = r9.d.b(i10);
        if (c.f33469a) {
            c.a(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f15258c), Integer.valueOf(b10));
        }
        List<Runnable> shutdownNow = this.f15257b.shutdownNow();
        this.f15257b = a.a(b10, "Network");
        if (shutdownNow.size() > 0) {
            c.i(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.f15258c = b10;
        return true;
    }
}
