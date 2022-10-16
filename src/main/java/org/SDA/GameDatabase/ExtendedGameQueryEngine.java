package org.SDA.GameDatabase;

public class ExtendedGameQueryEngine extends GameQueryEngine {
    @Override
    public void registerQueries() {
        super.registerQueries();

        queries.add(new GameQueryInterface() {
            @Override
            public String getCommand() {
                return null;
            }

            @Override
            public String run(VideoGame[] games, Object parameter) {
                return null;
            }
        });
    }
}
