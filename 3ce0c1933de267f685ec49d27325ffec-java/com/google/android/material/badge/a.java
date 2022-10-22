package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.ParcelableSparseArray;
/* compiled from: BadgeUtils.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10444a;

    static {
        f10444a = Build.VERSION.SDK_INT < 18;
    }

    public static void a(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        e(badgeDrawable, view, frameLayout);
        if (badgeDrawable.i() != null) {
            badgeDrawable.i().setForeground(badgeDrawable);
        } else if (!f10444a) {
            view.getOverlay().add(badgeDrawable);
        } else {
            throw new IllegalArgumentException("Trying to reference null customBadgeParent");
        }
    }

    public static SparseArray<BadgeDrawable> b(Context context, ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i10 = 0; i10 < parcelableSparseArray.size(); i10++) {
            int keyAt = parcelableSparseArray.keyAt(i10);
            BadgeDrawable.SavedState savedState = (BadgeDrawable.SavedState) parcelableSparseArray.valueAt(i10);
            if (savedState != null) {
                sparseArray.put(keyAt, BadgeDrawable.e(context, savedState));
            } else {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }

    public static ParcelableSparseArray c(SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i10 = 0; i10 < sparseArray.size(); i10++) {
            int keyAt = sparseArray.keyAt(i10);
            BadgeDrawable valueAt = sparseArray.valueAt(i10);
            if (valueAt != null) {
                parcelableSparseArray.put(keyAt, valueAt.n());
            } else {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return parcelableSparseArray;
    }

    public static void d(BadgeDrawable badgeDrawable, View view) {
        if (badgeDrawable != null) {
            if (f10444a || badgeDrawable.i() != null) {
                badgeDrawable.i().setForeground(null);
            } else {
                view.getOverlay().remove(badgeDrawable);
            }
        }
    }

    public static void e(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.L(view, frameLayout);
    }

    public static void f(Rect rect, float f10, float f11, float f12, float f13) {
        rect.set((int) (f10 - f12), (int) (f11 - f13), (int) (f10 + f12), (int) (f11 + f13));
    }
}
