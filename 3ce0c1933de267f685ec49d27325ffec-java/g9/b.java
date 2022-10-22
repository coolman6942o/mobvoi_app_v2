package g9;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* compiled from: PermissionUtils.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final List<String> f27304a = c();

    /* renamed from: b  reason: collision with root package name */
    private static b f27305b;

    /* compiled from: PermissionUtils.java */
    /* loaded from: classes2.dex */
    public static class a extends Activity {
        @Override // android.app.Activity, android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            finish();
            return true;
        }

        @Override // android.app.Activity
        protected void onCreate(Bundle bundle) {
            getWindow().addFlags(262160);
            b unused = b.f27305b;
            super.onCreate(bundle);
            Log.e("PermissionUtils", "request permissions failed");
            finish();
        }

        @Override // android.app.Activity
        public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
            b.b(b.f27305b, this);
            finish();
        }
    }

    static /* synthetic */ void b(b bVar, Activity activity) {
        throw null;
    }

    public static List<String> c() {
        return d(f9.a.a().getPackageName());
    }

    public static List<String> d(String str) {
        try {
            return Arrays.asList(f9.a.a().getPackageManager().getPackageInfo(str, 4096).requestedPermissions);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return Collections.emptyList();
        }
    }
}
