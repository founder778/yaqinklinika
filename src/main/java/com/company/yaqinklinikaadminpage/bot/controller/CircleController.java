package com.company.yaqinklinikaadminpage.bot.controller;

import com.company.yaqinklinikaadminpage.bot.service.CircleService;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class CircleController {
    public static EditMessageText retunCircleStep(String userid, Integer chat_id, String data,String userState){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setReplyMarkup(CircleController.retunCircleStepInStep(userState));
        editMessageText.setText("*24/7 болими*");
        editMessageText.setParseMode("Markdown");
        Start.userstep.replace(userid, "start", data);
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        return editMessageText;
    }

    public static EditMessageText retunCircleStepRu(String userid, Integer chat_id, String data,String userState){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setReplyMarkup(CircleController.retunCircleStepInStep(userState));
        editMessageText.setText("*24/7 болими *");
        editMessageText.setParseMode("Markdown");
        Start.userstep.replace(userid, "start", data);
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        return editMessageText;
    }
    public static EditMessageText retunCircleStepIn(String userid,Integer chat_id,String data){
        EditMessageText  editMessageText =new EditMessageText();
        editMessageText.setMessageId(chat_id);
        Start.userstep.replace(userid, "circle/In");
        editMessageText.setChatId(userid);
        editMessageText.setText("*Керакли булимни танланг*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(CircleController.retunCircleByType(data));
        return editMessageText;
    }
    public static EditMessageText retunCircleStepInRu(String userid,Integer chat_id,String data){
        EditMessageText  editMessageText =new EditMessageText();
        editMessageText.setMessageId(chat_id);
        Start.userstep.replace(userid, "circle/In");
        editMessageText.setChatId(userid);
        editMessageText.setText("*ВЫБЕРИТЕ НЕОБХОДИМЫЙ РАЗДЕЛ*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(CircleController.retunCircleByType(data));
        return editMessageText;
    }
    public static SendPhoto photoController(String data, Integer chat_id, String userid){
        return ClinicController.retunClinc(data, chat_id, userid);
    }
    public static SendPhoto photoControllerRu(String data, Integer chat_id, String userid){
        return ClinicController.retunClincRu(data, chat_id, userid);
    }

    public static InlineKeyboardMarkup retunCircleStepInStep(String data) {
        return CircleService.retunCircle(data);
    }

    public static InlineKeyboardMarkup retunCircleByType(String data) {
        return CircleService.retunCircleBytype(data);
    }
}
