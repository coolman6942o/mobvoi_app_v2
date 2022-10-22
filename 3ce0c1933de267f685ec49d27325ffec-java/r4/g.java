package r4;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: ExifOrientationStream.java */
/* loaded from: classes.dex */
public final class g extends FilterInputStream {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f33413c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f33414d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f33415e;

    /* renamed from: a  reason: collision with root package name */
    private final byte f33416a;

    /* renamed from: b  reason: collision with root package name */
    private int f33417b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f33413c = bArr;
        int length = bArr.length;
        f33414d = length;
        f33415e = length + 2;
    }

    public g(InputStream inputStream, int i10) {
        super(inputStream);
        if (i10 < -1 || i10 > 8) {
            throw new IllegalArgumentException("Cannot add invalid orientation: " + i10);
        }
        this.f33416a = (byte) i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10;
        int i11;
        int i12 = this.f33417b;
        if (i12 < 2 || i12 > (i11 = f33415e)) {
            i10 = super.read();
        } else if (i12 == i11) {
            i10 = this.f33416a;
        } else {
            i10 = f33413c[i12 - 2] & 255;
        }
        if (i10 != -1) {
            this.f33417b++;
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long skip = super.skip(j10);
        if (skip > 0) {
            this.f33417b = (int) (this.f33417b + skip);
        }
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.f33417b;
        int i14 = f33415e;
        if (i13 > i14) {
            i12 = super.read(bArr, i10, i11);
        } else if (i13 == i14) {
            bArr[i10] = this.f33416a;
            i12 = 1;
        } else if (i13 < 2) {
            i12 = super.read(bArr, i10, 2 - i13);
        } else {
            int min = Math.min(i14 - i13, i11);
            System.arraycopy(f33413c, this.f33417b - 2, bArr, i10, min);
            i12 = min;
        }
        if (i12 > 0) {
            this.f33417b += i12;
        }
        return i12;
    }
}
