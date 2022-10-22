package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.system.OsConstants;
import android.util.Log;
import androidx.exifinterface.media.b;
import com.huawei.hms.hmsscankit.RemoteView;
import com.realsil.sdk.dfu.DfuException;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
/* compiled from: ExifInterface.java */
/* loaded from: classes.dex */
public class a {
    private static SimpleDateFormat G;
    private static SimpleDateFormat H;
    private static final d[] L;
    private static final d[] M;
    private static final d[] N;
    private static final d[] O;
    private static final d[] P;
    private static final d[] R;
    private static final d[] S;
    private static final d[] T;
    private static final d[] U;
    static final d[][] V;
    private static final HashMap<Integer, d>[] X;
    private static final HashMap<String, d>[] Y;

    /* renamed from: b0  reason: collision with root package name */
    static final Charset f2869b0;

    /* renamed from: c0  reason: collision with root package name */
    static final byte[] f2870c0;

    /* renamed from: d0  reason: collision with root package name */
    private static final byte[] f2871d0;

    /* renamed from: a  reason: collision with root package name */
    private String f2884a;

    /* renamed from: b  reason: collision with root package name */
    private FileDescriptor f2885b;

    /* renamed from: c  reason: collision with root package name */
    private AssetManager.AssetInputStream f2886c;

    /* renamed from: d  reason: collision with root package name */
    private int f2887d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2888e;

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<String, c>[] f2889f;

    /* renamed from: g  reason: collision with root package name */
    private Set<Integer> f2890g;

    /* renamed from: h  reason: collision with root package name */
    private ByteOrder f2891h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f2892i;

    /* renamed from: j  reason: collision with root package name */
    private int f2893j;

    /* renamed from: k  reason: collision with root package name */
    private int f2894k;

    /* renamed from: l  reason: collision with root package name */
    private int f2895l;

    /* renamed from: m  reason: collision with root package name */
    private int f2896m;

    /* renamed from: n  reason: collision with root package name */
    private int f2897n;

    /* renamed from: o  reason: collision with root package name */
    private static final boolean f2872o = Log.isLoggable("ExifInterface", 3);

    /* renamed from: p  reason: collision with root package name */
    private static final List<Integer> f2873p = Arrays.asList(1, 6, 3, 8);

    /* renamed from: q  reason: collision with root package name */
    private static final List<Integer> f2874q = Arrays.asList(2, 7, 4, 5);

    /* renamed from: r  reason: collision with root package name */
    public static final int[] f2875r = {8, 8, 8};

    /* renamed from: s  reason: collision with root package name */
    public static final int[] f2876s = {8};

    /* renamed from: t  reason: collision with root package name */
    static final byte[] f2877t = {-1, -40, -1};

    /* renamed from: u  reason: collision with root package name */
    private static final byte[] f2878u = {102, 116, 121, 112};

    /* renamed from: v  reason: collision with root package name */
    private static final byte[] f2879v = {109, 105, 102, 49};

    /* renamed from: w  reason: collision with root package name */
    private static final byte[] f2880w = {104, 101, 105, 99};

    /* renamed from: x  reason: collision with root package name */
    private static final byte[] f2881x = {79, 76, 89, 77, 80, 0};

