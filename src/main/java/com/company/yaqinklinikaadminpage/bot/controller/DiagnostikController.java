package com.company.yaqinklinikaadminpage.bot.controller;


import com.company.yaqinklinikaadminpage.bot.service.DiagnostikService;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class DiagnostikController {

    public static EditMessageText retunDiagnostikStep(String userid, Integer chat_id, String data,String userState){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setReplyMarkup(DiagnostikController.retunretunDiagnostikStep(userState));
        editMessageText.setText("*Диагностика болими*");
        editMessageText.setParseMode("Markdown");
        Start.userstep.replace(userid, data);
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        return editMessageText;
    }
    public static EditMessageText retunDiagnostikStepRu(String userid, Integer chat_id, String data,String userState){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setReplyMarkup(DiagnostikController.retunretunDiagnostikStep(userState));
        editMessageText.setText("*Диагностика болими*");
        editMessageText.setParseMode("Markdown");
        Start.userstep.replace(userid, "start", data);
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        return editMessageText;
    }
    public static EditMessageText retunretunDiagnostikStepInStep(String userid,Integer chat_id,String data){
        EditMessageText  editMessageText =new EditMessageText();
        editMessageText.setMessageId(chat_id);
        Start.userstep.replace(userid, "diagnostika/In");
        editMessageText.setChatId(userid);
        editMessageText.setText("*Керакли булимни танланг*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(DiagnostikController.retunretunDiagnostikStepByType(data));
        return editMessageText;
    }
    public static EditMessageText retunretunDiagnostikStepInStepRu(String userid,Integer chat_id,String data){
        EditMessageText  editMessageText =new EditMessageText();
        editMessageText.setMessageId(chat_id);
        Start.userstep.replace(userid, "diagnostika/In");
        editMessageText.setChatId(userid);
        editMessageText.setText("*ВЫБЕРИТЕ НЕОБХОДИМЫЙ РАЗДЕЛ*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(DiagnostikController.retunretunDiagnostikStepByType(data));
        return editMessageText;
    }
    public static SendPhoto photoController(String data, Integer chat_id, String userid){
        return ClinicController.retunClinc(data, chat_id, userid);
    }

    public static SendPhoto photoControllerRu(String data, Integer chat_id, String userid){
        return ClinicController.retunClincRu(data, chat_id, userid);
    }

    public static InlineKeyboardMarkup retunretunDiagnostikStep( String userstate) {
        return DiagnostikService.retunAzaliz(userstate);
    }

    public static InlineKeyboardMarkup retunretunDiagnostikStepByType(String data) {
        return DiagnostikService.retunAnalizBytype(data);
    }
}
