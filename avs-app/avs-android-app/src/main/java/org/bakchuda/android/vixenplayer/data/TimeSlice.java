package org.bakchuda.android.vixenplayer.data;

import java.util.List;

/**
 * Represents the on/off state of channels in a Vixen data stream
 * for one 'slice' of time
 *
 */
public class TimeSlice {

    /**
     * The sort index for this time slice
     */
    protected Integer index;

    /**
     * Byte array of channel on/off states for this time slice
     * A value of 1 is 'on', 0 is 'off'
     *
     * All other values are invalid
     */
    protected List<Byte> channelStates;

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public List<Byte> getChannelStates() {
        return channelStates;
    }

    public void setChannelStates(List<Byte> channelStates) {
        this.channelStates = channelStates;
    }
}
