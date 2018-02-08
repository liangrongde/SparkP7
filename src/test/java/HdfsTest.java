import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;


public class HdfsTest {

    public static void main (String[] args) throws IOException {

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
            fsin = fs.open(new Path("/user/hadoop/testdata/input/new_file_2"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] buff = new byte[1024];
        int readcount = 0;
        try {
            readcount = fsin.read(buff);
            while (readcount != -1) {
                String a = new String(buff);
                System.out.print(a);
                readcount = fsin.read(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("This is the end");


        fsin.close();
        fs.close();

    }
}
