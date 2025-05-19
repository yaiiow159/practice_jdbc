# JDBC MySQL 匯出範例

## 步驟

1. 匯入SQL檔案

   ```sh
   mysql -u root -p < member.sql
   ```

2. 下載MySQL JDBC驅動

   - 前往 https://dev.mysql.com/downloads/connector/j/ 下載 `mysql-connector-java-8.0.28.jar`
   - 將jar檔放在本目錄下

3. 一鍵執行（推薦）

   - 直接執行：
     ```sh
     run_export.bat
     ```
   - 會自動編譯並執行 ExportMemberCSV.java，產生三個查詢結果的 csv 檔案。

4. 手動編譯與執行（如需調整）

   - 修改 `ExportMemberCSV.java` 內的資料庫密碼
   - 編譯：
     ```sh
     javac -cp .;mysql-connector-java-8.0.28.jar ExportMemberCSV.java
     ```
   - 執行：
     ```sh
     java -cp .;mysql-connector-java-8.0.28.jar ExportMemberCSV
     ```
   - (Linux/macOS請將分號 ; 改為冒號 :)

5. 會產生三個csv檔案，分別對應三個查詢結果。

---

## 注意事項
- `phone` 欄位已改為 `VARCHAR(20)`，避免數據過長錯誤。

## 相關檔案
- `member.sql`：建庫、建表與範例數據
- `ExportMemberCSV.java`：查詢並匯出CSV
- `run_export.bat`：一鍵編譯與執行腳本

---

## Git 操作

1. 初始化 git repo
   ```sh
   git init
   ```
2. 新增所有檔案並提交
   ```sh
   git add .
   git commit -m "init"
   ``` 