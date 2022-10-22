package com.mobvoi.companion.utils;

import android.content.Context;
import androidx.core.content.FileProvider;
/* loaded from: classes2.dex */
public class TicwearFileProvider extends FileProvider {
    public static String h(Context context) {
        return context.getPackageName() + ".ticwear.fileProvider";
    }
}
