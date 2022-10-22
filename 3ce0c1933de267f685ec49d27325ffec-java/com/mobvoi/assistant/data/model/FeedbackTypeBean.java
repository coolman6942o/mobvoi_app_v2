package com.mobvoi.assistant.data.model;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class FeedbackTypeBean implements JsonBean, Serializable {
    private static final long serialVersionUID = 5391125480349369158L;
    @c("content")
    public List<ContentBean> content;
    @c("product")
    public String product;

    /* loaded from: classes2.dex */
    public static class CommonTypeNameBean implements Serializable {
        private static final long serialVersionUID = -8110516501605987389L;
        @c("cn")
        public String cnTypeName;
        @c("en")
        public String enTypeName;
        @c("tw")
        public String twTypeName;
    }

    /* loaded from: classes2.dex */
    public static class ContentBean implements Serializable {
        private static final long serialVersionUID = 7004794648413846180L;
        @c("multiple")
        public boolean multiple;
        @c("detail")
        public List<CommonTypeNameBean> subTypeList;
        @c("title")
        public CommonTypeNameBean type;
    }
}
