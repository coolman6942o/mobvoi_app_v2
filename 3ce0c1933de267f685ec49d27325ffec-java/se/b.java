package se;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: GridTransParentItemDecoration.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private int f34411a;

    public b(int i10) {
        this.f34411a = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        int W2 = ((GridLayoutManager) recyclerView.getLayoutManager()).W2();
        int h02 = recyclerView.h0(view);
        int i10 = this.f34411a;
        int i11 = ((h02 % W2) * i10) / W2;
        rect.left = i11;
        rect.right = i10 - i11;
        if (h02 / W2 == 0) {
            rect.top = 0;
        } else {
            rect.top = i10;
        }
        rect.bottom = 0;
    }
}
