package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.FAQSMsg;
import java.util.List;
/* loaded from: classes.dex */
public class FAQSBusiRespInfo extends BaseBusiRespInfo {
    private List<FAQSMsg> faqs;

    public List<FAQSMsg> getFaqs() {
        return this.faqs;
    }

    public void setFaqs(List<FAQSMsg> list) {
        this.faqs = list;
    }
}
