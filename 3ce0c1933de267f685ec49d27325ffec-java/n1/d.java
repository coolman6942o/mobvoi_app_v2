package n1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.d0;
/* compiled from: Fade.java */
/* loaded from: classes.dex */
public class d extends j0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Fade.java */
    /* loaded from: classes.dex */
    public class a extends n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f30886a;

        a(d dVar, View view) {
            this.f30886a = view;
        }

        @Override // n1.m.f
        public void b(m mVar) {
            c0.g(this.f30886a, 1.0f);
            c0.a(this.f30886a);
            mVar.P(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Fade.java */
    /* loaded from: classes.dex */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f30887a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f30888b = false;

        b(View view) {
            this.f30887a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.g(this.f30887a, 1.0f);
            if (this.f30888b) {
                this.f30887a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (d0.T(this.f30887a) && this.f30887a.getLayerType() == 0) {
                this.f30888b = true;
                this.f30887a.setLayerType(2, null);
            }
        }
    }

    public d(int i10) {
        i0(i10);
    }

    private Animator j0(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        c0.g(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, c0.f30885b, f11);
        ofFloat.addListener(new b(view));
        a(new a(this, view));
        return ofFloat;
    }

    private static float k0(s sVar, float f10) {
        Float f11;
        return (sVar == null || (f11 = (Float) sVar.f30986a.get("android:fade:transitionAlpha")) == null) ? f10 : f11.floatValue();
    }

    @Override // n1.j0
    public Animator e0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        float f10 = 0.0f;
        float k02 = k0(sVar, 0.0f);
        if (k02 != 1.0f) {
            f10 = k02;
        }
        return j0(view, f10, 1.0f);
    }

    @Override // n1.j0
    public Animator g0(ViewGroup viewGroup, View view, s sVar, s sVar2) {
        c0.e(view);
        return j0(view, k0(sVar, 1.0f), 0.0f);
    }

    @Override // n1.j0, n1.m
    public void j(s sVar) {
        super.j(sVar);
        sVar.f30986a.put("android:fade:transitionAlpha", Float.valueOf(c0.c(sVar.f30987b)));
    }

    public d() {
    }
}
