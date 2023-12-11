wordcount_sample = LOAD '/home/hadoop/practicals/pig/wordcount.txt' AS (line:Chararray);
Words = FOREACH wordcount_sample GENERATE FLATTEN(TOKENIZE(line,' ')) AS word;
Grouped = GROUP Words BY word;
wordcount_result = FOREACH Grouped GENERATE COUNT(Words),group;
dump wordcount_result;