@echo off
title CampusFix AI
where java >nul 2>nul
if errorlevel 1 (
  echo Java is not installed or is not on PATH. Install JDK 17 or newer.
  pause
  exit /b 1
)
where mvn >nul 2>nul
if errorlevel 1 (
  echo Maven is not installed or is not on PATH.
  echo Open this folder in VS Code and use: mvn spring-boot:run
  pause
  exit /b 1
)
mvn spring-boot:run
pause
