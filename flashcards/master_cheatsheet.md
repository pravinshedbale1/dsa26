# 📋 Master Cheatsheet — One Line Per Problem

| Problem | Pattern | Core Trick | Time / Space |
|---|---|---|---|
| Two Sum (LC #1) | HashMap Complement | Check `target - x` in map **before** `put(x, i)` | O(n) / O(n) |
| Contains Duplicate (LC #217) | HashSet Membership | `if (!set.add(x)) return true`; bounded range → `boolean[]` | O(n) / O(n) |
