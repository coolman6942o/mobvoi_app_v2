package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
/* compiled from: CompositeOnPageChangeCallback.java */
/* loaded from: classes.dex */
final class b extends ViewPager2.i {

    /* renamed from: a  reason: collision with root package name */
    private final List<ViewPager2.i> f4647a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i10) {
        this.f4647a = new ArrayList(i10);
    }

    private void e(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void a(int i10) {
        try {
            for (ViewPager2.i iVar : this.f4647a) {
                iVar.a(i10);
            }
        } catch (ConcurrentModificationException e10) {
            e(e10);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void b(int i10, float f10, int i11) {
        try {
            for (ViewPager2.i iVar : this.f4647a) {
                iVar.b(i10, f10, i11);
            }
        } catch (ConcurrentModificationException e10) {
            e(e10);
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.i
    public void c(int i10) {
        try {
            for (ViewPager2.i iVar : this.f4647a) {
                iVar.c(i10);
            }
        } catch (ConcurrentModificationException e10) {
            e(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ViewPager2.i iVar) {
        this.f4647a.add(iVar);
    }
}
