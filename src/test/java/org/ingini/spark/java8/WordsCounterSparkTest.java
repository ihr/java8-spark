/*
 *
 *  * Copyright (c) 2015 Ivan Hristov <hristov[DOT]iv[AT]gmail[DOT]com>
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  * 	http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package org.ingini.spark.java8;

import com.google.common.hash.Hashing;
import com.google.common.io.Files;
import org.junit.Test;
import scala.Tuple2;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class WordsCounterSparkTest implements Serializable {

    @Test
    public void count() throws IOException {
        //GIVEN
        String source = "src/test/resources/gutenberg/4300.txt";
        WordsCounterSpark wordsCounterSpark = new WordsCounterSpark();

        //WHEN
        List<Tuple2<String, Integer>> result = wordsCounterSpark.count(source);

        //THEN

        assertThat(Files.hash(new File(Utils.writeToFile("target/spark_output.txt", result)), Hashing.md5()).toString())
                .isEqualTo("18be35505e1799b1f49af1b99c2b40c5");

    }
}
