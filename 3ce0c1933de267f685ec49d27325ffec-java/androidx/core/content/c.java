package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.app.d;
/* compiled from: PermissionChecker.java */
/* loaded from: classes.dex */
public final class c {
    public static int a(Context context, String str) {
        return b(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }

    public static int b(Context context, String str, int i10, int i11, String str2) {
        int i12;
        if (context.checkPermission(str, i10, i11) == -1) {
            return -1;
        }
        String c10 = d.c(str);
        if (c10 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i11);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        if (Process.myUid() == i11 && j0.c.a(context.getPackageName(), str2)) {
            i12 = d.a(context, i11, c10, str2);
        } else {
            i12 = d.b(context, c10, str2);
        }
        return i12 == 0 ? 0 : -2;
    }

    public static int c(Context context, String str) {
        return b(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
