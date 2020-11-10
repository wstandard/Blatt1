package de.unitrier.st.core;

import java.io.*;

public class DataLoader {

    public String loadJsonFile(String name) {
        File file = new File(getClass().getResource("/"+name).getFile());
        StringBuilder json = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String str;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                json.append(str);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(json.length());

        return json.toString();
    }

}
