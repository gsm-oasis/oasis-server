package com.real.realoasis.domain.diary.schedule;

import com.real.realoasis.domain.user.domain.entity.User;
import com.real.realoasis.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DailyScheduler {
    private final UserFacade userFacade;

    @Scheduled(cron = "0 0 0 * * *")
    public void executeDailyTask() {
        User user = userFacade.currentUser();
        user.resetDailyCount();
    }
}
