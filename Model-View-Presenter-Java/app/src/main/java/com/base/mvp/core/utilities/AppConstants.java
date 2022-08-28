package com.base.mvp.core.utilities;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;
import androidx.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class AppConstants {

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DATABASE_NAME = "app.database";
    public static final String PREFERENCE_NAME = "app_preference";

    public static final long NULL_INDEX = -1L;

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final String RESPONSE_UNVERIFIED_USER = "unverified user";
    public static final String RESPONSE_UNVERIFIED_DOCTOR = "unverified user";
    public static final String RESPONSE_INACTIVE_DOCTOR = "inactive doctor";
    public static final String RESPONSE_INACTIVE_USER = "inactive user";
    public static final String STATE_INACTIVE = "INACTIVE";
    public static final String STATE_ACTIVE = "ACTIVE";
    public static final String STATE_VERIFIED = "VERIFIED";

    public static final int CALL_DIRECT = 1;         // benh nhan goi truc tiep cho bac si
    public static final int CALL_SCHEDULED = 2;      // bac si/dieu duong goi dinh ky cho benh nhan
    public static final int CALL_APPOINTED = 3;      // benh nhan dat lich gọi cho bac si
    public static final int CALL_FREE = 4;           // bac si/dieu duong goi mien phi cho benh nhan
    public static final int CALL_HOT_LINE = 5;       // benh nhan goi hotline
    public static final int CALL_GROUP = 6;          // benh nhan goi nhom bac si
    public static final int CALL_KIND_HOT_LINE = 14;
    public static final int CALL_KIND_GROUP = 15;
    public static final int CALL_KIND_DEFAULT = 16;
    public static final String AUDIO_CALL = "AUDIO";
    public static final String VIDEO_CALL = "VIDEO";
    public static final String TYPE_DOCTOR_LIKE = "DOCTOR";
    public static final String TYPE_GROUP_DOCTOR_LIKE = "GROUP";
    public static final String TYPE_HOT_LINE_DOCTOR_LIKE = "HOTLINE";
    public static final int STATUS_GETTING_CONVERSATION = 1;
    public static final int CONVERSATION_EXISTS = 2;
    public static final int CONVERSATION_NOT_FOUND = 3;
    public static final int OTHER_ERROR = 4;
    public static final int ADMIN_ROLE = 1;
    public static final int DOCTOR_ROLE = 2;
    public static final int PATIENT_ROLE = 3;
    public static final int NURSE_ROLE = 4;
    public static final int STATUS_TOOK = 0;
    public static final int STATUS_UN_TOOK = 1;
    public static final int STATUS_RE_REMINDER = 2;
    public static final String MEDICINE_STATUS_TOOK = "TOOK_MEDICINE";
    // TODO add RELATIVE_ROLE
    public static final String MEDICINE_STATUS_UN_TOOK = "UNTOOK_MEDICINE";
    public static final String MEDICINE_STATUS_RE_REMINDER = "RE_REMINDER";
    public static final String MEDICINE_STATUS_NO_ACTION = "NO_ACTION";
    public static final String MEDICINE_STATUS_IN_PROCESS = "IN_PROCESS";
    // typeDef to detect role
    public static final String ROLE_PATIENT = "PATIENT";
    public static final String ROLE_DOCTOR = "DOCTOR";
    public static final String ROLE_NURSE = "NURSE";
    public static final String TEXT_NURSE = "Điều dưỡng";
    //type usage policy
    public static final String TYPE_PRIVACY = "PRIVACY";
    public static final String TYPE_DISPUTATION = "DISPUTATION";
    public static final String TYPE_PATIENT_RULE = "PATIENT_RULE";
    public static final String TYPE_DOCTOR_RULE = "DOCTOR_RULE";
    public static final String TYPE_MECHANISM = "MECHANISM";
    public static final String TYPE_HOSPITAL = "HOSPITAL";
    public static final String TYPE_CLINIC = "CLINIC";
    public static final String NOTIFICATION_SCREEN_EXTEND_SERVICE = "PERIOD_PACKAGE";
    public static final String NOTIFICATION_SCREEN_DETAIL_APPOINTMENT = "APPOINTMENT";
    public static final String NOTIFICATION_SCREEN_PATIENT_FAMILY = "PATIENT_FAMILY";
    public static final String NOTIFICATION_SCREEN_QUESTION_ANSWERED = "TOPIC";
    public static final String NOTIFICATION_SCREEN_REVIEW = "REVIEW";
    public static final String NOTIFICATION_SCREEN_GROUP_DOCTOR = "GROUP_DOCTOR";
    public static final String NOTIFICATION_SCREEN_MISSED_CALL = "MISS_CALL";
    // end typeDef
    public static final String NOTIFICATION_SCREEN_NURSE_SHIFT = "NURSE_SHIFT";
    public static final String NOTIFICATION_SCREEN_HEALTH = "HEALTH";
    public static final String NOTIFICATION_SCREEN_ALARM = "ALARM";
    public static final String NOTIFICATION_SCREEN_HEALTH_RECORD = "HEALTH_RECORD";
    public static final String NOTIFICATION_SCREEN_FEATURED_ARTICLE = "FEATURED_ARTICLE";
    public static final String NOTIFICATION_SCREEN_DETAIL_REQUEST = "ACTION_REQUEST";
    public static final String NOTIFICATION_SCREEN_DOCTOR_INFO = "DOCTOR_INFO";
    public static final String NOTIFICATION_SCREEN_ADVISORY_HISTORY = "ADVISORY_HISTORY";
    public static final String NOTIFICATION_SCREEN_NEW_DEVICE_LOGIN = "NEW_DEVICE_LOGIN";
    public static final String NOTIFICATION_SCREEN_HEALTH_DECLARATION = "HEALTH_DECLARATION";
    public static final String NOTIFICATION_SCREEN_F0_INFORMATION_CHANGE = "F0_INFORMATION_CHANGE";
    public static final String NOTIFICATION_SCREEN_HEALTH_DECLARATION_DETAIL = "HEALTH_DECLARATION_DETAIL";
    public static final String NOTIFICATION_SCREEN_F0_MANAGEMENT_DOCTOR = "F0_MANAGEMENT_DOCTOR";
    public static final String NOTIFICATION_SCREEN_NOTIFICATION_BOARD = "NOTIFICATION_BOARD";
    public static final String NOTIFICATION_SCREEN_ELECTRONIC_MEDICAL_RECORD = "ELECTRONIC_MEDICAL_RECORD";
    public static final String NOTIFICATION_SCREEN_SELF_DOCTOR = "SELF_DOCTOR";
    public static final String NOTIFICATION_SCREEN_MEDICAL_RECORD_ROUTING = "MEDICAL_RECORD_ROUTING";
    public static final String NOTIFICATION_SCREEN_ONLINE_BOOKING_MEDICAL_DETAIL = "ONLINE_BOOKING_MEDICAL_DETAIL";
    public static final String SOCKET_CONNECT_EVENT = "connect";
    public static final String SOCKET_DOCTOR_STATUS_CHANGED_EVENT = "doctorstatus";
    public static final String SOCKET_DOCTOR_CHANGED_EVENT_APPOINTMENT = "appmtchange";
    public static final String SOCKET_DISCONNECT_EVENT = "disconnect";
    public static final String SOCKET_ERROR_EVENT = "error";
    public static final String SOCKET_HOTLINE_FORWARD = "HOTLINE_FORWARD";
    public static final String SOCKET_MISSED_CALL = "conversation_missed_call";
    public static final String SOCKET_REMINDER_MEDICINE = "ALARM_UPDATE";
    public static final String SOCKET_NEW_DEVICE_LOGIN = "NEW_DEVICE_LOGIN";
    public static final String SOCKET_HIS_MEDICAL_ROUTING_UPDATE_NEW_REMAIN_TURN = "HIS_MEDICAL_ROUTING_UPDATE_NEW_REMAIN_TURN";
    public static final String SOCKET_ONLINE_BOOKING_MEDICAL = "online_booking_medical_confirm_appmt";
    /* Notification channels */
    public static final String GENERAL_CHANNEL_ID = "general_notification_channel";
    public static final String GENERAL_CHANNEL_NAME = "General";
    // This notification channel will not show badges
    public static final String OTHER_CHANNEL_ID = "other_channel_id";
    public static final String OTHER_CHANNEL_NAME = "Other";
    public static final String GENERAL_CALL_NOTIFICATION_CHANNEL_ID = "general_call_notification_channel";
    public static final String GENERAL_CALL_NOTIFICATION_CHANNEL_NAME = "General Call Info";
    public static final int GENERAL_CALL_NOTIFICATION_ID = 1996;
    public static final String HEADS_UP_CALL_NOTIFICATION_CHANNEL_ID = "heads_up_call_notification_channel";
    public static final String HEADS_UP_CALL_NOTIFICATION_CHANNEL_NAME = "Heads-up Call Info";
    public static final int HEADS_UP_CALL_NOTIFICATION_ID = 1997;
    public static final int INCOMING_CALL_NOTIFICATION_ID = 1998;
    public static final String CHAT_CHANNEL_ID = "chat_notification_channel";
    public static final String CHAT_CHANNEL_NAME = "Messages";
    // Stringee
    public static final String INTENT_REGISTRATION_COMPLETE = "intent_get_firebase_token_success";
    public static final String TOPIC_GLOBAL = "topic_global";
    public static final String ACTION_CLEAR_FROM_RECENT = "ACTION_CLEAR_FROM_RECENT";
    public static final String ACTION_REJECT_CALL_FROM_NOTIFICATION = "ACTION_REJECT_CALL_FROM_NOTIFICATION";
    public static final String ACTION_CALL_ENDED_IN_OTHER_SIDE = "ACTION_CALL_ENDED_IN_OTHER_SIDE";
    public static final String ACTION_GET_NEW_STRINGEE_TOKEN = "ACTION_GET_NEW_STRINGEE_TOKEN";
    public static final String ACTION_ACCEPT_CALL = "ACTION_ACCEPT_CALL";
    public static final String ACTION_REJECT_CALL = "ACTION_REJECT_CALL";
    public static final String ACTION_INCOMING_CALL = "ACTION_INCOMING_CALL";
    public static final String ACTION_GO_TO_CHAT = "ACTION_GO_TO_CHAT";
    public static final String ACTION_GO_TO_DETAIL_QUESTION = "ACTION_GO_TO_DETAIL_QUESTION";
    public static final String ACTION_GO_TO_SUPERVISOR = "ACTION_GO_TO_SUPERVISOR";
    /* Notification channels */
    public static final String ACTION_RATING_AFTER_CALL = "ACTION_RATING_AFTER_CALL";
    public static final String ACTION_GO_TO_DETAIL_APPOINTMENT = "ACTION_GO_TO_DETAIL_APPOINTMENT";
    public static final String ACTION_GO_TO_DETAIL_ADVISORY_RATE = "ACTION_GO_TO_DETAIL_ADVISORY_RATE";
    public static final String ACTION_GO_TO_DOCTOR_GROUP = "ACTION_GO_TO_DOCTOR_GROUP";
    public static final String ACTION_GO_TO_SHIFT_MANAGE = "ACTION_GO_TO_SHIFT_MANAGE";
    public static final String ACTION_GO_TO_DETAIL_MEASURE = "ACTION_GO_TO_DETAIL_MEASURE";
    public static final String ACTION_GO_TO_HEALTH_RECORD = "ACTION_GO_TO_HEALTH_RECORD";
    public static final String ACTION_GO_TO_FEATURED_ARTICLE = "ACTION_GO_TO_FEATURED_ARTICLE";
    public static final String ACTION_GO_TO_DETAIL_MONTH_FINANCIAL = "ACTION_GO_TO_DETAIL_MONTH_FINANCIAL";
    public static final String ACTION_GO_TO_DETAIL_REQUEST = "ACTION_GO_TO_DETAIL_REQUEST";
    public static final String ACTION_GO_TO_DOCTOR_INFO = "ACTION_GO_TO_DOCTOR_INFO";
    public static final String ACTION_GO_TO_ADVISORY_HISTORY = "ACTION_GO_TO_ADVISORY_HISTORY";
    public static final String ACTION_GO_TO_HEALTH_DECLARATION = "ACTION_GO_TO_HEALTH_DECLARATION";
    public static final String ACTION_GO_TO_F0_INFORMATION_CHANGE = "ACTION_GO_TO_F0_INFORMATION_CHANGE";
    public static final String ACTION_GO_TO_HEALTH_DECLARATION_DETAIL = "ACTION_GO_TO_HEALTH_DECLARATION_DETAIL";
    public static final String ACTION_GO_TO_F0_MANAGEMENT_DOCTOR = "ACTION_GO_TO_F0_MANAGEMENT_DOCTOR";
    public static final String ACTION_GO_TO_NOTIFICATION_BOARD = "ACTION_GO_TO_NOTIFICATION_BOARD";
    public static final String ACTION_GO_TO_ELECTRONIC_MEDICAL_RECORD = "ACTION_GO_TO_ELECTRONIC_MEDICAL_RECORD";
    public static final String ACTION_GO_TO_SELF_DOCTOR = "ACTION_GO_TO_SELF_DOCTOR";
    public static final String ACTION_GO_TO_MEDICAL_RECORD_ROUTING = "ACTION_GO_TO_MEDICAL_RECORD_ROUTING";
    public static final String ACTION_GO_TO_ONLINE_BOOKING_MEDICAL_DETAIL = "ACTION_GO_TO_ONLINE_BOOKING_MEDICAL_DETAIL";
    public static final String ACTION_EXTEND_SERVICE_PATIENT_NOTIFICATION = "ACTION_EXTEND_SERVICE_PATIENT_NOTIFICATION";
    public static final String ACTION_HOT_LINE_BUSY = "ACTION_HOT_LINE_BUSY";
    public static final String ACTION_DOCTOR_GROUP_BUSY = "ACTION_DOCTOR_GROUP_BUSY";
    public static final String ACTION_HOT_LINE_CALL_FORWARDED = "ACTION_HOT_LINE_CALL_FORWARDED";
    public static final String ACTION_DOCTOR_BUSY = "ACTION_DOCTOR_BUSY";
    // Patient
    public static final String WAITING_DOCTOR_CONFIRM = "WAITING_DOCTOR_CONFIRM";
    public static final String WAITING_PATIENT_CONFIRM = "WAITING_PATIENT_CONFIRM";
    public static final String ACCEPTED = "ACCEPTED";
    public static final String ONGOING = "ONGOING";
    public static final String CANCELED = "CANCELED";
    public static final String FAILED = "FAILED";
    public static final String SUCCESS = "SUCCESS";
    public static final String FINISHED = "FINISHED";
    // Call Activity bundle keys
    public static final String FROM = "from";
    public static final String TO = "to";
    public static final String CALL_TYPE_KEY = "call_type";
    public static final String CALL_SERVICE_KEY = "call_service";
    public static final String CALL_PARTICIPANT_INFO = "call_participant_info";
    public static final String EXTRA_CALL_INFO = "extra_call_info"; // extra info which structure depends on call service
    public static final String PERIOD_PACKAGE_ID = "period_package_id";
    public static final String APPOINTMENT_ID = "appointment_id";
    public static final String RELATIVE_PATIENT_ID = "relative_patient_id";
    public static final String GROUP_ID = "group_id";
    public static final String GROUP_NAME = "group_name";
    public static final String GROUP_AVATAR = "group_avatar";
    public static final String HOTLINE_ID = "hotline_id";
    public static final String HOTLINE_NAME = "hotline_name";
    public static final String HOSPITAL_NAME = "hospital_name";
    public static final String TRIED_IDS = "tried_ids";
    public static final String DATA = "data";
    public static final String HOTLINE_CALL_SESSION_ID = "hotline_call_session_id";
    public static final String PATIENT_ID = "patient_id";
    public static final String PATIENT_F0 = "patient_f0";
    public static final int BLOOD_PRESSURE = 1;
    public static final int BLOOD_SUGAR = 2;
    public static final int GROWTH_CHART = 3;
    public static final int HEALTH_RECORD = 4;
    public static final int MEDICAL_HISTORY = 5;
    public static final int VACCINATION = 6;
    public static final int HEALTH_DECLARATION = 7;
    public static final int MEDICAL_RECORDS = 8;
    public static final String NO_CHANGE = "NO_CHANGE";
    public static final String CHANGED = "CHANGED";
    public static final String WAITING_CONFIRM = "WAITING_CONFIRM";

    private AppConstants() {
        // This utility class is not publicly instantiable
    }

    public enum GENDER {
        MALE("MALE", "Nam"),
        FEMALE("FEMALE", "Nữ");

        private String value;
        private String shownValue;

        GENDER(String value, String shownValue) {
            this.value = value;
            this.shownValue = shownValue;
        }

        public static String convertGender(@NonNull String gender) {
            return gender.equals(MALE.value) ? MALE.shownValue : gender.equals(FEMALE.value) ? FEMALE.shownValue : null;
        }

        public static GENDER convertFromString(@NonNull String gender) {
            return gender.equalsIgnoreCase(MALE.value) ? MALE : gender.equalsIgnoreCase(FEMALE.value) ? FEMALE : null;
        }

        public String getValue() {
            return value;
        }

        public String getShownValue() {
            return shownValue;
        }
    }

    @IntDef({CALL_FREE, CALL_DIRECT, CALL_SCHEDULED, CALL_APPOINTED, CALL_HOT_LINE, CALL_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CALL_SERVICE {
    }

    @IntDef({CALL_KIND_HOT_LINE, CALL_KIND_GROUP, CALL_KIND_DEFAULT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CALL_KIND {
    }

    @StringDef({AUDIO_CALL, VIDEO_CALL})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CALL_TYPE {
    }

    @IntDef({STATUS_GETTING_CONVERSATION, CONVERSATION_EXISTS, CONVERSATION_NOT_FOUND, OTHER_ERROR})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CONVERSATION_STATUS {
    }

    @IntDef({ADMIN_ROLE, DOCTOR_ROLE, PATIENT_ROLE, NURSE_ROLE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface USER_ROLE {
    }

    @StringDef({MEDICINE_STATUS_TOOK, MEDICINE_STATUS_UN_TOOK, MEDICINE_STATUS_RE_REMINDER
            , MEDICINE_STATUS_NO_ACTION, MEDICINE_STATUS_IN_PROCESS})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TAKE_MEDICINE_STATUS {
    }

    @IntDef({STATUS_TOOK, STATUS_UN_TOOK, STATUS_RE_REMINDER})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TAKE_STATUS {
    }

    @StringDef({TYPE_PRIVACY, TYPE_DISPUTATION, TYPE_PATIENT_RULE, TYPE_DOCTOR_RULE, TYPE_MECHANISM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE_POLICY {
    }

    @StringDef({ROLE_PATIENT, ROLE_DOCTOR, ROLE_NURSE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface USER_ROLE_STR {
    }

    @StringDef({TYPE_HOSPITAL, TYPE_CLINIC})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HOSPITAL_TYPE {
    }

    @StringDef({NOTIFICATION_SCREEN_EXTEND_SERVICE, NOTIFICATION_SCREEN_DETAIL_APPOINTMENT,
            NOTIFICATION_SCREEN_PATIENT_FAMILY, NOTIFICATION_SCREEN_QUESTION_ANSWERED,
            NOTIFICATION_SCREEN_REVIEW, NOTIFICATION_SCREEN_GROUP_DOCTOR, NOTIFICATION_SCREEN_MISSED_CALL,
            NOTIFICATION_SCREEN_NURSE_SHIFT, NOTIFICATION_SCREEN_HEALTH, NOTIFICATION_SCREEN_FEATURED_ARTICLE,
            NOTIFICATION_SCREEN_DETAIL_REQUEST, NOTIFICATION_SCREEN_DOCTOR_INFO, NOTIFICATION_SCREEN_ADVISORY_HISTORY,
            NOTIFICATION_SCREEN_HEALTH_DECLARATION, NOTIFICATION_SCREEN_HEALTH_DECLARATION_DETAIL,
            NOTIFICATION_SCREEN_F0_INFORMATION_CHANGE, NOTIFICATION_SCREEN_F0_MANAGEMENT_DOCTOR,
            NOTIFICATION_SCREEN_NOTIFICATION_BOARD, NOTIFICATION_SCREEN_ELECTRONIC_MEDICAL_RECORD,
            NOTIFICATION_SCREEN_SELF_DOCTOR, NOTIFICATION_SCREEN_MEDICAL_RECORD_ROUTING})

    @Retention(RetentionPolicy.SOURCE)
    public @interface NOTIFICATION_SCREEN {
    }
}
