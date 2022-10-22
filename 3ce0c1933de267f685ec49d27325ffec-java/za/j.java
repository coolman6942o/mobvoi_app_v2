package za;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.mobvoi.assistant.account.tab.about.SettingAboutActivity;
import com.mobvoi.assistant.account.tab.settings.CommonListActivity;
import com.mobvoi.assistant.account.tab.webview.OverseaBrowserActivity;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.companion.setting.Constants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import db.e;
import kc.b;
import lb.c;
import mb.g;
/* compiled from: SettingActionImpl.java */
/* loaded from: classes2.dex */
public class j implements g {

    /* renamed from: a  reason: collision with root package name */
    private Context f37325a;

    /* renamed from: b  reason: collision with root package name */
    private int f37326b = 0;

    public j(Context context) {
        this.f37325a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(DialogInterface dialogInterface, int i10) {
        a.setDevelopMode(this.f37325a, true);
        ((SettingAboutActivity) this.f37325a).g0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(DialogInterface dialogInterface, int i10) {
        a.setDevelopMode(this.f37325a, false);
    }

    private void q(String str) {
        Intent intent = new Intent("com.mobvoi.action.OPEN_BROWSER");
        intent.putExtra("url", str);
        this.f37325a.startActivity(intent);
    }

    private void r(String str) {
        OverseaBrowserActivity.J(this.f37325a, str);
    }

    private void s() {
        new AlertDialog.Builder(this.f37325a).setMessage(g.f30639i).setPositiveButton(g.f30637f, new DialogInterface.OnClickListener() { // from class: za.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                j.this.o(dialogInterface, i10);
            }
        }).setNegativeButton(g.f30635d, new DialogInterface.OnClickListener() { // from class: za.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                j.this.p(dialogInterface, i10);
            }
        }).show();
    }

    @Override // za.g
    public void a() {
        q("https://store.ticwear.com/");
    }

    @Override // za.g
    public void b() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.f37325a.getPackageName()));
        if (this.f37325a.getPackageManager().queryIntentActivities(intent, WXMediaMessage.THUMB_LENGTH_LIMIT).size() != 0) {
            this.f37325a.startActivity(intent);
            return;
        }
        q("http://m.wandoujia.com/apps/" + this.f37325a.getPackageName());
    }

    @Override // za.g
    public void c() {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.f37325a.getPackageName()));
        if (this.f37325a.getPackageManager().queryIntentActivities(intent, WXMediaMessage.THUMB_LENGTH_LIMIT).size() != 0) {
            this.f37325a.startActivity(intent);
        }
    }

    @Override // za.g
    public void d() {
        lc.a.a(this.f37325a, "chumenwenwen");
        Context context = this.f37325a;
        Toast.makeText(context, context.getString(g.f30648v, "chumenwenwen"), 0).show();
    }

    @Override // za.g
    public void e() {
    }

    @Override // za.g
    public void f() {
        if (a.isOversea()) {
            CommonListActivity.Q(this.f37325a, 1);
            return;
        }
        Intent intent = new Intent("android.intent.action.FEED_BACK");
        intent.putExtra("wwid", ta.a.x());
        this.f37325a.startActivity(intent);
    }

    @Override // za.g
    public void g() {
        int i10 = this.f37326b + 1;
        this.f37326b = i10;
        if (i10 >= 4 && !a.isDevelopMode(this.f37325a)) {
            s();
        }
    }

    @Override // za.g
    public void h() {
        r(c.d() ? "https://www.mobvoi.com/tw/pages/privacy-policy" : Constants.PRIVACY_URL);
    }

    @Override // za.g
    public void i() {
        CommonListActivity.Q(this.f37325a, 0);
    }

    @Override // za.g
    public void j() {
        ((e) b.b().a(e.class)).j();
    }

    @Override // za.g
    public void k() {
        q("http://weibo.com/chumenwenwen");
    }

    @Override // za.g
    public void l() {
        r(c.d() ? "https://www.mobvoi.com/tw/pages/terms-of-service" : Constants.TERMS_URL);
    }
}
