package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: PagerAdapter.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private final DataSetObservable f4603a = new DataSetObservable();

    /* renamed from: b  reason: collision with root package name */
    private DataSetObserver f4604b;

    public abstract void a(ViewGroup viewGroup, int i10, Object obj);

    @Deprecated
    public void b(View view) {
    }

    public void c(ViewGroup viewGroup) {
        b(viewGroup);
    }

    public abstract int d();

    public int e(Object obj) {
        return -1;
    }

    public CharSequence f(int i10) {
        return null;
    }

    public float g(int i10) {
        return 1.0f;
    }

    public abstract Object h(ViewGroup viewGroup, int i10);

    public abstract boolean i(View view, Object obj);

    public void j() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.f4604b;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.f4603a.notifyChanged();
    }

    public void k(DataSetObserver dataSetObserver) {
        this.f4603a.registerObserver(dataSetObserver);
    }

    public void l(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable m() {
        return null;
    }

    @Deprecated
    public void n(View view, int i10, Object obj) {
    }

    public void o(ViewGroup viewGroup, int i10, Object obj) {
        n(viewGroup, i10, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f4604b = dataSetObserver;
        }
    }

    @Deprecated
    public void q(View view) {
    }

    public void r(ViewGroup viewGroup) {
        q(viewGroup);
    }

    public void s(DataSetObserver dataSetObserver) {
        this.f4603a.unregisterObserver(dataSetObserver);
    }
}
