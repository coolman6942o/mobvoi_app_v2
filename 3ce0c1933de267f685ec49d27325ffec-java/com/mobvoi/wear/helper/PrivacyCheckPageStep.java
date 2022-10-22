package com.mobvoi.wear.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.R;
import com.mobvoi.wear.common.StartForResult;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.common.steps.PageStep;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class PrivacyCheckPageStep extends PageStep {
    private static final Map<String, Integer> PRIVACY_CAPABILITIES_MAP;
    private Activity mActivity;
    private String[] mImpactList;
    private String[] mPrivacyList;

    static {
        HashMap hashMap = new HashMap();
        PRIVACY_CAPABILITIES_MAP = hashMap;
        hashMap.put(SharedWearInfoHelper.GdprInfo.KEY_DATA_STEP, Integer.valueOf(R.string.capability_privacy_cloud_sync));
    }

    public PrivacyCheckPageStep(Activity activity) {
        this.mActivity = activity;
    }

    private boolean check(Activity activity, String[] strArr, String[] strArr2) {
        boolean z10;
        boolean z11;
        if (strArr.length == 0) {
            return false;
        }
        if (strArr.length != strArr2.length) {
            k.f("PageStep", "privacy %s and refused impact %s size dose not match!", Arrays.toString(strArr), Arrays.toString(strArr2));
            if (!k.j()) {
                return false;
            }
            throw new IllegalArgumentException("privacy list and refused list size must match.");
        } else if (!SharedWearInfoHelper.getInstance(this.mActivity).isGdprEnabled()) {
            k.a("PageStep", "Privacy not enabled, skip check");
            return false;
        } else {
            StartForResult.OnActivityResultCallback pVar = new StartForResult.OnActivityResultCallback() { // from class: com.mobvoi.wear.helper.p
                @Override // com.mobvoi.wear.common.StartForResult.OnActivityResultCallback
                public final void onCallback(StartForResult.ActivityResult activityResult) {
                    PrivacyCheckPageStep.this.lambda$check$0(activityResult);
                }
            };
            for (String str : strArr) {
                Integer num = PRIVACY_CAPABILITIES_MAP.get(str);
                if (num != null && !SharedWearInfoHelper.getInstance(this.mActivity).getWearCapabilities().contains(this.mActivity.getString(num.intValue()))) {
                    k.s("PageStep", "privacy %s not supported in current Privacy App, update is required", str);
                    z10 = true;
                } else if (!SharedWearInfoHelper.getInstance(activity).isGdprDataEnabled(str)) {
                    z10 = false;
                }
                z11 = z10;
                break;
            }
            z10 = false;
            z11 = true;
            if (z10) {
                AlertDialog alertDialog = new AlertDialog(this.mActivity);
                alertDialog.setMessage(activity.getString(R.string.privacy_app_version_too_old));
                alertDialog.setIconPositiveButton(k.f20921a);
                alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mobvoi.wear.helper.n
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        PrivacyCheckPageStep.this.lambda$check$2(dialogInterface);
                    }
                });
                alertDialog.show();
                return true;
            } else if (z11) {
                return false;
            } else {
                Intent intent = new Intent(Constants.Privacy.ACTION_CHECK);
                intent.putExtra(Constants.Privacy.KEY_CHECK_PRIVACY_LIST, strArr);
                intent.putExtra(Constants.Privacy.KEY_CHECK_IMPACT_LIST, strArr2);
                if (intent.resolveActivity(activity.getPackageManager()) != null) {
                    k.a("PageStep", "Has privacy check activity, start with result");
                    intent.addFlags(4194304);
                    StartForResult.newInstance(activity).startActivityForResult(intent, pVar);
                    return true;
                }
                k.q("PageStep", "Privacy check activity not found, skip check.");
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$check$0(StartForResult.ActivityResult activityResult) {
        complete(activityResult.resultCode == -1 ? PageStep.PageStepResult.Success : PageStep.PageStepResult.Failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$check$1(DialogInterface dialogInterface, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$check$2(DialogInterface dialogInterface) {
        complete(PageStep.PageStepResult.Failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$check$3(StartForResult.ActivityResult activityResult) {
        complete(activityResult.resultCode == -1 ? PageStep.PageStepResult.Success : PageStep.PageStepResult.Failed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$check$4(DialogInterface dialogInterface, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$check$5(DialogInterface dialogInterface) {
        complete(PageStep.PageStepResult.Failed);
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    protected void execute() {
        if (!check(this.mActivity, this.mPrivacyList)) {
            complete(PageStep.PageStepResult.Skipped);
        }
    }

    @Override // com.mobvoi.wear.common.steps.PageStep
    public String getName() {
        return "Privacy";
    }

    public PrivacyCheckPageStep setImpactList(String[] strArr) {
        this.mImpactList = strArr;
        return this;
    }

    public PrivacyCheckPageStep setPrivacyList(String[] strArr) {
        this.mPrivacyList = strArr;
        return this;
    }

    private boolean check(Activity activity, String[] strArr) {
        boolean z10;
        boolean z11;
        if (strArr.length == 0) {
            return false;
        }
        if (!SharedWearInfoHelper.getInstance(this.mActivity).isGdprEnabled()) {
            k.a("PageStep", "Privacy not enabled, skip check");
            return false;
        }
        StartForResult.OnActivityResultCallback oVar = new StartForResult.OnActivityResultCallback() { // from class: com.mobvoi.wear.helper.o
            @Override // com.mobvoi.wear.common.StartForResult.OnActivityResultCallback
            public final void onCallback(StartForResult.ActivityResult activityResult) {
                PrivacyCheckPageStep.this.lambda$check$3(activityResult);
            }
        };
        for (String str : strArr) {
            Integer num = PRIVACY_CAPABILITIES_MAP.get(str);
            if (num != null && !SharedWearInfoHelper.getInstance(this.mActivity).getWearCapabilities().contains(this.mActivity.getString(num.intValue()))) {
                k.s("PageStep", "privacy %s not supported in current Privacy App, update is required", str);
                z10 = true;
            } else if (!SharedWearInfoHelper.getInstance(activity).isGdprDataEnabled(str)) {
                z10 = false;
            }
            z11 = z10;
        }
        z10 = false;
        z11 = true;
        if (z10) {
            AlertDialog alertDialog = new AlertDialog(this.mActivity);
            alertDialog.setMessage(activity.getString(R.string.privacy_app_version_too_old));
            alertDialog.setIconPositiveButton(l.f20922a);
            alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mobvoi.wear.helper.m
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    PrivacyCheckPageStep.this.lambda$check$5(dialogInterface);
                }
            });
            alertDialog.show();
            return true;
        } else if (z11) {
            return false;
        } else {
            Intent intent = new Intent(Constants.Privacy.ACTION_SETTINGS);
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                k.a("PageStep", "Has privacy check activity, start with result");
                intent.addFlags(4194304);
                StartForResult.newInstance(activity).startActivityForResult(intent, oVar);
                return true;
            }
            k.q("PageStep", "Privacy check activity not found, skip check.");
            return false;
        }
    }
}
