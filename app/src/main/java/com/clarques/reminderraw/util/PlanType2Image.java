package com.clarques.reminderraw.util;

import com.clarques.reminderraw.R;
import com.clarques.reminderraw.types.PlanType;

public class PlanType2Image {

    public static int getImageOfPlanType(PlanType planType) {
        switch (planType) {
            case EXERCISE:
                return R.drawable.exercise;
            case REST:
                return R.drawable.rest;
            case WORK:
                return R.drawable.working;
            case SPORT:
                return R.drawable.sport;
            case STUDY:
                return R.drawable.study;
            case WORKING_PET:
                return R.drawable.walking_pet;
        }
        return R.drawable.exercise;
    }

}
