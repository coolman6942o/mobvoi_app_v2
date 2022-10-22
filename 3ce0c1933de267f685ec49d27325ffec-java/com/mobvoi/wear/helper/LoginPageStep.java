package com.mobvoi.wear.helper;

import android.app.Activity;
import android.text.TextUtils;
import com.mobvoi.wear.common.StartForResult;
import com.mobvoi.wear.common.steps.PageStep;
import com.mobvoi.wear.info.AccountInfoHelper;
import com.mobvoi.wear.util.AccountWearUtil;
/* loaded from: classes2.dex */
public class LoginPageStep extends PageStep {
    protected Activity mActivity;
    private boolean mForceLogin;
    private boolean mLoginCanCancel;
    private StartForResult mStartForResult;

    public LoginPageStep(Activity activity) {
        this.mActivity = activity;
        this.mStartForResult = StartForResult.newInstance(activity);
    }

    private void doRequestLogin(boolean z10, StartForResult.OnActivityResultCallback onActivityResultCallback) {
        this.mStartForResult.startActivityForResult(AccountWearUtil.getLoginIntent(z10), onActivityResultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$execute$0(StartForResult.ActivityResult activityResult) {
        complete(activityResult.resultCode == 0 ? PageStep.PageStepResult.Failed : PageStep.PageStepResult.Success);
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    protected void execute() {
        if ((this.mForceLogin || !AccountInfoHelper.getInstance(this.mActivity).getNotRemindLogin()) && AccountWearUtil.isAccountLoginEnable(this.mActivity) && TextUtils.isEmpty(AccountInfoHelper.getInstance(this.mActivity).getWwid())) {
            doRequestLogin(this.mLoginCanCancel, new StartForResult.OnActivityResultCallback() { // from class: com.mobvoi.wear.helper.d
                @Override // com.mobvoi.wear.common.StartForResult.OnActivityResultCallback
                public final void onCallback(StartForResult.ActivityResult activityResult) {
                    LoginPageStep.this.lambda$execute$0(activityResult);
                }
            });
        } else {
            complete(PageStep.PageStepResult.Skipped);
        }
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    public String getName() {
        return "Login";
    }

    public LoginPageStep setForceLogin(boolean z10) {
        this.mForceLogin = z10;
        return this;
    }

    public LoginPageStep setLoginCanCancel(boolean z10) {
        this.mLoginCanCancel = z10;
        return this;
    }
}
