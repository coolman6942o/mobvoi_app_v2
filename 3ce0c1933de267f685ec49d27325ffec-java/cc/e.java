package cc;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import h8.c;
import java.util.List;
import kotlin.jvm.internal.f;
/* compiled from: WatchFaceCardBean.kt */
/* loaded from: classes2.dex */
public final class e implements JsonBean {
    @c("card_index")
    private int cardIndex;
    @c("card_name")
    private String cardName;
    @c("card_watch_bean_list")
    private List<WatchFaceBean> cardWatchBeanList;
    @c("data_type")
    private int dataType;
    @c("is_show_more")
    private boolean isShowMore;
    private int secondId;

    public e() {
        this(0, null, false, null, 0, 0);
    }

    public final int a() {
        return this.cardIndex;
    }

    public final String b() {
        return this.cardName;
    }

    public final List<WatchFaceBean> c() {
        return this.cardWatchBeanList;
    }

    public final int d() {
        return this.dataType;
    }

    public final int e() {
        return this.secondId;
    }

    public final boolean f() {
        return this.isShowMore;
    }

    public String toString() {
        return "WatchfaceCardBean(cardName=" + ((Object) this.cardName) + ", cardIndex=" + this.cardIndex + ", isShowMore=" + this.isShowMore + ", cardWatchBeanList=" + this.cardWatchBeanList + ", dataType=" + this.dataType + ')';
    }

    public /* synthetic */ e(int i10, String str, boolean z10, List list, int i11, int i12, int i13, f fVar) {
        this(i10, str, z10, list, i11, (i13 & 32) != 0 ? 0 : i12);
    }

    public e(int i10, String str, boolean z10, List<WatchFaceBean> list, int i11, int i12) {
        this.cardIndex = i10;
        this.cardName = str;
        this.isShowMore = z10;
        this.cardWatchBeanList = list;
        this.dataType = i11;
        this.secondId = i12;
    }
}
