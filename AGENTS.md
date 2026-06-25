# Agent Guidelines

## Testing

- Use [kotest-assertions](https://kotest.io/docs/assertions/assertions.html) for all assertions (`shouldBe`, `shouldBeInstanceOf`, `shouldThrow`, etc.)
- Use `kotlin.test.Test` for test annotations and `kotlinx.coroutines.test.runTest` for coroutine tests
- Write tests first (TDD): red → green → refactor

## Design

- Apply SOLID principles: single responsibility, open/closed, dependency inversion
- Prefer composition over inheritance
- Keep functions small and focused on one thing

## Style

- Follow [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html) and naming rules
- Follow [Kotlin API design guidelines](docs/kotlin-api-design-guidelines.md)
- Use descriptive backtick test names: `` `does X when Y` ``
- Prioritise readability over cleverness
