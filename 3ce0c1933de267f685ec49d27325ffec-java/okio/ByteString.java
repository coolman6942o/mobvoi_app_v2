package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.h;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import rp.c;
import sp.b;
/* compiled from: ByteString.kt */
/* loaded from: classes3.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final a Companion = new a(null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    /* compiled from: ByteString.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ ByteString h(a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = bArr.length;
            }
            return aVar.g(bArr, i10, i11);
        }

        public final ByteString a(String decodeBase64) {
            i.f(decodeBase64, "$this$decodeBase64");
            byte[] a10 = rp.a.a(decodeBase64);
            if (a10 != null) {
                return new ByteString(a10);
            }
            return null;
        }

        public final ByteString b(String decodeHex) {
            int e10;
            int e11;
            i.f(decodeHex, "$this$decodeHex");
            if (decodeHex.length() % 2 == 0) {
                int length = decodeHex.length() / 2;
                byte[] bArr = new byte[length];
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = i10 * 2;
                    e10 = b.e(decodeHex.charAt(i11));
                    e11 = b.e(decodeHex.charAt(i11 + 1));
                    bArr[i10] = (byte) ((e10 << 4) + e11);
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + decodeHex).toString());
        }

        public final ByteString c(String encode, Charset charset) {
            i.f(encode, "$this$encode");
            i.f(charset, "charset");
            byte[] bytes = encode.getBytes(charset);
            i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString d(String encodeUtf8) {
            i.f(encodeUtf8, "$this$encodeUtf8");
            ByteString byteString = new ByteString(rp.b.a(encodeUtf8));
            byteString.setUtf8$okio(encodeUtf8);
            return byteString;
        }

        public final ByteString e(ByteBuffer toByteString) {
            i.f(toByteString, "$this$toByteString");
            byte[] bArr = new byte[toByteString.remaining()];
            toByteString.get(bArr);
            return new ByteString(bArr);
        }

        public final ByteString f(byte... data) {
            i.f(data, "data");
            byte[] copyOf = Arrays.copyOf(data, data.length);
            i.e(copyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(copyOf);
        }

        public final ByteString g(byte[] toByteString, int i10, int i11) {
            byte[] g10;
            i.f(toByteString, "$this$toByteString");
            c.b(toByteString.length, i10, i11);
            g10 = h.g(toByteString, i10, i11 + i10);
            return new ByteString(g10);
        }

        public final ByteString i(InputStream readByteString, int i10) throws IOException {
            i.f(readByteString, "$this$readByteString");
            int i11 = 0;
            if (i10 >= 0) {
                byte[] bArr = new byte[i10];
                while (i11 < i10) {
                    int read = readByteString.read(bArr, i11, i10 - i11);
                    if (read != -1) {
                        i11 += read;
                    } else {
                        throw new EOFException();
                    }
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i10).toString());
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public ByteString(byte[] data) {
        i.f(data, "data");
        this.data = data;
    }

    public static final ByteString decodeBase64(String str) {
        return Companion.a(str);
    }

    public static final ByteString decodeHex(String str) {
        return Companion.b(str);
    }

    public static final ByteString encodeString(String str, Charset charset) {
        return Companion.c(str, charset);
    }

    public static final ByteString encodeUtf8(String str) {
        return Companion.d(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return byteString.indexOf(byteString2, i10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = 0;
            }
            return byteString.indexOf(bArr, i10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = byteString.size();
            }
            return byteString.lastIndexOf(byteString2, i10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i10, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                i10 = byteString.size();
            }
            return byteString.lastIndexOf(bArr, i10);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static final ByteString of(ByteBuffer byteBuffer) {
        return Companion.e(byteBuffer);
    }

    public static final ByteString of(byte... bArr) {
        return Companion.f(bArr);
    }

    public static final ByteString of(byte[] bArr, int i10, int i11) {
        return Companion.g(bArr, i10, i11);
    }

    public static final ByteString read(InputStream inputStream, int i10) throws IOException {
        return Companion.i(inputStream, i10);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i10, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = byteString.size();
            }
            return byteString.substring(i10, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m39deprecated_getByte(int i10) {
        return getByte(i10);
    }

    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m40deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer asReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        i.e(asReadOnlyBuffer, "ByteBuffer.wrap(data).asReadOnlyBuffer()");
        return asReadOnlyBuffer;
    }

    public String base64() {
        return rp.a.c(getData$okio(), null, 1, null);
    }

    public String base64Url() {
        return rp.a.b(getData$okio(), rp.a.d());
    }

    public ByteString digest$okio(String algorithm) {
        i.f(algorithm, "algorithm");
        byte[] digest = MessageDigest.getInstance(algorithm).digest(this.data);
        i.e(digest, "MessageDigest.getInstance(algorithm).digest(data)");
        return new ByteString(digest);
    }

    public final boolean endsWith(ByteString suffix) {
        i.f(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i10) {
        return internalGet$okio(i10);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    public String hex() {
        byte[] data$okio;
        char[] cArr = new char[getData$okio().length * 2];
        int i10 = 0;
        for (byte b10 : getData$okio()) {
            int i11 = i10 + 1;
            cArr[i10] = b.f()[(b10 >> 4) & 15];
            i10 = i11 + 1;
            cArr[i11] = b.f()[b10 & 15];
        }
        return new String(cArr);
    }

    public ByteString hmac$okio(String algorithm, ByteString key) {
        i.f(algorithm, "algorithm");
        i.f(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] doFinal = mac.doFinal(this.data);
            i.e(doFinal, "mac.doFinal(data)");
            return new ByteString(doFinal);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public ByteString hmacSha1(ByteString key) {
        i.f(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public ByteString hmacSha256(ByteString key) {
        i.f(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public ByteString hmacSha512(ByteString key) {
        i.f(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    public final int indexOf(ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int indexOf(ByteString other, int i10) {
        i.f(other, "other");
        return indexOf(other.internalArray$okio(), i10);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i10) {
        return getData$okio()[i10];
    }

    public final int lastIndexOf(ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    public final int lastIndexOf(ByteString other, int i10) {
        i.f(other, "other");
        return lastIndexOf(other.internalArray$okio(), i10);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i10, ByteString other, int i11, int i12) {
        i.f(other, "other");
        return other.rangeEquals(i11, getData$okio(), i10, i12);
    }

    public final void setHashCode$okio(int i10) {
        this.hashCode = i10;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString prefix) {
        i.f(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public String string(Charset charset) {
        i.f(charset, "charset");
        return new String(this.data, charset);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public final ByteString substring(int i10) {
        return substring$default(this, i10, 0, 2, null);
    }

    public ByteString substring(int i10, int i11) {
        byte[] g10;
        boolean z10 = true;
        if (i10 >= 0) {
            if (i11 <= getData$okio().length) {
                if (i11 - i10 < 0) {
                    z10 = false;
                }
                if (!z10) {
                    throw new IllegalArgumentException("endIndex < beginIndex".toString());
                } else if (i10 == 0 && i11 == getData$okio().length) {
                    return this;
                } else {
                    g10 = h.g(getData$okio(), i10, i11);
                    return new ByteString(g10);
                }
            } else {
                throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
    }

    public ByteString toAsciiLowercase() {
        byte b10;
        for (int i10 = 0; i10 < getData$okio().length; i10++) {
            byte b11 = getData$okio()[i10];
            byte b12 = (byte) 65;
            if (b11 >= b12 && b11 <= (b10 = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                i.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i10] = (byte) (b11 + 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b13 = copyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        copyOf[i11] = (byte) (b13 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        byte b10;
        for (int i10 = 0; i10 < getData$okio().length; i10++) {
            byte b11 = getData$okio()[i10];
            byte b12 = (byte) 97;
            if (b11 >= b12 && b11 <= (b10 = (byte) 122)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                i.e(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i10] = (byte) (b11 - 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b13 = copyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        copyOf[i11] = (byte) (b13 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        i.e(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    public String toString() {
        int c10;
        String z10;
        String z11;
        String z12;
        ByteString byteString;
        byte[] g10;
        boolean z13 = true;
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        c10 = b.c(getData$okio(), 64);
        if (c10 != -1) {
            String utf8 = utf8();
            Objects.requireNonNull(utf8, "null cannot be cast to non-null type java.lang.String");
            String substring = utf8.substring(0, c10);
            i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            z10 = t.z(substring, "\\", "\\\\", false, 4, null);
            z11 = t.z(z10, "\n", "\\n", false, 4, null);
            z12 = t.z(z11, "\r", "\\r", false, 4, null);
            if (c10 < utf8.length()) {
                return "[size=" + getData$okio().length + " text=" + z12 + "…]";
            }
            return "[text=" + z12 + ']';
        } else if (getData$okio().length <= 64) {
            return "[hex=" + hex() + ']';
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[size=");
            sb2.append(getData$okio().length);
            sb2.append(" hex=");
            if (64 > getData$okio().length) {
                z13 = false;
            }
            if (z13) {
                if (64 == getData$okio().length) {
                    byteString = this;
                } else {
                    g10 = h.g(getData$okio(), 0, 64);
                    byteString = new ByteString(g10);
                }
                sb2.append(byteString.hex());
                sb2.append("…]");
                return sb2.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String b10 = rp.b.b(internalArray$okio());
        setUtf8$okio(b10);
        return b10;
    }

    public void write(OutputStream out) throws IOException {
        i.f(out, "out");
        out.write(this.data);
    }

    public void write$okio(c buffer, int i10, int i11) {
        i.f(buffer, "buffer");
        b.d(this, buffer, i10, i11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
        if (r0 < r1) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
        if (r7 < r8) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compareTo(ByteString other) {
        i.f(other, "other");
        int size = size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i10 = 0; i10 < min; i10++) {
            int i11 = getByte(i10) & 255;
            int i12 = other.getByte(i10) & 255;
            if (i11 == i12) {
            }
        }
        if (size == size2) {
            return 0;
        }
    }

    public final boolean endsWith(byte[] suffix) {
        i.f(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public int indexOf(byte[] other, int i10) {
        i.f(other, "other");
        int length = getData$okio().length - other.length;
        int max = Math.max(i10, 0);
        if (max <= length) {
            while (!c.a(getData$okio(), max, other, 0, other.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    public int lastIndexOf(byte[] other, int i10) {
        i.f(other, "other");
        for (int min = Math.min(i10, getData$okio().length - other.length); min >= 0; min--) {
            if (c.a(getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i10, byte[] other, int i11, int i12) {
        i.f(other, "other");
        return i10 >= 0 && i10 <= getData$okio().length - i12 && i11 >= 0 && i11 <= other.length - i12 && c.a(getData$okio(), i10, other, i11, i12);
    }

    public final boolean startsWith(byte[] prefix) {
        i.f(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }
}
