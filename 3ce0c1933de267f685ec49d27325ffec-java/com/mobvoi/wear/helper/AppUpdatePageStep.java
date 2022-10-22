package com.mobvoi.wear.helper;

import android.app.Activity;
import com.mobvoi.wear.common.StartForResult;
import com.mobvoi.wear.common.steps.PageStep;
import com.mobvoi.wear.info.AppInfo;
import com.mobvoi.wear.util.AppUpdateUtil;
/* loaded from: classes2.dex */
public class AppUpdatePageStep extends PageStep {
    protected Activity mActivity;
    private StartForResult mStartForResult;

    public AppUpdatePageStep(Activity activity) {
        this.mActivity = activity;
        this.mStartForResult = StartForResult.newInstance(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0(StartForResult.ActivityResult activityResult) {
        complete(PageStep.PageStepResult.Success);
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    protected void execute() {
        try {
            Activity activity = this.mActivity;
            AppInfo checkUpdate = AppUpdateUtil.checkUpdate(activity, activity.getPackageName());
            if (!AppUpdateUtil.needUpdate(this.mActivity, checkUpdate) || !AppUpdateUtil.isRemindEnable(checkUpdate)) {
                complete(PageStep.PageStepResult.Skipped);
            } else {
                this.mStartForResult.startActivityForResult(AppUpdateUtil.getAppUpdateIntent(checkUpdate), new StartForResult.OnActivityResultCallback() { // from class: com.mobvoi.wear.helper.b
                    @Override // com.mobvoi.wear.common.StartForResult.OnActivityResultCallback
                    public final void onCallback(StartForResult.ActivityResult activityResult) {
                        AppUpdatePageStep.this.lambda$execute$0(activityResult);
                    }
                });
            }
        } catch (Exception unused) {
            complete(PageStep.PageStepResult.Skipped);
        }
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    public String getName() {
        return "AppUpdate";
    }
}
