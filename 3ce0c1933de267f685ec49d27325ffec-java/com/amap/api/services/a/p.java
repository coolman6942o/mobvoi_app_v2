package com.amap.api.services.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
public class p implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f7245a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f7246b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f7247c;

    /* renamed from: d  reason: collision with root package name */
    private int f7248d;

    /* renamed from: e  reason: collision with root package name */
    private int f7249e;

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
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, p.this.f7246b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public p(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void h() throws IOException {
        InputStream inputStream = this.f7245a;
        byte[] bArr = this.f7247c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f7248d = 0;
            this.f7249e = read;
            return;
        }
        throw new EOFException();
    }

    public String c() throws IOException {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f7245a) {
            if (this.f7247c != null) {
                if (this.f7248d >= this.f7249e) {
                    h();
                }
                for (int i12 = this.f7248d; i12 != this.f7249e; i12++) {
                    byte[] bArr2 = this.f7247c;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f7248d;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.f7246b.name());
                                this.f7248d = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.f7246b.name());
                        this.f7248d = i12 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f7249e - this.f7248d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f7247c;
                    int i14 = this.f7248d;
                    aVar.write(bArr3, i14, this.f7249e - i14);
                    this.f7249e = -1;
                    h();
                    i10 = this.f7248d;
                    while (i10 != this.f7249e) {
                        bArr = this.f7247c;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f7248d;
                if (i10 != i15) {
                    aVar.write(bArr, i15, i10 - i15);
                }
                this.f7248d = i10 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f7245a) {
            if (this.f7247c != null) {
                this.f7247c = null;
                this.f7245a.close();
            }
        }
    }

    public p(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(q.f7251a)) {
            this.f7245a = inputStream;
            this.f7246b = charset;
            this.f7247c = new byte[i10];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
