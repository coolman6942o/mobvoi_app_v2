package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.e;
import kotlin.collections.h;
import kotlin.jvm.internal.i;
import rp.c;
import rp.g;
/* compiled from: SegmentedByteString.kt */
/* loaded from: classes3.dex */
public final class SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.EMPTY.getData$okio());
        i.f(segments, "segments");
        i.f(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    private final ByteString a() {
        return new ByteString(toByteArray());
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        i.e(asReadOnlyBuffer, "ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    @Override // okio.ByteString
    public String base64() {
        return a().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return a().base64Url();
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String algorithm) {
        i.f(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = getDirectory$okio()[length + i10];
            int i13 = getDirectory$okio()[i10];
            messageDigest.update(getSegments$okio()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] digest = messageDigest.digest();
        i.e(digest, "digest.digest()");
        return new ByteString(digest);
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory$okio()[length + i10];
            int i14 = getDirectory$okio()[i10];
            byte[] bArr = getSegments$okio()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        setHashCode$okio(i11);
        return i11;
    }

    @Override // okio.ByteString
    public String hex() {
        return a().hex();
    }

    @Override // okio.ByteString
    public ByteString hmac$okio(String algorithm, ByteString key) {
        i.f(algorithm, "algorithm");
        i.f(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int length = getSegments$okio().length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = getDirectory$okio()[length + i10];
                int i13 = getDirectory$okio()[i10];
                mac.update(getSegments$okio()[i10], i12, i13 - i11);
                i10++;
                i11 = i13;
            }
            byte[] doFinal = mac.doFinal();
            i.e(doFinal, "mac.doFinal()");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @Override // okio.ByteString
    public int indexOf(byte[] other, int i10) {
        i.f(other, "other");
        return a().indexOf(other, i10);
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i10) {
        c.b(getDirectory$okio()[getSegments$okio().length - 1], i10, 1L);
        int b10 = sp.c.b(this, i10);
        return getSegments$okio()[b10][(i10 - (b10 == 0 ? 0 : getDirectory$okio()[b10 - 1])) + getDirectory$okio()[getSegments$okio().length + b10]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] other, int i10) {
        i.f(other, "other");
        return a().lastIndexOf(other, i10);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i10, ByteString other, int i11, int i12) {
        i.f(other, "other");
        if (i10 < 0 || i10 > size() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int b10 = sp.c.b(this, i10);
        while (i10 < i13) {
            int i14 = b10 == 0 ? 0 : getDirectory$okio()[b10 - 1];
            int i15 = getDirectory$okio()[getSegments$okio().length + b10];
            int min = Math.min(i13, (getDirectory$okio()[b10] - i14) + i14) - i10;
            if (!other.rangeEquals(i11, getSegments$okio()[b10], i15 + (i10 - i14), min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            b10++;
        }
        return true;
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        i.f(charset, "charset");
        return a().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i10, int i11) {
        int i12 = 0;
        if (i10 >= 0) {
            if (i11 <= size()) {
                int i13 = i11 - i10;
                if (!(i13 >= 0)) {
                    throw new IllegalArgumentException(("endIndex=" + i11 + " < beginIndex=" + i10).toString());
                } else if (i10 == 0 && i11 == size()) {
                    return this;
                } else {
                    if (i10 == i11) {
                        return ByteString.EMPTY;
                    }
                    int b10 = sp.c.b(this, i10);
                    int b11 = sp.c.b(this, i11 - 1);
                    byte[][] bArr = (byte[][]) e.h(getSegments$okio(), b10, b11 + 1);
                    int[] iArr = new int[bArr.length * 2];
                    if (b10 <= b11) {
                        int i14 = 0;
                        int i15 = b10;
                        while (true) {
                            iArr[i14] = Math.min(getDirectory$okio()[i15] - i10, i13);
                            i14++;
                            iArr[i14 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i15];
                            if (i15 == b11) {
                                break;
                            }
                            i15++;
                        }
                    }
                    if (b10 != 0) {
                        i12 = getDirectory$okio()[b10 - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = iArr[length] + (i10 - i12);
                    return new SegmentedByteString(bArr, iArr);
                }
            } else {
                throw new IllegalArgumentException(("endIndex=" + i11 + " > length(" + size() + ')').toString());
            }
        } else {
            throw new IllegalArgumentException(("beginIndex=" + i10 + " < 0").toString());
        }
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return a().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return a().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = getDirectory$okio()[length + i10];
            int i14 = getDirectory$okio()[i10];
            int i15 = i14 - i11;
            h.c(getSegments$okio()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return a().toString();
    }

    @Override // okio.ByteString
    public void write(OutputStream out) throws IOException {
        i.f(out, "out");
        int length = getSegments$okio().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = getDirectory$okio()[length + i10];
            int i13 = getDirectory$okio()[i10];
            out.write(getSegments$okio()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
    }

    @Override // okio.ByteString
    public void write$okio(c buffer, int i10, int i11) {
        i.f(buffer, "buffer");
        int i12 = i11 + i10;
        int b10 = sp.c.b(this, i10);
        while (i10 < i12) {
            int i13 = b10 == 0 ? 0 : getDirectory$okio()[b10 - 1];
            int i14 = getDirectory$okio()[getSegments$okio().length + b10];
            int min = Math.min(i12, (getDirectory$okio()[b10] - i13) + i13) - i10;
            int i15 = i14 + (i10 - i13);
            g gVar = new g(getSegments$okio()[b10], i15, i15 + min, true, false);
            g gVar2 = buffer.f32393a;
            if (gVar2 == null) {
                gVar.f33669g = gVar;
                gVar.f33668f = gVar;
                buffer.f32393a = gVar;
            } else {
                i.d(gVar2);
                g gVar3 = gVar2.f33669g;
                i.d(gVar3);
                gVar3.c(gVar);
            }
            i10 += min;
            b10++;
        }
        buffer.h0(buffer.i0() + size());
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i10, byte[] other, int i11, int i12) {
        i.f(other, "other");
        if (i10 < 0 || i10 > size() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int b10 = sp.c.b(this, i10);
        while (i10 < i13) {
            int i14 = b10 == 0 ? 0 : getDirectory$okio()[b10 - 1];
            int i15 = getDirectory$okio()[getSegments$okio().length + b10];
            int min = Math.min(i13, (getDirectory$okio()[b10] - i14) + i14) - i10;
            if (!c.a(getSegments$okio()[b10], i15 + (i10 - i14), other, i11, min)) {
                return false;
            }
            i11 += min;
            i10 += min;
            b10++;
        }
        return true;
    }
}
