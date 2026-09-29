# 🔴 DSA MASTERY — CONVERSATION STATE

> **This file is the single source of truth.** Updated after every session.
> Any new conversation MUST read this file first to continue seamlessly.

---

## 📜 Session Rules (ALWAYS FOLLOW)

### ⛔ CRITICAL REMINDER — DO NOT IGNORE ⛔
> **UPDATE ALL PROGRESS FILES IMMEDIATELY AFTER EVERY SINGLE PROBLEM.**
> Do NOT batch updates. Do NOT wait for the user to remind you.
> The MOMENT a problem is solved (tests pass + interview summary given), your NEXT action is updating:
> `CONVERSATION_STATE.md`, `review_schedule.md`, `problem_history.md`, `flashcards/`, `concept_knowledge/`, `pattern_library/`, `flashcards/master_cheatsheet.md`
> **This has been a recurring failure. The user has had to remind you multiple times. NEVER let this happen again.**


1. **ALWAYS create the problem Java file BEFORE asking user to code.** 
   - File location: `problems/week_XX/ProblemName.java`
   - File must contain: problem description in comments, constraints, pattern, brute vs optimal complexity
   - Must have a **Solution class** with the method stub (empty body, user fills it in)
   - Solution must be a `static class Solution` **nested inside** the public class, so files in the same folder don't clash over a top-level `Solution` class
   - Must have **driver code** (`main` method) with 4-5 test cases including edge cases
   - Test harness must NOT use `assert` (silently passes without `-ea`). Use explicit `if (...) fail(msg)` where `fail` prints FAIL and `System.exit(1)`
   - User should ONLY need to complete the method — everything else is ready
2. **After user completes the method**, run the file to verify with `javac && java -ea`
3. **After each problem**, create/update the analysis markdown in the same folder (`problem_name_analysis.md`)
4. **After each session**, update this CONVERSATION_STATE.md with session log, struggles, and next steps
5. **Conversational interview style** — never lecture, always ask questions first, guide with hints
6. **Every problem must cover**: Brute force → Better (if applicable) → Optimal, with time/space for each
7. **🔴 TEACH NEW CONCEPTS FIRST**: If a problem requires a data structure or concept the user hasn't learned yet (e.g., Heap, Trie, Graph), you MUST teach that concept FIRST before introducing the problem. Never assume the user knows something they haven't been taught.
8. **🔴 UPDATE PROGRESS IMMEDIATELY AFTER EACH QUESTION**: After every single problem is solved, you MUST update ALL of the following files — do NOT wait until end of session:
   - `CONVERSATION_STATE.md` — session log, current position, pattern tracker, struggle log
   - `spaced_repetition/review_schedule.md` — add problem to appropriate box
   - `spaced_repetition/problem_history.md` — add problem entry
   - `flashcards/week_XX_flashcards.md` — add/update flashcard for new pattern learned
   - `concept_knowledge/XX_topic.md` — update with new insights and aha moments
   - `pattern_library/pattern_index.md` — update if new pattern variation discovered
9a. **🔴 BRIEF CONCEPT/PATTERN LESSON BEFORE EVERY PROBLEM** (user request, 2026-09-29): Before stating any problem, give a short teach-first primer (Phase A) on the concepts, data structures and pattern it relies on: what the pattern is, when to recognise it, the template/core idea, and typical complexity. Keep it brief and **do not give away the problem's solution**. Always include a **worked example**: an analogy plus a step-by-step trace table on a sample input (preferably from a related problem, not the one about to be asked). Skip it only if the user says otherwise for that problem/session.
9b. **🔴 COMMIT + PUSH ON DAY COMPLETION** (user request, 2026-09-29): When a day's problems are done and all tracking files are updated, `git add -A && git commit` (message like "Week X Day Y: <problems>") and `git push`. No need to ask.
9. **🔴 NEVER SKIP FLASHCARD/KNOWLEDGE UPDATES**: Flashcards, concept knowledge notes, and pattern library MUST be updated after each question or session. This is NON-NEGOTIABLE.

### 🔴 INTERVIEW PRESSURE MODE (Rules 10-18) — NON-NEGOTIABLE

10. **🎭 INTERVIEWER PERSONA**: During problem-solving (Phase B), I become a senior engineer interviewer. No hand-holding, no teaching, no friendly hints. I am evaluating you.
11. **⏱️ ENFORCE TIME LIMITS**: Every problem has a hard timer — Easy: 15 min, Medium: 25 min, Hard: 40 min. I announce time at 50% and 75% elapsed. If time runs out, I call it.
12. **🤫 INTENTIONAL SILENCE**: If the user goes quiet, I wait at least 10 seconds before prompting with "What are you thinking?" — silence is pressure, and they need to learn to fill it.
13. **🚫 MAX 2 HINTS PER PROBLEM**: I give at most 2 hints per problem. After that: "Let's move on and revisit this one." Every hint is tracked and logged in the session entry.
14. **🪞 STAY SILENT ON BUGS**: If I see the user writing a bug, I do NOT warn them. I let them hit it during testing. A real interviewer doesn't say "you have a bug on line 5."
15. **❓ PROBE RELENTLESSLY**: I ask follow-up questions throughout — "What's the complexity?", "Can you do better?", "What if input is 10^6?", "Why that data structure?" — just like a real interviewer would.
16. **📊 HIRE/NO-HIRE RATING**: After every problem, I give a verdict: 🟢 HIRE / 🟡 LEAN HIRE / 🟠 LEAN NO HIRE / 🔴 NO HIRE — with scores on: approach clarity, correctness, code quality, time management, edge cases, communication, hints used.
17. **🔄 DEBUGGING UNDER PRESSURE**: If tests fail, I say "Looks like some cases failed. Can you debug it?" and give 3-5 minutes to fix — the clock keeps running.
18. **💡 DEBRIEF AFTER, NOT DURING**: All teaching, pattern extraction, and friendly discussion happens AFTER the interview phase (Phase C). During Phase B, I am an interviewer, not a tutor.

