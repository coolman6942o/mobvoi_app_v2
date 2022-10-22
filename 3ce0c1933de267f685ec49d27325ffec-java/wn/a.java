package wn;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.s;
import java.util.concurrent.Callable;
/* compiled from: AndroidSchedulers.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final s f36333a = vn.a.d(new CallableC0526a());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: wn.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class CallableC0526a implements Callable<s> {
        CallableC0526a() {
        }

        /* renamed from: a */
        public s call() throws Exception {
            return b.f36334a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AndroidSchedulers.java */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final s f36334a = new wn.b(new Handler(Looper.getMainLooper()), false);
    }

    public static s a() {
        return vn.a.e(f36333a);
    }
}
