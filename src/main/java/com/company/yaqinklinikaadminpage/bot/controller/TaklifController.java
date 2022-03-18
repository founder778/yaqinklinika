package com.company.yaqinklinikaadminpage.bot.controller;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class TaklifController {
    public static SendMessage taklif(String user) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("*Таклиф йоки шикойатингизни йозинг* 📝");
        sendMessage.setParseMode("Markdown");
        sendMessage.setChatId(user);
        return sendMessage;
    }

    public static SendMessage sendAdmin(String user) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("*Мурожатингиз йуборилди якин фурсатларда жавоб оласиз* ✅");
        sendMessage.setParseMode("Markdown");
        sendMessage.setChatId(user);

        return sendMessage;

    }
    public static SendMessage retunAnswer(){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("*жавобингизни киритинг* 📝");
        sendMessage.setParseMode("Markdown");
        sendMessage.setChatId("868795543");
        return sendMessage;
    }
}
