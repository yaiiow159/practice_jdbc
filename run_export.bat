@echo off
setlocal

set JAR=mysql-connector-java-8.0.28.jar
set JAVA_FILE=ExportMemberCSV.java
set CLASS_FILE=ExportMemberCSV.class

if not exist %JAR% (
  echo 缺少 %JAR%，請先下載並放在本目錄下。
  exit /b 1
)

javac -cp .;%JAR% %JAVA_FILE%
if %errorlevel% neq 0 (
  echo 編譯失敗
  exit /b 1
)

java -cp .;%JAR% ExportMemberCSV
if %errorlevel% neq 0 (
  echo 執行失敗
  exit /b 1
)

echo 匯出完成，請檢查csv檔案。 