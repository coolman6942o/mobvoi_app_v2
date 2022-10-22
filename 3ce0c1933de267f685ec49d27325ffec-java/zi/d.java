package zi;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import com.google.zxing.h;
import com.mobvoi.android.common.utils.j;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.apollo.client.q;
import com.mobvoi.companion.R;
import com.mobvoi.companion.base.perms.PermissionActivity;
import com.mobvoi.companion.lpa.x;
import com.mobvoi.qr.QRCodeReaderView;
import com.mobvoi.wear.permission.PermissionRequestActivity;
import hc.e;
import jc.a;
import kc.c;
/* compiled from: ScanQrcodeFragment.java */
/* loaded from: classes2.dex */
public class d extends Fragment implements QRCodeReaderView.b {

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f37612c = {"android.permission.READ_EXTERNAL_STORAGE"};

    /* renamed from: a  reason: collision with root package name */
    private QRCodeReaderView f37613a;

    /* renamed from: b  reason: collision with root package name */
    private x f37614b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScanQrcodeFragment.java */
    /* loaded from: classes2.dex */
    public class a implements a.AbstractC0354a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ jc.a f37615a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f37616b;

        a(jc.a aVar, String str) {
            this.f37615a = aVar;
            this.f37616b = str;
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            this.f37615a.dismiss();
            q.f15504a.w(this.f37616b);
            d.this.a0();
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScanQrcodeFragment.java */
    /* loaded from: classes2.dex */
    public class b implements a.AbstractC0354a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ jc.a f37618a;

        b(jc.a aVar) {
            this.f37618a = aVar;
        }

        @Override // jc.a.AbstractC0354a
        public void a() {
            this.f37618a.dismiss();
            d.this.a0();
        }

        @Override // jc.a.AbstractC0354a
        public void onCancel() {
            this.f37618a.dismiss();
            d.this.a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        if (getFragmentManager() != null) {
            getFragmentManager().W0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(View view) {
        f activity = getActivity();
        String[] strArr = f37612c;
        if (!e.i(activity, strArr)) {
            String string = getString(R.string.camera_permission_rational_text);
            Intent intent = new Intent(getActivity(), PermissionActivity.class);
            intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_PERMISSIONS, strArr);
            intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_RATIONALE_MSG, string);
            intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_GO_SETTINGS_MSG, string);
            intent.addFlags(4194304);
            startActivityForResult(intent, 0);
            return;
        }
        c0();
    }

    private void c0() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.addFlags(3);
        startActivityForResult(intent, 1);
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void E(String str, byte[] bArr, Camera.Parameters parameters) {
        k.a("ScanQrcodeFragment", "result == " + str);
        this.f37613a.setCanScan(false);
        jc.a aVar = new jc.a(getActivity());
        if (ci.a.b().e()) {
            aVar.j(getString(R.string.profile_in_download), getString(R.string.profile_in_download_message));
            aVar.b(getString(R.string.common_ok));
            aVar.d(new a(aVar, str));
        } else {
            aVar.j(getString(R.string.bluetooth_disconnected_title), getString(R.string.bluetooth_disconnected_message));
            aVar.c(getString(R.string.common_cancel), getString(R.string.common_ok));
            aVar.d(new b(aVar));
        }
        aVar.show();
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void P() {
        k.a("ScanQrcodeFragment", "QRCode not found on camera");
    }

    @Override // com.mobvoi.qr.QRCodeReaderView.b
    public void R() {
        k.a("ScanQrcodeFragment", "camera not found");
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 1 && i11 == -1) {
            if (!(intent == null || getActivity() == null)) {
                Uri data = intent.getData();
                ContentResolver contentResolver = getActivity().getContentResolver();
                Cursor query = contentResolver.query(data, null, null, null, null);
                if (query != null) {
                    try {
                        try {
                            query.moveToFirst();
                            long j10 = query.getLong(query.getColumnIndexOrThrow("_id"));
                            query.close();
                            Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, j10);
                            k.c("ScanQrcodeFragment", "The Uri chosen is %s.", withAppendedId.toString());
                            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(contentResolver.openFileDescriptor(withAppendedId, "r").getFileDescriptor());
                            int[] iArr = new int[decodeFileDescriptor.getWidth() * decodeFileDescriptor.getHeight()];
                            decodeFileDescriptor.getPixels(iArr, 0, decodeFileDescriptor.getWidth(), 0, 0, decodeFileDescriptor.getWidth(), decodeFileDescriptor.getHeight());
                            h b10 = new d9.a().b(new com.google.zxing.b(new com.google.zxing.common.f(new com.google.zxing.f(decodeFileDescriptor.getWidth(), decodeFileDescriptor.getHeight(), iArr))));
                            k.a("ScanQrcodeFragment", "result == " + b10.f());
                            if (TextUtils.isEmpty(b10.f())) {
                                Toast.makeText(getActivity(), getString(R.string.parse_qr_fail), 0).show();
                            } else {
                                E(b10.f(), null, null);
                            }
                        } catch (Exception e10) {
                            Toast.makeText(getActivity(), getString(R.string.parse_qr_fail), 0).show();
                            k.e("ScanQrcodeFragment", "parse qr from image error, ", e10);
                        }
                    } finally {
                        j.a(query);
                    }
                }
            }
        } else if (i10 == 0 && i11 == -1) {
            c0();
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_qr_scan, (ViewGroup) null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f37614b = (x) c.b(arguments.getString("esim_select_region_extra"), x.class);
            k.a("ScanQrcodeFragment", "" + this.f37614b);
        }
        this.f37613a.setCanScan(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        QRCodeReaderView qRCodeReaderView = (QRCodeReaderView) view.findViewById(R.id.qrdecoderview);
        this.f37613a = qRCodeReaderView;
        qRCodeReaderView.setOnQRCodeReadListener(this);
        view.findViewById(R.id.local_qr).setOnClickListener(new View.OnClickListener() { // from class: zi.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d.this.b0(view2);
            }
        });
    }
}
