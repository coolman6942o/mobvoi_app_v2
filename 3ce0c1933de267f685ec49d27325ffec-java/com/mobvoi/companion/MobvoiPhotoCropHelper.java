package com.mobvoi.companion;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.view.crop.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.i;
/* compiled from: CropImageActivity.kt */
/* loaded from: classes2.dex */
public final class MobvoiPhotoCropHelper {
    public static final MobvoiPhotoCropHelper INSTANCE = new MobvoiPhotoCropHelper();
    private static final String TAG = "MobvoiPhotoCropHelper";

    private MobvoiPhotoCropHelper() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final File createTmpFileForChooseImage(Context context, Uri imageUri) {
        c.a aVar;
        IOException e10;
        BufferedOutputStream bufferedOutputStream;
        i.f(context, "context");
        i.f(imageUri, "imageUri");
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            aVar = c.l(context, imageUri, 300, 300);
        } catch (Exception unused) {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        Bitmap bitmap = aVar.f17783a;
        File file = new File(context.getCacheDir(), "tmp_from_gallery.jpeg");
        try {
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (IOException e11) {
                    k.d(TAG, e11.getMessage());
                }
            } catch (IOException e12) {
                e10 = e12;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
            bitmap.compress(compressFormat, 80, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedOutputStream2 = compressFormat;
        } catch (IOException e13) {
            e10 = e13;
            bufferedOutputStream2 = bufferedOutputStream;
            k.d(TAG, e10.getMessage());
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
                bufferedOutputStream2 = bufferedOutputStream2;
            }
            return file;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e14) {
                    k.d(TAG, e14.getMessage());
                }
            }
            throw th;
        }
        return file;
    }

    public final String generateCameraFilePath(Context context) {
        i.f(context, "context");
        File cacheDir = context.getCacheDir();
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) cacheDir.getAbsolutePath());
        String str = File.separator;
        sb2.append((Object) str);
        sb2.append("browser-photos");
        File file = new File(sb2.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return ((Object) file.getAbsolutePath()) + ((Object) str) + "tmp_from_camera.jpg";
    }

    public final Uri getUriForFile(Context context, File file) {
        i.f(context, "context");
        i.f(file, "file");
        if (Build.VERSION.SDK_INT >= 24) {
            Uri e10 = FileProvider.e(context, i.n(context.getPackageName(), ".fileProvider"), file);
            i.e(e10, "{\n            FileProvider.getUriForFile(\n                context, \"${context.packageName}.fileProvider\", file\n            )\n        }");
            return e10;
        }
        Uri fromFile = Uri.fromFile(file);
        i.e(fromFile, "{\n            Uri.fromFile(file)\n        }");
        return fromFile;
    }

    public final void launchCameraActivity(Fragment owner, String resultFilePath, int i10) {
        i.f(owner, "owner");
        i.f(resultFilePath, "resultFilePath");
        Context requireContext = owner.requireContext();
        i.e(requireContext, "owner.requireContext()");
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.addFlags(1);
        }
        intent.putExtra("output", INSTANCE.getUriForFile(requireContext, new File(resultFilePath)));
        owner.startActivityForResult(intent, i10);
    }

    public final void launchCropImageActivity(Fragment owner, Uri fileUri, int i10) {
        i.f(owner, "owner");
        i.f(fileUri, "fileUri");
        Intent intent = new Intent(MobvoiCropParams.CROP_ACTION);
        intent.putExtra(MobvoiCropParams.EXTRA_CROP_INPUT_URI, fileUri);
        intent.setPackage(owner.requireContext().getPackageName());
        owner.startActivityForResult(intent, i10);
    }
}
