package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.y;
/* compiled from: FragmentAnim.java */
/* loaded from: classes.dex */
class g {
    private static int a(Fragment fragment, boolean z10, boolean z11) {
        if (z11) {
            if (z10) {
                return fragment.getPopEnterAnim();
            }
            return fragment.getPopExitAnim();
        } else if (z10) {
            return fragment.getEnterAnim();
        } else {
            return fragment.getExitAnim();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a b(Context context, Fragment fragment, boolean z10, boolean z11) {
        int nextTransition = fragment.getNextTransition();
        int a10 = a(fragment, z10, z11);
        boolean z12 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i10 = v0.b.f35562c;
            if (viewGroup.getTag(i10) != null) {
                fragment.mContainer.setTag(i10, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z10, a10);
        if (onCreateAnimation != null) {
            return new a(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z10, a10);
        if (onCreateAnimator != null) {
            return new a(onCreateAnimator);
        }
        if (a10 == 0 && nextTransition != 0) {
            a10 = d(context, nextTransition, z10);
        }
        if (a10 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(a10));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, a10);
                    if (loadAnimation != null) {
                        return new a(loadAnimation);
                    }
                    z12 = true;
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            }
            if (!z12) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, a10);
                    if (loadAnimator != null) {
                        return new a(loadAnimator);
                    }
                } catch (RuntimeException e11) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, a10);
                        if (loadAnimation2 != null) {
                            return new a(loadAnimation2);
                        }
                    } else {
                        throw e11;
                    }
                }
            }
        }
        return null;
    }

    private static int c(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(16973825, new int[]{i10});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int d(Context context, int i10, boolean z10) {
        if (i10 == 4097) {
            return z10 ? v0.a.f35558e : v0.a.f35559f;
        }
        if (i10 == 8194) {
            return z10 ? v0.a.f35554a : v0.a.f35555b;
        }
        if (i10 != 8197) {
            if (i10 == 4099) {
                return z10 ? v0.a.f35556c : v0.a.f35557d;
            }
            if (i10 != 4100) {
                return -1;
            }
            if (z10) {
                return c(context, 16842936);
            }
            return c(context, 16842937);
        } else if (z10) {
            return c(context, 16842938);
        } else {
            return c(context, 16842939);
        }
    }

    /* compiled from: FragmentAnim.java */
    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Animation f3135a;

        /* renamed from: b  reason: collision with root package name */
        public final Animator f3136b;

        a(Animation animation) {
            this.f3135a = animation;
            this.f3136b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        a(Animator animator) {
            this.f3135a = null;
            this.f3136b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* compiled from: FragmentAnim.java */
    /* loaded from: classes.dex */
    static class b extends AnimationSet implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final ViewGroup f3137a;

        /* renamed from: b  reason: collision with root package name */
        private final View f3138b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3139c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3140d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3141e = true;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f3137a = viewGroup;
            this.f3138b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation) {
            this.f3141e = true;
            if (this.f3139c) {
                return !this.f3140d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f3139c = true;
                y.a(this.f3137a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3139c || !this.f3141e) {
                this.f3137a.endViewTransition(this.f3138b);
                this.f3140d = true;
                return;
            }
            this.f3141e = false;
            this.f3137a.post(this);
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f3141e = true;
            if (this.f3139c) {
                return !this.f3140d;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f3139c = true;
                y.a(this.f3137a, this);
            }
            return true;
        }
    }
}
