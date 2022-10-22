package e7;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import java.util.List;
/* compiled from: AnimatorSetCompat.java */
/* loaded from: classes.dex */
public class b {
    public static void a(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            Animator animator = list.get(i10);
            j10 = Math.max(j10, animator.getStartDelay() + animator.getDuration());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j10);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }
}
