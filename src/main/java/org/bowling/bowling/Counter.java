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
        for(int i = frames.size() - 1; i >= 0 ; i--)
        {
            int localScore = computeScoreReverse(frames.get(i), i);
            frames.get(i).setScore(localScore);
        }
        for(int i = 0; i < frames.size(); i++)
        {
            int localScore = frames.get(i).getScore();
            score += localScore;
            frames.get(i).setTotalScore(score);
        }
        return frames;
    }

    private int computeScoreReverse(ScoredFrame frame, int index)
    {
        if(frame.isStrike())
        {
            if(frame.getIndex() == 10)
            {
                int score = 10;
                if (frame.getThrow3() != null)
                {
                    score += frame.getThrow3() + frame.getThrow2();
                } else if (frame.getThrow2() != null)
                {
                    score += frame.getThrow2();
                }
                return score;
            }
            int addedScore = computeScoreReverse(frames.get(index + 1), index + 1);
            if(addedScore > 20)
            {
                addedScore = 20;
            }
            return 10 + addedScore;
        }
        else if(frame.isSpare())
        {
            if(index + 1 < frames.size())
            {
                return 10 + frames.get(index + 1).getThrow1();
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
