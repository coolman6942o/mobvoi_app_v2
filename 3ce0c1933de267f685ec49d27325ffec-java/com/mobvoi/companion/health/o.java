package com.mobvoi.companion.health;

import aa.d;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.mobvoi.companion.health.viewholder.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
/* compiled from: CardManagementModule.kt */
/* loaded from: classes2.dex */
public final class o {

    /* compiled from: CardManagementModule.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f16906a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f16907b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f16908c;

        a(int i10, int i11, int i12) {
            this.f16906a = i10;
            this.f16907b = i11;
            this.f16908c = i12;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            i.f(outRect, "outRect");
            i.f(view, "view");
            i.f(parent, "parent");
            i.f(state, "state");
            int g02 = parent.g0(view);
            int i10 = this.f16906a;
            int i11 = this.f16907b;
            int i12 = this.f16908c;
            outRect.left = i10;
            outRect.right = i10;
            outRect.top = i11;
            boolean z10 = true;
            int i13 = g02 + 1;
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter == null || i13 != adapter.getItemCount()) {
                z10 = false;
            }
            if (!z10) {
                i12 = 0;
            }
            outRect.bottom = i12;
        }
    }

    public final u a() {
        return new u();
    }

    public final List<k> b() {
        return new ArrayList();
    }

    public final List<k> c() {
        return new ArrayList();
    }

    public final RecyclerView.n d(Context context) {
        i.f(context, "context");
        return new a(d.b(16.0f, context), d.b(10.0f, context), d.b(36.0f, context));
    }

    public final g e(u cardMgrDragCallback) {
        i.f(cardMgrDragCallback, "cardMgrDragCallback");
        return new g(cardMgrDragCallback);
    }
}
