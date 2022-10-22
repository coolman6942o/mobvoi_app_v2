package tc;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import java.util.List;
/* compiled from: VpaCardSettingResponse.kt */
/* loaded from: classes2.dex */
public final class l implements JsonBean {
    @c("cardList")
    private List<k> cardList;
    @c("cardNonList")
    private List<k> cardNonList;

    public final List<k> a() {
        return this.cardList;
    }

    public final List<k> b() {
        return this.cardNonList;
    }
}
