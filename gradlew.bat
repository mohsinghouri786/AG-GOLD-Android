@echo off
set GRADLE_VERSION=8.9
set GRADLE_HOME=%USERPROFILE%\.gradle\mag-wrapper\gradle-%GRADLE_VERSION%
if not exist "%GRADLE_HOME%\bin\gradle.bat" (
 echo Please use the GitHub Actions Linux build or install Gradle %GRADLE_VERSION% locally.
 exit /b 1
)
call "%GRADLE_HOME%\bin\gradle.bat" %*
