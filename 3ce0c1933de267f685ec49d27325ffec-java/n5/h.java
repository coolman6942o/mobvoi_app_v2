package n5;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: MarkEnforcingInputStream.java */
/* loaded from: classes.dex */
public class h extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private int f31041a = Integer.MIN_VALUE;

    public h(InputStream inputStream) {
        super(inputStream);
    }

    private long c(long j10) {
        int i10 = this.f31041a;
        if (i10 == 0) {
            return -1L;
        }
        return (i10 == Integer.MIN_VALUE || j10 <= ((long) i10)) ? j10 : i10;
    }

    private void d(long j10) {
        int i10 = this.f31041a;
        if (i10 != Integer.MIN_VALUE && j10 != -1) {
            this.f31041a = (int) (i10 - j10);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i10 = this.f31041a;
        if (i10 == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i10, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        super.mark(i10);
        this.f31041a = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (c(1L) == -1) {
            return -1;
        }
        int read = super.read();
        d(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f31041a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long c10 = c(j10);
        if (c10 == -1) {
            return 0L;
        }
        long skip = super.skip(c10);
        d(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int c10 = (int) c(i11);
        if (c10 == -1) {
            return -1;
        }
        int read = super.read(bArr, i10, c10);
        d(read);
        return read;
    }
}
