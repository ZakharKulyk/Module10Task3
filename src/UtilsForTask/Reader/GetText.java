package UtilsForTask.Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class GetText implements ReadingFile {
    File file;

    public GetText(File file) {
        this.file = file;
    }

    @Override
    public ArrayList<String> getText() {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;

    }
}
