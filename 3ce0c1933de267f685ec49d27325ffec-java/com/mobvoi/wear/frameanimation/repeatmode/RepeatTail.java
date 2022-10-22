package com.mobvoi.wear.frameanimation.repeatmode;

import com.mobvoi.wear.frameanimation.FrameAnimation;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.i;
/* compiled from: RepeatTail.kt */
/* loaded from: classes2.dex */
public final class RepeatTail implements RepeatStrategy {
    private List<FrameAnimation.PathData> paths;
    private final int repeatStartPosition;

    public RepeatTail(int i10) {
        this.repeatStartPosition = i10;
    }

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
        int i11 = this.repeatStartPosition;
        List<FrameAnimation.PathData> list = this.paths;
        if (list == null) {
            i.u("paths");
            throw null;
        } else if (i11 < list.size()) {
            int i12 = this.repeatStartPosition;
            if (i10 < i12) {
                List<FrameAnimation.PathData> list2 = this.paths;
                if (list2 != null) {
                    return list2.get(i10);
                }
                i.u("paths");
                throw null;
            }
            int i13 = i10 - i12;
            List<FrameAnimation.PathData> list3 = this.paths;
            if (list3 != null) {
                int size = list3.size();
                int i14 = this.repeatStartPosition;
                int i15 = size - i14;
                List<FrameAnimation.PathData> list4 = this.paths;
                if (list4 != null) {
                    return list4.get(i14 + (i13 % i15));
                }
                i.u("paths");
                throw null;
            }
            i.u("paths");
            throw null;
        } else {
            throw new IllegalArgumentException("illegal start position");
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