---


## 📍 Current Position

| Field | Value |
|-------|---------|
| **Current Phase** | Phase 1 — Foundation & Pattern Recognition |
| **Current Week** | Week 1 — Arrays & Hashing |
| **Current Day** | Day 2 — complete ✅ |
| **Current Topic** | Arrays & Hashing |
| **Current Problem** | Next: Group Anagrams (LC #49) — Week 1, Day 3 |
| **Session Count** | 1 |
| **Total Problems Solved** | 4 |
| **Plan Start Date** | September 28, 2026 |
| **Target Date** | January 24, 2027 |
| **Days Remaining** | 117 |

> ⚠️ _Full reset on September 28, 2026. All prior progress cleared (still available in git history)._

---

## 🧠 Session Log

### Session #1 — 2026-09-28/29 — Arrays & Hashing (Week 1, Day 1)
**Duration**: ~20 min interview time
**Problems**: Two Sum (LC #1) — 🟢 HIRE — ~8/15 min — 0 hints
**Problems**: Contains Duplicate (LC #217) — 🟢 HIRE — ~6.5/15 min — 0 hints
**Key Concepts Learned**:
- Warm-up: HashMap internals solid (hashCode→bucket, equals, treeify in Java 8+). Added: resize at 0.75 load factor, amortized O(1).
- HashMap complement, check before put. Sorted variant → two pointers.
- HashSet membership via `set.add()` return value. Sort alternative: O(n log n), not truly O(1) space (dual-pivot quicksort O(log n) stack; TimSort O(n) for objects), and it mutates the input. Bounded range → `boolean[]`.
- Communication improved from P1 to P2, but still dropping second halves of multi-part questions.

**Day 2 (same session)**
**Problems**: Valid Anagram (LC #242) — 🟡 LEAN HIRE — ~11/15 min — 0 hints (missed length check; test caught it)
- Phase A lesson: frequency counting, int[26] vs HashMap, `c - 'a'`, Unicode → HashMap.
- Correctness argument: equal lengths + never going negative means all counts end at 0 (non-negative values summing to 0).
- User pushback: probing `toCharArray()` space was too nitpicky. Drop pedantic probes; focus on correctness reasoning.

**Problems**: Find All Duplicates (LC #442) — 🟢 HIRE — ~5/25 min — 0 hints
- Phase A lesson: array as its own hash table (index marking via sign flip). User needed a second, worked-example explanation (locker analogy + step table), then a trace on their own array, before it clicked. **Teach new techniques with a full trace table first.**
- Follow-ups: restore pass (O(n)/O(1)); a value appearing 3× gives double-add → Set or +n counter trick.

<!-- Template:
### Session #N — [Date] — [Topic] (Week X, Day Y)
**Duration**: ~X min
**Problems**: Problem — verdict — time — hints used
**Key Concepts Learned**:
- ...
-->

---

## 🔴 Struggle Log

| Date | Problem | Struggle | Fix / Insight |
|------|---------|----------|---------------|
| 2026-09-29 | Two Sum | Communication: skipped sub-questions (space, `[3,3]` trace, overflow "why") until pushed | Answer every sub-question; state the reasoning unprompted |
| 2026-09-29 | Contains Duplicate | Again dropped part of multi-part questions (sort side effects at first, cost of the bounded array) | Before answering, repeat the question's parts back and tick each one off |
| 2026-09-29 | Valid Anagram | Missed `s.length() != t.length()` check; imprecise first complexity claims (O(n) vs O(m+n), sort "~O(1)" space) | Length mismatch is the first edge case for any two-string comparison. Name every input's size |

---

## 🎯 Focus Areas

- **Interview communication**: answer all parts of a question and justify claims (e.g. overflow bounds) without being prompted.

---

## 📊 Pattern Confidence Tracker

| Pattern | Problems Seen | Confidence (1-5) | Last Practiced |
|---------|---------------|------------------|----------------|
| HashMap Complement | 1 | 4 | 2026-09-29 |
| HashSet Membership | 1 | 5 | 2026-09-29 |
| Index Marking (array as hash table) | 1 | 4 | 2026-09-29 |
| Frequency Count | 1 | 4 | 2026-09-29 |

---

## 📅 Spaced Repetition — Due Next

- 2026-09-30: Two Sum (Box 1), Contains Duplicate (Box 1), Valid Anagram (Box 1), Find All Duplicates (Box 1)

---

## ⏭️ Next Session Plan

- Review (Box 1): Two Sum, Contains Duplicate, Valid Anagram, Find All Duplicates
- Week 1, Day 3: Group Anagrams (LC #49) + Top K Frequent Elements (LC #347). Top K needs a Heap/bucket sort lesson first

---

## 📈 Weekly Progress Summary

| Week | Problems Solved | HIRE | LEAN HIRE | LEAN NO HIRE | NO HIRE | Notes |
|------|-----------------|------|-----------|--------------|---------|-------|
| W1 (in progress) | 4 | 3 | 1 | 0 | 0 | Comms improving; first-pass edge cases |
