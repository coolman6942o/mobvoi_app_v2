package ji;

import com.cardiex.arty.lite.models.coach.Action;
import com.cardiex.arty.lite.models.coach.ArtyComponent;
import com.cardiex.arty.lite.models.coach.ArtyGraph;
import com.cardiex.arty.lite.models.coach.ArtyScore;
import com.cardiex.arty.lite.models.coach.ContentType;
import com.cardiex.arty.lite.models.coach.Question;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.jvm.internal.i;
/* compiled from: ContentMultiBean.kt */
/* loaded from: classes2.dex */
public final class a implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    private Action f29620a;

    /* renamed from: b  reason: collision with root package name */
    private ArtyComponent f29621b;

    /* renamed from: c  reason: collision with root package name */
    private ArtyGraph f29622c;

    /* renamed from: d  reason: collision with root package name */
    private ArtyScore f29623d;

    /* renamed from: e  reason: collision with root package name */
    private String f29624e;

    /* renamed from: f  reason: collision with root package name */
    private String f29625f;

    /* renamed from: g  reason: collision with root package name */
    private String f29626g;

    /* renamed from: h  reason: collision with root package name */
    private Question f29627h;

    /* renamed from: i  reason: collision with root package name */
    private ContentType f29628i;

    /* renamed from: j  reason: collision with root package name */
    private String f29629j;

    /* renamed from: k  reason: collision with root package name */
    private String f29630k;

    /* compiled from: ContentMultiBean.kt */
    /* renamed from: ji.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public /* synthetic */ class C0356a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29631a;

        static {
            int[] iArr = new int[ContentType.values().length];
            iArr[ContentType.HTML.ordinal()] = 1;
            iArr[ContentType.GRAPH.ordinal()] = 2;
            f29631a = iArr;
        }
    }

    public a(Action action, ArtyComponent artyComponent, ArtyGraph artyGraph, ArtyScore artyScore, String str, String str2, String str3, Question question, ContentType type, String str4, String str5) {
        i.f(type, "type");
        this.f29620a = action;
        this.f29621b = artyComponent;
        this.f29622c = artyGraph;
        this.f29623d = artyScore;
        this.f29624e = str;
        this.f29625f = str2;
        this.f29626g = str3;
        this.f29627h = question;
        this.f29628i = type;
        this.f29629j = str4;
        this.f29630k = str5;
    }

    public final ArtyGraph a() {
        return this.f29622c;
    }

    public final String b() {
        return this.f29626g;
    }

    public final String c() {
        return this.f29629j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f29620a == aVar.f29620a && i.b(this.f29621b, aVar.f29621b) && i.b(this.f29622c, aVar.f29622c) && i.b(this.f29623d, aVar.f29623d) && i.b(this.f29624e, aVar.f29624e) && i.b(this.f29625f, aVar.f29625f) && i.b(this.f29626g, aVar.f29626g) && i.b(this.f29627h, aVar.f29627h) && this.f29628i == aVar.f29628i && i.b(this.f29629j, aVar.f29629j) && i.b(this.f29630k, aVar.f29630k);
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        int i10 = C0356a.f29631a[this.f29628i.ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? -1 : 1;
        }
        return 0;
    }

    public int hashCode() {
        Action action = this.f29620a;
        int i10 = 0;
        int hashCode = (action == null ? 0 : action.hashCode()) * 31;
        ArtyComponent artyComponent = this.f29621b;
        int hashCode2 = (hashCode + (artyComponent == null ? 0 : artyComponent.hashCode())) * 31;
        ArtyGraph artyGraph = this.f29622c;
        int hashCode3 = (hashCode2 + (artyGraph == null ? 0 : artyGraph.hashCode())) * 31;
        ArtyScore artyScore = this.f29623d;
        int hashCode4 = (hashCode3 + (artyScore == null ? 0 : artyScore.hashCode())) * 31;
        String str = this.f29624e;
        int hashCode5 = (hashCode4 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f29625f;
        int hashCode6 = (hashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f29626g;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Question question = this.f29627h;
        int hashCode8 = (((hashCode7 + (question == null ? 0 : question.hashCode())) * 31) + this.f29628i.hashCode()) * 31;
        String str4 = this.f29629j;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f29630k;
        if (str5 != null) {
            i10 = str5.hashCode();
        }
        return hashCode9 + i10;
    }

    public String toString() {
        return "ContentData(action=" + this.f29620a + ", artyComponent=" + this.f29621b + ", artyGraph=" + this.f29622c + ", artyScore=" + this.f29623d + ", bin=" + ((Object) this.f29624e) + ", icon=" + ((Object) this.f29625f) + ", image=" + ((Object) this.f29626g) + ", question=" + this.f29627h + ", type=" + this.f29628i + ", value=" + ((Object) this.f29629j) + ", video=" + ((Object) this.f29630k) + ')';
    }
}
