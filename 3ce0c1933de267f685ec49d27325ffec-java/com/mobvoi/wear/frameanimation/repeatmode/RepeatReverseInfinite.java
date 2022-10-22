package com.mobvoi.wear.frameanimation.repeatmode;

import com.mobvoi.wear.frameanimation.FrameAnimation;
import java.util.List;
import kotlin.collections.s;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
/* compiled from: RepeatReverseInfinite.kt */
/* loaded from: classes2.dex */
public final class RepeatReverseInfinite implements RepeatStrategy {
    private List<FrameAnimation.PathData> paths;
    private List<FrameAnimation.PathData> reversePaths;

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public void clear() {
        List<FrameAnimation.PathData> list = this.reversePaths;
        if (list != null) {
            list.clear();
            List<FrameAnimation.PathData> list2 = this.paths;
            if (list2 != null) {
                list2.clear();
            } else {
                i.u("paths");
                throw null;
            }
        } else {
            i.u("reversePaths");
            throw null;
        }
    }

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public FrameAnimation.PathData getNextFrameResource(int i10) {
        List<FrameAnimation.PathData> list = this.paths;
        if (list == null) {
            i.u("paths");
            throw null;
        } else if (!(!list.isEmpty())) {
            return null;
        } else {
            List<FrameAnimation.PathData> list2 = this.paths;
            if (list2 == null) {
                i.u("paths");
                throw null;
            } else if ((i10 / list2.size()) % 2 == 0) {
                List<FrameAnimation.PathData> list3 = this.paths;
                if (list3 == null) {
                    i.u("paths");
                    throw null;
                } else if (list3 != null) {
                    return list3.get(i10 % list3.size());
                } else {
                    i.u("paths");
                    throw null;
                }
            } else {
                List<FrameAnimation.PathData> list4 = this.reversePaths;
                if (list4 == null) {
                    i.u("reversePaths");
                    throw null;
                } else if (list4 != null) {
                    return list4.get(i10 % list4.size());
                } else {
                    i.u("reversePaths");
                    throw null;
                }
            }
        }
    }

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public int getTotalFrames() {
        return FrameAnimation.Companion.getFRAMES_INFINITE();
    }

    @Override // com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy
    public void setPaths(List<FrameAnimation.PathData> list) {
        List W;
        List<FrameAnimation.PathData> y10;
        List<FrameAnimation.PathData> W2;
        i.f(list, "list");
        W = u.W(list);
        y10 = s.y(W);
        this.reversePaths = y10;
        W2 = u.W(list);
        this.paths = W2;
        if (!list.isEmpty()) {
            List<FrameAnimation.PathData> list2 = this.reversePaths;
            if (list2 == null) {
                i.u("reversePaths");
                throw null;
            } else if (list2 != null) {
                list2.remove(list2.size() - 1);
                List<FrameAnimation.PathData> list3 = this.paths;
                if (list3 == null) {
                    i.u("paths");
                    throw null;
                } else if (list3 != null) {
                    list3.remove(list3.size() - 1);
                } else {
                    i.u("paths");
                    throw null;
                }
            } else {
                i.u("reversePaths");
                throw null;
            }
        }
    }
}
