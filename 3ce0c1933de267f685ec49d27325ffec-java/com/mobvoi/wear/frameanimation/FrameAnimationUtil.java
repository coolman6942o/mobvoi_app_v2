package com.mobvoi.wear.frameanimation;

import android.content.Context;
import android.util.Log;
import com.mobvoi.wear.frameanimation.FrameAnimation;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.r;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
/* compiled from: FrameAnimationUtil.kt */
/* loaded from: classes2.dex */
public final class FrameAnimationUtil {
    public static final FrameAnimationUtil INSTANCE;
    private static final String TAG;

    static {
        FrameAnimationUtil frameAnimationUtil = new FrameAnimationUtil();
        INSTANCE = frameAnimationUtil;
        TAG = frameAnimationUtil.getClass().getSimpleName();
    }

    private FrameAnimationUtil() {
    }

    public static final List<FrameAnimation.PathData> getPathList(Context context, String assetsPath) {
        List<FrameAnimation.PathData> W;
        i.f(context, "context");
        i.f(assetsPath, "assetsPath");
        try {
            String[] list = context.getAssets().list(assetsPath);
            boolean z10 = true;
            if (list != null) {
                if (!(list.length == 0)) {
                    z10 = false;
                }
            }
            if (z10) {
                Log.e(TAG, "no file in this asset directory");
                return new ArrayList();
            }
            int length = list.length - 1;
            if (length >= 0) {
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    list[i10] = assetsPath + ((Object) File.separator) + ((Object) list[i10]);
                    if (i11 > length) {
                        break;
                    }
                    i10 = i11;
                }
            }
            ArrayList arrayList = new ArrayList(list.length);
            for (String it : list) {
                i.e(it, "it");
                arrayList.add(new FrameAnimation.PathData(it, FrameAnimation.Companion.getPATH_ASSETS()));
            }
            W = u.W(arrayList);
            return W;
        } catch (IOException e10) {
            String message = e10.getMessage();
            if (message != null) {
                Log.e(TAG, message);
            }
            e10.printStackTrace();
            return new ArrayList();
        }
    }

    public static final List<FrameAnimation.PathData> getPathList(File file) {
        ArrayList arrayList = new ArrayList();
        if (file == null) {
            Log.e(TAG, "file is null");
        } else if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            ArrayList arrayList2 = new ArrayList(listFiles.length);
            for (File file2 : listFiles) {
                String absolutePath = file2.getAbsolutePath();
                i.e(absolutePath, "it.absolutePath");
                arrayList2.add(new FrameAnimation.PathData(absolutePath, FrameAnimation.Companion.getPATH_FILE()));
            }
            arrayList.addAll(arrayList2);
        } else if (!file.exists()) {
            Log.e(TAG, "file doesn't exists");
        } else {
            Log.e(TAG, "file isn't a directory");
        }
        return arrayList;
    }

    public static final List<FrameAnimation.PathData> getPathList(Context context, String... assetsPaths) {
        List<FrameAnimation.PathData> W;
        i.f(context, "context");
        i.f(assetsPaths, "assetsPaths");
        ArrayList arrayList = new ArrayList();
        for (String str : assetsPaths) {
            r.s(arrayList, getPathList(context, str));
        }
        W = u.W(arrayList);
        return W;
    }

    public static final List<FrameAnimation.PathData> getPathList(File... files) {
        List<FrameAnimation.PathData> W;
        i.f(files, "files");
        ArrayList arrayList = new ArrayList();
        int length = files.length;
        for (int i10 = 0; i10 < length; i10++) {
            r.s(arrayList, getPathList(files[i10]));
        }
        W = u.W(arrayList);
        return W;
    }
}
