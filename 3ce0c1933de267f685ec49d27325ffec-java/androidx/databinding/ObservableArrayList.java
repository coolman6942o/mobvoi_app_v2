package androidx.databinding;

import androidx.databinding.g;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes.dex */
public class ObservableArrayList<T> extends ArrayList<T> implements g<T> {
    private transient e mListeners = new e();

    private void a(int i10, int i11) {
        e eVar = this.mListeners;
        if (eVar != null) {
            eVar.p(this, i10, i11);
        }
    }

    private void b(int i10, int i11) {
        e eVar = this.mListeners;
        if (eVar != null) {
            eVar.q(this, i10, i11);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T t10) {
        super.add(t10);
        a(size() - 1, 1);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> collection) {
        int size = size();
        boolean addAll = super.addAll(collection);
        if (addAll) {
            a(size, size() - size);
        }
        return addAll;
    }

    public void addOnListChangedCallback(g.a aVar) {
        if (this.mListeners == null) {
            this.mListeners = new e();
        }
        this.mListeners.a(aVar);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int size = size();
        super.clear();
        if (size != 0) {
            b(0, size);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T remove(int i10) {
        T t10 = (T) super.remove(i10);
        b(i10, 1);
        return t10;
    }

    public void removeOnListChangedCallback(g.a aVar) {
        e eVar = this.mListeners;
        if (eVar != null) {
            eVar.j(aVar);
        }
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    protected void removeRange(int i10, int i11) {
        super.removeRange(i10, i11);
        b(i10, i11 - i10);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T set(int i10, T t10) {
        T t11 = (T) super.set(i10, t10);
        e eVar = this.mListeners;
        if (eVar != null) {
            eVar.o(this, i10, 1);
        }
        return t11;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int i10, T t10) {
        super.add(i10, t10);
        a(i10, 1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int i10, Collection<? extends T> collection) {
        boolean addAll = super.addAll(i10, collection);
        if (addAll) {
            a(i10, collection.size());
        }
        return addAll;
    }
}
