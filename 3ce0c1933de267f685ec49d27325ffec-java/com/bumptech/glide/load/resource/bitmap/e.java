package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import n5.j;
/* compiled from: DefaultImageHeaderParser.java */
/* loaded from: classes.dex */
public final class e implements ImageHeaderParser {

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f8075a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f8076b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    private static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f8077a;

        a(ByteBuffer byteBuffer) {
            this.f8077a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.e.c
        public long f(long j10) {
            int min = (int) Math.min(this.f8077a.remaining(), j10);
            ByteBuffer byteBuffer = this.f8077a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.e.c
        public int g() {
            return ((j() << 8) & 65280) | (j() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.e.c
        public int h(byte[] bArr, int i10) {
            int min = Math.min(i10, this.f8077a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f8077a.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.e.c
        public short i() {
            return (short) (j() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.e.c
        public int j() {
            if (this.f8077a.remaining() < 1) {
                return -1;
            }
            return this.f8077a.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final ByteBuffer f8078a;

        b(byte[] bArr, int i10) {
            this.f8078a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
        }

        private boolean c(int i10, int i11) {
            return this.f8078a.remaining() - i10 >= i11;
        }

        short a(int i10) {
            if (c(i10, 2)) {
                return this.f8078a.getShort(i10);
            }
            return (short) -1;
        }

        int b(int i10) {
            if (c(i10, 4)) {
                return this.f8078a.getInt(i10);
            }
            return -1;
        }

        int d() {
            return this.f8078a.remaining();
        }

        void e(ByteOrder byteOrder) {
            this.f8078a.order(byteOrder);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    public interface c {
        long f(long j10) throws IOException;

        int g() throws IOException;

        int h(byte[] bArr, int i10) throws IOException;

        short i() throws IOException;

        int j() throws IOException;
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* loaded from: classes.dex */
    private static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        private final InputStream f8079a;

        d(InputStream inputStream) {
            this.f8079a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.e.c
        public long f(long j10) throws IOException {
            if (j10 < 0) {
                return 0L;
            }
            long j11 = j10;
            while (j11 > 0) {
                long skip = this.f8079a.skip(j11);
                if (skip <= 0) {
                    if (this.f8079a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j11 -= skip;
            }
            return j10 - j11;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.e.c
        public int g() throws IOException {
            return ((this.f8079a.read() << 8) & 65280) | (this.f8079a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.e.c
        public int h(byte[] bArr, int i10) throws IOException {
            int i11 = i10;
            while (i11 > 0) {
                int read = this.f8079a.read(bArr, i10 - i11, i11);
                if (read == -1) {
                    break;
                }
                i11 -= read;
            }
            return i10 - i11;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.e.c
        public short i() throws IOException {
            return (short) (this.f8079a.read() & 255);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.e.c
        public int j() throws IOException {
            return this.f8079a.read();
        }
    }

    private static int d(int i10, int i11) {
        return i10 + 2 + (i11 * 12);
    }

    private int e(c cVar, u4.b bVar) throws IOException {
        int g10 = cVar.g();
        if (!g(g10)) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + g10);
            }
            return -1;
        }
        int i10 = i(cVar);
        if (i10 == -1) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        byte[] bArr = (byte[]) bVar.e(i10, byte[].class);
        try {
            return k(cVar, bArr, i10);
        } finally {
            bVar.d(bArr);
        }
    }

    private ImageHeaderParser.ImageType f(c cVar) throws IOException {
        int g10 = cVar.g();
        if (g10 == 65496) {
            return ImageHeaderParser.ImageType.JPEG;
        }
        int g11 = ((g10 << 16) & (-65536)) | (cVar.g() & 65535);
        if (g11 == -1991225785) {
            cVar.f(21L);
            return cVar.j() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
        } else if ((g11 >> 8) == 4671814) {
            return ImageHeaderParser.ImageType.GIF;
        } else {
            if (g11 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            cVar.f(4L);
            if ((((cVar.g() << 16) & (-65536)) | (cVar.g() & 65535)) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int g12 = ((cVar.g() << 16) & (-65536)) | (cVar.g() & 65535);
            if ((g12 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i10 = g12 & 255;
            if (i10 == 88) {
                cVar.f(4L);
                return (cVar.j() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            } else if (i10 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            } else {
                cVar.f(4L);
                return (cVar.j() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
        }
    }

    private static boolean g(int i10) {
        return (i10 & 65496) == 65496 || i10 == 19789 || i10 == 18761;
    }

    private boolean h(byte[] bArr, int i10) {
        boolean z10 = bArr != null && i10 > f8075a.length;
        if (z10) {
            int i11 = 0;
            while (true) {
                byte[] bArr2 = f8075a;
                if (i11 >= bArr2.length) {
                    break;
                } else if (bArr[i11] != bArr2[i11]) {
                    return false;
                } else {
                    i11++;
                }
            }
        }
        return z10;
    }

    private int i(c cVar) throws IOException {
        short i10;
        short i11;
        int g10;
        long j10;
        long f10;
        do {
            if (cVar.i() != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) i10));
                }
                return -1;
            }
            i11 = cVar.i();
            if (i11 == 218) {
                return -1;
            }
            if (i11 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            g10 = cVar.g() - 2;
            if (i11 == 225) {
                return g10;
            }
            j10 = g10;
            f10 = cVar.f(j10);
        } while (f10 == j10);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) i11) + ", wanted to skip: " + g10 + ", but actually skipped: " + f10);
        }
        return -1;
    }

    private static int j(b bVar) {
        ByteOrder byteOrder;
        short a10 = bVar.a(6);
        if (a10 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else if (a10 != 19789) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) a10));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.e(byteOrder);
        int b10 = bVar.b(10) + 6;
        short a11 = bVar.a(b10);
        for (int i10 = 0; i10 < a11; i10++) {
            int d10 = d(b10, i10);
            short a12 = bVar.a(d10);
            if (a12 == 274) {
                short a13 = bVar.a(d10 + 2);
                if (a13 >= 1 && a13 <= 12) {
                    int b11 = bVar.b(d10 + 4);
                    if (b11 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i10 + " tagType=" + ((int) a12) + " formatCode=" + ((int) a13) + " componentCount=" + b11);
                        }
                        int i11 = b11 + f8076b[a13];
                        if (i11 <= 4) {
                            int i12 = d10 + 8;
                            if (i12 < 0 || i12 > bVar.d()) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i12 + " tagType=" + ((int) a12));
                                }
                            } else if (i11 >= 0 && i11 + i12 <= bVar.d()) {
                                return bVar.a(i12);
                            } else {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a12));
                                }
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a13));
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) a13));
                }
            }
        }
        return -1;
    }

    private int k(c cVar, byte[] bArr, int i10) throws IOException {
        int h10 = cVar.h(bArr, i10);
        if (h10 != i10) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i10 + ", actually read: " + h10);
            }
            return -1;
        } else if (h(bArr, i10)) {
            return j(new b(bArr, i10));
        } else {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) throws IOException {
        return f(new a((ByteBuffer) j.d(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(InputStream inputStream, u4.b bVar) throws IOException {
        return e(new d((InputStream) j.d(inputStream)), (u4.b) j.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType c(InputStream inputStream) throws IOException {
        return f(new d((InputStream) j.d(inputStream)));
    }
}
