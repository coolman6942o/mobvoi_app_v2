package com.huawei.hms.ml.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import com.huawei.hms.ml.camera.CameraConfig;
import java.util.Locale;
/* loaded from: classes2.dex */
public class NV21ToBitmapConverter1 {
    private Context applicationContext;

    /* renamed from: in  reason: collision with root package name */
    private Allocation f14029in;
    private Allocation out;
    private RenderScript renderScript;
    private Type.Builder rgbaType;
    private ScriptIntrinsicYuvToRGB yuvToRgbIntrinsic;
    private Type.Builder yuvType;
    private int width = -1;
    private int height = -1;
    private int length = -1;

    public NV21ToBitmapConverter1(Context context) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                this.applicationContext = context;
            } else {
                this.applicationContext = applicationContext;
            }
            RenderScript create = RenderScript.create(this.applicationContext);
            this.renderScript = create;
            this.yuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
            return;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    private void recreateIfNeed(byte[] bArr, int i10, int i11, int i12) {
        if (this.width != i10 || this.height != i11 || this.length != bArr.length) {
            this.width = i10;
            this.height = i11;
            this.length = bArr.length;
            this.yuvType = null;
            this.rgbaType = null;
        }
    }

    public Bitmap convert(byte[] bArr, int i10, int i11, int i12, int i13, int i14, boolean z10, boolean z11, boolean z12) {
        recreateIfNeed(bArr, i10, i11, i14);
        Bitmap createBitmap = Bitmap.createBitmap(i12, i13, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(convertYUVtoRGB(bArr, i10, i11), getTransformationMatrix(i10, i11, i12, i13, i14, z10, z11, z12), null);
        return createBitmap;
    }

    public Bitmap convertYUVtoRGB(byte[] bArr, int i10, int i11) {
        if (this.yuvType == null) {
            RenderScript renderScript = this.renderScript;
            Type.Builder x10 = new Type.Builder(renderScript, Element.U8(renderScript)).setX(bArr.length);
            this.yuvType = x10;
            this.f14029in = Allocation.createTyped(this.renderScript, x10.create(), 1);
            RenderScript renderScript2 = this.renderScript;
            Type.Builder y10 = new Type.Builder(renderScript2, Element.RGBA_8888(renderScript2)).setX(i10).setY(i11);
            this.rgbaType = y10;
            this.out = Allocation.createTyped(this.renderScript, y10.create(), 1);
        }
        this.f14029in.copyFrom(bArr);
        this.yuvToRgbIntrinsic.setInput(this.f14029in);
        this.yuvToRgbIntrinsic.forEach(this.out);
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
        this.out.copyTo(createBitmap);
        return createBitmap;
    }

    public Context getApplicationContext() {
        Context context = this.applicationContext;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("initial must be called first");
    }

    public Matrix getTransformationMatrix(int i10, int i11, int i12, int i13, int i14, boolean z10, boolean z11, boolean z12) {
        Matrix matrix = new Matrix();
        boolean z13 = false;
        int i15 = 1;
        if (i14 != 0) {
            if (i14 % 90 == 0) {
                matrix.postTranslate((-i10) / 2.0f, (-i11) / 2.0f);
                matrix.postRotate(i14);
            } else {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Rotation of %d", Integer.valueOf(i14)));
            }
        }
        if ((Math.abs(i14) + 90) % CameraConfig.CAMERA_THIRD_DEGREE == 0) {
            z13 = true;
        }
        int i16 = z13 ? i11 : i10;
        if (!z13) {
            i10 = i11;
        }
        int i17 = z10 ? -1 : 1;
        if (z11) {
            i15 = -1;
        }
        if (!(i16 == i12 && i10 == i13)) {
            float f10 = (i17 * i12) / i16;
            float f11 = (i15 * i13) / i10;
            if (z12) {
                float max = Math.max(Math.abs(f10), Math.abs(f11));
                matrix.postScale(max, max);
            } else {
                matrix.postScale(f10, f11);
            }
        }
        if (i14 != 0) {
            float f12 = i12 / 2.0f;
            float f13 = i13 / 2.0f;
            matrix.postTranslate(f12, f13);
            matrix.postScale(i17, i15, f12, f13);
        }
        return matrix;
    }

    public Bitmap convert(byte[] bArr, int i10, int i11, int i12, int i13, int i14) {
        return convert(bArr, i10, i11, i12, i13, i14, false, false, false);
    }
}
