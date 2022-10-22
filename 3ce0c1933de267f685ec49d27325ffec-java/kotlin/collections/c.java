package kotlin.collections;

import java.util.AbstractList;
import java.util.List;
/* compiled from: AbstractMutableList.kt */
/* loaded from: classes3.dex */
public abstract class c<E> extends AbstractList<E> implements List<E> {
    public abstract int a();

    public abstract E b(int i10);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int i10) {
        return b(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
