package org.bowling.bowling;

import java.util.List;

public class Bowling {

    public static void main(String[] args)
    {
        try
        {
            List<Frame> frames = ParametersParser.parseParams(args);
            Counter counter = new Counter(frames);
            List<ScoredFrame> scoredFrames = counter.scoreFrames();
            System.out.println(Formatter.formatScoredFrames(scoredFrames));
        }
        catch(IllegalArgumentException e)
        {
            e.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }
}
