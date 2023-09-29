@echo off
rem D:
rem cd D:\symca_batch_c_182\android-studio
git checkout lab
for /F "tokens=1" %%i in ('time /t') do set time1=%%i
for /F "tokens=2" %%i in ('time /t') do set ampm=%%i
git config user.name "Atman-Shastri-Lab"
git config user.email "atmanshastri@gmail.com"
git add .
git commit -m "%DATE% %time1% %ampm%"
git push origin lab
pause
