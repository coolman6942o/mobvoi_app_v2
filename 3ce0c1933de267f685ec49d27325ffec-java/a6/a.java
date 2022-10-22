package a6;

import com.google.android.gms.common.data.DataHolder;
import java.util.Iterator;
/* loaded from: classes.dex */
public abstract class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final DataHolder f102a;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(DataHolder dataHolder) {
        this.f102a = dataHolder;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new c(this);
    }

    @Override // com.google.android.gms.common.api.g
    public void release() {
        DataHolder dataHolder = this.f102a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
