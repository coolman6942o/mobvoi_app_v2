package zk;

import java.util.concurrent.LinkedBlockingDeque;
/* loaded from: classes2.dex */
public abstract class a<T> extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f37624a = false;

    /* renamed from: b  reason: collision with root package name */
    public LinkedBlockingDeque<T> f37625b = new LinkedBlockingDeque<>();

    public void a(T t10) {
        synchronized (this.f37625b) {
            this.f37625b.add(t10);
        }
    }

    public void b(boolean z10) {
        this.f37624a = z10;
    }

    public void c() {
        synchronized (this.f37625b) {
            this.f37625b.clear();
        }
    }

    public boolean d() {
        return this.f37624a;
    }

    public T e() {
        try {
            return this.f37625b.take();
        } catch (InterruptedException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
