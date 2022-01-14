package com.example.telegram_spring_bot.bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ReplyMessageService {

    public SendMessage sendMessage(Message message,String messageText){
        return (SendMessage.builder()
                .text(messageText)
                .chatId(message.getChatId().toString())
                .build());


    }
}
