package com.amap.api.mapcore2d;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
public class q implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f7041a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f7042b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f7043c;

    /* renamed from: d  reason: collision with root package name */
    private int f7044d;

    /* renamed from: e  reason: collision with root package name */
    private int f7045e;

    /* compiled from: StrictLineReader.java */
    /* loaded from: classes.dex */
    class a extends ByteArrayOutputStream {
        a(int i10) {
            super(i10);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i10 = ((ByteArrayOutputStream) this).count;
            if (i10 > 0 && ((ByteArrayOutputStream) this).buf[i10 - 1] == 13) {
                i10--;
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, q.this.f7042b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public q(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void h() throws IOException {
        InputStream inputStream = this.f7041a;
        byte[] bArr = this.f7043c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f7044d = 0;
            this.f7045e = read;
            return;
        }
        throw new EOFException();
    }

    public String c() throws IOException {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f7041a) {
            if (this.f7043c != null) {
                if (this.f7044d >= this.f7045e) {
                    h();
                }
                for (int i12 = this.f7044d; i12 != this.f7045e; i12++) {
                    byte[] bArr2 = this.f7043c;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f7044d;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.f7042b.name());
                                this.f7044d = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.f7042b.name());
                        this.f7044d = i12 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f7045e - this.f7044d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f7043c;
                    int i14 = this.f7044d;
                    aVar.write(bArr3, i14, this.f7045e - i14);
                    this.f7045e = -1;
                    h();
                    i10 = this.f7044d;
                    while (i10 != this.f7045e) {
                        bArr = this.f7043c;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f7044d;
                if (i10 != i15) {
                    aVar.write(bArr, i15, i10 - i15);
                }
                this.f7044d = i10 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f7041a) {
            if (this.f7043c != null) {
                this.f7043c = null;
                this.f7041a.close();
            }
        }
    }

    public q(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(r.f7047a)) {
            this.f7041a = inputStream;
            this.f7042b = charset;
            this.f7043c = new byte[i10];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
