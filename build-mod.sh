#!/bin/bash

# Название твоего мода (название .jar файла, без .jar)
MOD_NAME="MyMod"

# Путь к папке, куда Mindustry кладёт моды
MODS_DIR="$HOME/.local/share/Steam/steamapps/common/Mindustry/saves/mods"

# Путь к сборке
JAR_PATH="./build/libs/$MOD_NAME.jar"

echo "🔄 Удаляем старую версию мода..."
rm -f "$MODS_DIR/$MOD_NAME.jar"

echo "⚙️ Собираем мод..."
./gradlew jar || { echo "❌ Ошибка сборки. Выход."; exit 1; }

echo "📦 Копируем новый .jar в папку модов..."
cp "$JAR_PATH" "$MODS_DIR" || { echo "❌ Не удалось скопировать .jar"; exit 1; }

echo "✅ Мод $MOD_NAME обновлён!"
