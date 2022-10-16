package org.SDA.GameDatabase;

public class GameQueryBestsellerTitle implements GameQueryInterface {
    @Override
    public String run(VideoGame[] games, Object parameter) {
        VideoGame bestseller = null;

        for (VideoGame game : games) {
            if (bestseller == null || bestseller.getSoldUnitsInMillions() < game.getSoldUnitsInMillions()) {
                bestseller = game;
            }
        }

        if (bestseller != null) {
            return bestseller.getTitle();
        }
        else {
            return "NOT FOUND";
        }
    }

    @Override
    public String getCommand() {
        return "best_sales_ever_title";
    }
}
