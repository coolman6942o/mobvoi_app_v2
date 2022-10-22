package ya;

import ab.a;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.f;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.assistant.account.data.AccountManager;
import com.mobvoi.assistant.account.tab.about.SettingAboutActivity;
import com.mobvoi.assistant.account.tab.settings.CommonListActivity;
import com.mobvoi.assistant.account.tab.webview.OverseaBrowserActivity;
import com.mobvoi.assistant.account.tab.webview.ShareBrowserActivity;
import com.mobvoi.companion.MobvoiCropParams;
import com.mobvoi.companion.MobvoiPhotoCropHelper;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.ticcare.common.model.bean.TicCareDeviceInfo;
import com.unionpay.tsmservice.data.Constant;
import hc.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kb.g;
import kb.h;
import kb.m;
import lb.c;
import nb.b;
/* compiled from: AccountTabFragment.java */
/* loaded from: classes2.dex */
public class v extends a implements h {

    /* renamed from: g  reason: collision with root package name */
    private static final String f36902g = v.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f36903h = {"android.permission.CAMERA"};

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f36904i = {"android.permission.WRITE_EXTERNAL_STORAGE"};

    /* renamed from: c  reason: collision with root package name */
    private w f36905c;

    /* renamed from: d  reason: collision with root package name */
    private g f36906d;

    /* renamed from: e  reason: collision with root package name */
    private String f36907e;

    /* renamed from: f  reason: collision with root package name */
    private b f36908f;

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(View view) {
        e0("clickAbout");
        SettingAboutActivity.start(requireActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        f requireActivity = requireActivity();
        e0("clickAuth");
        Intent intent = new Intent("com.mobvoi.action.AUTH");
        intent.setPackage(requireActivity.getPackageName());
        requireActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(View view) {
        f requireActivity = requireActivity();
        e0("clickFeedback");
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            CommonListActivity.Q(requireActivity, 1);
            return;
        }
        Intent intent = new Intent("android.intent.action.FEED_BACK");
        intent.setPackage(requireActivity.getPackageName());
        intent.putExtra("wwid", ta.a.x());
        requireActivity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        OverseaBrowserActivity.J(requireActivity(), "https://www.mobvoi.com/mobvoi-app/activity");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        e0("clickReport");
        Intent intent = new Intent(requireActivity(), ShareBrowserActivity.class);
        intent.putExtra("url", "http://h5.mobvoi.com/vpa-user-analysis/dist/#/index");
        intent.putExtra(Constant.KEY_PARAMS, true);
        intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, false);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        e0("clickRecorder");
        Intent intent = new Intent("com.mobvoi.companion.action.RECORD_MAIN");
        intent.setPackage(requireActivity().getPackageName());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        f requireActivity = requireActivity();
        e0("clickAccountSettings");
        if (!com.mobvoi.companion.base.settings.a.isOversea()) {
            Intent intent = new Intent("com.mobvoi.action.USER_SETTING");
            intent.setPackage(requireActivity.getPackageName());
            requireActivity.startActivity(intent);
        } else if (!TextUtils.isEmpty(ta.a.s())) {
            c.s(requireActivity, mb.a.f30619a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        e0("clickTiccare");
        Intent intent = new Intent("com.mobvoi.companion.action.TICCARE_SETTINGS");
        intent.setPackage(requireActivity().getPackageName());
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        e0("clickAvatar");
        f1();
    }

    private void J0(Uri uri) {
        MobvoiPhotoCropHelper.INSTANCE.launchCropImageActivity(this, uri, 102);
    }

    private void K0(Bitmap bitmap) {
        g gVar = this.f36906d;
        if (gVar != null) {
            gVar.i(bitmap);
        }
    }

    public static void L0(Context context, String str, Boolean bool) {
        if (bool.booleanValue()) {
            d1(context, str);
        } else {
            V0(context, str);
        }
    }

    public static void M0(Context context, String str) {
        OverseaBrowserActivity.J(context, str);
    }

    private void N0() {
        w wVar = (w) new h0(this).a(w.class);
        this.f36905c = wVar;
        wVar.f36909m.i(getViewLifecycleOwner(), new x() { // from class: ya.s
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                v.this.k1(((Integer) obj).intValue());
            }
        });
        this.f36905c.z().i(getViewLifecycleOwner(), new x() { // from class: ya.r
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                v.this.j1((Pair) obj);
            }
        });
    }

