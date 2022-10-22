package xm;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import sm.e;
/* compiled from: DesignUtil.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: DesignUtil.java */
    /* renamed from: xm.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0534a implements AppBarLayout.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ vm.a f36613a;

        C0534a(vm.a aVar) {
            this.f36613a = aVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.c
        public void a(AppBarLayout appBarLayout, int i10) {
            vm.a aVar = this.f36613a;
            boolean z10 = true;
            boolean z11 = i10 >= 0;
            if (appBarLayout.getTotalScrollRange() + i10 > 0) {
                z10 = false;
            }
            aVar.i(z11, z10);
        }
    }

    public static void a(View view, e eVar, vm.a aVar) {
        try {
            if (view instanceof CoordinatorLayout) {
                eVar.d().a(false);
                ViewGroup viewGroup = (ViewGroup) view;
                for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt = viewGroup.getChildAt(childCount);
                    if (childAt instanceof AppBarLayout) {
                        ((AppBarLayout) childAt).d(new C0534a(aVar));
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
