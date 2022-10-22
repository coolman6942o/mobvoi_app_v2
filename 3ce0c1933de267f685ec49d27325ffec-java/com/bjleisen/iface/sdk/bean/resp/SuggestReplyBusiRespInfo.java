package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.SuggestMsg;
import java.util.List;
/* loaded from: classes.dex */
public class SuggestReplyBusiRespInfo extends BaseBusiRespInfo {
    private List<SuggestMsg> suggestMsg;

    public List<SuggestMsg> getSuggestMsg() {
        return this.suggestMsg;
    }

    public void setSuggestMsg(List<SuggestMsg> list) {
        this.suggestMsg = list;
    }
}
