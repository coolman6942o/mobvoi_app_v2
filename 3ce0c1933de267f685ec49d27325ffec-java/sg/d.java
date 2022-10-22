package sg;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mobvoi.sleep.data.pojo.SleepRecord;
/* compiled from: SleepMultiBean.java */
/* loaded from: classes2.dex */
public class d implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    private int f34421a;

    /* renamed from: b  reason: collision with root package name */
    public SleepRecord f34422b;

    public d(int i10, SleepRecord sleepRecord) {
        this.f34421a = i10;
        this.f34422b = sleepRecord;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.f34421a;
    }
}
