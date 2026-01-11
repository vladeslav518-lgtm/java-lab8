import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        /* =======================
           ЗАДАНИЕ 1
           ======================= */

        task1_1(); // Пример 1
        task1_2(); // Пример 2
        task1_3(); // Пример 3
        task1_4(); // Пример 4
        task1_5(); // Пример 5
        task1_6(); // Пример 6
        task1_7(); // Пример 7
        task1_8(); // Пример 8
        task1_9(); // Пример 9
        task1_10(); // Пример 10

        /* =======================
           ЗАДАНИЕ 2
           ======================= */
        task2();

        /* =======================
           ЗАДАНИЕ 3
           ======================= */
        task3();
    }

    /* ---------- 1.1 ---------- */
    static void task1_1() {
        try {
            File f = new File("file1.txt");
            f.createNewFile();
            File dir = new File("Folder/SubFolder");
            dir.mkdirs();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* ---------- 1.2 ---------- */
    static void task1_2() {
        try (FileInputStream fis = new FileInputStream("file1.txt")) {
            int b;
            while ((b = fis.read()) != -1) {
                System.out.print((char) b);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* ---------- 1.3 ---------- */
    static void task1_3() {
        try (FileInputStream fis = new FileInputStream("file1.txt")) {
            byte[] buf = new byte[5];
            int n;
            while ((n = fis.read(buf)) != -1) {
                System.out.print(new String(buf, 0, n));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* ---------- 1.4 ---------- */
    static void task1_4() {
        try {
            DataOutputStream out = new DataOutputStream(
                    new FileOutputStream("numbers.dat"));
            out.writeDouble(2.5);
            out.writeDouble(-4.1);
            out.writeDouble(7.3);
            out.close();

            DataInputStream in = new DataInputStream(
                    new FileInputStream("numbers.dat"));

            try {
                while (true) {
                    System.out.println(in.readDouble());
                }
            } catch (EOFException e) {}
            in.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* ---------- 1.5 ---------- */
    static void task1_5() {
        try {
            DataOutputStream out = new DataOutputStream(
                    new FileOutputStream("strings.dat"));
            out.writeUTF("Первая строка");
            out.writeUTF("Вторая строка");
            out.close();

            DataInputStream in = new DataInputStream(
                    new FileInputStream("strings.dat"));
            System.out.println(in.readUTF());
            System.out.println(in.readUTF());
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* ---------- 1.6 ---------- */
    static void task1_6() {
        try {
            FileReader fr = new FileReader("file1.txt");
            FileWriter fw = new FileWriter("copy.txt", true);
            int c;
            while ((c = fr.read()) != -1) {
                fw.write(c);
            }
            fr.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* ---------- 1.7 ---------- */
    static void task1_7() {
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("file1.txt"));
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("result7.txt"));

            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                i++;
                bw.write(i + ": " + line);
                bw.newLine();
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* ---------- 1.8 ---------- */
    static void task1_8() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("file1.txt"), "UTF-8"));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* ---------- 1.9 ---------- */
    static void task1_9() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("file1.txt"), "UTF-8"));
            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("result9.txt"), "UTF-8"));

            String s;
            while ((s = br.readLine()) != null) {
                bw.write(s);
                bw.newLine();
            }
            br.close();
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* ---------- 1.10 ---------- */
    static void task1_10() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("file1.txt"), "UTF-8"));
            PrintWriter pw = new PrintWriter("result10.txt", "UTF-8");

            String s;
            int n = 0;
            while ((s = br.readLine()) != null) {
                n++;
                pw.println(n + ": " + s);
            }
            br.close();
            pw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* =======================
       ЗАДАНИЕ 2
       ======================= */
    static void task2() {
        try {
            PrintWriter pw = new PrintWriter("source.txt", "UTF-8");
            pw.println("Первая строка");
            pw.println("Вторая строка");
            pw.println(5.5);
            pw.println(-3.2);
            pw.println(7.1);
            pw.println(-1.0);
            pw.println(9.9);
            pw.close();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("source.txt"), "UTF-8"));
            PrintWriter out = new PrintWriter("result2.txt", "UTF-8");

            br.readLine(); // первая строка
            out.println(br.readLine()); // вторая строка

            String s;
            while ((s = br.readLine()) != null) {
                double d = Double.parseDouble(s);
                if (d > 0) out.println(d);
            }

            br.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /* =======================
       ЗАДАНИЕ 3
       ======================= */
    static void task3() {
        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("text.txt"), "UTF-8"));
            PrintWriter out = new PrintWriter("result3.txt", "UTF-8");

            String consonants = "бвгджзйклмнпрстфхцчшщ";
            String line;
            int lineNum = 0;

            while ((line = br.readLine()) != null) {
                lineNum++;
                String[] words = line.split("[\\s,.;:!?]+");
                int count = 0;

                out.print("Строка " + lineNum + ": ");

                for (String w : words) {
                    if (!w.isEmpty()) {
                        char c = Character.toLowerCase(w.charAt(0));
                        if (consonants.indexOf(c) != -1) {
                            out.print(w + " ");
                            count++;
                        }
                    }
                }
                out.println("\nКоличество слов: " + count + "\n");
            }

            br.close();
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
/* =========================================
    ЗАДАНИЕ 3 Timus 1991
   ========================================= */
static void task2_timus1991() {
    Scanner sc = new Scanner(System.in);

    System.out.println("Введите строку:");
    String s = sc.nextLine();
    int count = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c == ' ' || c == '.' || c == ',' || c == '!' || c == '?') {
            count += 1;
        } else if ("abc".indexOf(c) >= 0) {
            count += 1;
        } else if ("def".indexOf(c) >= 0) {
            count += 2;
        } else if ("ghi".indexOf(c) >= 0) {
            count += 3;
        } else if ("jkl".indexOf(c) >= 0) {
            count += 1;
        } else if ("mno".indexOf(c) >= 0) {
            count += 2;
        } else if ("pqrs".indexOf(c) >= 0) {
            count += 1;
        } else if ("tuv".indexOf(c) >= 0) {
            count += 2;
        } else if ("wxyz".indexOf(c) >= 0) {
            count += 3;
        }
    }

    System.out.println("Количество нажатий: " + count);
}

/* =========================================
   ЗАДАНИЕ 3 Timus 1567
   ========================================= */
static void  task3_timus1567() {
    Scanner sc = new Scanner(System.in);

    System.out.print("Введите количество отрядов и стрел: ");
    int n = sc.nextInt();
    int k = sc.nextInt();

    int dead = 0;
    int survived = 0;

    for (int i = 0; i < n; i++) {
        int arrows = sc.nextInt();

        if (arrows > k) {
            dead += arrows - k;
        } else {
            survived += k - arrows;
        }
    }

    System.out.println(dead + " " + survived);
}
public static void main(String[] args) {

    // Задание 1
    // task1();

    // Задание 2
    // task2();
    task2_timus1991();

    // Задание 3
    // task3();
    task3_timus1567();
}
