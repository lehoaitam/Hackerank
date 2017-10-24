package temp;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex {
    public static final String EXAMPLE_TEST = "" +
            "This is plans lands small lander string which I'm going to use for pattern matching.";

    public static final String EXAMPLE_TEST2 = "baaaaaaaaaaaab";

    public static void main3(String[] args){
        File inputFile = new File("./resource/test.txt");
        String outputFileName = "./resource/test_processed.txt";
        String regexPattern = "\\w*(lan)\\w+";
        String replacement = "<-replaced->";
        doTask(inputFile, outputFileName, regexPattern,replacement);
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("\\w*(lan)\\w+");
//        Pattern pattern = Pattern.compile("ba*b");
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        System.out.println("group count:" + matcher.groupCount());
//        System.out.println("group count:" + matcher.groupCount());
        // check all occurance
        int count = 0;
        if(matcher.find()){

        }
        while (matcher.find()) {
            count++;
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
        }
        System.out.println("count:" + count);
//        System.out.println("group count:" + matcher.groupCount());
        // now create a new pattern and matcher to replace whitespace with tabs
        Pattern replace = Pattern.compile("\\w*(lan)\\w+");

        Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
        System.out.println(matcher2.replaceAll("<-replaced->"));
    }


    public static void main2(String[] args){
        long startTime = System.nanoTime();
        String patternStr = "\\w*(lan)\\w+";
        String replacement = "<-replaced->";
        int BUFFER_LENGTH = 4096;
        try{

            BufferedWriter writter = new BufferedWriter(new FileWriter("./resource/test-processed.txt"), 4096);
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream("./resource/test.txt"));
            byte[] buffer = new byte[BUFFER_LENGTH];
            int readLength;
            byte[] joinBuffer = null;
            //divide whole file into chunks to deal with large file
            //process data include current chunk and small buffer around a cut between two chunks,
            //because regex pattern may fall into cut between two chunks.
            while ((readLength = reader.read(buffer)) != -1) {
                //make buffer from current chunk
                byte[] currentBuffer = Arrays.copyOfRange(buffer,0,readLength);
                //make process data
                String str;
                if(joinBuffer != null) {
                    //concat joinBuffer and currentBuffer together
                    byte[] processBuffer = new byte[joinBuffer.length + currentBuffer.length];
                    System.arraycopy(joinBuffer, 0, processBuffer, 0, joinBuffer.length);
                    System.arraycopy(currentBuffer, 0, processBuffer, joinBuffer.length, currentBuffer.length);
                    //process data are (joinBuffer and currentBuffer)
                    str = new String(processBuffer,0,processBuffer.length);
                }else
                    //process only read data in case of first chunk
                    str = new String(currentBuffer,0,currentBuffer.length);

                Pattern pattern = Pattern.compile(patternStr);
                Matcher matcher = pattern.matcher(str);
                //detect match group of given pattern is not equal to 1
                if(matcher.groupCount() != 1)
                    System.exit(1);
                //replace by replacement if pattern was found
                if(matcher.find()) {
                    str = str.replaceAll(matcher.group(1), replacement);
                }
                //write final string to buffer
                writter.write(str);

                //reserve small buffer arround cut between chunk.
                joinBuffer = Arrays.copyOfRange(buffer, readLength - patternStr.length(), readLength);
            }
            //flush to output file
            writter.flush();
            writter.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");


    }
    public static void main1(String[] args){
        walkFilesystemBFS(new File("./resource"));
    }

    public static void walkFilesystemDFS(File file)
    {
        for(File f : file.listFiles())
        {
            if(f.isDirectory())
            {
                System.out.println(file.getAbsolutePath()+" (Directory)");
                walkFilesystemDFS(f);
            }
            else if(f.isFile())
            {
                System.out.println(file.getAbsolutePath()+" (node)");
            }
        }
    }

    public static void walkFilesystemBFS(File f)
    {

        Queue<File> queue = new LinkedList<>();
        queue.add(f);
        while(!queue.isEmpty()){
            File currentNode = queue.poll();
            for(File file : currentNode.listFiles()){
                if(file.isDirectory())
                {
//                    System.out.println(file.getAbsolutePath()+" (Directory)");
                    queue.add(file);
                }
                else if(file.isFile())
                {
                    try {
                        System.out.println(file.getCanonicalPath() + ":can");
                        System.out.println(file.getAbsolutePath() + ":abs");
                    }catch (Exception e){

                    }
                }
            }
        }

    }

    static int BUFFER_LENGTH = 4096;

    public static void doTask(File inputFile, String outputFileName, String regexPattern, String replacement){
        long startTime = System.nanoTime();
        String inputFileName = inputFile.getAbsolutePath();
        regexPattern = regexPattern.replaceAll("\\\\", "\\\\\\\\");
//        "regexPattern.replace("\\", "\\\\");
        try{

            BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName), BUFFER_LENGTH);
            BufferedInputStream reader = new BufferedInputStream(new FileInputStream(inputFileName));
            byte[] buffer = new byte[BUFFER_LENGTH];
            int readLength;
            byte[] joinBuffer = null;
            //divide whole file into chunks to deal with large file
            //process data include current chunk and small buffer around a cut between two chunks,
            //because regex pattern may fall into cut between two chunks.
            while ((readLength = reader.read(buffer)) != -1) {
                //make buffer from current chunk
                byte[] currentBuffer = Arrays.copyOfRange(buffer,0,readLength);
                //make process data
                String str;
                if(joinBuffer != null) {
                    //concat joinBuffer and currentBuffer together
                    byte[] processBuffer = new byte[joinBuffer.length + currentBuffer.length];
                    System.arraycopy(joinBuffer, 0, processBuffer, 0, joinBuffer.length);
                    System.arraycopy(currentBuffer, 0, processBuffer, joinBuffer.length, currentBuffer.length);
                    //process data are (joinBuffer and currentBuffer)
                    str = new String(processBuffer,0,processBuffer.length);
                }else
                    //process only read data in case of first chunk
                    str = new String(currentBuffer,0,currentBuffer.length);

                Pattern pattern = Pattern.compile(regexPattern);
                Matcher matcher = pattern.matcher(str);
                //detect match group of given pattern is not equal to 1
                if(matcher.groupCount() != 1)
                    System.exit(1);
                //get stats info
                String foundPattern = null;
                while(matcher.find()) {
                    if(foundPattern == null)
                        foundPattern = matcher.group(1);
                    if(!Logger.map.containsKey(matcher.group(0)))
                        Logger.map.put(matcher.group(0),0);
                    int currentCount = Logger.map.get(matcher.group(0));
                    Logger.map.put(matcher.group(0), currentCount + 1);

                }
                //replace for all match pattern by replacement if only one pattern  was found
                if(foundPattern != null)
                    str = str.replaceAll(foundPattern, replacement);

                //write final string to buffer
                writter.write(str);

                //reserve small buffer arround cut between chunk.
                joinBuffer = Arrays.copyOfRange(buffer, readLength - regexPattern.length(), readLength);
            }
            //flush to output file
            writter.flush();
            writter.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        long elapsedTimeInMillis = TimeUnit.MILLISECONDS.convert((endTime - startTime), TimeUnit.NANOSECONDS);
        System.out.println("Total elapsed time: " + elapsedTimeInMillis + " ms");
    }

}
