package org.SDA.GameDatabase;

public class GameQueryGenreAmount implements GameQueryInterface {
    @Override
    public String run(VideoGame[] games, Object parameter) {
        String genre = (String) parameter;
        Integer amount = 0;

        for (VideoGame game : games) {
            if (game.getGenre().equals(genre)) {
                amount++;
            }
        }

        return amount.toString();
    }

    @Override
    public String getCommand() {
        return "genre_amount %s";
    }
}
