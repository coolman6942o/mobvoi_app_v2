package com.mobvoi.wear.common.steps;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public abstract class PageStep {
    protected static final String TAG = "PageStep";
    private StepResultCallback mResultCallback;
    private List<StepResultCallback> mResultListeners = new ArrayList();

    /* loaded from: classes2.dex */
    public enum PageStepResult {
        Skipped,
        Success,
        Failed
    }

    /* loaded from: classes2.dex */
    public interface StepResultCallback {
        void onStepResult(PageStep pageStep, PageStepResult pageStepResult);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void complete(PageStepResult pageStepResult) {
        if (!this.mResultListeners.isEmpty()) {
            for (StepResultCallback stepResultCallback : this.mResultListeners) {
                stepResultCallback.onStepResult(this, pageStepResult);
            }
        }
        StepResultCallback stepResultCallback2 = this.mResultCallback;
        if (stepResultCallback2 != null) {
            stepResultCallback2.onStepResult(this, pageStepResult);
        }
    }

    protected abstract void execute();

    public final void execute(StepResultCallback stepResultCallback) {
        this.mResultCallback = stepResultCallback;
        execute();
    }

    public String getName() {
        return getClass().getName();
    }

    public final PageStep onComplete(StepResultCallback stepResultCallback) {
        this.mResultListeners.add(stepResultCallback);
        return this;
    }
}
