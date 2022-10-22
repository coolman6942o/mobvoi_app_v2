package com.mobvoi.wear.common.steps;

import com.mobvoi.wear.common.steps.PageStep;
/* loaded from: classes2.dex */
public class PageStepSingle extends PageStepSequence {
    public PageStepSingle(PageStep... pageStepArr) {
        super(pageStepArr);
    }

    @Override // com.mobvoi.wear.common.steps.PageStepSequence
    boolean shouldContinue(PageStep pageStep, PageStep.PageStepResult pageStepResult) {
        return pageStepResult == null || pageStepResult == PageStep.PageStepResult.Skipped;
    }
}
