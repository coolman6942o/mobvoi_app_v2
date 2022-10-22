package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import k0.c;
/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    int[] K;
    View[] L;
    private boolean Q;
    boolean I = false;
    int J = -1;
    final SparseIntArray M = new SparseIntArray();
    final SparseIntArray N = new SparseIntArray();
    c O = new a();
    final Rect P = new Rect();

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanIndex(int i10, int i11) {
            return i10 % i11;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i10) {
            int size = sparseIntArray.size() - 1;
            int i11 = 0;
            while (i11 <= size) {
                int i12 = (i11 + size) >>> 1;
                if (sparseIntArray.keyAt(i12) < i10) {
                    i11 = i12 + 1;
                } else {
                    size = i12 - 1;
                }
            }
            int i13 = i11 - 1;
            if (i13 < 0 || i13 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i13);
        }

        int getCachedSpanGroupIndex(int i10, int i11) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i10, i11);
            }
            int i12 = this.mSpanGroupIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanGroupIndex = getSpanGroupIndex(i10, i11);
            this.mSpanGroupIndexCache.put(i10, spanGroupIndex);
            return spanGroupIndex;
        }

        int getCachedSpanIndex(int i10, int i11) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i10, i11);
            }
            int i12 = this.mSpanIndexCache.get(i10, -1);
            if (i12 != -1) {
                return i12;
            }
            int spanIndex = getSpanIndex(i10, i11);
            this.mSpanIndexCache.put(i10, spanIndex);
            return spanIndex;
        }

        public int getSpanGroupIndex(int i10, int i11) {
            int i12;
            int i13;
            int i14;
            int findFirstKeyLessThan;
            if (!this.mCacheSpanGroupIndices || (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i10)) == -1) {
                i14 = 0;
                i13 = 0;
                i12 = 0;
            } else {
                i14 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i13 = findFirstKeyLessThan + 1;
                i12 = getCachedSpanIndex(findFirstKeyLessThan, i11) + getSpanSize(findFirstKeyLessThan);
                if (i12 == i11) {
                    i14++;
                    i12 = 0;
                }
            }
            int spanSize = getSpanSize(i10);
            while (i13 < i10) {
                int spanSize2 = getSpanSize(i13);
                i12 += spanSize2;
                if (i12 == i11) {
                    i14++;
                    i12 = 0;
                } else if (i12 > i11) {
                    i14++;
                    i12 = spanSize2;
                }
                i13++;
            }
            return i12 + spanSize > i11 ? i14 + 1 : i14;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanIndex(int i10, int i11) {
            int i12;
            int i13;
            int spanSize = getSpanSize(i10);
            if (spanSize == i11) {
                return 0;
            }
            if (!this.mCacheSpanIndices || (i13 = findFirstKeyLessThan(this.mSpanIndexCache, i10)) < 0) {
                i13 = 0;
                i12 = 0;
                if (i13 >= i10) {
                    int spanSize2 = getSpanSize(i13);
                    i12 += spanSize2;
                    if (i12 == i11) {
                        i12 = 0;
                    } else if (i12 > i11) {
                        i12 = spanSize2;
                    }
                    i13++;
                    if (i13 >= i10) {
                        if (spanSize + i12 <= i11) {
                            return i12;
                        }
                        return 0;
                    }
                }
            } else {
                i12 = this.mSpanIndexCache.get(i13) + getSpanSize(i13);
                i13++;
                if (i13 >= i10) {
                }
            }
        }

        public abstract int getSpanSize(int i10);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z10;
        }

        public void setSpanIndexCacheEnabled(boolean z10) {
            if (!z10) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z10;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        d3(RecyclerView.LayoutManager.j0(context, attributeSet, i10, i11).spanCount);
    }

    private void M2(RecyclerView.u uVar, RecyclerView.y yVar, int i10, boolean z10) {
        int i11;
        int i12;
        int i13 = 0;
        int i14 = -1;
        if (z10) {
            i11 = 1;
            i14 = i10;
            i12 = 0;
        } else {
            i12 = i10 - 1;
            i11 = -1;
        }
        while (i12 != i14) {
            View view = this.L[i12];
            b bVar = (b) view.getLayoutParams();
            int Z2 = Z2(uVar, yVar, i0(view));
            bVar.f3704f = Z2;
            bVar.f3703e = i13;
            i13 += Z2;
            i12 += i11;
        }
    }

    private void N2() {
        int K = K();
        for (int i10 = 0; i10 < K; i10++) {
            b bVar = (b) J(i10).getLayoutParams();
            int a10 = bVar.a();
            this.M.put(a10, bVar.f());
            this.N.put(a10, bVar.e());
        }
    }

    private void O2(int i10) {
        this.K = P2(this.K, this.J, i10);
    }

    static int[] P2(int[] iArr, int i10, int i11) {
        int i12;
        if (!(iArr != null && iArr.length == i10 + 1 && iArr[iArr.length - 1] == i11)) {
            iArr = new int[i10 + 1];
        }
        int i13 = 0;
        iArr[0] = 0;
        int i14 = i11 / i10;
        int i15 = i11 % i10;
        int i16 = 0;
        for (int i17 = 1; i17 <= i10; i17++) {
            i13 += i15;
            if (i13 <= 0 || i10 - i13 >= i15) {
                i12 = i14;
            } else {
                i12 = i14 + 1;
                i13 -= i10;
            }
            i16 += i12;
            iArr[i17] = i16;
        }
        return iArr;
    }

    private void Q2() {
        this.M.clear();
        this.N.clear();
    }

    private int R2(RecyclerView.y yVar) {
        int i10;
        if (!(K() == 0 || yVar.b() == 0)) {
            U1();
            boolean p22 = p2();
            View Y1 = Y1(!p22, true);
            View X1 = X1(!p22, true);
            if (!(Y1 == null || X1 == null)) {
                int cachedSpanGroupIndex = this.O.getCachedSpanGroupIndex(i0(Y1), this.J);
                int cachedSpanGroupIndex2 = this.O.getCachedSpanGroupIndex(i0(X1), this.J);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.O.getCachedSpanGroupIndex(yVar.b() - 1, this.J) + 1;
                if (this.f3710x) {
                    i10 = Math.max(0, (cachedSpanGroupIndex3 - max) - 1);
                } else {
                    i10 = Math.max(0, min);
                }
                if (!p22) {
                    return i10;
                }
                return Math.round((i10 * (Math.abs(this.f3707u.d(X1) - this.f3707u.g(Y1)) / ((this.O.getCachedSpanGroupIndex(i0(X1), this.J) - this.O.getCachedSpanGroupIndex(i0(Y1), this.J)) + 1))) + (this.f3707u.m() - this.f3707u.g(Y1)));
            }
        }
        return 0;
    }

    private int S2(RecyclerView.y yVar) {
        if (!(K() == 0 || yVar.b() == 0)) {
            U1();
            View Y1 = Y1(!p2(), true);
            View X1 = X1(!p2(), true);
            if (!(Y1 == null || X1 == null)) {
                if (!p2()) {
                    return this.O.getCachedSpanGroupIndex(yVar.b() - 1, this.J) + 1;
                }
                int d10 = this.f3707u.d(X1) - this.f3707u.g(Y1);
                int cachedSpanGroupIndex = this.O.getCachedSpanGroupIndex(i0(Y1), this.J);
                return (int) ((d10 / ((this.O.getCachedSpanGroupIndex(i0(X1), this.J) - cachedSpanGroupIndex) + 1)) * (this.O.getCachedSpanGroupIndex(yVar.b() - 1, this.J) + 1));
            }
        }
        return 0;
    }

    private void T2(RecyclerView.u uVar, RecyclerView.y yVar, LinearLayoutManager.a aVar, int i10) {
        boolean z10 = i10 == 1;
        int Y2 = Y2(uVar, yVar, aVar.f3717b);
        if (z10) {
            while (Y2 > 0) {
                int i11 = aVar.f3717b;
                if (i11 > 0) {
                    int i12 = i11 - 1;
                    aVar.f3717b = i12;
                    Y2 = Y2(uVar, yVar, i12);
                } else {
                    return;
                }
            }
            return;
        }
        int b10 = yVar.b() - 1;
        int i13 = aVar.f3717b;
        while (i13 < b10) {
            int i14 = i13 + 1;
            int Y22 = Y2(uVar, yVar, i14);
            if (Y22 <= Y2) {
                break;
            }
            i13 = i14;
            Y2 = Y22;
        }
        aVar.f3717b = i13;
    }

    private void U2() {
        View[] viewArr = this.L;
        if (viewArr == null || viewArr.length != this.J) {
            this.L = new View[this.J];
        }
    }

    private int X2(RecyclerView.u uVar, RecyclerView.y yVar, int i10) {
        if (!yVar.e()) {
            return this.O.getCachedSpanGroupIndex(i10, this.J);
        }
        int f10 = uVar.f(i10);
        if (f10 != -1) {
            return this.O.getCachedSpanGroupIndex(f10, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i10);
        return 0;
    }

    private int Y2(RecyclerView.u uVar, RecyclerView.y yVar, int i10) {
        if (!yVar.e()) {
            return this.O.getCachedSpanIndex(i10, this.J);
        }
        int i11 = this.N.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = uVar.f(i10);
        if (f10 != -1) {
            return this.O.getCachedSpanIndex(f10, this.J);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 0;
    }

    private int Z2(RecyclerView.u uVar, RecyclerView.y yVar, int i10) {
        if (!yVar.e()) {
            return this.O.getSpanSize(i10);
        }
        int i11 = this.M.get(i10, -1);
        if (i11 != -1) {
            return i11;
        }
        int f10 = uVar.f(i10);
        if (f10 != -1) {
            return this.O.getSpanSize(f10);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i10);
        return 1;
    }

    private void a3(float f10, int i10) {
        O2(Math.max(Math.round(f10 * this.J), i10));
    }

    private void b3(View view, int i10, boolean z10) {
        int i11;
        int i12;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f3825b;
        int i13 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i14 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int V2 = V2(bVar.f3703e, bVar.f3704f);
        if (this.f3705s == 1) {
            i11 = RecyclerView.LayoutManager.L(V2, i10, i14, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i12 = RecyclerView.LayoutManager.L(this.f3707u.n(), Y(), i13, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            i12 = RecyclerView.LayoutManager.L(V2, i10, i13, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            i11 = RecyclerView.LayoutManager.L(this.f3707u.n(), q0(), i14, ((ViewGroup.MarginLayoutParams) bVar).width, true);
        }
        c3(view, i11, i12, z10);
    }

    private void c3(View view, int i10, int i11, boolean z10) {
        boolean z11;
        RecyclerView.o oVar = (RecyclerView.o) view.getLayoutParams();
        if (z10) {
            z11 = I1(view, i10, i11, oVar);
        } else {
            z11 = G1(view, i10, i11, oVar);
        }
        if (z11) {
            view.measure(i10, i11);
        }
    }

    private void f3() {
        int i10;
        int i11;
        if (n2() == 1) {
            i11 = p0() - g0();
            i10 = f0();
        } else {
            i11 = X() - e0();
            i10 = h0();
        }
        O2(i11 - i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void D1(Rect rect, int i10, int i11) {
        int i12;
        int i13;
        if (this.K == null) {
            super.D1(rect, i10, i11);
        }
        int f02 = f0() + g0();
        int h02 = h0() + e0();
        if (this.f3705s == 1) {
            i13 = RecyclerView.LayoutManager.o(i11, rect.height() + h02, c0());
            int[] iArr = this.K;
            i12 = RecyclerView.LayoutManager.o(i10, iArr[iArr.length - 1] + f02, d0());
        } else {
            i12 = RecyclerView.LayoutManager.o(i10, rect.width() + f02, d0());
            int[] iArr2 = this.K;
            i13 = RecyclerView.LayoutManager.o(i11, iArr2[iArr2.length - 1] + h02, c0());
        }
        C1(i12, i13);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void D2(boolean z10) {
        if (!z10) {
            super.D2(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.o E() {
        if (this.f3705s == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.o F(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.o G(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00d6, code lost:
        if (r13 == (r2 > r15)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f6, code lost:
        if (r13 == r11) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View K0(View view, int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        int i11;
        int i12;
        int i13;
        int i14;
        View view2;
        View view3;
        int i15;
        int i16;
        int i17;
        boolean z10;
        RecyclerView.u uVar2 = uVar;
        RecyclerView.y yVar2 = yVar;
        View C = C(view);
        View view4 = null;
        if (C == null) {
            return null;
        }
        b bVar = (b) C.getLayoutParams();
        int i18 = bVar.f3703e;
        int i19 = bVar.f3704f + i18;
        if (super.K0(view, i10, uVar, yVar) == null) {
            return null;
        }
        if ((S1(i10) == 1) != this.f3710x) {
            i13 = K() - 1;
            i12 = -1;
            i11 = -1;
        } else {
            i12 = K();
            i11 = 1;
            i13 = 0;
        }
        boolean z11 = this.f3705s == 1 && o2();
        int X2 = X2(uVar2, yVar2, i13);
        int i20 = -1;
        int i21 = -1;
        int i22 = 0;
        int i23 = 0;
        int i24 = i13;
        View view5 = null;
        while (i24 != i12) {
            int X22 = X2(uVar2, yVar2, i24);
            View J = J(i24);
            if (J == C) {
                break;
            }
            if (!J.hasFocusable() || X22 == X2) {
                b bVar2 = (b) J.getLayoutParams();
                int i25 = bVar2.f3703e;
                view2 = C;
                int i26 = bVar2.f3704f + i25;
                if (J.hasFocusable() && i25 == i18 && i26 == i19) {
                    return J;
                }
                if ((!J.hasFocusable() || view4 != null) && (J.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int min = Math.min(i26, i19) - Math.max(i25, i18);
                    if (J.hasFocusable()) {
                        if (min <= i22) {
                            if (min == i22) {
                            }
                        }
                    } else if (view4 == null) {
                        i15 = i22;
                        i14 = i12;
                        z10 = true;
                        if (z0(J, false, true)) {
                            i16 = i23;
                            if (min > i16) {
                                i17 = i21;
                                if (z10) {
                                    if (J.hasFocusable()) {
                                        int i27 = bVar2.f3703e;
                                        i22 = Math.min(i26, i19) - Math.max(i25, i18);
                                        i20 = i27;
                                        i21 = i17;
                                        i23 = i16;
                                        view5 = view3;
                                        view4 = J;
                                    } else {
                                        int i28 = bVar2.f3703e;
                                        i23 = Math.min(i26, i19) - Math.max(i25, i18);
                                        i21 = i28;
                                        i22 = i15;
                                        view5 = J;
                                    }
                                    i24 += i11;
                                    uVar2 = uVar;
                                    yVar2 = yVar;
                                    C = view2;
                                    i12 = i14;
                                }
                            } else {
                                if (min == i16) {
                                    i17 = i21;
                                    if (i25 <= i17) {
                                        z10 = false;
                                    }
                                } else {
                                    i17 = i21;
                                }
                                z10 = false;
                                if (z10) {
                                }
                            }
                        }
                        i17 = i21;
                        i16 = i23;
                        z10 = false;
                        if (z10) {
                        }
                    }
                    i15 = i22;
                    i14 = i12;
                    i17 = i21;
                    i16 = i23;
                    z10 = false;
                    if (z10) {
                    }
                } else {
                    view3 = view5;
                }
                i15 = i22;
                i14 = i12;
                i17 = i21;
                i16 = i23;
                z10 = true;
                if (z10) {
                }
            } else if (view4 != null) {
                break;
            } else {
                view2 = C;
                view3 = view5;
                i15 = i22;
                i14 = i12;
                i17 = i21;
                i16 = i23;
            }
            i21 = i17;
            i23 = i16;
            i22 = i15;
            view5 = view3;
            i24 += i11;
            uVar2 = uVar;
            yVar2 = yVar;
            C = view2;
            i12 = i14;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean M1() {
        return this.D == null && !this.I;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int O(RecyclerView.u uVar, RecyclerView.y yVar) {
        if (this.f3705s == 1) {
            return this.J;
        }
        if (yVar.b() < 1) {
            return 0;
        }
        return X2(uVar, yVar, yVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void O1(RecyclerView.y yVar, LinearLayoutManager.c cVar, RecyclerView.LayoutManager.c cVar2) {
        int i10 = this.J;
        for (int i11 = 0; i11 < this.J && cVar.c(yVar) && i10 > 0; i11++) {
            int i12 = cVar.f3728d;
            cVar2.a(i12, Math.max(0, cVar.f3731g));
            i10 -= this.O.getSpanSize(i12);
            cVar.f3728d += cVar.f3729e;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Q0(RecyclerView.u uVar, RecyclerView.y yVar, View view, k0.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.P0(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        int X2 = X2(uVar, yVar, bVar.a());
        if (this.f3705s == 0) {
            cVar.d0(c.C0359c.a(bVar.e(), bVar.f(), X2, 1, false, false));
        } else {
            cVar.d0(c.C0359c.a(X2, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void S0(RecyclerView recyclerView, int i10, int i11) {
        this.O.invalidateSpanIndexCache();
        this.O.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void T0(RecyclerView recyclerView) {
        this.O.invalidateSpanIndexCache();
        this.O.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void U0(RecyclerView recyclerView, int i10, int i11, int i12) {
        this.O.invalidateSpanIndexCache();
        this.O.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void V0(RecyclerView recyclerView, int i10, int i11) {
        this.O.invalidateSpanIndexCache();
        this.O.invalidateSpanGroupIndexCache();
    }

    int V2(int i10, int i11) {
        if (this.f3705s != 1 || !o2()) {
            int[] iArr = this.K;
            return iArr[i11 + i10] - iArr[i10];
        }
        int[] iArr2 = this.K;
        int i12 = this.J;
        return iArr2[i12 - i10] - iArr2[(i12 - i10) - i11];
    }

    public int W2() {
        return this.J;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void X0(RecyclerView recyclerView, int i10, int i11, Object obj) {
        this.O.invalidateSpanIndexCache();
        this.O.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Y0(RecyclerView.u uVar, RecyclerView.y yVar) {
        if (yVar.e()) {
            N2();
        }
        super.Y0(uVar, yVar);
        Q2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void Z0(RecyclerView.y yVar) {
        super.Z0(yVar);
        this.I = false;
    }

    public void d3(int i10) {
        if (i10 != this.J) {
            this.I = true;
            if (i10 >= 1) {
                this.J = i10;
                this.O.invalidateSpanIndexCache();
                u1();
                return;
            }
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i10);
        }
    }

    public void e3(c cVar) {
        this.O = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View h2(RecyclerView.u uVar, RecyclerView.y yVar, boolean z10, boolean z11) {
        int i10;
        int K = K();
        int i11 = -1;
        int i12 = 1;
        if (z11) {
            i10 = K() - 1;
            i12 = -1;
        } else {
            i10 = 0;
            i11 = K;
        }
        int b10 = yVar.b();
        U1();
        int m10 = this.f3707u.m();
        int i13 = this.f3707u.i();
        View view = null;
        View view2 = null;
        while (i10 != i11) {
            View J = J(i10);
            int i02 = i0(J);
            if (i02 >= 0 && i02 < b10 && Y2(uVar, yVar, i02) == 0) {
                if (((RecyclerView.o) J.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = J;
                    }
                } else if (this.f3707u.g(J) < i13 && this.f3707u.d(J) >= m10) {
                    return J;
                } else {
                    if (view == null) {
                        view = J;
                    }
                }
            }
            i10 += i12;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int l0(RecyclerView.u uVar, RecyclerView.y yVar) {
        if (this.f3705s == 0) {
            return this.J;
        }
        if (yVar.b() < 1) {
            return 0;
        }
        return X2(uVar, yVar, yVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean n(RecyclerView.o oVar) {
        return oVar instanceof b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x009f, code lost:
        r21.f3722b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a1, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void q2(RecyclerView.u uVar, RecyclerView.y yVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        View d10;
        int l10 = this.f3707u.l();
        ?? r52 = 0;
        Object[] objArr = l10 != 1073741824 ? 1 : null;
        int i20 = K() > 0 ? this.K[this.J] : 0;
        if (objArr != null) {
            f3();
        }
        boolean z10 = cVar.f3729e == 1;
        int i21 = this.J;
        if (!z10) {
            i21 = Y2(uVar, yVar, cVar.f3728d) + Z2(uVar, yVar, cVar.f3728d);
        }
        int i22 = 0;
        while (i22 < this.J && cVar.c(yVar) && i21 > 0) {
            int i23 = cVar.f3728d;
            int Z2 = Z2(uVar, yVar, i23);
            if (Z2 <= this.J) {
                i21 -= Z2;
                if (i21 < 0 || (d10 = cVar.d(uVar)) == null) {
                    break;
                }
                this.L[i22] = d10;
                i22++;
            } else {
                throw new IllegalArgumentException("Item at position " + i23 + " requires " + Z2 + " spans but GridLayoutManager has only " + this.J + " spans.");
            }
        }
        float f10 = 0.0f;
        M2(uVar, yVar, i22, z10);
        int i24 = 0;
        int i25 = 0;
        while (i24 < i22) {
            View view = this.L[i24];
            if (cVar.f3736l == null) {
                if (z10) {
                    e(view);
                } else {
                    f(view, r52);
                }
            } else if (z10) {
                c(view);
            } else {
                int i26 = r52 == true ? 1 : 0;
                int i27 = r52 == true ? 1 : 0;
                d(view, i26);
            }
            k(view, this.P);
            b3(view, l10, r52);
            int e10 = this.f3707u.e(view);
            if (e10 > i25) {
                i25 = e10;
            }
            float f11 = (this.f3707u.f(view) * 1.0f) / ((b) view.getLayoutParams()).f3704f;
            if (f11 > f10) {
                f10 = f11;
            }
            i24++;
            r52 = 0;
        }
        if (objArr != null) {
            a3(f10, i20);
            i25 = 0;
            for (int i28 = 0; i28 < i22; i28++) {
                View view2 = this.L[i28];
                b3(view2, 1073741824, true);
                int e11 = this.f3707u.e(view2);
                if (e11 > i25) {
                    i25 = e11;
                }
            }
        }
        for (int i29 = 0; i29 < i22; i29++) {
            View view3 = this.L[i29];
            if (this.f3707u.e(view3) != i25) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.f3825b;
                int i30 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i31 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int V2 = V2(bVar2.f3703e, bVar2.f3704f);
                if (this.f3705s == 1) {
                    i19 = RecyclerView.LayoutManager.L(V2, 1073741824, i31, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    i18 = View.MeasureSpec.makeMeasureSpec(i25 - i30, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i25 - i31, 1073741824);
                    i18 = RecyclerView.LayoutManager.L(V2, 1073741824, i30, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    i19 = makeMeasureSpec;
                }
                c3(view3, i19, i18, true);
            }
        }
        int i32 = 0;
        bVar.f3721a = i25;
        if (this.f3705s == 1) {
            if (cVar.f3730f == -1) {
                i13 = cVar.f3726b;
                i10 = i13 - i25;
            } else {
                int i33 = cVar.f3726b;
                i13 = i25 + i33;
                i10 = i33;
            }
            i12 = 0;
            i11 = 0;
        } else if (cVar.f3730f == -1) {
            int i34 = cVar.f3726b;
            i11 = i34 - i25;
            i10 = 0;
            i12 = i34;
            i13 = 0;
        } else {
            int i35 = cVar.f3726b;
            i12 = i25 + i35;
            i11 = i35;
            i13 = 0;
            i10 = 0;
        }
        while (i32 < i22) {
            View view4 = this.L[i32];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.f3705s == 1) {
                if (o2()) {
                    int f02 = f0() + this.K[this.J - bVar3.f3703e];
                    i15 = f02 - this.f3707u.f(view4);
                    i17 = i13;
                    i16 = f02;
                } else {
                    int f03 = f0() + this.K[bVar3.f3703e];
                    i16 = this.f3707u.f(view4) + f03;
                    i17 = i13;
                    i15 = f03;
                }
                i14 = i10;
            } else {
                int h02 = h0() + this.K[bVar3.f3703e];
                i17 = this.f3707u.f(view4) + h02;
                i14 = h02;
                i16 = i12;
                i15 = i11;
            }
            A0(view4, i15, i14, i16, i17);
            if (bVar3.c() || bVar3.b()) {
                bVar.f3723c = true;
            }
            bVar.f3724d |= view4.hasFocusable();
            i32++;
            i13 = i17;
            i12 = i16;
            i11 = i15;
            i10 = i14;
        }
        Arrays.fill(this.L, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int s(RecyclerView.y yVar) {
        if (this.Q) {
            return R2(yVar);
        }
        return super.s(yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void s2(RecyclerView.u uVar, RecyclerView.y yVar, LinearLayoutManager.a aVar, int i10) {
        super.s2(uVar, yVar, aVar, i10);
        f3();
        if (yVar.b() > 0 && !yVar.e()) {
            T2(uVar, yVar, aVar, i10);
        }
        U2();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int t(RecyclerView.y yVar) {
        if (this.Q) {
            return S2(yVar);
        }
        return super.t(yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int v(RecyclerView.y yVar) {
        if (this.Q) {
            return R2(yVar);
        }
        return super.v(yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int w(RecyclerView.y yVar) {
        if (this.Q) {
            return S2(yVar);
        }
        return super.w(yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int x1(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        f3();
        U2();
        return super.x1(i10, uVar, yVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int z1(int i10, RecyclerView.u uVar, RecyclerView.y yVar) {
        f3();
        U2();
        return super.z1(i10, uVar, yVar);
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.o {

        /* renamed from: e  reason: collision with root package name */
        int f3703e = -1;

        /* renamed from: f  reason: collision with root package name */
        int f3704f = 0;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int e() {
            return this.f3703e;
        }

        public int f() {
            return this.f3704f;
        }

        public b(int i10, int i11) {
            super(i10, i11);
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(Context context, int i10) {
        super(context);
        d3(i10);
    }

    public GridLayoutManager(Context context, int i10, int i11, boolean z10) {
        super(context, i11, z10);
        d3(i10);
    }
}
