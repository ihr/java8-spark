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

import scala.Tuple2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.TreeMap;

public class Utils {

    public static String writeToFile(String target, TreeMap<String, Long> source) throws IOException {
        try (
                FileWriter f = new FileWriter(new File(target))
        ) {
            source.forEach((s, aLong) -> writeTupleToFile(f, "(" + s + "," + aLong + ")\n"));
        }

        return target;
    }

    private static void writeTupleToFile(FileWriter file, String str) {
        try {
            file.write(str);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String writeToFile(String target, List<Tuple2<String, Integer>> source) throws IOException {
        try (
                FileWriter f = new FileWriter(new File(target))
        ) {
            source.forEach(tuple -> writeTupleToFile(f, "(" + tuple._1() + "," + tuple._2() + ")\n"));
        }

        return target;
    }

}
