package com.company.yaqinklinikaadminpage.bot.service;
import com.company.yaqinklinikaadminpage.bot.buttons.MakeButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ServiceButton {
    public static InlineKeyboardMarkup retunMenuButton(){
        InlineKeyboardButton button1 =  MakeButton.makebutton("💉 АНАЛИЗ","analiz");
        InlineKeyboardButton button2 =  MakeButton.makebutton("🩺 ДИАГНОСТИКА","diagnostika");
        InlineKeyboardButton button3 =  MakeButton.makebutton("🕛    24/7","circle");
        InlineKeyboardButton button4 =  MakeButton.makebutton( "👨‍⚕️ МУТАХАССИСЛАР МАСЛАХАТИ","maslahat");
        InlineKeyboardButton button5 =  MakeButton.makebutton("🏥 ИХТИСОСЛАШГАН СЛИНИКАЛАР","intencive");
        List<InlineKeyboardButton> row1 = MakeButton.rows(button1, button2);
        List<InlineKeyboardButton> row2 = MakeButton.rows(button3, button4);
        List<InlineKeyboardButton> row3 = MakeButton.rows(button5);
        List<List<InlineKeyboardButton>> collection = MakeButton.collection(row1, row2, row3);
        return MakeButton.readybutton(collection);


    }
    public static InlineKeyboardMarkup retunMenuButtonRu(){
        InlineKeyboardButton button1 =  MakeButton.makebutton("💉 АНАЛИЗ","analiz");
        InlineKeyboardButton button2 =  MakeButton.makebutton("🩺 ДИАГНОСТИКА","diagnostika");
        InlineKeyboardButton button3 =  MakeButton.makebutton("🕛    24/7","circle");
        InlineKeyboardButton button4 =  MakeButton.makebutton( "👨‍⚕️ СОВЕТ ЭКСПЕРТА","maslahat");
        InlineKeyboardButton button5 =  MakeButton.makebutton("🏥 СПЕЦИАЛИЗИРОВАННЫЕ КЛИНИКИ ","intencive");
        List<InlineKeyboardButton> row1 = MakeButton.rows(button1, button2);
        List<InlineKeyboardButton> row2 = MakeButton.rows(button3, button4);
        List<InlineKeyboardButton> row3 = MakeButton.rows(button5);
        List<List<InlineKeyboardButton>> collection = MakeButton.collection(row1, row2, row3);
        return MakeButton.readybutton(collection);


    }
}
