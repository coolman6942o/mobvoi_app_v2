package com.mobvoi.companion.health.thirdparty.wechat;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: BindWechatBean.kt */
/* loaded from: classes2.dex */
public final class b implements JsonBean {
    private String bindPath;
    private int miniProgramType;
    private String replaceStr;
    private String unbindPath;
    private String userName;

    public b() {
        this(null, null, null, null, 0, 31, null);
    }

    public b(String replaceStr, String userName, String bindPath, String unbindPath, int i10) {
        i.f(replaceStr, "replaceStr");
        i.f(userName, "userName");
        i.f(bindPath, "bindPath");
        i.f(unbindPath, "unbindPath");
        this.replaceStr = replaceStr;
        this.userName = userName;
        this.bindPath = bindPath;
        this.unbindPath = unbindPath;
        this.miniProgramType = i10;
    }

    public final String a() {
        return this.bindPath;
    }

    public final int b() {
        return this.miniProgramType;
    }

    public final String c() {
        return this.replaceStr;
    }

    public final String d() {
        return this.unbindPath;
    }

    public final String e() {
        return this.userName;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return i.b(this.replaceStr, bVar.replaceStr) && i.b(this.userName, bVar.userName) && i.b(this.bindPath, bVar.bindPath) && i.b(this.unbindPath, bVar.unbindPath) && this.miniProgramType == bVar.miniProgramType;
    }

    public int hashCode() {
        return (((((((this.replaceStr.hashCode() * 31) + this.userName.hashCode()) * 31) + this.bindPath.hashCode()) * 31) + this.unbindPath.hashCode()) * 31) + this.miniProgramType;
    }

    public String toString() {
        return "BindConfigBean(replaceStr=" + this.replaceStr + ", userName=" + this.userName + ", bindPath=" + this.bindPath + ", unbindPath=" + this.unbindPath + ", miniProgramType=" + this.miniProgramType + ')';
    }

    public /* synthetic */ b(String str, String str2, String str3, String str4, int i10, int i11, f fVar) {
        this((i11 & 1) != 0 ? "#placeholder" : str, (i11 & 2) != 0 ? "gh_471f5f7b25a9" : str2, (i11 & 4) != 0 ? "pages/discover-new/discover-new?from=wxsport&&ticket=#placeholder" : str3, (i11 & 8) != 0 ? "pages/delete-devices/delete-devices?from=wxsport&&sdkIdList=#placeholder" : str4, (i11 & 16) != 0 ? 0 : i10);
    }
}
