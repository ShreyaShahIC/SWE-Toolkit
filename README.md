# SWE-Toolkit

Notes and working examples from Software Engineering module: Java and OOP from weeks 1–3, error handling from week 4, and Tutorials 1–4. Every class compiles, and every demo runs.

**To find something fast:** in IntelliJ press **Ctrl+Shift+F** (Find in Files) and search for a word like `ButtonGroup`, `finally` or `instanceof`. Every file starts with a comment saying what it shows.

**To run a demo:** open its class and click the green ▶ next to `main`.

---

## Where's the code for…

| I need to… | Look in |
|---|---|
| Casting, integer division, Strings, switch, loops, arrays, ArrayList | `basics/SyntaxReference` |
| A class with private fields and public methods | `basics/Calculator` |
| Read numbers from the keyboard with Scanner | `basics/StatsFromKeyboard` |
| Arrays + switch + static utility methods | `basics/ResistorCalculator` |
| Constructor validation, getters, objects passed to methods | `dosage/*` |
| Interface | `oop/Contactable`, `errors/Scanable` |
| Abstract class | `oop/Person`, `shapestudio/Shape`, `awtdrawing/Shape` |
| Subclass with `super(...)` and `@Override` | `oop/Patient`, `oop/ICUWard` |
| Overloading | `oop/ICUWard`, `oop/OopDemo` (`add`) |
| Static field / static method / static counter | `oop/Ward`, `oop/Patient` (`nextId`) |
| One list holding different classes (polymorphism) | `oop/Hospital`, `shapestudio/ShapeDB` |
| `instanceof` and downcasting | `oop/OopDemo` |
| Anonymous class / lambda | `oop/OopDemo`, `shapestudio/ShapeStudioMain` |
| Generics `<K, V>` | `oop/CallRecord` |
| Custom checked exception | `oop/InvalidNumberException`, `errors/ScanException` |
| Validated setter that throws | `oop/Patient.setMobileNum`, `oop/Doctor.setPagerNum` |
| Enum return codes | `errors/ScanErr`, `errors/UltrasoundInvestigation` |
| try / multiple catch / finally | `errors/UltrasoundInvestigation`, `errors/ExceptionBasics` |
| Unchecked exceptions (/ by zero, null, array index) | `errors/ExceptionBasics` |
| Logging | `errors/UltrasoundInvestigation` |
| A simulated (fake) device to try every error path | `errors/SimulatedScanner` |
| AWT window: Frame + Canvas + `paint` | `awtdrawing/AwtMain`, `awtdrawing/AwtDrawing` |
| Swing window: JFrame, BorderLayout, `invokeLater` | `shapestudio/ShapeStudioMain` |
| Drawing in Swing: `paintComponent` + `repaint()` | `shapestudio/Drawing` |
| Mouse click → shape at the cursor | `shapestudio/ShapeStudioMain`, `shapeui/DrawingUIController` |
| JComboBox, JSlider, JButton, JLabel | `shapestudio/ShapeStudioMain` |
| Radio buttons + ButtonGroup | `shapeui/ShapeSelector` |
| Colour chooser dialog | `shapeui/ColourSelector` |
| Label + slider in a nested GridLayout panel | `shapeui/SizeSelector` |
| GridLayout of control panels (coding from a design) | `shapeui/DrawingUIController` |
| Packages and package-private access | `shapestudio/ShapeDB` (only `Drawing` is public) |
| Undo / clear / count by type | `shapestudio/ShapeDB`, `shapestudio/Drawing` |

---

## Test-day timeline

| Time | Do |
|---|---|
| 9:00 | MCQ on paper (pen!). Finished early? Read the programming brief and sketch the classes. |
| 9:15 | Laptop open. Word brief from Canvas. |
| by 9:25 | New Gradle project, `Main` runs, **pushed to a public GitHub repo**. |
| every 20–30 min | Commit **and push**. |
| 11:10 | Stop adding features. Tidy names, delete dead code, comment. |
| 11:20 | Final push. Open the repo link in a **private browser window** and check the code is there. |
| by 11:30 | Email Mr Holloway the link. |

Only search with **noai.duckduckgo.com**. No AI tools at all.

---

## Git: getting code onto GitHub

**1. On github.com:** **+ → New repository**. Name it, choose **Public**, leave **"Add a README" unticked**, then **Create**. Copy the URL ending in `.git`.

**2. In IntelliJ's terminal (Alt+F12):**

```
git init                      (only if git status says "not a git repository")
git add .
git commit -m "First commit"
git branch -M main
git remote add origin https://github.com/ShreyaShahIC/REPO-NAME.git
git push -u origin main
```

**3. Every time after that:**

```
git add .
git commit -m "Add Patient class"
git push
```

Or in IntelliJ: **Ctrl+K** (commit) → tick everything, including **Unversioned Files** → **Commit and Push**.

| Error | Fix |
|---|---|
| `Author identity unknown` | `git config --global user.name "Shreya Shah"` and `git config --global user.email "you@example.com"`, then commit again |
| `remote origin already exists` | `git remote set-url origin https://github.com/ShreyaShahIC/REPO-NAME.git` |
| `rejected` / `fetch first` | The GitHub repo has a README you don't have. On a fresh repo: `git push -u origin main --force` |
| `permission denied to shreyabshah` | Git signed in as the wrong account. Windows: Credential Manager → Windows Credentials → remove `git:https://github.com`, then push again and sign in as ShreyaShahIC |
| `nothing to commit, working tree clean` | Already committed. You just need `git push` |
| Repo shows a "master had recent pushes" banner | Code went to branch `master`. Settings → General → Default branch → switch to `master` |

