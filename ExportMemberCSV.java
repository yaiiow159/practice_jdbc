import java.io.*;
import java.sql.*;

public class ExportMemberCSV {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/new_schema";
        String user = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement()) {
            // 題目1
            System.out.println("【題目1】查出Tony的生日與住址");
            ResultSet rs1 = stmt.executeQuery("SELECT birthday, address FROM Member WHERE name='Tony'");
            try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("tony_birthday_address.csv"))) {
                writer1.write("【題目1】查出Tony的生日與住址\n");
                writer1.write("birthday,address\n");
                while (rs1.next()) {
                    String birthday = rs1.getString("birthday");
                    String address = rs1.getString("address");
                    writer1.write(birthday + "," + address + "\n");
                    System.out.println("生日: " + birthday + ", 住址: " + address);
                }
            }
            rs1.close();

            // 題目2
            System.out.println("\n【題目2】住在高雄的人姓名、生日、mail");
            ResultSet rs2 = stmt.executeQuery("SELECT name, birthday, email FROM Member WHERE address LIKE '%高雄%'");
            try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("kaohsiung_name_birthday_email.csv"))) {
                writer2.write("【題目2】住在高雄的人姓名、生日、mail\n");
                writer2.write("name,birthday,email\n");
                while (rs2.next()) {
                    String name = rs2.getString("name");
                    String birthday = rs2.getString("birthday");
                    String email = rs2.getString("email");
                    writer2.write(name + "," + birthday + "," + email + "\n");
                    System.out.println("姓名: " + name + ", 生日: " + birthday + ", mail: " + email);
                }
            }
            rs2.close();

            // 題目3
            System.out.println("\n【題目3】pId第一個字母開頭是A的人的電話號碼");
            ResultSet rs3 = stmt.executeQuery("SELECT phone FROM Member WHERE pId LIKE 'A%'");
            try (BufferedWriter writer3 = new BufferedWriter(new FileWriter("pid_a_phone.csv"))) {
                writer3.write("【題目3】pId第一個字母開頭是A的人的電話號碼\n");
                writer3.write("phone\n");
                while (rs3.next()) {
                    String phone = rs3.getString("phone");
                    writer3.write(phone + "\n");
                    System.out.println("電話: " + phone);
                }
            }
            rs3.close();
        }
        System.out.println("\n三個查詢結果已分別匯出！");
    }
} 