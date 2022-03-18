package com.company.yaqinklinikaadminpage.bot.controller;


import com.company.yaqinklinikaadminpage.bot.service.TumanService;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;

public class TumanController {
    public static EditMessageText retunDistrict(String table,String data,Integer chat_id,String userid,String step){
        String[] sp = table.split("/");
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        Start.userstep.replace(userid,step);
        editMessageText.setText("*Керакли туманни танланг*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(TumanService.retunDistrName(data,sp[0]));
        return editMessageText;
    }
    public static EditMessageText retunDistrictRu( String table,String data,Integer chat_id,String userid,String step){
        String[] sp = table.split("/");
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        Start.userstep.replace(userid,step);
        editMessageText.setText("*ВЫБЕРИТЕ НЕОБХОДИМЫЙ РАЙОН*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(TumanService.retunDistrName(data,sp[0]));
        return editMessageText;
    }
}
