package org.SDA.GameDatabase;

import com.google.gson.Gson;

import java.io.*;

public class GameDatabaseJSON implements GameDatabaseInterface {
    @Override
    public VideoGame[] readVideoGames(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String jsonString = "";
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                jsonString += "\n" + currentLine;
            }

            Gson gson = new Gson();
            Class<VideoGame[]> clazz = VideoGame[].class;
            VideoGame[] games = gson.fromJson(jsonString, clazz);
            return games;
        } catch (IOException e) {
            System.out.println("Error");
            return null;
        }
    }

    @Override
    public void saveVideoGames(String filePath, VideoGame[] games) {
        Gson gson = new Gson();
        String jsonString = gson.toJson(games);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(jsonString);
            bw.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
