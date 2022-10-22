package h1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: CopyLock.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static final Map<String, Lock> f27682e = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final File f27683a;

    /* renamed from: b  reason: collision with root package name */
    private final Lock f27684b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f27685c;

    /* renamed from: d  reason: collision with root package name */
    private FileChannel f27686d;

    public a(String str, File file, boolean z10) {
        File file2 = new File(file, str + ".lck");
        this.f27683a = file2;
        this.f27684b = a(file2.getAbsolutePath());
        this.f27685c = z10;
    }

    private static Lock a(String str) {
        Lock lock;
        Map<String, Lock> map = f27682e;
        synchronized (map) {
            lock = map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
        }
        return lock;
    }

    public void b() {
        this.f27684b.lock();
        if (this.f27685c) {
            try {
                FileChannel channel = new FileOutputStream(this.f27683a).getChannel();
                this.f27686d = channel;
                channel.lock();
            } catch (IOException e10) {
                throw new IllegalStateException("Unable to grab copy lock.", e10);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.f27686d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f27684b.unlock();
    }
}
