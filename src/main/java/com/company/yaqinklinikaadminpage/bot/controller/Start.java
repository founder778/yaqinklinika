package com.company.yaqinklinikaadminpage.bot.controller;

import com.company.yaqinklinikaadminpage.bot.buttons.MakeButton;
import com.company.yaqinklinikaadminpage.bot.buttons.ManuButton;
import com.company.yaqinklinikaadminpage.bot.entity.BotUsersEntity;
import com.company.yaqinklinikaadminpage.bot.repository.UserRepository;
import com.company.yaqinklinikaadminpage.bot.service.ServiceButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendLocation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class Start extends TelegramLongPollingBot {
    @Autowired
    UserRepository userRepository;
    static Map<String, String> userstep = new HashMap<>();
    public static Map<String, String> userState = new HashMap<>();
    static Map<String, String> stepclin = new HashMap<>();
    String ans;

    @Override
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = new SendMessage();
        if (update.hasMessage()) {
            String userid = update.getMessage().getChatId().toString();
            if (update.getMessage().hasLocation() && userid.equals("561861517")) {
                sendMessage.setText(update.getMessage().getLocation().getLongitude() + "/" + update.getMessage().getLocation().getLatitude());
                sendMessage.setChatId("561861517");
                sendmes(sendMessage);
                return;
            }
        }

        if (update.hasMessage()) {
            String id = update.getMessage().getChatId().toString();
            if (!userState.containsKey(id)) {
                if (update.getMessage().getText().equals("/start")) {
                    sendMessage.setReplyMarkup(ManuButton.languageKeyboard());
                    sendMessage.setText("Tilni tanlang");
                    userState.put(id, "");
                    userRepository.save(new BotUsersEntity(update.getMessage().getChatId().toString()));
                    sendMessage.setChatId(id);
                    sendmes(sendMessage);
                    return;
                }
            }
            if (update.getMessage().getText().equals("🇺🇿 УЗ")) {
                userState.replace(id, UserState.UZ.name());
                sendMessage.setChatId(id);
                sendMessage.setText("*Yaqin Klinika ботига хуш келибсиз \n  " + update.getMessage().getFrom().getUserName() + "  " +
                        "\n" +
                        "Керакли булимни танланг*");
                sendMessage.setParseMode("Markdown");
                sendMessage.setReplyMarkup(ManuButton.menuKeyboard());
                sendmes(sendMessage);
                return;
            } else if (update.getMessage().getText().equals("🇷🇺 РУ")) {
                userState.replace(id, UserState.RU.name());
                sendMessage.setChatId(id);
                sendMessage.setText("*Добро пожаловать YaqinKlinika в бота \n  " + update.getMessage().getFrom().getUserName() + "  " +
                        "\n" +
                        "выберите нужный раздел*");
                sendMessage.setParseMode("Markdown");
                sendMessage.setReplyMarkup(ManuButton.menuKeyboardRu());
                sendmes(sendMessage);
                return;
            } else if (userState.get(id).equals(UserState.UZ.name())) {
                if (update.hasMessage()) {
                    String userid = update.getMessage().getChatId().toString();
                    String message = update.getMessage().getText();
                    if (ans != null && ans.startsWith("answer")) {
                        SendMessage sendMessage2 = new SendMessage();
                        sendMessage2.setText("*Админдан хабар *\n" + update.getMessage().getText());
                        sendMessage2.setParseMode("Markdown");
                        sendMessage2.setChatId(ans.substring(6));
                        sendmes(sendMessage2);
                        SendMessage sendMessage1 = new SendMessage();
                        sendMessage1.setChatId("561861517");
                        sendMessage1.setText("*Хабар йуборилди*");
                        sendmes(sendMessage1);
                        ans = "start";
                        return;
                    }
                    switch (message) {
                        case "/start": {

                            if (!userstep.containsKey(userid)) {
                                userstep.put(userid, "start");
                            } else {
                                userstep.replace(userid, "start");
                            }
                            sendMessage.setText("*Yaqin Klinika ботига хуш келибсиз \n  " + update.getMessage().getFrom().getUserName() + "  " +
                                    "\n" +
                                    "Керакли булимни танланг*");
                            sendMessage.setParseMode("Markdown");
                            sendMessage.setChatId(userid);

                            sendMessage.setReplyMarkup(ManuButton.menuKeyboard());
                            sendmes(sendMessage);
                            break;
                        }
                        case "📋 Хизматлар": {
                            if (!stepclin.containsKey(userid)) {
                                stepclin.put(userid, "first");
                            } else {
                                userstep.replace(userid, "first");
                            }
                            if (!userstep.containsKey(userid)) {
                                userstep.put(userid, "start");
                            } else {
                                userstep.replace(userid, "start");
                            }
                            sendMessage.setChatId(userid);
                            sendMessage.setText("* хизматлар *");
                            sendMessage.setParseMode("Markdown");
                            sendMessage.setReplyMarkup(ServiceButton.retunMenuButton());
                            sendmes(sendMessage);
                            break;
                        }
                        case "📝 Мурожаат": {
                            userstep.replace(userid, "📝 Murojat");
                            sendmes(TaklifController.taklif(userid));
                            return;
                        }
                        case "⚙ Созламалар": {
                            sendMessage.setReplyMarkup(ManuButton.languageKeyboard());
                            sendMessage.setText("Тилни танланг : ");
                            userState.replace(id, "");
                            sendMessage.setChatId(id);
                            sendmes(sendMessage);
                            return;
                        }
                    }
                    if (userstep.get(userid).equals("📝 Murojat")) {
                        userstep.replace(userid, "📝 Murojat", "start");
                        SendMessage sendMessage1 = new SendMessage();
                        List<List<InlineKeyboardButton>> but = new LinkedList<>();
                        List<InlineKeyboardButton> buttons = new LinkedList<>();
                        buttons.add(MakeButton.makebutton("Жавоб бериш ", "answer" + userid));
                        but.add(buttons);
                        sendMessage1.setReplyMarkup(MakeButton.readybutton(but));
                        sendMessage1.setText("      📨  Янги таклиф :\n" + update.getMessage().getText() + "   userid  = (" + userid + ")dan  ");
                        sendMessage1.setChatId("561861517");
                        sendmes(sendMessage1);
                        sendmes(TaklifController.sendAdmin(userid));
                    }

                }
            }

//        ======================================end hasmassage===================

            else if (userState.get(id).equals(UserState.RU.name())) {
                if (update.hasMessage()) {
                    String userid = update.getMessage().getChatId().toString();
                    String message = update.getMessage().getText();
                    if (ans != null && ans.startsWith("answer")) {
                        SendMessage sendMessage2 = new SendMessage();
                        sendMessage2.setText("*CООБЩЕНИЕ ОТ АДМИНА*\n" + update.getMessage().getText());
                        sendMessage2.setParseMode("Markdown");
                        sendMessage2.setChatId(ans.substring(6));
                        sendmes(sendMessage2);
                        SendMessage sendMessage1 = new SendMessage();
                        sendMessage1.setChatId("561861517");
                        sendMessage1.setText("*СООБЩЕНИЕ ОТПРАВЛЕНО*");
                        sendmes(sendMessage1);
                        ans = "start";
                        return;
                    }
//                    else if (update.getMessage().hasLocation() && userid.equals("561861517")) {
//                        sendMessage.setText(update.getMessage().getLocation().getLongitude() + "/" + update.getMessage().getLocation().getLatitude());
//                        sendMessage.setChatId("561861517");
//                        sendmes(sendMessage);
//                        return;
//                    }
                    switch (message) {
                        case "/start": {
                            if (!userstep.containsKey(userid)) {
                                userstep.put(userid, "start");
                            } else {
                                userstep.replace(userid, "start");
                            }
                            sendMessage.setText("*Добро пожаловать YaqinKlinika в бота \n  " + update.getMessage().getFrom().getUserName() + "  " +
                                    "\n" +
                                    "выберите нужный раздел*");
                            sendMessage.setParseMode("Markdown");
                            sendMessage.setReplyMarkup(ManuButton.menuKeyboardRu());
                            sendMessage.setChatId(userid);
                            sendmes(sendMessage);
                            break;
                        }
                        case "📋 сервисы": {
                            if (!userstep.containsKey(userid)) {
                                userstep.put(userid, "start");
                            } else {
                                userstep.replace(userid, "start");
                            }
                            sendMessage.setChatId(userid);
                            sendMessage.setText("*Меню болими*");
                            sendMessage.setParseMode("Markdown");
                            sendMessage.setReplyMarkup(ServiceButton.retunMenuButtonRu());
                            sendmes(sendMessage);
                            break;
                        }
                        case "📝 жалобы": {
                            userstep.replace(userid, "📝 Murojat");
                            sendmes(TaklifController.taklif(userid));
                            return;
                        }
                        case "⚙ настройки": {
                            sendMessage.setReplyMarkup(ManuButton.languageKeyboard());
                            sendMessage.setText("выберите язык : ");
                            userState.replace(id, "");
                            sendMessage.setChatId(id);
                            sendmes(sendMessage);
                            return;
                        }
                    }
                    if (userstep.get(userid).equals("📝 Murojat")) {
                        userstep.replace(userid, "📝 Murojat", "start");
                        SendMessage sendMessage1 = new SendMessage();
                        List<List<InlineKeyboardButton>> but = new LinkedList<>();
                        List<InlineKeyboardButton> buttons = new LinkedList<>();
                        buttons.add(MakeButton.makebutton("Жавоб бериш ", "answer" + userid));
                        but.add(buttons);
                        sendMessage1.setReplyMarkup(MakeButton.readybutton(but));
                        sendMessage1.setText("      📨  новое предложение :\n" + update.getMessage().getText() + "   userid  = (" + userid + ")dan  ");
                        sendMessage1.setChatId("561861517");
                        sendmes(sendMessage1);
                        sendmes(TaklifController.sendAdmin(userid));
                    }

                }

//        ======================================end hasmassage===================
            }
        } else if (update.hasCallbackQuery()) {
            if (userState.get(update.getCallbackQuery().getFrom().getId().toString()).equals(UserState.UZ.name())) {
                String userid = update.getCallbackQuery().getFrom().getId().toString();
                Integer chat_id = update.getCallbackQuery().getMessage().getMessageId();
                String data = update.getCallbackQuery().getData();
                if (data.startsWith("answer")) {
                    ans = data;
                    sendmes(TaklifController.retunAnswer());
                    return;
                }
                if (data.equals("back")) {
                    sendmes(ClinicController.retunClincsr(stepclin.get(userid), chat_id, userid));
                    userstep.replace(userid, "aklinikaIn");
                    return;
                }

//            ==========================check========================
                switch (data) {
                    case "analiz": {
                        editmes(AnalizController.retunAnalizStep(userid, chat_id, data,userState.get(userid)));
                        return;
                    }
                    case "diagnostika": {
                        editmes(DiagnostikController.retunDiagnostikStep(userid, chat_id, data, userState.get(userid)));

                        return;
                    }
                    case "circle": {
                        editmes(CircleController.retunCircleStep(userid, chat_id, data, userState.get(userid)));

                        return;
                    }
                    case "maslahat": {
                        editmes(AdviceController.retunAdviceStep(userid, chat_id, data, userState.get(userid)));

                        return;
                    }
                    case "intencive": {
                        editmes(IntenciveController.retunIntenciveStep(userid, chat_id, data, userState.get(userid)));

                        return;
                    }
                    case "📋 Мену": {
                        if (!userstep.containsKey(userid)) {
                            userstep.put(userid, "start");
                        } else {
                            userstep.replace(userid, "start");
                        }
                        sendMessage.setChatId(userid);
                        sendMessage.setText("*Мену болими*");
                        sendMessage.setParseMode("Markdown");
                        sendMessage.setReplyMarkup(ServiceButton.retunMenuButton());
                        sendmes(sendMessage);

                        break;

                    }
                }
//            =======================analiz==========================
                if (userstep.get(userid).equals("analiz")) {
                    editmes(AnalizController.retunAnalizInStep(userid, chat_id, data, userstep.get(userid)));
                    return;
                } else if (userstep.get(userid).equals("analiz/In")) {
                    editmes(TumanController.retunDistrict(userstep.get(userid), data, chat_id, userid, "aklinika"));

                    return;
                } else if (userstep.get(userid).equals("aklinika")) {
                    editmes(ClinicController.retunClincs(data, chat_id, userid, "aklinikaIn"));
                    stepclin.replace(userid, data);
                    return;
                } else if (userstep.get(userid).equals("aklinikaIn")) {
                    sendPhoto(AnalizController.photoController(data, chat_id, userid));
                    return;

                } else if (userstep.get(userid).equals("lokatsiya")) {
                    String datasp = data.substring(9);
                    String[] dataarray = datasp.split("/");
                    SendLocation sendLocation = new SendLocation();
                    sendLocation.setChatId(userid);
                    sendLocation.setLatitude(Double.valueOf(dataarray[1]));
                    sendLocation.setLongitude(Double.valueOf(dataarray[0]));
                    sendLocation.setReplyMarkup(MakeButton.readybutton(MakeButton.collection(MakeButton.rows(MakeButton.makebutton("🏠  Бош меню", "📋 Мену")),
                            MakeButton.rows(MakeButton.makebutton("Cлиникалар", "back")))));
                    userstep.replace(userid, "start");
                    try {
                        execute(sendLocation);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    return;
                }
                //            =============================24/7==============
                else if (userstep.get(userid).equals("circle")) {
                    editmes(CircleController.retunCircleStepIn(userid, chat_id, data));

                    return;
                } else if (userstep.get(userid).equals("circle/In")) {
                    editmes(TumanController.retunDistrict(userstep.get(userid), data, chat_id, userid, "cklinika"));
                    return;
                } else if (userstep.get(userid).equals("cklinika")) {
                    editmes(ClinicController.retunClincs(data, chat_id, userid, "cklinikaIn"));
                    if (stepclin.containsKey(userid)) {
                        stepclin.replace(userid, data);
                    } else {
                        stepclin.put(userid, data);
                    }
                    return;
                } else if (userstep.get(userid).equals("cklinikaIn")) {
                    sendPhoto(CircleController.photoController(data, chat_id, userid));
                    return;

                }

                //            =============================diagnostika==============


                else if (userstep.get(userid).equals("diagnostika")) {
                    editmes(DiagnostikController.retunretunDiagnostikStepInStep(userid, chat_id, data));
                    return;
                } else if (userstep.get(userid).equals("diagnostika/In")) {
                    editmes(TumanController.retunDistrict(userstep.get(userid), data, chat_id, userid, "dklinika"));

                    return;
                } else if (userstep.get(userid).equals("dklinika")) {
                    editmes(ClinicController.retunClincs(data, chat_id, userid, "dklinikaIn"));
                    if (stepclin.containsKey(userid)) {
                        stepclin.replace(userid, data);
                    } else {
                        stepclin.put(userid, data);
                    }
                    return;
                } else if (userstep.get(userid).equals("dklinikaIn")) {
                    sendPhoto(DiagnostikController.photoController(data, chat_id, userid));
                    return;

                }

//            =======================Advice=================

                else if (userstep.get(userid).equals("maslahat")) {
                    editmes(TumanController.retunDistrict(userstep.get(userid), data, chat_id, userid, "mklinika"));
                    return;
                } else if (userstep.get(userid).equals("mklinika")) {
                    editmes(ClinicController.retunClincs(data, chat_id, userid, "mklinikaIn"));
                    if (stepclin.containsKey(userid)) {
                        stepclin.replace(userid, data);
                    } else {
                        stepclin.put(userid, data);
                    }
                    return;
                } else if (userstep.get(userid).equals("mklinikaIn")) {
                    sendPhoto(AdviceController.photoController(data, chat_id, userid));
                    return;

                }
//            ===============================Intencive=====================
                else if (userstep.get(userid).equals("intencive")) {
                    editmes(IntenciveController.retunIntenciveStepIn(userid, chat_id, data));
                    return;
                } else if (userstep.get(userid).equals("intencive/In")) {
                    editmes(TumanController.retunDistrict(userstep.get(userid), data, chat_id, userid, "iklinika"));
                    return;
                } else if (userstep.get(userid).equals("iklinika")) {
                    editmes(ClinicController.retunClincs(data, chat_id, userid, "iklinikaIn"));
                    if (stepclin.containsKey(userid)) {
                        stepclin.replace(userid, data);
                    } else {
                        stepclin.put(userid, data);
                    }
                    return;
                } else if (userstep.get(userid).equals("iklinikaIn")) {
                    sendPhoto(IntenciveController.photoController(data, chat_id, userid));
                    return;

                }

            } else if (userState.get(update.getCallbackQuery().getFrom().getId().toString()).equals(UserState.RU.name())) {
                String userid = update.getCallbackQuery().getFrom().getId().toString();
                Integer chat_id = update.getCallbackQuery().getMessage().getMessageId();
                String data = update.getCallbackQuery().getData();
                if (data.startsWith("answer")) {
                    ans = data;
                    sendmes(TaklifController.retunAnswer());
                }
                if (data.equals("back")) {
                    sendmes(ClinicController.retunClincsrr(stepclin.get(userid), chat_id, userid));
                    userstep.replace(userid, "aklinikaIn");
                    return;
                }

//            ==========================check========================
                switch (data) {
                    case "analiz": {
                        editmes(AnalizController.retunAnalizStepRu(userid, chat_id, data, userState.get(userid)));
                        return;
                    }
                    case "diagnostika": {
                        editmes(DiagnostikController.retunDiagnostikStepRu(userid, chat_id, data, userState.get(userid)));
                        return;
                    }
                    case "circle": {
                        editmes(CircleController.retunCircleStepRu(userid, chat_id, data, userState.get(userid)));
                        return;
                    }
                    case "maslahat": {
                        editmes(AdviceController.retunAdviceStepRu(userid, chat_id, data, userState.get(userid)));
                        return;
                    }
                    case "intencive": {
                        editmes(IntenciveController.retunIntenciveStepRu(userid, chat_id, data, userState.get(userid)));
                        return;
                    }
                    case "📋 Мену": {
                        if (!userstep.containsKey(userid)) {
                            userstep.put(userid, "start");
                        } else {
                            userstep.replace(userid, "start");
                        }
                        sendMessage.setChatId(userid);
                        sendMessage.setText("*Мену раздел*");
                        sendMessage.setParseMode("Markdown");
                        sendMessage.setReplyMarkup(ServiceButton.retunMenuButton());
                        sendmes(sendMessage);
                        break;

                    }
                }
//            =======================analiz==========================
                if (userstep.get(userid).equals("analiz")) {
                    editmes(AnalizController.retunAnalizInStepRU(userid, chat_id, data, userstep.get(userid)));
                    return;
                } else if (userstep.get(userid).equals("analiz/In")) {
                    editmes(TumanController.retunDistrictRu(userstep.get(userid), data, chat_id, userid, "aklinika"));
                    return;
                } else if (userstep.get(userid).equals("aklinika")) {
                    editmes(ClinicController.retunClincsRu(data, chat_id, userid, "aklinikaIn"));
                    if (stepclin.containsKey(userid)) {
                        stepclin.replace(userid, data);
                    } else {
                        stepclin.put(userid, data);
                    }
                    return;
                } else if (userstep.get(userid).equals("aklinikaIn")) {
                    sendPhoto(AnalizController.photoControllerRu(data, chat_id, userid));
                    return;

                } else if (userstep.get(userid).equals("lokatsiya")) {
                    String datasp = data.substring(9);
                    String[] dataarray = datasp.split("/");
                    SendLocation sendLocation = new SendLocation();
                    sendLocation.setChatId(userid);
                    sendLocation.setLatitude(Double.valueOf(dataarray[1]));
                    sendLocation.setLongitude(Double.valueOf(dataarray[0]));
                    sendLocation.setReplyMarkup(MakeButton.readybutton(MakeButton.collection(MakeButton.rows(MakeButton.makebutton("🏠  Бош меню", "📋 Мену")),
                            MakeButton.rows(MakeButton.makebutton("Cлиники", "back")))));
                    userstep.replace(userid, "start");
                    try {
                        execute(sendLocation);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }

                    return;
                }
                //            =============================24/7==============
                else if (userstep.get(userid).equals("circle")) {
                    editmes(CircleController.retunCircleStepInRu(userid, chat_id, data));
                    return;
                } else if (userstep.get(userid).equals("circle/In")) {
                    editmes(TumanController.retunDistrictRu(userstep.get(userid), data, chat_id, userid, "cklinika"));
                    return;
                } else if (userstep.get(userid).equals("cklinika")) {
                    editmes(ClinicController.retunClincsRu(data, chat_id, userid, "cklinikaIn"));
                    if (stepclin.containsKey(userid)) {
                        stepclin.replace(userid, data);
                    } else {
                        stepclin.put(userid, data);
                    }
                    return;
                } else if (userstep.get(userid).equals("cklinikaIn")) {
                    sendPhoto(CircleController.photoControllerRu(data, chat_id, userid));
                    return;

                }

                //            =============================diagnostika==============


                else if (userstep.get(userid).equals("diagnostika")) {
                    editmes(DiagnostikController.retunretunDiagnostikStepInStepRu(userid, chat_id, data));
                    return;
                } else if (userstep.get(userid).equals("diagnostika/In")) {
                    editmes(TumanController.retunDistrictRu(userstep.get(userid), data, chat_id, userid, "dklinika"));
                    return;
                } else if (userstep.get(userid).equals("dklinika")) {
                    editmes(ClinicController.retunClincsRu(data, chat_id, userid, "dklinikaIn"));
                    if (stepclin.containsKey(userid)) {
                        stepclin.replace(userid, data);
                    } else {
                        stepclin.put(userid, data);
                    }
                    return;
                } else if (userstep.get(userid).equals("dklinikaIn")) {
                    sendPhoto(DiagnostikController.photoControllerRu(data, chat_id, userid));
                    return;

                }

//            =======================Advice=================

                else if (userstep.get(userid).equals("maslahat")) {
                    editmes(TumanController.retunDistrictRu(userstep.get(userid), data, chat_id, userid, "mklinika"));
                    return;
                } else if (userstep.get(userid).equals("mklinika")) {
                    editmes(ClinicController.retunClincsRu(data, chat_id, userid, "mklinikaIn"));
                    if (stepclin.containsKey(userid)) {
                        stepclin.replace(userid, data);
                    } else {
                        stepclin.put(userid, data);
                    }
                    return;
                } else if (userstep.get(userid).equals("mklinikaIn")) {
                    sendPhoto(AdviceController.photoControllerRu(data, chat_id, userid));
                    return;

                }
//            ===============================Intencive=====================
                else if (userstep.get(userid).equals("intencive")) {
                    editmes(IntenciveController.retunIntenciveStepInRu(userid, chat_id, data));
                    return;
                } else if (userstep.get(userid).equals("intencive/In")) {
                    editmes(TumanController.retunDistrictRu(userstep.get(userid), data, chat_id, userid, "iklinika"));
                    return;
                } else if (userstep.get(userid).equals("iklinika")) {
                    editmes(ClinicController.retunClincsRu(data, chat_id, userid, "iklinikaIn"));
                    if (stepclin.containsKey(userid)) {
                        stepclin.replace(userid, data);
                    } else {
                        stepclin.put(userid, data);
                    }
                    return;
                } else if (userstep.get(userid).equals("iklinikaIn")) {
                    sendPhoto(IntenciveController.photoControllerRu(data, chat_id, userid));
                    return;

                }

            }
        }


//        =============================hasMessage ===============================


    }


    @Override
    public String getBotUsername() {
        return "";
    }

    @Override
    public String getBotToken() {
        return "";
    }

    public void sendmes(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    public void editmes(EditMessageText editMessageText) {
        try {
            execute(editMessageText);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public void sendPhoto(SendPhoto sendPhoto) {
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


}
