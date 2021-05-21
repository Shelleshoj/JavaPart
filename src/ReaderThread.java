import java.io.BufferedReader;
import java.io.IOException;

class ReaderThread extends Thread {
    BufferedReader reader;

    public ReaderThread(BufferedReader reader) {
        this.reader = reader;
    }

    public void run() {
        try {
            String reply;
            System.out.println("Reader thread ready");
            while (true) {
                //while ((reply = reader.readLine()) != null) {
                reply = reader.readLine();
                    String[] replyAsArr = {"No reply"};
                    if (reply != null) {
                        replyAsArr = reply.split(" ");
                    } else System.out.println("Got reply: " + reply);
                    switch (replyAsArr[0]) {
                        case "result":
                            System.out.println("Got result");
                            break;
                        case "info":
                            System.out.println(reply);
                            break;
                        default:
                            System.out.println("Malformed input from cpp: " + reply);
                    }
                //}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}