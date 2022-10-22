package androidx.databinding;

import androidx.databinding.f;
/* compiled from: BaseObservable.java */
/* loaded from: classes.dex */
public class a implements f {
    private transient i mCallbacks;

    @Override // androidx.databinding.f
    public void addOnPropertyChangedCallback(f.a aVar) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new i();
            }
        }
        this.mCallbacks.a(aVar);
    }

    public void notifyChange() {
        synchronized (this) {
            i iVar = this.mCallbacks;
            if (iVar != null) {
                iVar.d(this, 0, null);
            }
        }
    }

    public void notifyPropertyChanged(int i10) {
        synchronized (this) {
            i iVar = this.mCallbacks;
            if (iVar != null) {
                iVar.d(this, i10, null);
            }
        }
    }

    public void removeOnPropertyChangedCallback(f.a aVar) {
        synchronized (this) {
            i iVar = this.mCallbacks;
            if (iVar != null) {
                iVar.j(aVar);
            }
        }
    }
}
