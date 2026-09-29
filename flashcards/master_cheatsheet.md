# 📋 Master Cheatsheet — One Line Per Problem

| Problem | Pattern | Core Trick | Time / Space |
|---|---|---|---|
| Two Sum (LC #1) | HashMap Complement | Check `target - x` in map **before** `put(x, i)` | O(n) / O(n) |
| Contains Duplicate (LC #217) | HashSet Membership | `if (!set.add(x)) return true`; bounded range → `boolean[]` | O(n) / O(n) |
| Valid Anagram (LC #242) | Frequency Count | Length check first, `int[26]` +1 for s, −1 for t, fail when a count would go below 0 | O(n) / O(1) |
| Find All Duplicates (LC #442) | Index Marking | `v=abs(nums[i])`; if `nums[v-1] < 0` → v is a dup, else negate it | O(n) / O(1) |
