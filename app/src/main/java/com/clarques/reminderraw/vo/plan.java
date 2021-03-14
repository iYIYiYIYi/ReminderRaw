package com.clarques.reminderraw.vo;

import com.clarques.reminderraw.types.PlanType;
import com.clarques.reminderraw.types.RemindFrequency;

import java.util.Date;

public class plan {

    private String planName;

    private Date startTime;

    private Date endTime;

    private RemindFrequency frequency;

    private int frequency_times = 1;

    private String briefIntro;

    private PlanType planType;

    public plan() {
    }

    public plan(String planName, Date startTime, Date endTime, RemindFrequency frequency, int frequency_times, String briefIntro, PlanType planType) {
        this.planName = planName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.frequency = frequency;
        this.frequency_times = frequency_times;
        this.briefIntro = briefIntro;
        this.planType = planType;
    }

    @Override
    public String toString() {
        return "plan{" +
                "planName='" + planName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", frequency=" + frequency +
                ", frequency_times=" + frequency_times +
                ", briefIntro='" + briefIntro + '\'' +
                ", planType=" + planType +
                '}';
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public RemindFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(RemindFrequency frequency) {
        this.frequency = frequency;
    }

    public int getFrequency_times() {
        return frequency_times;
    }

    public void setFrequency_times(int frequency_times) {
        this.frequency_times = frequency_times;
    }

    public String getBriefIntro() {
        return briefIntro;
    }

    public void setBriefIntro(String briefIntro) {
        this.briefIntro = briefIntro;
    }

    public PlanType getPlanType() {
        return planType;
    }

    public void setPlanType(PlanType planType) {
        this.planType = planType;
    }
}
