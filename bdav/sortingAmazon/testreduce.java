import java.io.IOException;
import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.mapreduce.Reducer;

public class testreduce extends Reducer<IntWritable, IntWritable,
IntWritable, IntWritable> {
@Override
        public void reduce(IntWritable key, Iterable<IntWritable> values,
Context context)  throws IOException, InterruptedException {

        for (IntWritable value : values) {

            context.write(value,key);

           }

}
}