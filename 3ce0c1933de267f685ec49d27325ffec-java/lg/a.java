package lg;

import com.alibaba.fastjson.annotation.JSONField;
import com.mobvoi.health.common.data.pojo.SportType;
import df.d;
import java.util.List;
/* compiled from: UserMotionSettingResponse.java */
/* loaded from: classes2.dex */
public class a extends d {
    @JSONField(name = "motionTypes")
    public List<SportType> motionTypes;

    public String toString() {
        return "UserMotionSettingResponse{motionTypes=" + this.motionTypes + '}';
    }
}
