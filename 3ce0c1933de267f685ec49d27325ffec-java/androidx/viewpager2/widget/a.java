package androidx.viewpager2.widget;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AnimateLayoutChangeDetector.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private static final ViewGroup.MarginLayoutParams f4645b;

    /* renamed from: a  reason: collision with root package name */
    private LinearLayoutManager f4646a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimateLayoutChangeDetector.java */
    /* renamed from: androidx.viewpager2.widget.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0052a implements Comparator<int[]> {
        C0052a(a aVar) {
        }

        /* renamed from: a */
        public int compare(int[] iArr, int[] iArr2) {
            return iArr[0] - iArr2[0];
        }
    }

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f4645b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LinearLayoutManager linearLayoutManager) {
        this.f4646a = linearLayoutManager;
    }

    private boolean a() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i10;
        int i11;
        int i12;
        int i13;
        int K = this.f4646a.K();
        if (K == 0) {
            return true;
        }
        boolean z10 = this.f4646a.n2() == 0;
        int[][] iArr = (int[][]) Array.newInstance(int.class, K, 2);
        for (int i14 = 0; i14 < K; i14++) {
            View J = this.f4646a.J(i14);
            if (J != null) {
                ViewGroup.LayoutParams layoutParams = J.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                } else {
                    marginLayoutParams = f4645b;
                }
                int[] iArr2 = iArr[i14];
                if (z10) {
                    i11 = J.getLeft();
                    i10 = marginLayoutParams.leftMargin;
                } else {
                    i11 = J.getTop();
                    i10 = marginLayoutParams.topMargin;
                }
                iArr2[0] = i11 - i10;
                int[] iArr3 = iArr[i14];
                if (z10) {
                    i13 = J.getRight();
                    i12 = marginLayoutParams.rightMargin;
                } else {
                    i13 = J.getBottom();
                    i12 = marginLayoutParams.bottomMargin;
                }
                iArr3[1] = i13 + i12;
            } else {
                throw new IllegalStateException("null view contained in the view hierarchy");
            }
        }
        Arrays.sort(iArr, new C0052a(this));
        for (int i15 = 1; i15 < K; i15++) {
            if (iArr[i15 - 1][1] != iArr[i15][0]) {
                return false;
            }
        }
        return iArr[0][0] <= 0 && iArr[K - 1][1] >= iArr[0][1] - iArr[0][0];
    }

    private boolean b() {
        int K = this.f4646a.K();
        for (int i10 = 0; i10 < K; i10++) {
            if (c(this.f4646a.J(i10))) {
                return true;
            }
        }
        return false;
    }

    private static boolean c(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (c(viewGroup.getChildAt(i10))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return (!a() || this.f4646a.K() <= 1) && b();
    }
}
