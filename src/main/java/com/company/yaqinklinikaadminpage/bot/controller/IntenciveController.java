package com.company.yaqinklinikaadminpage.bot.controller;

import com.company.yaqinklinikaadminpage.bot.service.IntenciveService;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class IntenciveController {
    public static EditMessageText retunIntenciveStep(String userid, Integer chat_id, String data,String userState){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setReplyMarkup(IntenciveController.retunIntenciveStepInStep(userState));
        editMessageText.setText("*Ихтисослашган слиникалар болими*");
        editMessageText.setParseMode("Markdown");
        Start.userstep.replace(userid, "start", data);
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        return editMessageText;
    }

    public static EditMessageText retunIntenciveStepRu(String userid, Integer chat_id, String data,String userState){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setReplyMarkup(IntenciveController.retunIntenciveStepInStep(userState));
        editMessageText.setText("*СПЕЦИАЛИЗИРОВАННЫЕ КЛИНИКИ*");
        editMessageText.setParseMode("Markdown");
        Start.userstep.replace(userid, "start", data);
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        return editMessageText;
    }
    public static EditMessageText retunIntenciveStepIn(String userid,Integer chat_id,String data){
        EditMessageText  editMessageText =new EditMessageText();
        editMessageText.setMessageId(chat_id);
        Start.userstep.replace(userid, "intencive/In");
        editMessageText.setChatId(userid);
        editMessageText.setText("*Керакли булимни танланг*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(IntenciveController.retunIntenciveStepByType(data));
        return editMessageText;
    }

    public static EditMessageText retunIntenciveStepInRu(String userid,Integer chat_id,String data){
        EditMessageText  editMessageText =new EditMessageText();
        editMessageText.setMessageId(chat_id);
        Start.userstep.replace(userid, "intencive/In");
        editMessageText.setChatId(userid);
        editMessageText.setText("*ВЫБЕРИТЕ НЕОБХОДИМЫЙ РАЗДЕЛ*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(IntenciveController.retunIntenciveStepByType(data));
        return editMessageText;
    }
    public static SendPhoto photoController(String data, Integer chat_id, String userid){
        return ClinicController.retunClinc(data, chat_id, userid);
    }
    public static SendPhoto photoControllerRu(String data, Integer chat_id, String userid){
        return ClinicController.retunClincRu(data, chat_id, userid);
    }

    public static InlineKeyboardMarkup retunIntenciveStepInStep(String data) {
        return IntenciveService.retunIntencive(data);
    }

    public static InlineKeyboardMarkup retunIntenciveStepByType(String data) {
        return IntenciveService.retunIntenciveBytype(data);
    }
}
