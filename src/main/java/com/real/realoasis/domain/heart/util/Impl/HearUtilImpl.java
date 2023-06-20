package com.real.realoasis.domain.heart.util.Impl;

import com.real.realoasis.domain.couple.domain.entity.Couple;
import com.real.realoasis.domain.heart.domain.entity.Heart;
import com.real.realoasis.domain.heart.util.HeartUtil;
import org.springframework.stereotype.Component;

@Component
public class HearUtilImpl implements HeartUtil {

    @Override
    public void heartLevel(Couple couple) {
        Heart heart = new Heart();

        if(couple.getDatingDate() <= 100){
            heart = new Heart(1);
        } else if (couple.getDatingDate() <= 200) {
            heart = new Heart(2);
        } else if (couple.getDatingDate() <= 300) {
            heart = new Heart(3);
        }else if (couple.getDatingDate() <= 400) {
            heart = new Heart(4);
        }else if (couple.getDatingDate() <= 500) {
            heart = new Heart(5);
        }else if (couple.getDatingDate() <= 600) {
            heart = new Heart(6);
        }else if (couple.getDatingDate() <= 700) {
            heart = new Heart(7);
        }
        couple.updateHeart(heart);
    }
}
