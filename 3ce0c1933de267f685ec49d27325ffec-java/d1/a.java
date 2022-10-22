package d1;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.k;
import f.d;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import o0.c;
/* compiled from: AbstractAppBarOnDestinationChangedListener.java */
/* loaded from: classes.dex */
abstract class a implements NavController.b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f24984a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Integer> f24985b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<c> f24986c;

    /* renamed from: d  reason: collision with root package name */
    private d f24987d;

    /* renamed from: e  reason: collision with root package name */
    private ValueAnimator f24988e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, d dVar) {
        this.f24984a = context;
        this.f24985b = dVar.c();
        c b10 = dVar.b();
        if (b10 != null) {
            this.f24986c = new WeakReference<>(b10);
        } else {
            this.f24986c = null;
        }
    }

    private void b(boolean z10) {
        boolean z11;
        int i10;
        if (this.f24987d == null) {
            this.f24987d = new d(this.f24984a);
            z11 = false;
        } else {
            z11 = true;
        }
        d dVar = this.f24987d;
        if (z10) {
            i10 = g.f24997b;
        } else {
            i10 = g.f24996a;
        }
        c(dVar, i10);
        float f10 = z10 ? 0.0f : 1.0f;
        if (z11) {
            float a10 = this.f24987d.a();
            ValueAnimator valueAnimator = this.f24988e;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f24987d, "progress", a10, f10);
            this.f24988e = ofFloat;
            ofFloat.start();
            return;
        }
        this.f24987d.setProgress(f10);
    }

    @Override // androidx.navigation.NavController.b
    public void a(NavController navController, k kVar, Bundle bundle) {
        if (!(kVar instanceof androidx.navigation.c)) {
            WeakReference<c> weakReference = this.f24986c;
            c cVar = weakReference != null ? weakReference.get() : null;
            if (this.f24986c == null || cVar != null) {
                CharSequence j10 = kVar.j();
                boolean z10 = true;
                if (j10 != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(j10);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle == null || !bundle.containsKey(group)) {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill label " + ((Object) j10));
                        }
                        matcher.appendReplacement(stringBuffer, "");
                        stringBuffer.append(bundle.get(group).toString());
                    }
                    matcher.appendTail(stringBuffer);
                    d(stringBuffer);
                }
                boolean a10 = f.a(kVar, this.f24985b);
                if (cVar != null || !a10) {
                    if (cVar == null || !a10) {
                        z10 = false;
                    }
                    b(z10);
                    return;
                }
                c(null, 0);
                return;
            }
            navController.z(this);
        }
    }

    protected abstract void c(Drawable drawable, int i10);

    protected abstract void d(CharSequence charSequence);
}
