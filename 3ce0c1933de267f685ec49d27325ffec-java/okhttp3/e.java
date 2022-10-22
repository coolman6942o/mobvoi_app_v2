package okhttp3;

import java.io.IOException;
/* compiled from: Call.kt */
/* loaded from: classes3.dex */
public interface e extends Cloneable {

    /* compiled from: Call.kt */
    /* loaded from: classes3.dex */
    public interface a {
        e a(z zVar);
    }

    void cancel();

    b0 execute() throws IOException;

    void h(f fVar);

    boolean isCanceled();

    z request();
}
