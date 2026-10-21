#!/usr/bin/env bash
set -euo pipefail

# Requires protoc on PATH (brew install protobuf).
cd "$(dirname "$0")"

for p in common.proto control.proto input.proto media.proto \
         navigation.proto playback.proto sensors.proto wireless.proto; do
    protoc "$p" --java_out=../java/
done