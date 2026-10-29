#!/bin/sh
set -e
GRADLE_VERSION=8.9
DIST_URL="https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
GRADLE_HOME="$HOME/.gradle/mag-wrapper/gradle-${GRADLE_VERSION}"
if [ ! -x "$GRADLE_HOME/bin/gradle" ]; then
  mkdir -p "$HOME/.gradle/mag-wrapper"
  ZIP="$HOME/.gradle/mag-wrapper/gradle-${GRADLE_VERSION}-bin.zip"
  curl -fsSL "$DIST_URL" -o "$ZIP"
  unzip -q -o "$ZIP" -d "$HOME/.gradle/mag-wrapper"
fi
exec "$GRADLE_HOME/bin/gradle" "$@"
