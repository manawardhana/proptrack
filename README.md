# Proptrack

A basic property transaction calculator library written in Clojure.

## Prerequisites
- [Leiningen](https://leiningen.org)

## Assumptions
 - Property value is a part of the buyer fee

## Project Structure
```
.
├── CHANGELOG.md
├── LICENSE
├── README.md
├── doc
│   └── intro.md
├── project.clj
├── resources
├── src
│   └── proptrack
│       ├── core.clj
│       ├── sample_data.clj
│       └── specs.clj
└── test
    └── proptrack
        └── core_test.clj
```

## Instructions - Running tests
```
lein test
```

## Notes
- Generative testing has not been done due to time constraints
- Specs have been developed. But they merely stands for documenting contracts.
- Rather maintaining a global state, function closures has been used. Ideally `component`, `mount`, or `integrant` should be used (due to time constraints).
- Original given data structures have been used in the original form. This is not performant due to sequential scans. Since the context is not known (DB? ETL? Volume etc), I didn't do optimizations based on assumptions.
