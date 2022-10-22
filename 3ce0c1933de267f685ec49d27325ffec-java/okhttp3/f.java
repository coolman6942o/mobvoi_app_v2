package okhttp3;

import java.io.IOException;
/* compiled from: Callback.kt */
/* loaded from: classes3.dex */
public interface f {
    void onFailure(e eVar, IOException iOException);

    void onResponse(e eVar, b0 b0Var) throws IOException;
}
