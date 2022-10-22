package com.mobvoi.wear.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.huawei.agconnect.exception.AGCServerException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
/* loaded from: classes2.dex */
public final class ImageUtils {
    public static byte[] bitmap2Bytes(Bitmap bitmap) {
        return bitmap2Bytes(bitmap, false);
    }

    public static byte[] bitmap2BytesScaled(Bitmap bitmap, boolean z10, boolean z11, int i10) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (z11) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        } else {
            bitmap.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream);
        }
        if (z10) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception unused) {
        }
        return byteArray;
    }

    public static Bitmap bitmapCompress(String str) {
        return bitmapCompress(str, 480, 800);
    }

    public static Bitmap bytes2Bitmap(byte[] bArr) {
        if (bArr.length != 0) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        if (i12 <= i11 && i13 <= i10) {
            return 1;
        }
        int round = Math.round(i12 / i11);
        int round2 = Math.round(i13 / i10);
        return round < round2 ? round2 : round;
    }

    public static Bitmap compressForWatchHead(Bitmap bitmap) {
        int i10;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < 500 && height < 500) {
            return bitmap;
        }
        int i11 = AGCServerException.AUTHENTICATION_INVALID;
        if (width > height) {
            i10 = (height * AGCServerException.AUTHENTICATION_INVALID) / width;
        } else if (width < height) {
            int i12 = (width * AGCServerException.AUTHENTICATION_INVALID) / height;
            i10 = 400;
            i11 = i12;
        } else {
            i10 = 400;
        }
        return Bitmap.createScaledBitmap(bitmap, i11, i10, true);
    }

    public static Bitmap compressImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        int i10 = 90;
        while (byteArrayOutputStream.toByteArray().length / 1024 > 10) {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream);
            i10 -= 10;
        }
        return BitmapFactory.decodeStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()), null, null);
    }

    public static Bitmap createBitmapFromDrawable(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap createDrawableToBitmap(Drawable drawable) {
        Bitmap bitmap;
        return (!(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) ? createBitmapFromDrawable(drawable) : bitmap;
    }

    public static Bitmap decodeSampledBitmapFromFile(String str, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources resources, int i10, int i11, int i12) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i10, options);
        options.inSampleSize = calculateInSampleSize(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i10, options);
    }

    public static Bitmap decodeSampledBitmapFromStream(InputStream inputStream, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static Bitmap getBitmapFromView(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
        }
        return null;
    }

    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        float f10;
        float f11;
        float f12;
        float f13;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f13 = width / 2;
            f12 = width;
            f11 = 0.0f;
            f10 = f12;
        } else {
            f13 = height / 2;
            f11 = (width - height) / 2;
            f12 = width - f11;
            f10 = height;
            width = height;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f11, (int) 0.0f, (int) f12, (int) f10);
        Rect rect2 = new Rect((int) 0.0f, (int) 0.0f, (int) f10, (int) f10);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawCircle(f13, f13, f13, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }

    public static byte[] bitmap2Bytes(Bitmap bitmap, boolean z10) {
        return bitmap2BytesScaled(bitmap, z10, true, 100);
    }

    public static Bitmap bitmapCompress(String str, int i10, int i11) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        options.inSampleSize = calculateInSampleSize(options, i10, i11);
        return compressImage(BitmapFactory.decodeFile(str, options));
    }
}
