Stack – Matching Delimiters

Description
This Java program uses a stack to check whether parentheses, brackets, and braces are correctly matched and nested.

Objectives
- Understand the LIFO principle.
- Practice push, peek, pop, and isEmpty operations.
- Check valid and invalid delimiter sequences.
- Display stack operations during execution.

Requirements
- Java Development Kit (JDK)
- Eclipse IDE or another Java IDE

How to Run
1. Open the project in Eclipse.
2. Open `MatchingDelimiters.java`.
3. Run the program.
4. Enter a delimiter sequence in the Console.
5. Review the result and stack execution trace.

Test Cases
| Input | Expected Result |
|---|---|
| `()` | Valid |
| `()[]{}` | Valid |
| `{[()]}` | Valid |
| `({[]})` | Valid |
| `{[(])}` | Invalid |
| `([)]` | Invalid |
| `{[()]` | Invalid |
| `{[()]}]` | Invalid |
| Empty input | Valid |
| `((a+b)*[c-d])` | Valid |

Screenshots
Actual screenshots of the source code and program execution are included in the repository.

AI Disclosure
AI assistance was used to help draft and explain the program. The student is responsible for reviewing, testing, understanding, and verifying the submitted code and results.
