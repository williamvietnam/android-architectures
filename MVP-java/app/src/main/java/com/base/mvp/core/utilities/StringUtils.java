package com.base.mvp.core.utilities;

import static com.viettel.yttm.mvp.utils.AppConstants.ACCEPTED;
import static com.viettel.yttm.mvp.utils.AppConstants.CANCELED;
import static com.viettel.yttm.mvp.utils.AppConstants.FAILED;
import static com.viettel.yttm.mvp.utils.AppConstants.FINISHED;
import static com.viettel.yttm.mvp.utils.AppConstants.ONGOING;
import static com.viettel.yttm.mvp.utils.AppConstants.ROLE_DOCTOR;
import static com.viettel.yttm.mvp.utils.AppConstants.ROLE_NURSE;
import static com.viettel.yttm.mvp.utils.AppConstants.SUCCESS;
import static com.viettel.yttm.mvp.utils.AppConstants.WAITING_DOCTOR_CONFIRM;
import static com.viettel.yttm.mvp.utils.AppConstants.WAITING_PATIENT_CONFIRM;
import static com.viettel.yttm.mvp.utils.Constant.THA_GOOD;
import static com.viettel.yttm.mvp.utils.Constant.THA_LOW;
import static com.viettel.yttm.mvp.utils.Constant.THA_LV1;
import static com.viettel.yttm.mvp.utils.Constant.THA_LV2;
import static com.viettel.yttm.mvp.utils.Constant.THA_LV3;
import static com.viettel.yttm.mvp.utils.Constant.THA_PRE;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.widget.TextView;

