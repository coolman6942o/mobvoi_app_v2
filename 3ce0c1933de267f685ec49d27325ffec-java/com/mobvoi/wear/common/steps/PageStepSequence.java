package com.mobvoi.wear.common.steps;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.steps.PageStep;
/* loaded from: classes2.dex */
public abstract class PageStepSequence extends PageStep implements PageStep.StepResultCallback {
    private int mCurrentStep = -1;
    private final PageStep[] steps;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PageStepSequence(PageStep... pageStepArr) {
        if (pageStepArr == null || pageStepArr.length == 0) {
            throw new IllegalArgumentException("Steps cannot be null!");
        }
        this.steps = pageStepArr;
    }

    private void executeNext() {
        this.steps[this.mCurrentStep].execute(this);
    }

    private boolean isExecuting() {
        return this.mCurrentStep >= 0;
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    protected void execute() {
        if (isExecuting()) {
            k.q("PageStep", "Sequence already executing");
            return;
        }
        this.mCurrentStep = 0;
        executeNext();
    }

    @Override // com.mobvoi.wear.common.steps.PageStep.StepResultCallback
    public void onStepResult(PageStep pageStep, PageStep.PageStepResult pageStepResult) {
        k.p("PageStep", "Sequence completed step %s, result %s", pageStep.getName(), pageStepResult);
        int i10 = this.mCurrentStep + 1;
        this.mCurrentStep = i10;
        if (i10 >= this.steps.length || !shouldContinue(pageStep, pageStepResult)) {
            this.mCurrentStep = -1;
            complete(PageStep.PageStepResult.Success);
            return;
        }
        executeNext();
    }

    abstract boolean shouldContinue(PageStep pageStep, PageStep.PageStepResult pageStepResult);
}
