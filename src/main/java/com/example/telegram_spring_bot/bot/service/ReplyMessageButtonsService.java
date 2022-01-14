package com.example.telegram_spring_bot.bot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.bots.AbsSender.*;
import java.util.List;

@Component
public class ReplyMessageButtonsService {

    public SendMessage sendInlineKeyBoardMessage(Message message, List<List<InlineKeyboardButton>> buttons, String messageText) throws TelegramApiException {
        return (SendMessage.builder()
                .text(messageText)
                .chatId(message.getChatId().toString())
                .replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build())
                .build());


    }

}