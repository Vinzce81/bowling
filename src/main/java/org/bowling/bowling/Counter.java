package org.bowling.bowling;

import java.util.ArrayList;
import java.util.List;

public class Counter
{
    public Counter(List<Frame> frames)
    {
        this.frames = new ArrayList<>(frames.size());
        for(int i = 0; i < frames.size(); i++)
        {
            ScoredFrame scoredFrame = new ScoredFrame(frames.get(i));
            scoredFrame.setIndex(i + 1);
            if(scoredFrame.getThrow1() == 10)
            {
                scoredFrame.setStrike(true);
            }
            if(scoredFrame.getThrow1() != null && scoredFrame.getThrow2() != null && scoredFrame.getThrow1() + scoredFrame.getThrow2() == 10)
            {
                scoredFrame.setSpare(true);
            }
            this.frames.add(scoredFrame);
        }
    }

    private List<ScoredFrame> frames;

    public List<ScoredFrame> scoreFrames()
    {
        int score = 0;
        for(int i = 0; i < frames.size(); i++)
        {
            int localScore = computeScore(frames.get(i), i);
            frames.get(i).setScore(localScore);
            score += localScore;
            frames.get(i).setTotalScore(score);
        }
        return frames;
    }

    private int computeScore(ScoredFrame frame, int startIndex)
    {
        if(frame.isStrike())
        {
            if(startIndex + 1 < frames.size())
            {
                int addedScore = computeScore(frames.get(startIndex + 1), startIndex + 1);
                if(addedScore > 20)
                {
                    return 30;
                }
                return 10 + addedScore;
            }
            else
            {
                int addedScore = 0;
                if(frames.size() == 10)
                {
                    if(frame.getThrow3() != null)
                    {
                        addedScore += frame.getThrow3();
                    }
                    if(frame.getThrow2() != null)
                    {
                        addedScore += frame.getThrow2();
                    }
                }
                return 10 + addedScore;
            }
        }
        else if(frame.isSpare())
        {
            if(startIndex + 1 < frames.size())
            {
                return 10 + frames.get(startIndex + 1).getThrow1();
            }
            else
            {
                return 10;
            }
        }
        else
        {
            int score = 0;
            if(frame.getThrow2() != null)
            {
                score += frame.getThrow2();
            }
            score += frame.getThrow1();
            return score;
        }
    }
}
