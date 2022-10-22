package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import d.a;
/* compiled from: AppCompatSeekBar.java */
/* loaded from: classes.dex */
public class x extends SeekBar {

    /* renamed from: a  reason: collision with root package name */
    private final y f1360a;

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.L);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1360a.h();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1360a.i();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1360a.g(canvas);
    }

    public x(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s0.a(this, getContext());
        y yVar = new y(this);
        this.f1360a = yVar;
        yVar.c(attributeSet, i10);
    }
}
