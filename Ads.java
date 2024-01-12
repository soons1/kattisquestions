import java.io.*;
import java.util.*;

public class Ads {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] token = br.readLine().split(" ");
        int H = Integer.parseInt(token[0]);
        int W = Integer.parseInt(token[1]);

        char[][] image = new char[H][W];

        for (int i = 0; i < H; i++) {
            String chars = br.readLine();
            for (int j = 0; j < W; j++) {
                image[i][j] = chars.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (image[i][j] != '+') {
                    continue;
                }

                int lastJ = j + 1;
                while (lastJ < W) {
                    if (image[i][lastJ] != '+') {
                        break;
                    }
                    lastJ++;
                }

                int lastI = i + 1;
                while (lastI < H) {
                    if (image[lastI][j] != '+') {
                        break;
                    }
                    lastI++;
                }

                boolean toClear = false;
                for (int adI = i + 1; adI < lastI - 1; adI++) {
                    for (int adJ = j + 1; adJ < lastJ - 1; adJ++) {
                        char toCheck = image[adI][adJ];
                        if (Character.isLetterOrDigit(toCheck) || toCheck == '?' || toCheck == '!' || toCheck == ',' || toCheck == '.' || toCheck == ' ') { // check for illegal
                            toClear = true;// clear the image
                            break;
                        }
                    }
                }

                if (toClear) {
                    for (int clearI = i; clearI < lastI; clearI++) {
                        for (int clearJ = j; clearJ < lastJ; clearJ++) {
                            image[clearI][clearJ] = ' ';
                        }
                    }
                }

                j = lastJ + 1;
            }
        }

        for (int i = 0; i < H; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < W; j++) {
                sb.append(image[i][j]);
            }
            pw.println(sb.toString().trim());
        }

        br.close();
        pw.close();
    }
}