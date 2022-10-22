package com.huawei.hianalytics.mn.no.b;

import com.huawei.hianalytics.mn.no.qr.mn;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.zip.Deflater;
/* loaded from: classes.dex */
public final class pq {
    public static String mn(File file) {
        Throwable th2;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th3) {
                th2 = th3;
            }
        } catch (FileNotFoundException unused) {
        } catch (IOException unused2) {
        }
        try {
            mn mnVar = new mn(1024);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                mnVar.mn(bArr, read);
            }
            if (mnVar.mn() == 0) {
                mn((Closeable) fileInputStream);
                return "";
            }
            String str = new String(mnVar.no(), "UTF-8");
            mn((Closeable) fileInputStream);
            return str;
        } catch (FileNotFoundException unused3) {
            fileInputStream2 = fileInputStream;
            mn.op("StreamUtil", "getInfoFromFile(): No files need to be read");
            mn((Closeable) fileInputStream2);
            return "";
        } catch (IOException unused4) {
            fileInputStream2 = fileInputStream;
            mn.op("StreamUtil", "getInfoFromFile(): stream.read or new string exception");
            mn((Closeable) fileInputStream2);
            return "";
        } catch (Throwable th4) {
            th2 = th4;
            fileInputStream2 = fileInputStream;
            mn((Closeable) fileInputStream2);
            throw th2;
        }
    }

    public static String mn(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toString("UTF-8");
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            mn((Closeable) byteArrayOutputStream);
        }
    }

    public static void mn(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                mn.op("StreamUtil", "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    public static void mn(File file, String str) {
        Throwable th2;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th3) {
                th2 = th3;
            }
        } catch (FileNotFoundException unused) {
        } catch (IOException unused2) {
        }
        try {
            fileOutputStream.write(str.getBytes("UTF-8"));
            fileOutputStream.flush();
            mn((Closeable) fileOutputStream);
        } catch (FileNotFoundException unused3) {
            fileOutputStream2 = fileOutputStream;
            mn.op("StreamUtil", "saveInfoToFile(): No files need to be read");
            mn((Closeable) fileOutputStream2);
        } catch (IOException unused4) {
            fileOutputStream2 = fileOutputStream;
            mn.op("StreamUtil", "saveInfoToFile(): io exc from write info to file!");
            mn((Closeable) fileOutputStream2);
        } catch (Throwable th4) {
            th2 = th4;
            fileOutputStream2 = fileOutputStream;
            mn((Closeable) fileOutputStream2);
            throw th2;
        }
    }

    private static void mn(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException unused) {
                mn.op("StreamUtil", "closeStream(): Exception: close OutputStream error!");
            }
        }
    }

    public static void mn(HttpURLConnection httpURLConnection) {
        try {
            httpURLConnection.getInputStream().close();
        } catch (Exception unused) {
            mn.op("StreamUtil", "closeQuietly(): Exception when connHttp.getInputStream()!,There may be no network, or no INTERNET permission");
        }
        httpURLConnection.disconnect();
        mn.mn("StreamUtil", " connHttp disconnect");
    }

    public static byte[] mn(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Deflater deflater = new Deflater();
        deflater.setInput(bArr);
        deflater.finish();
        byte[] bArr2 = new byte[1024];
        while (!deflater.finished()) {
            byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        deflater.end();
        mn((OutputStream) byteArrayOutputStream);
        return byteArray;
    }
}
