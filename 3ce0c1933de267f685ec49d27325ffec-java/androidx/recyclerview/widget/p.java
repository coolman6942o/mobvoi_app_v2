package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollbarHelper.java */
/* loaded from: classes.dex */
public class p {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.y yVar, m mVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z10) {
        if (layoutManager.K() == 0 || yVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(layoutManager.i0(view) - layoutManager.i0(view2)) + 1;
        }
        return Math.min(mVar.n(), mVar.d(view2) - mVar.g(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(RecyclerView.y yVar, m mVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z10, boolean z11) {
        int i10;
        if (layoutManager.K() == 0 || yVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(layoutManager.i0(view), layoutManager.i0(view2));
        int max = Math.max(layoutManager.i0(view), layoutManager.i0(view2));
        if (z11) {
            i10 = Math.max(0, (yVar.b() - max) - 1);
        } else {
            i10 = Math.max(0, min);
        }
        if (!z10) {
            return i10;
        }
        return Math.round((i10 * (Math.abs(mVar.d(view2) - mVar.g(view)) / (Math.abs(layoutManager.i0(view) - layoutManager.i0(view2)) + 1))) + (mVar.m() - mVar.g(view)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(RecyclerView.y yVar, m mVar, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z10) {
        if (layoutManager.K() == 0 || yVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return yVar.b();
        }
        return (int) (((mVar.d(view2) - mVar.g(view)) / (Math.abs(layoutManager.i0(view) - layoutManager.i0(view2)) + 1)) * yVar.b());
    }
}
