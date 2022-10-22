package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import e7.h;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MotionStrategy.java */
/* loaded from: classes.dex */
public interface d {
    void a();

    void b();

    h c();

    boolean d();

    void e(h hVar);

    AnimatorSet f();

    List<Animator.AnimatorListener> g();

    void h(ExtendedFloatingActionButton.f fVar);

    void onAnimationEnd();

    void onAnimationStart(Animator animator);
}
