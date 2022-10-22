package com.cardiex.arty.lite.networking;

import android.content.Context;
import com.cardiex.arty.lite.models.Pageable;
import com.cardiex.arty.lite.models.coach.Advice;
import com.cardiex.arty.lite.models.coach.ArtyLatest;
import com.cardiex.arty.lite.models.coach.ArtyTrend;
import com.cardiex.arty.lite.models.coach.ArtyType;
import com.cardiex.arty.lite.models.coach.Insight;
import com.cardiex.arty.lite.models.coach.SeenStatus;
import com.cardiex.arty.lite.models.dashboard.Dashboard;
import com.cardiex.arty.lite.models.event.Answer;
import com.cardiex.arty.lite.models.event.Event;
import com.cardiex.arty.lite.models.profile.Profile;
import com.cardiex.arty.lite.models.push.AddPushRegistration;
import com.cardiex.arty.lite.models.push.PushRegistration;
import com.cardiex.arty.lite.models.social.Badge;
import com.cardiex.arty.lite.models.social.Friend;
import com.cardiex.arty.lite.models.social.Message;
import java.util.Date;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.j;
import kotlinx.coroutines.t0;
/* compiled from: ApiRepository.kt */
/* loaded from: classes.dex */
public final class ApiRepository extends BaseApiRepository {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApiRepository(Context context, String accessToken, boolean z10) {
        super(context, accessToken, z10);
        i.f(context, "context");
        i.f(accessToken, "accessToken");
    }

    public final void addFriend(String userId, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$addFriend$1(this, new Message(userId, null, 2, null), callback, null), 2, null);
    }

    public final void addProfile(Profile profile, ApiResultCallback<Object> callback) {
        i.f(profile, "profile");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$addProfile$1(this, profile, callback, null), 2, null);
    }

    public final void addPushRegistrations(AddPushRegistration registration, ApiResultCallback<? super PushRegistration> callback) {
        i.f(registration, "registration");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$addPushRegistrations$1(this, registration, callback, null), 2, null);
    }

    public final void answerQuestion(String questionId, String value, ApiResultCallback<Object> callback) {
        i.f(questionId, "questionId");
        i.f(value, "value");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$answerQuestion$1(this, new Event("Answer", new Answer(questionId, value)), callback, null), 2, null);
    }

    public final void getAdvice(Pageable pageable, ApiResultCallback<? super Advice[]> callback) {
        i.f(pageable, "pageable");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$getAdvice$1(this, pageable, callback, null), 2, null);
    }

    public final void getArtyLatest(ArtyType type, ApiResultCallback<? super ArtyLatest> callback) {
        i.f(type, "type");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$getArtyLatest$1(this, type, callback, null), 2, null);
    }

    public final void getArtyTrends(ArtyType type, ApiResultCallback<? super ArtyTrend> callback) {
        i.f(type, "type");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$getArtyTrends$1(this, type, callback, null), 2, null);
    }

    public final void getBadges(ApiResultCallback<? super Badge[]> callback) {
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$getBadges$1(this, callback, null), 2, null);
    }

    public final void getDashboard(ApiResultCallback<? super Dashboard> callback) {
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$getDashboard$1(this, callback, null), 2, null);
    }

    public final void getFriends(Pageable pageable, ApiResultCallback<? super Friend[]> callback) {
        i.f(pageable, "pageable");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$getFriends$1(this, pageable, callback, null), 2, null);
    }

    public final void getInsight(Pageable pageable, Date date, ApiResultCallback<? super Insight[]> callback) {
        i.f(pageable, "pageable");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$getInsight$1(this, pageable, date, callback, null), 2, null);
    }

    public final void markAdviceSeen(String adviceId, boolean z10, ApiResultCallback<Object> callback) {
        i.f(adviceId, "adviceId");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$markAdviceSeen$1(this, adviceId, new SeenStatus(null, z10, 1, null), callback, null), 2, null);
    }

    public final void markArticleSeen(String articleId, boolean z10, ApiResultCallback<Object> callback) {
        i.f(articleId, "articleId");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$markArticleSeen$1(this, articleId, new SeenStatus(null, z10, 1, null), callback, null), 2, null);
    }

    public final void markBadgeSeen(String badgeId, boolean z10, ApiResultCallback<Object> callback) {
        i.f(badgeId, "badgeId");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$markBadgeSeen$1(this, badgeId, new SeenStatus(null, z10, 1, null), callback, null), 2, null);
    }

    public final void markFriendSeen(String friendId, boolean z10, ApiResultCallback<Object> callback) {
        i.f(friendId, "friendId");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$markFriendSeen$1(this, friendId, new SeenStatus(null, z10, 1, null), callback, null), 2, null);
    }

    public final void removeFriend(String userId, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$removeFriend$1(this, new Message(userId, null, 2, null), callback, null), 2, null);
    }

    public final void sendApplause(String userId, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$sendApplause$1(this, new Message(userId, null, 2, null), callback, null), 2, null);
    }

    public final void sendHearts(String userId, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$sendHearts$1(this, new Message(userId, null, 2, null), callback, null), 2, null);
    }

    public final void sendMessage(String userId, String message, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(message, "message");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$sendMessage$1(this, new Message(userId, message), callback, null), 2, null);
    }

    public final void sendThumbsUp(String userId, ApiResultCallback<Object> callback) {
        i.f(userId, "userId");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$sendThumbsUp$1(this, new Message(userId, null, 2, null), callback, null), 2, null);
    }

    public final void markAdviceSeen(SeenStatus[] status, ApiResultCallback<? super Advice[]> callback) {
        i.f(status, "status");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$markAdviceSeen$2(this, status, callback, null), 2, null);
    }

    public final void markAdviceSeen(Date dateToConsider, ApiResultCallback<? super Advice[]> callback) {
        i.f(dateToConsider, "dateToConsider");
        i.f(callback, "callback");
        j.b(this, t0.b(), null, new ApiRepository$markAdviceSeen$3(this, dateToConsider, callback, null), 2, null);
    }
}
