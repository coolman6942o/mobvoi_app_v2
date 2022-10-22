package com.mobvoi.wear.helper;

import com.mobvoi.wear.common.steps.PageStep;
/* loaded from: classes2.dex */
public class EmptyPageStep extends PageStep {
    @Override // com.mobvoi.wear.common.steps.PageStep
    protected void execute() {
        complete(PageStep.PageStepResult.Skipped);
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    public String getName() {
        return "Empty";
    }
}
