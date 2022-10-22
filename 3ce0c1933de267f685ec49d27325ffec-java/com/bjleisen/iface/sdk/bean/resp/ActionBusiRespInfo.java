package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.Action;
import java.util.List;
/* loaded from: classes.dex */
public class ActionBusiRespInfo extends BaseBusiRespInfo {
    private List<Action> actions;

    public List<Action> getActions() {
        return this.actions;
    }

    public void setActions(List<Action> list) {
        this.actions = list;
    }
}
