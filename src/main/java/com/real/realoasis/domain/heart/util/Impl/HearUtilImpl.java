package com.real.realoasis.domain.heart.util.Impl;

import com.real.realoasis.domain.heart.util.HeartUtil;
import org.springframework.stereotype.Component;

@Component
public class HearUtilImpl implements HeartUtil {
    @Override
    public int getMax(int level) {
        int max;
        switch (level) {
            case 1: max = 50; break;
            case 2: max = 150; break;
            case 3: max = 250; break;
            case 4: max = 400; break;
            case 5: max = 600; break;
            case 6: max = 800; break;
            case 7: max = 1000; break;
            case 8: max = 1300; break;
            case 9: max = 1600; break;
            case 10: max = 2000; break;
            case 11: max = 2500; break;
            case 12: max = 3000; break;
            case 13: max = 5000; break;
            default: max = 0;
        }
        return max;
    }
}
