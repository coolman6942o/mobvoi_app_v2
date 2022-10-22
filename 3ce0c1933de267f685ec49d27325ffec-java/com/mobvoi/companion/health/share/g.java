package com.mobvoi.companion.health.share;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.exercise.ExerciseDetailView;
import com.mobvoi.health.companion.model.ShareExerciseBean;
import com.mobvoi.wear.util.UnitsUtility;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import sb.a;
/* compiled from: HealthShareActivityChartFragment.kt */
/* loaded from: classes2.dex */
public final class g extends Fragment implements a {

    /* renamed from: a  reason: collision with root package name */
    private CardView f16974a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f16975b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f16976c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f16977d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f16978e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f16979f;

    /* renamed from: g  reason: collision with root package name */
    private ExerciseDetailView f16980g;

    @Override // com.mobvoi.companion.health.share.a
    public Bitmap L() {
        CardView cardView = this.f16974a;
        if (cardView != null) {
            return b.a(cardView);
        }
        i.u("activityShareCardView");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        return inflater.inflate(R.layout.layout_share_activity_chart, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        a.h(requireContext(), "activityShare");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        a.i(requireContext(), "activityShare");
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ShareExerciseBean shareExerciseBean;
        float f10;
        int i10;
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.activityShareCardView);
        i.e(findViewById, "view.findViewById(R.id.activityShareCardView)");
        this.f16974a = (CardView) findViewById;
        View findViewById2 = view.findViewById(R.id.tvSteps);
        i.e(findViewById2, "view.findViewById(R.id.tvSteps)");
        this.f16975b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tvCalorieValue);
        i.e(findViewById3, "view.findViewById(R.id.tvCalorieValue)");
        this.f16976c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tvDistanceValue);
        i.e(findViewById4, "view.findViewById(R.id.tvDistanceValue)");
        this.f16977d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tvDistanceUnit);
        i.e(findViewById5, "view.findViewById(R.id.tvDistanceUnit)");
        this.f16978e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.tvTimeRange);
        i.e(findViewById6, "view.findViewById(R.id.tvTimeRange)");
        this.f16979f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.exerciseDetailView);
        i.e(findViewById7, "view.findViewById(R.id.exerciseDetailView)");
        this.f16980g = (ExerciseDetailView) findViewById7;
        Bundle arguments = getArguments();
        if (arguments != null && (shareExerciseBean = (ShareExerciseBean) arguments.getSerializable("share_info")) != null) {
            TextView textView = this.f16975b;
            if (textView != null) {
                textView.setText(h.a(shareExerciseBean.step));
                TextView textView2 = this.f16976c;
                if (textView2 != null) {
                    textView2.setText(h.a(shareExerciseBean.calorie));
                    boolean b10 = i.b("imperial", com.mobvoi.companion.base.settings.a.getUnit(requireActivity()));
                    TextView textView3 = this.f16977d;
                    if (textView3 != null) {
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
                        textView3.setText(format);
                        TextView textView4 = this.f16978e;
                        if (textView4 != null) {
                            if (b10) {
                                i10 = R.string.health_detail_distance_miles_tip;
                            } else {
                                i10 = R.string.health_detail_distance_tip;
                            }
                            textView4.setText(getString(i10));
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd", Locale.getDefault());
                            if (shareExerciseBean.dateType == 1) {
                                TextView textView5 = this.f16979f;
                                if (textView5 != null) {
                                    textView5.setText(simpleDateFormat.format(Long.valueOf(shareExerciseBean.startMills)));
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
                                TextView textView6 = this.f16979f;
                                if (textView6 != null) {
                                    textView6.setText(sb3);
                                } else {
                                    i.u("tvTimeRange");
                                    throw null;
                                }
                            }
                            ExerciseDetailView exerciseDetailView = this.f16980g;
                            if (exerciseDetailView != null) {
                                exerciseDetailView.setDateType(shareExerciseBean.dateType);
                                ExerciseDetailView exerciseDetailView2 = this.f16980g;
                                if (exerciseDetailView2 != null) {
                                    exerciseDetailView2.d(shareExerciseBean.stepList, shareExerciseBean.stepGoal, shareExerciseBean.stepMax, shareExerciseBean.startMills);
                                } else {
                                    i.u("exerciseDetailView");
                                    throw null;
                                }
                            } else {
                                i.u("exerciseDetailView");
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
                    i.u("tvCalorieValue");
                    throw null;
                }
            } else {
                i.u("tvSteps");
                throw null;
            }
        }
    }
}
