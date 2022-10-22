package wm;

import android.graphics.PointF;
import android.view.View;
import vm.i;
import xm.b;
/* compiled from: SimpleBoundaryDecider.java */
/* loaded from: classes2.dex */
public class a implements i {

    /* renamed from: a  reason: collision with root package name */
    public PointF f36327a;

    /* renamed from: b  reason: collision with root package name */
    public i f36328b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36329c = true;

    @Override // vm.i
    public boolean a(View view) {
        i iVar = this.f36328b;
        if (iVar != null) {
            return iVar.a(view);
        }
        return b.b(view, this.f36327a);
    }

    @Override // vm.i
    public boolean b(View view) {
        i iVar = this.f36328b;
        if (iVar != null) {
            return iVar.b(view);
        }
        return b.a(view, this.f36327a, this.f36329c);
    }
}
