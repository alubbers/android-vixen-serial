package org.bakchuda.android.vixenplayer.data;

import java.util.List;

public class VixenData {

    /**
     * Name of the vixen project
     */
    protected String name;

    /**
     * Number of milliseconds per data slice
     */
    protected Integer millisPerSlice;

    protected List<TimeSlice> timeSlices;

    /**
     * Number of channels of data per time slice
     */
    protected int numChannels;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMillisPerSlice() {
        return millisPerSlice;
    }

    public void setMillisPerSlice(Integer millisPerSlice) {
        this.millisPerSlice = millisPerSlice;
    }

    public List<TimeSlice> getTimeSlices() {
        return timeSlices;
    }

    public void setTimeSlices(List<TimeSlice> timeSlices) {
        this.timeSlices = timeSlices;
    }

    public int getNumChannels() {
        return numChannels;
    }

    public void setNumChannels(int numChannels) {
        this.numChannels = numChannels;
    }
}
