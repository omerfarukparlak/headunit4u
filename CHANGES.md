# Changes from upstream (andrerinas/open-headunit)

## 2026-10-21 — initial fork by Omer Faruk Parlak
- Package renamed: com.andrerinas.openheadunit -> com.parlaktech.headunit4u
- App label: Open Headunit -> HeadUnit4u
- Attribution file added

## Known follow-ups
- `app/src/main/java/.../aap/protocol/proto/*.java` generated protobuf files
  still contain the upstream package name baked into their serialized
  `FileDescriptor` bytes. Regenerate with:
      brew install protobuf
      bash app/src/main/proto/gen.sh
  The `.proto` sources themselves already use the new package.
- `app/src/main/proto/gen.sh` was rewritten to use `protoc` from PATH
  (upstream hardcoded a `/Users/andre/...` path).
