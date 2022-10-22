package vh;

import com.cardiex.arty.lite.models.coach.Advice;
import com.cardiex.arty.lite.models.coach.Article;
import com.cardiex.arty.lite.models.coach.InsightType;
import com.cardiex.arty.lite.models.social.BadgeSummary;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.jvm.internal.i;
/* compiled from: ArtyFeedMultiBean.kt */
/* loaded from: classes2.dex */
public final class a implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    private Advice f35775a;

    /* renamed from: b  reason: collision with root package name */
    private Article f35776b;

    /* renamed from: c  reason: collision with root package name */
    private BadgeSummary f35777c;

    /* renamed from: d  reason: collision with root package name */
    private long f35778d;

    /* renamed from: e  reason: collision with root package name */
    private InsightType f35779e;

    /* compiled from: ArtyFeedMultiBean.kt */
    /* renamed from: vh.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class C0516a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35780a;

        static {
            int[] iArr = new int[InsightType.values().length];
            iArr[InsightType.ADVICE.ordinal()] = 1;
            f35780a = iArr;
        }
    }

    public a(Advice advice, Article article, BadgeSummary badgeSummary, long j10, InsightType insightType) {
        this.f35775a = advice;
        this.f35776b = article;
        this.f35777c = badgeSummary;
        this.f35778d = j10;
        this.f35779e = insightType;
    }

    public final Advice a() {
        return this.f35775a;
    }

    public final Article b() {
        return this.f35776b;
    }

    public final BadgeSummary c() {
        return this.f35777c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return i.b(this.f35775a, aVar.f35775a) && i.b(this.f35776b, aVar.f35776b) && i.b(this.f35777c, aVar.f35777c) && this.f35778d == aVar.f35778d && this.f35779e == aVar.f35779e;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        InsightType insightType = this.f35779e;
        return (insightType == null ? -1 : C0516a.f35780a[insightType.ordinal()]) == 1 ? 0 : -1;
    }

    public int hashCode() {
        Advice advice = this.f35775a;
        int i10 = 0;
        int hashCode = (advice == null ? 0 : advice.hashCode()) * 31;
        Article article = this.f35776b;
        int hashCode2 = (hashCode + (article == null ? 0 : article.hashCode())) * 31;
        BadgeSummary badgeSummary = this.f35777c;
        int hashCode3 = (((hashCode2 + (badgeSummary == null ? 0 : badgeSummary.hashCode())) * 31) + ia.a.a(this.f35778d)) * 31;
        InsightType insightType = this.f35779e;
        if (insightType != null) {
            i10 = insightType.hashCode();
        }
        return hashCode3 + i10;
    }

    public String toString() {
        return "InsightsData(advice=" + this.f35775a + ", article=" + this.f35776b + ", badgeSummary=" + this.f35777c + ", timestamp=" + this.f35778d + ", type=" + this.f35779e + ')';
    }
}
