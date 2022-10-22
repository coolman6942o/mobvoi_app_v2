package xf;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.info.AccountInfoHelper;
import java.util.Calendar;
import java.util.Locale;
/* compiled from: UserProfile.java */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f36545a;

    /* renamed from: b  reason: collision with root package name */
    public final float f36546b;

    /* renamed from: c  reason: collision with root package name */
    public final float f36547c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36548d;

    public i(int i10, float f10, float f11, int i11) {
        this.f36545a = i10;
        this.f36546b = f10 <= 0.0f ? 166.1f : f10;
        this.f36547c = f11 <= 0.0f ? 57.7f : f11;
        this.f36548d = i11 <= 0 ? 25 : i11;
        Calendar.getInstance().get(1);
    }

    public static i a(String str, String str2, String str3, String str4) {
        boolean equals = !TextUtils.isEmpty(str) ? str.equals(AccountInfoHelper.AccountInfo.VAL_SEX_MALE) : true;
        float parseFloat = !TextUtils.isEmpty(str2) ? Float.parseFloat(str2) : 170.0f;
        float parseFloat2 = !TextUtils.isEmpty(str3) ? Float.parseFloat(str3) : 60.0f;
        int b10 = b(str4);
        int i10 = equals ? 1 : 0;
        int i11 = equals ? 1 : 0;
        return new i(i10, parseFloat, parseFloat2, b10);
    }

    public static int b(String str) {
        int i10 = Calendar.getInstance().get(1);
        int i11 = 1990;
        if (!TextUtils.isEmpty(str)) {
            try {
                int indexOf = str.indexOf(".");
                if (indexOf > 0) {
                    str = str.substring(0, indexOf);
                }
                i11 = Integer.parseInt(str);
            } catch (Exception e10) {
                k.r("health.UserProfile", "Failed to parse birthday.", e10, new Object[0]);
            }
        }
        if (i11 > 0) {
            return i10 - i11;
        }
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "UserProfile 0x%x {sex %d, height %.2f, weight %.2f, age %d}", Integer.valueOf(hashCode()), Integer.valueOf(this.f36545a), Float.valueOf(this.f36546b), Float.valueOf(this.f36547c), Integer.valueOf(this.f36548d));
    }
}
