package v3;

import com.alipay.sdk.util.b;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Locale;
import q3.a;
import s3.d;
import s3.e;
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f35581a;

    /* renamed from: b  reason: collision with root package name */
    public String f35582b = b.g(24);

    public c(boolean z10) {
        this.f35581a = z10;
    }

    public static int a(String str) {
        return Integer.parseInt(str);
    }

    public static String b(int i10) {
        return String.format(Locale.getDefault(), "%05d", Integer.valueOf(i10));
    }

    public static byte[] e(String str, String str2) {
        return d.a(str, str2);
    }

    public static byte[] f(String str, byte[] bArr, String str2) {
        return e.b(str, bArr, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004c, code lost:
        if (r2 == null) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] g(byte[]... bArr) {
        Throwable th2;
        DataOutputStream dataOutputStream;
        DataOutputStream dataOutputStream2;
        Exception e10;
        byte[] bArr2 = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        bArr2 = null;
        if (bArr != null) {
            ?? length = bArr.length;
            try {
                if (length != 0) {
                    try {
                        length = new ByteArrayOutputStream();
                        try {
                            dataOutputStream2 = new DataOutputStream(length);
                            try {
                                for (byte[] bArr3 : bArr) {
                                    dataOutputStream2.write(b(bArr3.length).getBytes());
                                    dataOutputStream2.write(bArr3);
                                }
                                dataOutputStream2.flush();
                                byte[] byteArray = length.toByteArray();
                                try {
                                    length.close();
                                } catch (Exception unused) {
                                }
                                bArr2 = byteArray;
                            } catch (Exception e11) {
                                e10 = e11;
                                a4.d.d(e10);
                                if (length != 0) {
                                    try {
                                        length.close();
                                    } catch (Exception unused2) {
                                    }
                                }
                            }
                        } catch (Exception e12) {
                            e10 = e12;
                            dataOutputStream2 = null;
                        } catch (Throwable th3) {
                            th2 = th3;
                            dataOutputStream = null;
                            byteArrayOutputStream = length;
                            if (byteArrayOutputStream != null) {
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (dataOutputStream != null) {
                                try {
                                    dataOutputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                            throw th2;
                        }
                    } catch (Exception e13) {
                        e10 = e13;
                        length = 0;
                        dataOutputStream2 = null;
                    } catch (Throwable th4) {
                        th2 = th4;
                        dataOutputStream = null;
                        if (byteArrayOutputStream != null) {
                        }
                        if (dataOutputStream != null) {
                        }
                        throw th2;
                    }
                    try {
                        dataOutputStream2.close();
                    } catch (Exception unused5) {
                    }
                    return bArr2;
                }
            } catch (Throwable th5) {
                th2 = th5;
            }
        }
        return null;
    }

    public static byte[] h(String str, byte[] bArr, String str2) {
        return e.d(str, bArr, str2);
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0076: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:33:0x0076 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b c(d dVar, String str) {
        Throwable th2;
        String str2;
        String str3;
        Exception e10;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(dVar.a());
                try {
                    byte[] bArr = new byte[5];
                    byteArrayInputStream.read(bArr);
                    byte[] bArr2 = new byte[a(new String(bArr))];
                    byteArrayInputStream.read(bArr2);
                    str3 = new String(bArr2);
                } catch (Exception e11) {
                    e10 = e11;
                    str3 = null;
                }
                try {
                    byte[] bArr3 = new byte[5];
                    byteArrayInputStream.read(bArr3);
                    int a10 = a(new String(bArr3));
                    if (a10 > 0) {
                        byte[] bArr4 = new byte[a10];
                        byteArrayInputStream.read(bArr4);
                        if (this.f35581a) {
                            bArr4 = f(this.f35582b, bArr4, str);
                        }
                        if (dVar.b()) {
                            bArr4 = s3.b.b(bArr4);
                        }
                        str2 = new String(bArr4);
                    } else {
                        str2 = null;
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (Exception unused) {
                        if (str3 == null || str2 != null) {
                            return new b(str3, str2);
                        }
                        return null;
                    }
                } catch (Exception e12) {
                    e10 = e12;
                    a4.d.d(e10);
                    if (byteArrayInputStream != null) {
                        try {
                            byteArrayInputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    str2 = null;
                    if (str3 == null) {
                    }
                    return new b(str3, str2);
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (byteArrayInputStream2 != null) {
                    try {
                        byteArrayInputStream2.close();
                    } catch (Exception unused3) {
                    }
                }
                throw th2;
            }
        } catch (Exception e13) {
            e10 = e13;
            byteArrayInputStream = null;
            str3 = null;
        } catch (Throwable th4) {
            th2 = th4;
            if (byteArrayInputStream2 != null) {
            }
            throw th2;
        }
    }

    public d d(b bVar, boolean z10, String str) {
        byte[] bArr;
        if (bVar == null) {
            return null;
        }
        byte[] bytes = bVar.b().getBytes();
        byte[] bytes2 = bVar.a().getBytes();
        if (z10) {
            try {
                bytes2 = s3.b.a(bytes2);
            } catch (Exception unused) {
                z10 = false;
            }
        }
        if (this.f35581a) {
            bArr = g(bytes, e(this.f35582b, a.f32920b), h(this.f35582b, bytes2, str));
        } else {
            bArr = g(bytes, bytes2);
        }
        return new d(z10, bArr);
    }
}
