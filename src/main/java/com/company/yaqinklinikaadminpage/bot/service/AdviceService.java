package com.company.yaqinklinikaadminpage.bot.service;

import com.company.yaqinklinikaadminpage.bot.buttons.MakeButton;
import com.company.yaqinklinikaadminpage.bot.controller.UserState;
import com.company.yaqinklinikaadminpage.bot.entity.Button;
import com.company.yaqinklinikaadminpage.bot.repository.AdviceRepository;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;

public class AdviceService {
    public static InlineKeyboardMarkup retunAdviceBytype(String data){
        List<Button> analizList = null;
        if(data.equals(UserState.UZ.name())){
            analizList = AdviceRepository.retunAdviceByType();
        }
        else {
            analizList = AdviceRepository.retunAdviceByTypeRu();
        }

        List<List<InlineKeyboardButton>> buttons = new LinkedList<>();
        for(Button b : analizList){
            InlineKeyboardButton i = MakeButton.makebutton("👨‍💼   "+b.getName(),b.getData());
            List<InlineKeyboardButton> n =  MakeButton.rows(i);
            buttons.add(n);}
        InlineKeyboardButton back = MakeButton.makebutton("🏠  Бош меню","📋 Мену");
        List<InlineKeyboardButton> n = MakeButton.rows(back);
        buttons.add(n);
        return MakeButton.readybutton  (buttons);
    }
}
