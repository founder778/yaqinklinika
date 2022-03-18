package com.company.yaqinklinikaadminpage.bot.controller;


import com.company.yaqinklinikaadminpage.bot.service.AdviceService;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class AdviceController {
    public static EditMessageText retunAdviceStep(String userid, Integer chat_id, String data,String userState){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setReplyMarkup(AdviceController.retunCircleStepInStep(userState));
        editMessageText.setText("*Мутахассис маслахати болими*");
        editMessageText.setParseMode("Markdown");
        Start.userstep.replace(userid, "start", data);
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        return editMessageText;
    }

    public static EditMessageText retunAdviceStepRu(String userid, Integer chat_id, String data,String userState){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setReplyMarkup(AdviceController.retunCircleStepInStep(userState));
        editMessageText.setText("*ЭКСПЕРТНО-КОНСУЛЬТАЦИОННЫЙ ОТДЕЛ*");
        editMessageText.setParseMode("Markdown");
        Start.userstep.replace(userid, "start", data);
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        return editMessageText;
    }
    public static SendPhoto photoController(String data, Integer chat_id, String userid){
        return ClinicController.retunClinc(data, chat_id, userid);
    }
    public static SendPhoto photoControllerRu(String data, Integer chat_id, String userid){
        return ClinicController.retunClincRu(data, chat_id, userid);
    }

    public static InlineKeyboardMarkup retunCircleStepInStep(String data) {
        return AdviceService.retunAdviceBytype(data);
    }

}