---

## build.gradle (Groovy)

```groovy
plugins {
    id 'java'
    id 'application'
}

application {
    mainClass = 'Main'            // if Main.java starts "package org.example;" use 'org.example.Main'
}

run {
    standardInput = System.in     // only needed for Scanner keyboard input
}

repositories {
    mavenCentral()
}
```

Refresh the Gradle window after every edit (the elephant icon).

---

## Copying a class from here into the test project

- **Easiest:** drag the `.java` file between projects in the Project panel. IntelliJ fixes the `package` line for you.
- **If you paste text instead:** change the first line `package oop;` to match the package you pasted into. Delete it if the file sits straight in `src/main/java`.
- **Rename everywhere:** Shift+F6 on the class name.
- **Missing import:** click the red word, then Alt+Enter.

---

## IntelliJ shortcuts

| Do this | Windows |
|---|---|
| Add import / quick fix | Alt+Enter |
| Generate constructor, getters, setters | Alt+Insert |
| Override methods | Ctrl+O |
| Implement interface methods | Ctrl+I |
| Find in all files | Ctrl+Shift+F |
| Commit / Push | Ctrl+K / Ctrl+Shift+K |
| Rename everywhere | Shift+F6 |
| Reformat code | Ctrl+Alt+L |
| Terminal | Alt+F12 |

Live templates (type, then Tab): `psvm` → `main`, `sout` → `System.out.println()`, `fori` → index loop, `iter` → for-each loop.

---

## The traps that cost marks

1. Compare Strings with `.equals()`, never `==`.
2. `super(...)` must be the first line of a subclass constructor.
3. Checked exceptions (`extends Exception`) need `throws` or a `catch`.
4. Specific `catch` blocks go before `catch (Exception e)`, or it won't compile.
5. `7 / 2 == 3` (integer division). Write `7 / 2.0` for 3.5. `(int) 3.9 == 3`.
6. `ArrayList<Integer>`, never `ArrayList<int>`.
7. Abstract classes and interfaces can't be created with `new` (except as an anonymous class).
8. Change the data, then call `repaint()`. Never call `paint` yourself.
9. Swing: `super.paintComponent(g)` first, and `setVisible(true)` last.
10. Local variables have no default value; fields default to 0, false or null.
11. Committed isn't submitted: push, then check the link.

---

## Definitions (week 1–3 notes)

- **Encapsulation:** bundling data with the methods that act on it, and hiding the data (private fields, getters and validating setters).
- **Inheritance:** a more specific class reuses the fields and methods of a general one (`extends`).
- **Polymorphism:** treating different classes the same way through a common type. Three kinds:
  - **subtype:** a superclass or interface reference, with overridden methods chosen at run time
  - **ad hoc:** overloading
  - **parametric:** generics
- **Abstraction:** hiding implementation details and exposing only what's essential. It's the broadest of the four, and the other three serve it.
- **Abstract class:** can't be instantiated. It can have fields, constructors and implemented methods, plus abstract ones that subclasses must implement. A class `extends` only one.
- **Interface:** a contract. Its methods are public and abstract (or static); its fields are `public static final`. A class can `implements` several.
- **Static:** belongs to the class, with one shared copy. Static methods can't use instance fields, and they're resolved at compile time, so there's no polymorphism.
- **final:** a variable can't be reassigned, a method can't be overridden, a class can't be extended.
- **JVM** runs bytecode (`.class`) on any OS: "write once, run anywhere". The **JIT** turns bytecode into native code at run time. **JRE** = JVM + libraries. **JDK** = JRE + compiler and tools. A `.jar` is a zip of `.class` files.
- **Checked exception:** must be caught or declared. **Unchecked** (`RuntimeException` subclasses): ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException, IllegalArgumentException.
- An exception that isn't caught passes **up the call stack**. If nothing handles it, the program stops and prints the stack trace.
- **finally** always runs, even after a `return`.

### Access modifiers

| Modifier | Same class | Same package | Subclass, other package | Anywhere |
|---|---|---|---|---|
| `public` | ✓ | ✓ | ✓ | ✓ |
| `protected` | ✓ | ✓ | ✓ | ✗ |
| none (package-private) | ✓ | ✓ | ✗ | ✗ |
| `private` | ✓ | ✗ | ✗ | ✗ |

### UML class diagrams

`+` public, `-` private, `#` protected, `~` package-private. *Italic* = abstract. A solid line with a hollow triangle = `extends`. A dashed line with a hollow triangle = `implements`. A plain line = association (usually a field of that type).

---

## Imports

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.awt.*;           // Color, Graphics, Point, BorderLayout, GridLayout, FlowLayout, Frame, Canvas
import java.awt.event.*;     // MouseAdapter, MouseEvent, ActionListener, ActionEvent, WindowAdapter, WindowEvent
import javax.swing.*;        // JFrame, JPanel, JButton, JSlider, JLabel, JComboBox, JRadioButton, ButtonGroup, JColorChooser, SwingUtilities
import javax.swing.event.*;  // ChangeListener, ChangeEvent
```
