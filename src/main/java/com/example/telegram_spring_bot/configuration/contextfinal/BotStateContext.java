package com.example.telegram_spring_bot.configuration.contextfinal;

public final class BotStateContext {
    public static String CURRENT_BOT_STATEMENT = "MENU";

    public static final String MENU = "MENU";
    public static final String LITRES_KILOMETERS_FORK ="LITRES_KILOMETERS_FORK";
    public static final String GET_VAR ="GET_VAR";
    public static final String CITY_TRACE_FORK="CITY_TRACE_FORK";

    public static boolean isChooseKilometresLitres(){
            if(CURRENT_BOT_STATEMENT.equals(BotCommandsContext.CHOOSE_LITRES)||CURRENT_BOT_STATEMENT.equals(BotCommandsContext.CHOOSE_KILOMETERS)){
                return true;
            }
            return false;
        }
}
