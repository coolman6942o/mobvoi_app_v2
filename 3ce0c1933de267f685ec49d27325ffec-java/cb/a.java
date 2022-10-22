package cb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.media.MediaScannerConnection;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.j;
import com.mobvoi.android.common.utils.k;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import mb.g;
/* compiled from: FileUtil.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0081a f5678a = new C0081a(null);

    /* compiled from: FileUtil.kt */
    /* renamed from: cb.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0081a {
        private C0081a() {
        }

        public /* synthetic */ C0081a(f fVar) {
            this();
        }

        public final Bitmap a(View view) {
            i.f(view, "view");
            if (view.getWidth() == 0 || view.getHeight() == 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
            view.draw(canvas);
            return createBitmap;
        }

        public final void b(Context context, Bitmap bitmap) {
            Throwable th2;
            IOException e10;
            File createTempFile;
            FileOutputStream fileOutputStream;
            i.f(context, "context");
            i.f(bitmap, "bitmap");
            n nVar = n.f30086a;
            String format = String.format("img_%s.jpeg", Arrays.copyOf(new Object[]{new SimpleDateFormat("yyMMdd-HHmmss", Locale.getDefault()).format(new Date())}, 1));
            i.e(format, "java.lang.String.format(format, *args)");
            File h10 = b.h(Environment.DIRECTORY_PICTURES);
            i.e(h10, "getFilesDir(Environment.DIRECTORY_PICTURES)");
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    createTempFile = File.createTempFile(format, ".jpg", h10);
                    fileOutputStream = new FileOutputStream(createTempFile);
                } catch (IOException e11) {
                    e10 = e11;
                }
            } catch (Throwable th3) {
                th2 = th3;
            }
            try {
                if (bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream)) {
                    fileOutputStream.flush();
                    String absolutePath = createTempFile.getAbsolutePath();
                    i.e(absolutePath, "image.absolutePath");
                    MediaScannerConnection.scanFile(context, new String[]{yd.f.c(context, absolutePath, format)}, null, null);
                    Toast.makeText(context, context.getString(g.r_res_0x7f140c78), 0).show();
                    createTempFile.delete();
                }
                j.a(fileOutputStream);
            } catch (IOException e12) {
                e10 = e12;
                fileOutputStream2 = fileOutputStream;
                k.e("FileUtil", "Error when save bitmap, ", e10);
                Toast.makeText(context, context.getString(g.f30646t), 0).show();
                j.a(fileOutputStream2);
            } catch (Throwable th4) {
                th2 = th4;
                fileOutputStream2 = fileOutputStream;
                j.a(fileOutputStream2);
                throw th2;
            }
        }
    }
}