    /* renamed from: y  reason: collision with root package name */
    private static final byte[] f2882y = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};

    /* renamed from: z  reason: collision with root package name */
    private static final byte[] f2883z = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] A = {101, 88, 73, 102};
    private static final byte[] B = {73, 72, 68, 82};
    private static final byte[] C = {73, 69, 78, 68};
    private static final byte[] D = {82, 73, 70, 70};
    private static final byte[] E = {87, 69, 66, 80};
    private static final byte[] F = {69, 88, 73, 70};
    static final String[] I = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] J = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] K = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final d Q = new d("StripOffsets", 273, 3);
    private static final d[] W = {new d("SubIFDPointer", 330, 4), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("InteroperabilityIFDPointer", 40965, 4), new d("CameraSettingsIFDPointer", 8224, 1), new d("ImageProcessingIFDPointer", 8256, 1)};
    private static final HashSet<String> Z = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));

    /* renamed from: a0  reason: collision with root package name */
    private static final HashMap<Integer, Integer> f2868a0 = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExifInterface.java */
    /* renamed from: androidx.exifinterface.media.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0029a extends MediaDataSource {

        /* renamed from: a  reason: collision with root package name */
        long f2898a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f f2899b;

        C0029a(a aVar, f fVar) {
            this.f2899b = fVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // android.media.MediaDataSource
        public long getSize() throws IOException {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j10, byte[] bArr, int i10, int i11) throws IOException {
            if (i11 == 0) {
                return 0;
            }
            if (j10 < 0) {
                return -1;
            }
            try {
                long j11 = this.f2898a;
                if (j11 != j10) {
                    if (j11 >= 0 && j10 >= j11 + this.f2899b.available()) {
                        return -1;
                    }
                    this.f2899b.n(j10);
                    this.f2898a = j10;
                }
                if (i11 > this.f2899b.available()) {
                    i11 = this.f2899b.available();
                }
                int read = this.f2899b.read(bArr, i10, i11);
                if (read >= 0) {
                    this.f2898a += read;
                    return read;
                }
            } catch (IOException unused) {
            }
            this.f2898a = -1L;
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExifInterface.java */
    /* loaded from: classes.dex */
    public static class b extends InputStream implements DataInput {

        /* renamed from: e  reason: collision with root package name */
        private static final ByteOrder f2900e = ByteOrder.LITTLE_ENDIAN;

        /* renamed from: f  reason: collision with root package name */
        private static final ByteOrder f2901f = ByteOrder.BIG_ENDIAN;

        /* renamed from: a  reason: collision with root package name */
        final DataInputStream f2902a;

        /* renamed from: b  reason: collision with root package name */
        private ByteOrder f2903b;

        /* renamed from: c  reason: collision with root package name */
        int f2904c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f2905d;

        b(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f2902a.available();
        }

        public int c() {
            return this.f2904c;
        }

        public long d() throws IOException {
            return readInt() & 4294967295L;
        }

        public void h(ByteOrder byteOrder) {
            this.f2903b = byteOrder;
        }

        public void i(int i10) throws IOException {
            int i11 = 0;
            while (i11 < i10) {
                int i12 = i10 - i11;
                int skip = (int) this.f2902a.skip(i12);
                if (skip <= 0) {
                    if (this.f2905d == null) {
                        this.f2905d = new byte[8192];
                    }
                    skip = this.f2902a.read(this.f2905d, 0, Math.min(8192, i12));
                    if (skip == -1) {
                        throw new EOFException("Reached EOF while skipping " + i10 + " bytes.");
                    }
                }
                i11 += skip;
            }
            this.f2904c += i11;
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            throw new UnsupportedOperationException("Mark is currently unsupported");
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.f2904c++;
            return this.f2902a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.f2904c++;
            return this.f2902a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            this.f2904c++;
            int read = this.f2902a.read();
            if (read >= 0) {
                return (byte) read;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.f2904c += 2;
            return this.f2902a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i10, int i11) throws IOException {
            this.f2904c += i11;
            this.f2902a.readFully(bArr, i10, i11);
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            this.f2904c += 4;
            int read = this.f2902a.read();
            int read2 = this.f2902a.read();
            int read3 = this.f2902a.read();
            int read4 = this.f2902a.read();
            if ((read | read2 | read3 | read4) >= 0) {
                ByteOrder byteOrder = this.f2903b;
                if (byteOrder == f2900e) {
                    return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f2901f) {
                    return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                }
                throw new IOException("Invalid byte order: " + this.f2903b);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            this.f2904c += 8;
            int read = this.f2902a.read();
            int read2 = this.f2902a.read();
            int read3 = this.f2902a.read();
            int read4 = this.f2902a.read();
            int read5 = this.f2902a.read();
            int read6 = this.f2902a.read();
            int read7 = this.f2902a.read();
            int read8 = this.f2902a.read();
            if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                ByteOrder byteOrder = this.f2903b;
                if (byteOrder == f2900e) {
                    return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                }
                if (byteOrder == f2901f) {
                    return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                }
                throw new IOException("Invalid byte order: " + this.f2903b);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            this.f2904c += 2;
            int read = this.f2902a.read();
            int read2 = this.f2902a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f2903b;
                if (byteOrder == f2900e) {
                    return (short) ((read2 << 8) + read);
                }
                if (byteOrder == f2901f) {
                    return (short) ((read << 8) + read2);
                }
                throw new IOException("Invalid byte order: " + this.f2903b);
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.f2904c += 2;
            return this.f2902a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.f2904c++;
            return this.f2902a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            this.f2904c += 2;
            int read = this.f2902a.read();
            int read2 = this.f2902a.read();
            if ((read | read2) >= 0) {
                ByteOrder byteOrder = this.f2903b;
                if (byteOrder == f2900e) {
                    return (read2 << 8) + read;
                }
                if (byteOrder == f2901f) {
                    return (read << 8) + read2;
                }
                throw new IOException("Invalid byte order: " + this.f2903b);
            }
            throw new EOFException();
        }

        @Override // java.io.InputStream
        public void reset() {
            throw new UnsupportedOperationException("Reset is currently unsupported");
        }

        @Override // java.io.DataInput
        public int skipBytes(int i10) throws IOException {
            throw new UnsupportedOperationException("skipBytes is currently unsupported");
        }

        b(InputStream inputStream) throws IOException {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.f2903b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.f2902a = dataInputStream;
            dataInputStream.mark(0);
            this.f2904c = 0;
            this.f2903b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int read = this.f2902a.read(bArr, i10, i11);
            this.f2904c += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            this.f2904c += bArr.length;
            this.f2902a.readFully(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExifInterface.java */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f2906a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2907b;

        /* renamed from: c  reason: collision with root package name */
        public final long f2908c;

        /* renamed from: d  reason: collision with root package name */
        public final byte[] f2909d;

        c(int i10, int i11, byte[] bArr) {
            this(i10, i11, -1L, bArr);
        }

        public static c a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(a.f2869b0);
            return new c(2, bytes.length, bytes);
        }

        public static c b(long j10, ByteOrder byteOrder) {
            return c(new long[]{j10}, byteOrder);
        }

        public static c c(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.J[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j10 : jArr) {
                wrap.putInt((int) j10);
            }
            return new c(4, jArr.length, wrap.array());
        }

        public static c d(e eVar, ByteOrder byteOrder) {
            return e(new e[]{eVar}, byteOrder);
        }

        public static c e(e[] eVarArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.J[5] * eVarArr.length]);
            wrap.order(byteOrder);
            for (e eVar : eVarArr) {
                wrap.putInt((int) eVar.f2914a);
                wrap.putInt((int) eVar.f2915b);
            }
            return new c(5, eVarArr.length, wrap.array());
        }

        public static c f(int i10, ByteOrder byteOrder) {
            return g(new int[]{i10}, byteOrder);
        }

        public static c g(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[a.J[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i10 : iArr) {
                wrap.putShort((short) i10);
            }
            return new c(3, iArr.length, wrap.array());
        }

        public double h(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (k10 instanceof String) {
                return Double.parseDouble((String) k10);
            } else {
                if (k10 instanceof long[]) {
                    long[] jArr = (long[]) k10;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k10 instanceof int[]) {
                    int[] iArr = (int[]) k10;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k10 instanceof double[]) {
                    double[] dArr = (double[]) k10;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k10 instanceof e[]) {
                    e[] eVarArr = (e[]) k10;
                    if (eVarArr.length == 1) {
                        return eVarArr[0].a();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int i(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (k10 instanceof String) {
                return Integer.parseInt((String) k10);
            } else {
                if (k10 instanceof long[]) {
                    long[] jArr = (long[]) k10;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (k10 instanceof int[]) {
                    int[] iArr = (int[]) k10;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String j(ByteOrder byteOrder) {
            Object k10 = k(byteOrder);
            if (k10 == null) {
                return null;
            }
            if (k10 instanceof String) {
                return (String) k10;
            }
            StringBuilder sb2 = new StringBuilder();
            int i10 = 0;
            if (k10 instanceof long[]) {
                long[] jArr = (long[]) k10;
                while (i10 < jArr.length) {
                    sb2.append(jArr[i10]);
                    i10++;
                    if (i10 != jArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            } else if (k10 instanceof int[]) {
                int[] iArr = (int[]) k10;
                while (i10 < iArr.length) {
                    sb2.append(iArr[i10]);
                    i10++;
                    if (i10 != iArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            } else if (k10 instanceof double[]) {
                double[] dArr = (double[]) k10;
                while (i10 < dArr.length) {
                    sb2.append(dArr[i10]);
                    i10++;
                    if (i10 != dArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            } else if (!(k10 instanceof e[])) {
                return null;
            } else {
                e[] eVarArr = (e[]) k10;
                while (i10 < eVarArr.length) {
                    sb2.append(eVarArr[i10].f2914a);
                    sb2.append('/');
                    sb2.append(eVarArr[i10].f2915b);
                    i10++;
                    if (i10 != eVarArr.length) {
                        sb2.append(",");
                    }
                }
                return sb2.toString();
            }
        }

        /* JADX WARN: Not initialized variable reg: 3, insn: 0x019c: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:137:0x019c */
        /* JADX WARN: Removed duplicated region for block: B:160:0x019f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Object k(ByteOrder byteOrder) {
            Throwable th2;
            IOException e10;
            b bVar;
            byte b10;
            byte[] bArr;
            InputStream inputStream = null;
            try {
                try {
                    bVar = new b(this.f2909d);
                    try {
                        bVar.h(byteOrder);
                        boolean z10 = true;
                        int i10 = 0;
                        switch (this.f2906a) {
                            case 1:
                            case 6:
                                byte[] bArr2 = this.f2909d;
                                if (bArr2.length != 1 || bArr2[0] < 0 || bArr2[0] > 1) {
                                    String str = new String(bArr2, a.f2869b0);
                                    try {
                                        bVar.close();
                                    } catch (IOException e11) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                                    }
                                    return str;
                                }
                                String str2 = new String(new char[]{(char) (bArr2[0] + 48)});
                                try {
                                    bVar.close();
                                } catch (IOException e12) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                                }
                                return str2;
                            case 2:
                            case 7:
                                if (this.f2907b >= a.K.length) {
                                    int i11 = 0;
                                    while (true) {
                                        bArr = a.K;
                                        if (i11 < bArr.length) {
                                            if (this.f2909d[i11] != bArr[i11]) {
                                                z10 = false;
                                            } else {
                                                i11++;
                                            }
                                        }
                                    }
                                    if (z10) {
                                        i10 = bArr.length;
                                    }
                                }
                                StringBuilder sb2 = new StringBuilder();
                                while (i10 < this.f2907b && (b10 = this.f2909d[i10]) != 0) {
                                    if (b10 >= 32) {
                                        sb2.append((char) b10);
                                    } else {
                                        sb2.append('?');
                                    }
                                    i10++;
                                }
                                String sb3 = sb2.toString();
                                try {
                                    bVar.close();
                                } catch (IOException e13) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                                }
                                return sb3;
                            case 3:
                                int[] iArr = new int[this.f2907b];
                                while (i10 < this.f2907b) {
                                    iArr[i10] = bVar.readUnsignedShort();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e14) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                                }
                                return iArr;
                            case 4:
                                long[] jArr = new long[this.f2907b];
                                while (i10 < this.f2907b) {
                                    jArr[i10] = bVar.d();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e15) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                                }
                                return jArr;
                            case 5:
                                e[] eVarArr = new e[this.f2907b];
                                while (i10 < this.f2907b) {
                                    eVarArr[i10] = new e(bVar.d(), bVar.d());
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e16) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e16);
                                }
                                return eVarArr;
                            case 8:
                                int[] iArr2 = new int[this.f2907b];
                                while (i10 < this.f2907b) {
                                    iArr2[i10] = bVar.readShort();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e17) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e17);
                                }
                                return iArr2;
                            case 9:
                                int[] iArr3 = new int[this.f2907b];
                                while (i10 < this.f2907b) {
                                    iArr3[i10] = bVar.readInt();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e18) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e18);
                                }
                                return iArr3;
                            case 10:
                                e[] eVarArr2 = new e[this.f2907b];
                                while (i10 < this.f2907b) {
                                    eVarArr2[i10] = new e(bVar.readInt(), bVar.readInt());
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e19) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e19);
                                }
                                return eVarArr2;
                            case 11:
                                double[] dArr = new double[this.f2907b];
                                while (i10 < this.f2907b) {
                                    dArr[i10] = bVar.readFloat();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e20) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e20);
                                }
                                return dArr;
                            case 12:
                                double[] dArr2 = new double[this.f2907b];
                                while (i10 < this.f2907b) {
                                    dArr2[i10] = bVar.readDouble();
                                    i10++;
                                }
                                try {
                                    bVar.close();
                                } catch (IOException e21) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e21);
                                }
                                return dArr2;
                            default:
                                try {
                                    bVar.close();
                                } catch (IOException e22) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e22);
                                }
                                return null;
                        }
                    } catch (IOException e23) {
                        e10 = e23;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e10);
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e24) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e24);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e25) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e25);
                        }
                    }
                    throw th2;
                }
            } catch (IOException e26) {
                e10 = e26;
                bVar = null;
            } catch (Throwable th4) {
                th2 = th4;
                if (inputStream != null) {
                }
                throw th2;
            }
        }

        public String toString() {
            return "(" + a.I[this.f2906a] + ", data length:" + this.f2909d.length + ")";
        }

        c(int i10, int i11, long j10, byte[] bArr) {
            this.f2906a = i10;
            this.f2907b = i11;
            this.f2908c = j10;
            this.f2909d = bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExifInterface.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public final long f2914a;

        /* renamed from: b  reason: collision with root package name */
        public final long f2915b;

        e(long j10, long j11) {
            if (j11 == 0) {
                this.f2914a = 0L;
                this.f2915b = 1L;
                return;
            }
            this.f2914a = j10;
            this.f2915b = j11;
        }

        public double a() {
            return this.f2914a / this.f2915b;
        }

        public String toString() {
            return this.f2914a + "/" + this.f2915b;
        }
    }

    static {
        d[] dVarArr;
        "VP8X".getBytes(Charset.defaultCharset());
        "VP8L".getBytes(Charset.defaultCharset());
        "VP8 ".getBytes(Charset.defaultCharset());
        "ANIM".getBytes(Charset.defaultCharset());
        "ANMF".getBytes(Charset.defaultCharset());
        d[] dVarArr2 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ImageWidth", 256, 3, 4), new d("ImageLength", DfuException.ERROR_FILE_IO_EXCEPTION, 3, 4), new d("BitsPerSample", DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED, 3), new d("Compression", DfuException.ERROR_LOCK_WAIT_INTERRUPTED, 3), new d("PhotometricInterpretation", DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS, 3), new d("ImageDescription", 270, 2), new d("Make", DfuException.ERROR_READ_APP_INFO_ERROR, 2), new d("Model", DfuException.ERROR_READ_PATCH_INFO_ERROR, 2), new d("StripOffsets", 273, 3, 4), new d("Orientation", DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, 3), new d("SamplesPerPixel", DfuException.ERROR_READ_REMOTE_MAC_ADDR, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", DfuException.ERROR_SEND_COMMAND_FAIL, 3, 4), new d("XResolution", DfuException.ERROR_DFU_SPP_RWS_NOT_READY, 5), new d("YResolution", DfuException.ERROR_DFU_ROLE_SWAP_FAILED, 5), new d("PlanarConfiguration", DfuException.ERROR_DFU_ENABLE_BUFFER_CHECK_NO_RESPONSE, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("SensorTopBorder", 4, 4), new d("SensorLeftBorder", 5, 4), new d("SensorBottomBorder", 6, 4), new d("SensorRightBorder", 7, 4), new d("ISO", 23, 3), new d("JpgFromRaw", 46, 7), new d("Xmp", 700, 1)};
        L = dVarArr2;
        d[] dVarArr3 = {new d("ExposureTime", 33434, 5), new d("FNumber", 33437, 5), new d("ExposureProgram", 34850, 3), new d("SpectralSensitivity", 34852, 2), new d("PhotographicSensitivity", 34855, 3), new d("OECF", 34856, 7), new d("SensitivityType", 34864, 3), new d("StandardOutputSensitivity", 34865, 4), new d("RecommendedExposureIndex", 34866, 4), new d("ISOSpeed", 34867, 4), new d("ISOSpeedLatitudeyyy", 34868, 4), new d("ISOSpeedLatitudezzz", 34869, 4), new d("ExifVersion", 36864, 2), new d("DateTimeOriginal", 36867, 2), new d("DateTimeDigitized", 36868, 2), new d("OffsetTime", 36880, 2), new d("OffsetTimeOriginal", 36881, 2), new d("OffsetTimeDigitized", 36882, 2), new d("ComponentsConfiguration", 37121, 7), new d("CompressedBitsPerPixel", 37122, 5), new d("ShutterSpeedValue", 37377, 10), new d("ApertureValue", 37378, 5), new d("BrightnessValue", 37379, 10), new d("ExposureBiasValue", 37380, 10), new d("MaxApertureValue", 37381, 5), new d("SubjectDistance", 37382, 5), new d("MeteringMode", 37383, 3), new d("LightSource", 37384, 3), new d("Flash", 37385, 3), new d("FocalLength", 37386, 5), new d("SubjectArea", 37396, 3), new d("MakerNote", 37500, 7), new d("UserComment", 37510, 7), new d("SubSecTime", 37520, 2), new d("SubSecTimeOriginal", 37521, 2), new d("SubSecTimeDigitized", 37522, 2), new d("FlashpixVersion", 40960, 7), new d("ColorSpace", 40961, 3), new d("PixelXDimension", 40962, 3, 4), new d("PixelYDimension", 40963, 3, 4), new d("RelatedSoundFile", 40964, 2), new d("InteroperabilityIFDPointer", 40965, 4), new d("FlashEnergy", 41483, 5), new d("SpatialFrequencyResponse", 41484, 7), new d("FocalPlaneXResolution", 41486, 5), new d("FocalPlaneYResolution", 41487, 5), new d("FocalPlaneResolutionUnit", 41488, 3), new d("SubjectLocation", 41492, 3), new d("ExposureIndex", 41493, 5), new d("SensingMethod", 41495, 3), new d("FileSource", 41728, 7), new d("SceneType", 41729, 7), new d("CFAPattern", 41730, 7), new d("CustomRendered", 41985, 3), new d("ExposureMode", 41986, 3), new d("WhiteBalance", 41987, 3), new d("DigitalZoomRatio", 41988, 5), new d("FocalLengthIn35mmFilm", 41989, 3), new d("SceneCaptureType", 41990, 3), new d("GainControl", 41991, 3), new d("Contrast", 41992, 3), new d("Saturation", 41993, 3), new d("Sharpness", 41994, 3), new d("DeviceSettingDescription", 41995, 7), new d("SubjectDistanceRange", 41996, 3), new d("ImageUniqueID", 42016, 2), new d("CameraOwnerName", 42032, 2), new d("BodySerialNumber", 42033, 2), new d("LensSpecification", 42034, 5), new d("LensMake", 42035, 2), new d("LensModel", 42036, 2), new d("Gamma", 42240, 5), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        M = dVarArr3;
        d[] dVarArr4 = {new d("GPSVersionID", 0, 1), new d("GPSLatitudeRef", 1, 2), new d("GPSLatitude", 2, 5, 10), new d("GPSLongitudeRef", 3, 2), new d("GPSLongitude", 4, 5, 10), new d("GPSAltitudeRef", 5, 1), new d("GPSAltitude", 6, 5), new d("GPSTimeStamp", 7, 5), new d("GPSSatellites", 8, 2), new d("GPSStatus", 9, 2), new d("GPSMeasureMode", 10, 2), new d("GPSDOP", 11, 5), new d("GPSSpeedRef", 12, 2), new d("GPSSpeed", 13, 5), new d("GPSTrackRef", 14, 2), new d("GPSTrack", 15, 5), new d("GPSImgDirectionRef", 16, 2), new d("GPSImgDirection", 17, 5), new d("GPSMapDatum", 18, 2), new d("GPSDestLatitudeRef", 19, 2), new d("GPSDestLatitude", 20, 5), new d("GPSDestLongitudeRef", 21, 2), new d("GPSDestLongitude", 22, 5), new d("GPSDestBearingRef", 23, 2), new d("GPSDestBearing", 24, 5), new d("GPSDestDistanceRef", 25, 2), new d("GPSDestDistance", 26, 5), new d("GPSProcessingMethod", 27, 7), new d("GPSAreaInformation", 28, 7), new d("GPSDateStamp", 29, 2), new d("GPSDifferential", 30, 3), new d("GPSHPositioningError", 31, 5)};
        N = dVarArr4;
        d[] dVarArr5 = {new d("InteroperabilityIndex", 1, 2)};
        O = dVarArr5;
        d[] dVarArr6 = {new d("NewSubfileType", 254, 4), new d("SubfileType", 255, 4), new d("ThumbnailImageWidth", 256, 3, 4), new d("ThumbnailImageLength", DfuException.ERROR_FILE_IO_EXCEPTION, 3, 4), new d("BitsPerSample", DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED, 3), new d("Compression", DfuException.ERROR_LOCK_WAIT_INTERRUPTED, 3), new d("PhotometricInterpretation", DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS, 3), new d("ImageDescription", 270, 2), new d("Make", DfuException.ERROR_READ_APP_INFO_ERROR, 2), new d("Model", DfuException.ERROR_READ_PATCH_INFO_ERROR, 2), new d("StripOffsets", 273, 3, 4), new d("ThumbnailOrientation", DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, 3), new d("SamplesPerPixel", DfuException.ERROR_READ_REMOTE_MAC_ADDR, 3), new d("RowsPerStrip", 278, 3, 4), new d("StripByteCounts", DfuException.ERROR_SEND_COMMAND_FAIL, 3, 4), new d("XResolution", DfuException.ERROR_DFU_SPP_RWS_NOT_READY, 5), new d("YResolution", DfuException.ERROR_DFU_ROLE_SWAP_FAILED, 5), new d("PlanarConfiguration", DfuException.ERROR_DFU_ENABLE_BUFFER_CHECK_NO_RESPONSE, 3), new d("ResolutionUnit", 296, 3), new d("TransferFunction", 301, 3), new d("Software", 305, 2), new d("DateTime", 306, 2), new d("Artist", 315, 2), new d("WhitePoint", 318, 5), new d("PrimaryChromaticities", 319, 5), new d("SubIFDPointer", 330, 4), new d("JPEGInterchangeFormat", 513, 4), new d("JPEGInterchangeFormatLength", 514, 4), new d("YCbCrCoefficients", 529, 5), new d("YCbCrSubSampling", 530, 3), new d("YCbCrPositioning", 531, 3), new d("ReferenceBlackWhite", 532, 5), new d("Xmp", 700, 1), new d("Copyright", 33432, 2), new d("ExifIFDPointer", 34665, 4), new d("GPSInfoIFDPointer", 34853, 4), new d("DNGVersion", 50706, 1), new d("DefaultCropSize", 50720, 3, 4)};
        P = dVarArr6;
        d[] dVarArr7 = {new d("ThumbnailImage", 256, 7), new d("CameraSettingsIFDPointer", 8224, 4), new d("ImageProcessingIFDPointer", 8256, 4)};
        R = dVarArr7;
        d[] dVarArr8 = {new d("PreviewImageStart", DfuException.ERROR_FILE_IO_EXCEPTION, 4), new d("PreviewImageLength", DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED, 4)};
        S = dVarArr8;
        d[] dVarArr9 = {new d("AspectFrame", RemoteView.REQUEST_CODE_PHOTO, 3)};
        T = dVarArr9;
        d[] dVarArr10 = {new d("ColorSpace", 55, 3)};
        U = dVarArr10;
        d[][] dVarArr11 = {dVarArr2, dVarArr3, dVarArr4, dVarArr5, dVarArr6, dVarArr2, dVarArr7, dVarArr8, dVarArr9, dVarArr10};
        V = dVarArr11;
        X = new HashMap[dVarArr11.length];
        Y = new HashMap[dVarArr11.length];
        Charset forName = Charset.forName("US-ASCII");
        f2869b0 = forName;
        f2870c0 = "Exif\u0000\u0000".getBytes(forName);
        f2871d0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(forName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        G = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", locale);
        H = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i10 = 0;
        while (true) {
            d[][] dVarArr12 = V;
            if (i10 < dVarArr12.length) {
                X[i10] = new HashMap<>();
                Y[i10] = new HashMap<>();
                for (d dVar : dVarArr12[i10]) {
                    X[i10].put(Integer.valueOf(dVar.f2910a), dVar);
                    Y[i10].put(dVar.f2911b, dVar);
                }
                i10++;
            } else {
                HashMap<Integer, Integer> hashMap = f2868a0;
                d[] dVarArr13 = W;
                hashMap.put(Integer.valueOf(dVarArr13[0].f2910a), 5);
                hashMap.put(Integer.valueOf(dVarArr13[1].f2910a), 1);
                hashMap.put(Integer.valueOf(dVarArr13[2].f2910a), 2);
                hashMap.put(Integer.valueOf(dVarArr13[3].f2910a), 3);
                hashMap.put(Integer.valueOf(dVarArr13[4].f2910a), 7);
                hashMap.put(Integer.valueOf(dVarArr13[5].f2910a), 8);
                Pattern.compile(".*[1-9].*");
                Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
        }
    }

    public a(InputStream inputStream) throws IOException {
        this(inputStream, 0);
    }

    private boolean A(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = D;
            if (i10 >= bArr2.length) {
                int i11 = 0;
                while (true) {
                    byte[] bArr3 = E;
                    if (i11 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[D.length + i11 + 4] != bArr3[i11]) {
                        return false;
                    }
                    i11++;
                }
            } else if (bArr[i10] != bArr2[i10]) {
                return false;
            } else {
                i10++;
            }
        }
    }

    private void B(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputstream shouldn't be null");
        for (int i10 = 0; i10 < V.length; i10++) {
            try {
                try {
                    this.f2889f[i10] = new HashMap<>();
                } finally {
                    a();
                    if (f2872o) {
                        D();
                    }
                }
            } catch (IOException | UnsupportedOperationException e10) {
                boolean z10 = f2872o;
                if (z10) {
                    Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e10);
                }
                a();
                if (!z10) {
                    return;
                }
            }
        }
        if (!this.f2888e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.f2887d = g(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        if (K(this.f2887d)) {
            f fVar = new f(inputStream);
            if (this.f2888e) {
                m(fVar);
            } else {
                int i11 = this.f2887d;
                if (i11 == 12) {
                    e(fVar);
                } else if (i11 == 7) {
                    h(fVar);
                } else if (i11 == 10) {
                    l(fVar);
                } else {
                    k(fVar);
                }
            }
            fVar.n(this.f2894k);
            J(fVar);
        } else {
            b bVar = new b(inputStream);
            int i12 = this.f2887d;
            if (i12 == 4) {
                f(bVar, 0, 0);
            } else if (i12 == 13) {
                i(bVar);
            } else if (i12 == 9) {
                j(bVar);
            } else if (i12 == 14) {
                n(bVar);
            }
        }
    }

    private void C(b bVar) throws IOException {
        ByteOrder E2 = E(bVar);
        this.f2891h = E2;
        bVar.h(E2);
        int readUnsignedShort = bVar.readUnsignedShort();
        int i10 = this.f2887d;
        if (i10 == 7 || i10 == 10 || readUnsignedShort == 42) {
            int readInt = bVar.readInt();
            if (readInt >= 8) {
                int i11 = readInt - 8;
                if (i11 > 0) {
                    bVar.i(i11);
                    return;
                }
                return;
            }
            throw new IOException("Invalid first Ifd offset: " + readInt);
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    private void D() {
        for (int i10 = 0; i10 < this.f2889f.length; i10++) {
            Log.d("ExifInterface", "The size of tag group[" + i10 + "]: " + this.f2889f[i10].size());
            for (Map.Entry<String, c> entry : this.f2889f[i10].entrySet()) {
                c value = entry.getValue();
                Log.d("ExifInterface", "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.j(this.f2891h) + "'");
            }
        }
    }

    private ByteOrder E(b bVar) throws IOException {
        short readShort = bVar.readShort();
        if (readShort == 18761) {
            if (f2872o) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        } else if (readShort == 19789) {
            if (f2872o) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        } else {
            throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
        }
    }

    private void F(byte[] bArr, int i10) throws IOException {
        f fVar = new f(bArr);
        C(fVar);
        G(fVar, i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void G(f fVar, int i10) throws IOException {
        short s10;
        String str;
        boolean z10;
        long j10;
        short s11;
        String str2;
        long j11;
        String str3;
        int i11;
        int i12;
        int[] iArr;
        this.f2890g.add(Integer.valueOf(fVar.f2904c));
        short readShort = fVar.readShort();
        String str4 = "ExifInterface";
        if (f2872o) {
            Log.d(str4, "numberOfDirectoryEntry: " + ((int) readShort));
        }
        if (readShort > 0) {
            char c10 = 0;
            short s12 = 0;
            while (s12 < readShort) {
                int readUnsignedShort = fVar.readUnsignedShort();
                int readUnsignedShort2 = fVar.readUnsignedShort();
                int readInt = fVar.readInt();
                long c11 = fVar.c() + 4;
                d dVar = X[i10].get(Integer.valueOf(readUnsignedShort));
                boolean z11 = f2872o;
                if (z11) {
                    Object[] objArr = new Object[5];
                    objArr[c10] = Integer.valueOf(i10);
                    objArr[1] = Integer.valueOf(readUnsignedShort);
                    objArr[2] = dVar != null ? dVar.f2911b : null;
                    objArr[3] = Integer.valueOf(readUnsignedShort2);
                    objArr[4] = Integer.valueOf(readInt);
                    Log.d(str4, String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", objArr));
                }
                if (dVar != null) {
                    if (readUnsignedShort2 > 0) {
                        if (readUnsignedShort2 < J.length) {
                            if (dVar.a(readUnsignedShort2)) {
                                if (readUnsignedShort2 == 7) {
                                    readUnsignedShort2 = dVar.f2912c;
                                }
                                str = str4;
                                s10 = s12;
                                j10 = readInt * iArr[readUnsignedShort2];
                                if (j10 < 0 || j10 > 2147483647L) {
                                    if (z11) {
                                        Log.d(str, "Skip the tag entry since the number of components is invalid: " + readInt);
                                    }
                                    z10 = false;
                                    if (z10) {
                                        fVar.n(c11);
                                        s11 = readShort;
                                        str2 = str;
                                    } else {
                                        if (j10 > 4) {
                                            int readInt2 = fVar.readInt();
                                            s11 = readShort;
                                            if (z11) {
                                                StringBuilder sb2 = new StringBuilder();
                                                j11 = c11;
                                                sb2.append("seek to data offset: ");
                                                sb2.append(readInt2);
                                                Log.d(str, sb2.toString());
                                            } else {
                                                j11 = c11;
                                            }
                                            if (this.f2887d == 7) {
                                                if ("MakerNote".equals(dVar.f2911b)) {
                                                    this.f2895l = readInt2;
                                                } else if (i10 == 6 && "ThumbnailImage".equals(dVar.f2911b)) {
                                                    this.f2896m = readInt2;
                                                    this.f2897n = readInt;
                                                    c f10 = c.f(6, this.f2891h);
                                                    i11 = readInt;
                                                    c b10 = c.b(this.f2896m, this.f2891h);
                                                    str3 = str;
                                                    c b11 = c.b(this.f2897n, this.f2891h);
                                                    this.f2889f[4].put("Compression", f10);
                                                    this.f2889f[4].put("JPEGInterchangeFormat", b10);
                                                    this.f2889f[4].put("JPEGInterchangeFormatLength", b11);
                                                    fVar.n(readInt2);
                                                }
                                            }
                                            str3 = str;
                                            i11 = readInt;
                                            fVar.n(readInt2);
                                        } else {
                                            s11 = readShort;
                                            j11 = c11;
                                            str3 = str;
                                            i11 = readInt;
                                        }
                                        Integer num = f2868a0.get(Integer.valueOf(readUnsignedShort));
                                        if (z11) {
                                            str2 = str3;
                                            Log.d(str2, "nextIfdType: " + num + " byteCount: " + j10);
                                        } else {
                                            str2 = str3;
                                        }
                                        if (num != null) {
                                            long j12 = -1;
                                            if (readUnsignedShort2 != 3) {
                                                if (readUnsignedShort2 == 4) {
                                                    j12 = fVar.d();
                                                } else if (readUnsignedShort2 == 8) {
                                                    i12 = fVar.readShort();
                                                } else if (readUnsignedShort2 == 9 || readUnsignedShort2 == 13) {
                                                    i12 = fVar.readInt();
                                                }
                                                if (z11) {
                                                    Log.d(str2, String.format("Offset: %d, tagName: %s", Long.valueOf(j12), dVar.f2911b));
                                                }
                                                if (j12 <= 0) {
                                                    if (!this.f2890g.contains(Integer.valueOf((int) j12))) {
                                                        fVar.n(j12);
                                                        G(fVar, num.intValue());
                                                    } else if (z11) {
                                                        Log.d(str2, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j12 + ")");
                                                    }
                                                } else if (z11) {
                                                    Log.d(str2, "Skip jump into the IFD since its offset is invalid: " + j12);
                                                }
                                                fVar.n(j11);
                                            } else {
                                                i12 = fVar.readUnsignedShort();
                                            }
                                            j12 = i12;
                                            if (z11) {
                                            }
                                            if (j12 <= 0) {
                                            }
                                            fVar.n(j11);
                                        } else {
                                            long j13 = j11;
                                            byte[] bArr = new byte[(int) j10];
                                            fVar.readFully(bArr);
                                            c cVar = new c(readUnsignedShort2, i11, fVar.c() + this.f2894k, bArr);
                                            this.f2889f[i10].put(dVar.f2911b, cVar);
                                            if ("DNGVersion".equals(dVar.f2911b)) {
                                                this.f2887d = 3;
                                            }
                                            if ((("Make".equals(dVar.f2911b) || "Model".equals(dVar.f2911b)) && cVar.j(this.f2891h).contains("PENTAX")) || ("Compression".equals(dVar.f2911b) && cVar.i(this.f2891h) == 65535)) {
                                                this.f2887d = 8;
                                            }
                                            if (fVar.c() != j13) {
                                                fVar.n(j13);
                                            }
                                        }
                                    }
                                    s12 = (short) (s10 + 1);
                                    str4 = str2;
                                    readShort = s11;
                                    c10 = 0;
                                } else {
                                    z10 = true;
                                    if (z10) {
                                    }
                                    s12 = (short) (s10 + 1);
                                    str4 = str2;
                                    readShort = s11;
                                    c10 = 0;
                                }
                            } else if (z11) {
                                Log.d(str4, "Skip the tag entry since data format (" + I[readUnsignedShort2] + ") is unexpected for tag: " + dVar.f2911b);
                            }
                        }
                    }
                    str = str4;
                    s10 = s12;
                    if (z11) {
                        Log.d(str, "Skip the tag entry since data format is invalid: " + readUnsignedShort2);
                    }
                    j10 = 0;
                    z10 = false;
                    if (z10) {
                    }
                    s12 = (short) (s10 + 1);
                    str4 = str2;
                    readShort = s11;
                    c10 = 0;
                } else if (z11) {
                    Log.d(str4, "Skip the tag entry since tag number is not defined: " + readUnsignedShort);
                }
                str = str4;
                s10 = s12;
                j10 = 0;
                z10 = false;
                if (z10) {
                }
                s12 = (short) (s10 + 1);
                str4 = str2;
                readShort = s11;
                c10 = 0;
            }
            String str5 = str4;
            int readInt3 = fVar.readInt();
            boolean z12 = f2872o;
            if (z12) {
                Log.d(str5, String.format("nextIfdOffset: %d", Integer.valueOf(readInt3)));
            }
            long j14 = readInt3;
            if (j14 > 0) {
                if (!this.f2890g.contains(Integer.valueOf(readInt3))) {
                    fVar.n(j14);
                    if (this.f2889f[4].isEmpty()) {
                        G(fVar, 4);
                    } else if (this.f2889f[5].isEmpty()) {
                        G(fVar, 5);
                    }
                } else if (z12) {
                    Log.d(str5, "Stop reading file since re-reading an IFD may cause an infinite loop: " + readInt3);
                }
            } else if (z12) {
                Log.d(str5, "Stop reading file since a wrong offset may cause an infinite loop: " + readInt3);
            }
        }
    }

    private void H(int i10, String str, String str2) {
        if (!this.f2889f[i10].isEmpty() && this.f2889f[i10].get(str) != null) {
            HashMap<String, c>[] hashMapArr = this.f2889f;
            hashMapArr[i10].put(str2, hashMapArr[i10].get(str));
            this.f2889f[i10].remove(str);
        }
    }

    private void I(f fVar, int i10) throws IOException {
        c cVar = this.f2889f[i10].get("ImageLength");
        c cVar2 = this.f2889f[i10].get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            c cVar3 = this.f2889f[i10].get("JPEGInterchangeFormat");
            c cVar4 = this.f2889f[i10].get("JPEGInterchangeFormatLength");
            if (cVar3 != null && cVar4 != null) {
                int i11 = cVar3.i(this.f2891h);
                int i12 = cVar3.i(this.f2891h);
                fVar.n(i11);
                byte[] bArr = new byte[i12];
                fVar.read(bArr);
                f(new b(bArr), i11, i10);
            }
        }
    }

    private void J(b bVar) throws IOException {
        HashMap<String, c> hashMap = this.f2889f[4];
        c cVar = hashMap.get("Compression");
        if (cVar != null) {
            int i10 = cVar.i(this.f2891h);
            this.f2893j = i10;
            if (i10 != 1) {
                if (i10 == 6) {
                    o(bVar, hashMap);
                    return;
                } else if (i10 != 7) {
                    return;
                }
            }
            if (y(hashMap)) {
                p(bVar, hashMap);
                return;
            }
            return;
        }
        this.f2893j = 6;
        o(bVar, hashMap);
    }

    private static boolean K(int i10) {
        return (i10 == 4 || i10 == 9 || i10 == 13 || i10 == 14) ? false : true;
    }

    private void L(int i10, int i11) throws IOException {
        if (!this.f2889f[i10].isEmpty() && !this.f2889f[i11].isEmpty()) {
            c cVar = this.f2889f[i10].get("ImageLength");
            c cVar2 = this.f2889f[i10].get("ImageWidth");
            c cVar3 = this.f2889f[i11].get("ImageLength");
            c cVar4 = this.f2889f[i11].get("ImageWidth");
            if (cVar == null || cVar2 == null) {
                if (f2872o) {
                    Log.d("ExifInterface", "First image does not contain valid size information");
                }
            } else if (cVar3 != null && cVar4 != null) {
                int i12 = cVar.i(this.f2891h);
                int i13 = cVar2.i(this.f2891h);
                int i14 = cVar3.i(this.f2891h);
                int i15 = cVar4.i(this.f2891h);
                if (i12 < i14 && i13 < i15) {
                    HashMap<String, c>[] hashMapArr = this.f2889f;
                    HashMap<String, c> hashMap = hashMapArr[i10];
                    hashMapArr[i10] = hashMapArr[i11];
                    hashMapArr[i11] = hashMap;
                }
            } else if (f2872o) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
            }
        } else if (f2872o) {
            Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
        }
    }

    private void M(f fVar, int i10) throws IOException {
        c cVar;
        c cVar2;
        c cVar3 = this.f2889f[i10].get("DefaultCropSize");
        c cVar4 = this.f2889f[i10].get("SensorTopBorder");
        c cVar5 = this.f2889f[i10].get("SensorLeftBorder");
        c cVar6 = this.f2889f[i10].get("SensorBottomBorder");
        c cVar7 = this.f2889f[i10].get("SensorRightBorder");
        if (cVar3 != null) {
            if (cVar3.f2906a == 5) {
                e[] eVarArr = (e[]) cVar3.k(this.f2891h);
                if (eVarArr == null || eVarArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(eVarArr));
                    return;
                }
                cVar2 = c.d(eVarArr[0], this.f2891h);
                cVar = c.d(eVarArr[1], this.f2891h);
            } else {
                int[] iArr = (int[]) cVar3.k(this.f2891h);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                cVar2 = c.f(iArr[0], this.f2891h);
                cVar = c.f(iArr[1], this.f2891h);
            }
            this.f2889f[i10].put("ImageWidth", cVar2);
            this.f2889f[i10].put("ImageLength", cVar);
        } else if (cVar4 == null || cVar5 == null || cVar6 == null || cVar7 == null) {
            I(fVar, i10);
        } else {
            int i11 = cVar4.i(this.f2891h);
            int i12 = cVar6.i(this.f2891h);
            int i13 = cVar7.i(this.f2891h);
            int i14 = cVar5.i(this.f2891h);
            if (i12 > i11 && i13 > i14) {
                c f10 = c.f(i12 - i11, this.f2891h);
                c f11 = c.f(i13 - i14, this.f2891h);
                this.f2889f[i10].put("ImageLength", f10);
                this.f2889f[i10].put("ImageWidth", f11);
            }
        }
    }

    private void N() throws IOException {
        L(0, 5);
        L(0, 4);
        L(5, 4);
        c cVar = this.f2889f[1].get("PixelXDimension");
        c cVar2 = this.f2889f[1].get("PixelYDimension");
        if (!(cVar == null || cVar2 == null)) {
            this.f2889f[0].put("ImageWidth", cVar);
            this.f2889f[0].put("ImageLength", cVar2);
        }
        if (this.f2889f[4].isEmpty() && z(this.f2889f[5])) {
            HashMap<String, c>[] hashMapArr = this.f2889f;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!z(this.f2889f[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        H(0, "ThumbnailOrientation", "Orientation");
        H(0, "ThumbnailImageLength", "ImageLength");
        H(0, "ThumbnailImageWidth", "ImageWidth");
        H(5, "ThumbnailOrientation", "Orientation");
        H(5, "ThumbnailImageLength", "ImageLength");
        H(5, "ThumbnailImageWidth", "ImageWidth");
        H(4, "Orientation", "ThumbnailOrientation");
        H(4, "ImageLength", "ThumbnailImageLength");
        H(4, "ImageWidth", "ThumbnailImageWidth");
    }

    private void a() {
        String b10 = b("DateTimeOriginal");
        if (b10 != null && b("DateTime") == null) {
            this.f2889f[0].put("DateTime", c.a(b10));
        }
        if (b("ImageWidth") == null) {
            this.f2889f[0].put("ImageWidth", c.b(0L, this.f2891h));
        }
        if (b("ImageLength") == null) {
            this.f2889f[0].put("ImageLength", c.b(0L, this.f2891h));
        }
        if (b("Orientation") == null) {
            this.f2889f[0].put("Orientation", c.b(0L, this.f2891h));
        }
        if (b("LightSource") == null) {
            this.f2889f[1].put("LightSource", c.b(0L, this.f2891h));
        }
    }

    private c d(String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        if ("ISOSpeedRatings".equals(str)) {
            if (f2872o) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i10 = 0; i10 < V.length; i10++) {
            c cVar = this.f2889f[i10].get(str);
            if (cVar != null) {
                return cVar;
            }
        }
        return null;
    }

    private void e(f fVar) throws IOException {
        String str;
        String str2;
        if (Build.VERSION.SDK_INT >= 28) {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    b.C0030b.a(mediaMetadataRetriever, new C0029a(this, fVar));
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(33);
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(34);
                    String extractMetadata3 = mediaMetadataRetriever.extractMetadata(26);
                    String extractMetadata4 = mediaMetadataRetriever.extractMetadata(17);
                    String str3 = null;
                    if ("yes".equals(extractMetadata3)) {
                        str3 = mediaMetadataRetriever.extractMetadata(29);
                        str2 = mediaMetadataRetriever.extractMetadata(30);
                        str = mediaMetadataRetriever.extractMetadata(31);
                    } else if ("yes".equals(extractMetadata4)) {
                        str3 = mediaMetadataRetriever.extractMetadata(18);
                        str2 = mediaMetadataRetriever.extractMetadata(19);
                        str = mediaMetadataRetriever.extractMetadata(24);
                    } else {
                        str2 = null;
                        str = null;
                    }
                    if (str3 != null) {
                        this.f2889f[0].put("ImageWidth", c.f(Integer.parseInt(str3), this.f2891h));
                    }
                    if (str2 != null) {
                        this.f2889f[0].put("ImageLength", c.f(Integer.parseInt(str2), this.f2891h));
                    }
                    if (str != null) {
                        int i10 = 1;
                        int parseInt = Integer.parseInt(str);
                        if (parseInt == 90) {
                            i10 = 6;
                        } else if (parseInt == 180) {
                            i10 = 3;
                        } else if (parseInt == 270) {
                            i10 = 8;
                        }
                        this.f2889f[0].put("Orientation", c.f(i10, this.f2891h));
                    }
                    if (!(extractMetadata == null || extractMetadata2 == null)) {
                        int parseInt2 = Integer.parseInt(extractMetadata);
                        int parseInt3 = Integer.parseInt(extractMetadata2);
                        if (parseInt3 > 6) {
                            fVar.n(parseInt2);
                            byte[] bArr = new byte[6];
                            if (fVar.read(bArr) == 6) {
                                int i11 = parseInt2 + 6;
                                int i12 = parseInt3 - 6;
                                if (Arrays.equals(bArr, f2870c0)) {
                                    byte[] bArr2 = new byte[i12];
                                    if (fVar.read(bArr2) == i12) {
                                        this.f2894k = i11;
                                        F(bArr2, 0);
                                    } else {
                                        throw new IOException("Can't read exif");
                                    }
                                } else {
                                    throw new IOException("Invalid identifier");
                                }
                            } else {
                                throw new IOException("Can't read identifier");
                            }
                        } else {
                            throw new IOException("Invalid exif length");
                        }
                    }
                    if (f2872o) {
                        Log.d("ExifInterface", "Heif meta: " + str3 + "x" + str2 + ", rotation " + str);
                    }
                } catch (RuntimeException unused) {
                    throw new UnsupportedOperationException("Failed to read EXIF from HEIF file. Given stream is either malformed or unsupported.");
                }
            } finally {
                mediaMetadataRetriever.release();
            }
        } else {
            throw new UnsupportedOperationException("Reading EXIF from HEIF files is supported from SDK 28 and above");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0193, code lost:
        r21.h(r20.f2891h);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0198, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017d A[LOOP:0: B:10:0x0038->B:62:0x017d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0187 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(b bVar, int i10, int i11) throws IOException {
        byte readByte;
        byte readByte2;
        String str;
        String str2 = "ExifInterface";
        if (f2872o) {
            Log.d(str2, "getJpegAttributes starting with: " + bVar);
        }
        bVar.h(ByteOrder.BIG_ENDIAN);
        byte b10 = -1;
        if (bVar.readByte() != -1) {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        } else if (bVar.readByte() == -40) {
            int i12 = 2;
            int i13 = 2;
            while (true) {
                if (bVar.readByte() == b10) {
                    int i14 = i13 + 1;
                    byte readByte3 = bVar.readByte();
                    boolean z10 = f2872o;
                    if (z10) {
                        Log.d(str2, "Found JPEG segment indicator: " + Integer.toHexString(readByte3 & 255));
                    }
                    int i15 = i14 + 1;
                    if (readByte3 != -39 && readByte3 != -38) {
                        int readUnsignedShort = bVar.readUnsignedShort() - i12;
                        int i16 = i15 + i12;
                        if (z10) {
                            Log.d(str2, "JPEG segment: " + Integer.toHexString(readByte3 & 255) + " (length: " + (readUnsignedShort + 2) + ")");
                        }
                        if (readUnsignedShort >= 0) {
                            if (readByte3 == -31) {
                                byte[] bArr = new byte[readUnsignedShort];
                                bVar.readFully(bArr);
                                i16 += readUnsignedShort;
                                byte[] bArr2 = f2870c0;
                                if (androidx.exifinterface.media.b.c(bArr, bArr2)) {
                                    byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr2.length, readUnsignedShort);
                                    this.f2894k = i10 + i16 + bArr2.length;
                                    F(copyOfRange, i11);
                                    J(new b(copyOfRange));
                                } else {
                                    byte[] bArr3 = f2871d0;
                                    if (androidx.exifinterface.media.b.c(bArr, bArr3)) {
                                        int length = i16 + bArr3.length;
                                        byte[] copyOfRange2 = Arrays.copyOfRange(bArr, bArr3.length, readUnsignedShort);
                                        if (b("Xmp") == null) {
                                            str = str2;
                                            this.f2889f[0].put("Xmp", new c(1, copyOfRange2.length, length, copyOfRange2));
                                        }
                                    }
                                }
                                str = str2;
                            } else if (readByte3 != -2) {
                                switch (readByte3) {
                                    default:
                                        switch (readByte3) {
                                            default:
                                                switch (readByte3) {
                                                    default:
                                                        switch (readByte3) {
                                                        }
                                                    case -55:
                                                    case -54:
                                                    case -53:
                                                        bVar.i(1);
                                                        this.f2889f[i11].put(i11 != 4 ? "ImageLength" : "ThumbnailImageLength", c.b(bVar.readUnsignedShort(), this.f2891h));
                                                        this.f2889f[i11].put(i11 != 4 ? "ImageWidth" : "ThumbnailImageWidth", c.b(bVar.readUnsignedShort(), this.f2891h));
                                                        readUnsignedShort -= 5;
                                                        break;
                                                }
                                            case -59:
                                            case -58:
                                            case -57:
                                                break;
                                        }
                                    case -64:
                                    case -63:
                                    case -62:
                                    case -61:
                                        break;
                                }
                                str = str2;
                                if (readUnsignedShort < 0) {
                                    bVar.i(readUnsignedShort);
                                    i13 = i16 + readUnsignedShort;
                                    str2 = str;
                                    i12 = 2;
                                    b10 = -1;
                                } else {
                                    throw new IOException("Invalid length");
                                }
                            } else {
                                byte[] bArr4 = new byte[readUnsignedShort];
                                if (bVar.read(bArr4) == readUnsignedShort) {
                                    if (b("UserComment") == null) {
                                        this.f2889f[1].put("UserComment", c.a(new String(bArr4, f2869b0)));
                                    }
                                    str = str2;
                                } else {
                                    throw new IOException("Invalid exif");
                                }
                            }
                            readUnsignedShort = 0;
                            if (readUnsignedShort < 0) {
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                } else {
                    throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
                }
            }
        } else {
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
    }

    private int g(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (s(bArr)) {
            return 4;
        }
        if (v(bArr)) {
            return 9;
        }
        if (r(bArr)) {
            return 12;
        }
        if (t(bArr)) {
            return 7;
        }
        if (w(bArr)) {
            return 10;
        }
        if (u(bArr)) {
            return 13;
        }
        return A(bArr) ? 14 : 0;
    }

    private void h(f fVar) throws IOException {
        k(fVar);
        c cVar = this.f2889f[1].get("MakerNote");
        if (cVar != null) {
            f fVar2 = new f(cVar.f2909d);
            fVar2.h(this.f2891h);
            byte[] bArr = f2881x;
            byte[] bArr2 = new byte[bArr.length];
            fVar2.readFully(bArr2);
            fVar2.n(0L);
            byte[] bArr3 = f2882y;
            byte[] bArr4 = new byte[bArr3.length];
            fVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                fVar2.n(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                fVar2.n(12L);
            }
            G(fVar2, 6);
            c cVar2 = this.f2889f[7].get("PreviewImageStart");
            c cVar3 = this.f2889f[7].get("PreviewImageLength");
            if (!(cVar2 == null || cVar3 == null)) {
                this.f2889f[5].put("JPEGInterchangeFormat", cVar2);
                this.f2889f[5].put("JPEGInterchangeFormatLength", cVar3);
            }
            c cVar4 = this.f2889f[8].get("AspectFrame");
            if (cVar4 != null) {
                int[] iArr = (int[]) cVar4.k(this.f2891h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i10 = (iArr[2] - iArr[0]) + 1;
                    int i11 = (iArr[3] - iArr[1]) + 1;
                    if (i10 < i11) {
                        int i12 = i10 + i11;
                        i11 = i12 - i11;
                        i10 = i12 - i11;
                    }
                    c f10 = c.f(i10, this.f2891h);
                    c f11 = c.f(i11, this.f2891h);
                    this.f2889f[0].put("ImageWidth", f10);
                    this.f2889f[0].put("ImageLength", f11);
                }
            }
        }
    }

    private void i(b bVar) throws IOException {
        if (f2872o) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.h(ByteOrder.BIG_ENDIAN);
        byte[] bArr = f2883z;
        bVar.i(bArr.length);
        int length = bArr.length + 0;
        while (true) {
            try {
                int readInt = bVar.readInt();
                int i10 = length + 4;
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int i11 = i10 + 4;
                    if (i11 == 16 && !Arrays.equals(bArr2, B)) {
                        throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                    }
                    if (!Arrays.equals(bArr2, C)) {
                        if (Arrays.equals(bArr2, A)) {
                            byte[] bArr3 = new byte[readInt];
                            if (bVar.read(bArr3) == readInt) {
                                int readInt2 = bVar.readInt();
                                CRC32 crc32 = new CRC32();
                                crc32.update(bArr2);
                                crc32.update(bArr3);
                                if (((int) crc32.getValue()) == readInt2) {
                                    this.f2894k = i11;
                                    F(bArr3, 0);
                                    N();
                                    J(new b(bArr3));
                                    return;
                                }
                                throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + readInt2 + ", calculated CRC value: " + crc32.getValue());
                            }
                            throw new IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.b.a(bArr2));
                        }
                        int i12 = readInt + 4;
                        bVar.i(i12);
                        length = i11 + i12;
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void j(b bVar) throws IOException {
        boolean z10 = f2872o;
        if (z10) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.i(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i10 = ByteBuffer.wrap(bArr).getInt();
        int i11 = ByteBuffer.wrap(bArr2).getInt();
        int i12 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i11];
        bVar.i(i10 - bVar.c());
        bVar.read(bArr4);
        f(new b(bArr4), i10, 5);
        bVar.i(i12 - bVar.c());
        bVar.h(ByteOrder.BIG_ENDIAN);
        int readInt = bVar.readInt();
        if (z10) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + readInt);
        }
        for (int i13 = 0; i13 < readInt; i13++) {
            int readUnsignedShort = bVar.readUnsignedShort();
            int readUnsignedShort2 = bVar.readUnsignedShort();
            if (readUnsignedShort == Q.f2910a) {
                short readShort = bVar.readShort();
                short readShort2 = bVar.readShort();
                c f10 = c.f(readShort, this.f2891h);
                c f11 = c.f(readShort2, this.f2891h);
                this.f2889f[0].put("ImageLength", f10);
                this.f2889f[0].put("ImageWidth", f11);
                if (f2872o) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) readShort) + ", width: " + ((int) readShort2));
                    return;
                }
                return;
            }
            bVar.i(readUnsignedShort2);
        }
    }

    private void k(f fVar) throws IOException {
        c cVar;
        C(fVar);
        G(fVar, 0);
        M(fVar, 0);
        M(fVar, 5);
        M(fVar, 4);
        N();
        if (this.f2887d == 8 && (cVar = this.f2889f[1].get("MakerNote")) != null) {
            f fVar2 = new f(cVar.f2909d);
            fVar2.h(this.f2891h);
            fVar2.i(6);
            G(fVar2, 9);
            c cVar2 = this.f2889f[9].get("ColorSpace");
            if (cVar2 != null) {
                this.f2889f[1].put("ColorSpace", cVar2);
            }
        }
    }

    private void l(f fVar) throws IOException {
        if (f2872o) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + fVar);
        }
        k(fVar);
        c cVar = this.f2889f[0].get("JpgFromRaw");
        if (cVar != null) {
            f(new b(cVar.f2909d), (int) cVar.f2908c, 5);
        }
        c cVar2 = this.f2889f[0].get("ISO");
        c cVar3 = this.f2889f[1].get("PhotographicSensitivity");
        if (cVar2 != null && cVar3 == null) {
            this.f2889f[1].put("PhotographicSensitivity", cVar2);
        }
    }

    private void m(f fVar) throws IOException {
        byte[] bArr = f2870c0;
        fVar.i(bArr.length);
        byte[] bArr2 = new byte[fVar.available()];
        fVar.readFully(bArr2);
        this.f2894k = bArr.length;
        F(bArr2, 0);
    }

    private void n(b bVar) throws IOException {
        if (f2872o) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.h(ByteOrder.LITTLE_ENDIAN);
        bVar.i(D.length);
        int readInt = bVar.readInt() + 8;
        byte[] bArr = E;
        bVar.i(bArr.length);
        int length = bArr.length + 8;
        while (true) {
            try {
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) == 4) {
                    int readInt2 = bVar.readInt();
                    int i10 = length + 4 + 4;
                    if (Arrays.equals(F, bArr2)) {
                        byte[] bArr3 = new byte[readInt2];
                        if (bVar.read(bArr3) == readInt2) {
                            this.f2894k = i10;
                            F(bArr3, 0);
                            J(new b(bArr3));
                            return;
                        }
                        throw new IOException("Failed to read given length for given PNG chunk type: " + androidx.exifinterface.media.b.a(bArr2));
                    }
                    if (readInt2 % 2 == 1) {
                        readInt2++;
                    }
                    length = i10 + readInt2;
                    if (length != readInt) {
                        if (length <= readInt) {
                            bVar.i(readInt2);
                        } else {
                            throw new IOException("Encountered WebP file with invalid chunk size");
                        }
                    } else {
                        return;
                    }
                } else {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private void o(b bVar, HashMap hashMap) throws IOException {
        c cVar = (c) hashMap.get("JPEGInterchangeFormat");
        c cVar2 = (c) hashMap.get("JPEGInterchangeFormatLength");
        if (cVar != null && cVar2 != null) {
            int i10 = cVar.i(this.f2891h);
            int i11 = cVar2.i(this.f2891h);
            if (this.f2887d == 7) {
                i10 += this.f2895l;
            }
            if (i10 > 0 && i11 > 0 && this.f2884a == null && this.f2886c == null && this.f2885b == null) {
                bVar.skip(i10);
                bVar.read(new byte[i11]);
            }
            if (f2872o) {
                Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + i10 + ", length: " + i11);
            }
        }
    }

    private void p(b bVar, HashMap hashMap) throws IOException {
        c cVar = (c) hashMap.get("StripOffsets");
        c cVar2 = (c) hashMap.get("StripByteCounts");
        if (cVar != null && cVar2 != null) {
            long[] b10 = androidx.exifinterface.media.b.b(cVar.k(this.f2891h));
            long[] b11 = androidx.exifinterface.media.b.b(cVar2.k(this.f2891h));
            if (b10 == null || b10.length == 0) {
                Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            } else if (b11 == null || b11.length == 0) {
                Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            } else if (b10.length != b11.length) {
                Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            } else {
                long j10 = 0;
                for (long j11 : b11) {
                    j10 += j11;
                }
                byte[] bArr = new byte[(int) j10];
                this.f2892i = true;
                int i10 = 0;
                int i11 = 0;
                for (int i12 = 0; i12 < b10.length; i12++) {
                    int i13 = (int) b10[i12];
                    int i14 = (int) b11[i12];
                    if (i12 < b10.length - 1 && i13 + i14 != b10[i12 + 1]) {
                        this.f2892i = false;
                    }
                    int i15 = i13 - i10;
                    if (i15 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                        return;
                    }
                    long j12 = i15;
                    if (bVar.skip(j12) != j12) {
                        Log.d("ExifInterface", "Failed to skip " + i15 + " bytes.");
                        return;
                    }
                    int i16 = i10 + i15;
                    byte[] bArr2 = new byte[i14];
                    if (bVar.read(bArr2) != i14) {
                        Log.d("ExifInterface", "Failed to read " + i14 + " bytes.");
                        return;
                    }
                    i10 = i16 + i14;
                    System.arraycopy(bArr2, 0, bArr, i11, i14);
                    i11 += i14;
                }
                if (this.f2892i) {
                    long j13 = b10[0];
                }
            }
        }
    }

    private static boolean q(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = f2870c0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i10 = 0;
        while (true) {
            byte[] bArr3 = f2870c0;
            if (i10 >= bArr3.length) {
                return true;
            }
            if (bArr2[i10] != bArr3[i10]) {
                return false;
            }
            i10++;
        }
    }

    private boolean r(byte[] bArr) throws IOException {
        Throwable th2;
        Exception e10;
        b bVar;
        long readInt;
        byte[] bArr2;
        b bVar2 = null;
        try {
            try {
                bVar = new b(bArr);
            } catch (Exception e11) {
                e10 = e11;
            }
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            readInt = bVar.readInt();
            bArr2 = new byte[4];
            bVar.read(bArr2);
        } catch (Exception e12) {
            e10 = e12;
            bVar2 = bVar;
            if (f2872o) {
                Log.d("ExifInterface", "Exception parsing HEIF file type box.", e10);
            }
            if (bVar2 != null) {
                bVar2.close();
            }
            return false;
        } catch (Throwable th4) {
            th2 = th4;
            bVar2 = bVar;
            if (bVar2 != null) {
                bVar2.close();
            }
            throw th2;
        }
        if (!Arrays.equals(bArr2, f2878u)) {
            bVar.close();
            return false;
        }
        long j10 = 16;
        if (readInt == 1) {
            readInt = bVar.readLong();
            if (readInt < 16) {
                bVar.close();
                return false;
            }
        } else {
            j10 = 8;
        }
        if (readInt > bArr.length) {
            readInt = bArr.length;
        }
        long j11 = readInt - j10;
        if (j11 < 8) {
            bVar.close();
            return false;
        }
        byte[] bArr3 = new byte[4];
        boolean z10 = false;
        boolean z11 = false;
        for (long j12 = 0; j12 < j11 / 4; j12++) {
            if (bVar.read(bArr3) != 4) {
                bVar.close();
                return false;
            }
            if (j12 != 1) {
                if (Arrays.equals(bArr3, f2879v)) {
                    z10 = true;
                } else if (Arrays.equals(bArr3, f2880w)) {
                    z11 = true;
                }
                if (z10 && z11) {
                    bVar.close();
                    return true;
                }
            }
        }
        bVar.close();
        return false;
    }

    private static boolean s(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f2877t;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    private boolean t(byte[] bArr) throws IOException {
        Throwable th2;
        boolean z10 = false;
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder E2 = E(bVar2);
                this.f2891h = E2;
                bVar2.h(E2);
                short readShort = bVar2.readShort();
                if (readShort == 20306 || readShort == 21330) {
                    z10 = true;
                }
                bVar2.close();
                return z10;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th3) {
                th2 = th3;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th2;
            }
        } catch (Exception unused2) {
        } catch (Throwable th4) {
            th2 = th4;
        }
    }

    private boolean u(byte[] bArr) throws IOException {
        int i10 = 0;
        while (true) {
            byte[] bArr2 = f2883z;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    private boolean v(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i10 = 0; i10 < bytes.length; i10++) {
            if (bArr[i10] != bytes[i10]) {
                return false;
            }
        }
        return true;
    }

    private boolean w(byte[] bArr) throws IOException {
        Throwable th2;
        boolean z10 = false;
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder E2 = E(bVar2);
                this.f2891h = E2;
                bVar2.h(E2);
                if (bVar2.readShort() == 85) {
                    z10 = true;
                }
                bVar2.close();
                return z10;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th3) {
                th2 = th3;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th2;
            }
        } catch (Exception unused2) {
        } catch (Throwable th4) {
            th2 = th4;
        }
    }

    private static boolean x(FileDescriptor fileDescriptor) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                b.a.c(fileDescriptor, 0L, OsConstants.SEEK_CUR);
                return true;
            } catch (Exception unused) {
                if (f2872o) {
                    Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
                }
            }
        }
        return false;
    }

    private boolean y(HashMap hashMap) throws IOException {
        c cVar;
        int i10;
        c cVar2 = (c) hashMap.get("BitsPerSample");
        if (cVar2 != null) {
            int[] iArr = (int[]) cVar2.k(this.f2891h);
            int[] iArr2 = f2875r;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.f2887d == 3 && (cVar = (c) hashMap.get("PhotometricInterpretation")) != null && (((i10 = cVar.i(this.f2891h)) == 1 && Arrays.equals(iArr, f2876s)) || (i10 == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!f2872o) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    private boolean z(HashMap hashMap) throws IOException {
        c cVar = (c) hashMap.get("ImageLength");
        c cVar2 = (c) hashMap.get("ImageWidth");
        if (cVar == null || cVar2 == null) {
            return false;
        }
        return cVar.i(this.f2891h) <= 512 && cVar2.i(this.f2891h) <= 512;
    }

    public String b(String str) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        c d10 = d(str);
        if (d10 != null) {
            if (!Z.contains(str)) {
                return d10.j(this.f2891h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i10 = d10.f2906a;
                if (i10 == 5 || i10 == 10) {
                    e[] eVarArr = (e[]) d10.k(this.f2891h);
                    if (eVarArr != null && eVarArr.length == 3) {
                        return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) eVarArr[0].f2914a) / ((float) eVarArr[0].f2915b))), Integer.valueOf((int) (((float) eVarArr[1].f2914a) / ((float) eVarArr[1].f2915b))), Integer.valueOf((int) (((float) eVarArr[2].f2914a) / ((float) eVarArr[2].f2915b))));
                    }
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(eVarArr));
                    return null;
                }
                Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + d10.f2906a);
                return null;
            }
            try {
                return Double.toString(d10.h(this.f2891h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public int c(String str, int i10) {
        Objects.requireNonNull(str, "tag shouldn't be null");
        c d10 = d(str);
        if (d10 == null) {
            return i10;
        }
        try {
            return d10.i(this.f2891h);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ExifInterface.java */
    /* loaded from: classes.dex */
    public static class f extends b {
        f(byte[] bArr) throws IOException {
            super(bArr);
            this.f2902a.mark(Integer.MAX_VALUE);
        }

        public void n(long j10) throws IOException {
            int i10 = this.f2904c;
            if (i10 > j10) {
                this.f2904c = 0;
                this.f2902a.reset();
            } else {
                j10 -= i10;
            }
            i((int) j10);
        }

        f(InputStream inputStream) throws IOException {
            super(inputStream);
            if (inputStream.markSupported()) {
                this.f2902a.mark(Integer.MAX_VALUE);
                return;
            }
            throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
        }
    }

    public a(InputStream inputStream, int i10) throws IOException {
        d[][] dVarArr = V;
        this.f2889f = new HashMap[dVarArr.length];
        this.f2890g = new HashSet(dVarArr.length);
        this.f2891h = ByteOrder.BIG_ENDIAN;
        Objects.requireNonNull(inputStream, "inputStream cannot be null");
        this.f2884a = null;
        if (i10 == 1) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, f2870c0.length);
            if (!q(bufferedInputStream)) {
                Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                return;
            }
            this.f2888e = true;
            this.f2886c = null;
            this.f2885b = null;
            inputStream = bufferedInputStream;
        } else if (inputStream instanceof AssetManager.AssetInputStream) {
            this.f2886c = (AssetManager.AssetInputStream) inputStream;
            this.f2885b = null;
        } else {
            if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                if (x(fileInputStream.getFD())) {
                    this.f2886c = null;
                    this.f2885b = fileInputStream.getFD();
                }
            }
            this.f2886c = null;
            this.f2885b = null;
        }
        B(inputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ExifInterface.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int f2910a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2911b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2912c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2913d;

        d(String str, int i10, int i11) {
            this.f2911b = str;
            this.f2910a = i10;
            this.f2912c = i11;
            this.f2913d = -1;
        }

        boolean a(int i10) {
            int i11;
            int i12 = this.f2912c;
            if (i12 == 7 || i10 == 7 || i12 == i10 || (i11 = this.f2913d) == i10) {
                return true;
            }
            if ((i12 == 4 || i11 == 4) && i10 == 3) {
                return true;
            }
            if ((i12 == 9 || i11 == 9) && i10 == 8) {
                return true;
            }
            return (i12 == 12 || i11 == 12) && i10 == 11;
        }

        d(String str, int i10, int i11, int i12) {
            this.f2911b = str;
            this.f2910a = i10;
            this.f2912c = i11;
            this.f2913d = i12;
        }
    }
}
