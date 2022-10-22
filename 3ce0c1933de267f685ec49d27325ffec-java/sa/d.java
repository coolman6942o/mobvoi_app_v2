package sa;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.providers.SocialContract;
import h8.c;
/* compiled from: ImageUploadResponse.java */
/* loaded from: classes2.dex */
public class d extends c {
    public a result;

    /* compiled from: ImageUploadResponse.java */
    /* loaded from: classes2.dex */
    public static class a implements JsonBean {
        @c(SocialContract.RankingUserColumns.IMG_URL)
        public String imageUrl;
    }
}
