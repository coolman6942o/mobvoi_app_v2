package com.mobvoi.wear.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
/* loaded from: classes2.dex */
public class TransformationUtils {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface Transformer {
        float scale(float f10, float f11);
    }

    public static Bitmap fitToSize(int i10, Bitmap bitmap) {
        return scaleCrop(bitmap, i10, i10);
    }

    private static Bitmap scaleBitmap(Bitmap bitmap, int i10, int i11, Transformer transformer, boolean z10) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f10 = i10;
        float f11 = width;
        float f12 = i11;
        float f13 = height;
        float scale = transformer.scale(f10 / f11, f12 / f13);
        if (scale == 1.0f) {
            return bitmap;
        }
        float f14 = f11 * scale;
        float f15 = f13 * scale;
        Matrix matrix = new Matrix();
        matrix.postScale(scale, scale);
        if (z10) {
            matrix.postTranslate((f10 - f14) / 2.0f, (f12 - f15) / 2.0f);
        }
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    public static Bitmap scaleCrop(Bitmap bitmap, int i10, int i11) {
        return scaleBitmap(bitmap, i10, i11, new Transformer() { // from class: com.mobvoi.wear.util.TransformationUtils.3
            @Override // com.mobvoi.wear.util.TransformationUtils.Transformer
            public float scale(float f10, float f11) {
                return Math.max(f10, f11);
            }
        }, true);
    }

    public static Bitmap scaleDownBitmap(Bitmap bitmap, int i10, int i11) {
        return scaleDownInside(bitmap, i10, i11);
    }

    public static Bitmap scaleDownCrop(Bitmap bitmap, int i10, int i11) {
        return scaleBitmap(bitmap, i10, i11, new Transformer() { // from class: com.mobvoi.wear.util.TransformationUtils.2
            @Override // com.mobvoi.wear.util.TransformationUtils.Transformer
            public float scale(float f10, float f11) {
                float max = Math.max(f10, f11);
                if (max > 1.0f) {
                    return 1.0f;
                }
                return max;
            }
        }, true);
    }

    public static Bitmap scaleDownInside(Bitmap bitmap, int i10, int i11) {
        return scaleBitmap(bitmap, i10, i11, new Transformer() { // from class: com.mobvoi.wear.util.TransformationUtils.1
            @Override // com.mobvoi.wear.util.TransformationUtils.Transformer
            public float scale(float f10, float f11) {
                float min = Math.min(f10, f11);
                if (min > 1.0f) {
                    return 1.0f;
                }
                return min;
            }
        }, false);
    }

    public static Bitmap scaleDownBitmap(Bitmap bitmap, int i10) {
        return scaleDownInside(bitmap, i10, i10);
    }
}
