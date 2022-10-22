package e7;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
/* compiled from: MotionTiming.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private long f25848a;

    /* renamed from: b  reason: collision with root package name */
    private long f25849b;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f25850c;

    /* renamed from: d  reason: collision with root package name */
    private int f25851d;

    /* renamed from: e  reason: collision with root package name */
    private int f25852e;

    public i(long j10, long j11) {
        this.f25848a = 0L;
        this.f25849b = 300L;
        this.f25850c = null;
        this.f25851d = 0;
        this.f25852e = 1;
        this.f25848a = j10;
        this.f25849b = j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f25851d = valueAnimator.getRepeatCount();
        iVar.f25852e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f25834b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f25835c;
        }
        return interpolator instanceof DecelerateInterpolator ? a.f25836d : interpolator;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.f25848a;
    }

    public long d() {
        return this.f25849b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f25850c;
        return timeInterpolator != null ? timeInterpolator : a.f25834b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
            return e().getClass().equals(iVar.e().getClass());
        }
        return false;
    }

    public int g() {
        return this.f25851d;
    }

    public int h() {
        return this.f25852e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    public String toString() {
        return '\n' + i.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j10, long j11, TimeInterpolator timeInterpolator) {
        this.f25848a = 0L;
        this.f25849b = 300L;
        this.f25850c = null;
        this.f25851d = 0;
        this.f25852e = 1;
        this.f25848a = j10;
        this.f25849b = j11;
        this.f25850c = timeInterpolator;
    }
}
