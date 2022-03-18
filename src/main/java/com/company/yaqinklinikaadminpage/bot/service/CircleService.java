package com.company.yaqinklinikaadminpage.bot.service;
import com.company.yaqinklinikaadminpage.bot.buttons.MakeButton;
import com.company.yaqinklinikaadminpage.bot.controller.UserState;
import com.company.yaqinklinikaadminpage.bot.entity.Button;
import com.company.yaqinklinikaadminpage.bot.repository.CircleRepository;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;

public class CircleService {
    public static InlineKeyboardMarkup retunCircle(String userState){
        List<String> analizList = null;
        if(userState.equals(UserState.UZ.name())){
            analizList = CircleRepository.retunCircleType();
        }
        else {
            analizList = CircleRepository.retunCircleTypeRu();
        }

        List<List<InlineKeyboardButton>> buttons = new LinkedList<>();
        for(String s : analizList){
            InlineKeyboardButton i = MakeButton.makebutton( "⏰   "+ s.toUpperCase(),s.toLowerCase());
            List<InlineKeyboardButton> n =  MakeButton.rows(i);
            buttons.add(n);}
        InlineKeyboardButton back = MakeButton.makebutton("🏠  Бош меню","📋 Мену");
        List<InlineKeyboardButton> n = MakeButton.rows(back);
        buttons.add(n);
        return MakeButton.readybutton(buttons);
    }
    public static InlineKeyboardMarkup retunCircleBytype(String data){
        List<Button> analizList = CircleRepository.retunCircleByType(data);
        List<List<InlineKeyboardButton>> buttons = new LinkedList<>();
        for(Button b : analizList){
            InlineKeyboardButton i = MakeButton.makebutton("⏰   "+b.getName(),b.getData());
            List<InlineKeyboardButton> n =  MakeButton.rows(i);
            buttons.add(n);}
        InlineKeyboardButton back = MakeButton.makebutton("🏠  Бош меню","📋 Мену");
        List<InlineKeyboardButton> n = MakeButton.rows(back);
        buttons.add(n);
        return MakeButton.readybutton  (buttons);
    }
}
