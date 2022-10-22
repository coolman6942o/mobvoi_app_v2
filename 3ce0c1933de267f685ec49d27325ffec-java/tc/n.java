package tc;

import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.ble.BleProtocol;
import com.mobvoi.wear.permission.PermissionConstant;
import h8.c;
/* compiled from: HealthReportResponse.kt */
/* loaded from: classes2.dex */
public final class n implements JsonBean {
    @c("createdAt")
    private Long createAt;
    @c("expireAt")
    private Long expireAt;
    @c("expiresIn")
    private Long expiresIn;
    @c("id")

    /* renamed from: id  reason: collision with root package name */
    private Integer f35124id;
    @c("imageUrl")
    private String imageUrl;
    @c("imageUrl2")
    private String imageUrl2;
    @c("oversea")
    private Boolean isOversea;
    @c("link")
    private String link;
    @c("linkType")
    private Integer linkType;
    @c(BleProtocol.PRIORITY)
    private Integer priority;
    @c(PermissionConstant.Columns.STATUS)
    private Boolean status;
    @c("title")
    private String title;
    @c("type")
    private Integer type;
    @c("updatedAt")
    private Long updatedAt;

    public final String a() {
        return this.imageUrl;
    }

    public final String b() {
        return this.imageUrl2;
    }

    public final String c() {
        return this.link;
    }

    public final String d() {
        return this.title;
    }

    public final void e(String str) {
        this.link = str;
    }
}
