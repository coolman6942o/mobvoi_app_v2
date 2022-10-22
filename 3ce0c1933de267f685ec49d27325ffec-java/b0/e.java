package b0;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: TypefaceCompatUtil.java */
/* loaded from: classes.dex */
public class e {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static ByteBuffer b(Context context, Resources resources, int i10) {
        File e10 = e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (!c(e10, resources, i10)) {
                return null;
            }
            return g(e10);
        } finally {
            e10.delete();
        }
    }

    public static boolean c(File file, Resources resources, int i10) {
        InputStream inputStream;
        Throwable th2;
        try {
            inputStream = resources.openRawResource(i10);
            try {
                boolean d10 = d(file, inputStream);
                a(inputStream);
                return d10;
            } catch (Throwable th3) {
                th2 = th3;
                a(inputStream);
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            inputStream = null;
        }
    }

    public static boolean d(File file, InputStream inputStream) {
        Throwable th2;
        IOException e10;
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e11) {
                e10 = e11;
            }
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    a(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                }
            }
        } catch (IOException e12) {
            e10 = e12;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e10.getMessage());
            a(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th4) {
            th2 = th4;
            fileOutputStream2 = fileOutputStream;
            a(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th2;
        }
    }

    public static File e(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i10 = 0; i10 < 100; i10++) {
            File file = new File(cacheDir, str + i10);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static ByteBuffer f(Context context, CancellationSignal cancellationSignal, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                openFileDescriptor.close();
                return map;
            } catch (Throwable th2) {
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private static ByteBuffer g(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileChannel channel = fileInputStream.getChannel();
            MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
            fileInputStream.close();
            return map;
        } catch (IOException unused) {
            return null;
        }
    }

    public static Map<Uri, ByteBuffer> h(Context context, FontsContractCompat.FontInfo[] fontInfoArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
            if (fontInfo.b() == 0) {
                Uri d10 = fontInfo.d();
                if (!hashMap.containsKey(d10)) {
                    hashMap.put(d10, f(context, cancellationSignal, d10));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }
}
