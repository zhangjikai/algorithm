package com.zhangjikai.evaluation;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangjk on 2017/8/26.
 */
public class IdentityCardID {
    public static final int CARD_ID_LEN = 18;
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final Date MIN_DATE = new Calendar.Builder().setDate(1900, 0, 1).build().getTime();
    public static final Date MAX_DATE = new Calendar.Builder().setDate(2011, 11, 31).build().getTime();
    public static final Set<String> INVALID_SEQ_SET;

    static {
        INVALID_SEQ_SET = new HashSet<>();
        INVALID_SEQ_SET.add("000");
    }

    public String verify(String id, String[] regionArray) {
        if (id == null || id.length() != CARD_ID_LEN) {
            return "id is invalid";
        }
        String regionCode = id.substring(0, 6);
        boolean valid = false;
        for (String region : regionArray) {
            if (regionCode.equals(region)) {
                valid = true;
                break;
            }
        }
        if (!valid) {
            return "region code is invalid";
        }

        String yearCode = id.substring(6, 10);
        String monthCode = id.substring(10, 12);
        String dayCode = id.substring(12, 14);
        String dateText = yearCode + "-" + monthCode + "-" + dayCode;

        try {
            Date birthDay = DATE_FORMAT.parse(dateText);
            if (birthDay.compareTo(MIN_DATE) < 0 || birthDay.compareTo(MAX_DATE) > 0) {
                return "birthday code is invalid";
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return "birthday code is invalid";
        }

        String seqCode = id.substring(14, 17);
        if (INVALID_SEQ_SET.contains(seqCode)) {
            return "sequence code is invalid";
        }
        boolean isMale = true;
        try {
            int seqNumber = Integer.parseInt(seqCode);
            if ((seqNumber & 1) == 0) {
                isMale = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "sequence code is invalid";
        }

        String checkCode = id.substring(17);
        int checkNumber = 0;
        if (checkCode.equals("X")) {
            checkNumber = 10;
        } else {
            try {
                checkNumber = Integer.parseInt(checkCode);
            } catch (Exception e) {
                e.printStackTrace();
                return "check code is invalid";
            }
        }
        int sum = 0;
        for (int i = 0; i < CARD_ID_LEN - 1; i++) {
            char c = id.charAt(i);
            if (c < '0' || c > '9') {
                return "id is invalid";
            }
            sum += (c - '0') * ((int) Math.pow(2, CARD_ID_LEN - 1 - i));
        }
        sum += checkNumber;
        if (sum % 11 != 1) {
            return "check code is invalid";
        }
        if (isMale) {
            return "Male";
        } else {
            return "Female";
        }
    }

    public static void main(String[] args) {
        String result = new IdentityCardID().verify("110101197204300849", new String[]{"110101", "110102"});
        System.out.println(result);
    }
}
