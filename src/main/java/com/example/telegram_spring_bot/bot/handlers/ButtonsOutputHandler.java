package com.example.telegram_spring_bot.bot.handlers;

import com.example.telegram_spring_bot.configuration.contextfinal.BotCommandsContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ButtonsOutputHandler {
    List<List<InlineKeyboardButton>> buttonsChooseLitresKilometers = new ArrayList<>();
    List<List<InlineKeyboardButton>> buttonsChooseTraceCity = new ArrayList<>();

    public ButtonsOutputHandler() {
        buttonsChooseLitresKilometers.add(Arrays.asList(

                InlineKeyboardButton.builder().text("Литры").callbackData(BotCommandsContext.CHOOSE_LITRES).build(),
                InlineKeyboardButton.builder().text("Километры").callbackData(BotCommandsContext.CHOOSE_KILOMETERS).build()

        ));

        buttonsChooseTraceCity.add(Arrays.asList(
                InlineKeyboardButton.builder().text("По трассе").callbackData(BotCommandsContext.CHOOSE_TRACE).build(),
                InlineKeyboardButton.builder().text("В городе").callbackData(BotCommandsContext.CHOOSE_CITY).build()
        ));
    }

    public List<List<InlineKeyboardButton>> getButtonsChooseLitresKilometers() {
        return buttonsChooseLitresKilometers;
    }

    public List<List<InlineKeyboardButton>> getButtonsChooseTraceCity() {
        return buttonsChooseTraceCity;
    }


}
