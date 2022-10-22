package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import d.a;
/* compiled from: AppCompatRatingBar.java */
/* loaded from: classes.dex */
public class v extends RatingBar {

    /* renamed from: a  reason: collision with root package name */
    private final t f1354a;

    public v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.J);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        Bitmap b10 = this.f1354a.b();
        if (b10 != null) {
            setMeasuredDimension(View.resolveSizeAndState(b10.getWidth() * getNumStars(), i10, 0), getMeasuredHeight());
        }
    }

    public v(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s0.a(this, getContext());
        t tVar = new t(this);
        this.f1354a = tVar;
        tVar.c(attributeSet, i10);
    }
}
