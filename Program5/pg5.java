import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class pg5 {
    static int num = 0;

    static void check(String str) {
        int eq = str.indexOf("=");
        String lhs = str.substring(0, eq);
        Pattern p = Pattern.compile("[-+*/]");
        Matcher m = p.matcher(str);
        String rhs1, rhs2;
        if (!m.find()) {
            rhs1 = str.substring(eq + 1);
            System.out.println("MOV " + lhs + "," + rhs1);
        } else {
            int op = str.indexOf(m.group(0));
            rhs1 = str.substring(eq + 1, op);
            rhs2 = str.substring(op + 1);
            if (eq + 1 == op) {
                System.out.println("MOV " + lhs + "," + rhs2);
                System.out.println("NEG " + lhs);
            } else {
                System.out.println("MOV R0," + rhs1);
                System.out.println("MOV R1," + rhs2);
                switch (m.group(0)) {
                    case "+":
                        System.out.println("ADD " + lhs + ",R0,R1");
                        break;
                    case "-":
                        System.out.println("SUB " + lhs + ",R0,R1");
                        break;
                    case "*":
                        System.out.println("MUL " + lhs + ",R0,R1");
                        break;
                    case "/":
                        System.out.println("DIV " + lhs + ",R0,R1");
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter no. of Addresses");
        int n = s.nextInt();
        String[] addr = new String[n];
        for (int i = 0; i < n; i++) {
            addr[i] = s.next();
        }
        for (int i = 0; i < n; i++) {
            check(addr[i]);
        }
    }
}