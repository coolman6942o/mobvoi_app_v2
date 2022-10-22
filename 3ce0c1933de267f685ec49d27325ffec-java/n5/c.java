package n5;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: ContentLengthInputStream.java */
/* loaded from: classes.dex */
public final class c extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final long f31029a;

    /* renamed from: b  reason: collision with root package name */
    private int f31030b;

    private c(InputStream inputStream, long j10) {
        super(inputStream);
        this.f31029a = j10;
    }

    private int c(int i10) throws IOException {
        if (i10 >= 0) {
            this.f31030b += i10;
        } else if (this.f31029a - this.f31030b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f31029a + ", but read: " + this.f31030b);
        }
        return i10;
    }

    public static InputStream d(InputStream inputStream, long j10) {
        return new c(inputStream, j10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f31029a - this.f31030b, ((FilterInputStream) this).in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        c(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) throws IOException {
        return c(super.read(bArr, i10, i11));
    }
}
