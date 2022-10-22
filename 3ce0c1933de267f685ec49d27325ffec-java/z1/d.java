package z1;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.k;
import com.mobvoi.wear.providers.OtaColumn;
/* compiled from: PackageManagerHelper.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f37219a = k.f("PackageManagerHelper");

    public static void a(Context context, Class<?> cls, boolean z10) {
        String str = OtaColumn.COLUMN_ENABLED;
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z10 ? 1 : 2, 1);
            k c10 = k.c();
            String str2 = f37219a;
            Object[] objArr = new Object[2];
            objArr[0] = cls.getName();
            objArr[1] = z10 ? str : "disabled";
            c10.a(str2, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e10) {
            k c11 = k.c();
            String str3 = f37219a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = cls.getName();
            if (!z10) {
                str = "disabled";
            }
            objArr2[1] = str;
            c11.a(str3, String.format("%s could not be %s", objArr2), e10);
        }
    }
}
