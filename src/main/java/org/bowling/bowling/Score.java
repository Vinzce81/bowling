package org.bowling.bowling;

import java.util.List;

public class Score
{
    public Score(List<ScoredFrame> frames)
    {
        this.frames = frames;
    }
    private List<ScoredFrame> frames;

    public List<ScoredFrame> getFrames()
    {
        return frames;
    }

    public void setFrames(List<ScoredFrame> frames)
    {
        this.frames = frames;
    }
}
