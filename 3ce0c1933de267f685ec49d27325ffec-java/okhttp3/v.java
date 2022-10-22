package okhttp3;

import java.io.IOException;
/* compiled from: Interceptor.kt */
/* loaded from: classes3.dex */
public interface v {

    /* compiled from: Interceptor.kt */
    /* loaded from: classes3.dex */
    public interface a {
        b0 a(z zVar) throws IOException;

        j b();

        e call();

        z request();
    }

    b0 intercept(a aVar) throws IOException;
}
