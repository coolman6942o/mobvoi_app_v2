package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.i0;
/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements i0 {

    /* renamed from: a  reason: collision with root package name */
    private i0.a f924a;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        i0.a aVar = this.f924a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.i0
    public void setOnFitSystemWindowsListener(i0.a aVar) {
        this.f924a = aVar;
    }
}
