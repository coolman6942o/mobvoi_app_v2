package o4;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
/* compiled from: StrictLineReader.java */
/* loaded from: classes.dex */
class b implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final InputStream f31439a;

    /* renamed from: b  reason: collision with root package name */
    private final Charset f31440b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f31441c;

    /* renamed from: d  reason: collision with root package name */
    private int f31442d;

    /* renamed from: e  reason: collision with root package name */
    private int f31443e;

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
                return new String(((ByteArrayOutputStream) this).buf, 0, i10, b.this.f31440b.name());
            } catch (UnsupportedEncodingException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void d() throws IOException {
        InputStream inputStream = this.f31439a;
        byte[] bArr = this.f31441c;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f31442d = 0;
            this.f31443e = read;
            return;
        }
        throw new EOFException();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f31439a) {
            if (this.f31441c != null) {
                this.f31441c = null;
                this.f31439a.close();
            }
        }
    }

    public boolean h() {
        return this.f31443e == -1;
    }

    public String i() throws IOException {
        int i10;
        byte[] bArr;
        int i11;
        synchronized (this.f31439a) {
            if (this.f31441c != null) {
                if (this.f31442d >= this.f31443e) {
                    d();
                }
                for (int i12 = this.f31442d; i12 != this.f31443e; i12++) {
                    byte[] bArr2 = this.f31441c;
                    if (bArr2[i12] == 10) {
                        int i13 = this.f31442d;
                        if (i12 != i13) {
                            i11 = i12 - 1;
                            if (bArr2[i11] == 13) {
                                String str = new String(bArr2, i13, i11 - i13, this.f31440b.name());
                                this.f31442d = i12 + 1;
                                return str;
                            }
                        }
                        i11 = i12;
                        String str2 = new String(bArr2, i13, i11 - i13, this.f31440b.name());
                        this.f31442d = i12 + 1;
                        return str2;
                    }
                }
                a aVar = new a((this.f31443e - this.f31442d) + 80);
                loop1: while (true) {
                    byte[] bArr3 = this.f31441c;
                    int i14 = this.f31442d;
                    aVar.write(bArr3, i14, this.f31443e - i14);
                    this.f31443e = -1;
                    d();
                    i10 = this.f31442d;
                    while (i10 != this.f31443e) {
                        bArr = this.f31441c;
                        if (bArr[i10] == 10) {
                            break loop1;
                        }
                        i10++;
                    }
                }
                int i15 = this.f31442d;
                if (i10 != i15) {
                    aVar.write(bArr, i15, i10 - i15);
                }
                this.f31442d = i10 + 1;
                return aVar.toString();
            }
            throw new IOException("LineReader is closed");
        }
    }

    public b(InputStream inputStream, int i10, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        } else if (i10 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(c.f31445a)) {
            this.f31439a = inputStream;
            this.f31440b = charset;
            this.f31441c = new byte[i10];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }
}
