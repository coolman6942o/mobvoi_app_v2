package e6;

import android.util.Log;
import b6.f;
import java.util.Locale;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f25830a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25831b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25832c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(String str, String... strArr) {
        this(str, r8);
        String str2;
        if (strArr.length == 0) {
            str2 = "";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            for (String str3 : strArr) {
                if (sb2.length() > 1) {
                    sb2.append(",");
                }
                sb2.append(str3);
            }
            sb2.append(']');
            sb2.append(' ');
            str2 = sb2.toString();
        }
    }

    private final String c(String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.f25831b.concat(str);
    }

    public void a(String str, Object... objArr) {
        if (d(3)) {
            Log.d(this.f25830a, c(str, objArr));
        }
    }

    public void b(String str, Object... objArr) {
        Log.e(this.f25830a, c(str, objArr));
    }

    public boolean d(int i10) {
        return this.f25832c <= i10;
    }

    private a(String str, String str2) {
        this.f25831b = str2;
        this.f25830a = str;
        new f(str);
        int i10 = 2;
        while (7 >= i10 && !Log.isLoggable(this.f25830a, i10)) {
            i10++;
        }
        this.f25832c = i10;
    }
}
