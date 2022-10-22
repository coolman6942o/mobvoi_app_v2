package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.core.view.d0;
import androidx.core.view.i;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.m;
import d7.k;
import d7.l;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import k0.c;
import w7.k;
/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: k  reason: collision with root package name */
    private static final String f10588k = MaterialButtonToggleGroup.class.getSimpleName();

    /* renamed from: l  reason: collision with root package name */
    private static final int f10589l = k.f25359x;

    /* renamed from: a  reason: collision with root package name */
    private final List<d> f10590a;

    /* renamed from: b  reason: collision with root package name */
    private final c f10591b;

    /* renamed from: c  reason: collision with root package name */
    private final f f10592c;

    /* renamed from: d  reason: collision with root package name */
    private final LinkedHashSet<e> f10593d;

    /* renamed from: e  reason: collision with root package name */
    private final Comparator<MaterialButton> f10594e;

    /* renamed from: f  reason: collision with root package name */
    private Integer[] f10595f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10596g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10597h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10598i;

    /* renamed from: j  reason: collision with root package name */
    private int f10599j;

    /* loaded from: classes.dex */
    class a implements Comparator<MaterialButton> {
        a() {
        }

        /* renamed from: a */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    /* loaded from: classes.dex */
    class b extends androidx.core.view.a {
        b() {
        }

        @Override // androidx.core.view.a
        public void g(View view, k0.c cVar) {
            super.g(view, cVar);
            cVar.d0(c.C0359c.a(0, 1, MaterialButtonToggleGroup.this.o(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements MaterialButton.a {
        private c() {
        }

        @Override // com.google.android.material.button.MaterialButton.a
        public void a(MaterialButton materialButton, boolean z10) {
            if (!MaterialButtonToggleGroup.this.f10596g) {
                if (MaterialButtonToggleGroup.this.f10597h) {
                    MaterialButtonToggleGroup.this.f10599j = z10 ? materialButton.getId() : -1;
                }
                if (MaterialButtonToggleGroup.this.v(materialButton.getId(), z10)) {
                    MaterialButtonToggleGroup.this.m(materialButton.getId(), materialButton.isChecked());
                }
                MaterialButtonToggleGroup.this.invalidate();
            }
        }

        /* synthetic */ c(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: e  reason: collision with root package name */
        private static final w7.c f10603e = new w7.a(0.0f);

        /* renamed from: a  reason: collision with root package name */
        w7.c f10604a;

        /* renamed from: b  reason: collision with root package name */
        w7.c f10605b;

        /* renamed from: c  reason: collision with root package name */
        w7.c f10606c;

        /* renamed from: d  reason: collision with root package name */
        w7.c f10607d;

        d(w7.c cVar, w7.c cVar2, w7.c cVar3, w7.c cVar4) {
            this.f10604a = cVar;
            this.f10605b = cVar3;
            this.f10606c = cVar4;
            this.f10607d = cVar2;
        }

        public static d a(d dVar) {
            w7.c cVar = f10603e;
            return new d(cVar, dVar.f10607d, cVar, dVar.f10606c);
        }

        public static d b(d dVar, View view) {
            return m.d(view) ? c(dVar) : d(dVar);
        }

        public static d c(d dVar) {
            w7.c cVar = dVar.f10604a;
            w7.c cVar2 = dVar.f10607d;
            w7.c cVar3 = f10603e;
            return new d(cVar, cVar2, cVar3, cVar3);
        }

        public static d d(d dVar) {
            w7.c cVar = f10603e;
            return new d(cVar, cVar, dVar.f10605b, dVar.f10606c);
        }

        public static d e(d dVar, View view) {
            return m.d(view) ? d(dVar) : c(dVar);
        }

        public static d f(d dVar) {
            w7.c cVar = dVar.f10604a;
            w7.c cVar2 = f10603e;
            return new d(cVar, cVar2, dVar.f10605b, cVar2);
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f implements MaterialButton.b {
        private f() {
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(MaterialButton materialButton, boolean z10) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        /* synthetic */ f(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.A);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (q(i10)) {
                return i10;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (q(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if ((getChildAt(i11) instanceof MaterialButton) && q(i11)) {
                i10++;
            }
        }
        return i10;
    }

    private void h() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex != -1) {
            for (int i10 = firstVisibleChildIndex + 1; i10 < getChildCount(); i10++) {
                MaterialButton n10 = n(i10);
                int min = Math.min(n10.getStrokeWidth(), n(i10 - 1).getStrokeWidth());
                LinearLayout.LayoutParams i11 = i(n10);
                if (getOrientation() == 0) {
                    i.c(i11, 0);
                    i.d(i11, -min);
                    i11.topMargin = 0;
                } else {
                    i11.bottomMargin = 0;
                    i11.topMargin = -min;
                    i.d(i11, 0);
                }
                n10.setLayoutParams(i11);
            }
            s(firstVisibleChildIndex);
        }
    }

    private LinearLayout.LayoutParams i(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void k(int i10, boolean z10) {
        MaterialButton materialButton = (MaterialButton) findViewById(i10);
        if (materialButton != null) {
            materialButton.setChecked(z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i10, boolean z10) {
        Iterator<e> it = this.f10593d.iterator();
        while (it.hasNext()) {
            it.next().a(this, i10, z10);
        }
    }

    private MaterialButton n(int i10) {
        return (MaterialButton) getChildAt(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == view) {
                return i10;
            }
            if ((getChildAt(i11) instanceof MaterialButton) && q(i11)) {
                i10++;
            }
        }
        return -1;
    }

    private d p(int i10, int i11, int i12) {
        d dVar = this.f10590a.get(i10);
        if (i11 == i12) {
            return dVar;
        }
        boolean z10 = getOrientation() == 0;
        if (i10 == i11) {
            return z10 ? d.e(dVar, this) : d.f(dVar);
        }
        if (i10 == i12) {
            return z10 ? d.b(dVar, this) : d.a(dVar);
        }
        return null;
    }

    private boolean q(int i10) {
        return getChildAt(i10).getVisibility() != 8;
    }

    private void s(int i10) {
        if (getChildCount() != 0 && i10 != -1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) n(i10).getLayoutParams();
            if (getOrientation() == 1) {
                layoutParams.topMargin = 0;
                layoutParams.bottomMargin = 0;
                return;
            }
            i.c(layoutParams, 0);
            i.d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void setCheckedId(int i10) {
        this.f10599j = i10;
        m(i10, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(d0.m());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.a(this.f10591b);
        materialButton.setOnPressedChangeListenerInternal(this.f10592c);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private void t(int i10, boolean z10) {
        View findViewById = findViewById(i10);
        if (findViewById instanceof MaterialButton) {
            this.f10596g = true;
            ((MaterialButton) findViewById).setChecked(z10);
            this.f10596g = false;
        }
    }

    private static void u(k.b bVar, d dVar) {
        if (dVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.B(dVar.f10604a).t(dVar.f10607d).F(dVar.f10605b).x(dVar.f10606c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(int i10, boolean z10) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (!this.f10598i || !checkedButtonIds.isEmpty()) {
            if (z10 && this.f10597h) {
                checkedButtonIds.remove(Integer.valueOf(i10));
                for (Integer num : checkedButtonIds) {
                    int intValue = num.intValue();
                    t(intValue, false);
                    m(intValue, false);
                }
            }
            return true;
        }
        t(i10, true);
        this.f10599j = i10;
        return false;
    }

    private void w() {
        TreeMap treeMap = new TreeMap(this.f10594e);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            treeMap.put(n(i10), Integer.valueOf(i10));
        }
        this.f10595f = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f10588k, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i10, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            v(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        w7.k shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f10590a.add(new d(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        d0.t0(materialButton, new b());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        w();
        super.dispatchDraw(canvas);
    }

    public void g(e eVar) {
        this.f10593d.add(eVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.f10597h) {
            return this.f10599j;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            MaterialButton n10 = n(i10);
            if (n10.isChecked()) {
                arrayList.add(Integer.valueOf(n10.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i10, int i11) {
        Integer[] numArr = this.f10595f;
        if (numArr != null && i11 < numArr.length) {
            return numArr[i11].intValue();
        }
        Log.w(f10588k, "Child order wasn't updated");
        return i11;
    }

    public void j(int i10) {
        if (i10 != this.f10599j) {
            k(i10, true);
        }
    }

    public void l() {
        this.f10596g = true;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            MaterialButton n10 = n(i10);
            n10.setChecked(false);
            m(n10.getId(), false);
        }
        this.f10596g = false;
        setCheckedId(-1);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i10 = this.f10599j;
        if (i10 != -1) {
            k(i10, true);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        k0.c.D0(accessibilityNodeInfo).c0(c.b.a(1, getVisibleButtonCount(), false, r() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        x();
        h();
        super.onMeasure(i10, i11);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.h(this.f10591b);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f10590a.remove(indexOfChild);
        }
        x();
        h();
    }

    public boolean r() {
        return this.f10597h;
    }

    public void setSelectionRequired(boolean z10) {
        this.f10598i = z10;
    }

    public void setSingleSelection(boolean z10) {
        if (this.f10597h != z10) {
            this.f10597h = z10;
            l();
        }
    }

    void x() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i10 = 0; i10 < childCount; i10++) {
            MaterialButton n10 = n(i10);
            if (n10.getVisibility() != 8) {
                k.b v10 = n10.getShapeAppearanceModel().v();
                u(v10, p(i10, firstVisibleChildIndex, lastVisibleChildIndex));
                n10.setShapeAppearanceModel(v10.m());
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f10589l;
        this.f10590a = new ArrayList();
        this.f10591b = new c(this, null);
        this.f10592c = new f(this, null);
        this.f10593d = new LinkedHashSet<>();
        this.f10594e = new a();
        this.f10596g = false;
        TypedArray h10 = com.google.android.material.internal.k.h(getContext(), attributeSet, l.f25516t2, i10, i11, new int[0]);
        setSingleSelection(h10.getBoolean(l.f25540w2, false));
        this.f10599j = h10.getResourceId(l.f25524u2, -1);
        this.f10598i = h10.getBoolean(l.f25532v2, false);
        setChildrenDrawingOrderEnabled(true);
        h10.recycle();
        d0.E0(this, 1);
    }

    public void setSingleSelection(int i10) {
        setSingleSelection(getResources().getBoolean(i10));
    }
}
