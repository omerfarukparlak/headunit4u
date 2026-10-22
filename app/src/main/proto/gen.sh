#!/usr/bin/env bash
set -euo pipefail

# IMPORTANT: use protoc 25.1 — it matches com.google.protobuf:protobuf-java:3.25.5
# in app/build.gradle.kts. Newer protoc (26+) emits code that references
# com.google.protobuf.RuntimeVersion, a class that only exists in protobuf
# runtime 4.26+. Mixing them breaks the Java compile with "cannot find symbol:
# class RuntimeVersion" errors across every generated file.
#
# Download: https://github.com/protocolbuffers/protobuf/releases/tag/v25.1
# Install path can be overridden with the PROTOC env var.
PROTOC="${PROTOC:-protoc}"

cd "$(dirname "$0")"

for p in common.proto control.proto input.proto media.proto \
         navigation.proto playback.proto sensors.proto wireless.proto; do
    "$PROTOC" "$p" --java_out=../java/
done