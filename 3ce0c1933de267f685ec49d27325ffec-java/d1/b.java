package d1;

import android.graphics.drawable.Drawable;
import androidx.appcompat.app.a;
import androidx.appcompat.app.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionBarOnDestinationChangedListener.java */
/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: f  reason: collision with root package name */
    private final d f24989f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(d dVar, d dVar2) {
        super(dVar.getDrawerToggleDelegate().a(), dVar2);
        this.f24989f = dVar;
    }

    @Override // d1.a
    protected void c(Drawable drawable, int i10) {
        a supportActionBar = this.f24989f.getSupportActionBar();
        if (drawable == null) {
            supportActionBar.t(false);
            return;
        }
        supportActionBar.t(true);
        this.f24989f.getDrawerToggleDelegate().b(drawable, i10);
    }

    @Override // d1.a
    protected void d(CharSequence charSequence) {
        this.f24989f.getSupportActionBar().z(charSequence);
    }
}
