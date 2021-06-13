package org.bowling.bowling;

import java.util.ArrayList;
import java.util.List;

public class ParametersParser
{
    public static List<Frame> parseParams(String[] args) throws IllegalArgumentException
    {
        if(args.length == 0)
        {
            throw new IllegalArgumentException("Expected at least one parameter");
        }
        if(args.length > 21)
        {
            throw new IllegalArgumentException("Maximum parameters number exceeded");
        }
        try
        {
            List<Frame> ret = new ArrayList<>(10);
            int i=0;
            while(i < args.length)
            {
                //eventual last 21st throw
                if(ret.size() == 10)
                //ret already contains partial last frame
                {
                    Frame frame = ret.get(ret.size() - 1);
                    if (frame.getThrow1() != 10 || frame.getThrow2() != 10)
                    {
                        throw new IllegalArgumentException("Exceeded number of throws");
                    }
                    int pins3 = parsePin(args[i]);
                    frame.setThrow3(pins3);
                    //no more throws
                    if(i + 1 < args.length)
                    {
                        throw new IllegalArgumentException("Exceeded number of throws");
                    }
                    break;
                }
                int pins = parsePin(args[i]);
                Frame frame = new Frame();
                frame.setThrow1(pins);
                if(pins == 10 && ret.size() < 10 - 1)
                //multiple strikes are allowed on last frame (when ret size is 9)
                {
                    ret.add(frame);
                    i++;
                    continue;
                }
                i++;
                if(i < args.length)
                {
                    int pins2 = parsePin(args[i]);
                    if (pins2 + pins > 10 && !(ret.size() == 10 - 1 && pins == 10))
                    {
                        throw new IllegalArgumentException("Maximum pins per frame is 10");
                    }
                    frame.setThrow2(pins2);
                    i++;
                }
                ret.add(frame);
            }
            return ret;
        }
        catch(NumberFormatException ne)
        {
            throw new IllegalArgumentException("Parameters must be positive integers");
        }
    }

    public static int parsePin(String arg)
    {
        int pins = Integer.parseInt(arg);
        if(pins < 0 || pins > 10)
        {
            throw new IllegalArgumentException("Parameters must be between 0 and 10");
        }
        return pins;
    }
}
