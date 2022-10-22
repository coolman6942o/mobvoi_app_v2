package com.mobvoi.companion.health.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.x;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.share.HealthShareChartViewModel;
import com.mobvoi.companion.view.crop.c;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.health.companion.model.ShareExerciseBean;
import com.mobvoi.health.companion.sport.view.a;
import com.mobvoi.wear.util.UnitsUtility;
import dq.b;
import ef.u;
import hc.e;
import io.m;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
/* compiled from: HealthShareWaterMarkFragment.kt */
/* loaded from: classes2.dex */
public final class s extends Fragment implements com.mobvoi.companion.health.share.a {

    /* renamed from: a  reason: collision with root package name */
    private final b f17009a = new b();

    /* renamed from: b  reason: collision with root package name */
    private TextView f17010b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f17011c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f17012d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f17013e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f17014f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f17015g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f17016h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f17017i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f17018j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f17019k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f17020l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f17021m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f17022n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f17023o;

    /* renamed from: p  reason: collision with root package name */
    private ImageView f17024p;

    /* renamed from: q  reason: collision with root package name */
    private View f17025q;

    /* compiled from: HealthShareWaterMarkFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    private final Bitmap a0(Context context, Uri uri) {
        c.a aVar;
        try {
            aVar = c.l(context, uri, 350, 350);
        } catch (Exception unused) {
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        return aVar.f17783a;
    }

    private final String b0(long j10) {
        long j11 = 3600000;
        long j12 = j10 / j11;
        long j13 = 60000;
        long j14 = (j10 % j11) / j13;
        long j15 = (j10 % j13) / 1000;
        StringBuilder sb2 = new StringBuilder();
        int i10 = (j12 > 10L ? 1 : (j12 == 10L ? 0 : -1));
        Object valueOf = Long.valueOf(j12);
        if (i10 < 0) {
            valueOf = i.n("0", valueOf);
        }
        sb2.append(valueOf);
        sb2.append(':');
        int i11 = (j14 > 10L ? 1 : (j14 == 10L ? 0 : -1));
        Object valueOf2 = Long.valueOf(j14);
        if (i11 < 0) {
            valueOf2 = i.n("0", valueOf2);
        }
        sb2.append(valueOf2);
        sb2.append(':');
        int i12 = (j15 > 10L ? 1 : (j15 == 10L ? 0 : -1));
        Object valueOf3 = Long.valueOf(j15);
        if (i12 < 0) {
            valueOf3 = i.n("0", valueOf3);
        }
        sb2.append(valueOf3);
        return sb2.toString();
    }

    private final String c0(long j10, long j11) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd HH:mm", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) simpleDateFormat.format(Long.valueOf(j10)));
        sb2.append('-');
        sb2.append((Object) simpleDateFormat2.format(Long.valueOf(j11)));
        return sb2.toString();
    }

    private final Bitmap d0(Intent intent) {
        androidx.fragment.app.f requireActivity = requireActivity();
        i.e(requireActivity, "requireActivity()");
        Uri data = intent.getData();
        Objects.requireNonNull(data, "null cannot be cast to non-null type android.net.Uri");
        return a0(requireActivity, data);
    }

    private final void e0() {
        ImageView imageView = this.f17024p;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.share.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    s.f0(s.this, view);
                }
            });
        } else {
            i.u("ivSharePic");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(s this$0, View view) {
        i.f(this$0, "this$0");
        androidx.fragment.app.f activity = this$0.getActivity();
        if (activity != null) {
            sb.a.d(activity, "clickShareChoosePic");
            if (e.j(activity)) {
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
                m mVar = m.f28349a;
                this$0.startActivityForResult(intent, 100);
                return;
            }
            androidx.core.app.a.s(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(s this$0, SportType sportType, p pVar) {
        int b10;
        i.f(this$0, "this$0");
        i.f(sportType, "$sportType");
        u i10 = pVar.i();
        boolean m10 = pVar.m();
        TextView textView = this$0.f17023o;
        if (textView != null) {
            textView.setText(this$0.c0(i10.f25989h, i10.f25990i));
            a.C0219a e10 = com.mobvoi.health.companion.sport.view.a.d().e(sportType);
            i.e(e10, "getInstance().getResources(sportType)");
            TextView textView2 = this$0.f17010b;
            if (textView2 != null) {
                textView2.setText(this$0.requireContext().getString(e10.f18994c));
                ImageView imageView = this$0.f17011c;
                if (imageView != null) {
                    imageView.setImageResource(e10.f18992a);
                    TextView textView3 = this$0.f17014f;
                    if (textView3 != null) {
                        textView3.setText(this$0.b0(i10.f25991j));
                        TextView textView4 = this$0.f17019k;
                        if (textView4 != null) {
                            b10 = so.c.b(i10.f25993l);
                            textView4.setText(h.a(b10));
                            if (sportType.isCountType()) {
                                TextView textView5 = this$0.f17020l;
                                if (textView5 != null) {
                                    textView5.setText(String.valueOf(i10.H));
                                    TextView textView6 = this$0.f17021m;
                                    if (textView6 != null) {
                                        textView6.setText(this$0.getString(fg.u.X4));
                                        TextView textView7 = this$0.f17022n;
                                        if (textView7 != null) {
                                            textView7.setText(this$0.getString(fg.u.Y4));
                                            TextView textView8 = this$0.f17022n;
                                            if (textView8 != null) {
                                                textView8.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.sport_detail_times_icon, 0, 0, 0);
                                            } else {
                                                i.u("tvDistanceDesc");
                                                throw null;
                                            }
                                        } else {
                                            i.u("tvDistanceDesc");
                                            throw null;
                                        }
                                    } else {
                                        i.u("tvDistanceUnit");
                                        throw null;
                                    }
                                } else {
                                    i.u("tvDistanceValue");
                                    throw null;
                                }
                            } else {
                                int i11 = sportType.typeCode;
                                if (i11 == SportType.Swimming.typeCode || i11 == SportType.AutoSwimming.typeCode || i11 == SportType.OpenWaterSwimming.typeCode) {
                                    TextView textView9 = this$0.f17020l;
                                    if (textView9 != null) {
                                        textView9.setText(lf.c.d(SportDataType.SwimDistance, i10.A * i10.B, m10));
                                        TextView textView10 = this$0.f17021m;
                                        if (textView10 != null) {
                                            textView10.setText(lf.c.a(this$0.getResources(), m10, SportDataType.SwimTypeDistance));
                                        } else {
                                            i.u("tvDistanceUnit");
                                            throw null;
                                        }
                                    } else {
                                        i.u("tvDistanceValue");
                                        throw null;
                                    }
                                } else {
                                    TextView textView11 = this$0.f17020l;
                                    if (textView11 != null) {
                                        SportDataType sportDataType = SportDataType.Distance;
                                        textView11.setText(lf.c.d(sportDataType, i10.f25992k, m10));
                                        TextView textView12 = this$0.f17021m;
                                        if (textView12 != null) {
                                            textView12.setText(lf.c.a(this$0.getResources(), m10, sportDataType));
                                        } else {
                                            i.u("tvDistanceUnit");
                                            throw null;
                                        }
                                    } else {
                                        i.u("tvDistanceValue");
                                        throw null;
                                    }
                                }
                            }
                        } else {
                            i.u("tvCalorieValue");
                            throw null;
                        }
                    } else {
                        i.u("tvCostTime");
                        throw null;
                    }
                } else {
                    i.u("ivSportType");
                    throw null;
                }
            } else {
                i.u("tvSportType");
                throw null;
            }
        } else {
            i.u("tvTimeRange");
            throw null;
        }
    }

    @Override // com.mobvoi.companion.health.share.a
    public Bitmap L() {
        View view = this.f17025q;
        if (view != null) {
            return b.a(view);
        }
        i.u("waterMarkShareView");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        Bitmap d02;
        super.onActivityResult(i10, i11, intent);
        if (intent != null && i10 == 100 && intent.getData() != null && (d02 = d0(intent)) != null) {
            ImageView imageView = this.f17024p;
            if (imageView != null) {
                imageView.setImageBitmap(d02);
            } else {
                i.u("ivSharePic");
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_health_share_water_mark, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f17009a.b();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sb.a.h(requireContext(), "waterShare");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sb.a.i(requireContext(), "waterShare");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        float f10;
        int i10;
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.tvSportType);
        i.e(findViewById, "view.findViewById(R.id.tvSportType)");
        this.f17010b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.ivSportType);
        i.e(findViewById2, "view.findViewById(R.id.ivSportType)");
        this.f17011c = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.logoLeft);
        i.e(findViewById3, "view.findViewById(R.id.logoLeft)");
        this.f17012d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.logoBelow);
        i.e(findViewById4, "view.findViewById(R.id.logoBelow)");
        this.f17013e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tvCostTime);
        i.e(findViewById5, "view.findViewById(R.id.tvCostTime)");
        this.f17014f = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tvCostTimeDesc);
        i.e(findViewById6, "view.findViewById(R.id.tvCostTimeDesc)");
        this.f17015g = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.tvSteps);
        i.e(findViewById7, "view.findViewById(R.id.tvSteps)");
        this.f17016h = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.tvStepsUnit);
        i.e(findViewById8, "view.findViewById(R.id.tvStepsUnit)");
        this.f17017i = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.tvStepsDesc);
        i.e(findViewById9, "view.findViewById(R.id.tvStepsDesc)");
        this.f17018j = (TextView) findViewById9;
        View findViewById10 = view.findViewById(R.id.tvCalorieValue);
        i.e(findViewById10, "view.findViewById(R.id.tvCalorieValue)");
        this.f17019k = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.tvDistanceValue);
        i.e(findViewById11, "view.findViewById(R.id.tvDistanceValue)");
        this.f17020l = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.tvDistanceUnit);
        i.e(findViewById12, "view.findViewById(R.id.tvDistanceUnit)");
        this.f17021m = (TextView) findViewById12;
        View findViewById13 = view.findViewById(R.id.tvDistanceDesc);
        i.e(findViewById13, "view.findViewById(R.id.tvDistanceDesc)");
        this.f17022n = (TextView) findViewById13;
        View findViewById14 = view.findViewById(R.id.tvTimeRange);
        i.e(findViewById14, "view.findViewById(R.id.tvTimeRange)");
        this.f17023o = (TextView) findViewById14;
        View findViewById15 = view.findViewById(R.id.ivSharePic);
        i.e(findViewById15, "view.findViewById(R.id.ivSharePic)");
        this.f17024p = (ImageView) findViewById15;
        View findViewById16 = view.findViewById(R.id.waterMarkShareView);
        i.e(findViewById16, "view.findViewById(R.id.waterMarkShareView)");
        this.f17025q = findViewById16;
        e0();
        Bundle arguments = getArguments();
        if (arguments != null) {
            ShareExerciseBean shareExerciseBean = (ShareExerciseBean) arguments.getSerializable("share_info");
            if (shareExerciseBean != null) {
                TextView textView = this.f17010b;
                if (textView != null) {
                    textView.setVisibility(4);
                    ImageView imageView = this.f17011c;
                    if (imageView != null) {
                        imageView.setVisibility(4);
                        TextView textView2 = this.f17012d;
                        if (textView2 != null) {
                            textView2.setVisibility(0);
                            TextView textView3 = this.f17013e;
                            if (textView3 != null) {
                                textView3.setVisibility(4);
                                TextView textView4 = this.f17014f;
                                if (textView4 != null) {
                                    textView4.setVisibility(4);
                                    TextView textView5 = this.f17015g;
                                    if (textView5 != null) {
                                        textView5.setVisibility(4);
                                        TextView textView6 = this.f17016h;
                                        if (textView6 != null) {
                                            textView6.setVisibility(0);
                                            TextView textView7 = this.f17017i;
                                            if (textView7 != null) {
                                                textView7.setVisibility(0);
                                                TextView textView8 = this.f17018j;
                                                if (textView8 != null) {
                                                    textView8.setVisibility(0);
                                                    TextView textView9 = this.f17016h;
                                                    if (textView9 != null) {
                                                        textView9.setText(h.a(shareExerciseBean.step));
                                                        TextView textView10 = this.f17019k;
                                                        if (textView10 != null) {
                                                            textView10.setText(h.a(shareExerciseBean.calorie));
                                                            boolean b10 = i.b("imperial", com.mobvoi.companion.base.settings.a.getUnit(com.mobvoi.android.common.utils.b.e()));
                                                            TextView textView11 = this.f17020l;
                                                            if (textView11 != null) {
                                                                n nVar = n.f30086a;
                                                                String string = getString(R.string.distance_formatter_value);
                                                                i.e(string, "getString(R.string.distance_formatter_value)");
                                                                Object[] objArr = new Object[1];
                                                                if (b10) {
                                                                    f10 = UnitsUtility.Length.m2mile(shareExerciseBean.distance);
                                                                } else {
                                                                    f10 = UnitsUtility.Length.m2km(shareExerciseBean.distance);
                                                                }
                                                                objArr[0] = Float.valueOf(f10);
                                                                String format = String.format(string, Arrays.copyOf(objArr, 1));
                                                                i.e(format, "java.lang.String.format(format, *args)");
                                                                textView11.setText(format);
                                                                TextView textView12 = this.f17021m;
                                                                if (textView12 != null) {
                                                                    if (b10) {
                                                                        i10 = R.string.health_detail_distance_miles_tip;
                                                                    } else {
                                                                        i10 = R.string.health_detail_distance_tip;
                                                                    }
                                                                    textView12.setText(getString(i10));
                                                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd", Locale.getDefault());
                                                                    if (shareExerciseBean.dateType == 1) {
                                                                        TextView textView13 = this.f17023o;
                                                                        if (textView13 != null) {
                                                                            textView13.setText(simpleDateFormat.format(Long.valueOf(shareExerciseBean.startMills)));
                                                                        } else {
                                                                            i.u("tvTimeRange");
                                                                            throw null;
                                                                        }
                                                                    } else {
                                                                        StringBuilder sb2 = new StringBuilder();
                                                                        sb2.append((Object) simpleDateFormat.format(Long.valueOf(shareExerciseBean.startMills)));
                                                                        sb2.append('-');
                                                                        sb2.append((Object) simpleDateFormat.format(Long.valueOf(shareExerciseBean.endMills)));
                                                                        String sb3 = sb2.toString();
                                                                        TextView textView14 = this.f17023o;
                                                                        if (textView14 != null) {
                                                                            textView14.setText(sb3);
                                                                        } else {
                                                                            i.u("tvTimeRange");
                                                                            throw null;
                                                                        }
                                                                    }
                                                                } else {
                                                                    i.u("tvDistanceUnit");
                                                                    throw null;
                                                                }
                                                            } else {
                                                                i.u("tvDistanceValue");
                                                                throw null;
                                                            }
                                                        } else {
                                                            i.u("tvCalorieValue");
                                                            throw null;
                                                        }
                                                    } else {
                                                        i.u("tvSteps");
                                                        throw null;
                                                    }
                                                } else {
                                                    i.u("tvStepsDesc");
                                                    throw null;
                                                }
                                            } else {
                                                i.u("tvStepsUnit");
                                                throw null;
                                            }
                                        } else {
                                            i.u("tvSteps");
                                            throw null;
                                        }
                                    } else {
                                        i.u("tvCostTimeDesc");
                                        throw null;
                                    }
                                } else {
                                    i.u("tvCostTime");
                                    throw null;
                                }
                            } else {
                                i.u("logoBelow");
                                throw null;
                            }
                        } else {
                            i.u("logoLeft");
                            throw null;
                        }
                    } else {
                        i.u("ivSportType");
                        throw null;
                    }
                } else {
                    i.u("tvSportType");
                    throw null;
                }
            } else {
                String string2 = arguments.getString("sportId");
                if (string2 == null) {
                    string2 = "";
                }
                Serializable serializable = arguments.getSerializable("type");
                Objects.requireNonNull(serializable, "null cannot be cast to non-null type com.mobvoi.health.common.data.pojo.SportType");
                final SportType sportType = (SportType) serializable;
                HealthShareChartViewModel.a aVar = HealthShareChartViewModel.Companion;
                androidx.fragment.app.f requireActivity = requireActivity();
                i.e(requireActivity, "requireActivity()");
                HealthShareChartViewModel a10 = aVar.a(requireActivity, string2, sportType.name());
                a10.getHealthShareData().i(getViewLifecycleOwner(), new x() { // from class: com.mobvoi.companion.health.share.r
                    @Override // androidx.lifecycle.x
                    public final void a(Object obj) {
                        s.g0(s.this, sportType, (p) obj);
                    }
                });
                a10.querySportData();
            }
        }
    }
}
