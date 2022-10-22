package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Stack;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RopeByteString.java */
/* loaded from: classes.dex */
public final class p0 extends ByteString {
    private static final int[] minLengthByDepth;
    private static final long serialVersionUID = 1;
    private final ByteString left;
    private final int leftLength;
    private final ByteString right;
    private final int totalLength;
    private final int treeDepth;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RopeByteString.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Stack<ByteString> f13320a;

        private b() {
            this.f13320a = new Stack<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ByteString b(ByteString byteString, ByteString byteString2) {
            c(byteString);
            c(byteString2);
            ByteString pop = this.f13320a.pop();
            while (!this.f13320a.isEmpty()) {
                pop = new p0(this.f13320a.pop(), pop);
            }
            return pop;
        }

        private void c(ByteString byteString) {
            if (byteString.h()) {
                e(byteString);
            } else if (byteString instanceof p0) {
                p0 p0Var = (p0) byteString;
                c(p0Var.left);
                c(p0Var.right);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + byteString.getClass());
            }
        }

        private int d(int i10) {
            int binarySearch = Arrays.binarySearch(p0.minLengthByDepth, i10);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void e(ByteString byteString) {
            int d10 = d(byteString.size());
            int i10 = p0.minLengthByDepth[d10 + 1];
            if (this.f13320a.isEmpty() || this.f13320a.peek().size() >= i10) {
                this.f13320a.push(byteString);
                return;
            }
            int i11 = p0.minLengthByDepth[d10];
            ByteString pop = this.f13320a.pop();
            while (!this.f13320a.isEmpty() && this.f13320a.peek().size() < i11) {
                pop = new p0(this.f13320a.pop(), pop);
            }
            p0 p0Var = new p0(pop, byteString);
            while (!this.f13320a.isEmpty()) {
                if (this.f13320a.peek().size() >= p0.minLengthByDepth[d(p0Var.size()) + 1]) {
                    break;
                }
                p0Var = new p0(this.f13320a.pop(), p0Var);
            }
            this.f13320a.push(p0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RopeByteString.java */
    /* loaded from: classes.dex */
    public static class c implements Iterator<ByteString.g> {

        /* renamed from: a  reason: collision with root package name */
        private final Stack<p0> f13321a;

        /* renamed from: b  reason: collision with root package name */
        private ByteString.g f13322b;

        private ByteString.g a(ByteString byteString) {
            while (byteString instanceof p0) {
                p0 p0Var = (p0) byteString;
                this.f13321a.push(p0Var);
                byteString = p0Var.left;
            }
            return (ByteString.g) byteString;
        }

        private ByteString.g b() {
            while (!this.f13321a.isEmpty()) {
                ByteString.g a10 = a(this.f13321a.pop().right);
                if (!a10.isEmpty()) {
                    return a10;
                }
            }
            return null;
        }

        /* renamed from: c */
        public ByteString.g next() {
            ByteString.g gVar = this.f13322b;
            if (gVar != null) {
                this.f13322b = b();
                return gVar;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13322b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private c(ByteString byteString) {
            this.f13321a = new Stack<>();
            this.f13322b = a(byteString);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 1;
        while (i10 > 0) {
            arrayList.add(Integer.valueOf(i10));
            i10 = i11 + i10;
            i11 = i10;
        }
        arrayList.add(Integer.MAX_VALUE);
        minLengthByDepth = new int[arrayList.size()];
        int i12 = 0;
        while (true) {
            int[] iArr = minLengthByDepth;
            if (i12 < iArr.length) {
                iArr[i12] = ((Integer) arrayList.get(i12)).intValue();
                i12++;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString u(ByteString byteString, ByteString byteString2) {
        if (byteString2.size() == 0) {
            return byteString;
        }
        if (byteString.size() == 0) {
            return byteString2;
        }
        int size = byteString.size() + byteString2.size();
        if (size < 128) {
            return w(byteString, byteString2);
        }
        if (byteString instanceof p0) {
            p0 p0Var = (p0) byteString;
            if (p0Var.right.size() + byteString2.size() < 128) {
                return new p0(p0Var.left, w(p0Var.right, byteString2));
            } else if (p0Var.left.g() > p0Var.right.g() && p0Var.g() > byteString2.g()) {
                return new p0(p0Var.left, new p0(p0Var.right, byteString2));
            }
        }
        if (size >= minLengthByDepth[Math.max(byteString.g(), byteString2.g()) + 1]) {
            return new p0(byteString, byteString2);
        }
        return new b().b(byteString, byteString2);
    }

    private static ByteString w(ByteString byteString, ByteString byteString2) {
        int size = byteString.size();
        int size2 = byteString2.size();
        byte[] bArr = new byte[size + size2];
        byteString.copyTo(bArr, 0, 0, size);
        byteString2.copyTo(bArr, 0, size, size2);
        return ByteString.o(bArr);
    }

    private boolean y(ByteString byteString) {
        boolean z10;
        c cVar = new c(this);
        ByteString.g next = cVar.next();
        c cVar2 = new c(byteString);
        ByteString.g next2 = cVar2.next();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int size = next.size() - i10;
            int size2 = next2.size() - i11;
            int min = Math.min(size, size2);
            if (i10 == 0) {
                z10 = next.r(next2, i11, min);
            } else {
                z10 = next2.r(next, i10, min);
            }
            if (!z10) {
                return false;
            }
            i12 += min;
            int i13 = this.totalLength;
            if (i12 < i13) {
                if (min == size) {
                    i10 = 0;
                    next = cVar.next();
                } else {
                    i10 += min;
                    next = next;
                }
                if (min == size2) {
                    next2 = cVar2.next();
                    i11 = 0;
                } else {
                    i11 += min;
                }
            } else if (i12 == i13) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    @Override // com.google.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().asReadOnlyByteBuffer());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.ByteString
    public byte byteAt(int i10) {
        ByteString.b(i10, this.totalLength);
        int i11 = this.leftLength;
        if (i10 < i11) {
            return this.left.byteAt(i10);
        }
        return this.right.byteAt(i10 - i11);
    }

    @Override // com.google.protobuf.ByteString
    public void copyTo(ByteBuffer byteBuffer) {
        this.left.copyTo(byteBuffer);
        this.right.copyTo(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public void d(byte[] bArr, int i10, int i11, int i12) {
        int i13 = i10 + i12;
        int i14 = this.leftLength;
        if (i13 <= i14) {
            this.left.d(bArr, i10, i11, i12);
        } else if (i10 >= i14) {
            this.right.d(bArr, i10 - i14, i11, i12);
        } else {
            int i15 = i14 - i10;
            this.left.d(bArr, i10, i11, i15);
            this.right.d(bArr, 0, i11 + i15, i12 - i15);
        }
    }

    @Override // com.google.protobuf.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (this.totalLength != byteString.size()) {
            return false;
        }
        if (this.totalLength == 0) {
            return true;
        }
        int l10 = l();
        int l11 = byteString.l();
        if (l10 == 0 || l11 == 0 || l10 == l11) {
            return y(byteString);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int g() {
        return this.treeDepth;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public boolean h() {
        return this.totalLength >= minLengthByDepth[this.treeDepth];
    }

    @Override // com.google.protobuf.ByteString
    public boolean isValidUtf8() {
        int k10 = this.left.k(0, 0, this.leftLength);
        ByteString byteString = this.right;
        return byteString.k(k10, 0, byteString.size()) == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int j(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.leftLength;
        if (i13 <= i14) {
            return this.left.j(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.right.j(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.right.j(this.left.j(i10, i11, i15), 0, i12 - i15);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.ByteString
    public int k(int i10, int i11, int i12) {
        int i13 = i11 + i12;
        int i14 = this.leftLength;
        if (i13 <= i14) {
            return this.left.k(i10, i11, i12);
        }
        if (i11 >= i14) {
            return this.right.k(i10, i11 - i14, i12);
        }
        int i15 = i14 - i11;
        return this.right.k(this.left.k(i10, i11, i15), 0, i12 - i15);
    }

    @Override // com.google.protobuf.ByteString
    protected String n(Charset charset) {
        return new String(toByteArray(), charset);
    }

    @Override // com.google.protobuf.ByteString
    public i newCodedInput() {
        return i.e(new d());
    }

    @Override // com.google.protobuf.ByteString
    public InputStream newInput() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ByteString
    public void q(h hVar) throws IOException {
        this.left.q(hVar);
        this.right.q(hVar);
    }

    @Override // com.google.protobuf.ByteString
    public int size() {
        return this.totalLength;
    }

    @Override // com.google.protobuf.ByteString
    public ByteString substring(int i10, int i11) {
        int c10 = ByteString.c(i10, i11, this.totalLength);
        if (c10 == 0) {
            return ByteString.EMPTY;
        }
        if (c10 == this.totalLength) {
            return this;
        }
        int i12 = this.leftLength;
        if (i11 <= i12) {
            return this.left.substring(i10, i11);
        }
        if (i10 >= i12) {
            return this.right.substring(i10 - i12, i11 - i12);
        }
        return new p0(this.left.substring(i10), this.right.substring(0, i11 - this.leftLength));
    }

    @Override // com.google.protobuf.ByteString
    public void writeTo(OutputStream outputStream) throws IOException {
        this.left.writeTo(outputStream);
        this.right.writeTo(outputStream);
    }

    private p0(ByteString byteString, ByteString byteString2) {
        this.left = byteString;
        this.right = byteString2;
        int size = byteString.size();
        this.leftLength = size;
        this.totalLength = size + byteString2.size();
        this.treeDepth = Math.max(byteString.g(), byteString2.g()) + 1;
    }

    /* compiled from: RopeByteString.java */
    /* loaded from: classes.dex */
    private class d extends InputStream {

        /* renamed from: a  reason: collision with root package name */
        private c f13323a;

        /* renamed from: b  reason: collision with root package name */
        private ByteString.g f13324b;

        /* renamed from: c  reason: collision with root package name */
        private int f13325c;

        /* renamed from: d  reason: collision with root package name */
        private int f13326d;

        /* renamed from: e  reason: collision with root package name */
        private int f13327e;

        /* renamed from: f  reason: collision with root package name */
        private int f13328f;

        public d() {
            d();
        }

        private void c() {
            if (this.f13324b != null) {
                int i10 = this.f13326d;
                int i11 = this.f13325c;
                if (i10 == i11) {
                    this.f13327e += i11;
                    this.f13326d = 0;
                    if (this.f13323a.hasNext()) {
                        ByteString.g c10 = this.f13323a.next();
                        this.f13324b = c10;
                        this.f13325c = c10.size();
                        return;
                    }
                    this.f13324b = null;
                    this.f13325c = 0;
                }
            }
        }

        private void d() {
            c cVar = new c(p0.this);
            this.f13323a = cVar;
            ByteString.g c10 = cVar.next();
            this.f13324b = c10;
            this.f13325c = c10.size();
            this.f13326d = 0;
            this.f13327e = 0;
        }

        private int h(byte[] bArr, int i10, int i11) {
            int i12 = i11;
            while (true) {
                if (i12 <= 0) {
                    break;
                }
                c();
                if (this.f13324b != null) {
                    int min = Math.min(this.f13325c - this.f13326d, i12);
                    if (bArr != null) {
                        this.f13324b.copyTo(bArr, this.f13326d, i10, min);
                        i10 += min;
                    }
                    this.f13326d += min;
                    i12 -= min;
                } else if (i12 == i11) {
                    return -1;
                }
            }
            return i11 - i12;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return p0.this.size() - (this.f13327e + this.f13326d);
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            this.f13328f = this.f13327e + this.f13326d;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) {
            Objects.requireNonNull(bArr);
            if (i10 >= 0 && i11 >= 0 && i11 <= bArr.length - i10) {
                return h(bArr, i10, i11);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            d();
            h(null, 0, this.f13328f);
        }

        @Override // java.io.InputStream
        public long skip(long j10) {
            if (j10 >= 0) {
                if (j10 > 2147483647L) {
                    j10 = 2147483647L;
                }
                return h(null, 0, (int) j10);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            c();
            ByteString.g gVar = this.f13324b;
            if (gVar == null) {
                return -1;
            }
            int i10 = this.f13326d;
            this.f13326d = i10 + 1;
            return gVar.byteAt(i10) & 255;
        }
    }
}
