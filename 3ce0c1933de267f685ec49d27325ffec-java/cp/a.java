package cp;

import android.util.Log;
import com.google.gson.e;
import dp.b;
import dp.c;
import dp.d;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
/* compiled from: ArchiveInputStream.java */
/* loaded from: classes3.dex */
public class a extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private final ZipInputStream f24680a;

    /* renamed from: c  reason: collision with root package name */
    private b f24682c;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f24684e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f24685f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f24686g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f24687h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f24688i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f24689j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f24690k;

    /* renamed from: l  reason: collision with root package name */
    private int f24691l;

    /* renamed from: n  reason: collision with root package name */
    private int f24693n;

    /* renamed from: o  reason: collision with root package name */
    private int f24694o;

    /* renamed from: p  reason: collision with root package name */
    private int f24695p;

    /* renamed from: r  reason: collision with root package name */
    private byte[] f24697r;

    /* renamed from: s  reason: collision with root package name */
    private int f24698s;

    /* renamed from: d  reason: collision with root package name */
    private CRC32 f24683d = new CRC32();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, byte[]> f24681b = new HashMap();

    /* renamed from: q  reason: collision with root package name */
    private int f24696q = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f24692m = 0;

    /* JADX WARN: Removed duplicated region for block: B:79:0x020d A[Catch: all -> 0x027c, TryCatch #0 {all -> 0x027c, blocks: (B:3:0x001d, B:5:0x0025, B:11:0x0033, B:13:0x0059, B:14:0x0060, B:15:0x007d, B:17:0x007f, B:20:0x0089, B:22:0x008d, B:24:0x0091, B:26:0x00b7, B:27:0x00be, B:28:0x00db, B:29:0x00dc, B:30:0x00e3, B:31:0x00e4, B:34:0x00ee, B:36:0x00f2, B:38:0x0118, B:39:0x011f, B:40:0x013c, B:41:0x013d, B:44:0x0147, B:46:0x014b, B:48:0x014f, B:50:0x0153, B:52:0x0179, B:53:0x018a, B:54:0x01a7, B:55:0x01a8, B:56:0x01af, B:60:0x01b5, B:61:0x01bc, B:63:0x01bf, B:65:0x01c3, B:67:0x01d1, B:68:0x01dd, B:70:0x01e1, B:77:0x01ff, B:79:0x020d, B:80:0x0219, B:82:0x021d, B:84:0x0231, B:86:0x0234, B:88:0x0242, B:89:0x024e, B:91:0x0252, B:94:0x0267, B:97:0x0274, B:98:0x027b), top: B:102:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x021d A[Catch: all -> 0x027c, TryCatch #0 {all -> 0x027c, blocks: (B:3:0x001d, B:5:0x0025, B:11:0x0033, B:13:0x0059, B:14:0x0060, B:15:0x007d, B:17:0x007f, B:20:0x0089, B:22:0x008d, B:24:0x0091, B:26:0x00b7, B:27:0x00be, B:28:0x00db, B:29:0x00dc, B:30:0x00e3, B:31:0x00e4, B:34:0x00ee, B:36:0x00f2, B:38:0x0118, B:39:0x011f, B:40:0x013c, B:41:0x013d, B:44:0x0147, B:46:0x014b, B:48:0x014f, B:50:0x0153, B:52:0x0179, B:53:0x018a, B:54:0x01a7, B:55:0x01a8, B:56:0x01af, B:60:0x01b5, B:61:0x01bc, B:63:0x01bf, B:65:0x01c3, B:67:0x01d1, B:68:0x01dd, B:70:0x01e1, B:77:0x01ff, B:79:0x020d, B:80:0x0219, B:82:0x021d, B:84:0x0231, B:86:0x0234, B:88:0x0242, B:89:0x024e, B:91:0x0252, B:94:0x0267, B:97:0x0274, B:98:0x027b), top: B:102:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0242 A[Catch: all -> 0x027c, TryCatch #0 {all -> 0x027c, blocks: (B:3:0x001d, B:5:0x0025, B:11:0x0033, B:13:0x0059, B:14:0x0060, B:15:0x007d, B:17:0x007f, B:20:0x0089, B:22:0x008d, B:24:0x0091, B:26:0x00b7, B:27:0x00be, B:28:0x00db, B:29:0x00dc, B:30:0x00e3, B:31:0x00e4, B:34:0x00ee, B:36:0x00f2, B:38:0x0118, B:39:0x011f, B:40:0x013c, B:41:0x013d, B:44:0x0147, B:46:0x014b, B:48:0x014f, B:50:0x0153, B:52:0x0179, B:53:0x018a, B:54:0x01a7, B:55:0x01a8, B:56:0x01af, B:60:0x01b5, B:61:0x01bc, B:63:0x01bf, B:65:0x01c3, B:67:0x01d1, B:68:0x01dd, B:70:0x01e1, B:77:0x01ff, B:79:0x020d, B:80:0x0219, B:82:0x021d, B:84:0x0231, B:86:0x0234, B:88:0x0242, B:89:0x024e, B:91:0x0252, B:94:0x0267, B:97:0x0274, B:98:0x027b), top: B:102:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0252 A[Catch: all -> 0x027c, TryCatch #0 {all -> 0x027c, blocks: (B:3:0x001d, B:5:0x0025, B:11:0x0033, B:13:0x0059, B:14:0x0060, B:15:0x007d, B:17:0x007f, B:20:0x0089, B:22:0x008d, B:24:0x0091, B:26:0x00b7, B:27:0x00be, B:28:0x00db, B:29:0x00dc, B:30:0x00e3, B:31:0x00e4, B:34:0x00ee, B:36:0x00f2, B:38:0x0118, B:39:0x011f, B:40:0x013c, B:41:0x013d, B:44:0x0147, B:46:0x014b, B:48:0x014f, B:50:0x0153, B:52:0x0179, B:53:0x018a, B:54:0x01a7, B:55:0x01a8, B:56:0x01af, B:60:0x01b5, B:61:0x01bc, B:63:0x01bf, B:65:0x01c3, B:67:0x01d1, B:68:0x01dd, B:70:0x01e1, B:77:0x01ff, B:79:0x020d, B:80:0x0219, B:82:0x021d, B:84:0x0231, B:86:0x0234, B:88:0x0242, B:89:0x024e, B:91:0x0252, B:94:0x0267, B:97:0x0274, B:98:0x027b), top: B:102:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0274 A[Catch: all -> 0x027c, TRY_ENTER, TryCatch #0 {all -> 0x027c, blocks: (B:3:0x001d, B:5:0x0025, B:11:0x0033, B:13:0x0059, B:14:0x0060, B:15:0x007d, B:17:0x007f, B:20:0x0089, B:22:0x008d, B:24:0x0091, B:26:0x00b7, B:27:0x00be, B:28:0x00db, B:29:0x00dc, B:30:0x00e3, B:31:0x00e4, B:34:0x00ee, B:36:0x00f2, B:38:0x0118, B:39:0x011f, B:40:0x013c, B:41:0x013d, B:44:0x0147, B:46:0x014b, B:48:0x014f, B:50:0x0153, B:52:0x0179, B:53:0x018a, B:54:0x01a7, B:55:0x01a8, B:56:0x01af, B:60:0x01b5, B:61:0x01bc, B:63:0x01bf, B:65:0x01c3, B:67:0x01d1, B:68:0x01dd, B:70:0x01e1, B:77:0x01ff, B:79:0x020d, B:80:0x0219, B:82:0x021d, B:84:0x0231, B:86:0x0234, B:88:0x0242, B:89:0x024e, B:91:0x0252, B:94:0x0267, B:97:0x0274, B:98:0x027b), top: B:102:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(InputStream inputStream, int i10, int i11) throws IOException {
        boolean z10;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        boolean z11;
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        this.f24680a = zipInputStream;
        try {
            w(i10);
            b bVar = this.f24682c;
            boolean z12 = true;
            if (bVar != null) {
                if (bVar.a() == null || (i11 != 0 && (i11 & 4) <= 0)) {
                    z11 = false;
                } else {
                    dp.a a10 = this.f24682c.a();
                    this.f24684e = this.f24681b.get(a10.a());
                    this.f24689j = this.f24681b.get(a10.b());
                    byte[] bArr5 = this.f24684e;
                    if (bArr5 != null) {
                        this.f24695p = bArr5.length;
                        this.f24690k = bArr5;
                        z11 = true;
                    } else {
                        throw new IOException("Application file " + a10.a() + " not found.");
                    }
                }
                if (this.f24682c.b() != null && (i11 == 0 || (i11 & 2) > 0)) {
                    if (this.f24688i == null) {
                        dp.a b10 = this.f24682c.b();
                        this.f24686g = this.f24681b.get(b10.a());
                        this.f24688i = this.f24681b.get(b10.b());
                        byte[] bArr6 = this.f24686g;
                        if (bArr6 != null) {
                            this.f24694o = bArr6.length;
                            this.f24690k = bArr6;
                            z11 = true;
                        } else {
                            throw new IOException("Bootloader file " + b10.a() + " not found.");
                        }
                    } else {
                        throw new IOException("Manifest: softdevice and bootloader specified. Use softdevice_bootloader instead.");
                    }
                }
                if (this.f24682c.d() != null && (i11 == 0 || (i11 & 1) > 0)) {
                    dp.a d10 = this.f24682c.d();
                    this.f24685f = this.f24681b.get(d10.a());
                    this.f24688i = this.f24681b.get(d10.b());
                    byte[] bArr7 = this.f24685f;
                    if (bArr7 != null) {
                        this.f24693n = bArr7.length;
                        this.f24690k = bArr7;
                        z11 = true;
                    } else {
                        throw new IOException("SoftDevice file " + d10.a() + " not found.");
                    }
                }
                if (this.f24682c.c() == null || (i11 != 0 && ((i11 & 1) <= 0 || (i11 & 2) <= 0))) {
                    z12 = z11;
                } else if (this.f24688i == null) {
                    d c10 = this.f24682c.c();
                    this.f24687h = this.f24681b.get(c10.a());
                    this.f24688i = this.f24681b.get(c10.b());
                    if (this.f24687h != null) {
                        this.f24693n = c10.d();
                        this.f24694o = c10.c();
                        this.f24690k = this.f24687h;
                    } else {
                        throw new IOException("File " + c10.a() + " not found.");
                    }
                } else {
                    throw new IOException("Manifest: The softdevice_bootloader may not be used together with softdevice or bootloader.");
                }
                if (!z12) {
                    throw new IOException("Manifest file must specify at least one file.");
                }
            } else {
                if (i11 == 0 || (i11 & 4) > 0) {
                    byte[] bArr8 = this.f24681b.get("application.hex");
                    this.f24684e = bArr8;
                    if (bArr8 == null) {
                        this.f24684e = this.f24681b.get("application.bin");
                    }
                    byte[] bArr9 = this.f24684e;
                    if (bArr9 != null) {
                        this.f24695p = bArr9.length;
                        this.f24689j = this.f24681b.get("application.dat");
                        this.f24690k = this.f24684e;
                        z10 = true;
                        if (i11 != 0 || (i11 & 2) > 0) {
                            bArr3 = this.f24681b.get("bootloader.hex");
                            this.f24686g = bArr3;
                            if (bArr3 == null) {
                                this.f24686g = this.f24681b.get("bootloader.bin");
                            }
                            bArr4 = this.f24686g;
                            if (bArr4 != null) {
                                this.f24694o = bArr4.length;
                                this.f24688i = this.f24681b.get("system.dat");
                                this.f24690k = this.f24686g;
                                z10 = true;
                            }
                        }
                        if (i11 != 0 || (i11 & 1) > 0) {
                            bArr = this.f24681b.get("softdevice.hex");
                            this.f24685f = bArr;
                            if (bArr == null) {
                                this.f24685f = this.f24681b.get("softdevice.bin");
                            }
                            bArr2 = this.f24685f;
                            if (bArr2 != null) {
                                this.f24693n = bArr2.length;
                                this.f24688i = this.f24681b.get("system.dat");
                                this.f24690k = this.f24685f;
                                if (!z12) {
                                    throw new IOException("The ZIP file must contain an Application, a Soft Device and/or a Bootloader.");
                                }
                            }
                        }
                        z12 = z10;
                        if (!z12) {
                        }
                    }
                }
                z10 = false;
                if (i11 != 0) {
                }
                bArr3 = this.f24681b.get("bootloader.hex");
                this.f24686g = bArr3;
                if (bArr3 == null) {
                }
                bArr4 = this.f24686g;
                if (bArr4 != null) {
                }
                if (i11 != 0) {
                }
                bArr = this.f24681b.get("softdevice.hex");
                this.f24685f = bArr;
                if (bArr == null) {
                }
                bArr2 = this.f24685f;
                if (bArr2 != null) {
                }
                z12 = z10;
                if (!z12) {
                }
            }
            mark(0);
            this.f24691l = o();
            zipInputStream.close();
        } catch (Throwable th2) {
            this.f24691l = o();
            this.f24680a.close();
            throw th2;
        }
    }

    private byte[] O() {
        byte[] bArr;
        byte[] bArr2 = this.f24690k;
        if (bArr2 != this.f24685f || (bArr = this.f24686g) == null || (this.f24691l & 2) <= 0) {
            bArr = this.f24684e;
            if (bArr2 == bArr || bArr == null || (this.f24691l & 4) <= 0) {
                bArr = null;
                this.f24690k = null;
            } else {
                this.f24690k = bArr;
            }
        } else {
            this.f24690k = bArr;
        }
        this.f24692m = 0;
        return bArr;
    }

    private void w(int i10) throws IOException {
        byte[] bArr = new byte[1024];
        String str = null;
        while (true) {
            ZipEntry nextEntry = this.f24680a.getNextEntry();
            if (nextEntry == null) {
                break;
            }
            String name = nextEntry.getName();
            if (nextEntry.isDirectory()) {
                Log.w("DfuArchiveInputStream", "A directory found in the ZIP: " + name + "!");
            } else {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = this.f24680a.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (name.toLowerCase(Locale.US).endsWith("hex")) {
                    b bVar = new b(byteArray, i10);
                    byteArray = new byte[bVar.available()];
                    bVar.read(byteArray);
                    bVar.close();
                }
                if ("manifest.json".equals(name)) {
                    str = new String(byteArray, "UTF-8");
                } else {
                    this.f24681b.put(name, byteArray);
                }
            }
        }
        if (this.f24681b.isEmpty()) {
            throw new FileNotFoundException("No files found in the ZIP. Check if the URI provided is valid and the ZIP contains required files on root level, not in a directory.");
        } else if (str != null) {
            b a10 = ((c) new e().j(str, c.class)).a();
            this.f24682c = a10;
            if (a10 == null) {
                Log.w("DfuArchiveInputStream", "Manifest failed to be parsed. Did you add \n-keep class no.nordicsemi.android.dfu.** { *; }\nto your proguard rules?");
            }
        } else {
            Log.w("DfuArchiveInputStream", "Manifest not found in the ZIP. It is recommended to use a distribution file created with: https://github.com/NordicSemiconductor/pc-nrfutil/ (for Legacy DFU use version 0.5.x)");
        }
    }

    private int x(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = this.f24690k;
        int length = bArr2.length;
        int i12 = this.f24692m;
        int i13 = length - i12;
        if (i11 > i13) {
            i11 = i13;
        }
        System.arraycopy(bArr2, i12, bArr, i10, i11);
        this.f24692m += i11;
        this.f24696q += i11;
        this.f24683d.update(bArr, i10, i11);
        return i11;
    }

    public int E(int i10) {
        byte[] bArr;
        this.f24691l = i10;
        int i11 = i10 & 4;
        if (i11 > 0 && this.f24684e == null) {
            this.f24691l = i10 & (-5);
        }
        int i12 = i10 & 3;
        if (i12 == 3) {
            if (this.f24685f == null && this.f24687h == null) {
                this.f24691l &= -2;
            }
            if (this.f24686g == null && this.f24687h == null) {
                this.f24691l &= -2;
            }
        } else if (this.f24687h != null) {
            this.f24691l &= -4;
        }
        if (i12 > 0 && (bArr = this.f24687h) != null) {
            this.f24690k = bArr;
        } else if ((i10 & 1) > 0) {
            this.f24690k = this.f24685f;
        } else if ((i10 & 2) > 0) {
            this.f24690k = this.f24686g;
        } else if (i11 > 0) {
            this.f24690k = this.f24684e;
        }
        this.f24692m = 0;
        mark(0);
        reset();
        return this.f24691l;
    }

    public int I() {
        if ((this.f24691l & 1) > 0) {
            return this.f24693n;
        }
        return 0;
    }

    @Override // java.io.InputStream
    public int available() {
        int I;
        int i10;
        byte[] bArr = this.f24687h;
        if (bArr == null || this.f24693n != 0 || this.f24694o != 0 || (this.f24691l & 3) <= 0) {
            I = I() + d() + c();
            i10 = this.f24696q;
        } else {
            I = bArr.length + c();
            i10 = this.f24696q;
        }
        return I - i10;
    }

    public int c() {
        if ((this.f24691l & 4) > 0) {
            return this.f24695p;
        }
        return 0;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f24685f = null;
        this.f24686g = null;
        this.f24685f = null;
        this.f24687h = null;
        this.f24695p = 0;
        this.f24694o = 0;
        this.f24693n = 0;
        this.f24690k = null;
        this.f24692m = 0;
        this.f24696q = 0;
        this.f24680a.close();
    }

    public int d() {
        if ((this.f24691l & 2) > 0) {
            return this.f24694o;
        }
        return 0;
    }

    public void h() {
        byte[] bArr;
        byte[] bArr2 = this.f24685f;
        if (!(bArr2 == null || (bArr = this.f24686g) == null || this.f24690k != bArr)) {
            this.f24690k = bArr2;
        }
        this.f24692m = 0;
        mark(0);
        reset();
    }

    public byte[] i() {
        return this.f24689j;
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f24697r = this.f24690k;
        this.f24698s = this.f24692m;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public int n() {
        return this.f24696q;
    }

    public int o() {
        this.f24691l = 0;
        if (this.f24687h != null) {
            this.f24691l = 0 | 3;
        }
        if (this.f24693n > 0) {
            this.f24691l |= 1;
        }
        if (this.f24694o > 0) {
            this.f24691l |= 2;
        }
        if (this.f24695p > 0) {
            this.f24691l |= 4;
        }
        return this.f24691l;
    }

    public long q() {
        return this.f24683d.getValue();
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        byte[] bArr;
        this.f24690k = this.f24697r;
        int i10 = this.f24698s;
        this.f24692m = i10;
        this.f24696q = i10;
        this.f24683d.reset();
        if (this.f24690k == this.f24686g && (bArr = this.f24685f) != null) {
            this.f24683d.update(bArr);
            this.f24696q += this.f24693n;
        }
        this.f24683d.update(this.f24690k, 0, this.f24692m);
    }

    @Override // java.io.InputStream
    public long skip(long j10) {
        return 0L;
    }

    public byte[] u() {
        return this.f24688i;
    }

    public boolean v() {
        b bVar = this.f24682c;
        return bVar != null && bVar.e();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        int x10 = x(bArr, i10, i11);
        return (i11 <= x10 || O() == null) ? x10 : x10 + x(bArr, i10 + x10, i11 - x10);
    }
}
