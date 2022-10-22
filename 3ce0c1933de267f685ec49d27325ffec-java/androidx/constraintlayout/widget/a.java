package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
/* compiled from: ConstraintHelper.java */
/* loaded from: classes.dex */
public abstract class a extends View {

    /* renamed from: a  reason: collision with root package name */
    protected int[] f1836a;

    /* renamed from: b  reason: collision with root package name */
    protected int f1837b;

    /* renamed from: c  reason: collision with root package name */
    protected Context f1838c;

    /* renamed from: d  reason: collision with root package name */
    protected v.a f1839d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f1840e;

    /* renamed from: f  reason: collision with root package name */
    protected String f1841f;

    /* renamed from: g  reason: collision with root package name */
    protected String f1842g;

    /* renamed from: h  reason: collision with root package name */
    private View[] f1843h;

    /* renamed from: i  reason: collision with root package name */
    protected HashMap<Integer, String> f1844i;

    public a(Context context) {
        super(context);
        this.f1836a = new int[32];
        this.f1840e = false;
        this.f1843h = null;
        this.f1844i = new HashMap<>();
        this.f1838c = context;
        m(null);
    }

    private void d(String str) {
        if (str != null && str.length() != 0 && this.f1838c != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int k10 = k(trim);
            if (k10 != 0) {
                this.f1844i.put(Integer.valueOf(k10), trim);
                e(k10);
                return;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(trim).length() + 23);
            sb2.append("Could not find id of \"");
            sb2.append(trim);
            sb2.append("\"");
            Log.w("ConstraintHelper", sb2.toString());
        }
    }

    private void e(int i10) {
        if (i10 != getId()) {
            int i11 = this.f1837b + 1;
            int[] iArr = this.f1836a;
            if (i11 > iArr.length) {
                this.f1836a = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.f1836a;
            int i12 = this.f1837b;
            iArr2[i12] = i10;
            this.f1837b = i12 + 1;
        }
    }

    private void f(String str) {
        if (!(str == null || str.length() == 0 || this.f1838c == null)) {
            String trim = str.trim();
            ConstraintLayout constraintLayout = null;
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            }
            if (constraintLayout == null) {
                Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
                return;
            }
            int childCount = constraintLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = constraintLayout.getChildAt(i10);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((layoutParams instanceof ConstraintLayout.b) && trim.equals(((ConstraintLayout.b) layoutParams).X)) {
                    if (childAt.getId() == -1) {
                        String simpleName = childAt.getClass().getSimpleName();
                        StringBuilder sb2 = new StringBuilder(simpleName.length() + 42);
                        sb2.append("to use ConstraintTag view ");
                        sb2.append(simpleName);
                        sb2.append(" must have an ID");
                        Log.w("ConstraintHelper", sb2.toString());
                    } else {
                        e(childAt.getId());
                    }
                }
            }
        }
    }

    private int j(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f1838c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int k(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i10 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object p10 = constraintLayout.p(0, str);
            if (p10 instanceof Integer) {
                i10 = ((Integer) p10).intValue();
            }
        }
        if (i10 == 0 && constraintLayout != null) {
            i10 = j(constraintLayout, str);
        }
        if (i10 == 0) {
            try {
                i10 = g.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i10 == 0 ? this.f1838c.getResources().getIdentifier(str, "id", this.f1838c.getPackageName()) : i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            h((ConstraintLayout) parent);
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1836a, this.f1837b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
        for (int i10 = 0; i10 < this.f1837b; i10++) {
            View r10 = constraintLayout.r(this.f1836a[i10]);
            if (r10 != null) {
                r10.setVisibility(visibility);
                if (elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    r10.setTranslationZ(r10.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(ConstraintLayout constraintLayout) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View[] l(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f1843h;
        if (viewArr == null || viewArr.length != this.f1837b) {
            this.f1843h = new View[this.f1837b];
        }
        for (int i10 = 0; i10 < this.f1837b; i10++) {
            this.f1843h[i10] = constraintLayout.r(this.f1836a[i10]);
        }
        return this.f1843h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.T0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.f2018f1) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1841f = string;
                    setIds(string);
                } else if (index == h.f2026g1) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f1842g = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void n(ConstraintWidget constraintWidget, boolean z10) {
    }

    public void o(ConstraintLayout constraintLayout) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1841f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f1842g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f1840e) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(ConstraintLayout constraintLayout) {
    }

    public void q(ConstraintLayout constraintLayout) {
    }

    public void r(ConstraintLayout constraintLayout) {
        String str;
        int j10;
        if (isInEditMode()) {
            setIds(this.f1841f);
        }
        v.a aVar = this.f1839d;
        if (aVar != null) {
            aVar.a();
            for (int i10 = 0; i10 < this.f1837b; i10++) {
                int i11 = this.f1836a[i10];
                View r10 = constraintLayout.r(i11);
                if (r10 == null && (j10 = j(constraintLayout, (str = this.f1844i.get(Integer.valueOf(i11))))) != 0) {
                    this.f1836a[i10] = j10;
                    this.f1844i.put(Integer.valueOf(j10), str);
                    r10 = constraintLayout.r(j10);
                }
                if (r10 != null) {
                    this.f1839d.b(constraintLayout.s(r10));
                }
            }
            this.f1839d.c(constraintLayout.f1766c);
        }
    }

    public void s() {
        if (this.f1839d != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.b) {
                ((ConstraintLayout.b) layoutParams).f1817q0 = (ConstraintWidget) this.f1839d;
            }
        }
    }

    protected void setIds(String str) {
        this.f1841f = str;
        if (str != null) {
            int i10 = 0;
            this.f1837b = 0;
            while (true) {
                int indexOf = str.indexOf(44, i10);
                if (indexOf == -1) {
                    d(str.substring(i10));
                    return;
                } else {
                    d(str.substring(i10, indexOf));
                    i10 = indexOf + 1;
                }
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.f1842g = str;
        if (str != null) {
            int i10 = 0;
            this.f1837b = 0;
            while (true) {
                int indexOf = str.indexOf(44, i10);
                if (indexOf == -1) {
                    f(str.substring(i10));
                    return;
                } else {
                    f(str.substring(i10, indexOf));
                    i10 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1841f = null;
        this.f1837b = 0;
        for (int i10 : iArr) {
            e(i10);
        }
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        super.setTag(i10, obj);
        if (obj == null && this.f1841f == null) {
            e(i10);
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1836a = new int[32];
        this.f1840e = false;
        this.f1843h = null;
        this.f1844i = new HashMap<>();
        this.f1838c = context;
        m(attributeSet);
    }
}
