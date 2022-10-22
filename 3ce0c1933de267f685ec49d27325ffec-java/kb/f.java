package kb;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;
import com.bumptech.glide.h;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.m3.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.i;
import pa.d;
import pa.e;
import wa.c;
/* compiled from: AccountProfileFragment.kt */
/* loaded from: classes2.dex */
public class f extends b implements h, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: b  reason: collision with root package name */
    private Uri f29843b;

    /* renamed from: c  reason: collision with root package name */
    private sa.a f29844c;

    /* renamed from: d  reason: collision with root package name */
    private g f29845d;

    /* renamed from: e  reason: collision with root package name */
    private c f29846e;

    /* compiled from: AccountProfileFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    private final Uri f0(int i10, Intent intent, int i11, int i12) {
        String str;
        Uri uri = null;
        try {
            str = MediaStore.Images.Media.insertImage(requireActivity().getContentResolver(), MediaStore.Images.Media.getBitmap(requireActivity().getContentResolver(), intent.getData()), "", "");
        } catch (IOException e10) {
            e10.printStackTrace();
            str = null;
        }
        if (str != null) {
            uri = Uri.parse(str);
            File h10 = lb.c.h(requireActivity());
            if (h10 != null) {
                Intent intent2 = new Intent("com.android.camera.action.CROP");
                intent2.setDataAndType(uri, "image/*");
                intent2.putExtra("crop", "true");
                intent2.putExtra("aspectX", i11);
                intent2.putExtra("aspectY", i12);
                intent2.putExtra("outputX", i11);
                intent2.putExtra("outputY", i12);
                intent2.putExtra("noFaceDetection", true);
                intent2.putExtra("return-data", false);
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                intent2.putExtra("output", Uri.fromFile(h10));
                startActivityForResult(intent2, i10);
            }
        }
        return uri;
    }

    private final void g0(Bitmap bitmap) {
        g gVar = this.f29845d;
        if (gVar != null) {
            gVar.i(bitmap);
        } else {
            i.u("mProfilePresenter");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(f this$0, View view) {
        i.f(this$0, "this$0");
        this$0.s0("edit_password");
        androidx.navigation.fragment.a.a(this$0).o(e.f32647l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(f this$0, View view) {
        i.f(this$0, "this$0");
        this$0.s0("add_email");
        androidx.navigation.fragment.a.a(this$0).o(e.f32649m);
    }

    private final boolean l0() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(f this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        g gVar = this$0.f29845d;
        if (gVar != null) {
            gVar.e();
            String string = this$0.getString(pa.i.G);
            i.e(string, "getString(R.string.logout_ing)");
            this$0.Z(string);
            return;
        }
        i.u("mProfilePresenter");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(DialogInterface dialogInterface, int i10) {
    }

    private final void o0() {
    }

    private final void p0() {
        new k7.b(requireActivity()).B(new String[]{getString(pa.i.f32710t), getString(pa.i.f32712v)}, new DialogInterface.OnClickListener() { // from class: kb.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                f.q0(f.this, dialogInterface, i10);
            }
        }).a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(f this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        if (i10 == 0) {
            this$0.r0();
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
        this$0.startActivityForResult(intent, 100);
    }

    private final void r0() {
        startActivityForResult(new Intent("android.media.action.IMAGE_CAPTURE"), 101);
    }

    private final void t0() {
        ImageView imageView = h0().f36194l;
        int i10 = d.f32624a;
        imageView.setImageResource(i10);
        sa.a aVar = this.f29844c;
        if (!TextUtils.isEmpty(aVar == null ? null : aVar.headUrl)) {
            h v10 = com.bumptech.glide.c.v(this);
            sa.a aVar2 = this.f29844c;
            i.d(aVar2);
            v10.r(aVar2.headUrl).U(i10).f0(new aa.a()).u0(h0().f36194l);
        }
    }

    @Override // kb.h
    public void A(String msg) {
        i.f(msg, "msg");
        Toast.makeText(getActivity(), msg, 0).show();
        Y();
    }

    @Override // kb.h
    public void D(Bitmap bitmap, String msg) {
        i.f(bitmap, "bitmap");
        i.f(msg, "msg");
        Toast.makeText(getActivity(), msg, 0).show();
        this.f29844c = ta.a.e();
        t0();
    }

    @Override // kb.h
    public void M() {
    }

    @Override // kb.h
    public void Q(sa.a accountInfo) {
        i.f(accountInfo, "accountInfo");
    }

    @Override // kb.h
    public void S(String msg) {
        i.f(msg, "msg");
        Toast.makeText(getActivity(), msg, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final c h0() {
        c cVar = this.f29846e;
        i.d(cVar);
        return cVar;
    }

    public void i(String msg) {
        i.f(msg, "msg");
        Toast.makeText(getActivity(), msg, 0).show();
        Y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i0(View view) {
        i.f(view, "view");
        this.f29844c = ta.a.e();
        h0().f36189g.setOnClickListener(this);
        h0().f36194l.setOnClickListener(this);
        t0();
        h0().f36195m.setText(lb.c.i());
        h0().f36184b.setOnClickListener(new View.OnClickListener() { // from class: kb.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.j0(f.this, view2);
            }
        });
        h0().f36188f.setOnClickListener(new View.OnClickListener() { // from class: kb.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.k0(f.this, view2);
            }
        });
    }

    @Override // kb.h
    public void m(String msg) {
        i.f(msg, "msg");
        Toast.makeText(getActivity(), msg, 0).show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (intent != null) {
            k.a("ProfileFragment", "onReceived Activity result = " + i10 + "resultCode =" + i11);
            switch (i10) {
                case 100:
                    if (i11 == -1 && intent.getData() != null) {
                        this.f29843b = f0(102, intent, 300, 300);
                        return;
                    }
                    return;
                case 101:
                    if (i11 == -1 && intent.getExtras() != null) {
                        Bundle extras = intent.getExtras();
                        i.d(extras);
                        g0((Bitmap) extras.get("data"));
                        return;
                    }
                    return;
                case 102:
                    if (i11 == -1) {
                        Bitmap bitmap = null;
                        try {
                            bitmap = BitmapFactory.decodeStream(requireActivity().getContentResolver().openInputStream(Uri.fromFile(lb.c.h(getActivity()))));
                        } catch (FileNotFoundException e10) {
                            e10.printStackTrace();
                        }
                        if (bitmap == null && this.f29843b != null) {
                            try {
                                ContentResolver contentResolver = requireActivity().getContentResolver();
                                Uri uri = this.f29843b;
                                i.d(uri);
                                bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(uri));
                            } catch (FileNotFoundException e11) {
                                e11.printStackTrace();
                            }
                        }
                        if (bitmap != null) {
                            g0(bitmap);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void onClick(View v10) {
        i.f(v10, "v");
        int id2 = v10.getId();
        if (id2 == e.f32666u0) {
            s0("photo");
            if (l0()) {
                p0();
            } else {
                o0();
            }
        } else if (id2 == e.Q) {
            s0("exit2");
            new k7.b(requireActivity()).q(pa.i.E).h(pa.i.F).d(true).m(pa.i.f32713w, new DialogInterface.OnClickListener() { // from class: kb.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    f.m0(f.this, dialogInterface, i10);
                }
            }).j(pa.i.f32711u, c.f29840a).t();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        this.f29846e = c.d(inflater, viewGroup, false);
        ScrollView c10 = h0().a();
        i.e(c10, "binding.root");
        return c10;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        ta.a.C(this);
        super.onDestroyView();
        g gVar = this.f29845d;
        if (gVar != null) {
            gVar.unsubscribe();
        } else {
            i.u("mProfilePresenter");
            throw null;
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        i.f(sharedPreferences, "sharedPreferences");
        i.f(key, "key");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (TextUtils.isEmpty(ta.a.d())) {
            requireActivity().finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        i.e(LayoutInflater.from(requireActivity()), "from(requireActivity())");
        this.f29845d = new m(getActivity(), this);
        ta.a.a(this);
        i0(view);
        g gVar = this.f29845d;
        if (gVar != null) {
            gVar.p(ta.a.s(), com.mobvoi.android.common.utils.e.e(getActivity()));
        } else {
            i.u("mProfilePresenter");
            throw null;
        }
    }

    public final void s0(String key) {
        i.f(key, "key");
    }
}
