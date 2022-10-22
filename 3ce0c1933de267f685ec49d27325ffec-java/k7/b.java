package k7;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import androidx.appcompat.app.c;
import androidx.core.view.d0;
import d7.k;
import i.d;
import w7.g;
import x7.a;
/* compiled from: MaterialAlertDialogBuilder.java */
/* loaded from: classes.dex */
public class b extends c.a {

    /* renamed from: e  reason: collision with root package name */
    private static final int f29798e = d7.b.f25143a;

    /* renamed from: f  reason: collision with root package name */
    private static final int f29799f = k.f25337b;

    /* renamed from: g  reason: collision with root package name */
    private static final int f29800g = d7.b.f25169y;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f29801c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f29802d;

    public b(Context context) {
        this(context, 0);
    }

    private static Context u(Context context) {
        int v10 = v(context);
        Context c10 = a.c(context, null, f29798e, f29799f);
        return v10 == 0 ? c10 : new d(c10, v10);
    }

    private static int v(Context context) {
        TypedValue a10 = t7.b.a(context, f29800g);
        if (a10 == null) {
            return 0;
        }
        return a10.data;
    }

    private static int w(Context context, int i10) {
        return i10 == 0 ? v(context) : i10;
    }

    /* renamed from: A */
    public b f(Drawable drawable) {
        return (b) super.f(drawable);
    }

    public b B(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        return (b) super.g(charSequenceArr, onClickListener);
    }

    /* renamed from: C */
    public b h(int i10) {
        return (b) super.h(i10);
    }

    public b D(CharSequence charSequence) {
        return (b) super.i(charSequence);
    }

    /* renamed from: E */
    public b j(int i10, DialogInterface.OnClickListener onClickListener) {
        return (b) super.j(i10, onClickListener);
    }

    public b F(DialogInterface.OnCancelListener onCancelListener) {
        return (b) super.k(onCancelListener);
    }

    /* renamed from: G */
    public b l(DialogInterface.OnKeyListener onKeyListener) {
        return (b) super.l(onKeyListener);
    }

    /* renamed from: H */
    public b m(int i10, DialogInterface.OnClickListener onClickListener) {
        return (b) super.m(i10, onClickListener);
    }

    public b I(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (b) super.n(charSequence, onClickListener);
    }

    public b J(int i10, int i11, DialogInterface.OnClickListener onClickListener) {
        return (b) super.o(i10, i11, onClickListener);
    }

    /* renamed from: K */
    public b p(ListAdapter listAdapter, int i10, DialogInterface.OnClickListener onClickListener) {
        return (b) super.p(listAdapter, i10, onClickListener);
    }

    /* renamed from: L */
    public b q(int i10) {
        return (b) super.q(i10);
    }

    /* renamed from: M */
    public b r(CharSequence charSequence) {
        return (b) super.r(charSequence);
    }

    /* renamed from: N */
    public b s(View view) {
        return (b) super.s(view);
    }

    @Override // androidx.appcompat.app.c.a
    public c a() {
        c a10 = super.a();
        Window window = a10.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.f29801c;
        if (drawable instanceof g) {
            ((g) drawable).Y(d0.y(decorView));
        }
        window.setBackgroundDrawable(c.b(this.f29801c, this.f29802d));
        decorView.setOnTouchListener(new a(a10, this.f29802d));
        return a10;
    }

    /* renamed from: x */
    public b c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (b) super.c(listAdapter, onClickListener);
    }

    /* renamed from: y */
    public b d(boolean z10) {
        return (b) super.d(z10);
    }

    /* renamed from: z */
    public b e(View view) {
        return (b) super.e(view);
    }

    public b(Context context, int i10) {
        super(u(context), w(context, i10));
        Context b10 = b();
        Resources.Theme theme = b10.getTheme();
        int i11 = f29798e;
        int i12 = f29799f;
        this.f29802d = c.a(b10, i11, i12);
        int c10 = j7.a.c(b10, d7.b.f25161q, b.class.getCanonicalName());
        g gVar = new g(b10, null, i11, i12);
        gVar.O(b10);
        gVar.Z(ColorStateList.valueOf(c10));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(b().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                gVar.W(dimension);
            }
        }
        this.f29801c = gVar;
    }
}
