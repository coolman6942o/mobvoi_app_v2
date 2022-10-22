package com.mobvoi.companion.health;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import tc.i;
/* compiled from: HealthFragmentModule.kt */
/* loaded from: classes2.dex */
public final class b1 {

    /* compiled from: HealthFragmentModule.kt */
    /* loaded from: classes2.dex */
    public static final class a extends GridLayoutManager.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List<i> f16817a;

        a(List<i> list) {
            this.f16817a = list;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            Integer a10 = this.f16817a.get(i10).a();
            if (a10 == null) {
                return 0;
            }
            return a10.intValue();
        }
    }

    /* compiled from: HealthFragmentModule.kt */
    /* loaded from: classes2.dex */
    public static final class b extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List<i> f16818a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f16819b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f16820c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f16821d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f16822e;

        b(List<i> list, int i10, int i11, int i12, int i13) {
            this.f16818a = list;
            this.f16819b = i10;
            this.f16820c = i11;
            this.f16821d = i12;
            this.f16822e = i13;
        }

        private final int i(int i10) {
            Integer a10;
            if (i10 <= 0) {
                return 0;
            }
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = i11 + 1;
                i iVar = this.f16818a.get(i11);
                Integer a11 = iVar.a();
                int i14 = 2;
                if (a11 != null && a11.intValue() == 2) {
                    Integer a12 = iVar.a();
                    i14 = a12 == null ? 0 : a12.intValue();
                } else {
                    boolean z10 = i13 >= this.f16818a.size() || ((a10 = this.f16818a.get(i13).a()) != null && a10.intValue() == 2);
                    if (i12 % 2 != 0 || !z10) {
                        i14 = 1;
                    }
                }
                i12 += i14;
                if (i13 >= i10) {
                    return i12;
                }
                i11 = i13;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            int i10;
            int i11;
            Integer a10;
            Integer a11;
            Integer a12;
            kotlin.jvm.internal.i.f(outRect, "outRect");
            kotlin.jvm.internal.i.f(view, "view");
            kotlin.jvm.internal.i.f(parent, "parent");
            kotlin.jvm.internal.i.f(state, "state");
            if (!this.f16818a.isEmpty()) {
                int g02 = parent.g0(view);
                int i12 = i(g02);
                i iVar = this.f16818a.get(g02);
                int i13 = i12 % 2;
                if (i13 == 0) {
                    i10 = this.f16819b;
                } else {
                    i10 = this.f16820c;
                }
                outRect.left = i10;
                if (i13 != 0 || ((a12 = iVar.a()) != null && a12.intValue() == 2)) {
                    i11 = this.f16819b;
                } else {
                    i11 = this.f16820c;
                }
                outRect.right = i11;
                boolean z10 = true;
                int i14 = 0;
                outRect.top = i12 >= 0 && i12 < 4 ? 0 : this.f16821d;
                if (g02 != this.f16818a.size() - 1 && (g02 != this.f16818a.size() - 2 || (((a10 = iVar.a()) != null && a10.intValue() == 2) || (((a11 = this.f16818a.get(g02 + 1).a()) != null && a11.intValue() == 2) || i13 != 0)))) {
                    z10 = false;
                }
                if (z10) {
                    i14 = this.f16822e;
                }
                outRect.bottom = i14;
            }
        }
    }

    public final n0 a(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        return new n0(context);
    }

    public final GridLayoutManager b(Context context, List<i> healthCardList) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(healthCardList, "healthCardList");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        gridLayoutManager.e3(new a(healthCardList));
        return gridLayoutManager;
    }

    public final List<i> c() {
        return new ArrayList();
    }

    public final t1 d(List<i> healthCardList) {
        kotlin.jvm.internal.i.f(healthCardList, "healthCardList");
        return new t1(healthCardList);
    }

    public final RecyclerView.n e(Context context, List<i> healthCardList) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(healthCardList, "healthCardList");
        float f10 = context.getResources().getDisplayMetrics().widthPixels / 375.0f;
        return new b(healthCardList, (int) (16 * f10), (int) ((7 * f10) / 2), (int) (8 * f10), (int) (f10 * 20));
    }

    public final List<i> f() {
        return new ArrayList();
    }
}
