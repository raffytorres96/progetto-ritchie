# ♟️ Ataxx

> A command-line implementation of the abstract strategy board game **Ataxx** — built in Java, containerized with Docker, and developed collaboratively following an Agile/Scrum methodology.

---

## 📌 Overview

Ataxx is a two-player abstract strategy game played on a **7×7 grid**. Each player starts with two pieces in opposite corners and alternates turns trying to convert as many opponent pieces as possible. The player controlling the majority of pieces when the board is full wins.

This project was developed for the course **Ingegneria del Software** at the **University of Bari**, following a structured Agile workflow across multiple sprints, with full GitHub-based issue tracking, pull request reviews, and milestone management.

---

## 🎮 Game Rules

Each turn a player can make one of two moves:

| Move | Description | Effect |
|---|---|---|
| **Expansion** | Move to an adjacent cell (orthogonal or diagonal) | A **new piece** is created at the destination; the original remains |
| **Jump** | Move to a cell 2 steps away | The piece **relocates**; the original cell becomes empty |

After any move, all **opponent pieces adjacent to the destination cell** are captured and converted to the moving player's color.

A player **must pass** if no legal move is available. The game ends when the board is full or one player has no pieces left.

---

## 🖥️ Commands

| Command | Context | Description |
|---|---|---|
| `/help`, `-h`, `--help` | Always | Show help with command list and game description |
| `/gioca` | Always | Start a new game, show board in initial position |
| `/tavoliere` | In game | Display the board with all pieces |
| `/vuoto` | Always | Display the empty 7×7 board with coordinates |
| `/qualimosse` | In game | Highlight all available moves for the current player |
| `/mosse` | In game | Show move history in algebraic notation |
| `/tempo` | In game | Show elapsed time since game start (hh:mm:ss) |
| `/blocca xn` | Before game | Block cell `xn` — makes it inaccessible for both players |
| `/abbandona` | In game | Forfeit the current game (requires confirmation) |
| `/esci` | Always | Exit the application (requires confirmation) |

### Move notation

```
a1-a2    →  Expansion move (adjacent cell)
g1-e1    →  Jump move (2 cells away)
```

### `/qualimosse` color coding

| Color | Meaning |
|---|---|
| 🟡 Yellow | Cell reachable with an **expansion** move |
| 🟠 Orange | Cell reachable with a **jump** move |
| 🩷 Pink | Cell reachable with **either** move type |

---

## 🔒 `/blocca` Constraints

The following cells **cannot** be blocked:

- Starting cells of either player
- All cells adjacent to a starting cell (would prevent expansion at turn 1)
- All cells 2 steps from a starting cell (would prevent jump at turn 1)
- More than **9 cells** in total

---

## 🏗️ Architecture & Design

### Key classes

| Class | Responsibility |
|---|---|
| `Comandi` | Entry point for all user story commands; handles user input |
| `Partita` | Core game logic — turn alternation, win condition checks |
| `Tavoliere` | 7×7 board representation; manages blocked cells and piece placement |
| `Cella` | Single cell model with state (empty, piece color, blocked) |
| `Mossa` | Move validation and execution (expansion and jump) |
| `Giocatore` | Player model with piece color and name |
| `Regola` | Game rule enforcement |
| `GestioneStampa` | All output formatting — board rendering, ASCII art, messages |
| `Utils` | Input validation helpers for commands and coordinates |

### Design decisions

- **Information Hiding** was applied consistently across all classes
- **`Partita`** is designed as a single-instance class — Spotbugs warnings about static field mutation via constructor were suppressed accordingly
- **`GestioneStampa`** centralizes all output, including the board renderer and the ASCII art logo
- **`Utils`** handles input sanitization independently of game logic

---

## 🧪 Testing

JUnit tests were written with a focus on:

- **Input robustness** — partial commands, empty input, malformed coordinates
- **Move validation** — coordinates out of range, destination too far from piece
- **Edge cases** — blocked cells, no available moves, end-game conditions

