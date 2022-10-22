package np;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.internal.platform.h;
/* compiled from: StandardAndroidSocketAdapter.kt */
/* loaded from: classes3.dex */
public final class l extends f {

    /* renamed from: h */
    public static final a f31340h = new a(null);

    /* compiled from: StandardAndroidSocketAdapter.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ k b(a aVar, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                str = "com.android.org.conscrypt";
            }
            return aVar.a(str);
        }

        public final k a(String packageName) {
            i.f(packageName, "packageName");
            try {
                Class<?> cls = Class.forName(packageName + ".OpenSSLSocketImpl");
                Class<?> cls2 = Class.forName(packageName + ".OpenSSLSocketFactoryImpl");
                Class<?> paramsClass = Class.forName(packageName + ".SSLParametersImpl");
                i.e(paramsClass, "paramsClass");
                return new l(cls, cls2, paramsClass);
            } catch (Exception e10) {
                h.f32213c.g().k("unable to load android socket classes", 5, e10);
                return null;
            }
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Class<? super SSLSocket> sslSocketClass, Class<? super SSLSocketFactory> sslSocketFactoryClass, Class<?> paramClass) {
        super(sslSocketClass);
        i.f(sslSocketClass, "sslSocketClass");
        i.f(sslSocketFactoryClass, "sslSocketFactoryClass");
        i.f(paramClass, "paramClass");
    }
}
