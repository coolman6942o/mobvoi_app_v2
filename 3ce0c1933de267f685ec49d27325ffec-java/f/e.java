package f;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;
import f.b;
/* compiled from: StateListDrawable.java */
@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
class e extends b {

    /* renamed from: m  reason: collision with root package name */
    private a f26317m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f26318n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateListDrawable.java */
    /* loaded from: classes.dex */
    public static class a extends b.d {
        int[][] J;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a aVar, e eVar, Resources resources) {
            super(aVar, eVar, resources);
            if (aVar != null) {
                this.J = aVar.J;
            } else {
                this.J = new int[f()];
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int A(int[] iArr) {
            int[][] iArr2 = this.J;
            int h10 = h();
            for (int i10 = 0; i10 < h10; i10++) {
                if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new e(this, null);
        }

        @Override // f.b.d
        public void o(int i10, int i11) {
            super.o(i10, i11);
            int[][] iArr = new int[i11];
            System.arraycopy(this.J, 0, iArr, 0, i10);
            this.J = iArr;
        }

        @Override // f.b.d
        void r() {
            int[][] iArr = this.J;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.J = iArr2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int z(int[] iArr, Drawable drawable) {
            int a10 = a(drawable);
            this.J[a10] = iArr;
            return a10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new e(this, resources);
        }
    }

    e(a aVar, Resources resources) {
        h(new a(aVar, this, resources));
        onStateChange(getState());
    }

    @Override // f.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // f.b
    public void h(b.d dVar) {
        super.h(dVar);
        if (dVar instanceof a) {
            this.f26317m = (a) dVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public a b() {
        return new a(this.f26317m, this, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int[] k(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i10 = 0;
        for (int i11 = 0; i11 < attributeCount; i11++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i11);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                i10++;
                if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i10] = attributeNameResource;
            }
        }
        return StateSet.trimStateSet(iArr, i10);
    }

    @Override // f.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f26318n && super.mutate() == this) {
            this.f26317m.r();
            this.f26318n = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // f.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int A = this.f26317m.A(iArr);
        if (A < 0) {
            A = this.f26317m.A(StateSet.WILD_CARD);
        }
        return g(A) || onStateChange;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        if (aVar != null) {
            h(aVar);
        }
    }
}
