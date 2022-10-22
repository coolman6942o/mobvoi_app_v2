package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import d.d;
import d.f;
import d.g;
import d.i;
/* compiled from: TooltipPopup.java */
/* loaded from: classes.dex */
class c1 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1129a;

    /* renamed from: b  reason: collision with root package name */
    private final View f1130b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f1131c;

    /* renamed from: d  reason: collision with root package name */
    private final WindowManager.LayoutParams f1132d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f1133e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final int[] f1134f = new int[2];

    /* renamed from: g  reason: collision with root package name */
    private final int[] f1135g = new int[2];

    /* JADX INFO: Access modifiers changed from: package-private */
    public c1(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f1132d = layoutParams;
        this.f1129a = context;
        View inflate = LayoutInflater.from(context).inflate(g.f24833s, (ViewGroup) null);
        this.f1130b = inflate;
        this.f1131c = (TextView) inflate.findViewById(f.f24807s);
        layoutParams.setTitle(c1.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.f24849a;
        layoutParams.flags = 24;
    }

    private void a(View view, int i10, int i11, boolean z10, WindowManager.LayoutParams layoutParams) {
        int i12;
        int i13;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1129a.getResources().getDimensionPixelOffset(d.f24760m);
        if (view.getWidth() < dimensionPixelOffset) {
            i10 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1129a.getResources().getDimensionPixelOffset(d.f24759l);
            i13 = i11 + dimensionPixelOffset2;
            i12 = i11 - dimensionPixelOffset2;
        } else {
            i13 = view.getHeight();
            i12 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1129a.getResources().getDimensionPixelOffset(z10 ? d.f24762o : d.f24761n);
        View b10 = b(view);
        if (b10 == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        b10.getWindowVisibleDisplayFrame(this.f1133e);
        Rect rect = this.f1133e;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources = this.f1129a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1133e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        b10.getLocationOnScreen(this.f1135g);
        view.getLocationOnScreen(this.f1134f);
        int[] iArr = this.f1134f;
        int i14 = iArr[0];
        int[] iArr2 = this.f1135g;
        iArr[0] = i14 - iArr2[0];
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (iArr[0] + i10) - (b10.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1130b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.f1130b.getMeasuredHeight();
        int[] iArr3 = this.f1134f;
        int i15 = ((iArr3[1] + i12) - dimensionPixelOffset3) - measuredHeight;
        int i16 = iArr3[1] + i13 + dimensionPixelOffset3;
        if (z10) {
            if (i15 >= 0) {
                layoutParams.y = i15;
            } else {
                layoutParams.y = i16;
            }
        } else if (measuredHeight + i16 <= this.f1133e.height()) {
            layoutParams.y = i16;
        } else {
            layoutParams.y = i15;
        }
    }

    private static View b(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        if (d()) {
            ((WindowManager) this.f1129a.getSystemService("window")).removeView(this.f1130b);
        }
    }

    boolean d() {
        return this.f1130b.getParent() != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view, int i10, int i11, boolean z10, CharSequence charSequence) {
        if (d()) {
            c();
        }
        this.f1131c.setText(charSequence);
        a(view, i10, i11, z10, this.f1132d);
        ((WindowManager) this.f1129a.getSystemService("window")).addView(this.f1130b, this.f1132d);
    }
}
