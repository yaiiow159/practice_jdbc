import java.io.*;
import java.sql.*;

public class ExportMemberCSV {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/new_schema";
        String user = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement()) {
            
            ResultSet rs1 = stmt.executeQuery("SELECT birthday, address FROM Member WHERE name='Tony'");
            try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("tony_birthday_address.csv"))) {
                writer1.write("【題目1】查出Tony的生日與住址\n");
                writer1.write("birthday,address\n");
                while (rs1.next()) {
                    writer1.write(rs1.getString("birthday") + "," + rs1.getString("address") + "\n");
                }
            }
            rs1.close();
            
            ResultSet rs2 = stmt.executeQuery("SELECT name, birthday, email FROM Member WHERE address LIKE '%高雄%'");
            try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("kaohsiung_name_birthday_email.csv"))) {
                writer2.write("【題目2】住在高雄的人姓名、生日、mail\n");
                writer2.write("name,birthday,email\n");
                while (rs2.next()) {
                    writer2.write(rs2.getString("name") + "," + rs2.getString("birthday") + "," + rs2.getString("email") + "\n");
                }
            }
            rs2.close();
            
            ResultSet rs3 = stmt.executeQuery("SELECT phone FROM Member WHERE pId LIKE 'A%'");
            BufferedWriter writer3 = new BufferedWriter(new FileWriter("pid_a_phone.csv"));
            writer3.write("【題目3】pId第一個字母開頭是A的人的電話號碼\n");
            writer3.write("phone\n");
            while (rs3.next()) {
                writer3.write(rs3.getString("phone") + "\n");
            }
            writer3.close();
            rs3.close();
            
        }
        System.out.println("三個查詢結果已分別匯出！");
    }
} 