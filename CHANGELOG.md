# HeadUnit4u Changelog

HeadUnit4u is an independent, AGPLv3 fork of [andrerinas/open-headunit](https://github.com/andrerinas/open-headunit),
which itself builds on Michael Reid's original [headunit](https://github.com/mikereidis/headunit).
The upstream changelog is preserved in the git history of the first fork commit — only entries made by this fork are listed below.

## v1.0.0 — 2026-10-23

### First parlaktech release

- **Branding** — package renamed to `com.parlaktech.headunit4u`, app label and in-app brand strings swept to "HeadUnit4u" across every locale, GitHub URLs pointed at `omerfarukparlak/headunit4u`, copyright line to Omer Faruk Parlak · parlaktech, splash and launcher icon redesigned as a mor-white H4 monogram.
- **Version scheme reset** — upstream `4.0.0-alpha` (versionCode 120) → `1.0.0` (versionCode 1). Any future store listing is a fresh one; the parlaktech line does not continue upstream's numbering.
- **UI: MoodMap-style "Neo + Glass" theme** — single dark palette (Neo tones from MoodMap's `KOYU_RENKLER`), Material 3 `AppTheme` rewired through Neo surface / primary / container colors, 14 / 22 / 28 dp `ShapeAppearance.Neo.{Small,Medium,Large}` matching the compose card radii.
- **UI: new drawables** — `bg.xml` is now a three-stop vertical Neo gradient (top → mid → bottom), `bg_pill_translucent.xml` is a neo-card glass pill, `bg_neo_card.xml` adds a 28dp rounded Neo card for XML layouts, home-screen `gradient_blue|orange|purple|darkblue|monochrome.xml` recolored with Neo primary / primary_soft / pink / orange / card tones.
- **UI: home screen** — added `brand_header` ("HeadUnit" + mor "4u") at top-center and two decorative glow layers (`neo_glow_primary` top-end, `neo_glow_pink` bottom-start). Exit button restyled as a Material3 OutlinedButton with Neo card fill / border / 22 dp corners. Bring-up pill given a `maxWidth` + right margin so it no longer collides with Exit.
- **Compose layer** — Jetpack Compose + Material3 wired up (compile-side only for now): `ui/theme/` ports MoodMap's `HeadUnitRenkleri` + `LocalHeadUnitRenkleri` + `AppTypography`, `ui/components/` provides `NeoGradientBackground`, `DecorativeGlowLayer`, `NeoGlassCard`, `StatusChip`, `ui/showcase/HeadUnitShowcaseActivity` is a live preview of the compose stack (not in the manifest yet).
- **Build infra** — Kotlin Compose Compiler plugin on Kotlin 2.4.20, Compose BoM 2025.09, `minSdk` 16 → 21, JVM target 17.
- **Build fixes** — JNI function names in `cpp/usbhelper.c|aaudio_output.cpp|ffmpeg_hevc_decoder.cpp` restored (the initial package-rename sed had un-escaped dots and rewrote the `_` separators of the JNI symbol prefixes). Protobuf generation pinned to protoc 25.1 to match the `protobuf-java:3.25.5` runtime; `gen.sh` made portable (`PROTOC` env override).
- **About screen** — rewritten to credit andrerinas/open-headunit and Michael Reid's original mikereidis/headunit with clickable links, replaced the upstream support/PayPal line with our GitHub issue tracker.
