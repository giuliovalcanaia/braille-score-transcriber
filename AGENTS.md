# AGENTS.md — BrailleScoreTranscriber

## Project snapshot

- Single-module Java 17 Gradle project (`build.gradle`, no `settings.gradle`).
- No CLI entry point yet. The current entrypoint for parsing is `br.com.braille.model.Score(String filePath)`.
- Parses MusicXML into a DOM tree and exposes `Score` → `Measure` → `Note` → `Pitch` plus enums (`Step`, `ClefSign`, `Mode`).

## Commands

```bash
# Run all tests
./gradlew test

# Compile only
./gradlew compileJava

# Run a single test class
./gradlew test --tests "br.com.braille.model.ScoreTest"

# Run a single test method
./gradlew test --tests "br.com.braille.model.ScoreTest.testIfGetTitleIsWorkingInContructor"
```

## Architecture notes

- `Score` constructor performs I/O synchronously: it loads the XML, extracts the title, and extracts measures. Failures print to `stderr` and leave the internal DOM buffer as `null`; the constructor does not throw.
- Title resolution order: `<credit credit-type="title"><credit-words>` → `<work-title>` → fallback `"Título não encontrado"`.
- Measure divisions are currently read from the first global `<attributes>` block, not per-measure. The test fixture (`Asa-Branca.musicxml`) has uniform divisions, so this passes today. If you add MusicXML with changing divisions per measure, update `Score.extractMeasures()`.
- XML parsing disables external DTD loading (`load-external-dtd=false`, `setValidating(false)`) to avoid network/validation errors.

## Testing

- JUnit 5 via `junit-bom:5.10.2`.
- The only test fixture is `src/test/resources/Asa-Branca.musicxml`. Tests assert title, measure count (26), and divisions value (2).
- Tests run relative to the repo root, so the hardcoded `src/test/resources/Asa-Branca.musicxml` path works from Gradle's working directory.

## Environment

- Gradle wrapper uses Gradle 9.3.0.
- Target/source compatibility is Java 17; the runtime here is Java 21, which is compatible.
- No external dependencies beyond JUnit.

## Files worth knowing

- `README.md` — architecture overview in Portuguese/English.
- `UML.md` — Mermaid class diagram; note it may drift from the code (e.g., `Note.duration` is `Double`, `Pitch` fields differ slightly from README text).
- `REQUISITOS.md` — academic assignment requirements (Portuguese); not a build spec.

## Common gotchas

- `.gitignore` is mostly a Python template and largely irrelevant for this Java project. The important ignores are `.idea/`, `.gradle/`, `build/`, `out/`.
- No `src/main/resources` or application plugin is configured; there is no runnable `main` method yet.
