package tc;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import ph.a;
/* compiled from: TicHealthResponse.kt */
/* loaded from: classes2.dex */
public final class g implements JsonBean {
    @c("completeHSInMs")
    private Long completeHSInMs;
    @c("standardHSInMs")
    private Long standardHSInMs;
    @c("weekNum")
    private Integer weekNum;

    public final int a() {
        Long l10 = this.completeHSInMs;
        return a.a(l10 == null ? 0L : l10.longValue());
    }

    public final int b() {
        Long l10 = this.standardHSInMs;
        return a.a(l10 == null ? 0L : l10.longValue());
    }

    public final Integer c() {
        return this.weekNum;
    }
}
