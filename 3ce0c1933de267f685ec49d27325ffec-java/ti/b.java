package ti;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import gg.f;
/* compiled from: ArtyTrendsDataListMultiBean.java */
/* loaded from: classes2.dex */
public class b implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    private int f35166a;

    /* renamed from: b  reason: collision with root package name */
    private f f35167b;

    /* renamed from: c  reason: collision with root package name */
    private int f35168c;

    public b(int i10) {
        this.f35166a = i10;
    }

    public int a() {
        return this.f35168c;
    }

    public f b() {
        return this.f35167b;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.f35166a;
    }

    public b(int i10, f fVar, int i11) {
        this.f35166a = i10;
        this.f35167b = fVar;
        this.f35168c = i11;
    }
}
