package com.company.yaqinklinikaadminpage.bot.controller;

import com.company.yaqinklinikaadminpage.bot.buttons.MakeButton;
import com.company.yaqinklinikaadminpage.bot.entity.Button;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class PrintButtons {
    public static InlineKeyboardMarkup menuButtons(List<Button> buttons) {
        List<List<InlineKeyboardButton>> ButtonList = new ArrayList<>();
        for (Button a : buttons) {
            InlineKeyboardButton inlineKeyboardButton1 = MakeButton.makebutton(a.getName(), a.getData());//"\uD83E\uDD64"
            List<InlineKeyboardButton> inlineKeyboardButtonList = MakeButton.rows(inlineKeyboardButton1);
            ButtonList.add(inlineKeyboardButtonList);
        }
        InlineKeyboardMarkup inlineKeyboardMarkup = MakeButton.readybutton(ButtonList);
        return inlineKeyboardMarkup;
    }

    public static InlineKeyboardMarkup menuButton(List<Button> buttons) {
        List<List<InlineKeyboardButton>> ButtonList = new ArrayList<>();
        for (int i = 0; i < buttons.size(); i++) {

            InlineKeyboardButton inlineKeyboardButton1 = MakeButton.makebutton(buttons.get(i).getName(), buttons.get(i).getData());
            i++;//"\uD83E\uDD64"
            if(i==buttons.size() ){
                List<InlineKeyboardButton> inlineKeyboardButtonList = MakeButton.rows(inlineKeyboardButton1);
                ButtonList.add(inlineKeyboardButtonList);
                break;
            }
            else{
                InlineKeyboardButton inlineKeyboardButton2 = MakeButton.makebutton(buttons.get(i).getName(), buttons.get(i).getData());//"\uD83E\uDD64"
                List<InlineKeyboardButton> inlineKeyboardButtonList = MakeButton.rows(inlineKeyboardButton1, inlineKeyboardButton2);
                ButtonList.add(inlineKeyboardButtonList);
            }

        }
        InlineKeyboardMarkup inlineKeyboardMarkup = MakeButton.readybutton(ButtonList);
        return inlineKeyboardMarkup;
    }




}
