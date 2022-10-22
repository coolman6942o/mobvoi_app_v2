package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.view.d0;
import d7.k;
import d7.l;
import java.util.ArrayList;
import java.util.List;
import k0.c;
/* loaded from: classes.dex */
public class ChipGroup extends com.google.android.material.internal.c {

    /* renamed from: n  reason: collision with root package name */
    private static final int f10683n = k.f25353r;

    /* renamed from: e  reason: collision with root package name */
    private int f10684e;

    /* renamed from: f  reason: collision with root package name */
    private int f10685f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10686g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10687h;

    /* renamed from: i  reason: collision with root package name */
    private d f10688i;

    /* renamed from: j  reason: collision with root package name */
    private final b f10689j;

    /* renamed from: k  reason: collision with root package name */
    private e f10690k;

    /* renamed from: l  reason: collision with root package name */
    private int f10691l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10692m;

    /* loaded from: classes.dex */
    private class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            if (!ChipGroup.this.f10692m) {
                if (!ChipGroup.this.getCheckedChipIds().isEmpty() || !ChipGroup.this.f10687h) {
                    int id2 = compoundButton.getId();
                    if (z10) {
                        if (!(ChipGroup.this.f10691l == -1 || ChipGroup.this.f10691l == id2 || !ChipGroup.this.f10686g)) {
                            ChipGroup chipGroup = ChipGroup.this;
                            chipGroup.r(chipGroup.f10691l, false);
                        }
                        ChipGroup.this.setCheckedId(id2);
                    } else if (ChipGroup.this.f10691l == id2) {
                        ChipGroup.this.setCheckedId(-1);
                    }
                } else {
                    ChipGroup.this.r(compoundButton.getId(), true);
                    ChipGroup.this.q(compoundButton.getId(), false);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends ViewGroup.MarginLayoutParams {
        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(int i10, int i11) {
            super(i10, i11);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(ChipGroup chipGroup, int i10);
    }

    /* loaded from: classes.dex */
    private class e implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f10694a;

        private e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(d0.m());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).m(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.f10689j);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f10694a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f10694a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.f25153i);
    }

    private int getChipCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) instanceof Chip) {
                i10++;
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i10, boolean z10) {
        this.f10691l = i10;
        d dVar = this.f10688i;
        if (dVar != null && this.f10686g && z10) {
            dVar.a(this, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i10, boolean z10) {
        View findViewById = findViewById(i10);
        if (findViewById instanceof Chip) {
            this.f10692m = true;
            ((Chip) findViewById).setChecked(z10);
            this.f10692m = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i10) {
        q(i10, true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i11 = this.f10691l;
                if (i11 != -1 && this.f10686g) {
                    r(i11, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i10, layoutParams);
    }

    @Override // com.google.android.material.internal.c
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof c);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        if (this.f10686g) {
            return this.f10691l;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f10686g) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.f10684e;
    }

    public int getChipSpacingVertical() {
        return this.f10685f;
    }

    public void m(int i10) {
        int i11 = this.f10691l;
        if (i10 != i11) {
            if (i11 != -1 && this.f10686g) {
                r(i11, false);
            }
            if (i10 != -1) {
                r(i10, true);
            }
            setCheckedId(i10);
        }
    }

    public void n() {
        this.f10692m = true;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f10692m = false;
        setCheckedId(-1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int o(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) instanceof Chip) {
                if (((Chip) getChildAt(i11)) == view) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f10691l;
        if (i10 != -1) {
            r(i10, true);
            setCheckedId(this.f10691l);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        k0.c.D0(accessibilityNodeInfo).c0(c.b.a(getRowCount(), c() ? getChipCount() : -1, false, p() ? 1 : 2));
    }

    public boolean p() {
        return this.f10686g;
    }

    public void setChipSpacing(int i10) {
        setChipSpacingHorizontal(i10);
        setChipSpacingVertical(i10);
    }

    public void setChipSpacingHorizontal(int i10) {
        if (this.f10684e != i10) {
            this.f10684e = i10;
            setItemSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i10) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingResource(int i10) {
        setChipSpacing(getResources().getDimensionPixelOffset(i10));
    }

    public void setChipSpacingVertical(int i10) {
        if (this.f10685f != i10) {
            this.f10685f = i10;
            setLineSpacing(i10);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i10) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i10));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i10) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(d dVar) {
        this.f10688i = dVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f10690k.f10694a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z10) {
        this.f10687h = z10;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i10) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.c
    public void setSingleLine(boolean z10) {
        super.setSingleLine(z10);
    }

    public void setSingleSelection(boolean z10) {
        if (this.f10686g != z10) {
            this.f10686g = z10;
            n();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ChipGroup(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f10683n;
        this.f10689j = new b();
        this.f10690k = new e();
        this.f10691l = -1;
        this.f10692m = false;
        TypedArray h10 = com.google.android.material.internal.k.h(getContext(), attributeSet, l.X0, i10, i11, new int[0]);
        int dimensionPixelOffset = h10.getDimensionPixelOffset(l.Z0, 0);
        setChipSpacingHorizontal(h10.getDimensionPixelOffset(l.f25364a1, dimensionPixelOffset));
        setChipSpacingVertical(h10.getDimensionPixelOffset(l.f25372b1, dimensionPixelOffset));
        setSingleLine(h10.getBoolean(l.f25388d1, false));
        setSingleSelection(h10.getBoolean(l.f25396e1, false));
        setSelectionRequired(h10.getBoolean(l.f25380c1, false));
        int resourceId = h10.getResourceId(l.Y0, -1);
        if (resourceId != -1) {
            this.f10691l = resourceId;
        }
        h10.recycle();
        super.setOnHierarchyChangeListener(this.f10690k);
        d0.E0(this, 1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new c(layoutParams);
    }

    public void setSingleLine(int i10) {
        setSingleLine(getResources().getBoolean(i10));
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}
