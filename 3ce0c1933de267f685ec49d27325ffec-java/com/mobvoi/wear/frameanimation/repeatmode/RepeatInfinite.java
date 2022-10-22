package com.mobvoi.wear.frameanimation.repeatmode;

import com.mobvoi.wear.frameanimation.FrameAnimation;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
/* compiled from: RepeatInfinite.kt */
/* loaded from: classes2.dex */
public final class RepeatInfinite implements RepeatStrategy {
    private List<FrameAnimation.PathData> paths;

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public void clear() {
        List<FrameAnimation.PathData> list = this.paths;
        if (list != null) {
            list.clear();
        } else {
            i.u("paths");
            throw null;
        }
    }

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public FrameAnimation.PathData getNextFrameResource(int i10) {
        List<FrameAnimation.PathData> list = this.paths;
        if (list == null) {
            i.u("paths");
            throw null;
        } else if (list.isEmpty()) {
            return null;
        } else {
            List<FrameAnimation.PathData> list2 = this.paths;
            if (list2 == null) {
                i.u("paths");
                throw null;
            } else if (list2 != null) {
                return list2.get(i10 % list2.size());
            } else {
                i.u("paths");
                throw null;
            }
        }
    }

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public int getTotalFrames() {
        return FrameAnimation.Companion.getFRAMES_INFINITE();
    }

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public void setPaths(List<FrameAnimation.PathData> list) {
        List<FrameAnimation.PathData> W;
        i.f(list, "list");
        W = u.W(list);
        this.paths = W;
    }
}