The test suite verifies that the application handles all unexpected input gracefully without interrupting execution.

---

## 🚀 Getting Started

### Requirements

- Docker installed and running
- A terminal with **Unicode support** and **UTF-8 or UTF-16 encoding**

| OS | Supported terminals |
|---|---|
| Linux | `terminal` |
| Windows | PowerShell, Git Bash (`winpty` prefix required) |

### Run with Docker

```bash
# Pull the image from GitHub Packages
docker pull ghcr.io/softeng2324-inf-uniba/ataxx-<team>:latest

# Run the container
docker run --rm -it ghcr.io/softeng2324-inf-uniba/ataxx-<team>:latest
```

> Replace `<team>` with your group name.

**Git Bash on Windows:**
```bash
winpty docker run --rm -it ghcr.io/softeng2324-inf-uniba/ataxx-<team>:latest
```

---

## 📁 Project Structure

```
ataxx/
│
├── src/
│   ├── main/java/
│   │   └── it/uniba/app/
│   │       ├── Comandi.java
│   │       ├── Partita.java
│   │       ├── Tavoliere.java
│   │       ├── Cella.java
│   │       ├── Mossa.java
│   │       ├── Giocatore.java
│   │       ├── Regola.java
│   │       ├── GestioneStampa.java
│   │       └── Utils.java
│   └── test/java/
│       └── it/uniba/app/
│           └── [JUnit test classes]
│
├── img/                        # Report screenshots and UML diagrams
├── docs/
│   └── Report.md               # Full technical report
├── Dockerfile
├── build.gradle
└── README.md
```

---

## 🔄 Development Process

The project followed an **Agile/Scrum** workflow over **3 sprints**, each managed through GitHub:

| Tool | Usage |
|---|---|
| **GitHub Issues** | One issue per functional requirement |
| **GitHub Projects** | Kanban board per sprint (ToDo → InProgress → Review → Ready → Done) |
| **GitHub Milestones** | One milestone per sprint |
| **Pull Requests** | Reviewed and approved by ≥ 2 team members before merge |
| **Feature branches** | One local branch per issue |

### Sprint board columns

```
ToDo  →  InProgress  →  Review  →  Ready  →  Done
```

Every sprint concluded with a **team review meeting** before delivery to the product owner.

### Tools used

| Tool | Purpose |
|---|---|
| Visual Studio Code | IDE for Java development and Markdown |
| Gradle | Build automation |
| Docker | Containerization and deployment |
| JUnit | Unit testing |
| Checkstyle | Code style enforcement |
| SpotBugs | Static analysis |
| StarUML | Domain model, class diagrams, sequence diagrams |
| Discord | Team meetings and collaborative sessions |
| WhatsApp | Quick communications |

---

## 📐 OO Design — UML Diagrams

Class diagrams and sequence diagrams were produced for the 5 most significant user stories:

| Command | Reason |
|---|---|
| `/help` | Entry point for all user information — fundamental for usability |
| `/gioca` | Core application flow — the game's nucleus |
| `/mosse` | Move history tracking — essential for game state awareness |
| `/qualimosse` | Strategic move highlighting — key during active gameplay |
| `/blocca` | Board customization — affects game dynamics before start |

---

## 👥 Team

Developed by a student team as part of the **Ingegneria del Software** course — University of Bari (A.Y. 2023–24).

**Contributors:** Raffaele Gatta and team

---

## 🛠️ Tech Stack

<p align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=flat-square&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Docker-2496ED?style=flat-square&logo=docker&logoColor=white"/>
  <img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white"/>
  <img src="https://img.shields.io/badge/JUnit5-25A162?style=flat-square&logo=junit5&logoColor=white"/>
  <img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=git&logoColor=white"/>
  <img src="https://img.shields.io/badge/GitHub_Actions-2088FF?style=flat-square&logo=githubactions&logoColor=white"/>
</p>
