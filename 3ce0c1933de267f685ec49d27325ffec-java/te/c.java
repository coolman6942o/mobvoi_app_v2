package te;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.android.common.utils.j;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.feedback.bean.FeedBackImageEntity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import okio.d;
import okio.e;
import okio.n;
/* compiled from: MyFeedbackUtil.java */
/* loaded from: classes2.dex */
public class c extends a {
    public static int e(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        if (i12 <= i11 && i13 <= i10) {
            return 1;
        }
        int round = Math.round(i12 / i11);
        int round2 = Math.round(i13 / i10);
        return round < round2 ? round : round2;
    }

    public static byte[] f(ContentResolver contentResolver, FeedBackImageEntity feedBackImageEntity) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        byte[] bArr = null;
        try {
            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(feedBackImageEntity.f17897b, "r");
            BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
            options.inSampleSize = e(options, AGCServerException.UNKNOW_EXCEPTION, AGCServerException.UNKNOW_EXCEPTION);
            options.inJustDecodeBounds = false;
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeFileDescriptor.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
            decodeFileDescriptor.recycle();
            bArr = byteArrayOutputStream.toByteArray();
            j.a(byteArrayOutputStream);
            return bArr;
        } catch (Exception e10) {
            k.d("MyFeedbackUtil", e10.getMessage());
            return bArr;
        }
    }

    public static byte[] g(File file) {
        Throwable th2;
        IOException e10;
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e11) {
                e10 = e11;
            }
        } catch (Throwable th3) {
            th2 = th3;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            j.a(fileInputStream);
        } catch (IOException e12) {
            e10 = e12;
            fileInputStream2 = fileInputStream;
            e10.printStackTrace();
            j.a(fileInputStream2);
            j.a(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th4) {
            th2 = th4;
            fileInputStream2 = fileInputStream;
            j.a(fileInputStream2);
            j.a(byteArrayOutputStream);
            throw th2;
        }
        j.a(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void h(File file, File file2) throws IOException {
        Throwable th2;
        d dVar;
        e d10;
        d dVar2 = null;
        try {
            d10 = n.d(n.k(file));
        } catch (Throwable th3) {
            th2 = th3;
            dVar = null;
        }
        try {
            dVar2 = n.c(new okio.j(n.f(file2)));
            byte[] bArr = new byte[8192];
            while (true) {
                int read = d10.read(bArr, 0, 8192);
                if (read != -1) {
                    dVar2.e(bArr, 0, read);
                } else {
                    j.a(d10);
                    j.a(dVar2);
                    return;
                }
            }
        } catch (Throwable th4) {
            th2 = th4;
            dVar = dVar2;
            dVar2 = d10;
            j.a(dVar2);
            j.a(dVar);
            throw th2;
        }
    }
}
