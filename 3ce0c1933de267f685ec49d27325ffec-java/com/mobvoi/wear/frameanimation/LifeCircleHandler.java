package com.mobvoi.wear.frameanimation;

import com.mobvoi.wear.frameanimation.FrameAnimation;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
/* compiled from: LifeCircleHandler.kt */
/* loaded from: classes2.dex */
public final class LifeCircleHandler {
    private final FrameAnimation animation;
    private int lastStopIndex;
    private List<FrameAnimation.PathData> lastStopPaths;
    private boolean restoreEnable = true;

    public LifeCircleHandler(FrameAnimation animation) {
        i.f(animation, "animation");
        this.animation = animation;
    }

    public final boolean getRestoreEnable() {
        return this.restoreEnable;
    }

    public final void pause() {
        if (this.animation.isPlaying()) {
            this.animation.setTemporaryStop(this.restoreEnable);
            List<FrameAnimation.PathData> mPaths = this.animation.getMPaths();
            this.lastStopPaths = mPaths == null ? null : u.W(mPaths);
            this.lastStopIndex = this.animation.stopAnimationSafely();
        }
    }

    public final void release() {
        this.animation.release();
    }

    public final void resume() {
        List<FrameAnimation.PathData> list = this.lastStopPaths;
        if (list != null && this.restoreEnable) {
            this.animation.playAnimation(list, this.lastStopIndex);
        }
        this.lastStopPaths = null;
    }

    public final void setRestoreEnable(boolean z10) {
        this.restoreEnable = z10;
    }
}
