package ti;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import gg.c;
import java.util.List;
/* compiled from: ArtyMultiBean.java */
/* loaded from: classes2.dex */
public class a implements MultiItemEntity {

    /* renamed from: a  reason: collision with root package name */
    private int f35162a;

    /* renamed from: b  reason: collision with root package name */
    private List<c> f35163b;

    /* renamed from: c  reason: collision with root package name */
    public String f35164c;

    /* renamed from: d  reason: collision with root package name */
    public int f35165d;

    public a(int i10) {
        this.f35162a = i10;
    }

    public List<c> a() {
        return this.f35163b;
    }

    public void b(List<c> list) {
        this.f35163b = list;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.f35162a;
    }
}
