package okhttp3;

import java.nio.charset.Charset;
import kotlin.jvm.internal.i;
import okio.ByteString;
/* compiled from: Credentials.kt */
/* loaded from: classes3.dex */
public final class o {
    static {
        new o();
    }

    private o() {
    }

    public static final String a(String username, String password, Charset charset) {
        i.f(username, "username");
        i.f(password, "password");
        i.f(charset, "charset");
        String base64 = ByteString.Companion.c(username + ':' + password, charset).base64();
        return "Basic " + base64;
    }
}
