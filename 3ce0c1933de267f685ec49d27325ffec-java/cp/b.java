package cp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;
/* compiled from: HexInputStream.java */
/* loaded from: classes3.dex */
public class b extends FilterInputStream {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f24699a;

    /* renamed from: c  reason: collision with root package name */
    private int f24701c;

    /* renamed from: d  reason: collision with root package name */
    private int f24702d;

    /* renamed from: f  reason: collision with root package name */
    private int f24704f;

    /* renamed from: g  reason: collision with root package name */
    private int f24705g;

    /* renamed from: h  reason: collision with root package name */
    private final int f24706h;

    /* renamed from: b  reason: collision with root package name */
    private int f24700b = 128;

    /* renamed from: e  reason: collision with root package name */
    private int f24703e = 0;

    public b(InputStream inputStream, int i10) throws HexFileValidationException, IOException {
        super(new BufferedInputStream(inputStream));
        byte[] bArr = new byte[128];
        this.f24699a = bArr;
        this.f24702d = bArr.length;
        this.f24706h = i10;
        this.f24704f = d(i10);
    }

    private int c(int i10) {
        if (i10 >= 65) {
            return i10 - 55;
        }
        if (i10 >= 48) {
            return i10 - 48;
        }
        return -1;
    }

    private int d(int i10) throws IOException {
        int i11;
        InputStream inputStream = ((FilterInputStream) this).in;
        inputStream.mark(inputStream.available());
        try {
            int read = inputStream.read();
            int i12 = 0;
            int i13 = 0;
            while (true) {
                h(read);
                int n10 = n(inputStream);
                int i14 = i(inputStream);
                int n11 = n(inputStream);
                if (n11 != 0) {
                    if (n11 == 1) {
                        return i13;
                    }
                    if (n11 == 2) {
                        i11 = i(inputStream) << 4;
                        if (i13 > 0 && (i11 >> 16) != (i12 >> 16) + 1) {
                            return i13;
                        }
                        u(inputStream, 2L);
                    } else if (n11 == 4) {
                        int i15 = i(inputStream);
                        if (i13 > 0 && i15 != (i12 >> 16) + 1) {
                            return i13;
                        }
                        i11 = i15 << 16;
                        u(inputStream, 2L);
                    }
                    i12 = i11;
                    while (true) {
                        read = inputStream.read();
                        if (read != 10 || read == 13) {
                        }
                    }
                } else if (i14 + i12 >= i10) {
                    i13 += n10;
                }
                u(inputStream, (n10 * 2) + 2);
                while (true) {
                    read = inputStream.read();
                    if (read != 10) {
                    }
                }
            }
        } finally {
            inputStream.reset();
        }
    }

    private void h(int i10) throws HexFileValidationException {
        if (i10 != 58) {
            throw new HexFileValidationException("Not a HEX file");
        }
    }

    private int i(InputStream inputStream) throws IOException {
        return n(inputStream) | (n(inputStream) << 8);
    }

    private int n(InputStream inputStream) throws IOException {
        return c(inputStream.read()) | (c(inputStream.read()) << 4);
    }

    private int o() throws IOException {
        if (this.f24701c == -1) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        while (true) {
            int read = inputStream.read();
            this.f24701c++;
            if (!(read == 10 || read == 13)) {
                h(read);
                int n10 = n(inputStream);
                this.f24701c += 2;
                int i10 = i(inputStream);
                this.f24701c += 4;
                int n11 = n(inputStream);
                int i11 = this.f24701c + 2;
                this.f24701c = i11;
                if (n11 != 0) {
                    if (n11 == 1) {
                        this.f24701c = -1;
                        return 0;
                    } else if (n11 == 2) {
                        int i12 = i(inputStream) << 4;
                        int i13 = this.f24701c + 4;
                        this.f24701c = i13;
                        if (this.f24705g > 0 && (i12 >> 16) != (this.f24703e >> 16) + 1) {
                            return 0;
                        }
                        this.f24703e = i12;
                        this.f24701c = (int) (i13 + u(inputStream, 2L));
                    } else if (n11 != 4) {
                        this.f24701c = (int) (i11 + u(inputStream, (n10 * 2) + 2));
                    } else {
                        int i14 = i(inputStream);
                        int i15 = this.f24701c + 4;
                        this.f24701c = i15;
                        if (this.f24705g > 0 && i14 != (this.f24703e >> 16) + 1) {
                            return 0;
                        }
                        this.f24703e = i14 << 16;
                        this.f24701c = (int) (i15 + u(inputStream, 2L));
                    }
                } else if (this.f24703e + i10 < this.f24706h) {
                    this.f24701c = (int) (i11 + u(inputStream, (n10 * 2) + 2));
                    n11 = -1;
                }
                if (n11 == 0) {
                    for (int i16 = 0; i16 < this.f24699a.length && i16 < n10; i16++) {
                        int n12 = n(inputStream);
                        this.f24701c += 2;
                        this.f24699a[i16] = (byte) n12;
                    }
                    this.f24701c = (int) (this.f24701c + u(inputStream, 2L));
                    this.f24700b = 0;
                    return n10;
                }
            }
        }
    }

    private long u(InputStream inputStream, long j10) throws IOException {
        long skip = inputStream.skip(j10);
        return skip < j10 ? skip + inputStream.skip(j10 - skip) : skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        return this.f24704f - this.f24705g;
    }

    public int q(byte[] bArr) throws IOException {
        int i10 = 0;
        while (i10 < bArr.length) {
            int i11 = this.f24700b;
            if (i11 < this.f24702d) {
                i10++;
                byte[] bArr2 = this.f24699a;
                this.f24700b = i11 + 1;
                bArr[i10] = bArr2[i11];
            } else {
                int i12 = this.f24705g;
                int o10 = o();
                this.f24702d = o10;
                this.f24705g = i12 + o10;
                if (o10 == 0) {
                    break;
                }
            }
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f24701c = 0;
        this.f24705g = 0;
        this.f24700b = 128;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return q(bArr);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        throw new UnsupportedOperationException("Please, use readPacket() method instead");
    }

    public b(byte[] bArr, int i10) throws HexFileValidationException, IOException {
        super(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[128];
        this.f24699a = bArr2;
        this.f24702d = bArr2.length;
        this.f24706h = i10;
        this.f24704f = d(i10);
    }
}
