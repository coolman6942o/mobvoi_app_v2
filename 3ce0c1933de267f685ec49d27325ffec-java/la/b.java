package la;

import com.mobvoi.android.common.json.JsonBean;
/* compiled from: HttpRequest.kt */
/* loaded from: classes2.dex */
public final class b implements JsonBean {
    private final String method;
    private final String params;
    private final String source;
    private final String url;

    public final String a() {
        return this.method;
    }

    public final String b() {
        return this.params;
    }

    public final String c() {
        return this.source;
    }

    public final String d() {
        return this.url;
    }
}
