package a4;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import s3.a;
/* loaded from: classes.dex */
public class g {
    public static Drawable a(String str, Context context) {
        return b(str, context, 480);
    }

    public static Drawable b(String str, Context context, int i10) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(a.d(str));
        } catch (Throwable unused) {
            byteArrayInputStream = null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            if (i10 <= 0) {
                i10 = 240;
            }
            options.inDensity = i10;
            options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
            BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(byteArrayInputStream, null, options));
            c(byteArrayInputStream);
            return bitmapDrawable;
        } catch (Throwable unused2) {
            c(byteArrayInputStream);
            return null;
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
