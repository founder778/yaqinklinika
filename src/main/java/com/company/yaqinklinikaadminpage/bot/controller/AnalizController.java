package com.company.yaqinklinikaadminpage.bot.controller;

import com.company.yaqinklinikaadminpage.bot.service.AnalizService;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class AnalizController {


    public static EditMessageText retunAnalizStep(String userid,Integer chat_id,String data,String userState){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setReplyMarkup(AnalizController.retunAnaliz(userState));
        editMessageText.setText("Анализ болими");
        editMessageText.setParseMode("Markdown");
        Start.userstep.replace(userid, data);
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        return editMessageText;
    }
    public static EditMessageText retunAnalizStepRu(String userid,Integer chat_id,String data,String userstate){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setReplyMarkup(AnalizController.retunAnaliz(userstate));
        editMessageText.setText("Анализ болими ");
        editMessageText.setParseMode("Markdown");
        Start.userstep.replace(userid, data);
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        return editMessageText;
    }
    public static EditMessageText retunAnalizInStep(String userid,Integer chat_id,String data,String step){
        EditMessageText  editMessageText =new EditMessageText();
        editMessageText.setMessageId(chat_id);
       Start.userstep.replace(userid, "analiz/In");
        editMessageText.setChatId(userid);
        editMessageText.setText("*Керакли булимни танланг*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(AnalizController.retunAnalizByType(data));
        return editMessageText;
    }
    public static EditMessageText retunAnalizInStepRU(String userid,Integer chat_id,String data,String step){
        EditMessageText  editMessageText =new EditMessageText();
        editMessageText.setMessageId(chat_id);
        Start.userstep.replace(userid, "analiz/In");
        editMessageText.setChatId(userid);
        editMessageText.setText("*ВЫБЕРИТЕ НЕОБХОДИМЫЙ РАЗДЕЛ*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(AnalizController.retunAnalizByType(data));
        return editMessageText;
    }
    public static SendPhoto photoController(String data, Integer chat_id, String userid){
        return ClinicController.retunClinc(data, chat_id, userid);
    }
    public static SendPhoto photoControllerRu(String data, Integer chat_id, String userid){
        return ClinicController.retunClincRu(data, chat_id, userid);
    }

    public static InlineKeyboardMarkup retunAnaliz(String userstate) {
        return AnalizService.retunAzaliz(userstate);
    }

    public static InlineKeyboardMarkup retunAnalizByType(String data) {
        return AnalizService.retunAnalizBytype(data);
    }
}
