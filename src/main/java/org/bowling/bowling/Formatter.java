package org.bowling.bowling;

import java.util.List;

public class Formatter
{
    public static String formatScoredFrame(ScoredFrame frame, boolean unfinished)
    {
        String ret = frame.getIndex() + ": " ;
        if(frame.getThrow1() == 10)
        {
            ret += "X";
        }
        else if(frame.getThrow1() == 0)
        {
            ret += "-";
        }
        else
        {
            ret += frame.getThrow1().toString();
        }
        if(frame.getThrow2() != null)
        {
            if(frame.getThrow2() == 10)
            {
                ret += ", X";
            }
            else if (frame.getThrow2() == 0)
            {
                ret += ", -";
            }
            else if (frame.getThrow1() + frame.getThrow2() == 10)
            {
                ret += ", /";
            }
            else
            {
                ret += ", " + frame.getThrow2().toString();
            }
        }
        if(frame.getThrow3() != null)
        {
            if(frame.getThrow3() == 10)
            {
                ret += ", X";
            }
            else if(frame.getThrow3() == 0)
            {
                ret += ", -";
            }
            else
            {
                ret += ", " + frame.getThrow3().toString();
            }

        }
        ret += " = ";
        if(frame.isSpare() || frame.isStrike())
        {
            ret += unfinished ? "-" : frame.getTotalScore();
        }
        else
        {
            ret += frame.getTotalScore();
        }
        return ret;
    }

    public static String formatScoredFrames(List<ScoredFrame> scoreFrames)
    {
        String ret = "";
        for(int i = 0; i < scoreFrames.size(); i++)
        {
            ScoredFrame frame = scoreFrames.get(i);
            ret += formatScoredFrame(frame, i == scoreFrames.size() - 1) + "\n";
        }
        ret += "---------\n";
        ret += scoreFrames.get(scoreFrames.size() - 1).getTotalScore();
        return ret;
    }
}
