package org.SDA.GameDatabase;

public interface GameQueryInterface {
    String getCommand();
    String run(VideoGame[] games, Object parameter);
}
