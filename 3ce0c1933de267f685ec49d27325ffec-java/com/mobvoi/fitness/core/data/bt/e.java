package com.mobvoi.fitness.core.data.bt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
/* compiled from: BtUserProfile.java */
/* loaded from: classes2.dex */
public class e extends a {
    private static final String JSON_BIRTHDAY = "birth";
    private static final String JSON_HEIGHT = "height";
    private static final String JSON_SEX = "sex";
    private static final String JSON_WEIGHT = "weight";
    @JSONField(name = JSON_BIRTHDAY)
    public int birthday = -1;
    @JSONField(name = JSON_SEX)
    public int sex = -1;
    @JSONField(name = JSON_WEIGHT)
    public float weight = -1.0f;
    @JSONField(name = "height")
    public float height = -1.0f;

    public static e b(String str) {
        return (e) JSON.parseObject(str, e.class);
    }
}
