package com.mobvoi.companion.lpa;

import aa.c;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.google.zxing.h;
import com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate;
import com.mobvoi.android.common.utils.j;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.R;
import com.mobvoi.companion.base.perms.PermissionActivity;
import com.mobvoi.qr.QRCodeReaderView;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyException;
import com.mobvoi.wear.permission.PermissionRequestActivity;
import hc.e;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import kotlin.reflect.KProperty;
import kotlin.text.d;
import kotlin.text.t;
import oc.n;
/* compiled from: ScanQrcodeFragment.kt */
/* loaded from: classes2.dex */
public final class g0 extends Fragment implements QRCodeReaderView.b {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17194c = {l.h(new PropertyReference1Impl(l.b(g0.class), "viewBinding", "getViewBinding()Lcom/mobvoi/companion/databinding/FragmentQrScanBinding;"))};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f17195d = {"android.permission.READ_EXTERNAL_STORAGE"};

    /* renamed from: a  reason: collision with root package name */
    private x f17196a;

    /* renamed from: b  reason: collision with root package name */
    private final FragmentViewBindingDelegate f17197b = com.mobvoi.android.common.ui.viewbinding.a.b(this, b.INSTANCE);

    /* compiled from: ScanQrcodeFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: ScanQrcodeFragment.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements qo.l<View, n> {
        public static final b INSTANCE = new b();

        b() {
            super(1, n.class, "bind", "bind(Landroid/view/View;)Lcom/mobvoi/companion/databinding/FragmentQrScanBinding;", 0);
        }

        /* renamed from: g */
        public final n invoke(View p02) {
            i.f(p02, "p0");
            return n.b(p02);
        }
    }

    static {
        new a(null);
    }

    public g0() {
        super(R.layout.fragment_qr_scan);
    }

    private final n g0() {
        return (n) this.f17197b.b(this, f17194c[0]);
    }

    private final void h0() {
        getParentFragmentManager().W0();
    }

    private final void i0() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.addFlags(3);
        startActivityForResult(intent, 1);
    }

    private final boolean j0(String str) {
        boolean o10;
        if (com.mobvoi.companion.base.settings.a.isOversea()) {
            x xVar = this.f17196a;
            if (xVar != null) {
                i.d(xVar);
                if (xVar.a() == 0) {
                    return false;
                }
            }
            return true;
        }
        o10 = t.o(str, "$1", false, 2, null);
        return o10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k0(final g0 this$0, final AlertDialog alertDialog, final EditText editText, final String result, DialogInterface dialogInterface) {
        i.f(this$0, "this$0");
        i.f(editText, "$editText");
        i.f(result, "$result");
        if (this$0.isAdded()) {
            Objects.requireNonNull(alertDialog, "null cannot be cast to non-null type android.app.AlertDialog");
            alertDialog.getButton(-1).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.f0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g0.l0(g0.this, editText, alertDialog, result, view);
                }
            });
            alertDialog.getButton(-2).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.d0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    g0.n0(alertDialog, this$0, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(final g0 this$0, EditText editText, AlertDialog alertDialog, String result, View view) {
        i.f(this$0, "this$0");
        i.f(editText, "$editText");
        i.f(result, "$result");
        x xVar = this$0.f17196a;
        if (xVar != null) {
            i.d(xVar);
            if (xVar.a() == 1) {
                x xVar2 = this$0.f17196a;
                i.d(xVar2);
                if (xVar2.a() != 1 || TextUtils.isEmpty(editText.getText())) {
                    return;
                }
            }
        }
        alertDialog.dismiss();
        MessageProxyClient messageProxyClient = MessageProxyClient.getInstance();
        String str = result + "###" + ((Object) editText.getText());
        Charset charset = d.f30092a;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        messageProxyClient.sendMessage(WearPath.Lpa.START_DOWNLOAD_PATH, bytes);
        new k7.b(this$0.requireActivity()).q(R.string.profile_in_download).h(R.string.profile_in_download_message).d(true).m(R.string.common_ok, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.lpa.z
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                g0.m0(g0.this, dialogInterface, i10);
            }
        }).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(g0 this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        this$0.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(AlertDialog alertDialog, g0 this$0, View view) {
        i.f(this$0, "this$0");
        alertDialog.dismiss();
        this$0.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(String result, g0 this$0, DialogInterface dialogInterface, int i10) {
        i.f(result, "$result");
        i.f(this$0, "this$0");
        MessageProxyClient messageProxyClient = MessageProxyClient.getInstance();
        byte[] bytes = result.getBytes(d.f30092a);
        i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        messageProxyClient.sendMessage(WearPath.Lpa.START_DOWNLOAD_PATH, bytes);
        this$0.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(g0 this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        this$0.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(g0 this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        this$0.h0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(g0 this$0, View view) {
        i.f(this$0, "this$0");
        androidx.fragment.app.f activity = this$0.getActivity();
        if (activity != null) {
            String[] strArr = f17195d;
            if (!e.i(activity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
                String string = this$0.getString(R.string.camera_permission_rational_text);
                i.e(string, "getString(R.string.camera_permission_rational_text)");
                Intent intent = new Intent(this$0.getActivity(), PermissionActivity.class);
                intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_PERMISSIONS, strArr);
                intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_RATIONALE_MSG, string);
                intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_GO_SETTINGS_MSG, string);
                intent.addFlags(4194304);
                this$0.startActivityForResult(intent, 0);
                return;
            }
            this$0.i0();
        }
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void E(final String result, byte[] bArr, Camera.Parameters parameters) {
        String str;
        i.f(result, "result");
        k.a("ScanQrcodeFragment", i.n("result == ", result));
        g0().f31552c.setCanScan(false);
        if (getActivity() != null) {
            try {
                boolean z10 = true;
                if (!MessageProxyClient.getInstance().hasConnectedNodes()) {
                    new k7.b(requireActivity()).q(R.string.bluetooth_disconnected_title).h(R.string.bluetooth_disconnected_message).d(true).j(R.string.common_cancel, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.lpa.a0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i10) {
                            g0.p0(g0.this, dialogInterface, i10);
                        }
                    }).m(R.string.common_ok, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.lpa.y
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i10) {
                            g0.q0(g0.this, dialogInterface, i10);
                        }
                    }).t();
                } else if (j0(result)) {
                    View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_confirmation_code, (ViewGroup) null);
                    View findViewById = inflate.findViewById(R.id.confirm_edit_text);
                    if (findViewById != null) {
                        final EditText editText = (EditText) findViewById;
                        AlertDialog.Builder title = new AlertDialog.Builder(getActivity()).setTitle(getString(R.string.lpa_input_confirmation_code));
                        x xVar = this.f17196a;
                        if (xVar == null || xVar.a() != 1) {
                            z10 = false;
                        }
                        if (z10) {
                            str = "";
                        } else {
                            str = getString(R.string.lpa_leave_blank);
                            i.e(str, "getString(\n                                R.string.lpa_leave_blank\n                            )");
                        }
                        final AlertDialog create = title.setMessage(str).setView(inflate).setCancelable(false).setPositiveButton(getString(R.string.common_ok), (DialogInterface.OnClickListener) null).setNegativeButton(getString(R.string.common_cancel), (DialogInterface.OnClickListener) null).create();
                        create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.mobvoi.companion.lpa.c0
                            @Override // android.content.DialogInterface.OnShowListener
                            public final void onShow(DialogInterface dialogInterface) {
                                g0.k0(g0.this, create, editText, result, dialogInterface);
                            }
                        });
                        editText.requestFocus();
                        create.show();
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
                } else {
                    new k7.b(requireActivity()).q(R.string.profile_in_download).h(R.string.profile_in_download_message).d(true).m(R.string.common_ok, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.lpa.b0
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i10) {
                            g0.o0(result, this, dialogInterface, i10);
                        }
                    }).t();
                }
            } catch (MessageProxyException e10) {
                k.e("ScanQrcodeFragment", "MessageProxyException, ", e10);
            }
        }
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void P() {
        k.a("ScanQrcodeFragment", "QRCode not found on camera");
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void R() {
        k.a("ScanQrcodeFragment", "camera not found");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x00d4 -> B:25:0x00e3). Please submit an issue!!! */
    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 1 && i11 == -1) {
            if (!(intent == null || getActivity() == null)) {
                Uri data = intent.getData();
                androidx.fragment.app.f activity = getActivity();
                i.d(activity);
                ContentResolver contentResolver = activity.getContentResolver();
                i.d(data);
                Cursor query = contentResolver.query(data, null, null, null, null);
                try {
                    if (query != null) {
                        try {
                            query.moveToFirst();
                            long j10 = query.getLong(query.getColumnIndexOrThrow("_id"));
                            query.close();
                            Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j10);
                            i.e(withAppendedId, "withAppendedId(\n                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,\n                            id\n                        )");
                            k.c("ScanQrcodeFragment", "The Uri chosen is %s.", withAppendedId.toString());
                            ParcelFileDescriptor openFileDescriptor = contentResolver.openFileDescriptor(withAppendedId, "r");
                            i.d(openFileDescriptor);
                            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor());
                            int[] iArr = new int[decodeFileDescriptor.getWidth() * decodeFileDescriptor.getHeight()];
                            decodeFileDescriptor.getPixels(iArr, 0, decodeFileDescriptor.getWidth(), 0, 0, decodeFileDescriptor.getWidth(), decodeFileDescriptor.getHeight());
                            h b10 = new d9.a().b(new com.google.zxing.b(new com.google.zxing.common.f(new com.google.zxing.f(decodeFileDescriptor.getWidth(), decodeFileDescriptor.getHeight(), iArr))));
                            k.a("ScanQrcodeFragment", i.n("result == ", b10.f()));
                            if (TextUtils.isEmpty(b10.f())) {
                                c.c(R.string.parse_qr_fail);
                            } else {
                                String f10 = b10.f();
                                i.e(f10, "qrResult.text");
                                E(f10, null, null);
                            }
                        } catch (Exception e10) {
                            c.c(R.string.parse_qr_fail);
                            k.e("ScanQrcodeFragment", "parse qr from image error, ", e10);
                        }
                    }
                } finally {
                    j.a(query);
                }
            }
        } else if (i10 == 0 && i11 == -1) {
            i0();
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        if (arguments != null) {
            x xVar = (x) kc.c.b(arguments.getString("esim_select_region_extra"), x.class);
            this.f17196a = xVar;
            k.a("ScanQrcodeFragment", i.n("", xVar));
        }
        g0().f31552c.setCanScan(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        g0().f31552c.setOnQRCodeReadListener(this);
        g0().f31551b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                g0.r0(g0.this, view2);
            }
        });
    }
}
