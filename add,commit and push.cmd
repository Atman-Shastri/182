@echo off
for /F "tokens=1" %%i in ('time /t') do set time1=%%i
for /F "tokens=2" %%i in ('time /t') do set ampm=%%i
git config user.name "Atman-Shastri"
git config user.email "atmanshastri@gmail.com"
git add .
git commit -m "%DATE% %time1% %ampm%"
git push