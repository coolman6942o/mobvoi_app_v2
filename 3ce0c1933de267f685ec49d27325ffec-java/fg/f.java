package fg;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.health.companion.model.MessageReply;
import com.mobvoi.health.companion.provider.Recorder;
import com.mobvoi.health.companion.system.c;
import com.mobvoi.wear.common.base.WearPath;
/* compiled from: HealthDataSyncController.java */
/* loaded from: classes2.dex */
public class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            k.a("health.HealthDataSync", " saveWearData " + new String(bArr));
            Recorder recorder = (Recorder) JSON.parseObject(bArr, Recorder.class, new Feature[0]);
            if (recorder != null) {
                MessageReply messageReply = new MessageReply();
                messageReply.messageId = recorder.messageId;
                c.a().e(WearPath.Health.CMD_NEW_WEAR_PUSH_TO_PHONE, JSON.toJSONBytes(messageReply, new SerializerFeature[0]));
                k.a("health.HealthDataSync", "sync steps " + recorder.current_step);
                c.a().i(context, recorder.current_step);
            }
        }
    }

    public static void b(Context context) {
        c.a().e(WearPath.Health.CMD_WEAR_PUSH_TO_PHONE, new byte[0]);
        c.a().n(context);
    }
}
