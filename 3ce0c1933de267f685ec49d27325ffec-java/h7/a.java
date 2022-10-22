package h7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import h7.d;
/* compiled from: CircularRevealCompat.java */
/* loaded from: classes.dex */
public final class a {

    /* compiled from: CircularRevealCompat.java */
    /* renamed from: h7.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0298a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f27743a;

        C0298a(d dVar) {
            this.f27743a = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f27743a.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f27743a.a();
        }
    }

    public static Animator a(d dVar, float f10, float f11, float f12) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(dVar, (Property<d, V>) d.c.f27747a, (TypeEvaluator) d.b.f27745b, (Object[]) new d.e[]{new d.e(f10, f11, f12)});
        if (Build.VERSION.SDK_INT < 21) {
            return ofObject;
        }
        d.e revealInfo = dVar.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) dVar, (int) f10, (int) f11, revealInfo.f27751c, f12);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static Animator.AnimatorListener b(d dVar) {
        return new C0298a(dVar);
    }
}
