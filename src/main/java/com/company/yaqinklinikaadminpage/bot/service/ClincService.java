package com.company.yaqinklinikaadminpage.bot.service;

import com.company.yaqinklinikaadminpage.bot.buttons.MakeButton;
import com.company.yaqinklinikaadminpage.bot.repository.ClincRepository;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;

public class ClincService {
    public static InlineKeyboardMarkup retunClincByDist(String data,String userid){
        List<String> clincs = ClincRepository.retunClincByDistr(data);
        List<List<InlineKeyboardButton>> buttons = new LinkedList<>();
        for(String d : clincs){
            InlineKeyboardButton i = MakeButton.makebutton("🏥   "+d.toUpperCase(),d.toLowerCase());
            List<InlineKeyboardButton> n =  MakeButton.rows(i);
            buttons.add(n);}
        InlineKeyboardButton back = MakeButton.makebutton("🏠  Бош меню","📋 Мену");
        List<InlineKeyboardButton> n = MakeButton.rows(back);
        buttons.add(n);
        return MakeButton.readybutton  (buttons);
    }
}
