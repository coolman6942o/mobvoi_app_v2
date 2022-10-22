package com.mobvoi.wear.frameanimation.repeatmode;

import com.mobvoi.wear.frameanimation.FrameAnimation;
import java.util.List;
/* compiled from: RepeatStrategy.kt */
/* loaded from: classes2.dex */
public interface RepeatStrategy {
    void clear();

    FrameAnimation.PathData getNextFrameResource(int i10);

    int getTotalFrames();

    void setPaths(List<FrameAnimation.PathData> list);
}
