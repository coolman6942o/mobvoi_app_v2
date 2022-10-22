package aa;

import a5.d;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import java.security.MessageDigest;
import u4.e;
/* compiled from: CircleTransform.java */
/* loaded from: classes2.dex */
public class a extends d {
    private static Bitmap d(Bitmap bitmap) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        Bitmap createBitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f10 = min / 2.0f;
        canvas.drawCircle(f10, f10, f10, paint);
        createBitmap.recycle();
        return createBitmap2;
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        messageDigest.update("Glide_Circle_Transformation".getBytes());
    }

    @Override // a5.d
    protected Bitmap c(e eVar, Bitmap bitmap, int i10, int i11) {
        return d(bitmap);
    }
}
