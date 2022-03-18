package com.company.yaqinklinikaadminpage.bot.buttons;

import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public  class ManuButton {
    public static ReplyKeyboard menuKeyboard() {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setResizeKeyboard(true);
        keyboard.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow firstRow = new KeyboardRow();
        String emojitext = EmojiParser.parseToUnicode(":clipboard:" + " " + "Хизматлар");
        String emojitext1 = EmojiParser.parseToUnicode(":memo:" + " " + "Мурожаат");
        String emojitext3 = EmojiParser.parseToUnicode(":gear:" + " " + "Созламалар");
        firstRow.add(new KeyboardButton(emojitext));
        firstRow.add(new KeyboardButton(emojitext1));

        KeyboardRow secondRow = new KeyboardRow();
        secondRow.add(new KeyboardButton(emojitext3));

        KeyboardRow thirdRow = new KeyboardRow();
        keyboardRowList.add(firstRow);
        keyboardRowList.add(secondRow);
        keyboardRowList.add(thirdRow);
        keyboard.setKeyboard(keyboardRowList);
        return keyboard;
    }
    public static ReplyKeyboard menuKeyboardRu() {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setResizeKeyboard(true);
        keyboard.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow firstRow = new KeyboardRow();
        String emojitext = EmojiParser.parseToUnicode(":clipboard:" + " " + "сервисы");
        String emojitext1 = EmojiParser.parseToUnicode(":memo:" + " " + "жалобы");
        String emojitext3 = EmojiParser.parseToUnicode(":gear:" + " " + "настройки");
        firstRow.add(new KeyboardButton(emojitext));
        firstRow.add(new KeyboardButton(emojitext1));

        KeyboardRow secondRow = new KeyboardRow();
        secondRow.add(new KeyboardButton(emojitext3));

        KeyboardRow thirdRow = new KeyboardRow();
        keyboardRowList.add(firstRow);
        keyboardRowList.add(secondRow);
        keyboardRowList.add(thirdRow);
        keyboard.setKeyboard(keyboardRowList);
        return keyboard;
    }
    public static ReplyKeyboard languageKeyboard() {
        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setResizeKeyboard(true);
        keyboard.setOneTimeKeyboard(false);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();

        KeyboardRow firstRow = new KeyboardRow();
        String emojitext = EmojiParser.parseToUnicode(":uz:" + " " + "УЗ");
        String emojitext1 = EmojiParser.parseToUnicode(":ru:" + " " + "РУ");
        firstRow.add(new KeyboardButton(emojitext));
        firstRow.add(new KeyboardButton(emojitext1));

        KeyboardRow secondRow = new KeyboardRow();
        KeyboardRow thirdRow = new KeyboardRow();
        keyboardRowList.add(firstRow);
        keyboardRowList.add(secondRow);
        keyboardRowList.add(thirdRow);
        keyboard.setKeyboard(keyboardRowList);
        return keyboard;
    }
}
