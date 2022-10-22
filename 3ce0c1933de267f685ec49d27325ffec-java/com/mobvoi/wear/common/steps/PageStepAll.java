package com.mobvoi.wear.common.steps;

import com.mobvoi.wear.common.steps.PageStep;
/* loaded from: classes2.dex */
public class PageStepAll extends PageStepSequence {
    public PageStepAll(PageStep... pageStepArr) {
        super(pageStepArr);
    }

    @Override // com.mobvoi.wear.common.steps.PageStepSequence
    boolean shouldContinue(PageStep pageStep, PageStep.PageStepResult pageStepResult) {
        return true;
    }
}
