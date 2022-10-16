package org.SDA.GameDatabase;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameDatabaseTSV implements GameDatabaseInterface {
    @Override
    public VideoGame[] readVideoGames(String filePath) {
        List<String[]> rows = new ArrayList<>();

        try {
            CSVReader csvReader = new CSVReader(new FileReader(filePath), '\t');
            String[] nextRow;

            while ((nextRow = csvReader.readNext()) != null) {
                rows.add(nextRow);
            }

            return rowsToGames(rows);
        } catch (IOException e) {
            System.out.println("Error");
            return null;
        }
    }

    @Override
    public void saveVideoGames(String filePath, VideoGame[] games) {
        try {
            CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath), '\t');
            csvWriter.writeAll(gamesToRows(games));
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    private List<String[]> gamesToRows(VideoGame[] games) {
        List<String[]> rows = new ArrayList<>();
        for (VideoGame game : games) {
            rows.add(gameToRow(game));
        }
        return rows;
    }

    private String[] gameToRow(VideoGame game) {
        return new String[] { game.getTitle(), game.getGenre(), game.getReleaseYear().toString(),
                game.getSoldUnitsInMillions().toString() };
    }

    private VideoGame[] rowsToGames(List<String[]> rows) {
        VideoGame[] games = new VideoGame[rows.size()];

        for (int i = 0; i < rows.size(); i++) {
            games[i] = rowToGame(rows.get(i));
        }

        return games;
    }

    private VideoGame rowToGame(String[] row) {
        return new VideoGame(row[0], row[1], Integer.parseInt(row[2]), Double.parseDouble(row[3]));
    }
}
