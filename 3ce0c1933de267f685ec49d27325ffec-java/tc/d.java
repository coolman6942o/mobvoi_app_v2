package tc;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.jvm.internal.f;
/* compiled from: SportMedalMultiBean.kt */
/* loaded from: classes2.dex */
public final class d implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    private final int f35112a;

    /* renamed from: b  reason: collision with root package name */
    private com.mobvoi.companion.health.entity.a f35113b;

    /* compiled from: SportMedalMultiBean.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public d(int i10) {
        this.f35112a = i10;
    }

    public final com.mobvoi.companion.health.entity.a a() {
        return this.f35113b;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.f35112a;
    }

    public d(int i10, com.mobvoi.companion.health.entity.a aVar) {
        this.f35112a = i10;
        this.f35113b = aVar;
    }
}
