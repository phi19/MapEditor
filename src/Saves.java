import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.Map;

public class Saves {

    private static String file;
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;

    private static FileWriter fileWriter;
    private static BufferedWriter bufferedWriter;

    public static void load() {
        try {
            file = "resources//save.txt";
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            Color[] values = new Color[Grid.getGridSideLength()*Grid.getGridSideLength()];
            int counter = 0;

            String line = bufferedReader.readLine();
            while (line != null) {
                values[counter] = ConvertToColors.stringToColor(line);
                counter++;
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            Grid.loadSquares(values);
        } catch (IOException exception) {
            System.out.println("File not found");
        }
    }

    public static void save() {
        try {
            file = "resources//save.txt";
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<Rectangle, Color> entry : Grid.getMap().entrySet()) {
                bufferedWriter.write(ConvertToColors.colorToString(entry.getValue()) + "\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException exception) {
            System.out.println("File not found");
        }

    }

    public static class ConvertToColors {

        public static String colorToString(Color color) {
            if (color == Color.YELLOW) {
                return "YELLOW";
            } else if (color == Color.RED) {
                return "RED";
            } else if (color == Color.PINK) {
                return "PINK";
            } else if (color == Color.ORANGE) {
                return "ORANGE";
            } else if (color == Color.MAGENTA) {
                return "MAGENTA";
            } else if (color == Color.GRAY) {
                return "GRAY";
            } else if (color == Color.CYAN) {
                return "CYAN";
            } else if (color == Color.BLUE) {
                return "BLUE";
            } else if (color == Color.BLACK) {
                return "BLACK";
            } else if (color == Color.GREEN) {
                return "GREEN";
            } else {
                return "WHITE";
            }
        }

        public static Color stringToColor(String string) {
            switch (string) {
                case "YELLOW":
                    return Color.YELLOW;
                case "RED":
                    return Color.RED;
                case "PINK":
                    return Color.PINK;
                case "ORANGE":
                    return Color.ORANGE;
                case "MAGENTA":
                    return Color.MAGENTA;
                case "GRAY":
                    return Color.GRAY;
                case "CYAN":
                    return Color.CYAN;
                case "BLUE":
                    return Color.BLUE;
                case "BLACK":
                    return Color.BLACK;
                case "GREEN":
                    return Color.GREEN;
                default:
                    return Color.WHITE;
            }
        }
    }
}
