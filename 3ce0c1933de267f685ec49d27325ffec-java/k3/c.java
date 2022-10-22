package k3;

import android.util.Log;
import com.airbnb.lottie.i;
import java.util.HashSet;
import java.util.Set;
/* compiled from: LogcatLogger.java */
/* loaded from: classes.dex */
public class c implements i {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f29723a = new HashSet();

    @Override // com.airbnb.lottie.i
    public void a(String str, Throwable th2) {
        if (com.airbnb.lottie.c.f6417a) {
            Log.d("LOTTIE", str, th2);
        }
    }

    @Override // com.airbnb.lottie.i
    public void b(String str) {
        e(str, null);
    }

    @Override // com.airbnb.lottie.i
    public void c(String str, Throwable th2) {
        Set<String> set = f29723a;
        if (!set.contains(str)) {
            Log.w("LOTTIE", str, th2);
            set.add(str);
        }
    }

    @Override // com.airbnb.lottie.i
    public void d(String str) {
        c(str, null);
    }

    public void e(String str, Throwable th2) {
        if (com.airbnb.lottie.c.f6417a) {
            Log.d("LOTTIE", str, th2);
        }
    }
}
