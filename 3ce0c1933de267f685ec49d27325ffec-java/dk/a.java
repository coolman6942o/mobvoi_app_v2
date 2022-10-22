package dk;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import java.util.List;
/* compiled from: CareSettingResult.java */
/* loaded from: classes2.dex */
public class a extends c {
    @c("data")
    public List<C0276a> data;

    /* compiled from: CareSettingResult.java */
    /* renamed from: dk.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0276a implements JsonBean {
        @c("shareDataStatus")
        public boolean shareDataStatus;
        @c("shareDataType")
        public String shareDataType;
    }
}
