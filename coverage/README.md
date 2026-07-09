# Test Coverage

Unit tests and coverage tooling for the LeetCode solutions in this repository.

## Why a separate project?

Each solution lives at the repository root in its own directory (e.g.
`0001-two-sum/`) and is written exactly as it is submitted to LeetCode: a single
top-level `class Solution` in the default package. Because every file declares
the same class name, the solutions cannot all be compiled into one module.

This Maven project therefore builds **one module per problem**. Each module uses
the `build-helper-maven-plugin` to add the corresponding solution directory as a
source root, so the tests run against the real solution files — nothing is
copied or duplicated, and the solution files are left untouched.

## Layout

```
coverage/
  pom.xml                    aggregator + shared JUnit 5 / JaCoCo config
  two-sum/                   -> ../0001-two-sum
  palindrome-number/         -> ../0009-palindrome-number
  remove-element/            -> ../0027-remove-element
```

## Running the tests

From this directory:

```bash
mvn test
```

Requires JDK 17+ and Maven 3.6+.

## Coverage reports

JaCoCo runs as part of `mvn test`. After a run, an HTML report is generated per
module at:

```
<module>/target/site/jacoco/index.html
```

For example: `two-sum/target/site/jacoco/index.html`.

## Adding tests for a new solution

1. Add the solution at the repo root as usual (e.g. `0042-trapping-rain-water/`).
2. Create a module directory here (e.g. `trapping-rain-water/`) with a `pom.xml`
   copied from an existing module, updating `<artifactId>`, `<name>`, and the
   `build-helper` `<source>` path to point at the new solution directory.
3. Register the module in the `<modules>` section of `coverage/pom.xml`.
4. Add `src/test/java/SolutionTest.java` and run `mvn test`.
