package tj;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mobvoi.companion.proto.SoundProto;
import com.mobvoi.record.RecordViewModel;
/* compiled from: SummaryFragment.java */
/* loaded from: classes2.dex */
public class g extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private rj.g f35204a;

    /* renamed from: b  reason: collision with root package name */
    private RecordViewModel f35205b;

    /* renamed from: c  reason: collision with root package name */
    private qj.a f35206c;

    /* renamed from: d  reason: collision with root package name */
    private SoundProto.SoundFile f35207d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SummaryFragment.java */
    /* loaded from: classes2.dex */
    public class a implements x<SoundProto.SoundConvertResultResp> {
        a() {
        }

        /* renamed from: b */
        public void a(SoundProto.SoundConvertResultResp soundConvertResultResp) {
            Log.d("SummaryFragment", "onChanged: " + soundConvertResultResp.toString());
            g gVar = g.this;
            gVar.f35206c = new qj.a(gVar.requireActivity(), soundConvertResultResp.getDataList(), g.this.f35207d.getFlagsList(), false);
            g.this.f35204a.f33588b.setAdapter(g.this.f35206c);
        }
    }

    private void c0() {
        this.f35205b.F().i(requireActivity(), new a());
    }

    private void d0() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireActivity());
        linearLayoutManager.B2(1);
        this.f35204a.f33588b.setLayoutManager(linearLayoutManager);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f35204a = rj.g.d(layoutInflater, viewGroup, false);
        this.f35205b = (RecordViewModel) new h0(requireActivity()).a(RecordViewModel.class);
        if (getArguments() != null) {
            this.f35207d = (SoundProto.SoundFile) getArguments().getSerializable("soundFile");
        }
        d0();
        c0();
        return this.f35204a.a();
    }
}
