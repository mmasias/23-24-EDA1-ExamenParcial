# CLAUDE.md - AI Assistant Guide

## Repository Overview

This is an exam repository for **EDA1 (Estructuras de Datos y Algoritmos 1)** for the academic year 2023-2024. The repository contains an exam problem called "Teléfono Descacharrado" (Broken Telephone Game) that students must solve using data structures and algorithms concepts.

### Repository Purpose
- **Type**: Academic exam repository
- **Course**: Data Structures and Algorithms 1 (EDA1)
- **Academic Year**: 2023-2024
- **Primary Language**: Java
- **Main Objective**: Students must implement a simulation of a children's game involving queues, timing, and message transformation

---

## Problem Description Summary

The exam challenges students to simulate a playroom scenario where:

1. **Game Setup**: Children arrive at a playroom and are placed in a queue
2. **Game Start**: When 5+ children are in the queue, the game begins
3. **Message Passing**: A 10-letter message is passed from child to child
4. **Message Corruption**: Children may inadvertently change 1-2 letters when copying the message
5. **Timing Constraints**: Each message reading/writing takes 1 minute
6. **Arrival Pattern**:
   - First 10 minutes: 0-2 children per minute
   - Next 20 minutes: 1 child every 3 minutes (50% probability)
   - After 30 minutes: no more arrivals
7. **Duration**: The playroom operates for 2 hours total

### Key Data Structures & Concepts
- **Queue**: Children waiting in line
- **Time simulation**: Discrete event simulation with minute-by-minute progression
- **Randomness**: Child arrivals and message corruption
- **State management**: Game in progress vs. accepting new children

---

## Directory Structure

```
23-24-EDA1-ExamenParcial/
├── README.md              # Problem statement (Spanish)
├── CLAUDE.md              # This file - AI assistant guide
├── .gitignore             # Java-specific gitignore
├── entregas/              # Student submissions directory
│   └── README.md          # "Entregas aquí" (Submit here)
└── imagenes/              # Visual assets for problem description
    └── DALL·E...png       # Illustration of children in the game
```

### Directory Purposes

- **`/entregas/`**: Students should place their solution submissions here
  - Each student typically creates a subdirectory with their name or ID
  - Contains source code (.java files), compiled classes, and optional documentation

- **`/imagenes/`**: Contains visual assets referenced in README.md
  - Currently contains one illustration showing the game scenario
  - Do not modify unless adding new problem illustrations

- **Root directory**: Contains problem statement and configuration files
  - README.md is the authoritative problem description
  - Should not be modified by students

---

## Development Workflow

### For Students (Primary Use Case)

1. **Read the Problem**: Start with `/README.md` for complete problem requirements
2. **Create Submission Directory**: `mkdir entregas/[student-name]`
3. **Implement Solution**: Write Java code implementing the simulation
4. **Test Thoroughly**: Verify timing, queue behavior, and message passing
5. **Submit**: Commit and push to the appropriate branch

### For Instructors/Maintainers

1. **Problem Updates**: Modify `/README.md` with clear commit messages
2. **Asset Management**: Add new images to `/imagenes/` if needed
3. **Review Submissions**: Check `/entregas/` for student work
4. **Branch Management**: Students may work on feature branches before merging

---

## Code Conventions & Best Practices

### Expected Java Implementation Patterns

Since this is a data structures course exam, students should demonstrate:

1. **Queue Implementation**
   - Use `java.util.Queue` or implement a custom queue
   - Proper enqueue/dequeue operations
   - FIFO (First In, First Out) behavior

2. **Simulation Architecture**
   ```java
   // Expected pattern:
   class PlayroomSimulation {
       private Queue<Child> waitingQueue;
       private int currentMinute;
       private String currentMessage;

       public void simulate(int durationMinutes) {
           // Main simulation loop
       }
   }
   ```

3. **Random Event Handling**
   - Use `java.util.Random` for probabilistic events
   - Child arrivals: randomize timing based on problem rules
   - Message corruption: randomly change 1-2 characters

4. **Time Management**
   - Discrete time steps (minute by minute)
   - Track when game is in progress vs. accepting arrivals
   - Queue management during active games

