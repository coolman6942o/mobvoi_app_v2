package tc;

import com.mobvoi.android.common.json.JsonBean;
import h8.a;
import h8.c;
import xc.b;
/* compiled from: VPAHealthCardResp.kt */
/* loaded from: classes2.dex */
public final class i implements JsonBean {
    @c("boxType")
    private Integer boxType;
    @c("card")
    private String card;
    @a(deserialize = false, serialize = false)
    private b<?> data;

    public i(Integer num, String str) {
        this.boxType = num;
        this.card = str;
    }

    public final Integer a() {
        return this.boxType;
    }

    public final String b() {
        return this.card;
    }

    public final b<?> c() {
        return this.data;
    }

    public final void d(Integer num) {
        this.boxType = num;
    }

    public final void e(String str) {
        this.card = str;
    }

    public final void f(b<?> bVar) {
        this.data = bVar;
    }

    public i() {
        this(null, null);
    }
}
