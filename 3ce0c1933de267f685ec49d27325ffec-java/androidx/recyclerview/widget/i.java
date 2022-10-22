package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.d0;
import e1.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ItemTouchUIUtilImpl.java */
/* loaded from: classes.dex */
public class i implements h {

    /* renamed from: a  reason: collision with root package name */
    static final h f4085a = new i();

    i() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            if (childAt != view) {
                float y10 = d0.y(childAt);
                if (y10 > f10) {
                    f10 = y10;
                }
            }
        }
        return f10;
    }

    @Override // androidx.recyclerview.widget.h
    public void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            int i10 = c.f25705a;
            Object tag = view.getTag(i10);
            if (tag instanceof Float) {
                d0.B0(view, ((Float) tag).floatValue());
            }
            view.setTag(i10, null);
        }
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.h
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.h
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
    }

    @Override // androidx.recyclerview.widget.h
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f10, float f11, int i10, boolean z10) {
        if (Build.VERSION.SDK_INT >= 21 && z10) {
            int i11 = c.f25705a;
            if (view.getTag(i11) == null) {
                Float valueOf = Float.valueOf(d0.y(view));
                d0.B0(view, e(recyclerView, view) + 1.0f);
                view.setTag(i11, valueOf);
            }
        }
        view.setTranslationX(f10);
        view.setTranslationY(f11);
    }
}
