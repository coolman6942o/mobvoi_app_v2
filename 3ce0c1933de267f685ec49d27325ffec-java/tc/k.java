package tc;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.providers.OtaColumn;
import h8.c;
/* compiled from: VpaCardSettingResponse.kt */
/* loaded from: classes2.dex */
public final class k implements JsonBean {
    @c("boxType")
    private Integer boxType;
    @c("card")
    private String card;
    @c(OtaColumn.COLUMN_DESCRIPTION)
    private String description;
    @c("exist")
    private Boolean exist;

    public final String a() {
        return this.card;
    }

    public final String b() {
        return this.description;
    }

    public final Boolean c() {
        return this.exist;
    }
}
