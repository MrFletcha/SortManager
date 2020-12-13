package com.spartaglobal.jf.start;

import java.util.Random;

public class RandomIntsArray {

    public int[] randoms(int maxV, int size)
    {
        Random random = new Random();
        int[] ranRet = new int[size];
        for (int i = 0; i < size -1; i++) {
            ranRet[i] = random.nextInt(maxV);
        }
        return ranRet;
    }
}
