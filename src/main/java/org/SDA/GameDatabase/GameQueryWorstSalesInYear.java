package org.SDA.GameDatabase;

public class GameQueryWorstSalesInYear implements GameQueryInterface {
    @Override
    public String run(VideoGame[] games, Object parameter) {
        Integer year = (Integer) parameter;
        VideoGame worst = null;

        for (VideoGame game : games) {
            if (!game.getReleaseYear().equals(year)) {
                continue;
            }

            if (worst == null || worst.getSoldUnitsInMillions() > game.getSoldUnitsInMillions()) {
                worst = game;
            }
        }

        if (worst != null) {
            return worst.getTitle();
        }
        else {
            return "NOT FOUND";
        }
    }

    @Override
    public String getCommand() {
        return "worst_sales_year %d";
    }
}
