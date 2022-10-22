package com.bjleisen.iface.sdk.bean.resp;

import com.bjleisen.iface.sdk.bean.Notice;
import java.util.List;
/* loaded from: classes.dex */
public class NoticeRespInfo extends BaseBusiRespInfo {
    private List<Notice> noticeList;

    public List<Notice> getNoticeList() {
        return this.noticeList;
    }

    public void setNoticeList(List<Notice> list) {
        this.noticeList = list;
    }
}
