package com.mobvoi.wear.frameanimation.io;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.mobvoi.wear.frameanimation.FrameAnimation;
import java.io.IOException;
import kotlin.jvm.internal.i;
import kotlin.text.u;
/* compiled from: BitmapDecoderImpl.kt */
/* loaded from: classes2.dex */
public class BitmapDecoderImpl implements BitmapDecoder {
    private final String TAG = getClass().getSimpleName();
    private final AssetManager assets;

    public BitmapDecoderImpl(Context context) {
        i.f(context, "context");
        this.assets = context.getAssets();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r3 == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bitmap decodeAssetBitmap(String str, Bitmap bitmap) {
        boolean I;
        BitmapFactory.Options options = new BitmapFactory.Options();
        boolean z10 = true;
        options.inSampleSize = 1;
        options.inMutable = true;
        if (bitmap != null) {
            options.inBitmap = bitmap;
        }
        try {
            return BitmapFactory.decodeStream(this.assets.open(str), null, options);
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        } catch (IllegalArgumentException e11) {
            String message = e11.getMessage();
            if (message != null) {
                I = u.I(message, "Problem decoding into existing bitmap", false, 2, null);
            }
            z10 = false;
            if (z10) {
                options.inBitmap = null;
                return BitmapFactory.decodeStream(this.assets.open(str), null, options);
            }
            throw e11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r2 == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bitmap decodeFileBitmap(String str, Bitmap bitmap) {
        boolean I;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (bitmap != null) {
            options.inBitmap = bitmap;
        }
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        } catch (IllegalArgumentException e11) {
            String message = e11.getMessage();
            boolean z10 = true;
            if (message != null) {
                I = u.I(message, "Problem decoding into existing bitmap", false, 2, null);
            }
            z10 = false;
            if (z10) {
                options.inBitmap = null;
                return BitmapFactory.decodeFile(str, options);
            }
            throw e11;
        }
    }

    @Override // com.mobvoi.wear.frameanimation.io.BitmapDecoder
    public Bitmap decodeBitmap(FrameAnimation.PathData path, Bitmap bitmap) {
        i.f(path, "path");
        int type = path.getType();
        FrameAnimation.Companion companion = FrameAnimation.Companion;
        if (type == companion.getPATH_FILE()) {
            return decodeFileBitmap(path.getPath(), bitmap);
        }
        if (type == companion.getPATH_ASSETS()) {
            return decodeAssetBitmap(path.getPath(), bitmap);
        }
        return null;
    }

    @Override // com.mobvoi.wear.frameanimation.io.BitmapDecoder
    public Bitmap decodeBitmap(FrameAnimation.PathData path) {
        i.f(path, "path");
        return decodeBitmap(path, null);
    }
}