### Naming Conventions

- **Classes**: PascalCase (`PlayroomSimulation`, `Child`, `Message`)
- **Methods**: camelCase (`passMessage()`, `corruptMessage()`)
- **Variables**: camelCase (`currentMinute`, `waitingQueue`)
- **Constants**: UPPER_SNAKE_CASE (`MIN_CHILDREN_TO_START`, `MESSAGE_LENGTH`)

### Code Organization

Recommended structure for submissions:
```
entregas/[student-name]/
├── src/
│   ├── Main.java              # Entry point
│   ├── Simulation.java        # Main simulation logic
│   ├── Child.java             # Child entity
│   └── Message.java           # Message handling
├── README.md                  # Optional: approach explanation
└── results.txt                # Optional: simulation outputs
```

---

## Working with This Repository as an AI Assistant

### Understanding Context

When asked to help with this repository, consider:

1. **Academic Integrity**: This is an exam. Focus on:
   - Explaining concepts and data structures
   - Helping debug logical errors
   - Clarifying problem requirements
   - NOT writing complete solutions unless explicitly asked

2. **Problem Interpretation**: The problem is in Spanish. Key terms:
   - "Ludoteca" = Playroom/Game room
   - "Cola" = Queue
   - "Pizarrín" = Small whiteboard/slate
   - "Teléfono descacharrado" = Broken telephone/Chinese whispers

3. **Scope Boundaries**:
   - Students must implement the core simulation
   - Optional: visualization, statistics, advanced features
   - Required: source code; optional: other artifacts

### Common Tasks

#### Task: Review a Student's Solution
```markdown
1. Check queue implementation correctness
2. Verify timing logic (1 minute per child)
3. Confirm arrival patterns match problem spec
4. Validate message corruption (1-2 characters only)
5. Test edge cases (< 5 children, exactly 120 minutes)
```

#### Task: Explain a Concept
Focus on:
- Queue data structure fundamentals
- Event-driven simulation principles
- Probability in computer science
- Java Collections Framework

#### Task: Debug Help
1. Read the student's code from `/entregas/[name]/`
2. Identify logical errors (timing, queue operations)
3. Suggest fixes without rewriting entire solution
4. Explain the underlying concept

#### Task: Add Test Cases
Help create test scenarios:
- Minimum viable game (5 children)
- Maximum corruption scenario
- Timing edge cases
- Arrival pattern verification

### Commands for Analysis

```bash
# Find all Java submissions
find entregas -name "*.java"

# Count submissions
ls entregas | wc -l

# Check a specific student's code
ls entregas/[student-name]/

# View git history for submission tracking
git log --all --graph --oneline
```

---

## Git Workflow

### Branch Strategy

- **Main branch**: Contains problem statement and structure (typically `main` or `master`)
- **Feature branches**: Named `claude/[description]-[id]` for AI assistant work
- **Student branches**: May vary; check with instructor

### Commit Guidelines

- **Problem updates**: `"Update README.md - clarify timing requirements"`
- **New assets**: `"Add illustration for game setup"`
- **Structure changes**: `"Add template directory for submissions"`
- **Documentation**: `"Create CLAUDE.md with repository guide"`

### Before Committing

1. Verify you're on the correct branch
2. Check what files are changed: `git status`
3. Review changes: `git diff`
4. Stage specific files (avoid committing unnecessary files)
5. Write clear, descriptive commit messages
6. Push to the designated branch

---

## Key Files Reference

### README.md
- **Location**: `/README.md`
- **Purpose**: Complete problem statement
- **Language**: Spanish
- **Content**: Game rules, timing, arrival patterns, deliverables
- **Modify**: Only by instructors/maintainers

### .gitignore
- **Location**: `/.gitignore`
- **Purpose**: Exclude compiled Java files and artifacts
- **Patterns**: `*.class`, `*.jar`, `*.log`, etc.
- **Modify**: Rarely; add new patterns if needed for IDE files

### entregas/README.md
- **Location**: `/entregas/README.md`
- **Purpose**: Marker for submission directory
- **Content**: Simple "Entregas aquí" (Submit here)
- **Modify**: Generally not needed

