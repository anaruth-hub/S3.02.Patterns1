<div align="center">

# Design Patterns Implementation – SOLID Principles (S3.02)

<p>
  <strong>Java 17+ · Maven · JUnit 5 · IntelliJ IDEA</strong>
</p>

<p>
  This project demonstrates the implementation of three fundamental design patterns in Java — <strong>Singleton</strong>, <strong>Abstract Factory</strong>, and <strong>Strategy</strong> — applying <strong>SOLID principles</strong> to build clean, scalable, extensible, and loosely coupled code.
  <br/>
  The objective is to understand how design patterns improve maintainability and prevent future refactoring issues.
</p>

<!-- Badges -->
<p>
  <img alt="Java" src="https://img.shields.io/badge/Java-17%2B-informational" />
  <img alt="Maven" src="https://img.shields.io/badge/Build-Maven-informational" />
  <img alt="JUnit5" src="https://img.shields.io/badge/Tests-JUnit%205-informational" />
  <img alt="IDE" src="https://img.shields.io/badge/IDE-IntelliJ%20IDEA-informational" />
</p>

</div>

---

## Table of Contents
- [📌 Exercise Statement](#-exercise-statement)
- [✨ Features](#-features)
- [🛠 Technologies](#-technologies)
- [🚀 Installation and Execution](#-installation-and-execution)
- [📸 Demo](#-demo)
- [🧩 Diagrams & Technical Decisions](#-diagrams--technical-decisions)
- [SOLID Principles Applied](#solid-principles-applied)

---

## 📌 Exercise Statement

This assignment is divided into three levels:

### 🔹 Level 1 – Singleton Pattern

Implement a class `Undo` that simulates a command history system:

- Store commands
- Undo the last command
- Show command history

The class must guarantee a single shared instance across the application.

### 🔹 Level 2 – Abstract Factory Pattern

Build an international contact manager that:

- Formats addresses and phone numbers depending on the country
- Supports multiple countries without modifying existing code
- Allows easy extension for new countries

### 🔹 Level 3 – Strategy Pattern

Develop a report generation system that:

- Supports multiple output formats (HTML, JSON, XML, PDF, CSV, Excel, Word)
- Allows runtime strategy changes
- Follows Open/Closed Principle and Dependency Inversion Principle

---

## ✨ Features

### ✅ Singleton
- Private constructor
- Static `getInstance()` method
- Shared command history
- Stack-based undo mechanism
- Fully tested with unit tests

### ✅ Abstract Factory
- Abstract products: Address, Phone
- Abstract factory: ContactFactory
- Concrete factories: Spain & USA
- Decoupled client (Contact)
- Easily extensible for new countries

### ✅ Strategy
- ReportStrategy interface
- Multiple concrete implementations (HTML, JSON, XML, PDF, CSV, Excel, Word)
- Runtime strategy switching
- Clean separation between context and algorithms
- Tested through JUnit

---

## 🛠 Technologies

- Frontend: Not applicable (Backend-only exercise)
- Backend: Java 17+
- Testing: JUnit 5
- Build Tool: Maven
- IDE: IntelliJ IDEA

---

## 🚀 Installation and Execution

### Clone the repository
```bash
git clone https://github.com/anaruth-hub/S3.02.Patterns1.git

📸 Demo

Console output examples:

Singleton
mkdir folder
cd folder
undo -> cd folder removed

Abstract Factory
Address: Carrer Major 34, 08001 Barcelona | Phone: +34 123456789
Address: 154 5th Avenue, New York, NY 10001 | Phone: +1 987654321

Strategy
JSON:
{"title":"Weekly Report","date":"2026-02-18","lines":["Line A","Line B"]}

HTML:
<html><body>...</body></html>

🧩 Diagrams & Technical Decisions
Architectural Decisions

Singleton

Ensures one global shared state.

Prevents multiple command histories.

Encapsulation enforced through private constructor.

Abstract Factory

Reduces coupling between client and concrete implementations.

Supports Open/Closed Principle.

Enables scalable country-based formatting system.

Strategy

Replaces conditional logic (if/switch) with composition.

Allows runtime behavior change.

Promotes extensibility and maintainability.

SOLID Principles Applied

S – Single Responsibility
Each class has one clear responsibility.

O – Open/Closed
New strategies or factories can be added without modifying existing code.

L – Liskov Substitution
All implementations respect their abstract contracts.

I – Interface Segregation
Small, focused interfaces (ReportStrategy, Address, Phone).

D – Dependency Inversion
High-level modules depend on abstractions, not concrete implementations.