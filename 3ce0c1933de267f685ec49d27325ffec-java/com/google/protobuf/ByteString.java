package com.google.protobuf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int CONCATENATE_BY_COPY_SIZE = 128;
    public static final ByteString EMPTY = new h(u.f13366c);
    static final int MAX_READ_FROM_CHUNK_SIZE = 8192;
    static final int MIN_READ_FROM_CHUNK_SIZE = 256;
    private static final d byteArrayCopier;
    private int hash = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements e {

        /* renamed from: a  reason: collision with root package name */
        private int f12699a = 0;

        /* renamed from: b  reason: collision with root package name */
        private final int f12700b;

        a() {
            this.f12700b = ByteString.this.size();
        }

        /* renamed from: a */
        public Byte next() {
            return Byte.valueOf(b());
        }

        public byte b() {
            try {
                ByteString byteString = ByteString.this;
                int i10 = this.f12699a;
                this.f12699a = i10 + 1;
                return byteString.byteAt(i10);
            } catch (IndexOutOfBoundsException e10) {
                throw new NoSuchElementException(e10.getMessage());
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12699a < this.f12700b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    private static final class b implements d {
        private b() {
        }

        @Override // com.google.protobuf.ByteString.d
        public byte[] a(byte[] bArr, int i10, int i11) {
            return Arrays.copyOfRange(bArr, i10, i11 + i10);
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends h {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        c(byte[] bArr, int i10, int i11) {
            super(bArr);
            ByteString.c(i10, i10 + i11, bArr.length);
            this.bytesOffset = i10;
            this.bytesLength = i11;
        }

        @Override // com.google.protobuf.ByteString.h, com.google.protobuf.ByteString
        public byte byteAt(int i10) {
            ByteString.b(i10, size());
            return this.bytes[this.bytesOffset + i10];
        }

        @Override // com.google.protobuf.ByteString.h, com.google.protobuf.ByteString
        protected void d(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.bytes, s() + i10, bArr, i11, i12);
        }

        @Override // com.google.protobuf.ByteString.h
        protected int s() {
            return this.bytesOffset;
        }

        @Override // com.google.protobuf.ByteString.h, com.google.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        byte[] a(byte[] bArr, int i10, int i11);
    }

    /* loaded from: classes.dex */
    public interface e extends Iterator<Byte> {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        private final CodedOutputStream f12702a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f12703b;

        /* synthetic */ f(int i10, a aVar) {
            this(i10);
        }

        public ByteString a() {
            this.f12702a.d();
            return new h(this.f12703b);
        }

        public CodedOutputStream b() {
            return this.f12702a;
        }

        private f(int i10) {
            byte[] bArr = new byte[i10];
            this.f12703b = bArr;
            this.f12702a = CodedOutputStream.a0(bArr);
        }
    }

    /* loaded from: classes.dex */
    static abstract class g extends ByteString {
        g() {
        }

        @Override // com.google.protobuf.ByteString
        protected final int g() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        protected final boolean h() {
            return true;
        }

        @Override // com.google.protobuf.ByteString, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return ByteString.super.iterator2();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract boolean r(ByteString byteString, int i10, int i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends g {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        h(byte[] bArr) {
            this.bytes = bArr;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteBuffer asReadOnlyByteBuffer() {
            return ByteBuffer.wrap(this.bytes, s(), size()).asReadOnlyBuffer();
        }

        @Override // com.google.protobuf.ByteString
        public final List<ByteBuffer> asReadOnlyByteBufferList() {
            return Collections.singletonList(asReadOnlyByteBuffer());
        }

        @Override // com.google.protobuf.ByteString
        public byte byteAt(int i10) {
            return this.bytes[i10];
        }

        @Override // com.google.protobuf.ByteString
        public final void copyTo(ByteBuffer byteBuffer) {
            byteBuffer.put(this.bytes, s(), size());
        }

        @Override // com.google.protobuf.ByteString
        protected void d(byte[] bArr, int i10, int i11, int i12) {
            System.arraycopy(this.bytes, i10, bArr, i11, i12);
        }

        @Override // com.google.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof h)) {
                return obj.equals(this);
            }
            h hVar = (h) obj;
            int l10 = l();
            int l11 = hVar.l();
            if (l10 == 0 || l11 == 0 || l10 == l11) {
                return r(hVar, 0, size());
            }
            return false;
        }

        @Override // com.google.protobuf.ByteString
        public final boolean isValidUtf8() {
            int s10 = s();
            return d1.m(this.bytes, s10, size() + s10);
        }

        @Override // com.google.protobuf.ByteString
        protected final int j(int i10, int i11, int i12) {
            return u.j(i10, this.bytes, s() + i11, i12);
        }

        @Override // com.google.protobuf.ByteString
        protected final int k(int i10, int i11, int i12) {
            int s10 = s() + i11;
            return d1.n(i10, this.bytes, s10, i12 + s10);
        }

        @Override // com.google.protobuf.ByteString
        protected final String n(Charset charset) {
            return new String(this.bytes, s(), size(), charset);
        }

        @Override // com.google.protobuf.ByteString
        public final com.google.protobuf.i newCodedInput() {
            return com.google.protobuf.i.i(this.bytes, s(), size(), true);
        }

        @Override // com.google.protobuf.ByteString
        public final InputStream newInput() {
            return new ByteArrayInputStream(this.bytes, s(), size());
        }

        @Override // com.google.protobuf.ByteString
        final void q(com.google.protobuf.h hVar) throws IOException {
            hVar.a(this.bytes, s(), size());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.protobuf.ByteString.g
        public final boolean r(ByteString byteString, int i10, int i11) {
            if (i11 <= byteString.size()) {
                int i12 = i10 + i11;
                if (i12 > byteString.size()) {
                    throw new IllegalArgumentException("Ran off end of other: " + i10 + ", " + i11 + ", " + byteString.size());
                } else if (!(byteString instanceof h)) {
                    return byteString.substring(i10, i12).equals(substring(0, i11));
                } else {
                    h hVar = (h) byteString;
                    byte[] bArr = this.bytes;
                    byte[] bArr2 = hVar.bytes;
                    int s10 = s() + i11;
                    int s11 = s();
                    int s12 = hVar.s() + i10;
                    while (s11 < s10) {
                        if (bArr[s11] != bArr2[s12]) {
                            return false;
                        }
                        s11++;
                        s12++;
                    }
                    return true;
                }
            } else {
                throw new IllegalArgumentException("Length too large: " + i11 + size());
            }
        }

        protected int s() {
            return 0;
        }

        @Override // com.google.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // com.google.protobuf.ByteString
        public final ByteString substring(int i10, int i11) {
            int c10 = ByteString.c(i10, i11, size());
            if (c10 == 0) {
                return ByteString.EMPTY;
            }
            return new c(this.bytes, s() + i10, c10);
        }

        @Override // com.google.protobuf.ByteString
        public final void writeTo(OutputStream outputStream) throws IOException {
            outputStream.write(toByteArray());
        }
    }

    /* loaded from: classes.dex */
    private static final class j implements d {
        private j() {
        }

        @Override // com.google.protobuf.ByteString.d
        public byte[] a(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, i10, bArr2, 0, i11);
            return bArr2;
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    static {
        boolean z10 = true;
        try {
            Class.forName("android.content.Context");
        } catch (ClassNotFoundException unused) {
            z10 = false;
        }
        byteArrayCopier = z10 ? new j(null) : new b(null);
    }

    private static ByteString a(Iterator<ByteString> it, int i10) {
        if (i10 == 1) {
            return it.next();
        }
        int i11 = i10 >>> 1;
        return a(it, i11).concat(a(it, i10 - i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i10, int i11) {
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return;
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i10);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i10 + ", " + i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i10, int i11, int i12) {
        int i13 = i11 - i10;
        if ((i10 | i11 | i13 | (i12 - i11)) >= 0) {
            return i13;
        }
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i10 + " < 0");
        } else if (i11 < i10) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i10 + ", " + i11);
        } else {
            throw new IndexOutOfBoundsException("End index: " + i11 + " >= " + i12);
        }
    }

    public static ByteString copyFrom(byte[] bArr, int i10, int i11) {
        return new h(byteArrayCopier.a(bArr, i10, i11));
    }

    public static ByteString copyFromUtf8(String str) {
        return new h(str.getBytes(u.f13364a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f i(int i10) {
        return new f(i10, null);
    }

    private static ByteString m(InputStream inputStream, int i10) throws IOException {
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int read = inputStream.read(bArr, i11, i10 - i11);
            if (read == -1) {
                break;
            }
            i11 += read;
        }
        if (i11 == 0) {
            return null;
        }
        return copyFrom(bArr, 0, i11);
    }

    public static i newOutput(int i10) {
        return new i(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString o(byte[] bArr) {
        return new h(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString p(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    public static ByteString readFrom(InputStream inputStream) throws IOException {
        return readFrom(inputStream, 256, 8192);
    }

    public abstract ByteBuffer asReadOnlyByteBuffer();

    public abstract List<ByteBuffer> asReadOnlyByteBufferList();

    public abstract byte byteAt(int i10);

    public final ByteString concat(ByteString byteString) {
        if (Integer.MAX_VALUE - size() >= byteString.size()) {
            return p0.u(this, byteString);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + size() + "+" + byteString.size());
    }

    public abstract void copyTo(ByteBuffer byteBuffer);

    public void copyTo(byte[] bArr, int i10) {
        copyTo(bArr, 0, i10, size());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void d(byte[] bArr, int i10, int i11, int i12);

    public final boolean endsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(size() - byteString.size()).equals(byteString);
    }

    public abstract boolean equals(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int g();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean h();

    public final int hashCode() {
        int i10 = this.hash;
        if (i10 == 0) {
            int size = size();
            i10 = j(size, 0, size);
            if (i10 == 0) {
                i10 = 1;
            }
            this.hash = i10;
        }
        return i10;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int j(int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int k(int i10, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: protected */
    public final int l() {
        return this.hash;
    }

    protected abstract String n(Charset charset);

    public abstract com.google.protobuf.i newCodedInput();

    public abstract InputStream newInput();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void q(com.google.protobuf.h hVar) throws IOException;

    public abstract int size();

    public final boolean startsWith(ByteString byteString) {
        return size() >= byteString.size() && substring(0, byteString.size()).equals(byteString);
    }

    public final ByteString substring(int i10) {
        return substring(i10, size());
    }

    public abstract ByteString substring(int i10, int i11);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return u.f13366c;
        }
        byte[] bArr = new byte[size];
        d(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString(String str) throws UnsupportedEncodingException {
        try {
            return toString(Charset.forName(str));
        } catch (UnsupportedCharsetException e10) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str);
            unsupportedEncodingException.initCause(e10);
            throw unsupportedEncodingException;
        }
    }

    public final String toStringUtf8() {
        return toString(u.f13364a);
    }

    public abstract void writeTo(OutputStream outputStream) throws IOException;

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static i newOutput() {
        return new i(CONCATENATE_BY_COPY_SIZE);
    }

    public static ByteString readFrom(InputStream inputStream, int i10) throws IOException {
        return readFrom(inputStream, i10, i10);
    }

    public final void copyTo(byte[] bArr, int i10, int i11, int i12) {
        c(i10, i10 + i12, size());
        c(i11, i11 + i12, bArr.length);
        if (i12 > 0) {
            d(bArr, i10, i11, i12);
        }
    }

    @Override // java.lang.Iterable
    /* renamed from: iterator */
    public final Iterator<Byte> iterator2() {
        return new a();
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer, int i10) {
        byte[] bArr = new byte[i10];
        byteBuffer.get(bArr);
        return new h(bArr);
    }

    public static ByteString readFrom(InputStream inputStream, int i10, int i11) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            ByteString m10 = m(inputStream, i10);
            if (m10 == null) {
                return copyFrom(arrayList);
            }
            arrayList.add(m10);
            i10 = Math.min(i10 * 2, i11);
        }
    }

    /* loaded from: classes.dex */
    public static final class i extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final int f12704a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<ByteString> f12705b;

        /* renamed from: c  reason: collision with root package name */
        private int f12706c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f12707d;

        /* renamed from: e  reason: collision with root package name */
        private int f12708e;

        i(int i10) {
            if (i10 >= 0) {
                this.f12704a = i10;
                this.f12705b = new ArrayList<>();
                this.f12707d = new byte[i10];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private void c(int i10) {
            this.f12705b.add(new h(this.f12707d));
            int length = this.f12706c + this.f12707d.length;
            this.f12706c = length;
            this.f12707d = new byte[Math.max(this.f12704a, Math.max(i10, length >>> 1))];
            this.f12708e = 0;
        }

        public synchronized int d() {
            return this.f12706c + this.f12708e;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(d()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i10) {
            if (this.f12708e == this.f12707d.length) {
                c(1);
            }
            byte[] bArr = this.f12707d;
            int i11 = this.f12708e;
            this.f12708e = i11 + 1;
            bArr[i11] = (byte) i10;
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i10, int i11) {
            byte[] bArr2 = this.f12707d;
            int length = bArr2.length;
            int i12 = this.f12708e;
            if (i11 <= length - i12) {
                System.arraycopy(bArr, i10, bArr2, i12, i11);
                this.f12708e += i11;
            } else {
                int length2 = bArr2.length - i12;
                System.arraycopy(bArr, i10, bArr2, i12, length2);
                int i13 = i11 - length2;
                c(i13);
                System.arraycopy(bArr, i10 + length2, this.f12707d, 0, i13);
                this.f12708e = i13;
            }
        }
    }

    public final String toString(Charset charset) {
        return size() == 0 ? "" : n(charset);
    }

    public static ByteString copyFrom(ByteBuffer byteBuffer) {
        return copyFrom(byteBuffer, byteBuffer.remaining());
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public static ByteString copyFrom(String str, String str2) throws UnsupportedEncodingException {
        return new h(str.getBytes(str2));
    }

    public static ByteString copyFrom(String str, Charset charset) {
        return new h(str.getBytes(charset));
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        int i10;
        if (!(iterable instanceof Collection)) {
            i10 = 0;
            Iterator<ByteString> it = iterable.iterator();
            while (it.hasNext()) {
                it.next();
                i10++;
            }
        } else {
            i10 = ((Collection) iterable).size();
        }
        if (i10 == 0) {
            return EMPTY;
        }
        return a(iterable.iterator(), i10);
    }
}
