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
   - Must have **driver code** (`main` method) with 4-5 test cases including edge cases
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
| **Current Week** | Week 4 — Stack & Queue |
| **Current Day** | Day 3 — ✅ COMPLETE (Next Greater Element I + Largest Rectangle in Histogram, both 🟢 HIRE) |
| **Current Topic** | Week 4 Day 4 next |
| **Current Problem** | TBD — Week 4 Day 4 (Car Fleet LC #853 + Implement Queue using Stacks LC #232) |
| **Session Count** | 25 |
| **Total Problems Solved** | 38 (new plan) + 4 re-solves |
| **Plan Start Date** | June 15, 2026 |
| **Original Start Date** | May 10, 2026 |
| **Target Date** | October 11, 2026 |
| **Days Remaining** | 87 |

---

## 🧠 What We've Learned So Far

### Session Log

---

<details>
<summary>📂 ARCHIVED PRE-PLAN SESSIONS (May 8–17, 2026) — Click to expand</summary>

### Session #1 — May 8, 2026 — Arrays & Hashing (Day 1)
**Duration**: ~45 min
**Problems Covered**: 
- Two Sum (LC #1): ✅ Solved cleanly, zero bugs
- Contains Duplicate (LC #217): ✅ Solved cleanly, zero bugs
- Valid Anagram (LC #242): ✅ Solved cleanly, zero bugs

**Key Concepts Learned**:
- HashMap for O(1) complement lookup (element→index mapping)
- HashSet for O(1) membership checking ("have I seen this before?")
- `set.add()` returns false if element exists — combine check + insert in one call
- `int[26]` with `ch - 'a'` for fixed lowercase charset frequency counting
- Check-before-insert in HashMap to avoid self-pairing (Two Sum)
- Length check as early exit optimization (Valid Anagram)

**Aha Moments**:
- "HashSet is enough when I don't need key→value — just existence checking"
- "int[26] beats HashMap when charset is fixed — O(1) space, no boxing overhead"

**Struggles**:
- None! All 3 problems solved with zero implementation bugs.

**Code Implementation Notes**:
- 🌟 Flawless Day 1 — all approaches explained correctly before coding
- Used idiomatic Java: `!set.add(n)` for Contains Duplicate
- Clean early exits, proper variable naming throughout

**Pattern Extracted**:
- HashMap Complement Lookup → find pair summing to target
- HashSet Membership Check → detect duplicates / "seen before"
- Frequency Counting int[26] → compare character distributions

### Session #2 — May 8, 2026 — Arrays & Hashing (Day 2)
**Duration**: ~45 min
**Problems Covered**: 
- Group Anagrams (LC #49): ✅ Solved with 3 bugs in brute force (missing sort, arr.toString(), Collection cast), fixed with guidance. Optimal solved cleanly.

**Key Concepts Learned**:
- HashMap Grouping pattern: group elements by a shared property
- Key design is critical: sorted string key O(k log k) vs frequency key O(k)
- `Arrays.toString(int[])` converts frequency array to a usable HashMap key
- `computeIfAbsent(key, k -> new ArrayList<>()).add(val)` — cleaner than if/else
- `char[].toString()` returns memory address, NOT string content — use `new String(arr)`

**Struggles**:
- Brute force had 3 implementation bugs: forgot Arrays.sort(), used arr.toString() instead of new String(arr), cast Collection to List
- Needed guidance to break down the grouping concept initially

**Code Implementation Notes**:
- Clean helper method separation (getFreqKey)
- Optimal approach implemented correctly after understanding the concept

**Pattern Extracted**:
- HashMap Grouping → group elements by shared property using HashMap<property, List<element>>

### Spaced Repetition Recall — May 12, 2026
- Two Sum: ✅ Pattern + approach recalled (complexity correct, approach description could be crisper)
- Contains Duplicate: ✅ Pattern + approach + !set.add() trick recalled
- Valid Anagram: ✅ Pattern + approach recalled (forgot to mention length early exit)
- Group Anagrams: ✅ Pattern + approach recalled (complexity had minor error: said O(n log k) instead of O(n·k log k))

### Session #3 — May 17, 2026 — Arrays & Hashing (Top K Frequent)
**Duration**: ~25 min
**Problems Covered**: 
- Top K Frequent Elements (LC #347): ⚡ Solved both approaches with guidance. Brute force (sort by freq) zero bugs. Bucket sort had 2 bugs (int[] instead of List[], missing inner loop bound check), fixed with hints.

**Key Concepts Learned**:
- Frequency Map + Sort = brute force for any "top K by frequency" problem
- **Bucket Sort trick**: use frequency as array index → O(n) instead of O(n log n)
- When bucket can hold multiple elements, must use `List[]` not `int[]`
- Inner loop boundary guards: always check `ptr >= k` before writing to result array
- `map.getOrDefault(key, 0) + 1` — clean frequency counting idiom
- Custom comparator with map lookup: `(a, b) -> map.get(b) - map.get(a)`

**Struggles**:
- Initially frustrated, couldn't see direction from freq map to answer
- Bucket sort: used int[] instead of List[] (overwrites when same frequency)
- Missing bound check in inner loop caused ArrayIndexOutOfBoundsException

**Code Implementation Notes**:
- Brute force implemented cleanly on first try — zero bugs!
- Bucket sort took 3 iterations to fix (int[]→List[], missing inner bound check)
- Good instinct on using `getOrDefault` for freq map building

**Pattern Extracted**:
- Frequency Count + Bucket Sort → when you need "top K by frequency" in O(n)
- Key insight: **frequency as array index** eliminates sorting

<!-- 
TEMPLATE for each session entry:
### Session #N — [Date] — [Topic]
**Duration**: ~X min
**Problems Covered**: 
- Problem 1: [status: solved/struggled/needs-review]
- Problem 2: [status]

**Key Concepts Learned**:
- Point 1
- Point 2

</details>

---

### New Plan Sessions (Starting June 15, 2026)

> ⚠️ _Progress reset on June 15, 2026. Previous sessions archived below._

### Session #1 — June 15, 2026 — Arrays & Hashing (Week 1, Day 1)
**Status**: ✅ COMPLETE
**Duration**: ~20 min

**Spaced Repetition Recall Results (7 prior problems)**:
- Two Sum (LC #1): ✅ Perfect — pattern, approach, complexity all correct
- Contains Duplicate (LC #217): ✅ Perfect — remembered `!set.add()` idiom
- Valid Anagram (LC #242): ✅ Perfect — 🎉 **LENGTH EARLY-EXIT MENTIONED FIRST** (fixed recurring miss!)
- Group Anagrams (LC #49): ✅ Solid — minor: brute TC should be O(n·m log m) not O(n log m)
- Top K Frequent (LC #347): ✅ Solid — bucket sort locked in. Minor: brute = sort by freq, not raw array sort
- Two Sum II (LC #167): ✅ Perfect — great trade-off reasoning (sorted → two ptr saves space)
- Product Except Self (LC #238): ✅ Solid — minor: brute is O(n²) not O(n³), naming mix-up in optimization

**Recall Verdict**: 7/7 recalled. Strong retention across all prior problems.

**Problems Covered**:
- Two Sum (LC #1): ✅ Re-solve — 🟡 LEAN HIRE. Had initial compile error (missing brace) + Test 1 returned [0,0] (bug: wrote to `nums` instead of `result`). Debugged and fixed. Zero hints. Code quality clean (`complementPair` naming, proper HashMap usage).
- Contains Duplicate (LC #217): ✅ Re-solve — 🟢 HIRE. Flawless. First-try pass on all 5 tests, zero bugs, zero hints. Idiomatic `!set.add(n)`. ~3 min.

**Key Observations**:
- Spaced repetition recall is excellent — all 7 patterns retained
- Valid Anagram length early-exit habit is FINALLY locked in ✅
- Two Sum had a typo bug (`nums` instead of `result`) — need to double-check target variables
- Contains Duplicate was flawless — this is the standard to aim for
- Day 1 complete! Ready for Day 2 (Valid Anagram + Two Sum II)

### Session #2 — June 17, 2026 — Arrays & Hashing (Week 1, Day 2)
**Status**: ✅ COMPLETE
**Duration**: ~15 min

**Spaced Repetition Recall Results (2 Box 1 problems)**:
- Two Sum (LC #1): ✅ Perfect — pattern, approach, complexity recalled instantly → **Promoted to Box 2**
- Contains Duplicate (LC #217): ✅ Perfect — pattern, `!set.add()` idiom, complexity → **Promoted to Box 2**

**Problems Covered**:
- Valid Anagram (LC #242): ✅ Re-solve — 🟢 HIRE. Length early-exit FIRST LINE ✅. All 5 tests passed first try. Zero bugs, zero hints. ~5 min. **Length early-exit struggle officially RESOLVED** (3 consecutive sessions with it).
- Two Sum II (LC #167): ✅ Re-solve — 🟡 LEAN HIRE. Correct approach, clean code. Initial bug: returned 0-indexed `[0,1]` instead of 1-indexed `[1,2]`. Self-debugged and fixed. Zero hints. ~5 min.

**Key Observations**:
- Length early-exit is now habit — 🟢 RESOLVED after 3 consecutive correct sessions
- New attention pattern needed: re-read output specification before returning (0-indexed vs 1-indexed)
- Both spaced repetition problems promoted to Box 2 — strong retention
- Day 2 complete! Ready for Day 3 (Group Anagrams + Top K Frequent)

### Session #3 — June 17, 2026 — Arrays & Hashing (Week 1, Day 3)
**Status**: ✅ COMPLETE
**Duration**: ~20 min

**Problems Covered**:
- Group Anagrams (LC #49): ✅ Re-solve — 🟢 HIRE. Freq key approach with helper function. All 5 tests first try. Zero bugs, zero hints. ~6 min. Used `Arrays.toString(freqArr)` correctly (fixed May 8 `arr.toString()` mistake permanently).
- Top K Frequent Elements (LC #347): ✅ Re-solve — 🟢 HIRE. Bucket sort approach. All 5 tests first try. Zero bugs, zero hints. ~16 min. Used `List[]` correctly (fixed May 17 `int[]` mistake permanently). Minor: inner loop missing `ptr < k` guard (safe due to constraint but not defensive).

**Key Observations**:
- Both problems 🟢 HIRE — massive improvement from original solves
- Group Anagrams: May 8 had 3 bugs → today zero bugs. Pattern fully locked in.
- Top K Frequent: May 17 had 2 bugs + hints → today zero bugs, zero hints. Bucket sort locked in.
- HashMap grouping + Bucket sort patterns both at confidence 5
- Minor improvement area: add defensive `ptr < k` guard in inner loops
- Day 3 complete! Ready for Day 4 (Product of Array Except Self + Longest Consecutive Sequence)

### Session #4 — June 18, 2026 — Arrays & Hashing (Week 1, Day 4)
**Status**: ✅ COMPLETE
**Duration**: ~35 min

**Spaced Repetition Recall Results (4 Box 1 problems)**:
- Valid Anagram (LC #242): ✅ Perfect — pattern, approach, complexity recalled. Note: said SC O(n) instead of O(1) for int[26]. Corrected. → **Promoted to Box 2**
- Two Sum II (LC #167): ✅ Perfect — pattern, pointer movement, complexity all correct → **Promoted to Box 2**
- Group Anagrams (LC #49): ✅ Perfect — freq key approach, both options explained, complexity correct → **Promoted to Box 2**
- Top K Frequent (LC #347): ✅ Solid — approach correct, but said TC is O(m·n) instead of O(n). Corrected. → **Promoted to Box 2**

**Problems Covered**:
- Product Except Self (LC #238): ✅ Re-solve — 🟢 HIRE. O(1) space optimization flawless. All 5 tests first try. Zero bugs, zero hints. ~11 min. Massive improvement from Jun 10 (2 debug iterations → zero).
- Longest Consecutive Sequence (LC #128): ✅ NEW — 🟢 HIRE. First time seeing this problem. All 5 tests first try. Zero bugs, zero hints. ~10 min. Concept teach needed for O(n) amortized analysis.

**Key Observations**:
- **4-problem HIRE streak** continues (6 total: Group Anagrams, Top K, Product Except Self, Longest Consecutive)
- Recall minor issues: said O(n) space for int[26] (should be O(1)), said O(m·n) for bucket sort (should be O(n)). Know the approaches but complexity articulation needs sharpening.
- Longest Consecutive: initially didn't understand why nested loop is O(n). Needed concrete step-by-step example. Now understood — **amortized analysis** concept clicked.
- Smart code decision: iterated over `set` instead of `nums` to naturally handle duplicates.
- **New session rule**: Track nuance notes (complexity reasoning, exact mistakes, conceptual gaps) in analysis markdown files for reference.
- Day 4 complete! Ready for Day 5 (Encode and Decode Strings + Valid Sudoku)

### Session #5 — June 20, 2026 — Arrays & Hashing (Week 1, Day 5)
**Status**: ✅ COMPLETE
**Duration**: ~45 min

**Spaced Repetition Recall Results (4 problems due)**:
- Product Except Self (LC #238): ✅ Perfect — pattern, approach (running postfix variable), complexity all correct → **Promoted to Box 2**
- Longest Consecutive Sequence (LC #128): ✅ Solid — approach correct, amortized reasoning slightly vague but corrected → **Promoted to Box 2**
- Two Sum (LC #1): ✅ Correct — initially misread as Two Sum II (reading error, not knowledge gap). Corrected and recalled HashMap complement approach → **Promoted to Box 3**
- Contains Duplicate (LC #217): ✅ Perfect — `!set.add()` idiom recalled instantly → **Promoted to Box 3**

**Problems Covered**:
- Encode and Decode Strings (LC #271): ⚡ NEW — 🟢 HIRE. Needed concept teach (length-prefix pattern). Encode solved independently. Decode needed 1 hint (pointer-based traversal with indexOf). All 5 tests first run. Minor nits cleaned (unused `char[] chars`, debug print).
- Valid Sudoku (LC #36): ✅ NEW — 🟢 HIRE. Concept teach on box index formula `(r/3)*3 + (c/3)`. All 5 tests first try. Zero bugs, zero hints. ~15 min. Elegant `!set.add()` triple-check in one boolean expression. Initialized HashSet arrays in loop (avoided NullPointerException without being warned).

**Key Observations**:
- **8-problem 🟢 HIRE streak** (Group Anagrams, Top K, Product Except Self, Longest Consecutive, Encode/Decode, Valid Sudoku)
- Pattern transfer in action: reused `!set.add()` idiom from Contains Duplicate in Valid Sudoku's triple-check
- Length-prefix is a design/serialization pattern — different flavor from algorithmic patterns. Good exposure.
- Box index formula `(r/3)*3 + (c/3)` derived independently after hint about integer division
- Recall: Two Sum vs Two Sum II misread — reminder to read problem titles carefully in interviews
- Amortized O(n) reasoning for Longest Consecutive Sequence tightened: "each element consumed by exactly one sequence"
- Day 5 complete! Week 1 Arrays & Hashing approaching completion. Ready for Day 6.

### Session #6 — June 21, 2026 — Arrays & Hashing (Week 1, Day 6)
**Status**: ✅ COMPLETE
**Duration**: ~30 min

**Spaced Repetition Recall Results (6 problems due)**:
- Encode and Decode Strings (LC #271): ✅ Solid — length-prefix pattern, encode/decode steps, O(n) indexOf reasoning → **Promoted to Box 2**
- Valid Sudoku (LC #36): ✅ Solid — HashSet per row/col/box, box formula correct. Minor: said SC O(n) instead of O(n²) → **Promoted to Box 2**
- Valid Anagram (LC #242): ✅ Perfect — length early-exit FIRST (4th consecutive!) → **Promoted to Box 3**
- Two Sum II (LC #167): ✅ Perfect — two pointer approach and complexity correct → **Promoted to Box 3**
- Group Anagrams (LC #49): ✅ Perfect — went straight to optimal freq key approach → **Promoted to Box 3**
- Top K Frequent (LC #347): ✅ Perfect — bucket sort, n+1 size reasoning explained → **Promoted to Box 3**

**Problems Covered**:
- Subarray Sum Equals K (LC #560): ✅ NEW — 🟢 HIRE. Concept teach on prefix sum + HashMap first. All 5 tests passed. Zero hints. Caught incorrect test case expectation (6, not 4). Used prefixSum array (minor: could use running variable). Clean implementation.

**Key Observations**:
- **9-problem 🟢 HIRE streak** continues! (Group Anagrams, Top K, Product Except Self, Longest Consecutive, Encode/Decode, Valid Sudoku, Subarray Sum Equals K)
- Spaced repetition: 6/6 recalled. All promoted. Zero in Box 1 (before new problem).
- New pattern learned: Prefix Sum + HashMap = Two Sum pattern applied to running sums
- Key insights locked in: {0:1} initialization, HashMap count vs existence, running sum optimization
- Caught interviewer's incorrect test case — strong debugging instinct
- Minor optimization available: replace prefixSum array with running variable (still O(n) SC due to HashMap)
- Day 6 complete! Ready for Day 7 (Weekly Challenge).

### Session #7 — June 22, 2026 — Arrays & Hashing (Week 1, Day 7 — 🔥 Weekly Challenge)
**Status**: ✅ COMPLETE
**Duration**: ~50 min total

**Spaced Repetition Recall Results (1 problem due)**:
- Subarray Sum Equals K (LC #560): ✅ Solid — pattern, approach, complexity recalled. Minor: said `k - sum` instead of `sum - k` (corrected). {0:1} reasoning slightly imprecise but correct intent. → **Promoted to Box 2**

**Problems Covered**:
- Contiguous Array (LC #525): ✅ NEW (UNSEEN CHALLENGE) — 🟡 LEAN HIRE. Zero hints, zero bugs, all 5 tests first try. Key insight: treat 0 as -1, reduces to "subarray sum = 0" (Prefix Sum + HashMap variant). Knew to store first occurrence only (max length vs count). Clean ternary, proper `else` for first-occurrence-only logic. **However**, took ~45 min (limit 25 min) — approach formulation was slow.
- Sort Characters By Frequency (LC #451): ✅ NEW (UNSEEN CHALLENGE) — 🟢 HIRE. Zero hints, zero bugs, all 5 tests first try. **~3 minutes**. Instantly connected to Top K Frequent bucket sort pattern. Clean StringBuilder, null-check on buckets, getOrDefault. Perfect pattern transfer.

**Key Observations**:
- **Pattern transfer proven**: Both unseen problems solved using Week 1 patterns independently
- Contiguous Array: Prefix Sum + HashMap variant (transform 0→-1, store first occurrence for max length)
- Sort Chars By Frequency: Bucket sort pattern transfer from Top K Frequent (~3 min, flawless)
- HIRE streak: 10 (including Sort Chars By Freq). Contiguous Array was LEAN HIRE due to time only.
- Time management split: Problem 1 slow (~45 min), Problem 2 blazing fast (~3 min). Speed correlates with pattern familiarity.
- 🎉 **WEEK 1 COMPLETE!** Arrays & Hashing mastered. Ready for Week 2 (Two Pointers & Sorting).

### Session #8 — June 23, 2026 — Two Pointers & Sorting (Week 2, Day 1)
**Status**: ✅ COMPLETE
**Duration**: ~30 min

**Spaced Repetition Recall Results (4 problems due)**:
- Contiguous Array (LC #525): ✅ Solid — pattern, approach (0→-1, first occurrence), complexity recalled. Said "complement search" instead of "Prefix Sum + HashMap" but understood the mechanic. → **Promoted to Box 2**
- Product Except Self (LC #238): ✅ Perfect — pattern, O(1) space approach (prefix into answer array, running suffix variable), complexity all correct → **Promoted to Box 3**
- Longest Consecutive Sequence (LC #128): ✅ Solid — HashSet, sequence start detection, amortized reasoning ("somebody else will pick it up") → **Promoted to Box 3**
- Sort Characters By Frequency (LC #451): ✅ Perfect — bucket sort, List[] of size n+1, iterate right-to-left, complexity correct → **Promoted to Box 2**

**Concept Teach**: Two Pointers & Sorting
- Reviewed why opposite-end two pointers work: sorted data gives monotonic guarantee
- Key insight: "moving a pointer eliminates an entire row/column of possibilities"
- Introduced the two-pointer family: opposite ends, same direction (read/write), sort as preprocessing

**Problems Covered**:
- Valid Palindrome (LC #125): ✅ NEW — 🟢 HIRE. Two pointers inward, skip non-alphanumeric with `continue`. All 5 tests first try. Zero bugs, zero hints. ~6 min. Clean `Character.isLetterOrDigit()` and `Character.toLowerCase()` usage.
- 3Sum (LC #15): ⚡ NEW — 🟡 LEAN HIRE. Sort + fix one + two pointers. 2 hints used: (1) `k` initialized outside for loop instead of inside, (2) extra `j++/k--` outside if/else causing double movement. Approach explained correctly before coding. Duplicate skipping for `i` done independently, for `j`/`k` needed guidance on placement (inside else block, after finding triplet). All 5 tests passed after fixes. ~20 min.

**Key Observations**:
- **Spaced rep 4/4 recalled**, all promoted. Zero Box 1 problems remaining.
- Valid Palindrome: Flawless. Skip-with-continue pattern is clean and reusable.
- 3Sum: Algorithm knowledge was solid — struggled with **code structure** (where pointer movements go). Two bugs were structural, not algorithmic.
- **New struggle pattern identified**: placing shared vs branch-specific logic in if/else blocks. Rule: each branch should be self-contained.
- Duplicate skipping placement: only skip AFTER recording a result, not before computing.
- Week 2 Day 1 complete! Ready for Day 2 (Container With Most Water + more two-pointer).

### Session #9 — June 25, 2026 — Two Pointers & Sorting (Week 2, Day 2)
**Status**: ✅ COMPLETE
**Duration**: ~25 min

**Spaced Repetition Recall Results (5 problems due)**:
- Valid Palindrome (LC #125): ✅ Perfect — pattern, approach (skip non-alphanumeric, compare lowercase), O(n)/O(1) → **Promoted to Box 2**
- 3Sum (LC #15): ✅ Excellent — All 3 prior bugs addressed: k inside loop, self-contained branches, dup skip inside else after triplet → **Promoted to Box 2**
- Encode and Decode Strings (LC #271): ✅ Solid — approach correct, decode logic clear. Pattern name corrected (Length-Prefix, not two pointer) → **Promoted to Box 3**
- Valid Sudoku (LC #36): ✅ Confirmed after formula clarification (typo in chat, full formula confirmed: (row/3)*3+(col/3)) → **Promoted to Box 3**
- Subarray Sum Equals K (LC #560): ✅ Solid — Prefix Sum + HashMap, check sum-k. Minor: didn't mention {0:1} initialization → **Promoted to Box 3**

**Problems Covered**:
- Container With Most Water (LC #11): ✅ NEW — 🟢 HIRE. Greedy two pointers, move shorter side. All 5 tests first try. Zero bugs, zero hints. ~4 min. Clean naming (leftHeight, rightHeight, maxArea). Greedy reasoning: moving taller side can only decrease area.
- Trapping Rain Water (LC #42): ✅ NEW HARD — 🟢 HIRE. Two pointers + maxLeft/maxRight, process smaller max side. All 5 tests first try. Zero bugs, zero hints. ~5 min. Articulate explanation: "smaller max is the bottleneck". Proactive null/empty check. Step comments in code.

**Key Observations**:
- **5/5 spaced rep recalled**, all promoted. Strong retention.
- **12-problem 🟢 HIRE streak** continues! (Group Anagrams, Top K, Product Except Self, Longest Consecutive, Encode/Decode, Valid Sudoku, Subarray Sum, Sort Chars, Valid Palindrome... and now Container + Trapping Rain Water)
- First Hard problem solved flawlessly — zero bugs, zero hints, ~5 min. Exceptional.
- Greedy two-pointer reasoning is clicking: understand WHY we move a specific pointer, not just how.
- Container vs Trapping: same skeleton (two pointers from ends), different greedy reasoning (shorter side vs smaller max).
- 3Sum recall shows all 3 code-structure bugs from Session #8 are resolved in memory.
- Day 2 complete! Ready for Day 3 (Move Zeroes + Sort Colors).

### Session #10 — June 28, 2026 — Two Pointers & Sorting (Week 2, Day 3)
**Status**: ✅ COMPLETE
**Duration**: ~30 min

**Spaced Repetition Recall Results (12 problems due — 4 overdue + 8 due today)**:
- Container With Most Water (LC #11): ✅ Perfect — two pointers, move shorter side, O(n)/O(1) → **Promoted to Box 2**
- Trapping Rain Water (LC #42): ✅ Solid — correct logic, said "minLeft" instead of "maxLeft" (naming not concept) → **Promoted to Box 2**
- Contiguous Array (LC #525): ✅ Excellent — transform 0→-1, first-occurrence HashMap, {0:-1} init with reasoning → **Promoted to Box 3**
- Sort Characters By Frequency (LC #451): ✅ Perfect — bucket sort, List[] n+1, right-to-left → **Promoted to Box 3**
- Two Sum (LC #1): ✅ Perfect — check-before-insert, complement lookup → **Stays Box 3**
- Contains Duplicate (LC #217): ✅ Perfect — !set.add() idiom → **Stays Box 3**
- Valid Palindrome (LC #125): ✅ Perfect — skip non-alphanumeric, compare lowercase → **Promoted to Box 3**
- 3Sum (LC #15): ✅ Excellent — all 3 prior bugs addressed in recall → **Promoted to Box 3**
- Valid Anagram (LC #242): ✅ Correct approach. Missed length early-exit in chat (fast typing). SC said O(n) instead of O(1) → **Promoted to Box 4**
- Two Sum II (LC #167): ✅ Perfect — sorted → two pointers, O(n)/O(1) → **Promoted to Box 4**
- Group Anagrams (LC #49): ✅ Perfect — freq key + HashMap grouping → **Promoted to Box 4**
- Top K Frequent (LC #347): ✅ Perfect — bucket sort + freq map → **Promoted to Box 4**

**Concept Teach**: Same-direction two pointers (write/read pointer), Dutch National Flag (3-way partition with lo/mid/hi)

**Problems Covered**:
- Move Zeroes (LC #283): ✅ NEW — 🟢 HIRE. Same-direction write/read pointer. All 5 tests first try. Zero bugs, zero hints. ~4 min. Clean swap-based approach. First same-direction two pointer problem.
- Sort Colors (LC #75): ✅ NEW — 🟢 HIRE. Dutch National Flag 3-way partition. All 5 tests first try. Zero bugs, zero hints. ~6 min. Clean swap helper method. Correctly explained why mid doesn't increment after hi swap.

**Key Observations**:
- **14-problem 🟢 HIRE streak** continues!
- 12/12 spaced rep recalled — 4 promoted to Box 4 (first Box 4 entries!)
- Same-direction two pointers clicked immediately — clean pattern transfer from understanding of write pointer concept
- Dutch National Flag: understood the critical invariant (don't advance mid after hi swap) on first explanation
- Both problems solved in under 10 min combined
- Day 3 complete! Ready for Day 4.

### Session #11 — June 29, 2026 — Two Pointers & Sorting (Week 2, Day 4 — Part 1)
**Status**: ✅ COMPLETE
**Duration**: ~20 min

**Spaced Repetition Recall Results (2 problems due)**:
- Move Zeroes (LC #283): ✅ Perfect — same-dir two pointers, write/read, swap non-zero forward. O(n)/O(1). → **Promoted to Box 2**
- Sort Colors (LC #75): ✅ Excellent — DNF 3-way partition, lo/mid/hi, explained mid-increment rule with reasoning. → **Promoted to Box 2**

**Problems Covered**:
- Remove Duplicates from Sorted Array (LC #26): ✅ NEW — 🟢 HIRE. Write pointer, overwrite with ++j. Initial off-by-one, self-debugged. Zero hints. ~3.5 min.

**Key Observations**:
- **15-problem 🟢 HIRE streak** continues!
- Pattern transfer from Move Zeroes to Remove Duplicates was instant
- Day 4 Part 1 complete, 4Sum pending.

### Session #12 — July 6, 2026 — Two Pointers & Sorting (Week 2, Day 4 — Part 2)
**Status**: ✅ COMPLETE
**Duration**: ~50 min (including spaced rep)

**Spaced Repetition Recall Results (16 overdue problems — 1 week gap)**:
- Remove Duplicates (LC #26): ✅ Correct → **Promoted to Box 2**
- Container With Most Water (LC #11): ✅ Correct → **Promoted to Box 3**
- Trapping Rain Water (LC #42): ✅ Correct → **Promoted to Box 3**
- Move Zeroes (LC #283): ✅ Correct → **Promoted to Box 3**
- Sort Colors (LC #75): ✅ Excellent — invariant reasoning for mid-increment → **Promoted to Box 3**
- Product Except Self (LC #238): ✅ Correct → **Promoted to Box 4**
- Longest Consecutive Sequence (LC #128): ✅ Correct, sequence start detection (no n-1) → **Promoted to Box 4**
- ⚠️ Subarray Sum Equals K (LC #560): Mixed up {0:1} (count) with {0:-1} (index from Contiguous Array) → **DEMOTED to Box 1**
- Encode and Decode Strings (LC #271): ✅ Correct → **Promoted to Box 4**
- Valid Sudoku (LC #36): ✅ Correct, box formula correct → **Promoted to Box 4**
- Valid Palindrome (LC #125): ✅ Correct → **Promoted to Box 4**
- 3Sum (LC #15): ✅ Correct, all dup skip placements correct → **Promoted to Box 4**
- Contiguous Array (LC #525): ✅ Correct, {0:-1} initialization correct → **Promoted to Box 4**
- Sort Characters By Frequency (LC #451): ✅ Correct → **Promoted to Box 4**
- Two Sum (LC #1): ✅ Correct, check-before-insert → **Promoted to Box 4**
- Contains Duplicate (LC #217): ✅ Correct, !set.add() idiom → **Promoted to Box 4**

**Recall Verdict**: 15/16 correct. 1 demotion (Subarray Sum Equals K — confused count-based vs index-based HashMap initialization).

**Problems Covered**:
- 4Sum (LC #18): ✅ NEW — 🟢 HIRE. Sort + fix two (i,j) + two pointers (k,l). All 5 tests first try. Zero bugs, zero hints. ~10 min. Clean extension of 3Sum. Smart overflow handling: split sum into two int pairs combined as long. Correct dup skipping for all 4 pointers (j > i+1 condition nailed).

**Key Observations**:
- **16-problem 🟢 HIRE streak** 🔥
- 4Sum was a clean generalization of 3Sum — pattern transfer confirmed
- Overflow awareness: proactively identified need for long when prompted about 10⁹ constraints
- Key confusion exposed: {0:1} vs {0:-1} in Prefix Sum + HashMap problems. Must drill: count-based = {0:1}, index-based = {0:-1}
- Despite 1-week gap, 15/16 recalled — strong long-term retention
- Day 4 complete! Ready for Day 5 (Boats to Save People + more two-pointer).

### Session #13 — July 7, 2026 — Two Pointers & Sorting (Week 2, Day 5)
**Status**: ✅ COMPLETE
**Duration**: ~15 min

**Spaced Repetition Recall Results (2 Box 1 problems)**:
- 4Sum (LC #18): ✅ Correct — Sort + fix two + two pointers, overflow handling (cast to long), O(n³)/O(k) → **Promoted to Box 2**
- Subarray Sum Equals K (LC #560): ✅ Correct — Nailed {0:1} (count-based) vs {0:-1} (index-based) distinction. Pattern, approach, complexity all correct. → **Promoted to Box 2**

**Problems Covered**:
- Boats to Save People (LC #881): ✅ NEW — 🟢 HIRE. Sort + greedy two pointers. 1 bug (forgot Arrays.sort()), self-debugged instantly. Zero hints. ~4 min. Greedy insight: heaviest always needs a boat, pair lightest if weight fits. Clean `left <= right` handles odd-person-out.

**Key Observations**:
- **17-problem 🟢 HIRE streak** 🔥
- Subarray Sum Equals K confusion from Session #12 is RESOLVED — correctly distinguished count-based {0:1} from index-based {0:-1}
- Forgot sort preprocessing (same miss type as May 8 Group Anagrams) — caught in under 1 min
- New greedy pairing pattern: "heaviest always boards, lightest joins if possible" — different flavor from Container With Most Water
- Day 5 complete! Week 2 Day 6 is review + re-solve struggles.

---

#### 📂 Pre-Reset Sessions (June 3–10, 2026)

### Session #1 — June 3, 2026 — Arrays & Hashing (Day 1)
**Status**: ✅ COMPLETE
**Duration**: ~45 min

**Spaced Repetition Recall Results**:
- Two Sum (LC #1): ✅ Pattern + approach + complexity all correct → Box 2
- Contains Duplicate (LC #217): ⚠️ Couldn’t recall problem statement, recalled pattern once prompted → stays Box 1
- Valid Anagram (LC #242): ✅ Good, but missed length early-exit again (recurring) → Box 2
- Group Anagrams (LC #49): ✅ Recalled optimal approach despite saying "not confident" → Box 2
- Top K Frequent Elements (LC #347): ❌ Couldn’t recall approach at all → stays Box 1

**Problems Covered So Far**:
- Two Sum (LC #1): ✅ Re-solve — 🟢 HIRE. Clean, zero bugs, ~4 min.
- Contains Duplicate (LC #217): ✅ Re-solve — 🟢 HIRE. Flawless, !set.add(n), ~2 min.
- Valid Anagram (LC #242): ⚡ Re-solve — 🟡 LEAN HIRE. Missed length early-exit (3rd time!). Fixed after probe. 1 hint used.
- Two Sum II (LC #167): ✅ NEW — 🟢 HIRE. First two-pointer problem. Clean implementation, zero bugs. Correct approach explanation.

**Key Observations**:
- Problem-to-pattern mapping is fuzzy for Contains Duplicate (knew pattern, forgot what problem asks)
- Valid Anagram: length early-exit is a recurring miss (May 12 recall, today's recall, AND today's code)
- Top K Frequent: Bucket sort concept completely forgotten — needs full re-solve
- 🔴 NEW RULE FOR SELF: Before ANY comparison function, first line = size check

### Session #2 — June 10, 2026 — Arrays & Hashing (Top K Frequent Re-solve)
**Status**: ✅ COMPLETE
**Duration**: ~30 min

**Spaced Repetition Recall**:
- Top K Frequent Elements (LC #347): ✅ Pattern fully recalled — went straight to bucket sort → Box 2

**Problems Covered**:
- Top K Frequent Elements (LC #347): ✅ Re-solve — 🟢 HIRE. Zero bugs, zero hints. Used `List[]` correctly (fixed previous `int[]` mistake). Added `ptr < k` guard after probing.

**Key Improvements Over May 17**:
- Used `List[]` instead of `int[]` — remembered that multiple elements can share a frequency
- `size + 1` reasoning explained perfectly (max freq = array length)
- Complexity analysis: O(n) time, O(n) space — articulated clearly
- Zero hints used (was 2+ hints on May 17)

**Pattern Confirmed**:
- Frequency Count + Bucket Sort → "top K by frequency" in O(n)
- Key insight locked in: **frequency as array index** eliminates sorting

**Problems Covered (continued)**:
- Product of Array Except Self (LC #238): ✅ NEW — 🟢 HIRE. Solved two-array version first (zero bugs), then optimized to O(1) space with running variable. Self-debugged the optimization (2 attempts). Zero hints.

**Key Concepts Learned**:
- **Prefix/Suffix pattern**: when you need "everything except current", build from both directions
- **Space optimization trick**: use output array for one direction + running variable for the other
- Base case for products: **1** (multiplicative identity), not the element itself

**Pattern Extracted**:
- Prefix/Suffix Product → O(n) time, O(1) extra space for "product except self" type problems

---

## 🔴 Struggle Log

> Tracks specific recurring struggles to focus on

| Date | Struggle Area | Details | Status |
|------|--------------|---------|--------|
| May 8 | Implementation bugs | 3 bugs in Group Anagrams brute force | 🟡 Improving |
| May 17 | Approaching new problems | Felt lost on Top K — couldn't see next step from freq map | 🔴 Active |
| May 17 | Array vs List for buckets | Used int[] when multiple values per bucket needed List[] | 🟡 Improving |
| May 17 | Inner loop bounds | Forgot to guard inner loop with ptr >= k check | 🟡 Improving |
| Jun 3 | **Length early-exit** | **Missed s.length()!=t.length() check in Valid Anagram — 3rd time** | 🟢 Resolved (Jun 17 — 3 consecutive correct sessions) |
| Jun 17 | **Output spec (0-indexed vs 1-indexed)** | Returned 0-indexed [0,1] on Two Sum II instead of 1-indexed [1,2] | 🟡 Improving |
| Jun 23 | **Variable scope in loops** | `k` initialized outside for loop — not reset per iteration of `i` in 3Sum | 🟡 New |
| Jun 23 | **If/else branch structure** | Extra `j++/k--` outside if/else caused double pointer movement | 🟡 New |
| Jun 23 | **Duplicate skip placement** | Put j/k duplicate skip at top of while loop instead of inside else block after finding triplet | 🟡 New |
| Jul 14 | **Conceptual synthesis lag** | Longest Repeating Char Replacement: executed the optimal template flawlessly (code fluency) but needed 2 nudges to explain why a stale `maxFreq` can't cause a wrong answer (conceptual fluency lagging behind code fluency) | 🟢 Resolved (Jul 16 — self-synthesized full argument at spaced-rep recall, zero nudges) |
| Jul 16 | **Complexity articulation on need/formed problems** | Minimum Window Substring recall: said TC O(m·n) instead of O(m+n) | 🟡 New — re-probe at next recall |
| Jul 18 | **Verbal explanation lags code fluency** | Remove Duplicates: said "move j to i+1" (wrong) but wrote/knew correct code (increment j, write nums[i] there) | 🟡 New — same shape as LRCR Jul 14 gap |
| Jul 18 | **Cold forgetting after sparse review gap** | Boats to Save People (Box 3, 11-day gap) fully forgotten — problem statement and approach both gone | 🟢 Resolved (Jul 19 — full recall on the real 24hr retest, refresher re-anchored it) |
| Jul 19 | **Complexity articulation defaults to a loose bound** | Boats to Save People needed 2 probes to state complexity at all; Sliding Window Maximum said O(n) space instead of tight O(k); Subarrays w/ K Distinct said O(1) instead of O(k) | 🟡 New — recurring across 3 problems same session, watch closely |
| Jul 19-20 | **Composition bugs invisible to composed tests** | Subarrays with K Distinct re-solve: moved `right++` before the count line in `atMostKDistinct`, overcounting every call by `n` — invisible in `atMost(k)-atMost(k-1)` since both calls are inflated identically and cancel. All 5 driver tests passed on the buggy version. Only caught when asked to hand-trace/assert the helper in isolation. | 🟡 New — general lesson: probe sub-functions of any `f(a)-f(b)` composition directly, not just the composed result |
| Jul 23 | **Code fluency ahead of the "why" (recurring)** | Largest Rectangle: wrote the correct `-1` right-sentinel but couldn't justify why `-1` (vs 0/1) when probed — the value must undercut the min possible bar height (0). Same shape as LRCR staleness (Jul 14) and Remove Duplicates verbal mix-up (Jul 18). | 🟡 Recurring — re-probe the "why -1" at next recall; keep pushing on the justification behind correct code |

<!-- Status: 🔴 Active | 🟡 Improving | 🟢 Resolved -->

---

## 🎯 Focus Areas

> Areas that need extra attention based on struggle patterns

| Priority | Area | Reason | Action Plan |
|----------|------|--------|-------------|
| — | Code Implementation | Self-identified weakness | Practice writing code from logic descriptions |
| — | — | — | — |

---

## 📊 Pattern Confidence Tracker

| # | Pattern | Confidence (1-5) | Last Practiced | Notes |
|---|---------|------------------|----------------|-------|
| 1 | HashMap/HashSet Lookup | 5 | June 17 | Two Sum + Contains Duplicate — all HIRE level |
| 2 | Frequency Counting | 5 | June 17 | Valid Anagram + Group Anagrams + Top K Frequent — all locked in |
| — | HashMap Grouping | 5 | June 17 | Group Anagrams — 🟢 HIRE, zero bugs, freq key approach |
| — | Bucket Sort (Freq as Index) | 5 | June 17 | Top K Frequent — 🟢 HIRE, zero bugs, zero hints. Locked in. |
| 3 | Two Pointers (Opposite Ends) | 5 | June 28 | Valid Palindrome 🟢 HIRE + Container With Most Water 🟢 HIRE |
| — | Greedy Two Pointers (Max Area) | 5 | June 28 | Container With Most Water 🟢 HIRE — move shorter side, ~4 min |
| — | Two Pointers (Trapped Water) | 5 | June 28 | Trapping Rain Water 🟢 HIRE (HARD) — process smaller max side, ~5 min |
| — | Two Pointers (Same Direction) | 5 | June 28 | Move Zeroes 🟢 HIRE — write/read pointer, ~4 min |
| — | Dutch National Flag (3-Way Partition) | 5 | June 28 | Sort Colors 🟢 HIRE — lo/mid/hi, ~6 min |
| — | Prefix/Suffix | 5 | June 18 | Product Except Self — 🟢 HIRE, O(1) space optimization flawless |
| — | HashSet + Sequence Start | 4 | June 18 | Longest Consecutive Sequence — 🟢 HIRE, NEW, amortized O(n) understood |
| — | Length-Prefix Encoding | 4 | June 21 | Encode and Decode Strings — Recalled solidly in spaced rep |
| — | HashSet Validation (Row/Col/Box) | 5 | June 21 | Valid Sudoku — Recalled solidly in spaced rep |
| — | Prefix Sum + HashMap | 5 | June 22 | Subarray Sum Equals K + Contiguous Array — pattern transfer proven on unseen problem |
| — | Sort + Fix One + Two Pointers | 5 | July 6 | 3Sum — recalled perfectly in spaced rep, promoted to Box 4 |
| — | Sort + Fix Two + Two Pointers (kSum) | 5 | July 6 | 4Sum 🟢 HIRE — clean 3Sum extension, overflow handling, ~10 min |
| — | Sort + Greedy Two Pointers (Pairing) | 5 | July 7 | Boats to Save People 🟢 HIRE — heaviest boards, lightest pairs if fits, ~4 min |
| 4 | Two Pointers (Same Direction) | 5 | June 28 | Move Zeroes 🟢 HIRE — write/read pointer, ~4 min |
| 5 | Sliding Window (Fixed) | 5 | July 13 | Max Sum Subarray of Size K 🟢 HIRE. Add right, remove left, track max. |
| 6 | Sliding Window (Variable) + HashSet | 5 | July 13 | Longest Substring Without Repeating 🟢 HIRE. Expand right, shrink left until valid, ~5 min. |
| — | Sliding Window (Variable — Shortest) | 5 | July 13 | Minimum Size Subarray Sum 🟢 HIRE. Update min DURING shrinking. Integer.MAX_VALUE init. |
| — | Sliding Window (Fixed + Freq Match) | 5 | July 13 | Permutation in String 🟢 HIRE. Running int[26] + Arrays.equals. Don't rebuild freq each time. |
| — | Sliding Window (Variable + Need/Formed Counter) | 5 | July 14 | Minimum Window Substring 🟢 HIRE (Hard). need/window maps, formed==required. Exact `==` to bump, strict `<` to drop — avoids double-counting. |
| — | Sliding Window (Variable + Max Frequency) | 4 | July 14 | Longest Repeating Char Replacement 🟢 HIRE. windowSize - maxFreq <= k, running int[26], if not while to shrink. Code flawless; "why stale maxFreq is harmless" needed 2 nudges to partially reconstruct — re-probe at recall. |
| — | Sliding Window (At-Most-K-Distinct) | 5 | July 14 | Fruit Into Baskets 🟢 HIRE. HashMap<type,count>, shrink while size>K, remove key at count 0. Zero hints, all follow-ups (incl. generalize to K) answered instantly. |
| — | Sliding Window (Zero Count / Binary-Alphabet Max Freq) | 5 | July 16 | Max Consecutive Ones III 🟢 HIRE. Cold pattern transfer, zero re-teach. zeroCount <= k, if/while equivalence proven, not assumed. |
| — | Sliding Window (Exactly-K Trick) | 5 | July 17 | Subarrays with K Different Integers 🟢 HIRE. atMost(K)-atMost(K-1), sum right-left+1 per step (not max). Needed concrete example to click, then flawless execution + strong follow-up reasoning. |
| — | Monotonic Deque (Window Max) | 5 | July 20 | Sliding Window Maximum 🟢 HIRE (re-solve, Hard). Clean first attempt — no repeat of the Jul 18 broken draft. Recall + re-solve both clean same cycle → confidence raised to 5. |
| — | Sort + Greedy Two Pointers (Pairing) | 5 | July 19 | Boats to Save People — full recall recovery after Jul 18 cold forgetting; refresher fully re-anchored it. |
| — | Sliding Window (Exactly-K Trick) | 4 | July 20 | Subarrays with K Distinct 🟡 LEAN HIRE (re-solve). Concept solid, but re-solve exposed a real composition bug (count-line ordering) invisible to composed driver tests — held at 4 until a clean re-solve with no bugs. |
| 7 | Monotonic Stack | 5 | July 23 | Daily Temperatures 🟢 HIRE + Next Greater Element I 🟢 HIRE. Decreasing stack of indices/values, pop-and-resolve when a bigger element arrives. |
| — | Monotonic Stack + HashMap | 5 | July 23 | Next Greater Element I 🟢 HIRE — precompute next-greater for all of nums2 into a value→answer map, then O(1) lookups. Value-key only valid because distinct. |
| — | Monotonic (Increasing) Stack — Boundaries | 5 | July 23 | Largest Rectangle in Histogram 🟢 HIRE (Hard) — pop-and-resolve, width = i - peek - 1, dual sentinels. Nearest-smaller-on-both-sides as area bound. |
| 8 | Fast/Slow Pointers | — | — | — |
| 9 | Linked List Reversal | — | — | — |
| 10 | Binary Search (Classic) | — | — | — |
| 11 | Binary Search (On Answer) | — | — | — |
| 12 | Tree DFS (Preorder/Inorder/Postorder) | — | — | — |
| 13 | Tree BFS (Level Order) | — | — | — |
| 14 | BST Properties | — | — | — |
| 15 | Heap / Top-K | — | — | — |
| 16 | Backtracking | — | — | — |
| 17 | Graph BFS/DFS | — | — | — |
| 18 | Topological Sort | — | — | — |
| 19 | Union-Find | — | — | — |
| 20 | DP — 1D | — | — | — |
| 21 | DP — 2D | — | — | — |
| 22 | DP — Knapsack | — | — | — |
| 23 | Trie | — | — | — |
| 24 | Intervals/Greedy | — | — | — |

---

## 📅 Spaced Repetition — Due Next

| Problem | Box Level | Last Reviewed | Due Date | Status |
|---------|-----------|---------------|----------|--------|
| Boats to Save People (LC #881) | Box 2 | Jul 19 | Jul 22 | ✅ Reviewed |
| Sliding Window Maximum (LC #239) | Box 2 | Jul 19 | Jul 22 | ✅ Reviewed |
| Subarrays with K Different Integers (LC #992) | Box 2 | Jul 18 | Jul 21 | ✅ Reviewed |
| Minimum Window Substring (LC #76) | Box 3 | Jul 19 | Jul 26 | ✅ Reviewed |
| Longest Repeating Character Replacement (LC #424) | Box 3 | Jul 19 | Jul 26 | ✅ Reviewed |
| Fruit Into Baskets (LC #904) | Box 3 | Jul 19 | Jul 26 | ✅ Reviewed |
| Max Sum Subarray of Size K | Box 3 | Jul 16 | Jul 23 | ✅ Reviewed |
| Longest Substring Without Repeating (LC #3) | Box 3 | Jul 16 | Jul 23 | ✅ Reviewed |
| Minimum Size Subarray Sum (LC #209) | Box 3 | Jul 17 | Jul 24 | ✅ Reviewed |
| Permutation in String (LC #567) | Box 3 | Jul 17 | Jul 24 | ✅ Reviewed |
| Max Consecutive Ones III (LC #1004) | Box 3 | Jul 20 | Jul 27 | ✅ Promoted |
| Partition Labels (LC #763) | Box 4 | Jul 20 | Aug 3 | ✅ Promoted |
| Container With Most Water (LC #11) | Box 4 | Jul 20 | Aug 3 | ✅ Promoted |
| Trapping Rain Water (LC #42) | Box 4 | Jul 20 | Aug 3 | ✅ Promoted |
| Move Zeroes (LC #283) | Box 4 | Jul 20 | Aug 3 | ✅ Promoted |
| Sort Colors (LC #75) | Box 4 | Jul 20 | Aug 3 | ✅ Promoted |
| Remove Duplicates (LC #26) | Box 4 | Jul 18 | Aug 1 | ✅ Reviewed |
| 4Sum (LC #18) | Box 4 | Jul 18 | Aug 1 | ✅ Reviewed |
| Subarray Sum Equals K (LC #560) | Box 4 | Jul 18 | Aug 1 | ✅ Reviewed |
| 3Sum Closest (LC #16) | Box 4 | Jul 18 | Aug 1 | ✅ Reviewed |
| Valid Anagram (LC #242) | Box 4 | Jul 13 | Jul 27 | ✅ Reviewed |
| Two Sum II (LC #167) | Box 4 | Jul 13 | Jul 27 | ✅ Reviewed |
| Group Anagrams (LC #49) | Box 4 | Jul 13 | Jul 27 | ✅ Reviewed |
| Top K Frequent (LC #347) | Box 4 | Jul 13 | Jul 27 | ✅ Reviewed |
| Product Except Self (LC #238) | Box 5 | Jul 20 | Aug 19 | 🎓 Mastered |
| Longest Consecutive (LC #128) | Box 5 | Jul 20 | Aug 19 | 🎓 Mastered |
| Encode and Decode Strings (LC #271) | Box 5 | Jul 20 | Aug 19 | 🎓 Mastered |
| Valid Sudoku (LC #36) | Box 5 | Jul 20 | Aug 19 | 🎓 Mastered |
| Valid Palindrome (LC #125) | Box 5 | Jul 20 | Aug 19 | 🎓 Mastered |
| 3Sum (LC #15) | Box 5 | Jul 20 | Aug 19 | 🎓 Mastered |
| Contiguous Array (LC #525) | Box 5 | Jul 20 | Aug 19 | 🎓 Mastered |
| Sort Chars By Freq (LC #451) | Box 5 | Jul 20 | Aug 19 | 🎓 Mastered |
| Two Sum (LC #1) | Box 5 | Jul 20 | Aug 19 | 🎓 Mastered |
| Contains Duplicate (LC #217) | Box 5 | Jul 20 | Aug 19 | 🎓 Mastered |
| Subarray Product Less Than K (LC #713) | Box 1 | Jul 20 | Jul 21 | 🆕 New |
| Minimum Operations to Reduce X to Zero (LC #1658) | Box 1 | Jul 20 | Jul 21 | 🆕 New |
| Valid Parentheses (LC #20) | Box 1 | Jul 21 | Jul 22 | 🆕 New |
| Min Stack (LC #155) | Box 1 | Jul 21 | Jul 22 | 🆕 New |

---

## 🧩 Code Implementation Struggle Patterns

> Specific coding mistakes/struggles tracked here to build targeted improvement

| Date | Mistake Type | Example | Fix/Rule |
|------|-------------|---------|----------|
| May 8 | char[].toString() confusion | `arr.toString()` returns memory address | Always use `new String(arr)` or `String.valueOf(arr)` for char[] → String |
| May 8 | Forgot preprocessing step | Brute force without `Arrays.sort(arr)` | Before using derived key, ask: "what transform makes anagrams identical?" |
| May 8 | Collection vs List return | `(List) res.values()` — wrong cast | Use `new ArrayList<>(map.values())` to convert Collection to List |
| May 17 | int[] for multi-value buckets | `buckets[freq] = key` overwrites | When multiple values map to same index, use `List[]` not `int[]` |
| May 17 | Missing inner loop bound | Inner loop writes past array size | Always guard nested collection loops with `if (ptr >= k) break` |

---

### Session #14 — July 7, 2026 — Week 2, Day 6 (Review + Re-solve)
**Duration**: ~20 min
**Type**: Review Day — Re-solve Struggles

**Re-solves Completed**:
- 3Sum (LC #15): 🟢 HIRE. ~5 min. Zero bugs, zero hints. Last time: 🟡 LEAN HIRE, 2 hints, ~20 min. Massive improvement — dup skipping logic flawless.
- Contiguous Array (LC #525): 🟢 HIRE. ~6 min. 1 self-caught bug (unconditional map.put → moved to else). Zero hints. Last time: 🟡 LEAN HIRE, 45 min (over limit).

**Key Observations**:
- Both struggle problems went from LEAN HIRE → HIRE
- Time improvement dramatic: 3Sum 20→5 min, Contiguous Array 45→6 min
- Pattern recall is solid — approach was instant in both cases
- Self-debugging skills improving (caught Contiguous Array bug before tests exposed it)

---

### Session #14 (continued) — July 7, 2026 — Week 2, Day 7 (Weekly Challenge)
**Type**: 🔥 Weekly Challenge — 2 unseen two-pointer problems

**Problems Solved**:
- 3Sum Closest (LC #16): 🟡 LEAN HIRE. UNSEEN. ~25 min. Bug: missing Math.abs() in distance comparison — caught during interviewer dry run probe, not self-caught. Zero hints. Good pattern transfer from 3Sum. Key lesson: always use Math.abs() when comparing closeness/distance.
- Partition Labels (LC #763): 🟢 HIRE. UNSEEN. All 5 tests first try. Zero bugs, zero hints. Optimal O(n) greedy: map char→last occurrence, extend partition end greedily, cut when i==end.

**Key Observations**:
- Pattern transfer from 3Sum → 3Sum Closest was solid (approach correct immediately)
- Math.abs() miss is a recurring theme — need to build a mental checklist for comparison problems
- Partition Labels showed excellent novel problem-solving — identified the greedy insight independently
- 🎉 **WEEK 2 COMPLETE** — All 12 problems done (10 new + 2 weekly challenge)

### Session #15 — July 11, 2026 — Sliding Window (Week 3, Day 1)
**Status**: ✅ COMPLETE
**Duration**: ~30 min

**Spaced Repetition Recall Results (5 Box 2 problems — 2 overdue + 3 due today)**:
- Remove Duplicates (LC #26): ✅ Perfect — write/read pointer, O(n)/O(1) → **Promoted to Box 3**
- 4Sum (LC #18): ✅ Solid — sort + fix two + two pointers, overflow→long recalled → **Promoted to Box 3**
- Subarray Sum Equals K (LC #560): ✅ Nailed — {0:1} count-based init correct, prefix sum complement search → **Promoted to Box 3**
- Boats to Save People (LC #881): ✅ Perfect — sort + greedy pairing, O(n log n)/O(1) → **Promoted to Box 3**
- 3Sum Closest (LC #16): ✅ Excellent — Math.abs() gotcha recalled proactively → **Promoted to Box 3**
- ⏭️ Partition Labels (LC #763): Deferred to next session.

**Recall Verdict**: 5/5 recalled. All promoted to Box 3. Partition Labels deferred (late session).

**Problems Covered**:
- Max Sum Subarray of Size K: ✅ NEW — 🟢 HIRE. Fixed sliding window. Solved prior to session (concept teach done in prior session).
- Longest Substring Without Repeating Characters (LC #3): ✅ NEW — 🟢 HIRE. Variable sliding window + HashSet. All 5 tests first try. Zero bugs, zero hints. ~5 min. Clean while+continue approach for shrinking (no nested while loop). Amortized O(n) reasoning solid — each element enters/leaves set at most once.

**Key Observations**:
- **19-problem 🟢 HIRE streak** 🔥🔥🔥 (if counting both today's problems)
- Sliding window pattern clicked immediately — concept teach from prior session paid off
- Used `while` + `continue` instead of nested `while` for shrinking — elegant alternative to the template
- Amortized reasoning transferred from Longest Consecutive Sequence (same logic: each element processed at most twice)
- Spaced rep: 5/5 recalled despite 3-day gap. Subarray Sum Equals K {0:1} vs {0:-1} confusion is permanently resolved.
- Day 1 complete! Ready for Day 2 (Minimum Size Subarray Sum + Permutation in String).

### Session #16 — July 13, 2026 — Sliding Window (Week 3, Day 2)
**Status**: ✅ COMPLETE
**Duration**: ~40 min

**Spaced Repetition Recall Results (11 problems — 7 overdue + 4 due today)**:
- Max Sum Subarray of Size K (Box 1): ✅ Perfect — fixed window, add/remove, track max. O(n)/O(1). → **Promoted to Box 2**
- Longest Substring Without Repeating (Box 1): ✅ Solid — variable window + HashSet, expand/shrink. O(n)/O(n). → **Promoted to Box 2**
- Partition Labels (Box 2, deferred): ✅ After probe — approach correct but cut condition imprecise ("cut when this char done" vs "cut when everything done"). Clarified: track end = max(end, lastOcc[char]), cut when i==end. → **Promoted to Box 3**
- Valid Anagram (Box 4): ✅ Perfect — length early-exit FIRST. int[26]. O(n)/O(1). → **Stays Box 4**
- Two Sum II (Box 4): ✅ Perfect — two pointers opposite, move on sum comparison. O(n)/O(1). → **Stays Box 4**
- Group Anagrams (Box 4): ✅ Solid — freq key + HashMap grouping. O(n·k)/O(n·k). → **Stays Box 4**
- Top K Frequent (Box 4): ✅ Perfect — bucket sort, List[] n+1, right-to-left. O(n)/O(n). → **Stays Box 4**
- Container With Most Water (Box 3): ✅ Solid after probe — move shorter side. O(n)/O(1). → **Stays Box 3**
- Trapping Rain Water (Box 3): ✅ Excellent — min(maxL, maxR) - h[i], process smaller max. O(n)/O(1). → **Stays Box 3**
- Move Zeroes (Box 3): ✅ Perfect — write/read pointer, swap non-zero forward. O(n)/O(1). → **Stays Box 3**
- Sort Colors (Box 3): ✅ Excellent — DNF lo/mid/hi, mid stays after hi swap. O(n)/O(1). → **Stays Box 3**

**Recall Verdict**: 11/11 recalled. 3 promoted, 8 maintained. Zero demotions.

**Problems Covered**:
- Minimum Size Subarray Sum (LC #209): ✅ NEW — 🟢 HIRE. Variable window (shortest). All 5 tests first try. 1 typo (target vs minLength), self-caught. Zero hints. ~4 min. Key: update min DURING shrinking, init Integer.MAX_VALUE, ternary return.
- Permutation in String (LC #567): ✅ NEW — 🟢 HIRE. Fixed window + freq match. All 5 tests first try (both versions). Initial version used helper function (O(m·k)), guided to refactor to running int[26] (O(m)). 1 hint (running freq vs rebuild). ~13 min. Clean need[]/window[] naming, Arrays.equals().

**Key Observations**:
- **21-problem 🟢 HIRE streak** 🔥🔥🔥
- New pattern distinction locked in: LONGEST → update during expanding, SHORTEST → update during shrinking
- Permutation in String: initially didn't connect "maintain running freq array" to the fixed sliding window pattern (same as running sum in Max Sum Subarray). After guided parallel, refactored cleanly.
- Integer.MAX_VALUE init for min-finding is a general technique — same as using Integer.MIN_VALUE for max-finding
- Spaced rep: 11/11 recalled despite 2-day gap. Partition Labels cut condition was the only fuzzy recall (approach was right, precision was lacking).
- Day 2 complete! Ready for Day 3 (Minimum Window Substring + Longest Repeating Character Replacement).

### Session #17 — July 14, 2026 — Sliding Window (Week 3, Day 3)
**Status**: ✅ COMPLETE (1 of 2 problems; Longest Repeating Character Replacement deferred)

**Spaced Repetition Recall Results (2 Box 1 problems)**:
- Minimum Size Subarray Sum (LC #209): ✅ Approach correct (shrink-and-update-min). Bug caught: said `sum > target` instead of `sum >= target` — counterexample [1,4,4]/target=4 shows strict `>` misses the exact-match window. Corrected. → **Promoted to Box 2**
- Permutation in String (LC #567): ✅ Perfect — need[]/window[] running freq, equality check at fixed size, remove-left/add-right slide. O(n)/O(1). → **Promoted to Box 2**

**Recall Verdict**: 2/2 recalled, 1 with correction.

**Problems Covered So Far**:
- Minimum Window Substring (LC #76): ✅ NEW HARD — 🟢 HIRE. Concept teach needed on need/window HashMap + formed/required counter (new trick — first "matching a multiset containment" problem, not just equality like Permutation in String). All 5 tests first try. Zero bugs, zero Phase-B hints. Correctly proposed `int[128]` over HashMap given bounded ASCII charset. Correctly explained why `formed` bump/drop uses exact `==` / strict `<` (avoids double-counting the same char).

**Key Observations**:
- **22-problem 🟢 HIRE streak** 🔥🔥🔥
- First Hard-difficulty sliding window problem solved flawlessly
- First "need/formed counter" pattern — generalizes the exact-equality-transition-moment idea from Permutation in String's Arrays.equals() to a running counter
- Concept required a from-scratch re-explanation with a walkthrough example (shopping-cart/checklist analogy) before it clicked — first attempt at explaining the counter abstractly wasn't enough; concrete example worked
- Longest Repeating Character Replacement (LC #424): concept teach given (window validity = `windowSize - maxFreq <= k`, stale `maxFreq` trick), but user deferred solving to next session before starting. No code file created yet.
- Day 3 partially complete — 1 new problem solved (Hard), 1 deferred. Ready for Day 4, starting with the deferred problem.

---

### Session #17 (continued) — July 14, 2026 — Sliding Window (Week 3, Day 4)
**Status**: 🔄 IN PROGRESS

**Concept Re-teach**: User asked to re-teach Longest Repeating Character Replacement from scratch before coding (concept had been taught earlier same session but deferred). Gave full walkthrough trace on `"AABABBA"`, k=1 showing the window growing to size 4 genuinely, then "coasting" at size 4 with a stale `mostFrequentChar` for the rest of the string — used to explain why staleness can't inflate the final answer.

**Problems Covered**:
- Longest Repeating Character Replacement (LC #424): ✅ NEW — 🟢 HIRE. All 5 tests first try. Zero bugs, zero hints on the algorithm itself. Used `if` (not `while`) to shrink — matches optimal template exactly, window length monotonically non-decreasing. Self-corrected a time-complexity typo (said O(1), meant O(n)). Needed 2 probing nudges to explain why a stale `mostFrequentChar` can't cause a wrong answer — landed on "result can only grow, never shrink" independently, but didn't fully self-synthesize the complete argument (had to close the loop in debrief).

**Key Observations**:
- **23-problem 🟢 HIRE streak** 🔥🔥🔥
- Clean pattern transfer from Permutation in String's running `int[26]` trick — recognized immediately, no hint needed for that part
- New gap identified: can execute the optimal template correctly (code fluency) while not fully internalizing the correctness invariant behind WHY it's optimal (conceptual fluency lagging code fluency) — worth re-probing at spaced-rep recall specifically on the "why" rather than just approach/complexity

**Problems Covered (continued)**:
- Fruit Into Baskets (LC #904): ✅ NEW — 🟢 HIRE. First "at most K distinct" sliding window problem. All 5 tests first try. Zero bugs, zero hints. `HashMap<fruitType, count>`, shrink while `map.size() > 2`, remove key entirely at count 0 (not just decrement). All 3 follow-up questions (complexity, why remove key entirely, generalization to K baskets) answered correctly with zero nudges — sharper than the LRCR debrief.

**Key Observations (Fruit Into Baskets)**:
- **24-problem 🟢 HIRE streak** 🔥🔥🔥
- Immediately understood why `map.size()` must reflect only truly-present distinct types — a stale zero-count key would silently break the shrink condition
- Instant correct generalization: `basket.size() > 2` → `basket.size() > k` for arbitrary K
- Conceptual articulation this round was crisp (contrast with LRCR needing 2 nudges) — good sign the "explain the why" muscle is warming up
- Day 4 in progress. Next: Max Consecutive Ones III (LC #1004), if continuing today.

---

### Session #18 — July 16, 2026 — Sliding Window (Week 3, Day 4 — continued)
**Status**: ✅ COMPLETE

**Spaced Repetition Recall Results (5 problems — 3 Box 1 overdue + 2 Box 2 due today)**:
- Minimum Window Substring (LC #76): ✅ Pattern/approach perfect (need/formed, exact `==`/strict `<`). Complexity wrong: said O(m·n), corrected to O(m+n) time / O(1) space (bounded ASCII int[128]). → **Promoted to Box 2**
- Longest Repeating Character Replacement (LC #424): ✅ Excellent — fully self-synthesized the "why stale maxFreq is harmless" argument this time (Jul 14 gap needed 2 nudges; today zero nudges, landed on "result can only grow, never shrink" independently). → **Promoted to Box 2**
- Fruit Into Baskets (LC #904): ✅ Perfect — HashMap count, shrink+remove-at-zero, O(n)/O(1). → **Promoted to Box 2**
- Max Sum Subarray of Size K: ✅ Perfect — windowSum += new − old, O(n)/O(1). → **Promoted to Box 3**
- Longest Substring Without Repeating (LC #3): ✅ Perfect — described HashMap-index-jump variant (last-seen-index + `left = lastIdx+1` only if inside window), a valid more-optimal alternative to the original HashSet expand/shrink. O(n)/O(min(n,charset)). → **Promoted to Box 3**

**Recall Verdict**: 5/5 recalled. 1 complexity correction (Minimum Window Substring). LRCR conceptual gap from Jul 14 is now resolved.

**Problems Covered**:
- Max Consecutive Ones III (LC #1004): ✅ NEW — 🟢 HIRE. Presented with no re-teach (pattern-transfer test from LRCR/Fruit Into Baskets) — correct approach stated immediately (zeroCount counter, shrink when > k, update max during expansion). All 5 tests first try. Zero bugs, zero hints. ~5 min incl. discussion. Follow-up: claimed switching shrink from `if` to `while` would help on adversarial input; pushed back with "how many zeros can enter per iteration?" — self-corrected to recognizing `if`/`while` are provably identical here (at most one shrink step ever needed).

**Key Observations**:
- **25-problem 🟢 HIRE streak** 🔥🔥🔥
- Pattern transfer from LRCR + Fruit Into Baskets to an entirely unseen problem was immediate and required zero concept re-teach — first "cold" transfer test of the week, passed cleanly
- LRCR's Jul 14 conceptual gap (staleness argument) is now fully resolved — recalled independently under spaced rep, no nudges
- New reasoning skill demonstrated: instead of accepting an interviewer's "can you do better" prompt at face value, worked out from first principles that a proposed "optimization" (`while` instead of `if`) was actually a no-op — good instinct, don't just agree with follow-up pressure
- Debrief insight (self-articulated after one nudge): Max Consecutive Ones III is LRCR's max-frequency trick specialized to a binary alphabet — `windowSize - maxFreq <= k` collapses to `zeroCount <= k` when there are only 2 possible values
- 🎉 **Day 4 complete!** All 3 problems done (LRCR, Fruit Into Baskets, Max Consecutive Ones III). Ready for Day 5 (Exactly-K trick + Monotonic Deque).

---

### Session #19 — July 17, 2026 — Sliding Window (Week 3, Day 5)
**Status**: 🔄 IN PROGRESS

**Spaced Repetition Recall Results (3 problems — 1 Box 1 + 2 Box 2 due today)**:
- Max Consecutive Ones III (LC #1004): ✅ Perfect — zero-count window, shrink-when-exceeds-K, max recorded during expansion, each pointer moves forward only. O(n)/O(1). → **Promoted to Box 2**
- Minimum Size Subarray Sum (LC #209): ✅ Perfect — monotonicity of positive numbers justifies single pass, min recorded during shrinking. O(n)/O(1). → **Promoted to Box 3**
- Permutation in String (LC #567): ✅ Perfect — fixed window, running int[26] update on slide, Arrays.equals() comparison. O(m)/O(1). → **Promoted to Box 3**

**Recall Verdict**: 3/3 recalled cleanly. All promoted.

**Concept Teach**: Exactly-K composition trick — `exactly(K) = atMost(K) - atMost(K-1)`. First explanation (abstract, goal-first) didn't land; user asked for a slow, concrete walkthrough without assuming the goal. Re-taught using `[1,2,1,2,3]`, K=2: manual enumeration of all 15 subarrays (ground truth = 7), then traced `atMost(2)=12` and `atMost(1)=5` step-by-step (table format, showing map state/distinct/shrink at each `right`), cross-checked `12-5=7`. Landed immediately on the second pass.

**Problems Covered**:
- Subarrays with K Different Integers (LC #992): ✅ NEW — 🟢 HIRE. First "exactly K" composition problem. Approach stated correctly before coding (HashMap count, shrink when size>k, sum `right-left+1` per step, call helper twice and subtract). All 5 tests first try. Zero bugs, zero hints in Phase B. Follow-ups: self-corrected space complexity from loose O(n) to tight O(k) (map never holds >k+1 keys mid-algorithm); explained HashMap-over-int[] tradeoff (value range tied to array length here, unlike Permutation in String's fixed 26-letter alphabet) with `.size()` convenience as a bonus reason; proactively identified that the HashMap version survives a hypothetical 10^9-range constraint where an int[] version would break.

**Key Observations**:
- **26-problem 🟢 HIRE streak** 🔥🔥🔥
- Concept teach needed a second, concrete-example-first pass — abstract "atMost(K)-atMost(K-1)" framing alone didn't click; a full manual-enumeration ground-truth + step-by-step trace table worked immediately. Note for future concept teaches: lead with a small worked example before the abstract formula, not after.
- Once the concept landed, code execution was flawless — no gap between conceptual and code fluency this time (contrast with LRCR's Jul 14 lag)
- Strong constraint-driven reasoning in debrief: correctly reasoned about what breaks under a harder constraint (10^9 range) without being asked directly
- Day 5 in progress. Next: Sliding Window Maximum (LC #239) — will need Monotonic Deque concept teach first (brand-new data structure).

---

### Session #20 — July 18, 2026 — Sliding Window (Week 3, Day 5 — continued)
**Status**: 🔄 IN PROGRESS

**Spaced Repetition Recall Results (6 problems — 1 Box 1 due + 5 Box 3 due)**:
- Subarrays with K Different Integers (LC #992): ✅ Solid on 2nd probe — first pass gave the exactly(K) formula without detail; probed for how atMost(K) itself works, got shrink-while-size>K + count += right-left+1 correctly. → **Promoted to Box 2**
- Remove Duplicates (LC #26): ✅ Correct, but verbal explanation ("move j to i+1") didn't match the actual mechanic (increment j, then write nums[i] there). Wrote correct code when pushed, then restated verbally correctly. → **Promoted to Box 4**
- 4Sum (LC #18): ✅ Solid — sort + fix i,j with dup-skip, two pointers k,l with dup-skip on match, O(n³)/O(1) extra. → **Promoted to Box 4**
- Subarray Sum Equals K (LC #560): ✅ Nailed count-based {0:1} reasoning. O(n)/O(n). → **Promoted to Box 4**
- Boats to Save People (LC #881): ❌ Forgot problem statement AND approach entirely. Given refresher (problem + solution); only repeated it back, not real recall. → **Demoted to Box 1**
- 3Sum Closest (LC #16): ✅ Excellent — clear two-pointer-squeeze explanation, correct O(n²)/O(1). → **Promoted to Box 4**

**Recall Verdict**: 5/6 recalled (1 needed a second probe to reach full precision). 1 forgotten cold (Boats to Save People) — first full demotion in several sessions.

**Key Observations**:
- Verbal explanation vs. code fluency gap resurfaced on Remove Duplicates (similar shape to LRCR's Jul 14 gap) — code was flawless, but the spoken description of what happens to `i`/`j` was imprecise until pressed for exact mechanics
- Boats to Save People forgotten completely after an 11-day gap with no interleaved review — first clean forgettance this cycle; worth watching whether Box 3 (weekly) interval is too sparse for lower-rep-count problems

**Concept Teach**: Monotonic Deque (brand-new data structure). First pass — dense step-by-step trace table on [1,3,-1,-3,5,3,6,7] — did NOT land ("i did not understood"). Second pass — slow narrative walkthrough on tiny [4,2,5,1] k=2 with the "younger and taller candidate goes home" analogy, one element at a time, comprehension checks between steps — landed immediately. This is now the SECOND confirmed instance (after Jul 17's Exactly-K re-teach) that dense/tabular-first explanations fail and small-concrete-narrative-first works. Also gave a Java Deque API cheat sheet on request (ArrayDeque, offerLast/pollLast/peekLast, pollFirst/peekFirst) — treated as free, not a hint.

**Problems Covered**:
- Sliding Window Maximum (LC #239): ✅ NEW HARD — 🟢 HIRE. First Monotonic Deque problem, data structure learned same session. Jumped to code before stating approach (pulled back); first draft structurally broken (`dq.poll()` on empty, inverted `while(dq.isEmpty())`) and asked interviewer to validate mid-write — deflected to self-trace on [4,2,5,1], then produced a clean, fully correct implementation unaided. All 5 tests first try. Zero hints. Under the 40-min Hard limit. Follow-ups both answered correctly: (1) `if` suffices for front expiry since the window slides one step per iteration; (2) `<` vs `<=` back-eviction both correct — equal-value newcomer dominates (same value + outlives), strict `<` merely keeps redundant duplicates.

**Key Observations (Sliding Window Maximum)**:
- **27-problem 🟢 HIRE streak** 🔥🔥🔥 — first Hard solved with a brand-new data structure taught the same day
- Self-recovery arc was the story of this problem: broken first draft → deflected validation request → correct final code with zero algorithmic help. The candidate habit to break: asking the interviewer "is this true?" mid-code instead of self-tracing on a small input.
- Teaching-style preference now firmly established (2 data points): concrete small example narrated step-by-step BEFORE any table/abstraction
- 🎉 **Day 5 complete!** Both problems done (Subarrays with K Distinct, Sliding Window Maximum). Next: Day 6 (review + re-solve struggles).

---

### Session #21 — July 19-20, 2026 — Sliding Window (Week 3, Day 6 — Review Day)
**Status**: ✅ COMPLETE

**Spaced Repetition Recall Results (5 problems — 2 Box 1 + 3 Box 2 due)**:
- Boats to Save People (LC #881): ✅ REAL recall test after Jul 18 cold forgetting — PASSED. Problem statement, sort + greedy pairing, left==right edge case all recalled unprompted. Complexity (O(n log n)/O(1)) only came out after 2 probes — skipped it twice. → **Promoted Box 1 → Box 2**
- Sliding Window Maximum (LC #239): ✅ First recall of Monotonic Deque — PASSED. Decreasing deque + back-eviction recalled unprompted; needed 3 probes for precision (indices-not-values, peekFirst-to-record vs pollFirst-on-expiry, amortized O(n) argument) — all answered correctly once probed. → **Promoted Box 1 → Box 2**
- Minimum Window Substring (LC #76): ✅ Textbook — need/window arrays, exact-`==`/about-to-break mechanics, and the flagged Jul 16 complexity gap fully CLEARED with a self-generated amortized argument ("two people on a one-way road, ≤2n steps; O(m·n) trap needs an inner loop that resets"). → **Promoted Box 2 → Box 3**
- Longest Repeating Character Replacement (LC #424): ✅ Excellent — never-shrink/only-slide mechanic and stale-maxFreq safety argument both fully self-synthesized, plus exact validity formula `windowSize - maxFreq <= k` with correct term definitions. → **Promoted Box 2 → Box 3**
- Fruit Into Baskets (LC #904): ✅ Correct pattern/approach/remove-at-zero reasoning. Minor notation nit: said space complexity "O(3)" instead of "O(1)" for a bounded-constant map size. → **Promoted Box 2 → Box 3**

**Recall Verdict: 5/5 recalled, zero demotions. Box 1 is now EMPTY for the first time this cycle.**

**Phase B — Timed Re-solves**:
- Sliding Window Maximum (LC #239, Hard, 40-min limit): 🟢 HIRE. Clean on the first attempt this time — no repeat of yesterday's broken first draft (poll-on-empty, inverted while). All 5 tests first try, zero bugs, zero hints, well under time. Complexity needed one nudge: said O(n) space, corrected to the tighter O(k) (deque never holds more than k elements regardless of array size, even when k==n).
- Subarrays with K Different Integers (LC #992, Medium, 25-min limit): 🟡 LEAN HIRE. All 5 driver tests passed on the FIRST attempt too — but the first attempt had a real bug: `right++` was moved before `ans += right-left+1`, which overcounts every `atMostKDistinct(nums, k)` call by exactly `nums.length`. This bug is invisible to the given tests because `exactly(k) = atMost(k) - atMost(k-1)` — both calls are inflated by the identical constant, which cancels out in the subtraction. Caught only because the interviewer asked for a direct hand-trace of `atMostKDistinct` in isolation (`assert atMostKDistinct(arr, 1) == 5`), not because a test failed. Self-corrected immediately once probed (moved the count line back above `right++`). Complexity: TC O(n) correct; SC said O(1), corrected to O(k) after a nudge (map bounded by k, not constant).

**Key Observations**:
- 🎉 **Box 1 emptied** — every problem currently in the system has been recalled successfully at least once past its most recent demotion/introduction.
- New struggle category identified (Subarrays with K Distinct re-solve): a bug that passes ALL given tests because of how the problem composes two calls to the same buggy helper — the errors cancel in the subtraction. This is a materially different failure mode from prior "tests catch it" bugs — the fix here required probing the helper in isolation, not just running the driver. **General interview lesson**: when a solution decomposes into `f(a) - f(b)` or similar composition, test the sub-function `f` directly, not just the composed result — composition can hide systematic bugs.
- Complexity articulation continues to need a nudge across multiple problems this session (Boats to Save People, Sliding Window Maximum's O(n)→O(k), Subarrays' O(1)→O(k)) — pattern: default instinct is a looser/safer bound; needs to actively check for the tighter one.
- 🎉 **WEEK 3 COMPLETE** (Day 6 review done). Day 7 (weekly challenge, 2 unseen sliding-window problems) remains.

---

### Session #22 — July 20-21, 2026 — Sliding Window (Week 3, Day 7 — 🔥 Weekly Challenge)
**Status**: ✅ COMPLETE — 🎉 **WEEK 3 COMPLETE**

**Spaced Repetition Recall Results (16 problems — 1 Box 2 + 5 Box 3 + 10 Box 4 due, first-ever Box 5 promotions)**:
All 16 recalled successfully, zero demotions. Full detail logged in `spaced_repetition/review_schedule.md` under "Today's Review Queue (Jul 20)". Highlights: Partition Labels' cut condition landed clean and unprompted this time (needed a probe on Jul 13); Trapping Rain Water's two-pointer bottleneck argument (`height[left] < height[right] ⟹ rightMax ≥ height[right] > height[left]`) self-derived precisely; Sort Colors' "why mid doesn't increment after a high-swap" self-derived precisely. 10 problems (Product Except Self, Longest Consecutive, Encode/Decode Strings, Valid Sudoku, Valid Palindrome, 3Sum, Contiguous Array, Sort Chars By Freq, Two Sum, Contains Duplicate) hit **Box 5 (mastered)** for the first time this cycle.

**Recall Verdict: 16/16, zero demotions. Box 5 populated for the first time (10 problems).**

**Problems Covered (both UNSEEN, cold, no concept teach)**:
- Subarray Product Less Than K (LC #713): ✅ NEW — 🟢 HIRE. Approach (incl. `k==0` early-return) stated correctly before coding. All 5 tests first try, zero bugs, zero hints. Correctly reasoned that a zero element would break the division-based shrink (product frozen at 0), though ruled out by constraints. One complexity notation nit ("space 0" → O(1)).
- Minimum Operations to Reduce X to Zero (LC #1658): ✅ NEW — 🟢 HIRE. The core insight — reframing prefix+suffix removal as "find the longest middle subarray summing to `total - x`" — was **fully self-derived, unprompted**, including the caveat that it breaks under negative numbers. All 5 tests first try, zero bugs. One good self-correction: initially proposed unnecessary explicit checks for `target < 0`/`target == 0` after a probe about sentinel safety, then hand-traced the actual code (unprompted-quality) and correctly concluded no special-casing was needed — window length is bounded at 0, never negative, so the `-1` sentinel can't collide with a real result.

**Key Observations**:
- **29-problem solved streak, 26 of those clean 🟢 HIRE** 🔥🔥🔥
- This week's real test — cold transfer to problems that don't scream "sliding window" — was passed cleanly. LC #1658 in particular required recognizing a non-obvious reframe with zero hints.
- New good habit: when challenged on a hunch (sentinel-collision question), default was to propose an unnecessary fix rather than first re-verifying against the actual code/trace — but self-corrected immediately once asked to trace it. Worth reinforcing: **check the real code/trace before assuming a fix is needed**, not just when told a bug exists.
- 🎉 **WEEK 3 COMPLETE** — all 12 new problems + weekly challenge done, avg confidence 5.0, zero LEAN HIRE or worse on any new problem this week.

---

### Session #23 — July 21, 2026 — Stack & Queue (Week 4, Day 1)
**Status**: ✅ COMPLETE

**Concept Teach**: Stack (LIFO push/pop/peek) taught with the "stack of plates" analogy first, then a small concrete trace ([3,7,2] → pop → push(9)) with a comprehension check (answered correctly: peek()==9). Then Min Stack's auxiliary-stack trick taught with a concrete push-by-push trace ([5],[5,3],[5,3,3]...) — comprehension check on what `minStack` looks like after pushing a 4th element (4): got the min value right (3) but initially gave a 3-element answer instead of 4 (missed that `minStack` must grow 1:1 with `main` on every push, not just when the min changes) — corrected on the spot. No re-teach needed, unlike Monotonic Deque's rocky first pass on Jul 18 — this concept landed on the first narrative-first pass.

**Problems Covered**:
- Valid Parentheses (LC #20): ✅ NEW — 🟢 HIRE. First stack problem. Approach stated correctly (stack + close→open map) before coding. All 6 tests first try, zero bugs, zero hints (all follow-ups were reasoning probes on already-passing code, not fixes). Used an unconventional but correct sentinel-stack design (push `'z'` at the bottom to avoid `isEmpty()` checks) — on mismatch, the code doesn't fail fast, it falls through and pushes the closing bracket; still correct because a wrongly-pushed closer can never be matched later (the map only maps closers→openers). Follow-ups: correctly explained why `'z'` is safe only because constraints guarantee a bracket-only alphabet; correctly identified the fail-fast improvement (return false immediately on a top-mismatch) when asked "can you do better?"
- Min Stack (LC #155): ✅ NEW — 🟢 HIRE. Auxiliary stack, applied the `>=` tie-handling rule from the concept walkthrough correctly and without prompting. All 5 tests first try, zero bugs, zero hints. Precise per-operation complexity (push O(1); space O(n), 2n worst case on strictly descending input). Follow-up (why not a single `minSoFar` variable): correctly explained the lost-history problem — once the element that set the current min is popped, a bare variable can't recover the prior min without a rescan.

**Key Observations**:
- **31-problem solved streak, 29 of those clean 🟢 HIRE** 🔥🔥🔥 — first day of a brand-new topic (Stack), both problems clean, zero re-teach needed on Min Stack (unlike Monotonic Deque's rocky first pass on Jul 18 — this concept landed first try)
- Notable non-fail-fast-but-still-correct design pattern surfaced on Valid Parentheses: pushing a "wrong" element that can structurally never be matched later is a valid (if unconventional) way to defer failure detection to the end — worth recognizing this shape again, though fail-fast is cleaner practice for a real interview
- 🎉 **Day 1 complete!** Both problems done (Valid Parentheses, Min Stack). Next: Day 2 — Evaluate RPN + Daily Temperatures (first Monotonic Stack problem, new concept).

---

### Session #24 — July 21-22, 2026 — Stack & Queue (Week 4, Day 2)
**Status**: 🔄 IN PROGRESS

**Spaced Repetition Recall Results (3 problems — 2 Box 1 + 1 Box 2 due)**:
- Subarray Product Less Than K (LC #713): ✅ Solid — variable window, product/=nums[left] while product>=k, count+=right-left+1. Probed k==1 edge case: correctly reasoned all nums[i]>=1 means product never <1, window logic naturally counts 0 without a special case. → **Promoted to Box 2**
- Minimum Operations to Reduce X to Zero (LC #1658): ✅ Solid — reframe, target<0→-1, re-derived why the -1 sentinel can't collide with a real window length. → **Promoted to Box 2**
- Subarrays with K Different Integers (LC #992): ✅ Exactly-K trick recalled well, but skipped the `atMostKDistinct` mechanics on first pass (same spot that caused last session's invisible bug) — needed a second, explicit ask. Once re-asked: correct order (add → repair-while-shrink → count) and corrected space to the tight O(k), not O(n). → **Promoted to Box 3**

**Recall Verdict: 3/3 recalled, zero demotions. One (992) needed a second explicit probe on mechanics — watch this spot again next recall.**

**Concept Teach**: Monotonic Stack — led with concrete example first (per established preference): stack of decreasing temps `[73,71,68]`, new value `76` pops everything (all found their warmer day), vs `70` which just gets pushed. User initially misread stack orientation (thought bottom-to-top was increasing, i.e., 68 at bottom) — quick correction (top = most recently pushed = closest to "today") resolved it immediately, not a logic gap.

**Problems Covered**:
- Evaluate Reverse Polish Notation (LC #150): ✅ NEW — 🟢 HIRE. Used try/catch on `Integer.parseInt` to distinguish operand vs operator (unconventional, correct). All 5 tests first try, zero bugs, zero hints. Follow-ups: agreed broad `Exception` catch is bad practice (swallows unrelated exceptions) and proposed direct `str.equals(op)` check instead; correctly derived tight worst-case stack depth `(n+1)/2` (n=2k+1 for k operators) while confirming Big-O still reports O(n) since constants drop out.
- Daily Temperatures (LC #739): ✅ NEW — 🟢 HIRE. First Monotonic Stack problem. Approach (decreasing stack of indices, pop-and-resolve on a warmer day) stated correctly before coding. All 5 tests first try, zero bugs, zero hints. Code had a redundant `if/else` split duplicating what the `while` loop's own condition already handles — self-identified the instant it was pointed out ("added for debugging, will remove"). Clean amortized O(n) reasoning (each index pushed once, popped at most once).

**Key Observations**:
- **33-problem solved streak, 31 of those clean 🟢 HIRE** 🔥
- Complexity reasoning continues to sharpen: three clean self-derived tight-bound/amortized arguments this session (k==1 edge case, RPN stack depth n/2, Daily Temp amortized O(n))
- Monotonic Stack concept landed after one orientation correction during the teach, then transferred cleanly to the actual problem — same "evict what can never win" idea as Week 3's Monotonic Deque, confirmed working
- 🎉 **Day 2 complete!** Both problems done (Evaluate RPN, Daily Temperatures). Next: Day 3 per master plan.

---

### Session #25 — July 23, 2026 — Stack & Queue (Week 4, Day 3)
**Status**: 🔄 IN PROGRESS

**Spaced Repetition Recall Results (4 problems — 2 Box 1 + 2 Box 2 due Jul 22)**:
- Valid Parentheses (LC #20): ✅ Pattern + mechanic correct (push openers, on closer match-top-then-pop else false). Reminder given on the final `isEmpty()` check for leftover openers. TC O(n)/SC O(n). → **Promoted to Box 2**
- Min Stack (LC #155): ✅ Two-stack approach correct, 1:1 growth on push. Complexity slip: said TC O(n), corrected to O(1) per operation. → **Promoted to Box 2**
- Boats to Save People (LC #881): ✅ Full recall — sort + two pointers from ends, pair lightest+heaviest if fits else heaviest alone, count++ each iter. Stuck this time (vs Jul 18 cold forget). Complexity slip: said O(n), self-corrected to O(n log n) on one nudge. → **Promoted to Box 3**
- Sliding Window Maximum (LC #239): ✅ Textbook — decreasing deque of indices, back-evict smaller, front-evict on expiry, front is max O(1). Nailed tight O(k) space unprompted (needed nudges for this on Jul 19). → **Promoted to Box 3**

**Recall Verdict: 4/4 recalled. Two complexity slips (Min Stack O(1), Boats O(n log n)) self-corrected on one nudge each — same "defaults to loose bound" pattern still worth watching, but recovery instant.**

**Problems Covered**:
- Next Greater Element I (LC #496): ✅ NEW — 🟢 HIRE. First stack+HashMap combo. Approach + complexity (O(n1+n2)/O(n2)) stated precisely before coding. All 5 tests first try, zero bugs, zero hints. Used `getOrDefault(..., -1)`. Follow-ups both nailed: (1) `java.util.Stack` legacy/synchronized vs `ArrayDeque` (knowingly used Stack for brevity); (2) identified that the value-keyed map only works because nums2 is distinct — with duplicates, `nextGreater.put(stack.pop(), num)` breaks (fix: key by index).
- Largest Rectangle in Histogram (LC #84): ✅ NEW HARD — 🟢 HIRE. Concept taught same session (increasing stack of indices, pop-and-resolve, `width = i - peek - 1`, dual sentinels). Absorbed the concept fast (answered both teach comprehension checks). All 6 tests first try, zero bugs, zero hints. Immediately applied the `ArrayDeque` feedback from 20 min earlier. Used both sentinels + `peek != -1` guard. Follow-ups: O(n) amortized clean; correctly explained why unresolved equal bars still capture the widest rectangle; MISSED the sentinel-value "why" (said "1"; correct is -1 since min height is 0 — counterexample [1,1,1]) — code was right, verbal justification faltered.

**Key Observations**:
- **35-problem solved streak, 33 clean 🟢 HIRE** 🔥 — two Hards this arc (SWM, Largest Rectangle) both solved flawlessly with same-session concepts.
- Monotonic Stack pattern transfer from Daily Temperatures (Jul 22) → Next Greater Element I was instant — no re-teach, approach stated cold. Then extended to the boundary/max-area flavor (Largest Rectangle) with a concept teach that landed on the first narrative-first pass.
- Complexity-defaults-to-loose-bound habit resurfaced in recall (Min Stack, Boats) but both self-corrected on a single nudge — trending toward resolved.
- **Code-fluency-ahead-of-why gap resurfaced** on the Largest Rectangle sentinel-value probe: wrote the correct `-1` sentinel but couldn't justify WHY -1 (vs 0/1) when pressed. Same shape as LRCR (Jul 14) and Remove Duplicates (Jul 18). Re-probe the "why -1" at spaced-rep recall.
- 🎉 **Day 3 complete!** Both problems 🟢 HIRE. Next: Day 4 — Car Fleet (LC #853) + Implement Queue using Stacks (LC #232).

---

## ⏭️ Next Session Plan

**Next**: Session #26 — Week 4, Day 4 (Car Fleet LC #853 + Implement Queue using Stacks LC #232)
**Focus**:
- **Re-probe the "why -1 sentinel" on Largest Rectangle** at recall — code was right, verbal justification faltered (code-ahead-of-why gap, 3rd instance).
- Watch Subarrays with K Different Integers (992) mechanics recall again next cycle — needed a second explicit probe (Jul 21).
- Complexity-defaults-to-loose-bound still surfacing in recall (Min Stack, Boats on Jul 22) — self-corrected on one nudge each; keep an eye on it.
- Car Fleet needs a sort + stack/monotonic idea (sort by position, merge by arrival time); Implement Queue using Stacks needs the two-stack amortized-O(1) lazy-transfer concept teach.
- Spaced repetition due Jul 24: Next Greater Element I, Largest Rectangle in Histogram (Box 1); Subarray Product Less Than K, Minimum Operations to Reduce X to Zero (Box 2); Min Size Subarray Sum, Permutation in String (Box 3).

---

## 📈 Weekly Progress Summary

| Week | Problems Solved | New Patterns | Avg Confidence | Key Achievement |
|------|----------------|-------------|----------------|-----------------|
| W1 | 13 | 11 | 4.7 | 🎉 Arrays & Hashing COMPLETE. 10/13 HIRE. 2 unseen challenges solved. Bucket sort + Prefix Sum patterns mastered. |
| W2 | 11 + 2 re-solves | 11 | 4.8 | 🎉 Two Pointers & Sorting COMPLETE. 10/11 🟢 HIRE. D6: re-solves crushed (3Sum 20→5 min, Contiguous Array 45→6 min). D7: 2 unseen challenges solved. Key lesson: Math.abs() for distance comparisons. |
| W3 | 12 + 2 re-solves | 12 | 5.0 | 🎉 Sliding Window COMPLETE. Fixed, Variable (Longest/Shortest), Fixed+Freq Match, Need/Formed Counter (Hard), Max Frequency, At-Most-K-Distinct, Zero Count, Exactly-K Trick, Monotonic Deque (Hard), Count-Subarrays, Reframe-as-Window. All 12 new problems 🟢 HIRE (zero LEAN HIRE or worse). D6: Box 1 emptied, re-solves (1 HIRE, 1 LEAN HIRE — test-invisible composition bug found). D7: 2 unseen weekly-challenge problems, both clean HIRE, cold pattern transfer including a non-obvious reframe. First-ever Box 5 (mastered) promotions — 10 problems. |
| W4 | 6 so far | 6 | 5.0 | Stack & Queue in progress. D1: Valid Parentheses + Min Stack. D2: Evaluate RPN + Daily Temperatures (first Monotonic Stack). D3: Next Greater Element I + Largest Rectangle in Histogram (Hard, same-session concept). All 6 🟢 HIRE. |
| W5 | — | — | — | — |
| W6 | — | — | — | — |
| W7 | — | — | — | — |
| W8 | — | — | — | — |
| W9 | — | — | — | — |
| W10 | — | — | — | — |
| W11 | — | — | — | — |
| W12 | — | — | — | — |
| W13 | — | — | — | — |
| W14 | — | — | — | — |
| W15 | — | — | — | — |
| W16 | — | — | — | — |
| W17 | — | — | — | — |
| W18 | — | — | — | — |
