package yd;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.mobvoi.android.common.utils.k;
import io.m;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import kotlin.jvm.internal.i;
import kotlin.text.t;
/* compiled from: ImageSaveHelper.kt */
/* loaded from: classes2.dex */
public final class f {
    private static final String a() {
        if (Build.VERSION.SDK_INT >= 29) {
            String str = Environment.DIRECTORY_PICTURES;
            i.e(str, "{\n        Environment.DIRECTORY_PICTURES\n    }");
            return str;
        }
        String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        i.e(absolutePath, "{\n        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).absolutePath\n    }");
        return absolutePath;
    }

    private static final String b(String str) {
        try {
            String encode = URLEncoder.encode(str, "UTF-8");
            i.e(encode, "encode(fileName, \"UTF-8\")");
            str = t.z(encode, "+", "%20", false, 4, null);
        } catch (UnsupportedEncodingException unused) {
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        i.e(fileExtensionFromUrl, "getFileExtensionFromUrl(encoded)");
        String lowerCase = fileExtensionFromUrl.toLowerCase();
        i.e(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public static final String c(Context context, String localImageFilePath, String targetFileName) {
        boolean D;
        i.f(context, "context");
        i.f(localImageFilePath, "localImageFilePath");
        i.f(targetFileName, "targetFileName");
        if (!new File(localImageFilePath).exists()) {
            return null;
        }
        String a10 = a();
        String str = a10 + ((Object) File.separator) + targetFileName;
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", targetFileName);
        String b10 = b(targetFileName);
        D = t.D(b10, "image/", false, 2, null);
        if (!D) {
            b10 = "image/jpeg";
        }
        contentValues.put("mime_type", b10);
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", a10);
        } else {
            File file = new File(a10);
            if (!file.exists()) {
                file.mkdir();
            }
            contentValues.put("_data", str);
        }
        Uri insert = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert != null) {
            try {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(insert);
                if (openOutputStream != null) {
                    FileInputStream fileInputStream = new FileInputStream(localImageFilePath);
                    byte[] bArr = new byte[1444];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        openOutputStream.write(bArr, 0, read);
                    }
                    fileInputStream.close();
                    openOutputStream.flush();
                    openOutputStream.close();
                    m mVar = m.f28349a;
                }
            } catch (Exception e10) {
                k.d("ImageSaveHelper", i.n("Write image file failed: ", e10.getMessage()));
                m mVar2 = m.f28349a;
            }
        }
        return str;
    }
}
