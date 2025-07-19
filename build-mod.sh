#!/bin/bash

# Имя JAR-файла после сборки
JAR_NAME="Ultimate-Military-TechnicDesktop.jar"

# Путь к папке, куда Mindustry кладёт моды
MODS_DIR="$HOME/.local/share/Steam/steamapps/common/Mindustry/saves/mods"

# Путь к .jar файлу после сборки
JAR_PATH="./build/libs/$JAR_NAME"

# Путь к build-папке
BUILD_DIR="./build"

# Путь к исполняемому файлу Mindustry (Steam-версия)
MINDUSTRY_PATH="$HOME/.local/share/Steam/steamapps/common/Mindustry/Mindustry"

echo "🔄 Удаляем старую версию мода..."
rm -f "$MODS_DIR/$JAR_NAME"

echo "⚙️ Собираем мод..."
./gradlew jar || { echo "❌ Ошибка сборки. Выход."; exit 1; }

echo "📦 Копируем $JAR_NAME в папку модов Mindustry..."
cp "$JAR_PATH" "$MODS_DIR" || { echo "❌ Не удалось скопировать $JAR_NAME"; exit 1; }

echo "🧹 Удаляем папку build..."
rm -rf "$BUILD_DIR" || { echo "⚠️ Не удалось удалить build-папку"; exit 1; }

echo "🚀 Mindustry запускается..."
"$MINDUSTRY_PATH" &

clear  # <-- Очищаем консоль сразу после запуска

echo "✅ Мод $JAR_NAME обновлён и Mindustry запущен!"
echo "$(date '+%Y-%m-%d %H:%M:%S')"
