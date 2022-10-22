package n5;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;
/* compiled from: ExceptionCatchingInputStream.java */
/* loaded from: classes.dex */
public class d extends InputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final Queue<d> f31031c = k.e(0);

    /* renamed from: a  reason: collision with root package name */
    private InputStream f31032a;

    /* renamed from: b  reason: collision with root package name */
    private IOException f31033b;

    d() {
    }

    public static d d(InputStream inputStream) {
        d poll;
        Queue<d> queue = f31031c;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.i(inputStream);
        return poll;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f31032a.available();
    }

    public IOException c() {
        return this.f31033b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f31032a.close();
    }

    public void h() {
        this.f31033b = null;
        this.f31032a = null;
        Queue<d> queue = f31031c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    void i(InputStream inputStream) {
        this.f31032a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f31032a.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f31032a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f31032a.read(bArr);
        } catch (IOException e10) {
            this.f31033b = e10;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f31032a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) {
        try {
            return this.f31032a.skip(j10);
        } catch (IOException e10) {
            this.f31033b = e10;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        try {
            return this.f31032a.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f31033b = e10;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f31032a.read();
        } catch (IOException e10) {
            this.f31033b = e10;
            return -1;
        }
    }
}
