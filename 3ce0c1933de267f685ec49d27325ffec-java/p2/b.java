package p2;

import cn.com.fmsh.FM_Exception;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import x2.c;
import x2.e;
import x2.f;
import x2.g;
import z2.a;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ byte f32542b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ int f32543c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ byte[] f32544d;

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ a f32541a = z2.b.a().b();

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ Map<Integer, Integer> f32545e = new HashMap();

    public b() {
        x2.b.b(2, "NjaeI# )\"!)");
    }

    public boolean a(byte[] bArr) {
        if (bArr == null) {
            this.f32541a.c(FM_Exception.insert(3, 47, "Ff!a\u00117p%:})"), x2.a.b("\u0014\u000eCE诮汀朔朏迉嚘纜柄a乄乘乜杤按仳标诏墌劻斲ａ计氝杗杊辎囝统枉两穽＜莮厔奺赱", 5, 9));
            return false;
        } else if (bArr.length != 3) {
            this.f32541a.c(x2.a.b("\u0013|b5\b1\u007f}'/\"", 2, 26), g.a(3, 38, "\u0012I[\u0010诼汓杈杆迗嚗纜枉;乏丌不朲捞任桂讍墏劷斫／丂乏朴挜亥乊吅泆"));
            return false;
        } else {
            this.f32545e.put(Integer.valueOf(c.e(Arrays.copyOf(bArr, 2))), Integer.valueOf(c.e(Arrays.copyOfRange(bArr, 2, 3))));
            return true;
        }
    }

    public byte[] b() {
        return this.f32544d;
    }

    public int c() {
        return this.f32543c;
    }

    public int d(byte[] bArr) {
        if (bArr == null) {
            this.f32541a.c(e.a(3, "\u0019+:tVb{xu`b"), f.a("桥挷\u0017\u0003\u0014\u0018讽氅杛杚迊囅绋枉莥叙万三持仧的栚诜旡８详汌朔朓近囜續柀乣稬｟菧厛奻赢", 212));
            return -1;
        }
        Integer num = this.f32545e.get(Integer.valueOf(c.e(bArr)));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public byte e() {
        return this.f32542b;
    }

    public boolean f() {
        return !this.f32545e.isEmpty();
    }

    public void g(byte[] bArr) {
        this.f32544d = bArr;
    }

    public void h(int i10) {
        this.f32543c = i10;
    }

    public void i(byte b10) {
        this.f32542b = b10;
    }
}
