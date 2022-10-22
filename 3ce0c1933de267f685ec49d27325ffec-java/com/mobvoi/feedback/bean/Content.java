package com.mobvoi.feedback.bean;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class Content implements JsonBean, Serializable {
    private List<Detail> detail;
    private boolean multiple;
    @c("title")
    private Title title;

    public List<Detail> getDetail() {
        return this.detail;
    }

    public boolean getMultiple() {
        return this.multiple;
    }

    public Title getTitle() {
        return this.title;
    }

    public void setDetail(List<Detail> list) {
        this.detail = list;
    }

    public void setMultiple(boolean z10) {
        this.multiple = z10;
    }

    public void setTitle(Title title) {
        this.title = title;
    }
}
