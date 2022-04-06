package com.company.yaqinklinikaadminpage.bot.service;

import com.company.yaqinklinikaadminpage.bot.buttons.MakeButton;
import com.company.yaqinklinikaadminpage.bot.controller.UserState;
import com.company.yaqinklinikaadminpage.bot.entity.Button;
import com.company.yaqinklinikaadminpage.bot.repository.AdviceRepository;
import com.company.yaqinklinikaadminpage.bot.repository.AdviceRepositoryBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;
@Service
public class AdviceService {
    @Autowired
    AdviceRepositoryBot adviceRepositoryBot;
    public  InlineKeyboardMarkup retunAdviceBytype(String data){
        List<Button> analizList = null;
        if(data.equals(UserState.UZ.name())){
//            analizList = AdviceRepository.retunAdviceByType();
            List<String> list = adviceRepositoryBot.retunAdviceByType();
            for (String s : list) {
                Button b = new Button();
                b.setName(s.toUpperCase());
                b.setData(s.toLowerCase());
                analizList.add(b);
            }
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
