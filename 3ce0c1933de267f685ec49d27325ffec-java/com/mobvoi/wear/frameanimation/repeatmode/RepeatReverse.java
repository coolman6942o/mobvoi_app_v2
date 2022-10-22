package com.mobvoi.wear.frameanimation.repeatmode;

import com.mobvoi.wear.frameanimation.FrameAnimation;
import java.util.List;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
/* compiled from: RepeatReverse.kt */
/* loaded from: classes2.dex */
public final class RepeatReverse implements RepeatStrategy {
    private List<FrameAnimation.PathData> reversePaths;

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public void clear() {
        List<FrameAnimation.PathData> list = this.reversePaths;
        if (list != null) {
            list.clear();
        } else {
            i.u("reversePaths");
            throw null;
        }
    }

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public FrameAnimation.PathData getNextFrameResource(int i10) {
        List<FrameAnimation.PathData> list = this.reversePaths;
        if (list == null) {
            i.u("reversePaths");
            throw null;
        } else if (i10 >= list.size()) {
            return null;
        } else {
            List<FrameAnimation.PathData> list2 = this.reversePaths;
            if (list2 != null) {
                return list2.get(i10);
            }
            i.u("reversePaths");
            throw null;
        }
    }

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public int getTotalFrames() {
        List<FrameAnimation.PathData> list = this.reversePaths;
        if (list != null) {
            return list.size();
        }
        i.u("reversePaths");
        throw null;
    }

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public void setPaths(List<FrameAnimation.PathData> list) {
        List W;
        List<FrameAnimation.PathData> y10;
        i.f(list, "list");
        W = u.W(list);
        y10 = s.y(W);
        this.reversePaths = y10;
    }
}