    private void O0() {
        int i10 = 0;
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            this.f36908f.f31109k.setVisibility(0);
            this.f36908f.f31102d.setVisibility(8);
        } else {
            this.f36908f.f31109k.setVisibility(8);
            this.f36908f.f31102d.setVisibility(0);
        }
        LinearLayout linearLayout = this.f36908f.f31106h;
        if (!com.mobvoi.companion.base.settings.a.isOversea()) {
            i10 = 8;
        }
        linearLayout.setVisibility(i10);
        i1();
        this.f36908f.f31107i.setOnClickListener(c1(new Runnable() { // from class: ya.u
            @Override // java.lang.Runnable
            public final void run() {
                v.this.B0();
            }
        }));
        this.f36908f.f31104f.setOnClickListener(c1(new Runnable() { // from class: ya.c
            @Override // java.lang.Runnable
            public final void run() {
                v.this.E0();
            }
        }));
        this.f36908f.f31105g.setOnClickListener(c1(new Runnable() { // from class: ya.j
            @Override // java.lang.Runnable
            public final void run() {
                v.this.I0();
            }
        }));
        this.f36908f.f31113o.setOnClickListener(c1(new Runnable() { // from class: ya.t
            @Override // java.lang.Runnable
            public final void run() {
                v.this.g1();
            }
        }));
        this.f36908f.f31115q.setOnClickListener(c1(new Runnable() { // from class: ya.e
            @Override // java.lang.Runnable
            public final void run() {
                v.this.G0();
            }
        }));
        this.f36908f.f31108j.setOnClickListener(c1(new Runnable() { // from class: ya.g
            @Override // java.lang.Runnable
            public final void run() {
                v.this.H0();
            }
        }));
        this.f36908f.f31110l.setOnClickListener(c1(new Runnable() { // from class: ya.b
            @Override // java.lang.Runnable
            public final void run() {
                v.this.F0();
            }
        }));
        this.f36908f.f31106h.setOnClickListener(c1(new Runnable() { // from class: ya.d
            @Override // java.lang.Runnable
            public final void run() {
                v.this.D0();
            }
        }));
        this.f36908f.f31103e.setOnClickListener(new View.OnClickListener() { // from class: ya.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.this.C0(view);
            }
        });
        this.f36908f.f31100b.setOnClickListener(new View.OnClickListener() { // from class: ya.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.this.A0(view);
            }
        });
        N0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P0(Runnable runnable, View view) {
        if (Z()) {
            runnable.run();
        } else {
            d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(DialogInterface dialogInterface, int i10) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", requireActivity().getPackageName(), null));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R0(DialogInterface dialogInterface, int i10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S0(DialogInterface dialogInterface, int i10) {
        if (i10 == 0) {
            f requireActivity = requireActivity();
            String[] strArr = f36903h;
            if (e.i(requireActivity, strArr)) {
                h1();
            } else {
                e1(strArr, 2);
            }
        } else if (e.j(requireContext())) {
            a1();
        } else {
            e1(f36904i, 3);
        }
    }

    public static v T0() {
        return new v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            M0(requireActivity(), "https://www.mobvoi.com/account/addresses");
        } else {
            L0(requireActivity(), "https://store.ticwear.com/pages/login-redirect?redirect_to=https%3A%2F%2Fstore.ticwear.com%2Faccount%2F%23%2Faddress", Boolean.FALSE);
        }
    }

    private static void V0(Context context, String str) {
        Intent intent = new Intent("com.mobvoi.action.OPEN_BROWSER");
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            M0(requireActivity(), "https://www.mobvoi.com/account/coupon");
        } else {
            L0(requireActivity(), "https://store.ticwear.com/pages/login-redirect?redirect_to=https%3A%2F%2Fstore.ticwear.com%2Faccount%2F%23%2Fcoupon", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            M0(requireActivity(), "https://www.mobvoi.com/account/orders");
        } else {
            L0(requireActivity(), "https://store.ticwear.com/pages/login-redirect?redirect_to=https%3A%2F%2Fstore.ticwear.com%2Faccount%2Forders", Boolean.FALSE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        f requireActivity = requireActivity();
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            OverseaBrowserActivity.J(requireActivity, "https://www.mobvoi.com?utm_source=mobvoiapp&utm_medium=app&utm_campaign=mobvoiapp");
            return;
        }
        d1(requireActivity, "https://store.ticwear.com/?utm_source=vpa&utm_medium=android&vpa_version=android_" + com.mobvoi.companion.base.settings.a.getVersionCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            M0(requireActivity(), "https://www.mobvoi.com/pages/support");
        } else {
            L0(requireActivity(), "https://shouhou.chumenwenwen.com/", Boolean.FALSE);
        }
    }

    private void a1() {
        Intent intent = new Intent("android.intent.action.PICK");
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 100);
    }

    private void b1(sa.a aVar) {
        if (!TextUtils.isEmpty(aVar.headUrl)) {
            com.bumptech.glide.c.v(this).r(aVar.headUrl).U(mb.b.a_res_0x7f08029a).f0(new aa.a()).u0(this.f36908f.f31105g);
        } else {
            this.f36908f.f31105g.setImageResource(mb.b.b_res_0x7f080337);
        }
        if (!TextUtils.isEmpty(aVar.nickName)) {
            this.f36908f.f31120v.setText(aVar.nickName);
        } else {
            this.f36908f.f31120v.setText("");
        }
        this.f36908f.f31119u.setText(mb.g.j_res_0x7f1403dc);
    }

    private View.OnClickListener c1(final Runnable runnable) {
        return new View.OnClickListener() { // from class: ya.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                v.this.P0(runnable, view);
            }
        };
    }

    private static void d1(Context context, String str) {
        Intent intent = new Intent("com.mobvoi.action.SHOP_BROWSER");
        intent.putExtra("url", str);
        intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
        intent.putExtra("auto_play_music", false);
        intent.putExtra("show_menu", false);
        intent.putExtra(Constant.KEY_PARAMS, -1);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    private void e1(String[] strArr, int i10) {
        if (!shouldShowRequestPermissionRationale(strArr[0])) {
            new k7.b(requireActivity()).q(mb.g.f30644p).D(getString(mb.g.f30643o, getString(mb.g.f30642n))).m(mb.g.f30637f, new DialogInterface.OnClickListener() { // from class: ya.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    v.this.Q0(dialogInterface, i11);
                }
            }).j(mb.g.f30635d, n.f36893a).t();
        } else {
            requestPermissions(strArr, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1() {
        if (!TextUtils.isEmpty(ta.a.s())) {
            e0("userInfo");
            Intent intent = new Intent("com.mobvoi.companion.action.HEALTH_INFO");
            intent.setPackage(requireActivity().getPackageName());
            startActivity(intent);
        }
    }

    private void h1() {
        MobvoiPhotoCropHelper mobvoiPhotoCropHelper = MobvoiPhotoCropHelper.INSTANCE;
        String generateCameraFilePath = mobvoiPhotoCropHelper.generateCameraFilePath(requireContext());
        this.f36907e = generateCameraFilePath;
        mobvoiPhotoCropHelper.launchCameraActivity(this, generateCameraFilePath, 101);
    }

    private void i1() {
        if (!Z()) {
            this.f36908f.f31105g.setImageResource(mb.b.b_res_0x7f080337);
            this.f36908f.f31120v.setText(mb.g.q_res_0x7f140c74);
            this.f36908f.f31119u.setText(mb.g.m_res_0x7f140ad3);
            return;
        }
        this.f36906d.p(ta.a.s(), com.mobvoi.android.common.utils.e.e(requireActivity()));
        sa.a g10 = AccountManager.h().g();
        if (g10 != null) {
            b1(g10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(Pair<Boolean, List<TicCareDeviceInfo>> pair) {
        Object obj;
        int size = (!((Boolean) pair.first).booleanValue() || (obj = pair.second) == null) ? 0 : ((List) obj).size();
        this.f36908f.f31101c.setText(getResources().getQuantityString(mb.f.f30631a, size, Integer.valueOf(size)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(int i10) {
        this.f36908f.f31111m.setText(getResources().getQuantityString(mb.f.f30632b, i10, Integer.valueOf(i10)));
    }

    @Override // kb.h
    public void A(String str) {
    }

    @Override // kb.h
    public void D(Bitmap bitmap, String str) {
        Toast.makeText(requireActivity(), str, 0).show();
        i1();
    }

    @Override // kb.h
    public void M() {
    }

    @Override // kb.h
    public void Q(sa.a aVar) {
        if (aVar != null) {
            b1(aVar);
        }
    }

    @Override // kb.h
    public void S(String str) {
        Toast.makeText(requireActivity(), str, 0).show();
    }

    @Override // ab.a
    protected int Y() {
        return 0;
    }

    @Override // ab.a
    public void a0() {
        this.f36905c.h0();
        this.f36905c.a0();
        this.f36906d.p(ta.a.s(), com.mobvoi.android.common.utils.e.e(requireActivity()));
    }

    @Override // ab.a
    public void b0() {
        i1();
        this.f36908f.f31111m.setText("");
        this.f36908f.f31101c.setText("");
    }

    protected void f1() {
        new k7.b(requireActivity()).B(new String[]{getString(mb.g.f30634c), getString(mb.g.f30636e)}, new DialogInterface.OnClickListener() { // from class: ya.l
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                v.this.S0(dialogInterface, i10);
            }
        }).a().show();
    }

    @Override // kb.h
    public void i(String str) {
    }

    @Override // kb.h
    public void m(String str) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        MobvoiPhotoCropHelper mobvoiPhotoCropHelper;
        File createTmpFileForChooseImage;
        super.onActivityResult(i10, i11, intent);
        k.c(f36902g, "onReceived Activity requestCode = %s , resultCode = %s", Integer.valueOf(i10), Integer.valueOf(i11));
        switch (i10) {
            case 100:
                if (i11 == -1 && intent != null && intent.getData() != null && (createTmpFileForChooseImage = (mobvoiPhotoCropHelper = MobvoiPhotoCropHelper.INSTANCE).createTmpFileForChooseImage(requireActivity(), intent.getData())) != null) {
                    J0(mobvoiPhotoCropHelper.getUriForFile(requireActivity(), createTmpFileForChooseImage));
                    return;
                }
                return;
            case 101:
                if (i11 == -1 && !TextUtils.isEmpty(this.f36907e)) {
                    File file = new File(this.f36907e);
                    if (file.exists()) {
                        J0(MobvoiPhotoCropHelper.INSTANCE.getUriForFile(requireActivity(), file));
                        return;
                    }
                    return;
                }
                return;
            case 102:
                if (i11 == -1) {
                    Bitmap bitmap = null;
                    try {
                        InputStream openInputStream = requireActivity().getContentResolver().openInputStream((Uri) intent.getParcelableExtra(MobvoiCropParams.EXTRA_CROP_OUTPUT_URI));
                        bitmap = BitmapFactory.decodeStream(openInputStream);
                        openInputStream.close();
                    } catch (FileNotFoundException e10) {
                        k.d(f36902g, e10.getMessage());
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    if (bitmap != null) {
                        K0(bitmap);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // ab.a, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        b d10 = b.d(layoutInflater, viewGroup, false);
        this.f36908f = d10;
        return d10.a();
    }

    @Override // ab.a, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f36905c.w();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f36908f = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sb.a.h(requireActivity(), "account");
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (i10 == 2) {
            f requireActivity = requireActivity();
            String[] strArr2 = f36903h;
            if (e.i(requireActivity, strArr2)) {
                h1();
            } else {
                e1(strArr2, 2);
            }
        } else if (i10 == 3) {
            if (e.j(requireContext())) {
                a1();
            } else {
                e1(f36904i, 3);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sb.a.i(requireActivity(), "account");
        if (Z()) {
            this.f36905c.h0();
            this.f36905c.a0();
            sa.a g10 = AccountManager.h().g();
            if (g10 != null) {
                b1(g10);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f36906d = new m(requireActivity(), this);
        this.f36908f.f31114p.setPaddingRelative(0, kc.f.b(), 0, 0);
        this.f36908f.f31112n.setOnClickListener(c1(new Runnable() { // from class: ya.f
            @Override // java.lang.Runnable
            public final void run() {
                v.this.Y0();
            }
        }));
        this.f36908f.f31116r.setOnClickListener(c1(new Runnable() { // from class: ya.m
            @Override // java.lang.Runnable
            public final void run() {
                v.this.W0();
            }
        }));
        this.f36908f.f31121w.setOnClickListener(c1(new Runnable() { // from class: ya.k
            @Override // java.lang.Runnable
            public final void run() {
                v.this.X0();
            }
        }));
        this.f36908f.f31118t.setOnClickListener(c1(new Runnable() { // from class: ya.i
            @Override // java.lang.Runnable
            public final void run() {
                v.this.U0();
            }
        }));
        this.f36908f.f31117s.setOnClickListener(c1(new Runnable() { // from class: ya.h
            @Override // java.lang.Runnable
            public final void run() {
                v.this.Z0();
            }
        }));
        O0();
    }
}
