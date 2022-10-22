package com.bumptech.glide.load.resource.bitmap;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import u4.b;
/* compiled from: RecyclableBufferedInputStream.java */
/* loaded from: classes.dex */
public class l extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private volatile byte[] f8104a;

    /* renamed from: b  reason: collision with root package name */
    private int f8105b;

    /* renamed from: c  reason: collision with root package name */
    private int f8106c;

    /* renamed from: d  reason: collision with root package name */
    private int f8107d;

    /* renamed from: e  reason: collision with root package name */
    private int f8108e;

    /* renamed from: f  reason: collision with root package name */
    private final b f8109f;

    /* compiled from: RecyclableBufferedInputStream.java */
    /* loaded from: classes.dex */
    static class a extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        a(String str) {
            super(str);
        }
    }

    public l(InputStream inputStream, b bVar) {
        this(inputStream, bVar, WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    private int c(InputStream inputStream, byte[] bArr) throws IOException {
        int i10 = this.f8107d;
        if (i10 != -1) {
            int i11 = this.f8108e - i10;
            int i12 = this.f8106c;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.f8105b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f8109f.e(i12, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f8104a = bArr2;
                    this.f8109f.d(bArr);
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy(bArr, i10, bArr, 0, bArr.length - i10);
                }
                int i13 = this.f8108e - this.f8107d;
                this.f8108e = i13;
                this.f8107d = 0;
                this.f8105b = 0;
                int read = inputStream.read(bArr, i13, bArr.length - i13);
                int i14 = this.f8108e;
                if (read > 0) {
                    i14 += read;
                }
                this.f8105b = i14;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f8107d = -1;
            this.f8108e = 0;
            this.f8105b = read2;
        }
        return read2;
    }

    private static IOException i() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f8104a == null || inputStream == null) {
            throw i();
        }
        return (this.f8105b - this.f8108e) + inputStream.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f8104a != null) {
            this.f8109f.d(this.f8104a);
            this.f8104a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void d() {
        this.f8106c = this.f8104a.length;
    }

    public synchronized void h() {
        if (this.f8104a != null) {
            this.f8109f.d(this.f8104a);
            this.f8104a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.f8106c = Math.max(this.f8106c, i10);
        this.f8107d = this.f8108e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f8104a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw i();
        } else if (this.f8108e >= this.f8105b && c(inputStream, bArr) == -1) {
            return -1;
        } else {
            if (bArr != this.f8104a && (bArr = this.f8104a) == null) {
                throw i();
            }
            int i10 = this.f8105b;
            int i11 = this.f8108e;
            if (i10 - i11 <= 0) {
                return -1;
            }
            this.f8108e = i11 + 1;
            return bArr[i11] & 255;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f8104a != null) {
            int i10 = this.f8107d;
            if (-1 != i10) {
                this.f8108e = i10;
            } else {
                throw new a("Mark has been invalidated, pos: " + this.f8108e + " markLimit: " + this.f8106c);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) throws IOException {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.f8104a;
        if (bArr != null) {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i10 = this.f8105b;
                int i11 = this.f8108e;
                if (i10 - i11 >= j10) {
                    this.f8108e = (int) (i11 + j10);
                    return j10;
                }
                long j11 = i10 - i11;
                this.f8108e = i10;
                if (this.f8107d == -1 || j10 > this.f8106c) {
                    return j11 + inputStream.skip(j10 - j11);
                } else if (c(inputStream, bArr) == -1) {
                    return j11;
                } else {
                    int i12 = this.f8105b;
                    int i13 = this.f8108e;
                    if (i12 - i13 >= j10 - j11) {
                        this.f8108e = (int) ((i13 + j10) - j11);
                        return j10;
                    }
                    long j12 = (j11 + i12) - i13;
                    this.f8108e = i12;
                    return j12;
                }
            } else {
                throw i();
            }
        } else {
            throw i();
        }
    }

    l(InputStream inputStream, b bVar, int i10) {
        super(inputStream);
        this.f8107d = -1;
        this.f8109f = bVar;
        this.f8104a = (byte[]) bVar.e(i10, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13;
        byte[] bArr2 = this.f8104a;
        if (bArr2 == null) {
            throw i();
        } else if (i11 == 0) {
            return 0;
        } else {
            InputStream inputStream = ((FilterInputStream) this).in;
            if (inputStream != null) {
                int i14 = this.f8108e;
                int i15 = this.f8105b;
                if (i14 < i15) {
                    int i16 = i15 - i14 >= i11 ? i11 : i15 - i14;
                    System.arraycopy(bArr2, i14, bArr, i10, i16);
                    this.f8108e += i16;
                    if (i16 == i11 || inputStream.available() == 0) {
                        return i16;
                    }
                    i10 += i16;
                    i12 = i11 - i16;
                } else {
                    i12 = i11;
                }
                while (true) {
                    int i17 = -1;
                    if (this.f8107d == -1 && i12 >= bArr2.length) {
                        i13 = inputStream.read(bArr, i10, i12);
                        if (i13 == -1) {
                            if (i12 != i11) {
                                i17 = i11 - i12;
                            }
                            return i17;
                        }
                    } else if (c(inputStream, bArr2) == -1) {
                        if (i12 != i11) {
                            i17 = i11 - i12;
                        }
                        return i17;
                    } else {
                        if (bArr2 != this.f8104a && (bArr2 = this.f8104a) == null) {
                            throw i();
                        }
                        int i18 = this.f8105b;
                        int i19 = this.f8108e;
                        i13 = i18 - i19 >= i12 ? i12 : i18 - i19;
                        System.arraycopy(bArr2, i19, bArr, i10, i13);
                        this.f8108e += i13;
                    }
                    i12 -= i13;
                    if (i12 == 0) {
                        return i11;
                    }
                    if (inputStream.available() == 0) {
                        return i11 - i12;
                    }
                    i10 += i13;
                }
            } else {
                throw i();
            }
        }
    }
}
