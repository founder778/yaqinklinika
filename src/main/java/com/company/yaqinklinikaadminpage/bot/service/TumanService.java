package com.company.yaqinklinikaadminpage.bot.service;
import com.company.yaqinklinikaadminpage.bot.buttons.MakeButton;
import com.company.yaqinklinikaadminpage.bot.entity.District;
import com.company.yaqinklinikaadminpage.bot.repository.TumanRepository;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;

public class TumanService {
    public static InlineKeyboardMarkup retunDistrName(String data,String table){
        List<District> districts = TumanRepository.retunDistByAnaliz(data ,table);
        List<List<InlineKeyboardButton>> buttons = new LinkedList<>();
        for(District d : districts){
            InlineKeyboardButton i = MakeButton.makebutton("📍  "+d.getName().toUpperCase(),d.getName().toLowerCase());
            List<InlineKeyboardButton> n =  MakeButton.rows(i);
            buttons.add(n);}
        InlineKeyboardButton back = MakeButton.makebutton("🏠  Бош меню","📋 Мену");
        List<InlineKeyboardButton> n = MakeButton.rows(back);
        buttons.add(n);
        return MakeButton.readybutton  (buttons);
    }
}
