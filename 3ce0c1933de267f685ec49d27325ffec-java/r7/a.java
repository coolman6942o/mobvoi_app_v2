package r7;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
/* compiled from: AnimatorDurationScaleProvider.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static float f33440a = 1.0f;

    public float a(ContentResolver contentResolver) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 17) {
            return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        }
        if (i10 == 16) {
            return Settings.System.getFloat(contentResolver, "animator_duration_scale", 1.0f);
        }
        return f33440a;
    }
}
