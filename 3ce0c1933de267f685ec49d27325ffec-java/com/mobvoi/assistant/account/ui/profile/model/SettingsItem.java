package com.mobvoi.assistant.account.ui.profile.model;

import android.view.View;
import com.mobvoi.android.common.json.JsonBean;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SettingsItem implements JsonBean, Serializable {
    public String desc;
    public boolean hideRightIcon;
    public View.OnClickListener onClick;
    public int rightIconRes;
    public String title;
}
