package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.d0;
import d.f;
/* loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void A(View view, int i10, int i11, int i12, int i13) {
        view.layout(i10, i11, i12 + i10, i13 + i11);
    }

    private static int B(View view) {
        int F = d0.F(view);
        if (F > 0) {
            return F;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return B(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private boolean C(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                int id2 = childAt.getId();
                if (id2 == f.P) {
                    view = childAt;
                } else if (id2 == f.f24799k) {
                    view2 = childAt;
                } else if ((id2 != f.f24801m && id2 != f.f24803o) || view3 != null) {
                    return false;
                } else {
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i10);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i10, 0);
            paddingTop += view.getMeasuredHeight();
            i12 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i12 = 0;
        }
        if (view2 != null) {
            view2.measure(i10, 0);
            i14 = B(view2);
            i13 = view2.getMeasuredHeight() - i14;
            paddingTop += i14;
            i12 = View.combineMeasuredStates(i12, view2.getMeasuredState());
        } else {
            i14 = 0;
            i13 = 0;
        }
        if (view3 != null) {
            view3.measure(i10, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            i15 = view3.getMeasuredHeight();
            paddingTop += i15;
            i12 = View.combineMeasuredStates(i12, view3.getMeasuredState());
        } else {
            i15 = 0;
        }
        int i17 = size - paddingTop;
        if (view2 != null) {
            int i18 = paddingTop - i14;
            int min = Math.min(i17, i13);
            if (min > 0) {
                i17 -= min;
                i14 += min;
            }
            view2.measure(i10, View.MeasureSpec.makeMeasureSpec(i14, 1073741824));
            paddingTop = i18 + view2.getMeasuredHeight();
            i12 = View.combineMeasuredStates(i12, view2.getMeasuredState());
        }
        if (view3 != null && i17 > 0) {
            view3.measure(i10, View.MeasureSpec.makeMeasureSpec(i15 + i17, mode));
            paddingTop = (paddingTop - i15) + view3.getMeasuredHeight();
            i12 = View.combineMeasuredStates(i12, view3.getMeasuredState());
        }
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8) {
                i19 = Math.max(i19, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i19 + getPaddingLeft() + getPaddingRight(), i10, i12), View.resolveSizeAndState(paddingTop, i11, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        l(childCount, i11);
        return true;
    }

    private void l(int i10, int i11) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i12 = 0; i12 < i10; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) childAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) aVar).width == -1) {
                    int i13 = ((LinearLayout.LayoutParams) aVar).height;
                    ((LinearLayout.LayoutParams) aVar).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i11, 0);
                    ((LinearLayout.LayoutParams) aVar).height = i13;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int paddingLeft = getPaddingLeft();
        int i18 = i12 - i10;
        int paddingRight = i18 - getPaddingRight();
        int paddingRight2 = (i18 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i19 = gravity & 112;
        int i20 = gravity & 8388615;
        if (i19 == 16) {
            i14 = getPaddingTop() + (((i13 - i11) - measuredHeight) / 2);
        } else if (i19 != 80) {
            i14 = getPaddingTop();
        } else {
            i14 = ((getPaddingTop() + i13) - i11) - measuredHeight;
        }
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) childAt.getLayoutParams();
                i20 = ((LinearLayout.LayoutParams) aVar).gravity;
                if (i20 < 0) {
                }
                int b10 = androidx.core.view.f.b(i20, d0.E(this)) & 7;
                if (b10 == 1) {
                    i17 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) aVar).leftMargin;
                    i16 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                } else if (b10 != 5) {
                    i15 = ((LinearLayout.LayoutParams) aVar).leftMargin + paddingLeft;
                    if (t(i21)) {
                        i14 += intrinsicHeight;
                    }
                    int i22 = i14 + ((LinearLayout.LayoutParams) aVar).topMargin;
                    A(childAt, i15, i22, measuredWidth, measuredHeight2);
                    i14 = i22 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin;
                } else {
                    i17 = paddingRight - measuredWidth;
                    i16 = ((LinearLayout.LayoutParams) aVar).rightMargin;
                }
                i15 = i17 - i16;
                if (t(i21)) {
                }
                int i222 = i14 + ((LinearLayout.LayoutParams) aVar).topMargin;
                A(childAt, i15, i222, measuredWidth, measuredHeight2);
                i14 = i222 + measuredHeight2 + ((LinearLayout.LayoutParams) aVar).bottomMargin;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!C(i10, i11)) {
            super.onMeasure(i10, i11);
        }
    }
}
