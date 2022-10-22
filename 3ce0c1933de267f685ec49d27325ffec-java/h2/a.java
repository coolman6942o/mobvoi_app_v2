package h2;

import cn.com.fmsh.communication.message.enumerate.ETagType;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private static /* synthetic */ a f27710b;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ Map<ETagType, g> f27711a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void <init>() {
        this.f27711a.put(ETagType.S, new b());
        this.f27711a.put(ETagType.N, new c());
        this.f27711a.put(ETagType.U, new f());
        this.f27711a.put(ETagType.H, new e());
        this.f27711a.put(ETagType.G, new d());
    }

    public static a c() {
        if (f27710b == null) {
            f27710b = new a();
        }
        return f27710b;
    }

    public g b(ETagType eTagType) {
        return this.f27711a.get(eTagType);
    }
}