import com.viettel.yttm.mvp.R;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class StringUtils {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static String isGender(String gender) {
        if (TextUtils.isEmpty(gender)) {
            return "";
        }
        if (gender.equals("FEMALE")) {
            return "Nữ";
        }
        if (gender.equals("MALE")) {
            return "Nam";
        }
        return "";
    }

    @SuppressLint("SetTextI18n")
    public static void showTextEveryTimeUnitMedicine(TextView textView, String unitMedicineTotalEveryTime) {
        String number = "";
        String surplus = "";
        String unit = "";
        if (!StringUtils.isNullOrEmpty(unitMedicineTotalEveryTime)) {
            if (unitMedicineTotalEveryTime.contains(",")) {
                String[] listNumber = unitMedicineTotalEveryTime.split(",");
                if (listNumber.length == 3) {
                    number = listNumber[0].trim();
                    surplus = listNumber[1].trim();
                    unit = listNumber[2].trim();
                }
            }
        }
        if (!StringUtils.isNullOrEmpty(number) && !StringUtils.isNullOrEmpty(surplus) && !StringUtils.isNullOrEmpty(unit)) {
            if (surplus.equals(".0")) {
                textView.setText(number + " " + unit);
            } else {
                if (surplus.contains("(")) {
                    int index = surplus.indexOf("(");
                    String item = surplus.substring(0, index);
                    textView.setText(number + item + " " + unit);
                } else {
                    textView.setText(number + surplus + " " + unit);
                }
            }
        }

    }

    public static String convertQualification(String qualification) {
        switch (qualification) {
            case "Bác sĩ":
                return "BS";

            case "Bác sĩ CK I":
            case "BSCKI":
                return "BSCKI";

            case "Bác sĩ CK II":
                return "BSCKII";

            case "Bác sĩ nội trú":
                return "BSNT";

            default:
                return "";
        }
    }

    public static String convertStatusCall(String statusCall) {
        String result = "";
        switch (statusCall) {
            case "FAILURE_RATING":
                return "Chưa hoàn thành";
            case "SUCCESS":
                return "Hoàn thành";
            case "FINISHED":
                return "Chưa đánh giá";
            case "CALLEE_REJECTED":
                return "Bạn đã từ chối";
            case "MISSED_CALL":
                return "Gọi nhỡ";
        }
        return result;

    }

    public static String nameDoctor(String role, String name) {
        if (role != null) {
            switch (role) {
                case ROLE_DOCTOR:
                    return "BS " + name;
                case ROLE_NURSE:
                    return "ĐD " + name;
                default:
                    return name;
            }
        } else {
            return name;
        }

    }

    public static String isNameCallServiceId(Integer idCallService) {
        switch (idCallService) {
            case AppConstants.CALL_DIRECT:
                return "trực tiếp:";
            case AppConstants.CALL_SCHEDULED:
                return "định kỳ";
            case AppConstants.CALL_APPOINTED:
                return "đặt lịch";
            case AppConstants.CALL_FREE:
                return "miễn phí";
            default:
                return "";

        }
    }

    public static String nameHospitalAnd(String typeHospital, String name) {
        if (typeHospital == null || name == null) {
            return "";
        }
        switch (typeHospital) {
            case "HOSPITAL":
                return "Bệnh viện " + name;
            case "CLINIC":
                return "Phòng khám " + name;
            case "GROUP":
                return "Nhóm " + name;
            default:
                return "";

        }
    }

    public static String handleDoctorTitle(String academicShortName, String degreeShortName, String qualification) {
        String title = "";
        if (!StringUtils.isNullOrEmpty(academicShortName) && !academicShortName.equals("Không")) {
            title = academicShortName + ".";
        }
        if (!StringUtils.isNullOrEmpty(degreeShortName) && !degreeShortName.equals("ĐH") && !degreeShortName.equals("CN")) {
            title = title + degreeShortName + ".";
        }
        if (!StringUtils.isNullOrEmpty(qualification) && !qualification.equals("Không")) {
            title = title + qualification;
        }
        return title;
    }

    public static String doctorNameWithTitle(String academic, String degree, String qualification, String nameDoctor) {
        return handleDoctorTitle(academic, degree, qualification) + " " + nameDoctor;
    }

    public static String convertAcademic(String academic) {
        if ("Giáo sư".equals(academic) || "GS".equals(academic)) {
            return "GS.";
        }
        if ("Không".equals(academic)) {
            return "";
        }
        if ("Phó giáo sư".equals(academic) || "PGS".equals(academic)) {
            return "PGS.";
        }
        return "";
    }

    public static String convertDegree(String academic) {
        if ("Thạc sĩ".equals(academic) || "ThS".equals(academic)) {
            return "ThS.";
        }
        if ("Tiến sĩ".equals(academic) || "TS".equals(academic)) {
            return "TS.";
        }
        return "";
    }

    public static DecimalFormat format = new DecimalFormat("#.##");

    public static String formatDouble(double input) {
        format.setRoundingMode(RoundingMode.UP);
        return format.format(input);
    }

    public static Double numberBMI(int height, Double weight) {
        if (height != 0) {
            Double he = (double) height / 100;
            return weight / (he * he);
        }
        return 0.0;
    }

    public static String numberBMIString(int height, Double weight) {
        if (height != 0) {
            Double he = (double) height / 100;
            return format.format(weight / (he * he));
        }
        return "0.0";
    }

    public static int setCategory(String category) {
        switch (category) {
            case THA_LOW:
                return R.string.string_low;
            case THA_GOOD:
                return R.string.string_good;
            case THA_PRE:
                return R.string.string_tien_tha;
            case THA_LV1:
                return R.string.string_do_1;
            case THA_LV2:
                return R.string.string_do_2;
            case THA_LV3:
                return R.string.string_do_3;
        }
        return 0;
    }

    public static int setColorCategory(String category) {
        switch (category) {
            case THA_LOW:
                return R.color.color_low;
            case THA_GOOD:
                return R.color.color_good;
            case THA_PRE:
                return R.color.color_tien_tha;
            case THA_LV1:
                return R.color.color_do_1;
            case THA_LV2:
                return R.color.color_do_2;
            case THA_LV3:
                return R.color.color_do_3;
        }
        return 0;
    }

    public static String getAge(String dateOfBirth, String initFormat) {

        if (StringUtils.isNullOrEmpty(dateOfBirth)) {
            return "";
        }
        int ageInMonth = differenceInMonths(DateUtils.convertStringToCalender(dateOfBirth, initFormat), Calendar.getInstance());
        if (ageInMonth < 24) {
            return ageInMonth + " tháng";
        } else {
            ageInMonth = differenceInDay(DateUtils.convertStringToCalender(dateOfBirth, initFormat), Calendar.getInstance());
            return String.valueOf(ageInMonth / 365);
        }

    }

    public static boolean isLeapYear(int year) {
        assert year >= 1583; // not valid before this date.
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    private static int differenceInDay(Calendar c1, Calendar c2) {
        int numLeap = 0;
        for (int i = c1.get(Calendar.YEAR); i <= c2.get(Calendar.YEAR); i++) {
            if (isLeapYear(i)) {
                numLeap++;
            }
        }

        int diff = 0;
        if (c2.after(c1)) {
            while (c2.after(c1)) {
                c1.add(Calendar.DATE, 1);
                if (c2.after(c1)) {
                    diff++;
                }
            }
        } else if (c2.before(c1)) {
            while (c2.before(c1)) {
                c1.add(Calendar.DATE, -1);
                if (c1.before(c2)) {
                    diff--;
                }
            }
        }
        return diff - numLeap;
    }

    private static int differenceInMonths(Calendar c1, Calendar c2) {
        int diff = 0;
        if (c2.after(c1)) {
            while (c2.after(c1)) {
                c1.add(Calendar.MONTH, 1);
                if (c2.after(c1)) {
                    diff++;
                }
            }
        } else if (c2.before(c1)) {
            while (c2.before(c1)) {
                c1.add(Calendar.MONTH, -1);
                if (c1.before(c2)) {
                    diff--;
                }
            }
        }
        return diff;
    }

    public static String formatCurrency(long amount) {
        DecimalFormatSymbols customSymbol = new DecimalFormatSymbols(Locale.getDefault());
        customSymbol.setDecimalSeparator(',');
        DecimalFormat formatter = new DecimalFormat("###,###,###", customSymbol);

        return formatter.format(amount);
    }

    public static String getStatusAppointment(String status) {
        if (status == null) {
            return "";
        }
        switch (status) {
            case WAITING_DOCTOR_CONFIRM:
                return "Chờ xác nhận";
            case WAITING_PATIENT_CONFIRM:
                return "Cần bạn xác nhận";
            case ACCEPTED:
                return "Đã xác nhận";
            case ONGOING:
                return "Đang diễn ra";
            case CANCELED:
                return "Hủy lịch";
            case FAILED:
                return "Thất bại";
            case SUCCESS:
                return "Thành công";
            case FINISHED:
                return "Chưa đánh giá";
        }
        return "";
    }

    public static String getStatusAppointmentDoctor(String status) {
        if (status == null) {
            return "";
        }
        switch (status) {
            case WAITING_DOCTOR_CONFIRM:
                return "Cần bạn xác nhận";
            case WAITING_PATIENT_CONFIRM:
                return "Chờ xác nhận";
            case ACCEPTED:
                return "Đã xác nhận";
            case ONGOING:
                return "Đang diễn ra";
            case CANCELED:
                return "Hủy lịch";
            case FAILED:
                return "Thất bại";
            case SUCCESS:
                return "Thành công";
            case FINISHED:
                return "Chưa đánh giá";
        }
        return "";
    }

    public static int getStatusColorAppointment(String status) {
        if (status == null) {
            return R.color.color_fc8d08;
        }
        switch (status) {
            case WAITING_DOCTOR_CONFIRM:
            case WAITING_PATIENT_CONFIRM:
                return R.color.color_fc8d08;
            case ACCEPTED:
            case ONGOING:
            case SUCCESS:
                return R.color.color_low;
            case FINISHED:
            case FAILED:
            case CANCELED:
                return R.color.color_do_2;
        }
        return R.color.color_fc8d08;
    }

    public static String convertStatusCallHotline(String status) {
        switch (status) {
            case "HAPPENED":
                return "Đã diễn ra";
            case "HAPPENING":
                return "Đang diễn ra";
            case "NOT_HAPPEN":
                return "Chưa diễn ra";
        }
        return "";
    }

    public static String convertStatusCallHotlineDetail(String status) {
        switch (status) {
            case "REJECTED":
                return "Đã từ chối";
            case "ANSWERED":
                return " nghe máy";
            case "NOT_ANSWERED":
                return "Không nghe máy";
        }
        return "";
    }

    public static int getStatusColorHotline(String status) {
        switch (status) {
            case "REJECTED":
            case "NOT_ANSWERED":
                return R.color.color_do_2;
            case "ANSWERED":
                return R.color.color_low;
        }
        return R.color.color_fc8d08;
    }

    public static String convertStatusHotlineCall(String status) {
        switch (status) {
            case "REJECTED":
                return "Đã từ chối";
            case "NOT_ANSWERED":
                return "Không nghe máy";
            case "ANSWERED":
                return "Đã nghe máy";
            case "SUCCESS_FORWARD":
            case "FORWARDED":
                return "Chuyển tiếp đến";
        }
        return "";
    }

    public static String setTextHour(int hourAlarm, int minuteAlarm) {
        String hour;
        String minute;
        String timeOfDay;
        if (hourAlarm < 10) {
            hour = "0" + hourAlarm;
        } else {
            hour = String.valueOf(hourAlarm);
        }

        if (minuteAlarm < 10) {
            minute = "0" + minuteAlarm;
        } else {
            minute = String.valueOf(minuteAlarm);
        }

        if (hourAlarm <= 12) {
            timeOfDay = " AM";
        } else {
            timeOfDay = " PM";
        }
        return hour + ":" + minute;
    }

    public static int convertHealthRecordIdResource(String type) {
        if (StringUtils.isNullOrEmpty(type)) return R.drawable.ic_huyetap;
        switch (type) {
            case "BLOOD_PRESSURE":
                return R.drawable.ic_huyetap;
            case "BLOOD_SUGAR":
                return R.drawable.ic_duonghuyet;
            case "GROWTH_CHART":
                return R.drawable.ic_bieudo;
            case "HEALTH_RECORD":
                return R.drawable.ic_hosokham_donthuoc;
            case "MEDICAL_HISTORY":
                return R.drawable.ic_tiensubenh;
            case "VACCINATION":
                return R.drawable.ic_sotiemchung;
            case "HEALTH_DECLARATION":
                return R.drawable.ic_khai_bao;
        }
        return R.drawable.ic_huyetap;
    }

    public static String convertHealthRecordName(String type) {
        if (StringUtils.isNullOrEmpty(type)) return "";
        switch (type) {
            case "BLOOD_PRESSURE":
                return "Huyết áp";
            case "BLOOD_SUGAR":
                return "Đường huyết";
            case "GROWTH_CHART":
                return "Biểu đồ \ntăng trưởng";
            case "HEALTH_RECORD":
                return "Hồ sơ sức khỏe";
            case "MEDICAL_HISTORY":
                return "Tiền sử \nbệnh";
            case "VACCINATION":
                return "Sổ tiêm \nchủng";
            case "HEALTH_DECLARATION":
                return "Bệnh nhân F0 tại nhà";
        }
        return "";
    }

    public static int convertHealthRecordTypeToInt(String type) {
        if (StringUtils.isNullOrEmpty(type)) return AppConstants.BLOOD_PRESSURE;
        switch (type) {
            case "BLOOD_PRESSURE":
                return AppConstants.BLOOD_PRESSURE;
            case "BLOOD_SUGAR":
                return AppConstants.BLOOD_SUGAR;
            case "GROWTH_CHART":
                return AppConstants.GROWTH_CHART;
            case "HEALTH_RECORD":
                return AppConstants.HEALTH_RECORD;
            case "MEDICAL_HISTORY":
                return AppConstants.MEDICAL_HISTORY;
            case "VACCINATION":
                return AppConstants.VACCINATION;
            case "HEALTH_DECLARATION":
                return AppConstants.HEALTH_DECLARATION;
        }
        return AppConstants.BLOOD_PRESSURE;
    }

    public static String convertHealthRecordTypeToString(int type) {
        switch (type) {
            case AppConstants.BLOOD_PRESSURE:
                return "BLOOD_PRESSURE";
            case AppConstants.BLOOD_SUGAR:
                return "BLOOD_SUGAR";
            case AppConstants.GROWTH_CHART:
                return "GROWTH_CHART";
            case AppConstants.HEALTH_RECORD:
                return "HEALTH_RECORD";
            case AppConstants.MEDICAL_HISTORY:
                return "MEDICAL_HISTORY";
            case AppConstants.VACCINATION:
                return "VACCINATION";
            case AppConstants.HEALTH_DECLARATION:
                return "HEALTH_DECLARATION";
        }
        return "BLOOD_PRESSURE";
    }

    public static String convertHealthDeclarationStatus(String type) {
        if (StringUtils.isNullOrEmpty(type)) return "";
        switch (type) {
            case "NOT_EVALUATE":
                return "Chưa đánh giá";
            case "F0_LOW_RISK":
                return "Nguy cơ thấp";
            case "F0_MED_RISK":
                return "Nguy cơ trung bình";
            case "F0_HIGH_RISK":
                return "Nguy cơ cao";
            case "F0_DANGEROUS_RISK":
                return "Nguy cơ rất cao";
            case "F0_AFTER_TREATMENT":
                return "F0_Sau điều trị";
            case "F1_NO_SYMPTOM":
                return "F1_Không triệu chứng";
            case "F1_SYMPTOM":
                return "F1_Có triệu chứng";
            case "STOP_FOLLOWING":
                return "Ngừng theo dõi";
        }
        return "";
    }

    public static String convertHealthDeclarationType(String status) {
        if (StringUtils.isNullOrEmpty(status)) return "NOT_EVALUATE";
        switch (status) {
            case "Chưa đánh giá":
                return "NOT_EVALUATE";
            case "Nguy cơ thấp":
                return "F0_LOW_RISK";
            case "Nguy cơ trung bình":
                return "F0_MED_RISK";
            case "Nguy cơ cao":
                return "F0_HIGH_RISK";
            case "Nguy cơ rất cao":
                return "F0_DANGEROUS_RISK";
            case "F0_Sau điều trị":
                return "F0_AFTER_TREATMENT";
            case "F1_Không triệu chứng":
                return "F1_NO_SYMPTOM";
            case "F1_Có triệu chứng":
                return "F1_SYMPTOM";
            case "Ngừng theo dõi":
                return "STOP_FOLLOWING";
        }
        return "NOT_EVALUATE";
    }

    public static String convertDoctorFollowStatus(String status) {
        if (StringUtils.isNullOrEmpty(status)) return "";
        switch (status) {
            case "Ngừng theo dõi":
                return "STOP_FOLLOWING";
            case "Đang theo dõi":
                return "FOLLOWING";
        }
        return "";
    }

    public static String convertHealthHaveDeclaration(String status) {
        if (StringUtils.isNullOrEmpty(status)) return "ALL";
        switch (status) {
            case "Đã khai báo":
                return "DECLARED";
            case "Chưa khai báo":
                return "NOT_DECLARED";
        }
        return "ALL";
    }
}
