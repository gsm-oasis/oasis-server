package com.real.realoasis.domain.heart.util.Impl;

import com.real.realoasis.domain.heart.util.HeartUtil;
import org.springframework.stereotype.Component;

@Component
public class HearUtilImpl implements HeartUtil {
    @Override
    public int getMax(int level) {
        int max = 0;
        switch (level) {
            case 1: max = 50;
            case 2: max = 150;
            case 3: max = 250;
            case 4: max = 400;
            case 5: max = 600;
            case 6: max = 800;
            case 7: max = 1000;
            case 8: max = 1300;
            case 9: max = 1600;
            case 10: max = 2000;
            case 11: max = 2500;
            case 12: max = 3000;
            case 13: max = 5000;
        }
        return max;
    }
}
