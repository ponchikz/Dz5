import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class CreateFileClass {
    public static ArrayList<FIleObject> fIleObjectArrayList = new ArrayList();
    public static final String title = "value1;value2;value3;" + "\n";


    public CreateFileClass() {
    }

    public static void main(String[] args) throws IOException {
        createFileObjects();
        writeStream();
        System.out.print(title);
        AppData appData = readToObject();
    }

    public static void createFileObjects() {
        Random random = new Random();

        for(int i = 0; i < 5; ++i) {
            fIleObjectArrayList.add(new FIleObject(random.nextInt(1000), random.nextInt(1000), random.nextInt(1000)));
        }

    }

    public static void writer() throws IOException {
        FileWriter writer = new FileWriter("src/demo.csv");

        try {
            writer.write(title);
            Iterator var = fIleObjectArrayList.iterator();

            while(var.hasNext()) {
                FIleObject fIleObject = (FIleObject)var.next();
                Integer var1 = fIleObject.getValue();
                writer.write("" + var1 + ";" + fIleObject.getValueFrom() + ";" + fIleObject.getValueFrom() + ";" + "\n");
            }
        } catch (Throwable var2) {
            try {
                writer.close();
            } catch (Throwable var3) {
                var2.addSuppressed(var3);
            }

            throw var2;
        }

        writer.close();
    }

    public static void writeStream() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("src/demo.csv");

        try {
            byte[] var = title.getBytes(StandardCharsets.UTF_8);
            int var1 = var.length;

            for(int var2 = 0; var2 < var1; ++var2) {
                byte b = var[var2];
                fileOutputStream.write(b);
            }

            Iterator var3 = fIleObjectArrayList.iterator();

            while(var3.hasNext()) {
                FIleObject fIleObject = (FIleObject)var3.next();
                Integer var4 = fIleObject.getValue();
                String raw = "" + var4 + ";" + fIleObject.getValueFrom() + ";" + fIleObject.getValueTo() +  ";" + "\n";
                byte[] var5 = raw.getBytes(StandardCharsets.UTF_8);
                int var7 = var5.length;

                for(int var6 = 0; var6 < var7; ++var6) {
                    byte b = var5[var6];
                    fileOutputStream.write(b);
                }
            }
        } catch (Throwable var8) {
            try {
                fileOutputStream.close();
            } catch (Throwable var9) {
                var8.addSuppressed(var9);
            }

            throw var8;
        }

        fileOutputStream.close();
    }

    public static AppData readToObject() throws IOException {
        AppData appData = new AppData();
        List<List<String>> records = new ArrayList();
        BufferedReader br = new BufferedReader(new FileReader("src/demo.csv"));


        try {
            String line = br.readLine();
            appData.setHeader(line.split(";"));

            while((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }
        } catch (Throwable var) {
            try {
                br.close();
            } catch (Throwable var1) {
                var.addSuppressed(var1);
            }

            throw var;
        }
        br.close();


        int[][] resultData = new int[records.size()][3];

        for(int i = 0; i < records.size(); ++i) {
            for(int j = 0; j < ((List)records.get(i)).size(); ++j) {
                resultData[i][j] = Integer.valueOf((String)((List)records.get(i)).get(j));


            }
            System.out.println(records.get(i));
        }
        appData.setData(resultData);
        return appData;
    }
}