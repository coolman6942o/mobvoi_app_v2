package j6;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import h6.n;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29443a;

    public b(Context context) {
        this.f29443a = context;
    }

    public int a(String str) {
        return this.f29443a.checkCallingOrSelfPermission(str);
    }

    public ApplicationInfo b(String str, int i10) throws PackageManager.NameNotFoundException {
        return this.f29443a.getPackageManager().getApplicationInfo(str, i10);
    }

    public CharSequence c(String str) throws PackageManager.NameNotFoundException {
        return this.f29443a.getPackageManager().getApplicationLabel(this.f29443a.getPackageManager().getApplicationInfo(str, 0));
    }

    public PackageInfo d(String str, int i10) throws PackageManager.NameNotFoundException {
        return this.f29443a.getPackageManager().getPackageInfo(str, i10);
    }

    public final String[] e(int i10) {
        return this.f29443a.getPackageManager().getPackagesForUid(i10);
    }

    public boolean f() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.f29443a);
        }
        if (!n.i() || (nameForUid = this.f29443a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f29443a.getPackageManager().isInstantApp(nameForUid);
    }

    public final PackageInfo g(String str, int i10, int i11) throws PackageManager.NameNotFoundException {
        return this.f29443a.getPackageManager().getPackageInfo(str, 64);
    }

    @TargetApi(19)
    public final boolean h(int i10, String str) {
        if (n.e()) {
            try {
                ((AppOpsManager) this.f29443a.getSystemService("appops")).checkPackage(i10, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.f29443a.getPackageManager().getPackagesForUid(i10);
            if (!(str == null || packagesForUid == null)) {
                for (String str2 : packagesForUid) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
