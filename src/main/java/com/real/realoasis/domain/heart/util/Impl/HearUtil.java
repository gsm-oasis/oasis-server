package com.real.realoasis.domain.heart.util.Impl;

import com.real.realoasis.domain.heart.data.entity.Heart;
import com.real.realoasis.domain.heart.util.HeartUtil;
import com.real.realoasis.domain.user.data.entity.User;
import org.springframework.stereotype.Component;

@Component
public class HearUtil implements HeartUtil {

    @Override
    public void heartLevel(User user) {
        Heart heart = new Heart();

        if(user.getDatingDate() <= 100){
            heart = new Heart(1);
        } else if (user.getDatingDate() <= 200) {
            heart = new Heart(2);
        } else if (user.getDatingDate() <= 300) {
            heart = new Heart(3);
        }else if (user.getDatingDate() <= 400) {
            heart = new Heart(4);
        }else if (user.getDatingDate() <= 500) {
            heart = new Heart(5);
        }else if (user.getDatingDate() <= 600) {
            heart = new Heart(6);
        }else if (user.getDatingDate() <= 700) {
            heart = new Heart(7);
        }
        user.updateHeart(heart);
    }
}
