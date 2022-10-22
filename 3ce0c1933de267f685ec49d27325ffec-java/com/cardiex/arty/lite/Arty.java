package com.cardiex.arty.lite;

import android.content.Context;
import com.cardiex.arty.lite.models.Pageable;
import com.cardiex.arty.lite.models.coach.Advice;
import com.cardiex.arty.lite.models.coach.ArtyLatest;
import com.cardiex.arty.lite.models.coach.ArtyTrend;
import com.cardiex.arty.lite.models.coach.ArtyType;
import com.cardiex.arty.lite.models.coach.Insight;
import com.cardiex.arty.lite.models.coach.SeenStatus;
import com.cardiex.arty.lite.models.dashboard.Dashboard;
import com.cardiex.arty.lite.models.profile.Profile;
import com.cardiex.arty.lite.models.push.AddPushRegistration;
import com.cardiex.arty.lite.models.push.PushRegistration;
import com.cardiex.arty.lite.models.social.Badge;
import com.cardiex.arty.lite.models.social.Friend;
import com.cardiex.arty.lite.networking.ApiRepository;
import com.cardiex.arty.lite.networking.ApiResultCallback;
import java.util.Date;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Arty.kt */
/* loaded from: classes.dex */
public final class Arty {
    private final ApiRepository repository;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Arty(Context context, String accessToken) {
        this(context, accessToken, false, 4, null);
        i.f(context, "context");
        i.f(accessToken, "accessToken");
    }

    public Arty(ApiRepository repository) {
        i.f(repository, "repository");
        this.repository = repository;
    }

    public static /* synthetic */ void getInsight$default(Arty arty, Pageable pageable, Date date, ApiResultCallback apiResultCallback, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            date = null;
        }
        arty.getInsight(pageable, date, apiResultCallback);
    }

    public final void addFriend(String userId, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(callback, "callback");
        this.repository.addFriend(userId, callback);
    }

    public final void addProfile(Profile profile, ApiResultCallback<Object> callback) {
        i.f(profile, "profile");
        i.f(callback, "callback");
        this.repository.addProfile(profile, callback);
    }

    public final void addPushDevice(AddPushRegistration registration, ApiResultCallback<? super PushRegistration> callback) {
        i.f(registration, "registration");
        i.f(callback, "callback");
        this.repository.addPushRegistrations(registration, callback);
    }

    public final void answerQuestion(String questionId, String value, ApiResultCallback<Object> callback) {
        i.f(questionId, "questionId");
        i.f(value, "value");
        i.f(callback, "callback");
        this.repository.answerQuestion(questionId, value, callback);
    }

    public final void getAdvice(Pageable pageable, ApiResultCallback<? super Advice[]> callback) {
        i.f(pageable, "pageable");
        i.f(callback, "callback");
        this.repository.getAdvice(pageable, callback);
    }

    public final void getArtyLatest(ArtyType type, ApiResultCallback<? super ArtyLatest> callback) {
        i.f(type, "type");
        i.f(callback, "callback");
        this.repository.getArtyLatest(type, callback);
    }

    public final void getArtyTrends(ArtyType type, ApiResultCallback<? super ArtyTrend> callback) {
        i.f(type, "type");
        i.f(callback, "callback");
        this.repository.getArtyTrends(type, callback);
    }

    public final void getBadges(ApiResultCallback<? super Badge[]> callback) {
        i.f(callback, "callback");
        this.repository.getBadges(callback);
    }

    public final void getDashboard(ApiResultCallback<? super Dashboard> callback) {
        i.f(callback, "callback");
        this.repository.getDashboard(callback);
    }

    public final void getFriends(Pageable pageable, ApiResultCallback<? super Friend[]> callback) {
        i.f(pageable, "pageable");
        i.f(callback, "callback");
        this.repository.getFriends(pageable, callback);
    }

    public final void getInsight(Pageable pageable, ApiResultCallback<? super Insight[]> callback) {
        i.f(pageable, "pageable");
        i.f(callback, "callback");
        getInsight$default(this, pageable, null, callback, 2, null);
    }

    public final void getInsight(Pageable pageable, Date date, ApiResultCallback<? super Insight[]> callback) {
        i.f(pageable, "pageable");
        i.f(callback, "callback");
        this.repository.getInsight(pageable, date, callback);
    }

    public final void markAdviceSeen(String adviceId, boolean z10, ApiResultCallback<Object> callback) {
        i.f(adviceId, "adviceId");
        i.f(callback, "callback");
        this.repository.markAdviceSeen(adviceId, z10, callback);
    }

    public final void markArticleSeen(String articleId, boolean z10, ApiResultCallback<Object> callback) {
        i.f(articleId, "articleId");
        i.f(callback, "callback");
        this.repository.markArticleSeen(articleId, z10, callback);
    }

    public final void markBadgeSeen(String badgeId, boolean z10, ApiResultCallback<Object> callback) {
        i.f(badgeId, "badgeId");
        i.f(callback, "callback");
        this.repository.markBadgeSeen(badgeId, z10, callback);
    }

    public final void markFriendSeen(String friendId, boolean z10, ApiResultCallback<Object> callback) {
        i.f(friendId, "friendId");
        i.f(callback, "callback");
        this.repository.markFriendSeen(friendId, z10, callback);
    }

    public final void removeFriend(String userId, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(callback, "callback");
        this.repository.removeFriend(userId, callback);
    }

    public final void sendApplause(String userId, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(callback, "callback");
        this.repository.sendApplause(userId, callback);
    }

    public final void sendHearts(String userId, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(callback, "callback");
        this.repository.sendHearts(userId, callback);
    }

    public final void sendMessage(String userId, String message, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(message, "message");
        i.f(callback, "callback");
        this.repository.sendMessage(userId, message, callback);
    }

    public final void sendThumbsUp(String userId, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(callback, "callback");
        this.repository.sendThumbsUp(userId, callback);
    }

    public /* synthetic */ Arty(Context context, String str, boolean z10, int i10, f fVar) {
        this(context, str, (i10 & 4) != 0 ? false : z10);
    }

    public final void markAdviceSeen(SeenStatus[] status, ApiResultCallback<? super Advice[]> callback) {
        i.f(status, "status");
        i.f(callback, "callback");
        this.repository.markAdviceSeen(status, callback);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Arty(Context context, String accessToken, boolean z10) {
        this(new ApiRepository(context, AuthTokenValidator.Companion.get$lite_release().requireValid(accessToken), z10));
        i.f(context, "context");
        i.f(accessToken, "accessToken");
    }

    public final void markAdviceSeen(Date dateToConsider, ApiResultCallback<? super Advice[]> callback) {
        i.f(dateToConsider, "dateToConsider");
        i.f(callback, "callback");
        this.repository.markAdviceSeen(dateToConsider, callback);
    }
}