---

## Problem-Specific Implementation Notes

### Critical Requirements

1. **Queue must hold 5+ children before starting**: Don't start game prematurely
2. **Timing is discrete**: Each action takes exactly 1 minute
3. **Parallel arrivals and gameplay**: Children can arrive while game is in progress
4. **Message is exactly 10 letters**: Validate this constraint
5. **Corruption is 1-2 letters**: Not zero, not more than two
6. **Duration is exactly 120 minutes**: Simulation ends after 2 hours

### Common Pitfalls

1. **Incorrect arrival probability**: Pay attention to the time windows
   - 0-10 min: 0-2 children/minute
   - 10-30 min: 50% chance every 3 minutes
   - 30+ min: no arrivals

2. **Game timing**: Each child takes 1 minute (not parallel processing)

3. **Queue management**: Children arriving during a game wait with Lydia, not in the main queue

4. **Message corruption**: Should be random and vary per transmission

### Suggested Test Scenarios

```java
// Test 1: Minimum game
// - Exactly 5 children arrive
// - No new arrivals during game
// - Verify message passes through 5 children in 5 minutes

// Test 2: Continuous arrivals
// - Children arrive while game is in progress
// - Verify they don't join queue until game ends
// - Check queue rebuilds correctly

// Test 3: Maximum corruption
// - Track how message degrades over multiple children
// - Verify only 1-2 chars change per child

// Test 4: Timing accuracy
// - Verify simulation runs exactly 120 minutes
// - Check all timing constraints are met
```

---

## Technical Specifications

### Language & Environment
- **Language**: Java (version not specified; suggest Java 11+)
- **Build Tool**: None specified (students may use javac directly or Maven/Gradle)
- **Dependencies**: Standard Java library only
- **Testing**: Optional but recommended (JUnit)

### Expected Skills Demonstrated
- Queue data structure usage
- Object-oriented design
- Discrete event simulation
- Random number generation and probability
- Time complexity awareness
- Clean code practices

---

## Additional Resources

### Key Concepts to Review
- Queue ADT (Abstract Data Type)
- FIFO (First In, First Out) principle
- Discrete event simulation
- Probability and random events
- State machines (game active/inactive)

### Related Topics
- Java Collections Framework (`Queue`, `LinkedList`, `ArrayDeque`)
- String manipulation in Java
- Random class and seeding
- Time management in simulations

---

## Maintenance Notes

### Last Updated
- **Date**: 2025-11-14
- **Updated by**: Claude (AI Assistant)
- **Reason**: Initial creation of CLAUDE.md guide

### Version History
- **v1.0** (2025-11-14): Initial comprehensive guide created

### Future Considerations
- Add example solution structure (after exam period)
- Include grading rubric reference
- Add common FAQ section based on student questions
- Create automated test suite for submissions

---

## Contact & Support

For questions about this repository:
- Check the problem statement in `/README.md`
- Review this guide for structural questions
- Consult course materials for algorithm clarification
- Contact course instructors for exam-specific questions

---

## Notes for AI Assistants

### When Helping Students
- **Do**: Explain concepts, clarify requirements, help debug
- **Don't**: Write complete solutions, make decisions for students
- **Focus**: Understanding > Implementation

### When Helping Instructors
- **Do**: Analyze submissions, suggest improvements, create resources
- **Don't**: Modify student work, change problem requirements without approval
- **Focus**: Quality assessment > Automation

### Code Analysis Approach
1. Read the problem requirements first
2. Understand what the student is trying to achieve
3. Identify structural issues before syntactic ones
4. Suggest improvements that teach, not just fix
5. Encourage testing and edge case consideration

---

## Quick Reference

| Task | Command/Action |
|------|----------------|
| View problem | `cat README.md` |
| List submissions | `ls entregas/` |
| Find Java files | `find entregas -name "*.java"` |
| Check student work | `cat entregas/[name]/Main.java` |
| View git history | `git log --oneline` |
| Check branches | `git branch -a` |

---

**End of CLAUDE.md**
