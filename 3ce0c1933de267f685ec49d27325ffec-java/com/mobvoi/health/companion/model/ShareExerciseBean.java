package com.mobvoi.health.companion.model;

import com.mobvoi.health.companion.provider.Recorder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class ShareExerciseBean implements Serializable {
    public int calorie;
    public int dateType;
    public float distance;
    public long endMills;
    public long startMills;
    public int step;
    public int stepGoal;
    public int stepMax = 0;
    public List<Recorder.Item> stepList = new ArrayList();
}
