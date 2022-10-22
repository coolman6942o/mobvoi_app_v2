package sn;

import android.app.Activity;
import androidx.fragment.app.f;
/* compiled from: ActivityModule.java */
/* loaded from: classes2.dex */
abstract class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static f a(Activity activity) {
        try {
            return (f) activity;
        } catch (ClassCastException e10) {
            throw new IllegalStateException("Expected activity to be a FragmentActivity: " + activity, e10);
        }
    }
}
