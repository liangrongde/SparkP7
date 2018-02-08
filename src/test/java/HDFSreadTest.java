import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HDFSreadTest {

    public static String hdfsread () throws IOException {
        Configuration conf = new Configuration();

        conf.set("fs.defaultFS","hdfs://172.19.30.7:9000");

        FileSystem fs = null;
        try {
            fs = FileSystem.get(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }

        FSDataInputStream fsin = null;
        try {
            fsin = fs.open(new Path("/user/hadoop/testdata/input/new_file_1"));
        } catch (IOException e) {
            e.printStackTrace();
        }

//        byte[] buff = new byte[10];
//        int readcount = 0;
//
//        String a = null;
//        try {
//            fsin.read(buff);
//            a = new String(buff);
//            System.out.println(a);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("The first");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fsin));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            System.out.println("123");
        }

        return line;
    }
}
