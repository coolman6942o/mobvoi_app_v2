package com.mobvoi.wear.helper;

import android.app.Activity;
import android.content.Intent;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.StartForResult;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.common.steps.PageStep;
/* loaded from: classes2.dex */
public class CompanionCheckPageStep extends PageStep {
    private Activity mActivity;
    private boolean mCanSkip;
    private boolean mCanStandalone;
    private String mInstallExplainAndroid;
    private String mInstallExplainIos;
    private String mLoginExplainAndroid;
    private String mLoginExplainIos;
    private StartForResult mStartForResult;

    public CompanionCheckPageStep(Activity activity) {
        this.mActivity = activity;
        this.mStartForResult = StartForResult.newInstance(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0(StartForResult.ActivityResult activityResult) {
        complete(activityResult.resultCode == -1 ? PageStep.PageStepResult.Success : PageStep.PageStepResult.Failed);
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    protected void execute() {
        if (CompanionHelper.setupCompleted(this.mActivity, this.mCanStandalone)) {
            complete(PageStep.PageStepResult.Skipped);
            return;
        }
        Intent intent = new Intent(Constants.Companion.CHECK_ACTION);
        intent.putExtra(Constants.Companion.INSTALL_EXPLAIN_ANDROID, this.mInstallExplainAndroid);
        intent.putExtra(Constants.Companion.INSTALL_EXPLAIN_IOS, this.mInstallExplainIos);
        intent.putExtra(Constants.Companion.LOGIN_EXPLAIN_ANDROID, this.mLoginExplainAndroid);
        intent.putExtra(Constants.Companion.LOGIN_EXPLAIN_IOS, this.mLoginExplainIos);
        intent.putExtra(Constants.Companion.CAN_SKIP, this.mCanSkip);
        intent.putExtra(Constants.Companion.CAN_STANDALONE, this.mCanStandalone);
        intent.putExtra("package_name", this.mActivity.getPackageName());
        if (intent.resolveActivity(this.mActivity.getPackageManager()) != null) {
            k.c("PageStep", "Has companion check activity, start with canSkip %s, canStandalone %s", Boolean.valueOf(this.mCanSkip), Boolean.valueOf(this.mCanStandalone));
            this.mStartForResult.startActivityForResult(intent, new StartForResult.OnActivityResultCallback() { // from class: com.mobvoi.wear.helper.c
                @Override // com.mobvoi.wear.common.StartForResult.OnActivityResultCallback
                public final void onCallback(StartForResult.ActivityResult activityResult) {
                    CompanionCheckPageStep.this.lambda$execute$0(activityResult);
                }
            });
        }
        k.a("PageStep", "Companion check activity not found, skip check.");
        complete(PageStep.PageStepResult.Skipped);
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    public String getName() {
        return "Companion";
    }

    public CompanionCheckPageStep setCanSkip(boolean z10) {
        this.mCanSkip = z10;
        return this;
    }

    public CompanionCheckPageStep setCanStandalone(boolean z10) {
        this.mCanStandalone = z10;
        return this;
    }

    public CompanionCheckPageStep setInstallExplainAndroid(String str) {
        this.mInstallExplainAndroid = str;
        return this;
    }

    public CompanionCheckPageStep setInstallExplainIos(String str) {
        this.mInstallExplainIos = str;
        return this;
    }

    public CompanionCheckPageStep setLoginExplainAndroid(String str) {
        this.mLoginExplainAndroid = str;
        return this;
    }

    public CompanionCheckPageStep setLoginExplainIos(String str) {
        this.mLoginExplainIos = str;
        return this;
    }
}
