package wh;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: BadgeMultiBean.kt */
/* loaded from: classes2.dex */
public final class a implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    private String f36234a;

    /* renamed from: b  reason: collision with root package name */
    private String f36235b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f36236c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f36237d;

    public a(String category, String name, boolean z10, boolean z11, boolean z12) {
        i.f(category, "category");
        i.f(name, "name");
        this.f36234a = category;
        this.f36235b = name;
        this.f36236c = z11;
        this.f36237d = z12;
    }

    public final String a() {
        return this.f36234a;
    }

    public final String b() {
        return this.f36235b;
    }

    public final boolean c() {
        return this.f36236c;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.f36237d ? 1 : 0;
    }

    public /* synthetic */ a(String str, String str2, boolean z10, boolean z11, boolean z12, int i10, f fVar) {
        this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? false : z11, (i10 & 16) != 0 ? true : z12);
    }
}
