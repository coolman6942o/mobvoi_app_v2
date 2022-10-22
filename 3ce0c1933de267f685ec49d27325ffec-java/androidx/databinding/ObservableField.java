package androidx.databinding;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ObservableField<T> extends b implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField(T t10) {
        this.mValue = t10;
    }

    public T get() {
        return this.mValue;
    }

    public void set(T t10) {
        if (t10 != this.mValue) {
            this.mValue = t10;
            notifyChange();
        }
    }

    public ObservableField() {
    }

    public ObservableField(f... fVarArr) {
        super(fVarArr);
    }
}
