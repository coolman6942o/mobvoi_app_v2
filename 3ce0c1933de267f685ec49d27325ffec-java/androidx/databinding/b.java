package androidx.databinding;

import androidx.databinding.f;
/* compiled from: BaseObservableField.java */
/* loaded from: classes.dex */
abstract class b extends androidx.databinding.a {

    /* compiled from: BaseObservableField.java */
    /* loaded from: classes.dex */
    class a extends f.a {
        a() {
        }

        @Override // androidx.databinding.f.a
        public void a(f fVar, int i10) {
            b.this.notifyChange();
        }
    }

    public b() {
    }

    public b(f... fVarArr) {
        if (!(fVarArr == null || fVarArr.length == 0)) {
            a aVar = new a();
            for (f fVar : fVarArr) {
                fVar.addOnPropertyChangedCallback(aVar);
            }
        }
    }
}
