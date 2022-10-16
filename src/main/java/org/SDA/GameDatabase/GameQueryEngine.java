package org.SDA.GameDatabase;

import java.util.ArrayList;
import java.util.List;

public class GameQueryEngine {
    protected List<GameQueryInterface> queries;

    public GameQueryEngine() {
        queries = new ArrayList<>();
        registerQueries();
    }

    public void registerQueries() {
        // All-time bestseller query
        queries.add(new GameQueryInterface() {
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
        });

        // Amount of games in genre query
        queries.add(new GameQueryInterface() {
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
        });

        // Worst sales in given year query
        queries.add(new GameQueryInterface() {
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
        });
    }
}
