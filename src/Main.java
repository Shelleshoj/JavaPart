import java.io.*;


public class Main {
    private static ProcessBuilder pb;
    private static Process process;
    private static BufferedReader reader;
    private static BufferedWriter writer;

    public static void main(String[] args) throws IOException{//TransformException
        pb = new ProcessBuilder();
        pb.command("C:/Users/svend/CLionProjects/untitled/cmake-build-debug/untitled.exe");  // C++ executable
        process = pb.start();
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        ReaderThread rd = new ReaderThread(reader);
        rd.start();

        while(true){
            String input = inputReader.readLine();
            String lineToSend;
            switch(input.toLowerCase()){
                case "run":
                    String arg1 = "first";
                    String arg2 = "second";
                    lineToSend = "runExample"+" " + arg1 + " "+  arg2 + "\n";
                    writer.write(lineToSend);
                    writer.flush();
                    break;
            }
        }
    }
}

