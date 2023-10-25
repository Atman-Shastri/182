import java.io.IOException;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AvgReducer extends Reducer<Text, FloatWritable, Text, FloatWritable> {
	float wordCount = 0.0f;
	float sum=0.0f;
@Override

	public void reduce(Text key, Iterable<FloatWritable> values, Context context)  throws IOException, InterruptedException {
		
		for (FloatWritable value : values) {
			wordCount += value.get();
			
		}
		sum=sum+1;
		
		context.write(key, new FloatWritable(wordCount/sum));
	}
}