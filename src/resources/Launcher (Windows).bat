@echo off

REM Set the JAVA_HOME
for /f %%j in ("java.exe") do (
    set JAVA_HOME=%%~dp$PATH:j
)

REM Execute the application
java -jar "Dat Adventure.jar"

REM Check for errors
if NOT ["%errorlevel%"]==["0"] (
    pause
    exit /b %errorlevel%
)
