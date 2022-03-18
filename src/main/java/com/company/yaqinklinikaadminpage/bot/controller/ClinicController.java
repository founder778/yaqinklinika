package com.company.yaqinklinikaadminpage.bot.controller;
import com.company.yaqinklinikaadminpage.bot.buttons.MakeButton;
import com.company.yaqinklinikaadminpage.bot.entity.Clinic;
import com.company.yaqinklinikaadminpage.bot.repository.ClincRepository;
import com.company.yaqinklinikaadminpage.bot.service.ClincService;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.File;

public class ClinicController {
    public static EditMessageText retunClincs(String data, Integer chat_id, String userid,String step){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        Start.userstep.replace(userid,step);
        editMessageText.setText("*Сизга якин булган слиникани танланг*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(ClincService.retunClincByDist(data,userid));
        return editMessageText;
    }
    public static SendMessage retunClincsr(String data, Integer chat_id, String userid){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(userid);
        sendMessage.setText("*Сизга якин булган слиникани танланг*");
        sendMessage.setParseMode("Markdown");
        InlineKeyboardMarkup button =  ClincService.retunClincByDist(data,userid);
        sendMessage.setReplyMarkup(button);
        return sendMessage;
    }

    public static SendMessage retunClincsrr(String data, Integer chat_id, String userid){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(userid);
        sendMessage.setText("*ВЫБЕРИТЕ РЯДОМ*");
        sendMessage.setParseMode("Markdown");
        InlineKeyboardMarkup button =  ClincService.retunClincByDist(data,userid);
        sendMessage.setReplyMarkup(button);
        return sendMessage;
    }
    public static EditMessageText retunClincsRu(String data, Integer chat_id, String userid,String step){
        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setMessageId(chat_id);
        editMessageText.setChatId(userid);
        Start.userstep.replace(userid,step);
        editMessageText.setText("*ВЫБЕРИТЕ РЯДОМ*");
        editMessageText.setParseMode("Markdown");
        editMessageText.setReplyMarkup(ClincService.retunClincByDist(data,userid));
        return editMessageText;
    }
    public static SendPhoto retunClinc(String data,Integer chat_id, String userid){
        InputFile inputFile = new InputFile(new File("src/main/java/com/company/yaqinklinikaadminpage/bot/photo_2022-02-24_14-09-36-removebg-preview.png"));
        Clinic clinc = ClincRepository.retunClinc(data);
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(userid);
        sendPhoto.setCaption(" 🏥  Номи :" + clinc.getName().toUpperCase() +"\n\n" +
                " 📍 Адрес : " + clinc.getAddress() +"\n\n" +
                " 🛣  Арентр :  " + clinc.getC_arentr() + "\n\n"+
                "☎️ Тел : " + clinc.getPhone() +"\n\n" +
                "⏰  Иш вакти : " + clinc.getTime() +"\n\n" +
                "⭐️Рейтинг :" + clinc.getC_Reyting() );
        sendPhoto.setReplyMarkup(MakeButton.readybutton(MakeButton.collection(MakeButton.rows(MakeButton.makebutton("📍 Локатсйа ","lokatsiya" + clinc.getC_karta())),
                MakeButton.rows(MakeButton.makebutton("Бошқа клиникалар","back")),
                MakeButton.rows(MakeButton.makebutton("🏠  Бош меню","📋 Мену")))));
      sendPhoto.setPhoto(inputFile);
        Start.userstep.replace(userid,"lokatsiya");
        return sendPhoto;
    }

    public static SendPhoto retunClincRu(String data,Integer chat_id, String userid){
        InputFile inputFile = new InputFile(new File("src/main/java/com/company/yaqinklinikaadminpage/bot/photo_2022-02-24_14-09-36-removebg-preview.png"));
        Clinic clinc = ClincRepository.retunClinc(data);
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(userid);
        sendPhoto.setCaption(" 🏥  ИМЯ :" + clinc.getName().toUpperCase() +"\n\n" +
                " 📍 Адрес : " + clinc.getAddress() +"\n\n" +
                " 🛣  Арентр :  " + clinc.getC_arentr() + "\n\n"+
                "☎️ Тел : " + clinc.getPhone() +"\n\n" +
                "⏰  Рабоче время : " + clinc.getTime() +"\n\n" +
                "⭐️Рейтинг :" + clinc.getC_Reyting() );
        sendPhoto.setReplyMarkup(MakeButton.readybutton(MakeButton.collection(MakeButton.rows(MakeButton.makebutton("📍 Локатсйа ","lokatsiya" + clinc.getC_karta())),
                MakeButton.rows(MakeButton.makebutton("Другие клиники","back")),
                MakeButton.rows(MakeButton.makebutton("🏠  Бош меню","📋 Мену")))));
        sendPhoto.setPhoto(inputFile);
        Start.userstep.replace(userid,"lokatsiya");
        return sendPhoto;
    }
}
