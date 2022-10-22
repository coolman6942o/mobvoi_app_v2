package com.mobvoi.wear.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
/* loaded from: classes2.dex */
public final class GzipUtils {
    public static byte[] gzipByte(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read != -1) {
                    gZIPOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static byte[] gzipString(String str) {
        return gzipByte(str.getBytes());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.util.zip.GZIPInputStream] */
    public static byte[] ungzipToByte(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th2;
        Exception e10;
        ByteArrayOutputStream byteArrayOutputStream2;
        if (bArr == 0 || bArr.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                bArr = new GZIPInputStream(byteArrayInputStream);
            } catch (Throwable th3) {
                th2 = th3;
            }
        } catch (Exception e11) {
            e10 = e11;
            bArr = 0;
            byteArrayOutputStream2 = null;
        } catch (Throwable th4) {
            th2 = th4;
            byteArrayOutputStream = null;
            bArr = 0;
        }
        try {
            byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = bArr.read(bArr2);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream2.write(bArr2, 0, read);
                }
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                try {
                    byteArrayOutputStream2.close();
                    bArr.close();
                    byteArrayInputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                return byteArray;
            } catch (Exception e13) {
                e10 = e13;
                e10.printStackTrace();
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                        return null;
                    }
                }
                if (bArr != 0) {
                    bArr.close();
                }
                byteArrayInputStream.close();
                return null;
            }
        } catch (Exception e15) {
            e10 = e15;
            byteArrayOutputStream2 = null;
        } catch (Throwable th5) {
            th2 = th5;
            byteArrayOutputStream = null;
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                    throw th2;
                }
            }
            if (bArr != 0) {
                bArr.close();
            }
            byteArrayInputStream.close();
            throw th2;
        }
    }

    public static String ungzipToString(byte[] bArr) {
        byte[] ungzipToByte = ungzipToByte(bArr);
        return (ungzipToByte == null || ungzipToByte.length <= 0) ? "" : new String(ungzipToByte);
    }
}
